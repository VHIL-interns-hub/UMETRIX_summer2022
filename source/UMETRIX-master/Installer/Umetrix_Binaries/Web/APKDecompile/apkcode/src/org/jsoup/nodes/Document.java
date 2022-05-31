package org.jsoup.nodes;

import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;

public class Document
  extends Element
{
  private Document.OutputSettings f = new Document.OutputSettings();
  private Document.QuirksMode g = Document.QuirksMode.a;
  private String h;
  private boolean i = false;
  
  public Document(String paramString)
  {
    super(Tag.a("#root"), paramString);
    this.h = paramString;
  }
  
  public static Document a(String paramString)
  {
    Validate.a(paramString);
    paramString = new Document(paramString);
    Element localElement = paramString.c("html");
    localElement.c("head");
    localElement.c("body");
    return paramString;
  }
  
  private Element a(String paramString, Node paramNode)
  {
    if (paramNode.a().equals(paramString)) {
      return (Element)paramNode;
    }
    paramNode = paramNode.b.iterator();
    while (paramNode.hasNext())
    {
      Element localElement = a(paramString, (Node)paramNode.next());
      if (localElement != null) {
        return localElement;
      }
    }
    return null;
  }
  
  public String a()
  {
    return "#document";
  }
  
  public Document a(Document.QuirksMode paramQuirksMode)
  {
    this.g = paramQuirksMode;
    return this;
  }
  
  public Element b()
  {
    return a("body", this);
  }
  
  public String c()
  {
    return super.w();
  }
  
  public Document d()
  {
    Document localDocument = (Document)super.g();
    localDocument.f = this.f.g();
    return localDocument;
  }
  
  public Document.OutputSettings e()
  {
    return this.f;
  }
  
  public Document.QuirksMode f()
  {
    return this.g;
  }
}
