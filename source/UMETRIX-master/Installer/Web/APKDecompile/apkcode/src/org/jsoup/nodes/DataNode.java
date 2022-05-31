package org.jsoup.nodes;

public class DataNode
  extends Node
{
  public DataNode(String paramString1, String paramString2)
  {
    super(paramString2);
    this.c.a("data", paramString1);
  }
  
  public String a()
  {
    return "#data";
  }
  
  void a(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    paramStringBuilder.append(b());
  }
  
  public String b()
  {
    return this.c.a("data");
  }
  
  void b(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
  
  public String toString()
  {
    return c();
  }
}
