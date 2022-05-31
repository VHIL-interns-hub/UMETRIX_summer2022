package okio;

import java.io.IOException;
import java.io.InterruptedIOException;

public class AsyncTimeout
  extends Timeout
{
  private static AsyncTimeout a;
  private boolean c;
  private AsyncTimeout d;
  private long e;
  
  public AsyncTimeout() {}
  
  private static void a(AsyncTimeout paramAsyncTimeout, long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (a == null)
        {
          a = new AsyncTimeout();
          new AsyncTimeout.Watchdog().start();
        }
        long l = System.nanoTime();
        if ((paramLong != 0L) && (paramBoolean))
        {
          paramAsyncTimeout.e = (Math.min(paramLong, paramAsyncTimeout.d() - l) + l);
          paramLong = paramAsyncTimeout.b(l);
          localAsyncTimeout = a;
          if ((localAsyncTimeout.d != null) && (paramLong >= localAsyncTimeout.d.b(l))) {
            break label175;
          }
          paramAsyncTimeout.d = localAsyncTimeout.d;
          localAsyncTimeout.d = paramAsyncTimeout;
          if (localAsyncTimeout == a) {
            AsyncTimeout.class.notify();
          }
          return;
        }
        if (paramLong != 0L)
        {
          paramAsyncTimeout.e = (l + paramLong);
          continue;
        }
        if (!paramBoolean) {
          break label167;
        }
      }
      finally {}
      paramAsyncTimeout.e = paramAsyncTimeout.d();
      continue;
      label167:
      throw new AssertionError();
      label175:
      AsyncTimeout localAsyncTimeout = localAsyncTimeout.d;
    }
  }
  
  /* Error */
  private static boolean a(AsyncTimeout paramAsyncTimeout)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 19	okio/AsyncTimeout:a	Lokio/AsyncTimeout;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +39 -> 47
    //   11: aload_2
    //   12: getfield 48	okio/AsyncTimeout:d	Lokio/AsyncTimeout;
    //   15: aload_0
    //   16: if_acmpne +23 -> 39
    //   19: aload_2
    //   20: aload_0
    //   21: getfield 48	okio/AsyncTimeout:d	Lokio/AsyncTimeout;
    //   24: putfield 48	okio/AsyncTimeout:d	Lokio/AsyncTimeout;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 48	okio/AsyncTimeout:d	Lokio/AsyncTimeout;
    //   32: iconst_0
    //   33: istore_1
    //   34: ldc 2
    //   36: monitorexit
    //   37: iload_1
    //   38: ireturn
    //   39: aload_2
    //   40: getfield 48	okio/AsyncTimeout:d	Lokio/AsyncTimeout;
    //   43: astore_2
    //   44: goto -37 -> 7
    //   47: iconst_1
    //   48: istore_1
    //   49: goto -15 -> 34
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramAsyncTimeout	AsyncTimeout
    //   33	16	1	bool	boolean
    //   6	38	2	localAsyncTimeout	AsyncTimeout
    // Exception table:
    //   from	to	target	type
    //   3	7	52	finally
    //   11	32	52	finally
    //   39	44	52	finally
  }
  
  private long b(long paramLong)
  {
    return this.e - paramLong;
  }
  
  private static AsyncTimeout h()
  {
    AsyncTimeout localAsyncTimeout1 = null;
    for (;;)
    {
      AsyncTimeout localAsyncTimeout2;
      try
      {
        localAsyncTimeout2 = a.d;
        if (localAsyncTimeout2 == null)
        {
          AsyncTimeout.class.wait();
          return localAsyncTimeout1;
        }
        long l1 = localAsyncTimeout2.b(System.nanoTime());
        if (l1 > 0L)
        {
          long l2 = l1 / 1000000L;
          AsyncTimeout.class.wait(l2, (int)(l1 - 1000000L * l2));
          continue;
        }
        a.d = localAsyncTimeout2.d;
      }
      finally {}
      localAsyncTimeout2.d = null;
      Object localObject2 = localAsyncTimeout2;
    }
  }
  
  protected IOException a(IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  public final Sink a(Sink paramSink)
  {
    return new AsyncTimeout.1(this, paramSink);
  }
  
  public final Source a(Source paramSource)
  {
    return new AsyncTimeout.2(this, paramSource);
  }
  
  protected void a() {}
  
  final void a(boolean paramBoolean)
  {
    if ((c_()) && (paramBoolean)) {
      throw a(null);
    }
  }
  
  final IOException b(IOException paramIOException)
  {
    if (!c_()) {
      return paramIOException;
    }
    return a(paramIOException);
  }
  
  public final void c()
  {
    if (this.c) {
      throw new IllegalStateException("Unbalanced enter/exit");
    }
    long l = d_();
    boolean bool = e_();
    if ((l == 0L) && (!bool)) {
      return;
    }
    this.c = true;
    a(this, l, bool);
  }
  
  public final boolean c_()
  {
    if (!this.c) {
      return false;
    }
    this.c = false;
    return a(this);
  }
}
