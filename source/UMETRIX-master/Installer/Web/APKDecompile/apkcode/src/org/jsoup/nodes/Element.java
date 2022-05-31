package org.jsoup.nodes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator.AllElements;
import org.jsoup.select.Evaluator.Tag;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.Selector;

public class Element
  extends Node
{
  private static final Pattern g = Pattern.compile("\\s+");
  private Tag f;
  
  public Element(Tag paramTag, String paramString)
  {
    this(paramTag, paramString, new Attributes());
  }
  
  public Element(Tag paramTag, String paramString, Attributes paramAttributes)
  {
    super(paramString, paramAttributes);
    Validate.a(paramTag);
    this.f = paramTag;
  }
  
  private static Integer a(Element paramElement, List paramList)
  {
    Validate.a(paramElement);
    Validate.a(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      if ((Element)paramList.get(i) == paramElement) {
        return Integer.valueOf(i);
      }
      i += 1;
    }
    return null;
  }
  
  private static void a(Element paramElement, StringBuilder paramStringBuilder)
  {
    if ((paramElement.f.a().equals("br")) && (!TextNode.b(paramStringBuilder))) {
      paramStringBuilder.append(" ");
    }
  }
  
  private static void a(Element paramElement, Elements paramElements)
  {
    paramElement = paramElement.m();
    if ((paramElement != null) && (!paramElement.i().equals("#root")))
    {
      paramElements.add(paramElement);
      a(paramElement, paramElements);
    }
  }
  
  private void b(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof TextNode)) {
        b(paramStringBuilder, (TextNode)localNode);
      } else if ((localNode instanceof Element)) {
        a((Element)localNode, paramStringBuilder);
      }
    }
  }
  
  private static void b(StringBuilder paramStringBuilder, TextNode paramTextNode)
  {
    String str = paramTextNode.b();
    if (c(paramTextNode.a))
    {
      paramStringBuilder.append(str);
      return;
    }
    StringUtil.a(paramStringBuilder, str, TextNode.b(paramStringBuilder));
  }
  
  private void c(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((Node)localIterator.next()).a(paramStringBuilder);
    }
  }
  
  static boolean c(Node paramNode)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramNode != null)
    {
      bool1 = bool2;
      if ((paramNode instanceof Element))
      {
        paramNode = (Element)paramNode;
        if (!paramNode.f.g())
        {
          bool1 = bool2;
          if (paramNode.m() != null)
          {
            bool1 = bool2;
            if (!paramNode.m().f.g()) {}
          }
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String a()
  {
    return this.f.a();
  }
  
  public Element a(int paramInt)
  {
    return (Element)o().get(paramInt);
  }
  
  public Element a(String paramString1, String paramString2)
  {
    super.b(paramString1, paramString2);
    return this;
  }
  
  public Element a(Node paramNode)
  {
    Validate.a(paramNode);
    g(paramNode);
    F();
    this.b.add(paramNode);
    paramNode.c(this.b.size() - 1);
    return this;
  }
  
  void a(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    if ((paramStringBuilder.length() > 0) && (paramOutputSettings.d()) && ((this.f.c()) || ((m() != null) && (m().j().c())) || (paramOutputSettings.e()))) {
      c(paramStringBuilder, paramInt, paramOutputSettings);
    }
    paramStringBuilder.append("<").append(i());
    this.c.a(paramStringBuilder, paramOutputSettings);
    if ((this.b.isEmpty()) && (this.f.e()))
    {
      if ((paramOutputSettings.c() == Document.OutputSettings.Syntax.a) && (this.f.d()))
      {
        paramStringBuilder.append('>');
        return;
      }
      paramStringBuilder.append(" />");
      return;
    }
    paramStringBuilder.append(">");
  }
  
  public Element b(Node paramNode)
  {
    return (Element)super.d(paramNode);
  }
  
  public Elements b(String paramString)
  {
    return Selector.a(paramString, this);
  }
  
  void b(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    if ((!this.b.isEmpty()) || (!this.f.e()))
    {
      if ((paramOutputSettings.d()) && (!this.b.isEmpty()) && ((this.f.c()) || ((paramOutputSettings.e()) && ((this.b.size() > 1) || ((this.b.size() == 1) && (!(this.b.get(0) instanceof TextNode))))))) {
        c(paramStringBuilder, paramInt, paramOutputSettings);
      }
      paramStringBuilder.append("</").append(i()).append(">");
    }
  }
  
  public Element c(String paramString)
  {
    paramString = new Element(Tag.a(paramString), z());
    a(paramString);
    return paramString;
  }
  
  public Elements d(String paramString)
  {
    Validate.a(paramString);
    return Collector.a(new Evaluator.Tag(paramString.toLowerCase().trim()), this);
  }
  
  public boolean e(String paramString)
  {
    Object localObject = this.c.a("class");
    if ((((String)localObject).equals("")) || (((String)localObject).length() < paramString.length())) {}
    for (;;)
    {
      return false;
      localObject = g.split((CharSequence)localObject);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equalsIgnoreCase(localObject[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      bool1 = bool2;
    } while (!super.equals(paramObject));
    paramObject = (Element)paramObject;
    return this.f.equals(paramObject.f);
  }
  
  public Element g()
  {
    return (Element)super.h();
  }
  
  public int hashCode()
  {
    int j = super.hashCode();
    if (this.f != null) {}
    for (int i = this.f.hashCode();; i = 0) {
      return i + j * 31;
    }
  }
  
  public String i()
  {
    return this.f.a();
  }
  
  public Tag j()
  {
    return this.f;
  }
  
  public boolean k()
  {
    return this.f.b();
  }
  
  public String l()
  {
    return this.c.a("id");
  }
  
  public final Element m()
  {
    return (Element)this.a;
  }
  
  public Elements n()
  {
    Elements localElements = new Elements();
    a(this, localElements);
    return localElements;
  }
  
  public Elements o()
  {
    ArrayList localArrayList = new ArrayList(this.b.size());
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof Element)) {
        localArrayList.add((Element)localNode);
      }
    }
    return new Elements(localArrayList);
  }
  
  public Elements p()
  {
    if (this.a == null) {
      return new Elements(0);
    }
    Object localObject = m().o();
    Elements localElements = new Elements(((List)localObject).size() - 1);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Element localElement = (Element)((Iterator)localObject).next();
      if (localElement != this) {
        localElements.add(localElement);
      }
    }
    return localElements;
  }
  
  public Element q()
  {
    if (this.a == null) {}
    Elements localElements;
    Integer localInteger;
    do
    {
      return null;
      localElements = m().o();
      localInteger = a(this, localElements);
      Validate.a(localInteger);
    } while (localInteger.intValue() <= 0);
    return (Element)localElements.get(localInteger.intValue() - 1);
  }
  
  public Integer r()
  {
    if (m() == null) {
      return Integer.valueOf(0);
    }
    return a(this, m().o());
  }
  
  public Elements s()
  {
    return Collector.a(new Evaluator.AllElements(), this);
  }
  
  public String t()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    new NodeTraversor(new Element.1(this, localStringBuilder)).a(this);
    return localStringBuilder.toString().trim();
  }
  
  public String toString()
  {
    return c();
  }
  
  public String u()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    return localStringBuilder.toString().trim();
  }
  
  public String v()
  {
    return f("class").trim();
  }
  
  public String w()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    c(localStringBuilder);
    if (J().d()) {
      return localStringBuilder.toString().trim();
    }
    return localStringBuilder.toString();
  }
}
