package com.bumptech.glide.manager;

import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

class ActivityFragmentLifecycle
  implements Lifecycle
{
  private final Set a = Collections.newSetFromMap(new WeakHashMap());
  private boolean b;
  private boolean c;
  
  ActivityFragmentLifecycle() {}
  
  void a()
  {
    this.b = true;
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((LifecycleListener)localIterator.next()).d();
    }
  }
  
  public void a(LifecycleListener paramLifecycleListener)
  {
    this.a.add(paramLifecycleListener);
    if (this.c)
    {
      paramLifecycleListener.f();
      return;
    }
    if (this.b)
    {
      paramLifecycleListener.d();
      return;
    }
    paramLifecycleListener.e();
  }
  
  void b()
  {
    this.b = false;
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((LifecycleListener)localIterator.next()).e();
    }
  }
  
  void c()
  {
    this.c = true;
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((LifecycleListener)localIterator.next()).f();
    }
  }
}
