package com.squareup.okhttp;

import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.AuthenticatorAdapter;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public class OkHttpClient
  implements Cloneable
{
  private static final List a = Util.a(new Protocol[] { Protocol.d, Protocol.c, Protocol.b });
  private static final List b = Util.a(new ConnectionSpec[] { ConnectionSpec.a, ConnectionSpec.b, ConnectionSpec.c });
  private static SSLSocketFactory c;
  private int A = 10000;
  private final RouteDatabase d;
  private Dispatcher e;
  private Proxy f;
  private List g;
  private List h;
  private final List i = new ArrayList();
  private final List j = new ArrayList();
  private ProxySelector k;
  private CookieHandler l;
  private InternalCache m;
  private Cache n;
  private SocketFactory o;
  private SSLSocketFactory p;
  private HostnameVerifier q;
  private CertificatePinner r;
  private Authenticator s;
  private ConnectionPool t;
  private Dns u;
  private boolean v = true;
  private boolean w = true;
  private boolean x = true;
  private int y = 10000;
  private int z = 10000;
  
  static
  {
    com.squareup.okhttp.internal.Internal.b = new OkHttpClient.1();
  }
  
  public OkHttpClient()
  {
    this.d = new RouteDatabase();
    this.e = new Dispatcher();
  }
  
  private OkHttpClient(OkHttpClient paramOkHttpClient)
  {
    this.d = paramOkHttpClient.d;
    this.e = paramOkHttpClient.e;
    this.f = paramOkHttpClient.f;
    this.g = paramOkHttpClient.g;
    this.h = paramOkHttpClient.h;
    this.i.addAll(paramOkHttpClient.i);
    this.j.addAll(paramOkHttpClient.j);
    this.k = paramOkHttpClient.k;
    this.l = paramOkHttpClient.l;
    this.n = paramOkHttpClient.n;
    if (this.n != null) {}
    for (InternalCache localInternalCache = this.n.a;; localInternalCache = paramOkHttpClient.m)
    {
      this.m = localInternalCache;
      this.o = paramOkHttpClient.o;
      this.p = paramOkHttpClient.p;
      this.q = paramOkHttpClient.q;
      this.r = paramOkHttpClient.r;
      this.s = paramOkHttpClient.s;
      this.t = paramOkHttpClient.t;
      this.u = paramOkHttpClient.u;
      this.v = paramOkHttpClient.v;
      this.w = paramOkHttpClient.w;
      this.x = paramOkHttpClient.x;
      this.y = paramOkHttpClient.y;
      this.z = paramOkHttpClient.z;
      this.A = paramOkHttpClient.A;
      return;
    }
  }
  
  /* Error */
  private SSLSocketFactory w()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 164	com/squareup/okhttp/OkHttpClient:c	Ljavax/net/ssl/SSLSocketFactory;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull +23 -> 30
    //   10: ldc -90
    //   12: invokestatic 172	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   15: astore_1
    //   16: aload_1
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 176	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   23: aload_1
    //   24: invokevirtual 179	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   27: putstatic 164	com/squareup/okhttp/OkHttpClient:c	Ljavax/net/ssl/SSLSocketFactory;
    //   30: getstatic 164	com/squareup/okhttp/OkHttpClient:c	Ljavax/net/ssl/SSLSocketFactory;
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: areturn
    //   38: astore_1
    //   39: new 181	java/lang/AssertionError
    //   42: dup
    //   43: invokespecial 182	java/lang/AssertionError:<init>	()V
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	OkHttpClient
    //   5	32	1	localObject1	Object
    //   38	1	1	localGeneralSecurityException	java.security.GeneralSecurityException
    //   47	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	30	38	java/security/GeneralSecurityException
    //   2	6	47	finally
    //   10	30	47	finally
    //   30	34	47	finally
    //   39	47	47	finally
  }
  
  public int a()
  {
    return this.y;
  }
  
  public OkHttpClient a(Cache paramCache)
  {
    this.n = paramCache;
    this.m = null;
    return this;
  }
  
  public OkHttpClient a(Proxy paramProxy)
  {
    this.f = paramProxy;
    return this;
  }
  
  public OkHttpClient a(List paramList)
  {
    paramList = Util.a(paramList);
    if (!paramList.contains(Protocol.b)) {
      throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + paramList);
    }
    if (paramList.contains(Protocol.a)) {
      throw new IllegalArgumentException("protocols must not contain http/1.0: " + paramList);
    }
    if (paramList.contains(null)) {
      throw new IllegalArgumentException("protocols must not contain null");
    }
    this.g = Util.a(paramList);
    return this;
  }
  
  public OkHttpClient a(HostnameVerifier paramHostnameVerifier)
  {
    this.q = paramHostnameVerifier;
    return this;
  }
  
  public OkHttpClient a(SSLSocketFactory paramSSLSocketFactory)
  {
    this.p = paramSSLSocketFactory;
    return this;
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    long l1 = paramTimeUnit.toMillis(paramLong);
    if (l1 > 2147483647L) {
      throw new IllegalArgumentException("Timeout too large.");
    }
    if ((l1 == 0L) && (paramLong > 0L)) {
      throw new IllegalArgumentException("Timeout too small.");
    }
    this.y = ((int)l1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public int b()
  {
    return this.z;
  }
  
  public void b(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    long l1 = paramTimeUnit.toMillis(paramLong);
    if (l1 > 2147483647L) {
      throw new IllegalArgumentException("Timeout too large.");
    }
    if ((l1 == 0L) && (paramLong > 0L)) {
      throw new IllegalArgumentException("Timeout too small.");
    }
    this.z = ((int)l1);
  }
  
  public int c()
  {
    return this.A;
  }
  
  public Proxy d()
  {
    return this.f;
  }
  
  public ProxySelector e()
  {
    return this.k;
  }
  
  public CookieHandler f()
  {
    return this.l;
  }
  
  InternalCache g()
  {
    return this.m;
  }
  
  public Dns h()
  {
    return this.u;
  }
  
  public SocketFactory i()
  {
    return this.o;
  }
  
  public SSLSocketFactory j()
  {
    return this.p;
  }
  
  public HostnameVerifier k()
  {
    return this.q;
  }
  
  public CertificatePinner l()
  {
    return this.r;
  }
  
  public Authenticator m()
  {
    return this.s;
  }
  
  public ConnectionPool n()
  {
    return this.t;
  }
  
  public boolean o()
  {
    return this.v;
  }
  
  public boolean p()
  {
    return this.w;
  }
  
  public boolean q()
  {
    return this.x;
  }
  
  public List r()
  {
    return this.g;
  }
  
  public List s()
  {
    return this.h;
  }
  
  public List t()
  {
    return this.j;
  }
  
  OkHttpClient u()
  {
    OkHttpClient localOkHttpClient = new OkHttpClient(this);
    if (localOkHttpClient.k == null) {
      localOkHttpClient.k = ProxySelector.getDefault();
    }
    if (localOkHttpClient.l == null) {
      localOkHttpClient.l = CookieHandler.getDefault();
    }
    if (localOkHttpClient.o == null) {
      localOkHttpClient.o = SocketFactory.getDefault();
    }
    if (localOkHttpClient.p == null) {
      localOkHttpClient.p = w();
    }
    if (localOkHttpClient.q == null) {
      localOkHttpClient.q = OkHostnameVerifier.a;
    }
    if (localOkHttpClient.r == null) {
      localOkHttpClient.r = CertificatePinner.a;
    }
    if (localOkHttpClient.s == null) {
      localOkHttpClient.s = AuthenticatorAdapter.a;
    }
    if (localOkHttpClient.t == null) {
      localOkHttpClient.t = ConnectionPool.a();
    }
    if (localOkHttpClient.g == null) {
      localOkHttpClient.g = a;
    }
    if (localOkHttpClient.h == null) {
      localOkHttpClient.h = b;
    }
    if (localOkHttpClient.u == null) {
      localOkHttpClient.u = Dns.a;
    }
    return localOkHttpClient;
  }
  
  public OkHttpClient v()
  {
    return new OkHttpClient(this);
  }
}
