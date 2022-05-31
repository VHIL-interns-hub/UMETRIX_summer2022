package com.squareup.okhttp.internal;

public abstract class NamedRunnable
  implements Runnable
{
  protected final String a;
  
  public NamedRunnable(String paramString, Object... paramVarArgs)
  {
    this.a = String.format(paramString, paramVarArgs);
  }
  
  protected abstract void a();
  
  public final void run()
  {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.a);
    try
    {
      a();
      return;
    }
    finally
    {
      Thread.currentThread().setName(str);
    }
  }
}
