package com.bumptech.glide.manager;

import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker
{
  private final Set a = Collections.newSetFromMap(new WeakHashMap());
  private final List b = new ArrayList();
  private boolean c;
  
  public RequestTracker() {}
  
  public void a()
  {
    this.c = true;
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      Request localRequest = (Request)localIterator.next();
      if (localRequest.f())
      {
        localRequest.e();
        this.b.add(localRequest);
      }
    }
  }
  
  public void a(Request paramRequest)
  {
    this.a.add(paramRequest);
    if (!this.c)
    {
      paramRequest.b();
      return;
    }
    this.b.add(paramRequest);
  }
  
  public void b()
  {
    this.c = false;
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      Request localRequest = (Request)localIterator.next();
      if ((!localRequest.g()) && (!localRequest.i()) && (!localRequest.f())) {
        localRequest.b();
      }
    }
    this.b.clear();
  }
  
  public void b(Request paramRequest)
  {
    this.a.remove(paramRequest);
    this.b.remove(paramRequest);
  }
  
  public void c()
  {
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((Request)localIterator.next()).d();
    }
    this.b.clear();
  }
  
  public void d()
  {
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      Request localRequest = (Request)localIterator.next();
      if ((!localRequest.g()) && (!localRequest.i()))
      {
        localRequest.e();
        if (!this.c) {
          localRequest.b();
        } else {
          this.b.add(localRequest);
        }
      }
    }
  }
}
