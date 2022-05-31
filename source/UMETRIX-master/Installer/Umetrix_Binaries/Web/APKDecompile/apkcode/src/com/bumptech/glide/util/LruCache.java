package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LruCache
{
  private final LinkedHashMap a = new LinkedHashMap(100, 0.75F, true);
  private int b;
  private final int c;
  private int d = 0;
  
  public LruCache(int paramInt)
  {
    this.c = paramInt;
    this.b = paramInt;
  }
  
  private void c()
  {
    b(this.b);
  }
  
  protected int a(Object paramObject)
  {
    return 1;
  }
  
  public void a()
  {
    b(0);
  }
  
  protected void a(Object paramObject1, Object paramObject2) {}
  
  public int b()
  {
    return this.d;
  }
  
  public Object b(Object paramObject)
  {
    return this.a.get(paramObject);
  }
  
  public Object b(Object paramObject1, Object paramObject2)
  {
    if (a(paramObject2) >= this.b)
    {
      a(paramObject1, paramObject2);
      return null;
    }
    paramObject1 = this.a.put(paramObject1, paramObject2);
    if (paramObject2 != null) {
      this.d += a(paramObject2);
    }
    if (paramObject1 != null) {
      this.d -= a(paramObject1);
    }
    c();
    return paramObject1;
  }
  
  protected void b(int paramInt)
  {
    while (this.d > paramInt)
    {
      Object localObject2 = (Map.Entry)this.a.entrySet().iterator().next();
      Object localObject1 = ((Map.Entry)localObject2).getValue();
      this.d -= a(localObject1);
      localObject2 = ((Map.Entry)localObject2).getKey();
      this.a.remove(localObject2);
      a(localObject2, localObject1);
    }
  }
  
  public Object c(Object paramObject)
  {
    paramObject = this.a.remove(paramObject);
    if (paramObject != null) {
      this.d -= a(paramObject);
    }
    return paramObject;
  }
}
