package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.util.LogTime;

class DecodeJob
{
  private static final DecodeJob.FileOpener a = new DecodeJob.FileOpener();
  private final EngineKey b;
  private final int c;
  private final int d;
  private final DataFetcher e;
  private final DataLoadProvider f;
  private final Transformation g;
  private final ResourceTranscoder h;
  private final DecodeJob.DiskCacheProvider i;
  private final DiskCacheStrategy j;
  private final Priority k;
  private final DecodeJob.FileOpener l;
  private volatile boolean m;
  
  public DecodeJob(EngineKey paramEngineKey, int paramInt1, int paramInt2, DataFetcher paramDataFetcher, DataLoadProvider paramDataLoadProvider, Transformation paramTransformation, ResourceTranscoder paramResourceTranscoder, DecodeJob.DiskCacheProvider paramDiskCacheProvider, DiskCacheStrategy paramDiskCacheStrategy, Priority paramPriority)
  {
    this(paramEngineKey, paramInt1, paramInt2, paramDataFetcher, paramDataLoadProvider, paramTransformation, paramResourceTranscoder, paramDiskCacheProvider, paramDiskCacheStrategy, paramPriority, a);
  }
  
  DecodeJob(EngineKey paramEngineKey, int paramInt1, int paramInt2, DataFetcher paramDataFetcher, DataLoadProvider paramDataLoadProvider, Transformation paramTransformation, ResourceTranscoder paramResourceTranscoder, DecodeJob.DiskCacheProvider paramDiskCacheProvider, DiskCacheStrategy paramDiskCacheStrategy, Priority paramPriority, DecodeJob.FileOpener paramFileOpener)
  {
    this.b = paramEngineKey;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramDataFetcher;
    this.f = paramDataLoadProvider;
    this.g = paramTransformation;
    this.h = paramResourceTranscoder;
    this.i = paramDiskCacheProvider;
    this.j = paramDiskCacheStrategy;
    this.k = paramPriority;
    this.l = paramFileOpener;
  }
  
  private Resource a(Key paramKey)
  {
    Object localObject1 = null;
    Object localObject3 = this.i.a().a(paramKey);
    if (localObject3 == null) {}
    for (;;)
    {
      return localObject1;
      try
      {
        localObject3 = this.f.a().a(localObject3, this.c, this.d);
        localObject1 = localObject3;
        if (localObject3 != null) {
          continue;
        }
        this.i.a().b(paramKey);
        return localObject3;
      }
      finally
      {
        if (0 == 0) {
          this.i.a().b(paramKey);
        }
      }
    }
  }
  
  private Resource a(Resource paramResource)
  {
    long l1 = LogTime.a();
    paramResource = c(paramResource);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Transformed resource from source", l1);
    }
    b(paramResource);
    l1 = LogTime.a();
    paramResource = d(paramResource);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Transcoded transformed from source", l1);
    }
    return paramResource;
  }
  
  private Resource a(Object paramObject)
  {
    if (this.j.a()) {
      paramObject = b(paramObject);
    }
    long l1;
    Resource localResource;
    do
    {
      return paramObject;
      l1 = LogTime.a();
      localResource = this.f.b().a(paramObject, this.c, this.d);
      paramObject = localResource;
    } while (!Log.isLoggable("DecodeJob", 2));
    a("Decoded from source", l1);
    return localResource;
  }
  
  private void a(String paramString, long paramLong)
  {
    Log.v("DecodeJob", paramString + " in " + LogTime.a(paramLong) + ", key: " + this.b);
  }
  
  private Resource b(Object paramObject)
  {
    long l1 = LogTime.a();
    paramObject = new DecodeJob.SourceWriter(this, this.f.c(), paramObject);
    this.i.a().a(this.b.a(), paramObject);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Wrote source to cache", l1);
    }
    l1 = LogTime.a();
    paramObject = a(this.b.a());
    if ((Log.isLoggable("DecodeJob", 2)) && (paramObject != null)) {
      a("Decoded source from cache", l1);
    }
    return paramObject;
  }
  
  private void b(Resource paramResource)
  {
    if ((paramResource == null) || (!this.j.b())) {}
    long l1;
    do
    {
      return;
      l1 = LogTime.a();
      paramResource = new DecodeJob.SourceWriter(this, this.f.d(), paramResource);
      this.i.a().a(this.b, paramResource);
    } while (!Log.isLoggable("DecodeJob", 2));
    a("Wrote transformed from source to cache", l1);
  }
  
  private Resource c(Resource paramResource)
  {
    Object localObject;
    if (paramResource == null) {
      localObject = null;
    }
    Resource localResource;
    do
    {
      return localObject;
      localResource = this.g.a(paramResource, this.c, this.d);
      localObject = localResource;
    } while (paramResource.equals(localResource));
    paramResource.d();
    return localResource;
  }
  
  private Resource d(Resource paramResource)
  {
    if (paramResource == null) {
      return null;
    }
    return this.h.a(paramResource);
  }
  
  private Resource e()
  {
    try
    {
      long l1 = LogTime.a();
      Object localObject1 = this.e.a(this.k);
      if (Log.isLoggable("DecodeJob", 2)) {
        a("Fetched data", l1);
      }
      boolean bool = this.m;
      if (bool) {
        return null;
      }
      localObject1 = a(localObject1);
      return localObject1;
    }
    finally
    {
      this.e.a();
    }
  }
  
  public Resource a()
  {
    Object localObject;
    if (!this.j.b()) {
      localObject = null;
    }
    long l1;
    Resource localResource;
    do
    {
      return localObject;
      l1 = LogTime.a();
      localObject = a(this.b);
      if (Log.isLoggable("DecodeJob", 2)) {
        a("Decoded transformed from cache", l1);
      }
      l1 = LogTime.a();
      localResource = d((Resource)localObject);
      localObject = localResource;
    } while (!Log.isLoggable("DecodeJob", 2));
    a("Transcoded transformed from cache", l1);
    return localResource;
  }
  
  public Resource b()
  {
    if (!this.j.a()) {
      return null;
    }
    long l1 = LogTime.a();
    Resource localResource = a(this.b.a());
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Decoded source from cache", l1);
    }
    return a(localResource);
  }
  
  public Resource c()
  {
    return a(e());
  }
  
  public void d()
  {
    this.m = true;
    this.e.c();
  }
}
