package org.jsoup.nodes;

public class BooleanAttribute
  extends Attribute
{
  public BooleanAttribute(String paramString)
  {
    super(paramString, "");
  }
  
  protected boolean d()
  {
    return true;
  }
}
