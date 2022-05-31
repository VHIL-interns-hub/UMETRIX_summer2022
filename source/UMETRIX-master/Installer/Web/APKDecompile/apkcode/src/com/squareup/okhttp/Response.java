package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.OkHeaders;
import java.util.Collections;
import java.util.List;

public final class Response
{
  private final Request a;
  private final Protocol b;
  private final int c;
  private final String d;
  private final Handshake e;
  private final Headers f;
  private final ResponseBody g;
  private Response h;
  private Response i;
  private final Response j;
  private volatile CacheControl k;
  
  private Response(Response.Builder paramBuilder)
  {
    this.a = Response.Builder.a(paramBuilder);
    this.b = Response.Builder.b(paramBuilder);
    this.c = Response.Builder.c(paramBuilder);
    this.d = Response.Builder.d(paramBuilder);
    this.e = Response.Builder.e(paramBuilder);
    this.f = Response.Builder.f(paramBuilder).a();
    this.g = Response.Builder.g(paramBuilder);
    this.h = Response.Builder.h(paramBuilder);
    this.i = Response.Builder.i(paramBuilder);
    this.j = Response.Builder.j(paramBuilder);
  }
  
  public Request a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    return a(paramString, null);
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = this.f.a(paramString1);
    if (paramString1 != null) {
      paramString2 = paramString1;
    }
    return paramString2;
  }
  
  public Protocol b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public Handshake e()
  {
    return this.e;
  }
  
  public Headers f()
  {
    return this.f;
  }
  
  public ResponseBody g()
  {
    return this.g;
  }
  
  public Response.Builder h()
  {
    return new Response.Builder(this, null);
  }
  
  public Response i()
  {
    return this.h;
  }
  
  public Response j()
  {
    return this.i;
  }
  
  public List k()
  {
    if (this.c == 401) {}
    for (String str = "WWW-Authenticate";; str = "Proxy-Authenticate")
    {
      return OkHeaders.b(f(), str);
      if (this.c != 407) {
        break;
      }
    }
    return Collections.emptyList();
  }
  
  public CacheControl l()
  {
    CacheControl localCacheControl = this.k;
    if (localCacheControl != null) {
      return localCacheControl;
    }
    localCacheControl = CacheControl.a(this.f);
    this.k = localCacheControl;
    return localCacheControl;
  }
  
  public String toString()
  {
    return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.d() + '}';
  }
}
