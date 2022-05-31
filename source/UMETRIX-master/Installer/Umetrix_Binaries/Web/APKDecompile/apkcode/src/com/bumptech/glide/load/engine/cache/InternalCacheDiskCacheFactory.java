package com.bumptech.glide.load.engine.cache;

import android.content.Context;

public final class InternalCacheDiskCacheFactory
  extends DiskLruCacheFactory
{
  public InternalCacheDiskCacheFactory(Context paramContext)
  {
    this(paramContext, "image_manager_disk_cache", 262144000);
  }
  
  public InternalCacheDiskCacheFactory(Context paramContext, String paramString, int paramInt)
  {
    super(new InternalCacheDiskCacheFactory.1(paramContext, paramString), paramInt);
  }
}
