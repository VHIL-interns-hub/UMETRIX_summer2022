package net.fred.feedex.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ArticleTextExtractor
{
  private static final Pattern a = Pattern.compile("p|div|td|h1|h2|article|section");
  private static final Pattern b = Pattern.compile("com(bx|ment|munity)|dis(qus|cuss)|e(xtra|[-]?mail)|foot|header|menu|re(mark|ply)|rss|sh(are|outbox)|sponsora(d|ll|gegate|rchive|ttachment)|(pag(er|ination))|popup|print|login|si(debar|gn|ngle)");
  private static final Pattern c = Pattern.compile("(^(body|content|h?entry|main|page|post|text|blog|story|haupt))|arti(cle|kel)|instapaper_body");
  private static final Pattern d = Pattern.compile("nav($|igation)|user|com(ment|bx)|(^com-)|contact|foot|masthead|(me(dia|ta))|outbrain|promo|related|scroll|(sho(utbox|pping))|sidebar|sponsor|tags|tool|widget|player|disclaimer|toc|infobox|vcard");
  private static final Pattern e = Pattern.compile("hidden|display: ?none|font-size: ?small");
  
  private static int a(String paramString)
  {
    return paramString.length() / 25;
  }
  
  private static int a(Element paramElement)
  {
    int j = 0;
    if (c.matcher(paramElement.v()).find()) {
      j = 35;
    }
    int i = j;
    if (c.matcher(paramElement.l()).find()) {
      i = j + 40;
    }
    j = i;
    if (b.matcher(paramElement.v()).find()) {
      j = i - 20;
    }
    i = j;
    if (b.matcher(paramElement.l()).find()) {
      i = j - 20;
    }
    j = i;
    if (d.matcher(paramElement.v()).find()) {
      j = i - 50;
    }
    i = j;
    if (d.matcher(paramElement.l()).find()) {
      i = j - 50;
    }
    paramElement = paramElement.f("style");
    j = i;
    if (paramElement != null)
    {
      j = i;
      if (!paramElement.isEmpty())
      {
        j = i;
        if (e.matcher(paramElement).find()) {
          j = i - 50;
        }
      }
    }
    return j;
  }
  
  private static int a(Element paramElement, String paramString)
  {
    return a(paramElement) + (int)Math.round(paramElement.u().length() / 100.0D * 10.0D) + b(paramElement, paramString);
  }
  
  public static String a(InputStream paramInputStream, String paramString)
  {
    return a(Jsoup.a(paramInputStream, null, ""), paramString);
  }
  
  public static String a(Document paramDocument, String paramString)
  {
    if (paramDocument == null) {
      throw new NullPointerException("missing document");
    }
    a(paramDocument);
    Object localObject1 = e(paramDocument);
    int i = 0;
    Iterator localIterator = ((Collection)localObject1).iterator();
    localObject1 = null;
    Object localObject2 = localObject1;
    int j;
    if (localIterator.hasNext())
    {
      localObject2 = (Element)localIterator.next();
      j = a((Element)localObject2, paramString);
      if (j <= i) {
        break label221;
      }
      if (j <= 300) {}
    }
    else
    {
      paramDocument = d(paramDocument).iterator();
      do
      {
        if (!paramDocument.hasNext()) {
          break;
        }
        paramString = (Element)paramDocument.next();
      } while ((!paramString.g("property")) || (!"og:image".equals(paramString.f("property"))));
      paramDocument = paramString.f("content");
      label142:
      if (localObject2 == null) {
        break label214;
      }
      localObject1 = ((Element)localObject2).toString();
      paramString = (String)localObject1;
      if (paramDocument != null)
      {
        paramString = (String)localObject1;
        if (!((String)localObject1).contains(paramDocument)) {
          paramString = "<img src=\"" + paramDocument + "\"><br>\n" + (String)localObject1;
        }
      }
      return paramString;
    }
    i = j;
    localObject1 = localObject2;
    label214:
    label221:
    for (;;)
    {
      break;
      return null;
      paramDocument = null;
      break label142;
    }
  }
  
  private static void a(Document paramDocument)
  {
    c(paramDocument);
    b(paramDocument);
  }
  
  private static int b(Element paramElement, String paramString)
  {
    Object localObject = null;
    ArrayList localArrayList = new ArrayList(5);
    Iterator localIterator = paramElement.o().iterator();
    int i = 0;
    Element localElement;
    String str;
    int k;
    int j;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localElement = (Element)localIterator.next();
        str = localElement.t();
        k = str.length();
        if (k >= 20)
        {
          j = i;
          if (paramString != null)
          {
            j = i;
            if (str.contains(paramString)) {
              j = i + 100;
            }
          }
          str = localElement.u();
          int m = str.length();
          i = j;
          if (m > 200) {
            i = j + Math.max(50, m / 10);
          }
          if ((localElement.i().equals("h1")) || (localElement.i().equals("h2"))) {
            i += 30;
          }
        }
      }
    }
    for (;;)
    {
      break;
      if (!localElement.i().equals("div"))
      {
        j = i;
        if (!localElement.i().equals("p")) {}
      }
      else
      {
        i += a(str);
        if ((localElement.i().equals("p")) && (k > 50)) {
          localArrayList.add(localElement);
        }
        j = i;
        if (localElement.v().toLowerCase().equals("caption"))
        {
          localObject = localElement;
          continue;
          j = i;
          if (localObject != null) {
            j = i + 30;
          }
          i = j;
          if (localArrayList.size() >= 2)
          {
            paramElement = paramElement.o().iterator();
            for (;;)
            {
              i = j;
              if (!paramElement.hasNext()) {
                break;
              }
              if ("h1;h2;h3;h4;h5;h6".contains(((Element)paramElement.next()).i())) {
                j += 20;
              }
            }
          }
          return i;
        }
      }
      i = j;
    }
  }
  
  private static Document b(Document paramDocument)
  {
    Iterator localIterator = paramDocument.d("script").iterator();
    while (localIterator.hasNext()) {
      ((Element)localIterator.next()).E();
    }
    localIterator = paramDocument.d("noscript").iterator();
    while (localIterator.hasNext()) {
      ((Element)localIterator.next()).E();
    }
    localIterator = paramDocument.d("style").iterator();
    while (localIterator.hasNext()) {
      ((Element)localIterator.next()).E();
    }
    return paramDocument;
  }
  
  private static Document c(Document paramDocument)
  {
    Iterator localIterator = paramDocument.d("select").iterator();
    while (localIterator.hasNext()) {
      ((Element)localIterator.next()).E();
    }
    localIterator = paramDocument.d("option").iterator();
    while (localIterator.hasNext()) {
      ((Element)localIterator.next()).E();
    }
    return paramDocument;
  }
  
  private static Collection d(Document paramDocument)
  {
    HashSet localHashSet = new HashSet(64);
    paramDocument = paramDocument.b("head").a("meta").iterator();
    while (paramDocument.hasNext()) {
      localHashSet.add((Element)paramDocument.next());
    }
    return localHashSet;
  }
  
  private static Collection e(Document paramDocument)
  {
    HashSet localHashSet = new HashSet(64);
    paramDocument = paramDocument.b("body").a("*").iterator();
    while (paramDocument.hasNext())
    {
      Element localElement = (Element)paramDocument.next();
      if (a.matcher(localElement.i()).matches()) {
        localHashSet.add(localElement);
      }
    }
    return localHashSet;
  }
}
