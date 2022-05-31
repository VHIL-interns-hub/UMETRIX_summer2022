package org.jsoup.nodes;

import java.util.Arrays;
import java.util.Map.Entry;
import org.jsoup.helper.Validate;

public class Attribute
  implements Cloneable, Map.Entry
{
  private static final String[] a = { "allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch" };
  private String b;
  private String c;
  
  public Attribute(String paramString1, String paramString2)
  {
    Validate.a(paramString1);
    Validate.a(paramString2);
    this.b = paramString1.trim().toLowerCase();
    this.c = paramString2;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String a(String paramString)
  {
    Validate.a(paramString);
    String str = this.c;
    this.c = paramString;
    return str;
  }
  
  protected void a(StringBuilder paramStringBuilder, Document.OutputSettings paramOutputSettings)
  {
    paramStringBuilder.append(this.b);
    if (!a(paramOutputSettings))
    {
      paramStringBuilder.append("=\"");
      Entities.a(paramStringBuilder, this.c, paramOutputSettings, true, false, false);
      paramStringBuilder.append('"');
    }
  }
  
  protected final boolean a(Document.OutputSettings paramOutputSettings)
  {
    return (("".equals(this.c)) || (this.c.equalsIgnoreCase(this.b))) && (paramOutputSettings.c() == Document.OutputSettings.Syntax.a) && (d());
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, new Document("").e());
    return localStringBuilder.toString();
  }
  
  protected boolean d()
  {
    return Arrays.binarySearch(a, this.b) >= 0;
  }
  
  public Attribute e()
  {
    try
    {
      Attribute localAttribute = (Attribute)super.clone();
      return localAttribute;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Attribute)) {
        return false;
      }
      paramObject = (Attribute)paramObject;
      if (this.b != null)
      {
        if (this.b.equals(paramObject.b)) {}
      }
      else {
        while (paramObject.b != null) {
          return false;
        }
      }
      if (this.c == null) {
        break;
      }
    } while (this.c.equals(paramObject.c));
    while (paramObject.c != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.b != null) {}
    for (int i = this.b.hashCode();; i = 0)
    {
      if (this.c != null) {
        j = this.c.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public String toString()
  {
    return c();
  }
}
