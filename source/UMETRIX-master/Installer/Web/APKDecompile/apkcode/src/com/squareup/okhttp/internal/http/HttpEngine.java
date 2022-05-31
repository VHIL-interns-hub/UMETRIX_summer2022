package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Date;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;

public final class HttpEngine
{
  private static final ResponseBody e = new HttpEngine.1();
  final OkHttpClient a;
  public final StreamAllocation b;
  long c = -1L;
  public final boolean d;
  private final Response f;
  private HttpStream g;
  private boolean h;
  private final Request i;
  private Request j;
  private Response k;
  private Response l;
  private Sink m;
  private BufferedSink n;
  private final boolean o;
  private final boolean p;
  private CacheRequest q;
  private CacheStrategy r;
  
  public HttpEngine(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, StreamAllocation paramStreamAllocation, RetryableSink paramRetryableSink, Response paramResponse)
  {
    this.a = paramOkHttpClient;
    this.i = paramRequest;
    this.d = paramBoolean1;
    this.o = paramBoolean2;
    this.p = paramBoolean3;
    if (paramStreamAllocation != null) {}
    for (;;)
    {
      this.b = paramStreamAllocation;
      this.m = paramRetryableSink;
      this.f = paramResponse;
      return;
      paramStreamAllocation = new StreamAllocation(paramOkHttpClient.n(), a(paramOkHttpClient, paramRequest));
    }
  }
  
  private static Address a(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    CertificatePinner localCertificatePinner = null;
    SSLSocketFactory localSSLSocketFactory;
    HostnameVerifier localHostnameVerifier;
    if (paramRequest.j())
    {
      localSSLSocketFactory = paramOkHttpClient.j();
      localHostnameVerifier = paramOkHttpClient.k();
      localCertificatePinner = paramOkHttpClient.l();
    }
    for (;;)
    {
      return new Address(paramRequest.a().g(), paramRequest.a().h(), paramOkHttpClient.h(), paramOkHttpClient.i(), localSSLSocketFactory, localHostnameVerifier, localCertificatePinner, paramOkHttpClient.m(), paramOkHttpClient.d(), paramOkHttpClient.r(), paramOkHttpClient.s(), paramOkHttpClient.e());
      localHostnameVerifier = null;
      localSSLSocketFactory = null;
    }
  }
  
  private static Headers a(Headers paramHeaders1, Headers paramHeaders2)
  {
    int i2 = 0;
    Headers.Builder localBuilder = new Headers.Builder();
    int i3 = paramHeaders1.a();
    int i1 = 0;
    if (i1 < i3)
    {
      String str1 = paramHeaders1.a(i1);
      String str2 = paramHeaders1.b(i1);
      if (("Warning".equalsIgnoreCase(str1)) && (str2.startsWith("1"))) {}
      for (;;)
      {
        i1 += 1;
        break;
        if ((!OkHeaders.a(str1)) || (paramHeaders2.a(str1) == null)) {
          localBuilder.a(str1, str2);
        }
      }
    }
    i3 = paramHeaders2.a();
    i1 = i2;
    if (i1 < i3)
    {
      paramHeaders1 = paramHeaders2.a(i1);
      if ("Content-Length".equalsIgnoreCase(paramHeaders1)) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (OkHeaders.a(paramHeaders1)) {
          localBuilder.a(paramHeaders1, paramHeaders2.b(i1));
        }
      }
    }
    return localBuilder.a();
  }
  
  private Response a(CacheRequest paramCacheRequest, Response paramResponse)
  {
    if (paramCacheRequest == null) {}
    Sink localSink;
    do
    {
      return paramResponse;
      localSink = paramCacheRequest.a();
    } while (localSink == null);
    paramCacheRequest = new HttpEngine.2(this, paramResponse.g().c(), paramCacheRequest, Okio.a(localSink));
    return paramResponse.h().a(new RealResponseBody(paramResponse.f(), Okio.a(paramCacheRequest))).a();
  }
  
  public static boolean a(Response paramResponse)
  {
    if (paramResponse.a().e().equals("HEAD")) {}
    do
    {
      return false;
      int i1 = paramResponse.c();
      if (((i1 < 100) || (i1 >= 200)) && (i1 != 204) && (i1 != 304)) {
        return true;
      }
    } while ((OkHeaders.a(paramResponse) == -1L) && (!"chunked".equalsIgnoreCase(paramResponse.a("Transfer-Encoding"))));
    return true;
  }
  
  private static boolean a(Response paramResponse1, Response paramResponse2)
  {
    if (paramResponse2.c() == 304) {}
    do
    {
      return true;
      paramResponse1 = paramResponse1.f().b("Last-Modified");
      if (paramResponse1 == null) {
        break;
      }
      paramResponse2 = paramResponse2.f().b("Last-Modified");
    } while ((paramResponse2 != null) && (paramResponse2.getTime() < paramResponse1.getTime()));
    return false;
  }
  
  private Request b(Request paramRequest)
  {
    Request.Builder localBuilder = paramRequest.h();
    if (paramRequest.a("Host") == null) {
      localBuilder.a("Host", Util.a(paramRequest.a()));
    }
    if (paramRequest.a("Connection") == null) {
      localBuilder.a("Connection", "Keep-Alive");
    }
    if (paramRequest.a("Accept-Encoding") == null)
    {
      this.h = true;
      localBuilder.a("Accept-Encoding", "gzip");
    }
    CookieHandler localCookieHandler = this.a.f();
    if (localCookieHandler != null)
    {
      Map localMap = OkHeaders.a(localBuilder.a().f(), null);
      OkHeaders.a(localBuilder, localCookieHandler.get(paramRequest.c(), localMap));
    }
    if (paramRequest.a("User-Agent") == null) {
      localBuilder.a("User-Agent", Version.a());
    }
    return localBuilder.a();
  }
  
  private static Response b(Response paramResponse)
  {
    Response localResponse = paramResponse;
    if (paramResponse != null)
    {
      localResponse = paramResponse;
      if (paramResponse.g() != null) {
        localResponse = paramResponse.h().a(null).a();
      }
    }
    return localResponse;
  }
  
  private Response c(Response paramResponse)
  {
    if ((!this.h) || (!"gzip".equalsIgnoreCase(this.l.a("Content-Encoding")))) {}
    while (paramResponse.g() == null) {
      return paramResponse;
    }
    GzipSource localGzipSource = new GzipSource(paramResponse.g().c());
    Headers localHeaders = paramResponse.f().b().b("Content-Encoding").b("Content-Length").a();
    return paramResponse.h().a(localHeaders).a(new RealResponseBody(localHeaders, Okio.a(localGzipSource))).a();
  }
  
  private HttpStream m()
  {
    if (!this.j.e().equals("GET")) {}
    for (boolean bool = true;; bool = false) {
      return this.b.a(this.a.a(), this.a.b(), this.a.c(), this.a.q(), bool);
    }
  }
  
  private void n()
  {
    InternalCache localInternalCache = Internal.b.a(this.a);
    if (localInternalCache == null) {}
    do
    {
      return;
      if (CacheStrategy.a(this.l, this.j)) {
        break;
      }
    } while (!HttpMethod.a(this.j.e()));
    try
    {
      localInternalCache.b(this.j);
      return;
    }
    catch (IOException localIOException)
    {
      return;
    }
    this.q = localIOException.a(b(this.l));
  }
  
  private Response o()
  {
    this.g.c();
    Response localResponse2 = this.g.b().a(this.j).a(this.b.a().b()).a(OkHeaders.b, Long.toString(this.c)).a(OkHeaders.c, Long.toString(System.currentTimeMillis())).a();
    Response localResponse1 = localResponse2;
    if (!this.p) {
      localResponse1 = localResponse2.h().a(this.g.a(localResponse2)).a();
    }
    if (("close".equalsIgnoreCase(localResponse1.a().a("Connection"))) || ("close".equalsIgnoreCase(localResponse1.a("Connection")))) {
      this.b.c();
    }
    return localResponse1;
  }
  
  public HttpEngine a(RouteException paramRouteException)
  {
    if (!this.b.a(paramRouteException)) {}
    while (!this.a.q()) {
      return null;
    }
    paramRouteException = j();
    return new HttpEngine(this.a, this.i, this.d, this.o, this.p, paramRouteException, (RetryableSink)this.m, this.f);
  }
  
  public HttpEngine a(IOException paramIOException)
  {
    return a(paramIOException, this.m);
  }
  
  public HttpEngine a(IOException paramIOException, Sink paramSink)
  {
    if (!this.b.a(paramIOException, paramSink)) {}
    while (!this.a.q()) {
      return null;
    }
    paramIOException = j();
    return new HttpEngine(this.a, this.i, this.d, this.o, this.p, paramIOException, (RetryableSink)paramSink, this.f);
  }
  
  public void a()
  {
    if (this.r != null) {
      return;
    }
    if (this.g != null) {
      throw new IllegalStateException();
    }
    Request localRequest = b(this.i);
    InternalCache localInternalCache = Internal.b.a(this.a);
    if (localInternalCache != null) {}
    long l1;
    for (Response localResponse = localInternalCache.a(localRequest);; localResponse = null)
    {
      this.r = new CacheStrategy.Factory(System.currentTimeMillis(), localRequest, localResponse).a();
      this.j = this.r.a;
      this.k = this.r.b;
      if (localInternalCache != null) {
        localInternalCache.a(this.r);
      }
      if ((localResponse != null) && (this.k == null)) {
        Util.a(localResponse.g());
      }
      if (this.j == null) {
        break label302;
      }
      this.g = m();
      this.g.a(this);
      if ((!this.o) || (!a(this.j)) || (this.m != null)) {
        break;
      }
      l1 = OkHeaders.a(localRequest);
      if (!this.d) {
        break label270;
      }
      if (l1 <= 2147483647L) {
        break label223;
      }
      throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
    }
    label223:
    if (l1 != -1L)
    {
      this.g.a(this.j);
      this.m = new RetryableSink((int)l1);
      return;
    }
    this.m = new RetryableSink();
    return;
    label270:
    this.g.a(this.j);
    this.m = this.g.a(this.j, l1);
    return;
    label302:
    if (this.k != null) {}
    for (this.l = this.k.h().a(this.i).c(b(this.f)).b(b(this.k)).a();; this.l = new Response.Builder().a(this.i).c(b(this.f)).a(Protocol.b).a(504).a("Unsatisfiable Request (only-if-cached)").a(e).a())
    {
      this.l = c(this.l);
      return;
    }
  }
  
  public void a(Headers paramHeaders)
  {
    CookieHandler localCookieHandler = this.a.f();
    if (localCookieHandler != null) {
      localCookieHandler.put(this.i.c(), OkHeaders.a(paramHeaders, null));
    }
  }
  
  public boolean a(HttpUrl paramHttpUrl)
  {
    HttpUrl localHttpUrl = this.i.a();
    return (localHttpUrl.g().equals(paramHttpUrl.g())) && (localHttpUrl.h() == paramHttpUrl.h()) && (localHttpUrl.c().equals(paramHttpUrl.c()));
  }
  
  boolean a(Request paramRequest)
  {
    return HttpMethod.c(paramRequest.e());
  }
  
  public void b()
  {
    if (this.c != -1L) {
      throw new IllegalStateException();
    }
    this.c = System.currentTimeMillis();
  }
  
  public Sink c()
  {
    if (this.r == null) {
      throw new IllegalStateException();
    }
    return this.m;
  }
  
  public BufferedSink d()
  {
    Object localObject = this.n;
    if (localObject != null) {
      return localObject;
    }
    localObject = c();
    if (localObject != null)
    {
      localObject = Okio.a((Sink)localObject);
      this.n = ((BufferedSink)localObject);
      return localObject;
    }
    return null;
  }
  
  public boolean e()
  {
    return this.l != null;
  }
  
  public Response f()
  {
    if (this.l == null) {
      throw new IllegalStateException();
    }
    return this.l;
  }
  
  public Connection g()
  {
    return this.b.a();
  }
  
  public void h()
  {
    this.b.b();
  }
  
  public void i()
  {
    this.b.d();
  }
  
  public StreamAllocation j()
  {
    if (this.n != null)
    {
      Util.a(this.n);
      if (this.l == null) {
        break label53;
      }
      Util.a(this.l.g());
    }
    for (;;)
    {
      return this.b;
      if (this.m == null) {
        break;
      }
      Util.a(this.m);
      break;
      label53:
      this.b.e();
    }
  }
  
  public void k()
  {
    if (this.l != null) {}
    label418:
    label430:
    label440:
    do
    {
      do
      {
        return;
        if ((this.j == null) && (this.k == null)) {
          throw new IllegalStateException("call sendRequest() first!");
        }
      } while (this.j == null);
      if (this.p) {
        this.g.a(this.j);
      }
      for (Object localObject = o();; localObject = new HttpEngine.NetworkInterceptorChain(this, 0, this.j).a(this.j))
      {
        a(((Response)localObject).f());
        if (this.k == null) {
          break label440;
        }
        if (!a(this.k, (Response)localObject)) {
          break label430;
        }
        this.l = this.k.h().a(this.i).c(b(this.f)).a(a(this.k.f(), ((Response)localObject).f())).b(b(this.k)).a(b((Response)localObject)).a();
        ((Response)localObject).g().close();
        h();
        localObject = Internal.b.a(this.a);
        ((InternalCache)localObject).a();
        ((InternalCache)localObject).a(this.k, b(this.l));
        this.l = c(this.l);
        return;
        if (this.o) {
          break;
        }
      }
      if ((this.n != null) && (this.n.c().b() > 0L)) {
        this.n.f();
      }
      if (this.c == -1L)
      {
        if ((OkHeaders.a(this.j) == -1L) && ((this.m instanceof RetryableSink)))
        {
          long l1 = ((RetryableSink)this.m).b();
          this.j = this.j.h().a("Content-Length", Long.toString(l1)).a();
        }
        this.g.a(this.j);
      }
      if (this.m != null)
      {
        if (this.n == null) {
          break label418;
        }
        this.n.close();
      }
      for (;;)
      {
        if ((this.m instanceof RetryableSink)) {
          this.g.a((RetryableSink)this.m);
        }
        localObject = o();
        break;
        this.m.close();
      }
      Util.a(this.k.g());
      this.l = ((Response)localObject).h().a(this.i).c(b(this.f)).b(b(this.k)).a(b((Response)localObject)).a();
    } while (!a(this.l));
    n();
    this.l = c(a(this.q, this.l));
  }
  
  public Request l()
  {
    if (this.l == null) {
      throw new IllegalStateException();
    }
    Object localObject = this.b.a();
    if (localObject != null)
    {
      localObject = ((Connection)localObject).a();
      label34:
      if (localObject == null) {
        break label143;
      }
    }
    String str;
    label143:
    for (localObject = ((Route)localObject).b();; localObject = this.a.d())
    {
      int i1 = this.l.c();
      str = this.i.e();
      switch (i1)
      {
      default: 
        return null;
        localObject = null;
        break label34;
      }
    }
    if (((Proxy)localObject).type() != Proxy.Type.HTTP) {
      throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    }
    return OkHeaders.a(this.a.m(), this.l, (Proxy)localObject);
    if ((!str.equals("GET")) && (!str.equals("HEAD"))) {
      return null;
    }
    if (!this.a.p()) {
      return null;
    }
    localObject = this.l.a("Location");
    if (localObject == null) {
      return null;
    }
    localObject = this.i.a().c((String)localObject);
    if (localObject == null) {
      return null;
    }
    if ((!((HttpUrl)localObject).c().equals(this.i.a().c())) && (!this.a.o())) {
      return null;
    }
    Request.Builder localBuilder = this.i.h();
    if (HttpMethod.c(str))
    {
      if (!HttpMethod.d(str)) {
        break label376;
      }
      localBuilder.a("GET", null);
    }
    for (;;)
    {
      localBuilder.a("Transfer-Encoding");
      localBuilder.a("Content-Length");
      localBuilder.a("Content-Type");
      if (!a((HttpUrl)localObject)) {
        localBuilder.a("Authorization");
      }
      return localBuilder.a((HttpUrl)localObject).a();
      label376:
      localBuilder.a(str, null);
    }
  }
}
