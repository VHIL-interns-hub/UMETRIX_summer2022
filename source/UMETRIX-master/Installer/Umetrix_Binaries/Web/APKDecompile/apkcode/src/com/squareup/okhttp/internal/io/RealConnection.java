package com.squareup.okhttp.internal.io;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.ConnectionSpecSelector;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedConnection.Builder;
import com.squareup.okhttp.internal.http.Http1xStream;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public final class RealConnection
  implements Connection
{
  private static SSLSocketFactory m;
  private static TrustRootIndex n;
  public Socket a;
  public volatile FramedConnection b;
  public int c;
  public BufferedSource d;
  public BufferedSink e;
  public final List f = new ArrayList();
  public boolean g;
  public long h = Long.MAX_VALUE;
  private final Route i;
  private Socket j;
  private Handshake k;
  private Protocol l;
  
  public RealConnection(Route paramRoute)
  {
    this.i = paramRoute;
  }
  
  private static TrustRootIndex a(SSLSocketFactory paramSSLSocketFactory)
  {
    try
    {
      if (paramSSLSocketFactory != m)
      {
        X509TrustManager localX509TrustManager = Platform.a().a(paramSSLSocketFactory);
        n = Platform.a().a(localX509TrustManager);
        m = paramSSLSocketFactory;
      }
      paramSSLSocketFactory = n;
      return paramSSLSocketFactory;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = f();
    Object localObject2 = ((Request)localObject1).a();
    String str = "CONNECT " + ((HttpUrl)localObject2).g() + ":" + ((HttpUrl)localObject2).h() + " HTTP/1.1";
    do
    {
      localObject2 = new Http1xStream(null, this.d, this.e);
      this.d.a().a(paramInt1, TimeUnit.MILLISECONDS);
      this.e.a().a(paramInt2, TimeUnit.MILLISECONDS);
      ((Http1xStream)localObject2).a(((Request)localObject1).f(), str);
      ((Http1xStream)localObject2).c();
      localObject1 = ((Http1xStream)localObject2).d().a((Request)localObject1).a();
      long l2 = OkHeaders.a((Response)localObject1);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      localObject2 = ((Http1xStream)localObject2).b(l1);
      Util.b((Source)localObject2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
      ((Source)localObject2).close();
      switch (((Response)localObject1).c())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + ((Response)localObject1).c());
      case 200: 
        if ((this.d.c().g()) && (this.e.c().g())) {
          break;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
      case 407: 
        localObject2 = OkHeaders.a(this.i.a().f(), (Response)localObject1, this.i.b());
        localObject1 = localObject2;
      }
    } while (localObject2 != null);
    throw new IOException("Failed to authenticate with proxy");
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ConnectionSpecSelector paramConnectionSpecSelector)
  {
    this.j.setSoTimeout(paramInt2);
    for (;;)
    {
      try
      {
        Platform.a().a(this.j, this.i.c(), paramInt1);
        this.d = Okio.a(Okio.b(this.j));
        this.e = Okio.a(Okio.a(this.j));
        if (this.i.a().k() != null)
        {
          a(paramInt2, paramInt3, paramConnectionSpecSelector);
          if ((this.l == Protocol.c) || (this.l == Protocol.d))
          {
            this.a.setSoTimeout(0);
            paramConnectionSpecSelector = new FramedConnection.Builder(true).a(this.a, this.i.a().a().g(), this.d, this.e).a(this.l).a();
            paramConnectionSpecSelector.d();
            this.b = paramConnectionSpecSelector;
          }
          return;
        }
      }
      catch (ConnectException paramConnectionSpecSelector)
      {
        throw new ConnectException("Failed to connect to " + this.i.c());
      }
      this.l = Protocol.b;
      this.a = this.j;
    }
  }
  
  /* Error */
  private void a(int paramInt1, int paramInt2, ConnectionSpecSelector paramConnectionSpecSelector)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: getfield 49	com/squareup/okhttp/internal/io/RealConnection:i	Lcom/squareup/okhttp/Route;
    //   13: invokevirtual 290	com/squareup/okhttp/Route:d	()Z
    //   16: ifeq +9 -> 25
    //   19: aload_0
    //   20: iload_1
    //   21: iload_2
    //   22: invokespecial 292	com/squareup/okhttp/internal/io/RealConnection:a	(II)V
    //   25: aload_0
    //   26: getfield 49	com/squareup/okhttp/internal/io/RealConnection:i	Lcom/squareup/okhttp/Route;
    //   29: invokevirtual 197	com/squareup/okhttp/Route:a	()Lcom/squareup/okhttp/Address;
    //   32: astore 8
    //   34: aload 8
    //   36: invokevirtual 244	com/squareup/okhttp/Address:k	()Ljavax/net/ssl/SSLSocketFactory;
    //   39: astore 5
    //   41: aload 5
    //   43: aload_0
    //   44: getfield 215	com/squareup/okhttp/internal/io/RealConnection:j	Ljava/net/Socket;
    //   47: aload 8
    //   49: invokevirtual 294	com/squareup/okhttp/Address:b	()Ljava/lang/String;
    //   52: aload 8
    //   54: invokevirtual 295	com/squareup/okhttp/Address:c	()I
    //   57: iconst_1
    //   58: invokevirtual 301	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   61: checkcast 303	javax/net/ssl/SSLSocket
    //   64: astore 5
    //   66: aload_3
    //   67: aload 5
    //   69: invokevirtual 308	com/squareup/okhttp/internal/ConnectionSpecSelector:a	(Ljavax/net/ssl/SSLSocket;)Lcom/squareup/okhttp/ConnectionSpec;
    //   72: astore 7
    //   74: aload 7
    //   76: invokevirtual 312	com/squareup/okhttp/ConnectionSpec:c	()Z
    //   79: ifeq +21 -> 100
    //   82: invokestatic 58	com/squareup/okhttp/internal/Platform:a	()Lcom/squareup/okhttp/internal/Platform;
    //   85: aload 5
    //   87: aload 8
    //   89: invokevirtual 294	com/squareup/okhttp/Address:b	()Ljava/lang/String;
    //   92: aload 8
    //   94: invokevirtual 315	com/squareup/okhttp/Address:g	()Ljava/util/List;
    //   97: invokevirtual 318	com/squareup/okhttp/internal/Platform:a	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   100: aload 5
    //   102: invokevirtual 321	javax/net/ssl/SSLSocket:startHandshake	()V
    //   105: aload 5
    //   107: invokevirtual 325	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   110: invokestatic 330	com/squareup/okhttp/Handshake:a	(Ljavax/net/ssl/SSLSession;)Lcom/squareup/okhttp/Handshake;
    //   113: astore 4
    //   115: aload 8
    //   117: invokevirtual 333	com/squareup/okhttp/Address:l	()Ljavax/net/ssl/HostnameVerifier;
    //   120: aload 8
    //   122: invokevirtual 294	com/squareup/okhttp/Address:b	()Ljava/lang/String;
    //   125: aload 5
    //   127: invokevirtual 325	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   130: invokeinterface 339 3 0
    //   135: ifne +154 -> 289
    //   138: aload 4
    //   140: invokevirtual 341	com/squareup/okhttp/Handshake:b	()Ljava/util/List;
    //   143: iconst_0
    //   144: invokeinterface 347 2 0
    //   149: checkcast 349	java/security/cert/X509Certificate
    //   152: astore_3
    //   153: new 351	javax/net/ssl/SSLPeerUnverifiedException
    //   156: dup
    //   157: new 77	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   164: ldc_w 353
    //   167: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 8
    //   172: invokevirtual 294	com/squareup/okhttp/Address:b	()Ljava/lang/String;
    //   175: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 355
    //   181: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 357
    //   187: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_3
    //   191: invokestatic 362	com/squareup/okhttp/CertificatePinner:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   194: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 364
    //   200: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_3
    //   204: invokevirtual 368	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   207: invokeinterface 373 1 0
    //   212: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 375
    //   218: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_3
    //   222: invokestatic 380	com/squareup/okhttp/internal/tls/OkHostnameVerifier:a	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   225: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokespecial 381	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   234: athrow
    //   235: astore 4
    //   237: aload 5
    //   239: astore_3
    //   240: aload 4
    //   242: astore 5
    //   244: aload_3
    //   245: astore 4
    //   247: aload 5
    //   249: invokestatic 384	com/squareup/okhttp/internal/Util:a	(Ljava/lang/AssertionError;)Z
    //   252: ifeq +181 -> 433
    //   255: aload_3
    //   256: astore 4
    //   258: new 176	java/io/IOException
    //   261: dup
    //   262: aload 5
    //   264: invokespecial 387	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   267: athrow
    //   268: astore_3
    //   269: aload 4
    //   271: ifnull +11 -> 282
    //   274: invokestatic 58	com/squareup/okhttp/internal/Platform:a	()Lcom/squareup/okhttp/internal/Platform;
    //   277: aload 4
    //   279: invokevirtual 390	com/squareup/okhttp/internal/Platform:a	(Ljavax/net/ssl/SSLSocket;)V
    //   282: aload 4
    //   284: invokestatic 393	com/squareup/okhttp/internal/Util:a	(Ljava/net/Socket;)V
    //   287: aload_3
    //   288: athrow
    //   289: aload 8
    //   291: invokevirtual 396	com/squareup/okhttp/Address:m	()Lcom/squareup/okhttp/CertificatePinner;
    //   294: getstatic 399	com/squareup/okhttp/CertificatePinner:a	Lcom/squareup/okhttp/CertificatePinner;
    //   297: if_acmpeq +41 -> 338
    //   300: new 401	com/squareup/okhttp/internal/tls/CertificateChainCleaner
    //   303: dup
    //   304: aload 8
    //   306: invokevirtual 244	com/squareup/okhttp/Address:k	()Ljavax/net/ssl/SSLSocketFactory;
    //   309: invokestatic 403	com/squareup/okhttp/internal/io/RealConnection:a	(Ljavax/net/ssl/SSLSocketFactory;)Lcom/squareup/okhttp/internal/tls/TrustRootIndex;
    //   312: invokespecial 406	com/squareup/okhttp/internal/tls/CertificateChainCleaner:<init>	(Lcom/squareup/okhttp/internal/tls/TrustRootIndex;)V
    //   315: aload 4
    //   317: invokevirtual 341	com/squareup/okhttp/Handshake:b	()Ljava/util/List;
    //   320: invokevirtual 409	com/squareup/okhttp/internal/tls/CertificateChainCleaner:a	(Ljava/util/List;)Ljava/util/List;
    //   323: astore_3
    //   324: aload 8
    //   326: invokevirtual 396	com/squareup/okhttp/Address:m	()Lcom/squareup/okhttp/CertificatePinner;
    //   329: aload 8
    //   331: invokevirtual 294	com/squareup/okhttp/Address:b	()Ljava/lang/String;
    //   334: aload_3
    //   335: invokevirtual 412	com/squareup/okhttp/CertificatePinner:a	(Ljava/lang/String;Ljava/util/List;)V
    //   338: aload 6
    //   340: astore_3
    //   341: aload 7
    //   343: invokevirtual 312	com/squareup/okhttp/ConnectionSpec:c	()Z
    //   346: ifeq +12 -> 358
    //   349: invokestatic 58	com/squareup/okhttp/internal/Platform:a	()Lcom/squareup/okhttp/internal/Platform;
    //   352: aload 5
    //   354: invokevirtual 415	com/squareup/okhttp/internal/Platform:b	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   357: astore_3
    //   358: aload_0
    //   359: aload 5
    //   361: putfield 257	com/squareup/okhttp/internal/io/RealConnection:a	Ljava/net/Socket;
    //   364: aload_0
    //   365: aload_0
    //   366: getfield 257	com/squareup/okhttp/internal/io/RealConnection:a	Ljava/net/Socket;
    //   369: invokestatic 232	okio/Okio:b	(Ljava/net/Socket;)Lokio/Source;
    //   372: invokestatic 235	okio/Okio:a	(Lokio/Source;)Lokio/BufferedSource;
    //   375: putfield 106	com/squareup/okhttp/internal/io/RealConnection:d	Lokio/BufferedSource;
    //   378: aload_0
    //   379: aload_0
    //   380: getfield 257	com/squareup/okhttp/internal/io/RealConnection:a	Ljava/net/Socket;
    //   383: invokestatic 238	okio/Okio:a	(Ljava/net/Socket;)Lokio/Sink;
    //   386: invokestatic 241	okio/Okio:a	(Lokio/Sink;)Lokio/BufferedSink;
    //   389: putfield 108	com/squareup/okhttp/internal/io/RealConnection:e	Lokio/BufferedSink;
    //   392: aload_0
    //   393: aload 4
    //   395: putfield 417	com/squareup/okhttp/internal/io/RealConnection:k	Lcom/squareup/okhttp/Handshake;
    //   398: aload_3
    //   399: ifnull +27 -> 426
    //   402: aload_3
    //   403: invokestatic 420	com/squareup/okhttp/Protocol:a	(Ljava/lang/String;)Lcom/squareup/okhttp/Protocol;
    //   406: astore_3
    //   407: aload_0
    //   408: aload_3
    //   409: putfield 249	com/squareup/okhttp/internal/io/RealConnection:l	Lcom/squareup/okhttp/Protocol;
    //   412: aload 5
    //   414: ifnull +11 -> 425
    //   417: invokestatic 58	com/squareup/okhttp/internal/Platform:a	()Lcom/squareup/okhttp/internal/Platform;
    //   420: aload 5
    //   422: invokevirtual 390	com/squareup/okhttp/internal/Platform:a	(Ljavax/net/ssl/SSLSocket;)V
    //   425: return
    //   426: getstatic 286	com/squareup/okhttp/Protocol:b	Lcom/squareup/okhttp/Protocol;
    //   429: astore_3
    //   430: goto -23 -> 407
    //   433: aload_3
    //   434: astore 4
    //   436: aload 5
    //   438: athrow
    //   439: astore_3
    //   440: aload 5
    //   442: astore 4
    //   444: goto -175 -> 269
    //   447: astore 5
    //   449: aload 7
    //   451: astore_3
    //   452: goto -208 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	this	RealConnection
    //   0	455	1	paramInt1	int
    //   0	455	2	paramInt2	int
    //   0	455	3	paramConnectionSpecSelector	ConnectionSpecSelector
    //   1	138	4	localHandshake	Handshake
    //   235	6	4	localAssertionError1	AssertionError
    //   245	198	4	localObject1	Object
    //   39	402	5	localObject2	Object
    //   447	1	5	localAssertionError2	AssertionError
    //   4	335	6	localObject3	Object
    //   7	443	7	localConnectionSpec	ConnectionSpec
    //   32	298	8	localAddress	Address
    // Exception table:
    //   from	to	target	type
    //   66	100	235	java/lang/AssertionError
    //   100	235	235	java/lang/AssertionError
    //   289	338	235	java/lang/AssertionError
    //   341	358	235	java/lang/AssertionError
    //   358	398	235	java/lang/AssertionError
    //   402	407	235	java/lang/AssertionError
    //   407	412	235	java/lang/AssertionError
    //   426	430	235	java/lang/AssertionError
    //   41	66	268	finally
    //   247	255	268	finally
    //   258	268	268	finally
    //   436	439	268	finally
    //   66	100	439	finally
    //   100	235	439	finally
    //   289	338	439	finally
    //   341	358	439	finally
    //   358	398	439	finally
    //   402	407	439	finally
    //   407	412	439	finally
    //   426	430	439	finally
    //   41	66	447	java/lang/AssertionError
  }
  
  private Request f()
  {
    return new Request.Builder().a(this.i.a().a()).a("Host", Util.a(this.i.a().a())).a("Proxy-Connection", "Keep-Alive").a("User-Agent", Version.a()).a();
  }
  
  public Route a()
  {
    return this.i;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, List paramList, boolean paramBoolean)
  {
    if (this.l != null) {
      throw new IllegalStateException("already connected");
    }
    ConnectionSpecSelector localConnectionSpecSelector = new ConnectionSpecSelector(paramList);
    Proxy localProxy = this.i.b();
    Address localAddress = this.i.a();
    if ((this.i.a().k() == null) && (!paramList.contains(ConnectionSpec.c))) {
      throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + paramList));
    }
    for (;;)
    {
      try
      {
        localObject = new Socket(localProxy);
        this.j = ((Socket)localObject);
        a(paramInt1, paramInt2, paramInt3, localConnectionSpecSelector);
      }
      catch (IOException localIOException)
      {
        Util.a(this.a);
        Util.a(this.j);
        this.a = null;
        this.j = null;
        this.d = null;
        this.e = null;
        this.k = null;
        this.l = null;
        if (paramList != null) {
          continue;
        }
        Object localObject = new RouteException(localIOException);
        if (!paramBoolean) {
          continue;
        }
        paramList = (List)localObject;
        if (localConnectionSpecSelector.a(localIOException)) {
          continue;
        }
        throw ((Throwable)localObject);
        paramList.a(localIOException);
        localObject = paramList;
        continue;
      }
      if (this.l == null)
      {
        if ((localProxy.type() == Proxy.Type.DIRECT) || (localProxy.type() == Proxy.Type.HTTP)) {
          localObject = localAddress.e().createSocket();
        }
      }
      else
      {
        return;
        paramList = null;
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.a.isClosed()) || (this.a.isInputShutdown()) || (this.a.isOutputShutdown())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.b != null);
      bool1 = bool2;
    } while (!paramBoolean);
    try
    {
      int i1 = this.a.getSoTimeout();
      try
      {
        this.a.setSoTimeout(1);
        paramBoolean = this.d.g();
        return !paramBoolean;
      }
      finally
      {
        this.a.setSoTimeout(i1);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
  }
  
  public Handshake b()
  {
    return this.k;
  }
  
  public void c()
  {
    Util.a(this.j);
  }
  
  public Socket d()
  {
    return this.a;
  }
  
  public int e()
  {
    FramedConnection localFramedConnection = this.b;
    if (localFramedConnection != null) {
      return localFramedConnection.b();
    }
    return 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.i.a().a().g()).append(":").append(this.i.a().a().h()).append(", proxy=").append(this.i.b()).append(" hostAddress=").append(this.i.c()).append(" cipherSuite=");
    if (this.k != null) {}
    for (String str = this.k.a();; str = "none") {
      return str + " protocol=" + this.l + '}';
    }
  }
}
