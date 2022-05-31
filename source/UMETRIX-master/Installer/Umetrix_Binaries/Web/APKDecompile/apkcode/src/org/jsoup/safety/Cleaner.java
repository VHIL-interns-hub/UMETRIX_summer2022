package org.jsoup.safety;

import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.NodeTraversor;

public class Cleaner
{
  private Whitelist a;
  
  public Cleaner(Whitelist paramWhitelist)
  {
    Validate.a(paramWhitelist);
    this.a = paramWhitelist;
  }
  
  private int a(Element paramElement1, Element paramElement2)
  {
    paramElement2 = new Cleaner.CleaningVisitor(this, paramElement1, paramElement2, null);
    new NodeTraversor(paramElement2).a(paramElement1);
    return Cleaner.CleaningVisitor.a(paramElement2);
  }
  
  private Cleaner.ElementMeta a(Element paramElement)
  {
    String str = paramElement.i();
    Attributes localAttributes = new Attributes();
    Element localElement = new Element(Tag.a(str), paramElement.z(), localAttributes);
    Iterator localIterator = paramElement.y().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Attribute localAttribute = (Attribute)localIterator.next();
      if (this.a.a(str, paramElement, localAttribute)) {
        localAttributes.a(localAttribute);
      }
      for (;;)
      {
        break;
        i += 1;
      }
    }
    localAttributes.a(this.a.b(str));
    return new Cleaner.ElementMeta(localElement, i);
  }
  
  public Document a(Document paramDocument)
  {
    Validate.a(paramDocument);
    Document localDocument = Document.a(paramDocument.z());
    if (paramDocument.b() != null) {
      a(paramDocument.b(), localDocument.b());
    }
    return localDocument;
  }
}
