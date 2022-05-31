package net.fred.feedex.utils;

import android.database.ContentObserver;
import android.os.Handler;
import android.os.SystemClock;

public abstract class ThrottledContentObserver
  extends ContentObserver
{
  private final long a;
  private final Handler b;
  private Runnable c = null;
  
  public ThrottledContentObserver(Handler paramHandler, long paramLong)
  {
    super(paramHandler);
    this.a = paramLong;
    this.b = paramHandler;
  }
  
  public abstract void a();
  
  public void onChange(boolean paramBoolean)
  {
    if (this.c == null)
    {
      this.c = new ThrottledContentObserver.1(this);
      long l = SystemClock.uptimeMillis();
      this.b.postAtTime(this.c, l + this.a);
    }
    super.onChange(paramBoolean);
  }
}
