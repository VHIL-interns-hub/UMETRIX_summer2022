package org.jsoup.parser;

import java.util.ArrayList;

class ParseErrorList
  extends ArrayList
{
  private final int a;
  
  ParseErrorList(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    this.a = paramInt2;
  }
  
  static ParseErrorList a(int paramInt)
  {
    return new ParseErrorList(16, paramInt);
  }
  
  static ParseErrorList b()
  {
    return new ParseErrorList(0, 0);
  }
  
  boolean a()
  {
    return size() < this.a;
  }
}
