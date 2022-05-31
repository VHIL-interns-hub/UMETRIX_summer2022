package org.jsoup.nodes;

public class Comment
  extends Node
{
  public Comment(String paramString1, String paramString2)
  {
    super(paramString2);
    this.c.a("comment", paramString1);
  }
  
  public String a()
  {
    return "#comment";
  }
  
  void a(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    if (paramOutputSettings.d()) {
      c(paramStringBuilder, paramInt, paramOutputSettings);
    }
    paramStringBuilder.append("<!--").append(b()).append("-->");
  }
  
  public String b()
  {
    return this.c.a("comment");
  }
  
  void b(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
  
  public String toString()
  {
    return c();
  }
}
