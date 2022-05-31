package com.squareup.okhttp.internal.http;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RouteException
  extends Exception
{
  private static final Method a;
  private IOException b;
  
  static
  {
    try
    {
      Method localMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      a = localMethod;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public RouteException(IOException paramIOException)
  {
    super(paramIOException);
    this.b = paramIOException;
  }
  
  private void a(IOException paramIOException1, IOException paramIOException2)
  {
    if (a != null) {}
    try
    {
      a.invoke(paramIOException1, new Object[] { paramIOException2 });
      return;
    }
    catch (InvocationTargetException paramIOException1) {}catch (IllegalAccessException paramIOException1) {}
  }
  
  public IOException a()
  {
    return this.b;
  }
  
  public void a(IOException paramIOException)
  {
    a(paramIOException, this.b);
    this.b = paramIOException;
  }
}
