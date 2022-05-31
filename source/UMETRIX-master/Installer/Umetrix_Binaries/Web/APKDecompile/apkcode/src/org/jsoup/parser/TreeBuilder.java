package org.jsoup.parser;

import java.util.ArrayList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

abstract class TreeBuilder
{
  private Token.StartTag a = new Token.StartTag();
  private Token.EndTag b = new Token.EndTag();
  CharacterReader c;
  Tokeniser d;
  protected Document e;
  protected ArrayList f;
  protected String g;
  protected Token h;
  protected ParseErrorList i;
  
  TreeBuilder() {}
  
  Document a(String paramString1, String paramString2, ParseErrorList paramParseErrorList)
  {
    b(paramString1, paramString2, paramParseErrorList);
    y();
    return this.e;
  }
  
  public boolean a(String paramString, Attributes paramAttributes)
  {
    if (this.h == this.a) {
      return a(new Token.StartTag().a(paramString, paramAttributes));
    }
    this.a.n();
    this.a.a(paramString, paramAttributes);
    return a(this.a);
  }
  
  protected abstract boolean a(Token paramToken);
  
  protected void b(String paramString1, String paramString2, ParseErrorList paramParseErrorList)
  {
    Validate.a(paramString1, "String input must not be null");
    Validate.a(paramString2, "BaseURI must not be null");
    this.e = new Document(paramString2);
    this.c = new CharacterReader(paramString1);
    this.i = paramParseErrorList;
    this.d = new Tokeniser(this.c, paramParseErrorList);
    this.f = new ArrayList(32);
    this.g = paramString2;
  }
  
  protected boolean l(String paramString)
  {
    if (this.h == this.a) {
      return a(new Token.StartTag().a(paramString));
    }
    return a(this.a.n().a(paramString));
  }
  
  protected boolean m(String paramString)
  {
    if (this.h == this.b) {
      return a(new Token.EndTag().a(paramString));
    }
    return a(this.b.n().a(paramString));
  }
  
  protected void y()
  {
    Token localToken;
    do
    {
      localToken = this.d.a();
      a(localToken);
      localToken.b();
    } while (localToken.a != Token.TokenType.f);
  }
  
  protected Element z()
  {
    int j = this.f.size();
    if (j > 0) {
      return (Element)this.f.get(j - 1);
    }
    return null;
  }
}
