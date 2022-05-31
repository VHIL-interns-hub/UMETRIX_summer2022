package org.jsoup.nodes;

import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.parser.Tag;

public class TextNode
  extends Node
{
  String f;
  
  public TextNode(String paramString1, String paramString2)
  {
    this.d = paramString2;
    this.f = paramString1;
  }
  
  static boolean b(StringBuilder paramStringBuilder)
  {
    return (paramStringBuilder.length() != 0) && (paramStringBuilder.charAt(paramStringBuilder.length() - 1) == ' ');
  }
  
  private void e()
  {
    if (this.c == null)
    {
      this.c = new Attributes();
      this.c.a("text", this.f);
    }
  }
  
  public String a()
  {
    return "#text";
  }
  
  void a(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    if ((paramOutputSettings.d()) && (((I() == 0) && ((this.a instanceof Element)) && (((Element)this.a).j().c()) && (!d())) || ((paramOutputSettings.e()) && (G().size() > 0) && (!d())))) {
      c(paramStringBuilder, paramInt, paramOutputSettings);
    }
    if ((paramOutputSettings.d()) && ((x() instanceof Element)) && (!Element.c(x()))) {}
    for (boolean bool = true;; bool = false)
    {
      Entities.a(paramStringBuilder, b(), paramOutputSettings, false, bool, false);
      return;
    }
  }
  
  public String b()
  {
    if (this.c == null) {
      return this.f;
    }
    return this.c.a("text");
  }
  
  public Node b(String paramString1, String paramString2)
  {
    e();
    return super.b(paramString1, paramString2);
  }
  
  void b(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
  
  public boolean d()
  {
    return StringUtil.a(b());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (TextNode)paramObject;
      if (this.f == null) {
        break;
      }
    } while (this.f.equals(paramObject.f));
    while (paramObject.f != null) {
      return false;
    }
    return true;
  }
  
  public String f(String paramString)
  {
    e();
    return super.f(paramString);
  }
  
  public boolean g(String paramString)
  {
    e();
    return super.g(paramString);
  }
  
  public int hashCode()
  {
    int j = super.hashCode();
    if (this.f != null) {}
    for (int i = this.f.hashCode();; i = 0) {
      return i + j * 31;
    }
  }
  
  public String i(String paramString)
  {
    e();
    return super.i(paramString);
  }
  
  public String toString()
  {
    return c();
  }
  
  public Attributes y()
  {
    e();
    return super.y();
  }
}
