package org.jsoup.parser;

public class ParseError
{
  private int a;
  private String b;
  
  ParseError(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  ParseError(int paramInt, String paramString, Object... paramVarArgs)
  {
    this.b = String.format(paramString, paramVarArgs);
    this.a = paramInt;
  }
  
  public String toString()
  {
    return this.a + ": " + this.b;
  }
}
