package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;

public class ModelCache
{
  private final LruCache a;
  
  public ModelCache()
  {
    this(250);
  }
  
  public ModelCache(int paramInt)
  {
    this.a = new ModelCache.1(this, paramInt);
  }
  
  public Object a(Object paramObject, int paramInt1, int paramInt2)
  {
    paramObject = ModelCache.ModelKey.a(paramObject, paramInt1, paramInt2);
    Object localObject = this.a.b(paramObject);
    paramObject.a();
    return localObject;
  }
  
  public void a(Object paramObject1, int paramInt1, int paramInt2, Object paramObject2)
  {
    paramObject1 = ModelCache.ModelKey.a(paramObject1, paramInt1, paramInt2);
    this.a.b(paramObject1, paramObject2);
  }
}
