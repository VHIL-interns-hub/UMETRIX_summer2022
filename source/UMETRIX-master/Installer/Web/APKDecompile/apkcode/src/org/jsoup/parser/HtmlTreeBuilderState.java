package org.jsoup.parser;

import org.jsoup.helper.StringUtil;

 enum HtmlTreeBuilderState
{
  private static String x = String.valueOf('\000');
  
  private static boolean b(String paramString)
  {
    int i1 = 0;
    while (i1 < paramString.length())
    {
      if (!StringUtil.b(paramString.charAt(i1))) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private static boolean b(Token paramToken)
  {
    if (paramToken.k()) {
      return b(paramToken.l().n());
    }
    return false;
  }
  
  private static void c(Token.StartTag paramStartTag, HtmlTreeBuilder paramHtmlTreeBuilder)
  {
    paramHtmlTreeBuilder.a(paramStartTag);
    paramHtmlTreeBuilder.d.a(TokeniserState.c);
    paramHtmlTreeBuilder.b();
    paramHtmlTreeBuilder.a(h);
  }
  
  private static void d(Token.StartTag paramStartTag, HtmlTreeBuilder paramHtmlTreeBuilder)
  {
    paramHtmlTreeBuilder.a(paramStartTag);
    paramHtmlTreeBuilder.d.a(TokeniserState.e);
    paramHtmlTreeBuilder.b();
    paramHtmlTreeBuilder.a(h);
  }
  
  abstract boolean a(Token paramToken, HtmlTreeBuilder paramHtmlTreeBuilder);
}
