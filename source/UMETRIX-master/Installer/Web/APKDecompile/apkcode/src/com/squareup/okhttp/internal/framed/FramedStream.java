package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class FramedStream
{
  long a = 0L;
  long b;
  final FramedStream.FramedDataSink c;
  private final int e;
  private final FramedConnection f;
  private final List g;
  private List h;
  private final FramedStream.FramedDataSource i;
  private final FramedStream.StreamTimeout j = new FramedStream.StreamTimeout(this);
  private final FramedStream.StreamTimeout k = new FramedStream.StreamTimeout(this);
  private ErrorCode l = null;
  
  static
  {
    if (!FramedStream.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      return;
    }
  }
  
  FramedStream(int paramInt, FramedConnection paramFramedConnection, boolean paramBoolean1, boolean paramBoolean2, List paramList)
  {
    if (paramFramedConnection == null) {
      throw new NullPointerException("connection == null");
    }
    if (paramList == null) {
      throw new NullPointerException("requestHeaders == null");
    }
    this.e = paramInt;
    this.f = paramFramedConnection;
    this.b = paramFramedConnection.f.f(65536);
    this.i = new FramedStream.FramedDataSource(this, paramFramedConnection.e.f(65536), null);
    this.c = new FramedStream.FramedDataSink(this);
    FramedStream.FramedDataSource.a(this.i, paramBoolean2);
    FramedStream.FramedDataSink.a(this.c, paramBoolean1);
    this.g = paramList;
  }
  
  private boolean d(ErrorCode paramErrorCode)
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      if (this.l != null) {
        return false;
      }
      if ((FramedStream.FramedDataSource.a(this.i)) && (FramedStream.FramedDataSink.a(this.c))) {
        return false;
      }
    }
    finally {}
    this.l = paramErrorCode;
    notifyAll();
    this.f.b(this.e);
    return true;
  }
  
  private void j()
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!FramedStream.FramedDataSource.a(this.i)) && (FramedStream.FramedDataSource.b(this.i)))
        {
          if (FramedStream.FramedDataSink.a(this.c)) {
            break label112;
          }
          if (FramedStream.FramedDataSink.b(this.c))
          {
            break label112;
            bool = b();
            if (m == 0) {
              break label95;
            }
            a(ErrorCode.l);
            return;
          }
        }
        m = 0;
        continue;
        if (bool) {
          continue;
        }
      }
      finally {}
      label95:
      this.f.b(this.e);
      return;
      label112:
      int m = 1;
    }
  }
  
  private void k()
  {
    if (FramedStream.FramedDataSink.b(this.c)) {
      throw new IOException("stream closed");
    }
    if (FramedStream.FramedDataSink.a(this.c)) {
      throw new IOException("stream finished");
    }
    if (this.l != null) {
      throw new IOException("stream was reset: " + this.l);
    }
  }
  
  private void l()
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new InterruptedIOException();
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  void a(long paramLong)
  {
    this.b += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void a(ErrorCode paramErrorCode)
  {
    if (!d(paramErrorCode)) {
      return;
    }
    this.f.b(this.e, paramErrorCode);
  }
  
  void a(List paramList, HeadersMode paramHeadersMode)
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    Object localObject = null;
    boolean bool = true;
    label97:
    do
    {
      for (;;)
      {
        try
        {
          if (this.h == null)
          {
            if (paramHeadersMode.c())
            {
              paramList = ErrorCode.b;
              if (paramList == null) {
                break;
              }
              b(paramList);
              return;
            }
            this.h = paramList;
            bool = b();
            notifyAll();
            paramList = localObject;
            continue;
          }
          if (!paramHeadersMode.d()) {
            break label97;
          }
        }
        finally {}
        paramList = ErrorCode.e;
        continue;
        paramHeadersMode = new ArrayList();
        paramHeadersMode.addAll(this.h);
        paramHeadersMode.addAll(paramList);
        this.h = paramHeadersMode;
        paramList = localObject;
      }
    } while (bool);
    this.f.b(this.e);
  }
  
  void a(BufferedSource paramBufferedSource, int paramInt)
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    this.i.a(paramBufferedSource, paramInt);
  }
  
  public void b(ErrorCode paramErrorCode)
  {
    if (!d(paramErrorCode)) {
      return;
    }
    this.f.a(this.e, paramErrorCode);
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 53	com/squareup/okhttp/internal/framed/FramedStream:l	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 88	com/squareup/okhttp/internal/framed/FramedStream:i	Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;
    //   21: invokestatic 118	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:a	(Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;)Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 88	com/squareup/okhttp/internal/framed/FramedStream:i	Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;
    //   31: invokestatic 135	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:b	(Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;)Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 93	com/squareup/okhttp/internal/framed/FramedStream:c	Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   41: invokestatic 121	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:a	(Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;)Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 93	com/squareup/okhttp/internal/framed/FramedStream:c	Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   51: invokestatic 137	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:b	(Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;)Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 186	com/squareup/okhttp/internal/framed/FramedStream:h	Ljava/util/List;
    //   61: astore_2
    //   62: aload_2
    //   63: ifnonnull -50 -> 13
    //   66: iconst_1
    //   67: istore_1
    //   68: goto -55 -> 13
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	FramedStream
    //   1	67	1	bool	boolean
    //   8	55	2	localObject1	Object
    //   71	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  void c(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.l == null)
      {
        this.l = paramErrorCode;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramErrorCode = finally;
      throw paramErrorCode;
    }
  }
  
  public boolean c()
  {
    if ((this.e & 0x1) == 1) {}
    for (int m = 1; this.f.b == m; m = 0) {
      return true;
    }
    return false;
  }
  
  public List d()
  {
    try
    {
      this.j.c();
    }
    finally
    {
      try
      {
        while ((this.h == null) && (this.l == null)) {
          l();
        }
      }
      finally
      {
        this.j.b();
      }
    }
    this.j.b();
    if (this.h != null)
    {
      List localList = this.h;
      return localList;
    }
    throw new IOException("stream was reset: " + this.l);
  }
  
  public Timeout e()
  {
    return this.j;
  }
  
  public Timeout f()
  {
    return this.k;
  }
  
  public Source g()
  {
    return this.i;
  }
  
  public Sink h()
  {
    try
    {
      if ((this.h == null) && (!c())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
    }
    finally {}
    return this.c;
  }
  
  void i()
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      FramedStream.FramedDataSource.a(this.i, true);
      boolean bool = b();
      notifyAll();
      if (!bool) {
        this.f.b(this.e);
      }
      return;
    }
    finally {}
  }
}
