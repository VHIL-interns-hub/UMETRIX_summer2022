package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.Sink;

public final class StreamAllocation
{
  public final Address a;
  private final ConnectionPool b;
  private RouteSelector c;
  private RealConnection d;
  private boolean e;
  private boolean f;
  private HttpStream g;
  
  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress)
  {
    this.b = paramConnectionPool;
    this.a = paramAddress;
  }
  
  private RealConnection a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.b)
    {
      if (this.e) {
        throw new IllegalStateException("released");
      }
    }
    if (this.g != null) {
      throw new IllegalStateException("stream != null");
    }
    if (this.f) {
      throw new IOException("Canceled");
    }
    RealConnection localRealConnection1 = this.d;
    if ((localRealConnection1 != null) && (!localRealConnection1.g)) {
      return localRealConnection1;
    }
    localRealConnection1 = Internal.b.a(this.b, this.a, this);
    if (localRealConnection1 != null)
    {
      this.d = localRealConnection1;
      return localRealConnection1;
    }
    if (this.c == null) {
      this.c = new RouteSelector(this.a, f());
    }
    localRealConnection1 = new RealConnection(this.c.b());
    a(localRealConnection1);
    synchronized (this.b)
    {
      Internal.b.b(this.b, localRealConnection1);
      this.d = localRealConnection1;
      if (this.f) {
        throw new IOException("Canceled");
      }
    }
    localRealConnection2.a(paramInt1, paramInt2, paramInt3, this.a.h(), paramBoolean);
    f().b(localRealConnection2.a());
    return localRealConnection2;
  }
  
  private void a(IOException paramIOException)
  {
    synchronized (this.b)
    {
      if (this.c != null)
      {
        if (this.d.c == 0)
        {
          Route localRoute = this.d.a();
          this.c.a(localRoute, paramIOException);
        }
      }
      else
      {
        e();
        return;
      }
      this.c = null;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    ConnectionPool localConnectionPool = this.b;
    if (paramBoolean3) {}
    try
    {
      this.g = null;
      if (paramBoolean2) {
        this.e = true;
      }
      Object localObject1 = localObject4;
      if (this.d != null)
      {
        if (paramBoolean1) {
          this.d.g = true;
        }
        localObject1 = localObject4;
        if (this.g == null) {
          if (!this.e)
          {
            localObject1 = localObject4;
            if (!this.d.g) {}
          }
          else
          {
            b(this.d);
            if (this.d.c > 0) {
              this.c = null;
            }
            localObject1 = localObject3;
            if (this.d.f.isEmpty())
            {
              this.d.h = System.nanoTime();
              localObject1 = localObject3;
              if (Internal.b.a(this.b, this.d)) {
                localObject1 = this.d;
              }
            }
            this.d = null;
          }
        }
      }
      if (localObject1 != null) {
        Util.a(((RealConnection)localObject1).d());
      }
      return;
    }
    finally {}
  }
  
  private RealConnection b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      RealConnection localRealConnection1 = a(paramInt1, paramInt2, paramInt3, paramBoolean1);
      synchronized (this.b)
      {
        if (localRealConnection1.c == 0) {
          return localRealConnection1;
        }
        if (!localRealConnection1.a(paramBoolean2)) {
          e();
        }
      }
    }
    return localRealConnection2;
  }
  
  private void b(RealConnection paramRealConnection)
  {
    int j = paramRealConnection.f.size();
    int i = 0;
    while (i < j)
    {
      if (((Reference)paramRealConnection.f.get(i)).get() == this)
      {
        paramRealConnection.f.remove(i);
        return;
      }
      i += 1;
    }
    throw new IllegalStateException();
  }
  
  private boolean b(RouteException paramRouteException)
  {
    paramRouteException = paramRouteException.a();
    if ((paramRouteException instanceof ProtocolException)) {}
    do
    {
      return false;
      if ((paramRouteException instanceof InterruptedIOException)) {
        return paramRouteException instanceof SocketTimeoutException;
      }
    } while ((((paramRouteException instanceof SSLHandshakeException)) && ((paramRouteException.getCause() instanceof CertificateException))) || ((paramRouteException instanceof SSLPeerUnverifiedException)));
    return true;
  }
  
  private boolean b(IOException paramIOException)
  {
    if ((paramIOException instanceof ProtocolException)) {}
    while ((paramIOException instanceof InterruptedIOException)) {
      return false;
    }
    return true;
  }
  
  private RouteDatabase f()
  {
    return Internal.b.a(this.b);
  }
  
  /* Error */
  public HttpStream a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: iload 4
    //   6: iload 5
    //   8: invokespecial 192	com/squareup/okhttp/internal/http/StreamAllocation:b	(IIIZZ)Lcom/squareup/okhttp/internal/io/RealConnection;
    //   11: astore 7
    //   13: aload 7
    //   15: getfield 195	com/squareup/okhttp/internal/io/RealConnection:b	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   18: ifnull +51 -> 69
    //   21: new 197	com/squareup/okhttp/internal/http/Http2xStream
    //   24: dup
    //   25: aload_0
    //   26: aload 7
    //   28: getfield 195	com/squareup/okhttp/internal/io/RealConnection:b	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   31: invokespecial 200	com/squareup/okhttp/internal/http/Http2xStream:<init>	(Lcom/squareup/okhttp/internal/http/StreamAllocation;Lcom/squareup/okhttp/internal/framed/FramedConnection;)V
    //   34: astore 6
    //   36: aload_0
    //   37: getfield 24	com/squareup/okhttp/internal/http/StreamAllocation:b	Lcom/squareup/okhttp/ConnectionPool;
    //   40: astore 8
    //   42: aload 8
    //   44: monitorenter
    //   45: aload 7
    //   47: aload 7
    //   49: getfield 103	com/squareup/okhttp/internal/io/RealConnection:c	I
    //   52: iconst_1
    //   53: iadd
    //   54: putfield 103	com/squareup/okhttp/internal/io/RealConnection:c	I
    //   57: aload_0
    //   58: aload 6
    //   60: putfield 39	com/squareup/okhttp/internal/http/StreamAllocation:g	Lcom/squareup/okhttp/internal/http/HttpStream;
    //   63: aload 8
    //   65: monitorexit
    //   66: aload 6
    //   68: areturn
    //   69: aload 7
    //   71: invokevirtual 135	com/squareup/okhttp/internal/io/RealConnection:d	()Ljava/net/Socket;
    //   74: iload_2
    //   75: invokevirtual 206	java/net/Socket:setSoTimeout	(I)V
    //   78: aload 7
    //   80: getfield 209	com/squareup/okhttp/internal/io/RealConnection:d	Lokio/BufferedSource;
    //   83: invokeinterface 214 1 0
    //   88: iload_2
    //   89: i2l
    //   90: getstatic 220	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   93: invokevirtual 225	okio/Timeout:a	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
    //   96: pop
    //   97: aload 7
    //   99: getfield 228	com/squareup/okhttp/internal/io/RealConnection:e	Lokio/BufferedSink;
    //   102: invokeinterface 231 1 0
    //   107: iload_3
    //   108: i2l
    //   109: getstatic 220	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   112: invokevirtual 225	okio/Timeout:a	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
    //   115: pop
    //   116: new 233	com/squareup/okhttp/internal/http/Http1xStream
    //   119: dup
    //   120: aload_0
    //   121: aload 7
    //   123: getfield 209	com/squareup/okhttp/internal/io/RealConnection:d	Lokio/BufferedSource;
    //   126: aload 7
    //   128: getfield 228	com/squareup/okhttp/internal/io/RealConnection:e	Lokio/BufferedSink;
    //   131: invokespecial 236	com/squareup/okhttp/internal/http/Http1xStream:<init>	(Lcom/squareup/okhttp/internal/http/StreamAllocation;Lokio/BufferedSource;Lokio/BufferedSink;)V
    //   134: astore 6
    //   136: goto -100 -> 36
    //   139: astore 6
    //   141: new 166	com/squareup/okhttp/internal/http/RouteException
    //   144: dup
    //   145: aload 6
    //   147: invokespecial 238	com/squareup/okhttp/internal/http/RouteException:<init>	(Ljava/io/IOException;)V
    //   150: athrow
    //   151: astore 6
    //   153: aload 8
    //   155: monitorexit
    //   156: aload 6
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	StreamAllocation
    //   0	159	1	paramInt1	int
    //   0	159	2	paramInt2	int
    //   0	159	3	paramInt3	int
    //   0	159	4	paramBoolean1	boolean
    //   0	159	5	paramBoolean2	boolean
    //   34	101	6	localObject1	Object
    //   139	7	6	localIOException	IOException
    //   151	6	6	localObject2	Object
    //   11	116	7	localRealConnection	RealConnection
    // Exception table:
    //   from	to	target	type
    //   0	36	139	java/io/IOException
    //   36	45	139	java/io/IOException
    //   69	136	139	java/io/IOException
    //   156	159	139	java/io/IOException
    //   45	66	151	finally
    //   153	156	151	finally
  }
  
  public RealConnection a()
  {
    try
    {
      RealConnection localRealConnection = this.d;
      return localRealConnection;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(HttpStream paramHttpStream)
  {
    ConnectionPool localConnectionPool = this.b;
    if (paramHttpStream != null) {}
    try
    {
      if (paramHttpStream != this.g) {
        throw new IllegalStateException("expected " + this.g + " but was " + paramHttpStream);
      }
    }
    finally
    {
      throw paramHttpStream;
    }
  }
  
  public void a(RealConnection paramRealConnection)
  {
    paramRealConnection.f.add(new WeakReference(this));
  }
  
  public boolean a(RouteException paramRouteException)
  {
    if (this.d != null) {
      a(paramRouteException.a());
    }
    return ((this.c == null) || (this.c.a())) && (b(paramRouteException));
  }
  
  public boolean a(IOException paramIOException, Sink paramSink)
  {
    int i;
    if (this.d != null)
    {
      i = this.d.c;
      a(paramIOException);
      if (i != 1) {}
    }
    for (;;)
    {
      return false;
      if ((paramSink == null) || ((paramSink instanceof RetryableSink))) {}
      for (i = 1; ((this.c == null) || (this.c.a())) && (b(paramIOException)) && (i != 0); i = 0) {
        return true;
      }
    }
  }
  
  public void b()
  {
    a(false, true, false);
  }
  
  public void c()
  {
    a(true, false, false);
  }
  
  public void d()
  {
    RealConnection localRealConnection;
    do
    {
      synchronized (this.b)
      {
        this.f = true;
        HttpStream localHttpStream = this.g;
        localRealConnection = this.d;
        if (localHttpStream != null)
        {
          localHttpStream.a();
          return;
        }
      }
    } while (localRealConnection == null);
    localRealConnection.c();
  }
  
  public void e()
  {
    a(true, false, true);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}
