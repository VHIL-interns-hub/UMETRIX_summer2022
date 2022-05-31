package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public abstract interface MemoryCache
{
  public abstract Resource a(Key paramKey);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(MemoryCache.ResourceRemovedListener paramResourceRemovedListener);
  
  public abstract Resource b(Key paramKey, Resource paramResource);
}
