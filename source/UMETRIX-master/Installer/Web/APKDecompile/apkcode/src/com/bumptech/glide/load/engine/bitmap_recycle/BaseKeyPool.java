package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import java.util.Queue;

abstract class BaseKeyPool
{
  private final Queue a = Util.a(20);
  
  BaseKeyPool() {}
  
  public void a(Poolable paramPoolable)
  {
    if (this.a.size() < 20) {
      this.a.offer(paramPoolable);
    }
  }
  
  protected abstract Poolable b();
  
  protected Poolable c()
  {
    Poolable localPoolable2 = (Poolable)this.a.poll();
    Poolable localPoolable1 = localPoolable2;
    if (localPoolable2 == null) {
      localPoolable1 = b();
    }
    return localPoolable1;
  }
}
