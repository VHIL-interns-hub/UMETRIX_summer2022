package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class Timeout
{
  public static final Timeout b = new Timeout.1();
  private boolean a;
  private long c;
  private long d;
  
  public Timeout() {}
  
  public Timeout a(long paramLong)
  {
    this.a = true;
    this.c = paramLong;
    return this;
  }
  
  public Timeout a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0: " + paramLong);
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    this.d = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  public long d()
  {
    if (!this.a) {
      throw new IllegalStateException("No deadline");
    }
    return this.c;
  }
  
  public long d_()
  {
    return this.d;
  }
  
  public boolean e_()
  {
    return this.a;
  }
  
  public Timeout f()
  {
    this.a = false;
    return this;
  }
  
  public Timeout f_()
  {
    this.d = 0L;
    return this;
  }
  
  public void g()
  {
    if (Thread.interrupted()) {
      throw new InterruptedIOException("thread interrupted");
    }
    if ((this.a) && (this.c - System.nanoTime() <= 0L)) {
      throw new InterruptedIOException("deadline reached");
    }
  }
}
