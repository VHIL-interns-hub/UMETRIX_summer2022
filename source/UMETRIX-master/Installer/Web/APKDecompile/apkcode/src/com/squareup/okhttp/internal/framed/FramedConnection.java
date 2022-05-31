package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;

public final class FramedConnection
  implements Closeable
{
  private static final ExecutorService l;
  final Protocol a;
  final boolean b;
  long c = 0L;
  long d;
  Settings e = new Settings();
  final Settings f = new Settings();
  final Variant g;
  final Socket h;
  final FrameWriter i;
  final FramedConnection.Reader j;
  private final FramedConnection.Listener m;
  private final Map n = new HashMap();
  private final String o;
  private int p;
  private int q;
  private boolean r;
  private long s = System.nanoTime();
  private final ExecutorService t;
  private Map u;
  private final PushObserver v;
  private int w;
  private boolean x = false;
  private final Set y = new LinkedHashSet();
  
  static
  {
    if (!FramedConnection.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      k = bool;
      l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.a("OkHttp FramedConnection", true));
      return;
    }
  }
  
  private FramedConnection(FramedConnection.Builder paramBuilder)
  {
    this.a = FramedConnection.Builder.a(paramBuilder);
    this.v = FramedConnection.Builder.b(paramBuilder);
    this.b = FramedConnection.Builder.c(paramBuilder);
    this.m = FramedConnection.Builder.d(paramBuilder);
    int i1;
    if (FramedConnection.Builder.c(paramBuilder))
    {
      i1 = 1;
      this.q = i1;
      if ((FramedConnection.Builder.c(paramBuilder)) && (this.a == Protocol.d)) {
        this.q += 2;
      }
      i1 = i2;
      if (FramedConnection.Builder.c(paramBuilder)) {
        i1 = 1;
      }
      this.w = i1;
      if (FramedConnection.Builder.c(paramBuilder)) {
        this.e.a(7, 0, 16777216);
      }
      this.o = FramedConnection.Builder.e(paramBuilder);
      if (this.a != Protocol.d) {
        break label370;
      }
      this.g = new Http2();
      this.t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.a(String.format("OkHttp %s Push Observer", new Object[] { this.o }), true));
      this.f.a(7, 0, 65535);
      this.f.a(5, 0, 16384);
    }
    for (;;)
    {
      this.d = this.f.f(65536);
      this.h = FramedConnection.Builder.f(paramBuilder);
      this.i = this.g.a(FramedConnection.Builder.g(paramBuilder), this.b);
      this.j = new FramedConnection.Reader(this, this.g.a(FramedConnection.Builder.h(paramBuilder), this.b), null);
      new Thread(this.j).start();
      return;
      i1 = 2;
      break;
      label370:
      if (this.a != Protocol.c) {
        break label399;
      }
      this.g = new Spdy3();
      this.t = null;
    }
    label399:
    throw new AssertionError(this.a);
  }
  
  private FramedStream a(int paramInt, List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!paramBoolean1)
    {
      bool1 = true;
      if (paramBoolean2) {
        break label64;
      }
    }
    label64:
    for (paramBoolean2 = bool2;; paramBoolean2 = false)
    {
      synchronized (this.i)
      {
        try
        {
          if (!this.r) {
            break label70;
          }
          throw new IOException("shutdown");
        }
        finally {}
      }
      bool1 = false;
      break;
    }
    label70:
    int i1 = this.q;
    this.q += 2;
    FramedStream localFramedStream = new FramedStream(i1, this, bool1, paramBoolean2, paramList);
    if (localFramedStream.b())
    {
      this.n.put(Integer.valueOf(i1), localFramedStream);
      a(false);
    }
    if (paramInt == 0) {
      this.i.a(bool1, paramBoolean2, i1, paramInt, paramList);
    }
    for (;;)
    {
      if (!paramBoolean1) {
        this.i.b();
      }
      return localFramedStream;
      if (this.b) {
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
      }
      this.i.a(paramInt, i1, paramList);
    }
  }
  
  private void a(int paramInt, List paramList)
  {
    try
    {
      if (this.y.contains(Integer.valueOf(paramInt)))
      {
        a(paramInt, ErrorCode.b);
        return;
      }
      this.y.add(Integer.valueOf(paramInt));
      this.t.execute(new FramedConnection.4(this, "OkHttp %s Push Request[%s]", new Object[] { this.o, Integer.valueOf(paramInt) }, paramInt, paramList));
      return;
    }
    finally {}
  }
  
  private void a(int paramInt, List paramList, boolean paramBoolean)
  {
    this.t.execute(new FramedConnection.5(this, "OkHttp %s Push Headers[%s]", new Object[] { this.o, Integer.valueOf(paramInt) }, paramInt, paramList, paramBoolean));
  }
  
  private void a(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean)
  {
    Buffer localBuffer = new Buffer();
    paramBufferedSource.a(paramInt2);
    paramBufferedSource.a(localBuffer, paramInt2);
    if (localBuffer.b() != paramInt2) {
      throw new IOException(localBuffer.b() + " != " + paramInt2);
    }
    this.t.execute(new FramedConnection.6(this, "OkHttp %s Push Data[%s]", new Object[] { this.o, Integer.valueOf(paramInt1) }, paramInt1, localBuffer, paramInt2, paramBoolean));
  }
  
  /* Error */
  private void a(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2)
  {
    // Byte code:
    //   0: getstatic 56	com/squareup/okhttp/internal/framed/FramedConnection:k	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 359	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 223	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 360	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 363	com/squareup/okhttp/internal/framed/FramedConnection:a	(Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 92	com/squareup/okhttp/internal/framed/FramedConnection:n	Ljava/util/Map;
    //   34: invokeinterface 366 1 0
    //   39: ifne +247 -> 286
    //   42: aload_0
    //   43: getfield 92	com/squareup/okhttp/internal/framed/FramedConnection:n	Ljava/util/Map;
    //   46: invokeinterface 370 1 0
    //   51: aload_0
    //   52: getfield 92	com/squareup/okhttp/internal/framed/FramedConnection:n	Ljava/util/Map;
    //   55: invokeinterface 374 1 0
    //   60: anewarray 241	com/squareup/okhttp/internal/framed/FramedStream
    //   63: invokeinterface 380 2 0
    //   68: checkcast 382	[Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   71: astore 6
    //   73: aload_0
    //   74: getfield 92	com/squareup/okhttp/internal/framed/FramedConnection:n	Ljava/util/Map;
    //   77: invokeinterface 385 1 0
    //   82: aload_0
    //   83: iconst_0
    //   84: invokespecial 261	com/squareup/okhttp/internal/framed/FramedConnection:a	(Z)V
    //   87: aload_0
    //   88: getfield 387	com/squareup/okhttp/internal/framed/FramedConnection:u	Ljava/util/Map;
    //   91: ifnull +189 -> 280
    //   94: aload_0
    //   95: getfield 387	com/squareup/okhttp/internal/framed/FramedConnection:u	Ljava/util/Map;
    //   98: invokeinterface 370 1 0
    //   103: aload_0
    //   104: getfield 387	com/squareup/okhttp/internal/framed/FramedConnection:u	Ljava/util/Map;
    //   107: invokeinterface 374 1 0
    //   112: anewarray 389	com/squareup/okhttp/internal/framed/Ping
    //   115: invokeinterface 380 2 0
    //   120: checkcast 391	[Lcom/squareup/okhttp/internal/framed/Ping;
    //   123: astore 7
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 387	com/squareup/okhttp/internal/framed/FramedConnection:u	Ljava/util/Map;
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: astore 5
    //   135: aload 6
    //   137: ifnull +69 -> 206
    //   140: aload 6
    //   142: arraylength
    //   143: istore 4
    //   145: iconst_0
    //   146: istore_3
    //   147: iload_3
    //   148: iload 4
    //   150: if_icmpge +53 -> 203
    //   153: aload 6
    //   155: iload_3
    //   156: aaload
    //   157: astore 5
    //   159: aload 5
    //   161: aload_2
    //   162: invokevirtual 392	com/squareup/okhttp/internal/framed/FramedStream:a	(Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   165: aload_1
    //   166: astore 5
    //   168: iload_3
    //   169: iconst_1
    //   170: iadd
    //   171: istore_3
    //   172: aload 5
    //   174: astore_1
    //   175: goto -28 -> 147
    //   178: astore_1
    //   179: goto -151 -> 28
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    //   187: astore 8
    //   189: aload_1
    //   190: astore 5
    //   192: aload_1
    //   193: ifnull -25 -> 168
    //   196: aload 8
    //   198: astore 5
    //   200: goto -32 -> 168
    //   203: aload_1
    //   204: astore 5
    //   206: aload 7
    //   208: ifnull +30 -> 238
    //   211: aload 7
    //   213: arraylength
    //   214: istore 4
    //   216: iconst_0
    //   217: istore_3
    //   218: iload_3
    //   219: iload 4
    //   221: if_icmpge +17 -> 238
    //   224: aload 7
    //   226: iload_3
    //   227: aaload
    //   228: invokevirtual 394	com/squareup/okhttp/internal/framed/Ping:c	()V
    //   231: iload_3
    //   232: iconst_1
    //   233: iadd
    //   234: istore_3
    //   235: goto -17 -> 218
    //   238: aload_0
    //   239: getfield 195	com/squareup/okhttp/internal/framed/FramedConnection:i	Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   242: invokeinterface 397 1 0
    //   247: aload 5
    //   249: astore_1
    //   250: aload_0
    //   251: getfield 185	com/squareup/okhttp/internal/framed/FramedConnection:h	Ljava/net/Socket;
    //   254: invokevirtual 400	java/net/Socket:close	()V
    //   257: aload_1
    //   258: ifnull +17 -> 275
    //   261: aload_1
    //   262: athrow
    //   263: astore_1
    //   264: aload 5
    //   266: ifnull -16 -> 250
    //   269: aload 5
    //   271: astore_1
    //   272: goto -22 -> 250
    //   275: return
    //   276: astore_1
    //   277: goto -20 -> 257
    //   280: aconst_null
    //   281: astore 7
    //   283: goto -153 -> 130
    //   286: aconst_null
    //   287: astore 6
    //   289: goto -202 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	FramedConnection
    //   0	292	1	paramErrorCode1	ErrorCode
    //   0	292	2	paramErrorCode2	ErrorCode
    //   146	89	3	i1	int
    //   143	79	4	i2	int
    //   133	137	5	localObject	Object
    //   71	217	6	arrayOfFramedStream	FramedStream[]
    //   123	159	7	arrayOfPing	Ping[]
    //   187	10	8	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   21	26	178	java/io/IOException
    //   30	87	182	finally
    //   87	130	182	finally
    //   130	132	182	finally
    //   183	185	182	finally
    //   159	165	187	java/io/IOException
    //   238	247	263	java/io/IOException
    //   250	257	276	java/io/IOException
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        l1 = System.nanoTime();
        this.s = l1;
        return;
      }
      finally {}
      long l1 = Long.MAX_VALUE;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing)
  {
    l.execute(new FramedConnection.3(this, "OkHttp %s ping %08x%08x", new Object[] { this.o, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, paramBoolean, paramInt1, paramInt2, paramPing));
  }
  
  private void b(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing)
  {
    FrameWriter localFrameWriter = this.i;
    if (paramPing != null) {}
    try
    {
      paramPing.a();
      this.i.a(paramBoolean, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  /* Error */
  private Ping c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 387	com/squareup/okhttp/internal/framed/FramedConnection:u	Ljava/util/Map;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 387	com/squareup/okhttp/internal/framed/FramedConnection:u	Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 450 2 0
    //   22: checkcast 389	com/squareup/okhttp/internal/framed/Ping
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	FramedConnection
    //   0	40	1	paramInt	int
    //   25	7	2	localPing	Ping
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  private void c(int paramInt, ErrorCode paramErrorCode)
  {
    this.t.execute(new FramedConnection.7(this, "OkHttp %s Push Reset[%s]", new Object[] { this.o, Integer.valueOf(paramInt) }, paramInt, paramErrorCode));
  }
  
  private boolean d(int paramInt)
  {
    return (this.a == Protocol.d) && (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  public Protocol a()
  {
    return this.a;
  }
  
  FramedStream a(int paramInt)
  {
    try
    {
      FramedStream localFramedStream = (FramedStream)this.n.get(Integer.valueOf(paramInt));
      return localFramedStream;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public FramedStream a(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(0, paramList, paramBoolean1, paramBoolean2);
  }
  
  void a(int paramInt, long paramLong)
  {
    l.execute(new FramedConnection.2(this, "OkHttp Window Update %s stream %d", new Object[] { this.o, Integer.valueOf(paramInt) }, paramInt, paramLong));
  }
  
  void a(int paramInt, ErrorCode paramErrorCode)
  {
    l.submit(new FramedConnection.1(this, "OkHttp %s stream %d", new Object[] { this.o, Integer.valueOf(paramInt) }, paramInt, paramErrorCode));
  }
  
  public void a(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      this.i.a(paramBoolean, paramInt, paramBuffer, 0);
      return;
    }
    for (;;)
    {
      try
      {
        int i1 = Math.min((int)Math.min(l1, this.d), this.i.c());
        this.d -= i1;
        l1 -= i1;
        FrameWriter localFrameWriter = this.i;
        if ((!paramBoolean) || (l1 != 0L)) {
          break label170;
        }
        bool = true;
        localFrameWriter.a(bool, paramInt, paramBuffer, i1);
        if (l1 <= 0L) {
          break;
        }
        try
        {
          if (this.d > 0L) {
            continue;
          }
          if (!this.n.containsKey(Integer.valueOf(paramInt))) {
            throw new IOException("stream closed");
          }
        }
        catch (InterruptedException paramBuffer)
        {
          throw new InterruptedIOException();
        }
        wait();
      }
      finally {}
      continue;
      label170:
      boolean bool = false;
    }
  }
  
  void a(long paramLong)
  {
    this.d += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void a(ErrorCode paramErrorCode)
  {
    int i1;
    synchronized (this.i) {}
  }
  
  public int b()
  {
    try
    {
      int i1 = this.f.d(Integer.MAX_VALUE);
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  FramedStream b(int paramInt)
  {
    try
    {
      FramedStream localFramedStream = (FramedStream)this.n.remove(Integer.valueOf(paramInt));
      if ((localFramedStream != null) && (this.n.isEmpty())) {
        a(true);
      }
      notifyAll();
      return localFramedStream;
    }
    finally {}
  }
  
  void b(int paramInt, ErrorCode paramErrorCode)
  {
    this.i.a(paramInt, paramErrorCode);
  }
  
  public void c()
  {
    this.i.b();
  }
  
  public void close()
  {
    a(ErrorCode.a, ErrorCode.l);
  }
  
  public void d()
  {
    this.i.a();
    this.i.b(this.e);
    int i1 = this.e.f(65536);
    if (i1 != 65536) {
      this.i.a(0, i1 - 65536);
    }
  }
}
