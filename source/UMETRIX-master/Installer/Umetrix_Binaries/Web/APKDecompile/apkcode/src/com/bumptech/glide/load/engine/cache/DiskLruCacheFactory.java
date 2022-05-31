package com.bumptech.glide.load.engine.cache;

import java.io.File;

public class DiskLruCacheFactory
  implements DiskCache.Factory
{
  private final int a;
  private final DiskLruCacheFactory.CacheDirectoryGetter b;
  
  public DiskLruCacheFactory(DiskLruCacheFactory.CacheDirectoryGetter paramCacheDirectoryGetter, int paramInt)
  {
    this.a = paramInt;
    this.b = paramCacheDirectoryGetter;
  }
  
  public DiskCache a()
  {
    File localFile = this.b.a();
    if (localFile == null) {}
    while ((!localFile.mkdirs()) && ((!localFile.exists()) || (!localFile.isDirectory()))) {
      return null;
    }
    return DiskLruCacheWrapper.a(localFile, this.a);
  }
}
