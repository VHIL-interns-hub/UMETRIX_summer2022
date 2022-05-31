package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;

public class DocumentType
  extends Node
{
  public DocumentType(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString4);
    b("name", paramString1);
    b("publicId", paramString2);
    b("systemId", paramString3);
  }
  
  private boolean a(String paramString)
  {
    return !StringUtil.a(f(paramString));
  }
  
  public String a()
  {
    return "#doctype";
  }
  
  void a(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    if ((paramOutputSettings.c() == Document.OutputSettings.Syntax.a) && (!a("publicId")) && (!a("systemId"))) {
      paramStringBuilder.append("<!doctype");
    }
    for (;;)
    {
      if (a("name")) {
        paramStringBuilder.append(" ").append(f("name"));
      }
      if (a("publicId")) {
        paramStringBuilder.append(" PUBLIC \"").append(f("publicId")).append('"');
      }
      if (a("systemId")) {
        paramStringBuilder.append(" \"").append(f("systemId")).append('"');
      }
      paramStringBuilder.append('>');
      return;
      paramStringBuilder.append("<!DOCTYPE");
    }
  }
  
  void b(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
}
