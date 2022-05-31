package org.jsoup.safety;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public class Whitelist
{
  private Set a = new HashSet();
  private Map b = new HashMap();
  private Map c = new HashMap();
  private Map d = new HashMap();
  private boolean e = false;
  
  public Whitelist() {}
  
  public static Whitelist a()
  {
    return new Whitelist().a(new String[] { "a", "b", "blockquote", "br", "caption", "cite", "code", "col", "colgroup", "dd", "div", "dl", "dt", "em", "h1", "h2", "h3", "h4", "h5", "h6", "i", "img", "li", "ol", "p", "pre", "q", "small", "span", "strike", "strong", "sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr", "u", "ul" }).a("a", new String[] { "href", "title" }).a("blockquote", new String[] { "cite" }).a("col", new String[] { "span", "width" }).a("colgroup", new String[] { "span", "width" }).a("img", new String[] { "align", "alt", "height", "src", "title", "width" }).a("ol", new String[] { "start", "type" }).a("q", new String[] { "cite" }).a("table", new String[] { "summary", "width" }).a("td", new String[] { "abbr", "axis", "colspan", "rowspan", "width" }).a("th", new String[] { "abbr", "axis", "colspan", "rowspan", "scope", "width" }).a("ul", new String[] { "type" }).a("a", "href", new String[] { "ftp", "http", "https", "mailto" }).a("blockquote", "cite", new String[] { "http", "https" }).a("cite", "cite", new String[] { "http", "https" }).a("img", "src", new String[] { "http", "https" }).a("q", "cite", new String[] { "http", "https" });
  }
  
  private boolean a(Element paramElement, Attribute paramAttribute, Set paramSet)
  {
    paramElement = paramElement.i(paramAttribute.a());
    if (paramElement.length() == 0) {
      paramElement = paramAttribute.b();
    }
    for (;;)
    {
      if (!this.e) {
        paramAttribute.a(paramElement);
      }
      paramAttribute = paramSet.iterator();
      while (paramAttribute.hasNext())
      {
        paramSet = ((Whitelist.Protocol)paramAttribute.next()).toString();
        if (paramSet.equals("#"))
        {
          if (c(paramElement)) {
            return true;
          }
        }
        else
        {
          paramSet = paramSet + ":";
          if (paramElement.toLowerCase().startsWith(paramSet)) {
            return true;
          }
        }
      }
      return false;
    }
  }
  
  private boolean c(String paramString)
  {
    return (paramString.startsWith("#")) && (!paramString.matches(".*\\s.*"));
  }
  
  public Whitelist a(String paramString1, String paramString2, String... paramVarArgs)
  {
    Validate.a(paramString1);
    Validate.a(paramString2);
    Validate.a(paramVarArgs);
    Whitelist.TagName localTagName = Whitelist.TagName.a(paramString1);
    Whitelist.AttributeKey localAttributeKey = Whitelist.AttributeKey.a(paramString2);
    if (this.d.containsKey(localTagName))
    {
      paramString1 = (Map)this.d.get(localTagName);
      if (!paramString1.containsKey(localAttributeKey)) {
        break label143;
      }
    }
    for (paramString1 = (Set)paramString1.get(localAttributeKey);; paramString1 = paramString2)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramString2 = paramVarArgs[i];
        Validate.a(paramString2);
        paramString1.add(Whitelist.Protocol.a(paramString2));
        i += 1;
      }
      paramString1 = new HashMap();
      this.d.put(localTagName, paramString1);
      break;
      label143:
      paramString2 = new HashSet();
      paramString1.put(localAttributeKey, paramString2);
    }
    return this;
  }
  
  public Whitelist a(String paramString, String... paramVarArgs)
  {
    int i = 0;
    Validate.a(paramString);
    Validate.a(paramVarArgs);
    if (paramVarArgs.length > 0) {}
    HashSet localHashSet;
    for (boolean bool = true;; bool = false)
    {
      Validate.a(bool, "No attributes supplied.");
      paramString = Whitelist.TagName.a(paramString);
      if (!this.a.contains(paramString)) {
        this.a.add(paramString);
      }
      localHashSet = new HashSet();
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        Validate.a(str);
        localHashSet.add(Whitelist.AttributeKey.a(str));
        i += 1;
      }
    }
    if (this.b.containsKey(paramString))
    {
      ((Set)this.b.get(paramString)).addAll(localHashSet);
      return this;
    }
    this.b.put(paramString, localHashSet);
    return this;
  }
  
  public Whitelist a(String... paramVarArgs)
  {
    Validate.a(paramVarArgs);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      Validate.a(str);
      this.a.add(Whitelist.TagName.a(str));
      i += 1;
    }
    return this;
  }
  
  protected boolean a(String paramString)
  {
    return this.a.contains(Whitelist.TagName.a(paramString));
  }
  
  protected boolean a(String paramString, Element paramElement, Attribute paramAttribute)
  {
    boolean bool = true;
    Whitelist.TagName localTagName = Whitelist.TagName.a(paramString);
    Whitelist.AttributeKey localAttributeKey = Whitelist.AttributeKey.a(paramAttribute.a());
    if ((this.b.containsKey(localTagName)) && (((Set)this.b.get(localTagName)).contains(localAttributeKey))) {
      if (this.d.containsKey(localTagName))
      {
        paramString = (Map)this.d.get(localTagName);
        if ((paramString.containsKey(localAttributeKey)) && (!a(paramElement, paramAttribute, (Set)paramString.get(localAttributeKey)))) {
          break label122;
        }
        bool = true;
      }
    }
    label122:
    while ((!paramString.equals(":all")) && (a(":all", paramElement, paramAttribute))) {
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return false;
  }
  
  Attributes b(String paramString)
  {
    Attributes localAttributes = new Attributes();
    paramString = Whitelist.TagName.a(paramString);
    if (this.c.containsKey(paramString))
    {
      paramString = ((Map)this.c.get(paramString)).entrySet().iterator();
      while (paramString.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramString.next();
        localAttributes.a(((Whitelist.AttributeKey)localEntry.getKey()).toString(), ((Whitelist.AttributeValue)localEntry.getValue()).toString());
      }
    }
    return localAttributes;
  }
}
