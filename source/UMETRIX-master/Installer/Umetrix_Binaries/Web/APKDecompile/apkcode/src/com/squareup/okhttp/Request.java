package com.squareup.okhttp;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

public final class Request
{
  private final HttpUrl a;
  private final String b;
  private final Headers c;
  private final RequestBody d;
  private final Object e;
  private volatile URL f;
  private volatile URI g;
  private volatile CacheControl h;
  
  private Request(Request.Builder paramBuilder)
  {
    this.a = Request.Builder.a(paramBuilder);
    this.b = Request.Builder.b(paramBuilder);
    this.c = Request.Builder.c(paramBuilder).a();
    this.d = Request.Builder.d(paramBuilder);
    if (Request.Builder.e(paramBuilder) != null) {}
    for (paramBuilder = Request.Builder.e(paramBuilder);; paramBuilder = this)
    {
      this.e = paramBuilder;
      return;
    }
  }
  
  public HttpUrl a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public URL b()
  {
    URL localURL = this.f;
    if (localURL != null) {
      return localURL;
    }
    localURL = this.a.a();
    this.f = localURL;
    return localURL;
  }
  
  public URI c()
  {
    try
    {
      URI localURI = this.g;
      if (localURI != null) {
        return localURI;
      }
      localURI = this.a.b();
      this.g = localURI;
      return localURI;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new IOException(localIllegalStateException.getMessage());
    }
  }
  
  public String d()
  {
    return this.a.toString();
  }
  
  public String e()
  {
    return this.b;
  }
  
  public Headers f()
  {
    return this.c;
  }
  
  public RequestBody g()
  {
    return this.d;
  }
  
  public Request.Builder h()
  {
    return new Request.Builder(this, null);
  }
  
  public CacheControl i()
  {
    CacheControl localCacheControl = this.h;
    if (localCacheControl != null) {
      return localCacheControl;
    }
    localCacheControl = CacheControl.a(this.c);
    this.h = localCacheControl;
    return localCacheControl;
  }
  
  public boolean j()
  {
    return this.a.d();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Request{method=").append(this.b).append(", url=").append(this.a).append(", tag=");
    if (this.e != this) {}
    for (Object localObject = this.e;; localObject = null) {
      return localObject + '}';
    }
  }
}
