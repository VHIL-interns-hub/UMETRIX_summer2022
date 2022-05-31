package org.jsoup.parser;

import java.util.Arrays;

 enum TokeniserState
{
  private static final char[] ap;
  private static final char[] aq;
  private static final char[] ar;
  private static final String as;
  
  static
  {
    A = new TokeniserState.27("ScriptDataEscapedEndTagName", 26);
    B = new TokeniserState.28("ScriptDataDoubleEscapeStart", 27);
    C = new TokeniserState.29("ScriptDataDoubleEscaped", 28);
    D = new TokeniserState.30("ScriptDataDoubleEscapedDash", 29);
    E = new TokeniserState.31("ScriptDataDoubleEscapedDashDash", 30);
    F = new TokeniserState.32("ScriptDataDoubleEscapedLessthanSign", 31);
    G = new TokeniserState.33("ScriptDataDoubleEscapeEnd", 32);
    H = new TokeniserState.34("BeforeAttributeName", 33);
    I = new TokeniserState.35("AttributeName", 34);
    J = new TokeniserState.36("AfterAttributeName", 35);
    K = new TokeniserState.37("BeforeAttributeValue", 36);
    L = new TokeniserState.38("AttributeValue_doubleQuoted", 37);
    M = new TokeniserState.39("AttributeValue_singleQuoted", 38);
    N = new TokeniserState.40("AttributeValue_unquoted", 39);
    O = new TokeniserState.41("AfterAttributeValue_quoted", 40);
    P = new TokeniserState.42("SelfClosingStartTag", 41);
    Q = new TokeniserState.43("BogusComment", 42);
    R = new TokeniserState.44("MarkupDeclarationOpen", 43);
    S = new TokeniserState.45("CommentStart", 44);
    T = new TokeniserState.46("CommentStartDash", 45);
    U = new TokeniserState.47("Comment", 46);
    V = new TokeniserState.48("CommentEndDash", 47);
    W = new TokeniserState.49("CommentEnd", 48);
    X = new TokeniserState.50("CommentEndBang", 49);
    Y = new TokeniserState.51("Doctype", 50);
    Z = new TokeniserState.52("BeforeDoctypeName", 51);
    aa = new TokeniserState.53("DoctypeName", 52);
    ab = new TokeniserState.54("AfterDoctypeName", 53);
    ac = new TokeniserState.55("AfterDoctypePublicKeyword", 54);
    ad = new TokeniserState.56("BeforeDoctypePublicIdentifier", 55);
    ae = new TokeniserState.57("DoctypePublicIdentifier_doubleQuoted", 56);
    af = new TokeniserState.58("DoctypePublicIdentifier_singleQuoted", 57);
    ag = new TokeniserState.59("AfterDoctypePublicIdentifier", 58);
    ah = new TokeniserState.60("BetweenDoctypePublicAndSystemIdentifiers", 59);
    ai = new TokeniserState.61("AfterDoctypeSystemKeyword", 60);
    aj = new TokeniserState.62("BeforeDoctypeSystemIdentifier", 61);
    ak = new TokeniserState.63("DoctypeSystemIdentifier_doubleQuoted", 62);
    al = new TokeniserState.64("DoctypeSystemIdentifier_singleQuoted", 63);
    am = new TokeniserState.65("AfterDoctypeSystemIdentifier", 64);
    an = new TokeniserState.66("BogusDoctype", 65);
    ao = new TokeniserState.67("CdataSection", 66);
    at = new TokeniserState[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao };
    ap = new char[] { 39, 38, 0 };
    aq = new char[] { 34, 38, 0 };
    ar = new char[] { 9, 10, 13, 12, 32, 47, 61, 62, 0, 34, 39, 60 };
    as = String.valueOf(65533);
    Arrays.sort(ap);
    Arrays.sort(aq);
    Arrays.sort(ar);
  }
  
  private static void b(Tokeniser paramTokeniser, CharacterReader paramCharacterReader, TokeniserState paramTokeniserState)
  {
    if (paramCharacterReader.p())
    {
      paramCharacterReader = paramCharacterReader.l();
      paramTokeniser.b.b(paramCharacterReader.toLowerCase());
      paramTokeniser.a.append(paramCharacterReader);
      return;
    }
    int i1 = 0;
    if ((paramTokeniser.i()) && (!paramCharacterReader.b()))
    {
      char c1 = paramCharacterReader.d();
      switch (c1)
      {
      default: 
        paramTokeniser.a.append(c1);
        i1 = 1;
      }
    }
    while (i1 != 0)
    {
      paramTokeniser.a("</" + paramTokeniser.a.toString());
      paramTokeniser.a(paramTokeniserState);
      return;
      paramTokeniser.a(H);
      continue;
      paramTokeniser.a(P);
      continue;
      paramTokeniser.c();
      paramTokeniser.a(a);
      continue;
      i1 = 1;
    }
  }
  
  private static void b(Tokeniser paramTokeniser, CharacterReader paramCharacterReader, TokeniserState paramTokeniserState1, TokeniserState paramTokeniserState2)
  {
    if (paramCharacterReader.p())
    {
      paramCharacterReader = paramCharacterReader.l();
      paramTokeniser.a.append(paramCharacterReader.toLowerCase());
      paramTokeniser.a(paramCharacterReader);
      return;
    }
    char c1 = paramCharacterReader.d();
    switch (c1)
    {
    default: 
      paramCharacterReader.e();
      paramTokeniser.a(paramTokeniserState2);
      return;
    }
    if (paramTokeniser.a.toString().equals("script")) {
      paramTokeniser.a(paramTokeniserState1);
    }
    for (;;)
    {
      paramTokeniser.a(c1);
      return;
      paramTokeniser.a(paramTokeniserState2);
    }
  }
  
  abstract void a(Tokeniser paramTokeniser, CharacterReader paramCharacterReader);
}
