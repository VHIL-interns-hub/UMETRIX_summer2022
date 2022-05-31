package com.bumptech.glide.request;

public class ThumbnailRequestCoordinator
  implements Request, RequestCoordinator
{
  private Request a;
  private Request b;
  private RequestCoordinator c;
  
  public ThumbnailRequestCoordinator()
  {
    this(null);
  }
  
  public ThumbnailRequestCoordinator(RequestCoordinator paramRequestCoordinator)
  {
    this.c = paramRequestCoordinator;
  }
  
  private boolean j()
  {
    return (this.c == null) || (this.c.a(this));
  }
  
  private boolean k()
  {
    return (this.c == null) || (this.c.b(this));
  }
  
  private boolean l()
  {
    return (this.c != null) && (this.c.c());
  }
  
  public void a()
  {
    this.a.a();
    this.b.a();
  }
  
  public void a(Request paramRequest1, Request paramRequest2)
  {
    this.a = paramRequest1;
    this.b = paramRequest2;
  }
  
  public boolean a(Request paramRequest)
  {
    return (j()) && ((paramRequest.equals(this.a)) || (!this.a.h()));
  }
  
  public void b()
  {
    if (!this.b.f()) {
      this.b.b();
    }
    if (!this.a.f()) {
      this.a.b();
    }
  }
  
  public boolean b(Request paramRequest)
  {
    return (k()) && (paramRequest.equals(this.a)) && (!c());
  }
  
  public void c(Request paramRequest)
  {
    if (paramRequest.equals(this.b)) {}
    do
    {
      return;
      if (this.c != null) {
        this.c.c(this);
      }
    } while (this.b.g());
    this.b.d();
  }
  
  public boolean c()
  {
    return (l()) || (h());
  }
  
  public void d()
  {
    this.b.d();
    this.a.d();
  }
  
  public void e()
  {
    this.a.e();
    this.b.e();
  }
  
  public boolean f()
  {
    return this.a.f();
  }
  
  public boolean g()
  {
    return (this.a.g()) || (this.b.g());
  }
  
  public boolean h()
  {
    return (this.a.h()) || (this.b.h());
  }
  
  public boolean i()
  {
    return this.a.i();
  }
}
