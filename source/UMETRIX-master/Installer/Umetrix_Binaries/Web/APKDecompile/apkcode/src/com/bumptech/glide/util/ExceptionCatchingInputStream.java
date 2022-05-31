package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class ExceptionCatchingInputStream
  extends InputStream
{
  private static final Queue a = Util.a(0);
  private InputStream b;
  private IOException c;
  
  ExceptionCatchingInputStream() {}
  
  public static ExceptionCatchingInputStream a(InputStream paramInputStream)
  {
    synchronized (a)
    {
      ExceptionCatchingInputStream localExceptionCatchingInputStream = (ExceptionCatchingInputStream)a.poll();
      ??? = localExceptionCatchingInputStream;
      if (localExceptionCatchingInputStream == null) {
        ??? = new ExceptionCatchingInputStream();
      }
      ((ExceptionCatchingInputStream)???).b(paramInputStream);
      return ???;
    }
  }
  
  public IOException a()
  {
    return this.c;
  }
  
  public int available()
  {
    return this.b.available();
  }
  
  public void b()
  {
    this.c = null;
    this.b = null;
    synchronized (a)
    {
      a.offer(this);
      return;
    }
  }
  
  void b(InputStream paramInputStream)
  {
    this.b = paramInputStream;
  }
  
  public void close()
  {
    this.b.close();
  }
  
  public void mark(int paramInt)
  {
    this.b.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.b.markSupported();
  }
  
  public int read()
  {
    try
    {
      int i = this.b.read();
      return i;
    }
    catch (IOException localIOException)
    {
      this.c = localIOException;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    try
    {
      int i = this.b.read(paramArrayOfByte);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      this.c = paramArrayOfByte;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = this.b.read(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      this.c = paramArrayOfByte;
    }
    return -1;
  }
  
  public void reset()
  {
    try
    {
      this.b.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long skip(long paramLong)
  {
    try
    {
      paramLong = this.b.skip(paramLong);
      return paramLong;
    }
    catch (IOException localIOException)
    {
      this.c = localIOException;
    }
    return 0L;
  }
}
