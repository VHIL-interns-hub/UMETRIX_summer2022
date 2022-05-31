package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1xStream
  implements HttpStream
{
  private final StreamAllocation a;
  private final BufferedSource b;
  private final BufferedSink c;
  private HttpEngine d;
  private int e = 0;
  
  public Http1xStream(StreamAllocation paramStreamAllocation, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    this.a = paramStreamAllocation;
    this.b = paramBufferedSource;
    this.c = paramBufferedSink;
  }
  
  private void a(ForwardingTimeout paramForwardingTimeout)
  {
    Timeout localTimeout = paramForwardingTimeout.a();
    paramForwardingTimeout.a(Timeout.b);
    localTimeout.f();
    localTimeout.f_();
  }
  
  private Source b(Response paramResponse)
  {
    if (!HttpEngine.a(paramResponse)) {
      return b(0L);
    }
    if ("chunked".equalsIgnoreCase(paramResponse.a("Transfer-Encoding"))) {
      return b(this.d);
    }
    long l = OkHeaders.a(paramResponse);
    if (l != -1L) {
      return b(l);
    }
    return g();
  }
  
  public ResponseBody a(Response paramResponse)
  {
    Source localSource = b(paramResponse);
    return new RealResponseBody(paramResponse.f(), Okio.a(localSource));
  }
  
  public Sink a(long paramLong)
  {
    if (this.e != 1) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 2;
    return new Http1xStream.FixedLengthSink(this, paramLong, null);
  }
  
  public Sink a(Request paramRequest, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramRequest.a("Transfer-Encoding"))) {
      return f();
    }
    if (paramLong != -1L) {
      return a(paramLong);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public void a()
  {
    RealConnection localRealConnection = this.a.a();
    if (localRealConnection != null) {
      localRealConnection.c();
    }
  }
  
  public void a(Headers paramHeaders, String paramString)
  {
    if (this.e != 0) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.c.b(paramString).b("\r\n");
    int i = 0;
    int j = paramHeaders.a();
    while (i < j)
    {
      this.c.b(paramHeaders.a(i)).b(": ").b(paramHeaders.b(i)).b("\r\n");
      i += 1;
    }
    this.c.b("\r\n");
    this.e = 1;
  }
  
  public void a(Request paramRequest)
  {
    this.d.b();
    String str = RequestLine.a(paramRequest, this.d.g().a().b().type());
    a(paramRequest.f(), str);
  }
  
  public void a(HttpEngine paramHttpEngine)
  {
    this.d = paramHttpEngine;
  }
  
  public void a(RetryableSink paramRetryableSink)
  {
    if (this.e != 1) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 3;
    paramRetryableSink.a(this.c);
  }
  
  public Response.Builder b()
  {
    return d();
  }
  
  public Source b(long paramLong)
  {
    if (this.e != 4) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 5;
    return new Http1xStream.FixedLengthSource(this, paramLong);
  }
  
  public Source b(HttpEngine paramHttpEngine)
  {
    if (this.e != 4) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 5;
    return new Http1xStream.ChunkedSource(this, paramHttpEngine);
  }
  
  public void c()
  {
    this.c.flush();
  }
  
  public Response.Builder d()
  {
    if ((this.e != 1) && (this.e != 3)) {
      throw new IllegalStateException("state: " + this.e);
    }
    try
    {
      StatusLine localStatusLine;
      do
      {
        localStatusLine = StatusLine.a(this.b.r());
        localObject = new Response.Builder().a(localStatusLine.a).a(localStatusLine.b).a(localStatusLine.c).a(e());
      } while (localStatusLine.b == 100);
      this.e = 4;
      return localObject;
    }
    catch (EOFException localEOFException)
    {
      Object localObject = new IOException("unexpected end of stream on " + this.a);
      ((IOException)localObject).initCause(localEOFException);
      throw ((Throwable)localObject);
    }
  }
  
  public Headers e()
  {
    Headers.Builder localBuilder = new Headers.Builder();
    for (;;)
    {
      String str = this.b.r();
      if (str.length() == 0) {
        break;
      }
      Internal.b.a(localBuilder, str);
    }
    return localBuilder.a();
  }
  
  public Sink f()
  {
    if (this.e != 1) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 2;
    return new Http1xStream.ChunkedSink(this, null);
  }
  
  public Source g()
  {
    if (this.e != 4) {
      throw new IllegalStateException("state: " + this.e);
    }
    if (this.a == null) {
      throw new IllegalStateException("streamAllocation == null");
    }
    this.e = 5;
    this.a.c();
    return new Http1xStream.UnknownLengthSource(this, null);
  }
}
