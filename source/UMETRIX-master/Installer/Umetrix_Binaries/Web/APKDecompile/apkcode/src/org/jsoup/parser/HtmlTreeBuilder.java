package org.jsoup.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class HtmlTreeBuilder
  extends TreeBuilder
{
  public static final String[] a;
  private static final String[] j;
  private static final String[] k;
  private static final String[] l;
  private static final String[] m;
  private static final String[] n;
  private static final String[] o;
  private static final String[] p;
  private boolean A = false;
  private boolean B = false;
  private String[] C = { null };
  private HtmlTreeBuilderState q;
  private HtmlTreeBuilderState r;
  private boolean s = false;
  private Element t;
  private FormElement u;
  private Element v;
  private ArrayList w = new ArrayList();
  private List x = new ArrayList();
  private Token.EndTag y = new Token.EndTag();
  private boolean z = true;
  
  static
  {
    if (!HtmlTreeBuilder.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      j = new String[] { "script", "style" };
      a = new String[] { "applet", "caption", "html", "table", "td", "th", "marquee", "object" };
      k = new String[] { "ol", "ul" };
      l = new String[] { "button" };
      m = new String[] { "html", "table" };
      n = new String[] { "optgroup", "option" };
      o = new String[] { "dd", "dt", "li", "option", "optgroup", "p", "rp", "rt" };
      p = new String[] { "address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp" };
      return;
    }
  }
  
  HtmlTreeBuilder() {}
  
  private void a(ArrayList paramArrayList, Element paramElement1, Element paramElement2)
  {
    int i = paramArrayList.lastIndexOf(paramElement1);
    if (i != -1) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.a(bool);
      paramArrayList.set(i, paramElement2);
      return;
    }
  }
  
  private boolean a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.C[0] = paramString;
    return a(this.C, paramArrayOfString1, paramArrayOfString2);
  }
  
  private boolean a(ArrayList paramArrayList, Element paramElement)
  {
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      if ((Element)paramArrayList.get(i) == paramElement) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  private boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    int i = this.f.size() - 1;
    while (i >= 0)
    {
      String str = ((Element)this.f.get(i)).a();
      if (StringUtil.a(str, paramArrayOfString1)) {
        return true;
      }
      if (StringUtil.a(str, paramArrayOfString2)) {
        return false;
      }
      if ((paramArrayOfString3 != null) && (StringUtil.a(str, paramArrayOfString3))) {
        return false;
      }
      i -= 1;
    }
    Validate.b("Should not be reachable");
    return false;
  }
  
  private void b(Node paramNode)
  {
    if (this.f.size() == 0) {
      this.e.a(paramNode);
    }
    for (;;)
    {
      if (((paramNode instanceof Element)) && (((Element)paramNode).j().h()) && (this.u != null)) {
        this.u.b((Element)paramNode);
      }
      return;
      if (o()) {
        a(paramNode);
      } else {
        z().a(paramNode);
      }
    }
  }
  
  private void c(String... paramVarArgs)
  {
    int i = this.f.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        Element localElement = (Element)this.f.get(i);
        if ((!StringUtil.a(localElement.a(), paramVarArgs)) && (!localElement.a().equals("html"))) {}
      }
      else
      {
        return;
      }
      this.f.remove(i);
      i -= 1;
    }
  }
  
  private boolean d(Element paramElement1, Element paramElement2)
  {
    return (paramElement1.a().equals(paramElement2.a())) && (paramElement1.y().equals(paramElement2.y()));
  }
  
  List a(String paramString1, Element paramElement, String paramString2, ParseErrorList paramParseErrorList)
  {
    this.q = HtmlTreeBuilderState.a;
    b(paramString1, paramString2, paramParseErrorList);
    this.v = paramElement;
    this.B = true;
    paramString1 = null;
    if (paramElement != null)
    {
      if (paramElement.D() != null) {
        this.e.a(paramElement.D().f());
      }
      paramString1 = paramElement.i();
      if (!StringUtil.a(paramString1, new String[] { "title", "textarea" })) {
        break label195;
      }
      this.d.a(TokeniserState.c);
      paramString1 = new Element(Tag.a("html"), paramString2);
      this.e.a(paramString1);
      this.f.add(paramString1);
      m();
      paramString2 = paramElement.n();
      paramString2.add(0, paramElement);
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        paramParseErrorList = (Element)paramString2.next();
        if ((paramParseErrorList instanceof FormElement)) {
          this.u = ((FormElement)paramParseErrorList);
        }
      }
    }
    for (;;)
    {
      y();
      if ((paramElement != null) && (paramString1 != null))
      {
        return paramString1.A();
        label195:
        if (StringUtil.a(paramString1, new String[] { "iframe", "noembed", "noframes", "style", "xmp" }))
        {
          this.d.a(TokeniserState.e);
          break;
        }
        if (paramString1.equals("script"))
        {
          this.d.a(TokeniserState.f);
          break;
        }
        if (paramString1.equals("noscript"))
        {
          this.d.a(TokeniserState.a);
          break;
        }
        if (paramString1.equals("plaintext"))
        {
          this.d.a(TokeniserState.a);
          break;
        }
        this.d.a(TokeniserState.a);
        break;
      }
      return this.e.A();
    }
  }
  
  Document a(String paramString1, String paramString2, ParseErrorList paramParseErrorList)
  {
    this.q = HtmlTreeBuilderState.a;
    this.s = false;
    return super.a(paramString1, paramString2, paramParseErrorList);
  }
  
  Element a(String paramString)
  {
    paramString = new Element(Tag.a(paramString), this.g);
    b(paramString);
    return paramString;
  }
  
  Element a(Token.StartTag paramStartTag)
  {
    if (paramStartTag.r())
    {
      paramStartTag = b(paramStartTag);
      this.f.add(paramStartTag);
      this.d.a(TokeniserState.a);
      this.d.a(this.y.n().a(paramStartTag.i()));
      return paramStartTag;
    }
    paramStartTag = new Element(Tag.a(paramStartTag.q()), this.g, paramStartTag.d);
    b(paramStartTag);
    return paramStartTag;
  }
  
  FormElement a(Token.StartTag paramStartTag, boolean paramBoolean)
  {
    paramStartTag = new FormElement(Tag.a(paramStartTag.q()), this.g, paramStartTag.d);
    a(paramStartTag);
    b(paramStartTag);
    if (paramBoolean) {
      this.f.add(paramStartTag);
    }
    return paramStartTag;
  }
  
  HtmlTreeBuilderState a()
  {
    return this.q;
  }
  
  void a(Element paramElement)
  {
    if (this.s) {}
    do
    {
      return;
      paramElement = paramElement.i("href");
    } while (paramElement.length() == 0);
    this.g = paramElement;
    this.s = true;
    this.e.h(paramElement);
  }
  
  void a(Element paramElement1, Element paramElement2)
  {
    int i = this.f.lastIndexOf(paramElement1);
    if (i != -1) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.a(bool);
      this.f.add(i + 1, paramElement2);
      return;
    }
  }
  
  void a(FormElement paramFormElement)
  {
    this.u = paramFormElement;
  }
  
  void a(Node paramNode)
  {
    Element localElement2 = b("table");
    Element localElement1;
    int i;
    if (localElement2 != null) {
      if (localElement2.m() != null)
      {
        localElement1 = localElement2.m();
        i = 1;
      }
    }
    while (i != 0)
    {
      Validate.a(localElement2);
      localElement2.b(paramNode);
      return;
      localElement1 = f(localElement2);
      i = 0;
      continue;
      localElement1 = (Element)this.f.get(0);
      i = 0;
    }
    localElement1.a(paramNode);
  }
  
  void a(HtmlTreeBuilderState paramHtmlTreeBuilderState)
  {
    this.q = paramHtmlTreeBuilderState;
  }
  
  void a(Token.Character paramCharacter)
  {
    String str = z().i();
    if ((str.equals("script")) || (str.equals("style"))) {}
    for (paramCharacter = new DataNode(paramCharacter.n(), this.g);; paramCharacter = new TextNode(paramCharacter.n(), this.g))
    {
      z().a(paramCharacter);
      return;
    }
  }
  
  void a(Token.Comment paramComment)
  {
    b(new Comment(paramComment.n(), this.g));
  }
  
  void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  void a(String... paramVarArgs)
  {
    int i = this.f.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        Element localElement = (Element)this.f.get(i);
        this.f.remove(i);
        if (!StringUtil.a(localElement.a(), paramVarArgs)) {}
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
  
  boolean a(String paramString, String[] paramArrayOfString)
  {
    return a(paramString, a, paramArrayOfString);
  }
  
  protected boolean a(Token paramToken)
  {
    this.h = paramToken;
    return this.q.a(paramToken, this);
  }
  
  boolean a(Token paramToken, HtmlTreeBuilderState paramHtmlTreeBuilderState)
  {
    this.h = paramToken;
    return paramHtmlTreeBuilderState.a(paramToken, this);
  }
  
  Element b(String paramString)
  {
    int i = this.f.size() - 1;
    while (i >= 0)
    {
      Element localElement = (Element)this.f.get(i);
      if (localElement.a().equals(paramString)) {
        return localElement;
      }
      i -= 1;
    }
    return null;
  }
  
  Element b(Token.StartTag paramStartTag)
  {
    Tag localTag = Tag.a(paramStartTag.q());
    Element localElement = new Element(localTag, this.g, paramStartTag.d);
    b(localElement);
    if (paramStartTag.r())
    {
      if (!localTag.f()) {
        break label60;
      }
      if (localTag.e()) {
        this.d.b();
      }
    }
    return localElement;
    label60:
    localTag.i();
    this.d.b();
    return localElement;
  }
  
  void b()
  {
    this.r = this.q;
  }
  
  void b(Element paramElement)
  {
    b(paramElement);
    this.f.add(paramElement);
  }
  
  void b(Element paramElement1, Element paramElement2)
  {
    a(this.f, paramElement1, paramElement2);
  }
  
  void b(HtmlTreeBuilderState paramHtmlTreeBuilderState)
  {
    if (this.i.a()) {
      this.i.add(new ParseError(this.c.a(), "Unexpected token [%s] when in state [%s]", new Object[] { this.h.a(), paramHtmlTreeBuilderState }));
    }
  }
  
  void b(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  boolean b(String[] paramArrayOfString)
  {
    return a(paramArrayOfString, a, null);
  }
  
  HtmlTreeBuilderState c()
  {
    return this.r;
  }
  
  void c(String paramString)
  {
    int i = this.f.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        Element localElement = (Element)this.f.get(i);
        this.f.remove(i);
        if (!localElement.a().equals(paramString)) {}
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
  
  void c(Element paramElement)
  {
    this.f.add(paramElement);
  }
  
  void c(Element paramElement1, Element paramElement2)
  {
    a(this.w, paramElement1, paramElement2);
  }
  
  void d(String paramString)
  {
    int i = this.f.size() - 1;
    for (;;)
    {
      if ((i < 0) || (((Element)this.f.get(i)).a().equals(paramString))) {
        return;
      }
      this.f.remove(i);
      i -= 1;
    }
  }
  
  boolean d()
  {
    return this.z;
  }
  
  boolean d(Element paramElement)
  {
    return a(this.f, paramElement);
  }
  
  Document e()
  {
    return this.e;
  }
  
  boolean e(String paramString)
  {
    return a(paramString, null);
  }
  
  boolean e(Element paramElement)
  {
    int i = this.f.size() - 1;
    while (i >= 0)
    {
      if ((Element)this.f.get(i) == paramElement)
      {
        this.f.remove(i);
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  String f()
  {
    return this.g;
  }
  
  Element f(Element paramElement)
  {
    if ((!b) && (!d(paramElement))) {
      throw new AssertionError();
    }
    int i = this.f.size() - 1;
    while (i >= 0)
    {
      if ((Element)this.f.get(i) == paramElement) {
        return (Element)this.f.get(i - 1);
      }
      i -= 1;
    }
    return null;
  }
  
  boolean f(String paramString)
  {
    return a(paramString, k);
  }
  
  void g(Element paramElement)
  {
    this.t = paramElement;
  }
  
  boolean g()
  {
    return this.B;
  }
  
  boolean g(String paramString)
  {
    return a(paramString, l);
  }
  
  Element h()
  {
    int i = this.f.size();
    return (Element)this.f.remove(i - 1);
  }
  
  boolean h(String paramString)
  {
    return a(paramString, m, null);
  }
  
  boolean h(Element paramElement)
  {
    return StringUtil.a(paramElement.a(), p);
  }
  
  ArrayList i()
  {
    return this.f;
  }
  
  void i(Element paramElement)
  {
    int i = 0;
    int i1 = this.w.size() - 1;
    Element localElement;
    if (i1 >= 0)
    {
      localElement = (Element)this.w.get(i1);
      if (localElement != null) {}
    }
    else
    {
      label34:
      this.w.add(paramElement);
      return;
    }
    if (d(paramElement, localElement)) {
      i += 1;
    }
    for (;;)
    {
      if (i == 3)
      {
        this.w.remove(i1);
        break label34;
      }
      i1 -= 1;
      break;
    }
  }
  
  boolean i(String paramString)
  {
    int i = this.f.size() - 1;
    while (i >= 0)
    {
      String str = ((Element)this.f.get(i)).a();
      if (str.equals(paramString)) {
        return true;
      }
      if (!StringUtil.a(str, n)) {
        return false;
      }
      i -= 1;
    }
    Validate.b("Should not be reachable");
    return false;
  }
  
  void j()
  {
    c(new String[] { "table" });
  }
  
  void j(String paramString)
  {
    while ((paramString != null) && (!z().a().equals(paramString)) && (StringUtil.a(z().a(), o))) {
      h();
    }
  }
  
  void j(Element paramElement)
  {
    int i = this.w.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if ((Element)this.w.get(i) == paramElement) {
          this.w.remove(i);
        }
      }
      else {
        return;
      }
      i -= 1;
    }
  }
  
  Element k(String paramString)
  {
    int i = this.w.size() - 1;
    for (;;)
    {
      Element localElement2;
      Element localElement1;
      if (i >= 0)
      {
        localElement2 = (Element)this.w.get(i);
        if (localElement2 != null) {}
      }
      else
      {
        localElement1 = null;
      }
      do
      {
        return localElement1;
        localElement1 = localElement2;
      } while (localElement2.a().equals(paramString));
      i -= 1;
    }
  }
  
  void k()
  {
    c(new String[] { "tbody", "tfoot", "thead" });
  }
  
  boolean k(Element paramElement)
  {
    return a(this.w, paramElement);
  }
  
  void l()
  {
    c(new String[] { "tr" });
  }
  
  void m()
  {
    int i1 = 0;
    int i = this.f.size() - 1;
    for (;;)
    {
      Object localObject;
      if (i >= 0)
      {
        localObject = (Element)this.f.get(i);
        if (i == 0)
        {
          i1 = 1;
          localObject = this.v;
        }
        localObject = ((Element)localObject).a();
        if ("select".equals(localObject)) {
          a(HtmlTreeBuilderState.p);
        }
      }
      else
      {
        return;
      }
      if (("td".equals(localObject)) || (("th".equals(localObject)) && (i1 == 0)))
      {
        a(HtmlTreeBuilderState.o);
        return;
      }
      if ("tr".equals(localObject))
      {
        a(HtmlTreeBuilderState.n);
        return;
      }
      if (("tbody".equals(localObject)) || ("thead".equals(localObject)) || ("tfoot".equals(localObject)))
      {
        a(HtmlTreeBuilderState.m);
        return;
      }
      if ("caption".equals(localObject))
      {
        a(HtmlTreeBuilderState.k);
        return;
      }
      if ("colgroup".equals(localObject))
      {
        a(HtmlTreeBuilderState.l);
        return;
      }
      if ("table".equals(localObject))
      {
        a(HtmlTreeBuilderState.i);
        return;
      }
      if ("head".equals(localObject))
      {
        a(HtmlTreeBuilderState.g);
        return;
      }
      if ("body".equals(localObject))
      {
        a(HtmlTreeBuilderState.g);
        return;
      }
      if ("frameset".equals(localObject))
      {
        a(HtmlTreeBuilderState.s);
        return;
      }
      if ("html".equals(localObject))
      {
        a(HtmlTreeBuilderState.c);
        return;
      }
      if (i1 != 0)
      {
        a(HtmlTreeBuilderState.g);
        return;
      }
      i -= 1;
    }
  }
  
  Element n()
  {
    return this.t;
  }
  
  boolean o()
  {
    return this.A;
  }
  
  FormElement p()
  {
    return this.u;
  }
  
  void q()
  {
    this.x = new ArrayList();
  }
  
  List r()
  {
    return this.x;
  }
  
  void s()
  {
    j(null);
  }
  
  Element t()
  {
    if (this.w.size() > 0) {
      return (Element)this.w.get(this.w.size() - 1);
    }
    return null;
  }
  
  public String toString()
  {
    return "TreeBuilder{currentToken=" + this.h + ", state=" + this.q + ", currentElement=" + z() + '}';
  }
  
  Element u()
  {
    int i = this.w.size();
    if (i > 0) {
      return (Element)this.w.remove(i - 1);
    }
    return null;
  }
  
  void v()
  {
    Object localObject = t();
    if ((localObject == null) || (d((Element)localObject))) {
      return;
    }
    int i3 = this.w.size();
    int i = i3 - 1;
    label35:
    int i1;
    if (i == 0) {
      i1 = 1;
    }
    for (;;)
    {
      int i2 = i;
      if (i1 == 0)
      {
        localObject = this.w;
        i2 = i + 1;
        localObject = (Element)((ArrayList)localObject).get(i2);
      }
      Validate.a(localObject);
      Element localElement = a(((Element)localObject).a());
      localElement.y().a(((Element)localObject).y());
      this.w.set(i2, localElement);
      if (i2 == i3 - 1) {
        break;
      }
      i1 = 0;
      i = i2;
      continue;
      localObject = this.w;
      i -= 1;
      localObject = (Element)((ArrayList)localObject).get(i);
      if (localObject != null)
      {
        if (d((Element)localObject))
        {
          i1 = 0;
          continue;
        }
        break label35;
      }
      i1 = 0;
    }
  }
  
  void w()
  {
    while ((!this.w.isEmpty()) && (u() != null)) {}
  }
  
  void x()
  {
    this.w.add(null);
  }
}
