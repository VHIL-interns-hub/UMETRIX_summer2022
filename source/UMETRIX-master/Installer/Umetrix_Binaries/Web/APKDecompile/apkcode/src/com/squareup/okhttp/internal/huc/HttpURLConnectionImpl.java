package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.http.HttpDate;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RetryableSink;
import com.squareup.okhttp.internal.http.StatusLine;
import com.squareup.okhttp.internal.http.StreamAllocation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okio.BufferedSink;
import okio.Sink;

public class HttpURLConnectionImpl
  extends HttpURLConnection
{
  private static final Set e = new LinkedHashSet(Arrays.asList(new String[] { "OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH" }));
  private static final RequestBody f = RequestBody.a(null, new byte[0]);
  final OkHttpClient a;
  protected IOException b;
  protected HttpEngine c;
  Handshake d;
  private Headers.Builder g = new Headers.Builder();
  private long h = -1L;
  private int i;
  private Headers j;
  private Route k;
  
  public HttpURLConnectionImpl(URL paramURL, OkHttpClient paramOkHttpClient)
  {
    super(paramURL);
    this.a = paramOkHttpClient;
  }
  
  private Headers a()
  {
    if (this.j == null)
    {
      Response localResponse = d().f();
      this.j = localResponse.f().b().a(OkHeaders.d, localResponse.b().toString()).a(OkHeaders.e, a(localResponse)).a();
    }
    return this.j;
  }
  
  private HttpEngine a(String paramString, StreamAllocation paramStreamAllocation, RetryableSink paramRetryableSink, Response paramResponse)
  {
    if (HttpMethod.b(paramString)) {}
    Object localObject2;
    for (Object localObject1 = f;; localObject1 = null)
    {
      localObject2 = getURL();
      localObject2 = Internal.b.a(((URL)localObject2).toString());
      localObject1 = new Request.Builder().a((HttpUrl)localObject2).a(paramString, (RequestBody)localObject1);
      localObject2 = this.g.a();
      int m = 0;
      int n = ((Headers)localObject2).a();
      while (m < n)
      {
        ((Request.Builder)localObject1).b(((Headers)localObject2).a(m), ((Headers)localObject2).b(m));
        m += 1;
      }
    }
    boolean bool2 = false;
    boolean bool1 = false;
    if (HttpMethod.c(paramString))
    {
      if (this.h == -1L) {
        break label269;
      }
      ((Request.Builder)localObject1).a("Content-Length", Long.toString(this.h));
    }
    for (;;)
    {
      bool2 = bool1;
      if (((Headers)localObject2).a("Content-Type") == null)
      {
        ((Request.Builder)localObject1).a("Content-Type", "application/x-www-form-urlencoded");
        bool2 = bool1;
      }
      if (((Headers)localObject2).a("User-Agent") == null) {
        ((Request.Builder)localObject1).a("User-Agent", c());
      }
      localObject2 = ((Request.Builder)localObject1).a();
      localObject1 = this.a;
      paramString = (String)localObject1;
      if (Internal.b.a((OkHttpClient)localObject1) != null)
      {
        paramString = (String)localObject1;
        if (!getUseCaches()) {
          paramString = this.a.v().a(null);
        }
      }
      return new HttpEngine(paramString, (Request)localObject2, bool2, true, false, paramStreamAllocation, paramRetryableSink, paramResponse);
      label269:
      if (this.chunkLength > 0) {
        ((Request.Builder)localObject1).a("Transfer-Encoding", "chunked");
      } else {
        bool1 = true;
      }
    }
  }
  
  private static String a(Response paramResponse)
  {
    if (paramResponse.i() == null)
    {
      if (paramResponse.j() == null) {
        return "NONE";
      }
      return "CACHE " + paramResponse.c();
    }
    if (paramResponse.j() == null) {
      return "NETWORK " + paramResponse.c();
    }
    return "CONDITIONAL_CACHE " + paramResponse.i().c();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {
      localArrayList.addAll(this.a.r());
    }
    paramString = paramString.split(",", -1);
    int n = paramString.length;
    int m = 0;
    while (m < n)
    {
      String str = paramString[m];
      try
      {
        localArrayList.add(Protocol.a(str));
        m += 1;
      }
      catch (IOException paramString)
      {
        throw new IllegalStateException(paramString);
      }
    }
    this.a.a(localArrayList);
  }
  
  /* Error */
  private boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 289	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:c	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   6: invokevirtual 291	com/squareup/okhttp/internal/http/HttpEngine:a	()V
    //   9: aload_0
    //   10: getfield 289	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:c	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   13: invokevirtual 294	com/squareup/okhttp/internal/http/HttpEngine:g	()Lcom/squareup/okhttp/Connection;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +36 -> 54
    //   21: aload_0
    //   22: aload_3
    //   23: invokeinterface 299 1 0
    //   28: putfield 301	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:k	Lcom/squareup/okhttp/Route;
    //   31: aload_0
    //   32: aload_3
    //   33: invokeinterface 304 1 0
    //   38: putfield 306	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:d	Lcom/squareup/okhttp/Handshake;
    //   41: iload_1
    //   42: ifeq +128 -> 170
    //   45: aload_0
    //   46: getfield 289	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:c	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   49: invokevirtual 308	com/squareup/okhttp/internal/http/HttpEngine:k	()V
    //   52: iconst_1
    //   53: ireturn
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield 301	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:k	Lcom/squareup/okhttp/Route;
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 306	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:d	Lcom/squareup/okhttp/Handshake;
    //   64: goto -23 -> 41
    //   67: astore_3
    //   68: aload_3
    //   69: invokevirtual 311	com/squareup/okhttp/internal/http/RequestException:a	()Ljava/io/IOException;
    //   72: astore_3
    //   73: aload_0
    //   74: aload_3
    //   75: putfield 313	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:b	Ljava/io/IOException;
    //   78: aload_3
    //   79: athrow
    //   80: astore_3
    //   81: iconst_1
    //   82: istore_2
    //   83: iload_2
    //   84: ifeq +13 -> 97
    //   87: aload_0
    //   88: getfield 289	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:c	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   91: invokevirtual 316	com/squareup/okhttp/internal/http/HttpEngine:j	()Lcom/squareup/okhttp/internal/http/StreamAllocation;
    //   94: invokevirtual 320	com/squareup/okhttp/internal/http/StreamAllocation:b	()V
    //   97: aload_3
    //   98: athrow
    //   99: astore_3
    //   100: aload_0
    //   101: getfield 289	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:c	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   104: aload_3
    //   105: invokevirtual 323	com/squareup/okhttp/internal/http/HttpEngine:a	(Lcom/squareup/okhttp/internal/http/RouteException;)Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   108: astore 4
    //   110: aload 4
    //   112: ifnull +11 -> 123
    //   115: aload_0
    //   116: aload 4
    //   118: putfield 289	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:c	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   121: iconst_0
    //   122: ireturn
    //   123: aload_3
    //   124: invokevirtual 324	com/squareup/okhttp/internal/http/RouteException:a	()Ljava/io/IOException;
    //   127: astore_3
    //   128: aload_0
    //   129: aload_3
    //   130: putfield 313	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:b	Ljava/io/IOException;
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: aload_0
    //   137: getfield 289	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:c	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   140: aload_3
    //   141: invokevirtual 327	com/squareup/okhttp/internal/http/HttpEngine:a	(Ljava/io/IOException;)Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   144: astore 4
    //   146: aload 4
    //   148: ifnull +11 -> 159
    //   151: aload_0
    //   152: aload 4
    //   154: putfield 289	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:c	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   157: iconst_0
    //   158: ireturn
    //   159: aload_0
    //   160: aload_3
    //   161: putfield 313	com/squareup/okhttp/internal/huc/HttpURLConnectionImpl:b	Ljava/io/IOException;
    //   164: aload_3
    //   165: athrow
    //   166: astore_3
    //   167: goto -84 -> 83
    //   170: iconst_1
    //   171: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	HttpURLConnectionImpl
    //   0	172	1	paramBoolean	boolean
    //   1	83	2	m	int
    //   16	17	3	localConnection	com.squareup.okhttp.Connection
    //   67	2	3	localRequestException	com.squareup.okhttp.internal.http.RequestException
    //   72	7	3	localIOException1	IOException
    //   80	18	3	localObject1	Object
    //   99	25	3	localRouteException	com.squareup.okhttp.internal.http.RouteException
    //   127	7	3	localIOException2	IOException
    //   135	30	3	localIOException3	IOException
    //   166	1	3	localObject2	Object
    //   108	45	4	localHttpEngine	HttpEngine
    // Exception table:
    //   from	to	target	type
    //   2	17	67	com/squareup/okhttp/internal/http/RequestException
    //   21	41	67	com/squareup/okhttp/internal/http/RequestException
    //   45	52	67	com/squareup/okhttp/internal/http/RequestException
    //   54	64	67	com/squareup/okhttp/internal/http/RequestException
    //   2	17	80	finally
    //   21	41	80	finally
    //   45	52	80	finally
    //   54	64	80	finally
    //   68	80	80	finally
    //   100	110	80	finally
    //   123	135	80	finally
    //   136	146	80	finally
    //   159	166	80	finally
    //   2	17	99	com/squareup/okhttp/internal/http/RouteException
    //   21	41	99	com/squareup/okhttp/internal/http/RouteException
    //   45	52	99	com/squareup/okhttp/internal/http/RouteException
    //   54	64	99	com/squareup/okhttp/internal/http/RouteException
    //   2	17	135	java/io/IOException
    //   21	41	135	java/io/IOException
    //   45	52	135	java/io/IOException
    //   54	64	135	java/io/IOException
    //   115	121	166	finally
    //   151	157	166	finally
  }
  
  private void b()
  {
    if (this.b != null) {
      throw this.b;
    }
    if (this.c != null) {
      return;
    }
    this.connected = true;
    do
    {
      try
      {
        if (this.doOutput)
        {
          if (this.method.equals("GET")) {
            this.method = "POST";
          }
        }
        else
        {
          this.c = a(this.method, null, null, null);
          return;
        }
      }
      catch (IOException localIOException)
      {
        this.b = localIOException;
        throw localIOException;
      }
    } while (HttpMethod.c(this.method));
    throw new ProtocolException(this.method + " does not support writing");
  }
  
  private String c()
  {
    String str = System.getProperty("http.agent");
    if (str != null) {
      return Util.a(str);
    }
    return Version.a();
  }
  
  private HttpEngine d()
  {
    b();
    if (this.c.e()) {
      return this.c;
    }
    for (;;)
    {
      if (a(true))
      {
        Response localResponse = this.c.f();
        Request localRequest = this.c.l();
        if (localRequest == null)
        {
          this.c.h();
          return this.c;
        }
        int m = this.i + 1;
        this.i = m;
        if (m > 20) {
          throw new ProtocolException("Too many follow-up requests: " + this.i);
        }
        this.url = localRequest.b();
        this.g = localRequest.f().b();
        Sink localSink = this.c.c();
        if (!localRequest.e().equals(this.method)) {
          localSink = null;
        }
        if ((localSink != null) && (!(localSink instanceof RetryableSink))) {
          throw new HttpRetryException("Cannot retry streamed HTTP body", this.responseCode);
        }
        StreamAllocation localStreamAllocation2 = this.c.j();
        StreamAllocation localStreamAllocation1 = localStreamAllocation2;
        if (!this.c.a(localRequest.a()))
        {
          localStreamAllocation2.b();
          localStreamAllocation1 = null;
        }
        this.c = a(localRequest.e(), localStreamAllocation1, (RetryableSink)localSink, localResponse);
      }
    }
  }
  
  public final void addRequestProperty(String paramString1, String paramString2)
  {
    if (this.connected) {
      throw new IllegalStateException("Cannot add request property after connection is made");
    }
    if (paramString1 == null) {
      throw new NullPointerException("field == null");
    }
    if (paramString2 == null)
    {
      Platform.a().a("Ignoring header " + paramString1 + " because its value was null.");
      return;
    }
    if (("X-Android-Transports".equals(paramString1)) || ("X-Android-Protocols".equals(paramString1)))
    {
      a(paramString2, true);
      return;
    }
    this.g.a(paramString1, paramString2);
  }
  
  public final void connect()
  {
    b();
    while (!a(false)) {}
  }
  
  public final void disconnect()
  {
    if (this.c == null) {
      return;
    }
    this.c.i();
  }
  
  public int getConnectTimeout()
  {
    return this.a.a();
  }
  
  public final InputStream getErrorStream()
  {
    Object localObject2 = null;
    try
    {
      HttpEngine localHttpEngine = d();
      Object localObject1 = localObject2;
      if (HttpEngine.a(localHttpEngine.f()))
      {
        localObject1 = localObject2;
        if (localHttpEngine.f().c() >= 400) {
          localObject1 = localHttpEngine.f().g().b();
        }
      }
      return localObject1;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public final String getHeaderField(int paramInt)
  {
    try
    {
      String str = a().b(paramInt);
      return str;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public final String getHeaderField(String paramString)
  {
    if (paramString == null) {}
    try
    {
      return StatusLine.a(d().f()).toString();
    }
    catch (IOException paramString) {}
    paramString = a().a(paramString);
    return paramString;
    return null;
  }
  
  public final String getHeaderFieldKey(int paramInt)
  {
    try
    {
      String str = a().a(paramInt);
      return str;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public final Map getHeaderFields()
  {
    try
    {
      Map localMap = OkHeaders.a(a(), StatusLine.a(d().f()).toString());
      return localMap;
    }
    catch (IOException localIOException) {}
    return Collections.emptyMap();
  }
  
  public final InputStream getInputStream()
  {
    if (!this.doInput) {
      throw new ProtocolException("This protocol does not support input");
    }
    HttpEngine localHttpEngine = d();
    if (getResponseCode() >= 400) {
      throw new FileNotFoundException(this.url.toString());
    }
    return localHttpEngine.f().g().b();
  }
  
  public boolean getInstanceFollowRedirects()
  {
    return this.a.p();
  }
  
  public final OutputStream getOutputStream()
  {
    connect();
    BufferedSink localBufferedSink = this.c.d();
    if (localBufferedSink == null) {
      throw new ProtocolException("method does not support a request body: " + this.method);
    }
    if (this.c.e()) {
      throw new ProtocolException("cannot write request body after response has been read");
    }
    return localBufferedSink.d();
  }
  
  public final Permission getPermission()
  {
    Object localObject = getURL();
    String str = ((URL)localObject).getHost();
    if (((URL)localObject).getPort() != -1) {}
    for (int m = ((URL)localObject).getPort();; m = HttpUrl.a(((URL)localObject).getProtocol()))
    {
      if (usingProxy())
      {
        localObject = (InetSocketAddress)this.a.d().address();
        str = ((InetSocketAddress)localObject).getHostName();
        m = ((InetSocketAddress)localObject).getPort();
      }
      return new SocketPermission(str + ":" + m, "connect, resolve");
    }
  }
  
  public int getReadTimeout()
  {
    return this.a.b();
  }
  
  public final Map getRequestProperties()
  {
    if (this.connected) {
      throw new IllegalStateException("Cannot access request header fields after connection is set");
    }
    return OkHeaders.a(this.g.a(), null);
  }
  
  public final String getRequestProperty(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return this.g.c(paramString);
  }
  
  public final int getResponseCode()
  {
    return d().f().c();
  }
  
  public String getResponseMessage()
  {
    return d().f().d();
  }
  
  public void setConnectTimeout(int paramInt)
  {
    this.a.a(paramInt, TimeUnit.MILLISECONDS);
  }
  
  public void setFixedLengthStreamingMode(int paramInt)
  {
    setFixedLengthStreamingMode(paramInt);
  }
  
  public void setFixedLengthStreamingMode(long paramLong)
  {
    if (this.connected) {
      throw new IllegalStateException("Already connected");
    }
    if (this.chunkLength > 0) {
      throw new IllegalStateException("Already in chunked mode");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("contentLength < 0");
    }
    this.h = paramLong;
    this.fixedContentLength = ((int)Math.min(paramLong, 2147483647L));
  }
  
  public void setIfModifiedSince(long paramLong)
  {
    super.setIfModifiedSince(paramLong);
    if (this.ifModifiedSince != 0L)
    {
      this.g.c("If-Modified-Since", HttpDate.a(new Date(this.ifModifiedSince)));
      return;
    }
    this.g.b("If-Modified-Since");
  }
  
  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void setReadTimeout(int paramInt)
  {
    this.a.b(paramInt, TimeUnit.MILLISECONDS);
  }
  
  public void setRequestMethod(String paramString)
  {
    if (!e.contains(paramString)) {
      throw new ProtocolException("Expected one of " + e + " but was " + paramString);
    }
    this.method = paramString;
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    if (this.connected) {
      throw new IllegalStateException("Cannot set request property after connection is made");
    }
    if (paramString1 == null) {
      throw new NullPointerException("field == null");
    }
    if (paramString2 == null)
    {
      Platform.a().a("Ignoring header " + paramString1 + " because its value was null.");
      return;
    }
    if (("X-Android-Transports".equals(paramString1)) || ("X-Android-Protocols".equals(paramString1)))
    {
      a(paramString2, false);
      return;
    }
    this.g.c(paramString1, paramString2);
  }
  
  public final boolean usingProxy()
  {
    if (this.k != null) {}
    for (Proxy localProxy = this.k.b(); (localProxy != null) && (localProxy.type() != Proxy.Type.DIRECT); localProxy = this.a.d()) {
      return true;
    }
    return false;
  }
}
