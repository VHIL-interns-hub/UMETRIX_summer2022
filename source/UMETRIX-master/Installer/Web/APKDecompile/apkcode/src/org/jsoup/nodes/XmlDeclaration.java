package org.jsoup.nodes;

public class XmlDeclaration
  extends Node
{
  private final boolean f;
  
  public String a()
  {
    return "#declaration";
  }
  
  void a(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    paramOutputSettings = paramStringBuilder.append("<");
    if (this.f) {}
    for (paramStringBuilder = "!";; paramStringBuilder = "?")
    {
      paramOutputSettings.append(paramStringBuilder).append(b()).append(">");
      return;
    }
  }
  
  public String b()
  {
    Object localObject = this.c.a("declaration");
    if ((((String)localObject).equals("xml")) && (this.c.a() > 1))
    {
      localObject = new StringBuilder((String)localObject);
      String str = this.c.a("version");
      if (str != null) {
        ((StringBuilder)localObject).append(" version=\"").append(str).append("\"");
      }
      str = this.c.a("encoding");
      if (str != null) {
        ((StringBuilder)localObject).append(" encoding=\"").append(str).append("\"");
      }
      return ((StringBuilder)localObject).toString();
    }
    return this.c.a("declaration");
  }
  
  void b(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
  
  public String toString()
  {
    return c();
  }
}
