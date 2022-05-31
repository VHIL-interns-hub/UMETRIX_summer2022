package okio;

public abstract class ForwardingSource
  implements Source
{
  private final Source a;
  
  public ForwardingSource(Source paramSource)
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramSource;
  }
  
  public long a(Buffer paramBuffer, long paramLong)
  {
    return this.a.a(paramBuffer, paramLong);
  }
  
  public Timeout a()
  {
    return this.a.a();
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.a.toString() + ")";
  }
}
