package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache
  extends LruCache
  implements MemoryCache
{
  private MemoryCache.ResourceRemovedListener a;
  
  public LruResourceCache(int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(Resource paramResource)
  {
    return paramResource.c();
  }
  
  @SuppressLint({"InlinedApi"})
  public void a(int paramInt)
  {
    if (paramInt >= 60) {
      a();
    }
    while (paramInt < 40) {
      return;
    }
    b(b() / 2);
  }
  
  protected void a(Key paramKey, Resource paramResource)
  {
    if (this.a != null) {
      this.a.b(paramResource);
    }
  }
  
  public void a(MemoryCache.ResourceRemovedListener paramResourceRemovedListener)
  {
    this.a = paramResourceRemovedListener;
  }
}
