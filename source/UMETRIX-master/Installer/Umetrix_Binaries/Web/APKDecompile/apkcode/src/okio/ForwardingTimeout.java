package okio;

import java.util.concurrent.TimeUnit;

public class ForwardingTimeout
  extends Timeout
{
  private Timeout a;
  
  public ForwardingTimeout(Timeout paramTimeout)
  {
    if (paramTimeout == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramTimeout;
  }
  
  public final ForwardingTimeout a(Timeout paramTimeout)
  {
    if (paramTimeout == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramTimeout;
    return this;
  }
  
  public final Timeout a()
  {
    return this.a;
  }
  
  public Timeout a(long paramLong)
  {
    return this.a.a(paramLong);
  }
  
  public Timeout a(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.a(paramLong, paramTimeUnit);
  }
  
  public long d()
  {
    return this.a.d();
  }
  
  public long d_()
  {
    return this.a.d_();
  }
  
  public boolean e_()
  {
    return this.a.e_();
  }
  
  public Timeout f()
  {
    return this.a.f();
  }
  
  public Timeout f_()
  {
    return this.a.f_();
  }
  
  public void g()
  {
    this.a.g();
  }
}
