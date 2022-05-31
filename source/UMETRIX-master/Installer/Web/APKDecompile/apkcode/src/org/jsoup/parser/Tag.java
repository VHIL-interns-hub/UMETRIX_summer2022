package org.jsoup.parser;

import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.Validate;

public class Tag
{
  private static final Map a;
  private static final String[] l;
  private static final String[] m;
  private static final String[] n;
  private static final String[] o;
  private static final String[] p;
  private static final String[] q;
  private static final String[] r;
  private String b;
  private boolean c = true;
  private boolean d = true;
  private boolean e = true;
  private boolean f = true;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  
  static
  {
    int i2 = 0;
    a = new HashMap();
    l = new String[] { "html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "s", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math" };
    m = new String[] { "object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi" };
    n = new String[] { "meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track" };
    o = new String[] { "title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s" };
    p = new String[] { "pre", "plaintext", "title", "textarea" };
    q = new String[] { "button", "fieldset", "input", "keygen", "object", "output", "select", "textarea" };
    r = new String[] { "input", "keygen", "object", "select", "textarea" };
    String[] arrayOfString = l;
    int i3 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i3)
    {
      a(new Tag(arrayOfString[i1]));
      i1 += 1;
    }
    arrayOfString = m;
    i3 = arrayOfString.length;
    i1 = 0;
    Object localObject;
    while (i1 < i3)
    {
      localObject = new Tag(arrayOfString[i1]);
      ((Tag)localObject).c = false;
      ((Tag)localObject).e = false;
      ((Tag)localObject).d = false;
      a((Tag)localObject);
      i1 += 1;
    }
    arrayOfString = n;
    i3 = arrayOfString.length;
    i1 = 0;
    while (i1 < i3)
    {
      localObject = arrayOfString[i1];
      localObject = (Tag)a.get(localObject);
      Validate.a(localObject);
      ((Tag)localObject).e = false;
      ((Tag)localObject).f = false;
      ((Tag)localObject).g = true;
      i1 += 1;
    }
    arrayOfString = o;
    i3 = arrayOfString.length;
    i1 = 0;
    while (i1 < i3)
    {
      localObject = arrayOfString[i1];
      localObject = (Tag)a.get(localObject);
      Validate.a(localObject);
      ((Tag)localObject).d = false;
      i1 += 1;
    }
    arrayOfString = p;
    i3 = arrayOfString.length;
    i1 = 0;
    while (i1 < i3)
    {
      localObject = arrayOfString[i1];
      localObject = (Tag)a.get(localObject);
      Validate.a(localObject);
      ((Tag)localObject).i = true;
      i1 += 1;
    }
    arrayOfString = q;
    i3 = arrayOfString.length;
    i1 = 0;
    while (i1 < i3)
    {
      localObject = arrayOfString[i1];
      localObject = (Tag)a.get(localObject);
      Validate.a(localObject);
      ((Tag)localObject).j = true;
      i1 += 1;
    }
    arrayOfString = r;
    i3 = arrayOfString.length;
    i1 = i2;
    while (i1 < i3)
    {
      localObject = arrayOfString[i1];
      localObject = (Tag)a.get(localObject);
      Validate.a(localObject);
      ((Tag)localObject).k = true;
      i1 += 1;
    }
  }
  
  private Tag(String paramString)
  {
    this.b = paramString.toLowerCase();
  }
  
  public static Tag a(String paramString)
  {
    Validate.a(paramString);
    Object localObject2 = (Tag)a.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = paramString.trim().toLowerCase();
      Validate.a((String)localObject2);
      paramString = (Tag)a.get(localObject2);
      localObject1 = paramString;
      if (paramString == null)
      {
        localObject1 = new Tag((String)localObject2);
        ((Tag)localObject1).c = false;
        ((Tag)localObject1).e = true;
      }
    }
    return localObject1;
  }
  
  private static void a(Tag paramTag)
  {
    a.put(paramTag.b, paramTag);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    return this.g;
  }
  
  public boolean e()
  {
    return (this.g) || (this.h);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool1;
                        bool1 = bool3;
                      } while (!(paramObject instanceof Tag));
                      paramObject = (Tag)paramObject;
                      bool1 = bool3;
                    } while (!this.b.equals(paramObject.b));
                    bool1 = bool3;
                  } while (this.e != paramObject.e);
                  bool1 = bool3;
                } while (this.f != paramObject.f);
                bool1 = bool3;
              } while (this.g != paramObject.g);
              bool1 = bool3;
            } while (this.d != paramObject.d);
            bool1 = bool3;
          } while (this.c != paramObject.c);
          bool1 = bool3;
        } while (this.i != paramObject.i);
        bool1 = bool3;
      } while (this.h != paramObject.h);
      bool1 = bool3;
    } while (this.j != paramObject.j);
    if (this.k == paramObject.k) {}
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean f()
  {
    return a.containsKey(this.b);
  }
  
  public boolean g()
  {
    return this.i;
  }
  
  public boolean h()
  {
    return this.j;
  }
  
  public int hashCode()
  {
    int i9 = 1;
    int i10 = this.b.hashCode();
    int i1;
    int i2;
    label30:
    int i3;
    label39:
    int i4;
    label49:
    int i5;
    label59:
    int i6;
    label69:
    int i7;
    label79:
    int i8;
    if (this.c)
    {
      i1 = 1;
      if (!this.d) {
        break label155;
      }
      i2 = 1;
      if (!this.e) {
        break label160;
      }
      i3 = 1;
      if (!this.f) {
        break label165;
      }
      i4 = 1;
      if (!this.g) {
        break label171;
      }
      i5 = 1;
      if (!this.h) {
        break label177;
      }
      i6 = 1;
      if (!this.i) {
        break label183;
      }
      i7 = 1;
      if (!this.j) {
        break label189;
      }
      i8 = 1;
      label89:
      if (!this.k) {
        break label195;
      }
    }
    for (;;)
    {
      return (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + i10 * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i9;
      i1 = 0;
      break;
      label155:
      i2 = 0;
      break label30;
      label160:
      i3 = 0;
      break label39;
      label165:
      i4 = 0;
      break label49;
      label171:
      i5 = 0;
      break label59;
      label177:
      i6 = 0;
      break label69;
      label183:
      i7 = 0;
      break label79;
      label189:
      i8 = 0;
      break label89;
      label195:
      i9 = 0;
    }
  }
  
  Tag i()
  {
    this.h = true;
    return this;
  }
  
  public String toString()
  {
    return this.b;
  }
}
