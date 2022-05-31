package okio;

import java.io.Closeable;

public abstract interface Source
  extends Closeable
{
  public abstract long a(Buffer paramBuffer, long paramLong);
  
  public abstract Timeout a();
  
  public abstract void close();
}
