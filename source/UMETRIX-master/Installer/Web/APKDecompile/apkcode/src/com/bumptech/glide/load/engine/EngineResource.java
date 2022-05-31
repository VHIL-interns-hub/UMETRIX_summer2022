package com.bumptech.glide.load.engine;

import android.os.Looper;
import com.bumptech.glide.load.Key;

class EngineResource
  implements Resource
{
  private final Resource a;
  private final boolean b;
  private EngineResource.ResourceListener c;
  private Key d;
  private int e;
  private boolean f;
  
  EngineResource(Resource paramResource, boolean paramBoolean)
  {
    if (paramResource == null) {
      throw new NullPointerException("Wrapped resource must not be null");
    }
    this.a = paramResource;
    this.b = paramBoolean;
  }
  
  void a(Key paramKey, EngineResource.ResourceListener paramResourceListener)
  {
    this.d = paramKey;
    this.c = paramResourceListener;
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public Object b()
  {
    return this.a.b();
  }
  
  public int c()
  {
    return this.a.c();
  }
  
  public void d()
  {
    if (this.e > 0) {
      throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
    }
    if (this.f) {
      throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
    }
    this.f = true;
    this.a.d();
  }
  
  void e()
  {
    if (this.f) {
      throw new IllegalStateException("Cannot acquire a recycled resource");
    }
    if (!Looper.getMainLooper().equals(Looper.myLooper())) {
      throw new IllegalThreadStateException("Must call acquire on the main thread");
    }
    this.e += 1;
  }
  
  void f()
  {
    if (this.e <= 0) {
      throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
    }
    if (!Looper.getMainLooper().equals(Looper.myLooper())) {
      throw new IllegalThreadStateException("Must call release on the main thread");
    }
    int i = this.e - 1;
    this.e = i;
    if (i == 0) {
      this.c.b(this.d, this);
    }
  }
}
