package org.jsoup.nodes;

import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class FormElement
  extends Element
{
  private final Elements f = new Elements();
  
  public FormElement(Tag paramTag, String paramString, Attributes paramAttributes)
  {
    super(paramTag, paramString, paramAttributes);
  }
  
  public FormElement b(Element paramElement)
  {
    this.f.add(paramElement);
    return this;
  }
}
