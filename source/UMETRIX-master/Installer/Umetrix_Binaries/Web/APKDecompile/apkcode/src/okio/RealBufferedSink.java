package okio;

import java.io.OutputStream;

final class RealBufferedSink
  implements BufferedSink
{
  public final Buffer a;
  public final Sink b;
  private boolean c;
  
  public RealBufferedSink(Sink paramSink)
  {
    this(paramSink, new Buffer());
  }
  
  public RealBufferedSink(Sink paramSink, Buffer paramBuffer)
  {
    if (paramSink == null) {
      throw new IllegalArgumentException("sink == null");
    }
    this.a = paramBuffer;
    this.b = paramSink;
  }
  
  public long a(Source paramSource)
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l1 = 0L;
    for (;;)
    {
      long l2 = paramSource.a(this.a, 2048L);
      if (l2 == -1L) {
        break;
      }
      l1 += l2;
      v();
    }
    return l1;
  }
  
  public Timeout a()
  {
    return this.b.a();
  }
  
  public void a_(Buffer paramBuffer, long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a_(paramBuffer, paramLong);
    v();
  }
  
  public BufferedSink b(String paramString)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramString);
    return v();
  }
  
  public BufferedSink b(ByteString paramByteString)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramByteString);
    return v();
  }
  
  public Buffer c()
  {
    return this.a;
  }
  
  public BufferedSink c(byte[] paramArrayOfByte)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramArrayOfByte);
    return v();
  }
  
  public BufferedSink c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramArrayOfByte, paramInt1, paramInt2);
    return v();
  }
  
  public void close()
  {
    if (this.c) {}
    do
    {
      return;
      localObject2 = null;
      localObject1 = localObject2;
      for (;;)
      {
        try
        {
          if (this.a.b > 0L)
          {
            this.b.a_(this.a, this.a.b);
            localObject1 = localObject2;
          }
        }
        catch (Throwable localThrowable1)
        {
          continue;
        }
        try
        {
          this.b.close();
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable2)
        {
          localObject2 = localObject1;
          if (localObject1 != null) {
            continue;
          }
          localObject2 = localThrowable2;
        }
      }
      this.c = true;
    } while (localObject2 == null);
    Util.a(localObject2);
  }
  
  public OutputStream d()
  {
    return new RealBufferedSink.1(this);
  }
  
  public BufferedSink f()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    long l = this.a.b();
    if (l > 0L) {
      this.b.a_(this.a, l);
    }
    return this;
  }
  
  public BufferedSink f(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.d(paramInt);
    return v();
  }
  
  public void flush()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if (this.a.b > 0L) {
      this.b.a_(this.a, this.a.b);
    }
    this.b.flush();
  }
  
  public BufferedSink g(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.c(paramInt);
    return v();
  }
  
  public BufferedSink h(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramInt);
    return v();
  }
  
  public BufferedSink i(long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.h(paramLong);
    return v();
  }
  
  public String toString()
  {
    return "buffer(" + this.b + ")";
  }
  
  public BufferedSink v()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    long l = this.a.i();
    if (l > 0L) {
      this.b.a_(this.a, l);
    }
    return this;
  }
}
