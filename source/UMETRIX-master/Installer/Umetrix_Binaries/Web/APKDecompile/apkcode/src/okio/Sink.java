package okio;

import java.io.Closeable;
import java.io.Flushable;

public abstract interface Sink
  extends Closeable, Flushable
{
  public abstract Timeout a();
  
  public abstract void a_(Buffer paramBuffer, long paramLong);
  
  public abstract void close();
  
  public abstract void flush();
}
