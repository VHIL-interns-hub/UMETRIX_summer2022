package org.jsoup.parser;

abstract class Token
{
  Token.TokenType a;
  
  private Token() {}
  
  static void a(StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder != null) {
      paramStringBuilder.delete(0, paramStringBuilder.length());
    }
  }
  
  String a()
  {
    return getClass().getSimpleName();
  }
  
  abstract Token b();
  
  final boolean c()
  {
    return this.a == Token.TokenType.a;
  }
  
  final Token.Doctype d()
  {
    return (Token.Doctype)this;
  }
  
  final boolean e()
  {
    return this.a == Token.TokenType.b;
  }
  
  final Token.StartTag f()
  {
    return (Token.StartTag)this;
  }
  
  final boolean g()
  {
    return this.a == Token.TokenType.c;
  }
  
  final Token.EndTag h()
  {
    return (Token.EndTag)this;
  }
  
  final boolean i()
  {
    return this.a == Token.TokenType.d;
  }
  
  final Token.Comment j()
  {
    return (Token.Comment)this;
  }
  
  final boolean k()
  {
    return this.a == Token.TokenType.e;
  }
  
  final Token.Character l()
  {
    return (Token.Character)this;
  }
  
  final boolean m()
  {
    return this.a == Token.TokenType.f;
  }
}
