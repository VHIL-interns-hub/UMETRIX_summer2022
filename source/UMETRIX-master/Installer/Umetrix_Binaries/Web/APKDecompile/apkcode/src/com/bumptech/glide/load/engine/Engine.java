package com.bumptech.glide.load.engine;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class Engine
  implements EngineJobListener, EngineResource.ResourceListener, MemoryCache.ResourceRemovedListener
{
  private final Map a;
  private final EngineKeyFactory b;
  private final MemoryCache c;
  private final Engine.EngineJobFactory d;
  private final Map e;
  private final ResourceRecycler f;
  private final Engine.LazyDiskCacheProvider g;
  private ReferenceQueue h;
  
  public Engine(MemoryCache paramMemoryCache, DiskCache.Factory paramFactory, ExecutorService paramExecutorService1, ExecutorService paramExecutorService2)
  {
    this(paramMemoryCache, paramFactory, paramExecutorService1, paramExecutorService2, null, null, null, null, null);
  }
  
  Engine(MemoryCache paramMemoryCache, DiskCache.Factory paramFactory, ExecutorService paramExecutorService1, ExecutorService paramExecutorService2, Map paramMap1, EngineKeyFactory paramEngineKeyFactory, Map paramMap2, Engine.EngineJobFactory paramEngineJobFactory, ResourceRecycler paramResourceRecycler)
  {
    this.c = paramMemoryCache;
    this.g = new Engine.LazyDiskCacheProvider(paramFactory);
    paramFactory = paramMap2;
    if (paramMap2 == null) {
      paramFactory = new HashMap();
    }
    this.e = paramFactory;
    paramFactory = paramEngineKeyFactory;
    if (paramEngineKeyFactory == null) {
      paramFactory = new EngineKeyFactory();
    }
    this.b = paramFactory;
    paramFactory = paramMap1;
    if (paramMap1 == null) {
      paramFactory = new HashMap();
    }
    this.a = paramFactory;
    paramFactory = paramEngineJobFactory;
    if (paramEngineJobFactory == null) {
      paramFactory = new Engine.EngineJobFactory(paramExecutorService1, paramExecutorService2, this);
    }
    this.d = paramFactory;
    paramFactory = paramResourceRecycler;
    if (paramResourceRecycler == null) {
      paramFactory = new ResourceRecycler();
    }
    this.f = paramFactory;
    paramMemoryCache.a(this);
  }
  
  private EngineResource a(Key paramKey)
  {
    paramKey = this.c.a(paramKey);
    if (paramKey == null) {
      return null;
    }
    if ((paramKey instanceof EngineResource)) {
      return (EngineResource)paramKey;
    }
    return new EngineResource(paramKey, true);
  }
  
  private EngineResource a(Key paramKey, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return null;
    }
    Object localObject = (WeakReference)this.e.get(paramKey);
    if (localObject != null)
    {
      localObject = (EngineResource)((WeakReference)localObject).get();
      if (localObject != null)
      {
        ((EngineResource)localObject).e();
        paramKey = (Key)localObject;
      }
    }
    for (;;)
    {
      return paramKey;
      this.e.remove(paramKey);
      paramKey = (Key)localObject;
      continue;
      paramKey = null;
    }
  }
  
  private ReferenceQueue a()
  {
    if (this.h == null)
    {
      this.h = new ReferenceQueue();
      Looper.myQueue().addIdleHandler(new Engine.RefQueueIdleHandler(this.e, this.h));
    }
    return this.h;
  }
  
  private static void a(String paramString, long paramLong, Key paramKey)
  {
    Log.v("Engine", paramString + " in " + LogTime.a(paramLong) + "ms, key: " + paramKey);
  }
  
  private EngineResource b(Key paramKey, boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean) {
      localObject = null;
    }
    EngineResource localEngineResource;
    do
    {
      return localObject;
      localEngineResource = a(paramKey);
      localObject = localEngineResource;
    } while (localEngineResource == null);
    localEngineResource.e();
    this.e.put(paramKey, new Engine.ResourceWeakReference(paramKey, localEngineResource, a()));
    return localEngineResource;
  }
  
  public Engine.LoadStatus a(Key paramKey, int paramInt1, int paramInt2, DataFetcher paramDataFetcher, DataLoadProvider paramDataLoadProvider, Transformation paramTransformation, ResourceTranscoder paramResourceTranscoder, Priority paramPriority, boolean paramBoolean, DiskCacheStrategy paramDiskCacheStrategy, ResourceCallback paramResourceCallback)
  {
    Util.a();
    long l = LogTime.a();
    Object localObject = paramDataFetcher.b();
    paramKey = this.b.a((String)localObject, paramKey, paramInt1, paramInt2, paramDataLoadProvider.a(), paramDataLoadProvider.b(), paramTransformation, paramDataLoadProvider.d(), paramResourceTranscoder, paramDataLoadProvider.c());
    localObject = b(paramKey, paramBoolean);
    if (localObject != null)
    {
      paramResourceCallback.a((Resource)localObject);
      if (Log.isLoggable("Engine", 2)) {
        a("Loaded resource from cache", l, paramKey);
      }
      return null;
    }
    localObject = a(paramKey, paramBoolean);
    if (localObject != null)
    {
      paramResourceCallback.a((Resource)localObject);
      if (Log.isLoggable("Engine", 2)) {
        a("Loaded resource from active resources", l, paramKey);
      }
      return null;
    }
    localObject = (EngineJob)this.a.get(paramKey);
    if (localObject != null)
    {
      ((EngineJob)localObject).a(paramResourceCallback);
      if (Log.isLoggable("Engine", 2)) {
        a("Added to existing load", l, paramKey);
      }
      return new Engine.LoadStatus(paramResourceCallback, (EngineJob)localObject);
    }
    localObject = this.d.a(paramKey, paramBoolean);
    paramDataFetcher = new EngineRunnable((EngineRunnable.EngineRunnableManager)localObject, new DecodeJob(paramKey, paramInt1, paramInt2, paramDataFetcher, paramDataLoadProvider, paramTransformation, paramResourceTranscoder, this.g, paramDiskCacheStrategy, paramPriority), paramPriority);
    this.a.put(paramKey, localObject);
    ((EngineJob)localObject).a(paramResourceCallback);
    ((EngineJob)localObject).a(paramDataFetcher);
    if (Log.isLoggable("Engine", 2)) {
      a("Started new load", l, paramKey);
    }
    return new Engine.LoadStatus(paramResourceCallback, (EngineJob)localObject);
  }
  
  public void a(Key paramKey, EngineResource paramEngineResource)
  {
    
    if (paramEngineResource != null)
    {
      paramEngineResource.a(paramKey, this);
      if (paramEngineResource.a()) {
        this.e.put(paramKey, new Engine.ResourceWeakReference(paramKey, paramEngineResource, a()));
      }
    }
    this.a.remove(paramKey);
  }
  
  public void a(EngineJob paramEngineJob, Key paramKey)
  {
    
    if (paramEngineJob.equals((EngineJob)this.a.get(paramKey))) {
      this.a.remove(paramKey);
    }
  }
  
  public void a(Resource paramResource)
  {
    
    if ((paramResource instanceof EngineResource))
    {
      ((EngineResource)paramResource).f();
      return;
    }
    throw new IllegalArgumentException("Cannot release anything but an EngineResource");
  }
  
  public void b(Key paramKey, EngineResource paramEngineResource)
  {
    Util.a();
    this.e.remove(paramKey);
    if (paramEngineResource.a())
    {
      this.c.b(paramKey, paramEngineResource);
      return;
    }
    this.f.a(paramEngineResource);
  }
  
  public void b(Resource paramResource)
  {
    Util.a();
    this.f.a(paramResource);
  }
}
