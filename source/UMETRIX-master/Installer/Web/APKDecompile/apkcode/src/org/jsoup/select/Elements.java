package org.jsoup.select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Element;

public class Elements
  extends ArrayList
{
  public Elements() {}
  
  public Elements(int paramInt)
  {
    super(paramInt);
  }
  
  public Elements(Collection paramCollection)
  {
    super(paramCollection);
  }
  
  public Elements(List paramList)
  {
    super(paramList);
  }
  
  public Elements a()
  {
    Elements localElements = new Elements(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localElements.add(((Element)localIterator.next()).g());
    }
    return localElements;
  }
  
  public Elements a(String paramString)
  {
    return Selector.a(paramString, this);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(localElement.c());
    }
    return localStringBuilder.toString();
  }
  
  public Element c()
  {
    if (isEmpty()) {
      return null;
    }
    return (Element)get(0);
  }
  
  public String toString()
  {
    return b();
  }
}
