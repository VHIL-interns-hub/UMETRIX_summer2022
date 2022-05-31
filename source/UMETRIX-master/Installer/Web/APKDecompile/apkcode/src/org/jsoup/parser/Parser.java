package org.jsoup.parser;

import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class Parser
{
  private TreeBuilder a;
  private int b = 0;
  private ParseErrorList c;
  
  public Parser(TreeBuilder paramTreeBuilder)
  {
    this.a = paramTreeBuilder;
  }
  
  public static List a(String paramString1, Element paramElement, String paramString2)
  {
    return new HtmlTreeBuilder().a(paramString1, paramElement, paramString2, ParseErrorList.b());
  }
  
  public static Document b(String paramString1, String paramString2)
  {
    Document localDocument = Document.a(paramString2);
    Element localElement = localDocument.b();
    paramString1 = a(paramString1, localElement, paramString2);
    paramString1 = (Node[])paramString1.toArray(new Node[paramString1.size()]);
    int i = paramString1.length - 1;
    while (i > 0)
    {
      paramString1[i].E();
      i -= 1;
    }
    int j = paramString1.length;
    i = 0;
    while (i < j)
    {
      localElement.a(paramString1[i]);
      i += 1;
    }
    return localDocument;
  }
  
  public static Parser b()
  {
    return new Parser(new HtmlTreeBuilder());
  }
  
  public Document a(String paramString1, String paramString2)
  {
    if (a()) {}
    for (ParseErrorList localParseErrorList = ParseErrorList.a(this.b);; localParseErrorList = ParseErrorList.b())
    {
      this.c = localParseErrorList;
      return this.a.a(paramString1, paramString2, this.c);
    }
  }
  
  public boolean a()
  {
    return this.b > 0;
  }
}
