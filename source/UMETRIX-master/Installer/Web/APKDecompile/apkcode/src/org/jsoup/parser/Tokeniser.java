package org.jsoup.parser;

import java.util.Arrays;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;

final class Tokeniser
{
  private static final char[] h = { 9, 10, 13, 12, 32, 60, 38 };
  StringBuilder a = new StringBuilder(1024);
  Token.Tag b;
  Token.StartTag c = new Token.StartTag();
  Token.EndTag d = new Token.EndTag();
  Token.Character e = new Token.Character();
  Token.Doctype f = new Token.Doctype();
  Token.Comment g = new Token.Comment();
  private CharacterReader i;
  private ParseErrorList j;
  private TokeniserState k = TokeniserState.a;
  private Token l;
  private boolean m = false;
  private String n = null;
  private StringBuilder o = new StringBuilder(1024);
  private String p;
  private boolean q = true;
  private final char[] r = new char[1];
  
  static
  {
    Arrays.sort(h);
  }
  
  Tokeniser(CharacterReader paramCharacterReader, ParseErrorList paramParseErrorList)
  {
    this.i = paramCharacterReader;
    this.j = paramParseErrorList;
  }
  
  private void b(String paramString)
  {
    if (this.j.a()) {
      this.j.add(new ParseError(this.i.a(), "Invalid character reference: %s", new Object[] { paramString }));
    }
  }
  
  private void c(String paramString)
  {
    if (this.j.a()) {
      this.j.add(new ParseError(this.i.a(), paramString));
    }
  }
  
  Token.Tag a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Token.Tag localTag = this.c.n();; localTag = this.d.n())
    {
      this.b = localTag;
      return this.b;
    }
  }
  
  Token a()
  {
    if (!this.q)
    {
      c("Self closing flag not acknowledged");
      this.q = true;
    }
    while (!this.m) {
      this.k.a(this, this.i);
    }
    Object localObject;
    if (this.o.length() > 0)
    {
      localObject = this.o.toString();
      this.o.delete(0, this.o.length());
      this.n = null;
      return this.e.a((String)localObject);
    }
    if (this.n != null)
    {
      localObject = this.e.a(this.n);
      this.n = null;
      return localObject;
    }
    this.m = false;
    return this.l;
  }
  
  void a(char paramChar)
  {
    a(String.valueOf(paramChar));
  }
  
  void a(String paramString)
  {
    if (this.n == null)
    {
      this.n = paramString;
      return;
    }
    if (this.o.length() == 0) {
      this.o.append(this.n);
    }
    this.o.append(paramString);
  }
  
  void a(Token paramToken)
  {
    Validate.b(this.m, "There is an unread token pending!");
    this.l = paramToken;
    this.m = true;
    if (paramToken.a == Token.TokenType.b)
    {
      paramToken = (Token.StartTag)paramToken;
      this.p = paramToken.b;
      if (paramToken.c) {
        this.q = false;
      }
    }
    while ((paramToken.a != Token.TokenType.c) || (((Token.EndTag)paramToken).d == null)) {
      return;
    }
    c("Attributes incorrectly present on end tag");
  }
  
  void a(TokeniserState paramTokeniserState)
  {
    this.k = paramTokeniserState;
  }
  
  void a(char[] paramArrayOfChar)
  {
    a(String.valueOf(paramArrayOfChar));
  }
  
  char[] a(Character paramCharacter, boolean paramBoolean)
  {
    if (this.i.b()) {
      return null;
    }
    if ((paramCharacter != null) && (paramCharacter.charValue() == this.i.c())) {
      return null;
    }
    if (this.i.d(h)) {
      return null;
    }
    char[] arrayOfChar = this.r;
    this.i.g();
    if (this.i.d("#"))
    {
      paramBoolean = this.i.e("X");
      if (paramBoolean) {}
      for (paramCharacter = this.i.n(); paramCharacter.length() == 0; paramCharacter = this.i.o())
      {
        b("numeric reference with no numerals");
        this.i.h();
        return null;
      }
      if (!this.i.d(";")) {
        b("missing semicolon");
      }
      if (paramBoolean) {
        i1 = 16;
      }
      try
      {
        for (;;)
        {
          i1 = Integer.valueOf(paramCharacter, i1).intValue();
          if ((i1 != -1) && ((i1 < 55296) || (i1 > 57343)) && (i1 <= 1114111)) {
            break;
          }
          b("character outside of valid range");
          arrayOfChar[0] = 65533;
          return arrayOfChar;
          i1 = 10;
        }
      }
      catch (NumberFormatException paramCharacter)
      {
        for (;;)
        {
          i1 = -1;
        }
        if (i1 < 65536)
        {
          arrayOfChar[0] = ((char)i1);
          return arrayOfChar;
        }
        return Character.toChars(i1);
      }
    }
    paramCharacter = this.i.m();
    boolean bool = this.i.c(';');
    if ((Entities.b(paramCharacter)) || ((Entities.a(paramCharacter)) && (bool))) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      this.i.h();
      if (bool) {
        b(String.format("invalid named referenece '%s'", new Object[] { paramCharacter }));
      }
      return null;
    }
    if (paramBoolean) {
      if ((!this.i.p()) && (!this.i.q()))
      {
        if (!this.i.c(new char[] { 61, 45, 95 })) {}
      }
      else
      {
        this.i.h();
        return null;
      }
    }
    if (!this.i.d(";")) {
      b("missing semicolon");
    }
    arrayOfChar[0] = Entities.c(paramCharacter).charValue();
    return arrayOfChar;
  }
  
  void b()
  {
    this.q = true;
  }
  
  void b(TokeniserState paramTokeniserState)
  {
    this.i.f();
    this.k = paramTokeniserState;
  }
  
  void c()
  {
    this.b.p();
    a(this.b);
  }
  
  void c(TokeniserState paramTokeniserState)
  {
    if (this.j.a()) {
      this.j.add(new ParseError(this.i.a(), "Unexpected character '%s' in input state [%s]", new Object[] { Character.valueOf(this.i.c()), paramTokeniserState }));
    }
  }
  
  void d()
  {
    this.g.b();
  }
  
  void d(TokeniserState paramTokeniserState)
  {
    if (this.j.a()) {
      this.j.add(new ParseError(this.i.a(), "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[] { paramTokeniserState }));
    }
  }
  
  void e()
  {
    a(this.g);
  }
  
  void f()
  {
    this.f.b();
  }
  
  void g()
  {
    a(this.f);
  }
  
  void h()
  {
    Token.a(this.a);
  }
  
  boolean i()
  {
    return (this.p != null) && (this.b.b.equals(this.p));
  }
  
  String j()
  {
    if (this.p == null) {
      return null;
    }
    return this.p;
  }
}
