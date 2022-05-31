package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class EngineJob
  implements EngineRunnable.EngineRunnableManager
{
  private static final EngineJob.EngineResourceFactory a = new EngineJob.EngineResourceFactory();
  private static final Handler b = new Handler(Looper.getMainLooper(), new EngineJob.MainThreadCallback(null));
  private final List c = new ArrayList();
  private final EngineJob.EngineResourceFactory d;
  private final EngineJobListener e;
  private final Key f;
  private final ExecutorService g;
  private final ExecutorService h;
  private final boolean i;
  private boolean j;
  private Resource k;
  private boolean l;
  private Exception m;
  private boolean n;
  private Set o;
  private EngineRunnable p;
  private EngineResource q;
  private volatile Future r;
  
  public EngineJob(Key paramKey, ExecutorService paramExecutorService1, ExecutorService paramExecutorService2, boolean paramBoolean, EngineJobListener paramEngineJobListener)
  {
    this(paramKey, paramExecutorService1, paramExecutorService2, paramBoolean, paramEngineJobListener, a);
  }
  
  public EngineJob(Key paramKey, ExecutorService paramExecutorService1, ExecutorService paramExecutorService2, boolean paramBoolean, EngineJobListener paramEngineJobListener, EngineJob.EngineResourceFactory paramEngineResourceFactory)
  {
    this.f = paramKey;
    this.g = paramExecutorService1;
    this.h = paramExecutorService2;
    this.i = paramBoolean;
    this.e = paramEngineJobListener;
    this.d = paramEngineResourceFactory;
  }
  
  private void b()
  {
    if (this.j)
    {
      this.k.d();
      return;
    }
    if (this.c.isEmpty()) {
      throw new IllegalStateException("Received a resource without any callbacks to notify");
    }
    this.q = this.d.a(this.k, this.i);
    this.l = true;
    this.q.e();
    this.e.a(this.f, this.q);
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      ResourceCallback localResourceCallback = (ResourceCallback)localIterator.next();
      if (!d(localResourceCallback))
      {
        this.q.e();
        localResourceCallback.a(this.q);
      }
    }
    this.q.f();
  }
  
  private void c()
  {
    if (this.j) {}
    for (;;)
    {
      return;
      if (this.c.isEmpty()) {
        throw new IllegalStateException("Received an exception without any callbacks to notify");
      }
      this.n = true;
      this.e.a(this.f, null);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        ResourceCallback localResourceCallback = (ResourceCallback)localIterator.next();
        if (!d(localResourceCallback)) {
          localResourceCallback.a(this.m);
        }
      }
    }
  }
  
  private void c(ResourceCallback paramResourceCallback)
  {
    if (this.o == null) {
      this.o = new HashSet();
    }
    this.o.add(paramResourceCallback);
  }
  
  private boolean d(ResourceCallback paramResourceCallback)
  {
    return (this.o != null) && (this.o.contains(paramResourceCallback));
  }
  
  void a()
  {
    if ((this.n) || (this.l) || (this.j)) {
      return;
    }
    this.p.a();
    Future localFuture = this.r;
    if (localFuture != null) {
      localFuture.cancel(true);
    }
    this.j = true;
    this.e.a(this, this.f);
  }
  
  public void a(EngineRunnable paramEngineRunnable)
  {
    this.p = paramEngineRunnable;
    this.r = this.g.submit(paramEngineRunnable);
  }
  
  public void a(Resource paramResource)
  {
    this.k = paramResource;
    b.obtainMessage(1, this).sendToTarget();
  }
  
  public void a(ResourceCallback paramResourceCallback)
  {
    
    if (this.l)
    {
      paramResourceCallback.a(this.q);
      return;
    }
    if (this.n)
    {
      paramResourceCallback.a(this.m);
      return;
    }
    this.c.add(paramResourceCallback);
  }
  
  public void a(Exception paramException)
  {
    this.m = paramException;
    b.obtainMessage(2, this).sendToTarget();
  }
  
  public void b(EngineRunnable paramEngineRunnable)
  {
    this.r = this.h.submit(paramEngineRunnable);
  }
  
  public void b(ResourceCallback paramResourceCallback)
  {
    
    if ((this.l) || (this.n)) {
      c(paramResourceCallback);
    }
    do
    {
      return;
      this.c.remove(paramResourceCallback);
    } while (!this.c.isEmpty());
    a();
  }
}
