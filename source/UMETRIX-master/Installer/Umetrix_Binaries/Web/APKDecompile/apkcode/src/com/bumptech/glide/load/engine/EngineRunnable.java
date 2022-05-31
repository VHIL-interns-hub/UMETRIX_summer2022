package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.executor.Prioritized;

class EngineRunnable
  implements Prioritized, Runnable
{
  private final Priority a;
  private final EngineRunnable.EngineRunnableManager b;
  private final DecodeJob c;
  private EngineRunnable.Stage d;
  private volatile boolean e;
  
  public EngineRunnable(EngineRunnable.EngineRunnableManager paramEngineRunnableManager, DecodeJob paramDecodeJob, Priority paramPriority)
  {
    this.b = paramEngineRunnableManager;
    this.c = paramDecodeJob;
    this.d = EngineRunnable.Stage.a;
    this.a = paramPriority;
  }
  
  private void a(Resource paramResource)
  {
    this.b.a(paramResource);
  }
  
  private void a(Exception paramException)
  {
    if (c())
    {
      this.d = EngineRunnable.Stage.b;
      this.b.b(this);
      return;
    }
    this.b.a(paramException);
  }
  
  private boolean c()
  {
    return this.d == EngineRunnable.Stage.a;
  }
  
  private Resource d()
  {
    if (c()) {
      return e();
    }
    return f();
  }
  
  private Resource e()
  {
    try
    {
      Resource localResource1 = this.c.a();
      Resource localResource2 = localResource1;
      if (localResource1 == null) {
        localResource2 = this.c.b();
      }
      return localResource2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (Log.isLoggable("EngineRunnable", 3)) {
          Log.d("EngineRunnable", "Exception decoding result from cache: " + localException);
        }
        Object localObject = null;
      }
    }
  }
  
  private Resource f()
  {
    return this.c.c();
  }
  
  public void a()
  {
    this.e = true;
    this.c.d();
  }
  
  public int b()
  {
    return this.a.ordinal();
  }
  
  public void run()
  {
    Object localObject = null;
    if (this.e) {}
    for (;;)
    {
      return;
      try
      {
        localResource = d();
        if (this.e)
        {
          if (localResource == null) {
            continue;
          }
          localResource.d();
        }
      }
      catch (Exception localException)
      {
        Resource localResource;
        for (;;)
        {
          if (Log.isLoggable("EngineRunnable", 2)) {
            Log.v("EngineRunnable", "Exception decoding", localException);
          }
          localResource = null;
        }
        if (localResource == null)
        {
          a(localException);
          return;
        }
        a(localResource);
      }
    }
  }
}
