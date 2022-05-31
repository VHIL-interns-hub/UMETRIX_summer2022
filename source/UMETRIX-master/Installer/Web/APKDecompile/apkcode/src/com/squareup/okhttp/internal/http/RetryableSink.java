package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.net.ProtocolException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

public final class RetryableSink
  implements Sink
{
  private boolean a;
  private final int b;
  private final Buffer c = new Buffer();
  
  public RetryableSink()
  {
    this(-1);
  }
  
  public RetryableSink(int paramInt)
  {
    this.b = paramInt;
  }
  
  public Timeout a()
  {
    return Timeout.b;
  }
  
  public void a(Sink paramSink)
  {
    Buffer localBuffer = new Buffer();
    this.c.a(localBuffer, 0L, this.c.b());
    paramSink.a_(localBuffer, localBuffer.b());
  }
  
  public void a_(Buffer paramBuffer, long paramLong)
  {
    if (this.a) {
      throw new IllegalStateException("closed");
    }
    Util.a(paramBuffer.b(), 0L, paramLong);
    if ((this.b != -1) && (this.c.b() > this.b - paramLong)) {
      throw new ProtocolException("exceeded content-length limit of " + this.b + " bytes");
    }
    this.c.a_(paramBuffer, paramLong);
  }
  
  public long b()
  {
    return this.c.b();
  }
  
  public void close()
  {
    if (this.a) {}
    do
    {
      return;
      this.a = true;
    } while (this.c.b() >= this.b);
    throw new ProtocolException("content-length promised " + this.b + " bytes, but received " + this.c.b());
  }
  
  public void flush() {}
}
