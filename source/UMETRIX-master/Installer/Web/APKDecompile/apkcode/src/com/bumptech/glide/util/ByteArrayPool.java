package com.bumptech.glide.util;

import android.util.Log;
import java.util.Queue;

public final class ByteArrayPool
{
  private static final ByteArrayPool b = new ByteArrayPool();
  private final Queue a = Util.a(0);
  
  private ByteArrayPool() {}
  
  public static ByteArrayPool a()
  {
    return b;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramArrayOfByte.length != 65536) {
      return false;
    }
    synchronized (this.a)
    {
      if (this.a.size() < 32)
      {
        bool = true;
        this.a.offer(paramArrayOfByte);
      }
      return bool;
    }
  }
  
  public byte[] b()
  {
    synchronized (this.a)
    {
      byte[] arrayOfByte = (byte[])this.a.poll();
      ??? = arrayOfByte;
      if (arrayOfByte == null)
      {
        arrayOfByte = new byte[65536];
        ??? = arrayOfByte;
        if (Log.isLoggable("ByteArrayPool", 3))
        {
          Log.d("ByteArrayPool", "Created temp bytes");
          ??? = arrayOfByte;
        }
      }
      return ???;
    }
  }
}
