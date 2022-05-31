package com.bumptech.glide.load.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class LazyHeaders
  implements Headers
{
  private final Map c;
  private volatile Map d;
  
  LazyHeaders(Map paramMap)
  {
    this.c = Collections.unmodifiableMap(paramMap);
  }
  
  private Map b()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      List localList = (List)localEntry.getValue();
      int i = 0;
      while (i < localList.size())
      {
        localStringBuilder.append(((LazyHeaderFactory)localList.get(i)).a());
        if (i != localList.size() - 1) {
          localStringBuilder.append(',');
        }
        i += 1;
      }
      localHashMap.put(localEntry.getKey(), localStringBuilder.toString());
    }
    return localHashMap;
  }
  
  public Map a()
  {
    if (this.d == null) {}
    try
    {
      if (this.d == null) {
        this.d = Collections.unmodifiableMap(b());
      }
      return this.d;
    }
    finally {}
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof LazyHeaders))
    {
      paramObject = (LazyHeaders)paramObject;
      return this.c.equals(paramObject.c);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    return "LazyHeaders{headers=" + this.c + '}';
  }
}
