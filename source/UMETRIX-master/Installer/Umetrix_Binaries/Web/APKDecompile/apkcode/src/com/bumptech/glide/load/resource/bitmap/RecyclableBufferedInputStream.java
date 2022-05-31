package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream
  extends FilterInputStream
{
  private volatile byte[] a;
  private int b;
  private int c;
  private int d = -1;
  private int e;
  
  public RecyclableBufferedInputStream(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    super(paramInputStream);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      throw new IllegalArgumentException("buffer is null or empty");
    }
    this.a = paramArrayOfByte;
  }
  
  private int a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    if ((this.d == -1) || (this.e - this.d >= this.c))
    {
      i = paramInputStream.read(paramArrayOfByte);
      if (i > 0)
      {
        this.d = -1;
        this.e = 0;
        this.b = i;
      }
      return i;
    }
    int j;
    byte[] arrayOfByte;
    if ((this.d == 0) && (this.c > paramArrayOfByte.length) && (this.b == paramArrayOfByte.length))
    {
      j = paramArrayOfByte.length * 2;
      i = j;
      if (j > this.c) {
        i = this.c;
      }
      if (Log.isLoggable("BufferedIs", 3)) {
        Log.d("BufferedIs", "allocate buffer of length: " + i);
      }
      arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      this.a = arrayOfByte;
      this.e -= this.d;
      this.d = 0;
      this.b = 0;
      j = paramInputStream.read(arrayOfByte, this.e, arrayOfByte.length - this.e);
      if (j > 0) {
        break label248;
      }
    }
    label248:
    for (int i = this.e;; i = this.e + j)
    {
      this.b = i;
      return j;
      arrayOfByte = paramArrayOfByte;
      if (this.d <= 0) {
        break;
      }
      System.arraycopy(paramArrayOfByte, this.d, paramArrayOfByte, 0, paramArrayOfByte.length - this.d);
      arrayOfByte = paramArrayOfByte;
      break;
    }
  }
  
  private static IOException b()
  {
    throw new IOException("BufferedInputStream is closed");
  }
  
  public void a()
  {
    try
    {
      this.c = this.a.length;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int available()
  {
    try
    {
      InputStream localInputStream = this.in;
      if ((this.a == null) || (localInputStream == null)) {
        throw b();
      }
    }
    finally {}
    int i = this.b;
    int j = this.e;
    int k = localObject.available();
    return k + (i - j);
  }
  
  public void close()
  {
    this.a = null;
    InputStream localInputStream = this.in;
    this.in = null;
    if (localInputStream != null) {
      localInputStream.close();
    }
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.c = Math.max(this.c, paramInt);
      this.d = this.e;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    int i = -1;
    byte[] arrayOfByte2;
    try
    {
      arrayOfByte2 = this.a;
      InputStream localInputStream1 = this.in;
      if ((arrayOfByte2 == null) || (localInputStream1 == null)) {
        throw b();
      }
    }
    finally {}
    if (this.e >= this.b)
    {
      int j = a(localInputStream2, arrayOfByte2);
      if (j != -1) {}
    }
    for (;;)
    {
      return i;
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 != this.a)
      {
        arrayOfByte2 = this.a;
        arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2 == null) {
          throw b();
        }
      }
      if (this.b - this.e > 0)
      {
        i = this.e;
        this.e = (i + 1);
        i = arrayOfByte1[i];
        i &= 0xFF;
      }
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = -1;
    Object localObject2;
    try
    {
      localObject2 = this.a;
      if (localObject2 == null) {
        throw b();
      }
    }
    finally {}
    if (paramInt2 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      return paramInt1;
      InputStream localInputStream = this.in;
      if (localInputStream == null) {
        throw b();
      }
      int i;
      label132:
      int m;
      int j;
      Object localObject1;
      if (this.e < this.b)
      {
        if (this.b - this.e >= paramInt2) {}
        for (i = paramInt2;; i = this.b - this.e)
        {
          System.arraycopy(localObject2, this.e, paramArrayOfByte, paramInt1, i);
          this.e += i;
          if (i == paramInt2) {
            break;
          }
          if (localInputStream.available() != 0) {
            break label348;
          }
          break;
        }
        if ((this.d == -1) && (i >= localObject2.length))
        {
          m = localInputStream.read(paramArrayOfByte, paramInt1, i);
          j = m;
          localObject1 = localObject2;
          if (m != -1) {
            break label368;
          }
          paramInt1 = k;
          if (i == paramInt2) {
            continue;
          }
          paramInt1 = paramInt2 - i;
          continue;
        }
        if (a(localInputStream, (byte[])localObject2) == -1)
        {
          paramInt1 = k;
          if (i == paramInt2) {
            continue;
          }
          paramInt1 = paramInt2 - i;
          continue;
        }
        localObject1 = localObject2;
        if (localObject2 != this.a)
        {
          localObject2 = this.a;
          localObject1 = localObject2;
          if (localObject2 == null) {
            throw b();
          }
        }
        if (this.b - this.e >= i) {}
        for (j = i;; j = this.b - this.e)
        {
          System.arraycopy(localObject1, this.e, paramArrayOfByte, paramInt1, j);
          this.e += j;
          break;
        }
      }
      label348:
      label368:
      do
      {
        m = localInputStream.available();
        if (m == 0)
        {
          paramInt1 = paramInt2 - i;
          break;
        }
        paramInt1 += j;
        localObject2 = localObject1;
        break label132;
        paramInt1 = i;
        break;
        paramInt1 += i;
        i = paramInt2 - i;
        break label132;
        i = paramInt2;
        break label132;
        i -= j;
      } while (i != 0);
      paramInt1 = paramInt2;
    }
  }
  
  public void reset()
  {
    try
    {
      if (this.a == null) {
        throw new IOException("Stream is closed");
      }
    }
    finally {}
    if (-1 == this.d) {
      throw new RecyclableBufferedInputStream.InvalidMarkException("Mark has been invalidated");
    }
    this.e = this.d;
  }
  
  public long skip(long paramLong)
  {
    InputStream localInputStream;
    try
    {
      byte[] arrayOfByte1 = this.a;
      localInputStream = this.in;
      if (arrayOfByte1 == null) {
        throw b();
      }
    }
    finally {}
    if (paramLong < 1L) {
      paramLong = 0L;
    }
    for (;;)
    {
      return paramLong;
      if (localInputStream == null) {
        throw b();
      }
      if (this.b - this.e >= paramLong)
      {
        this.e = ((int)(this.e + paramLong));
      }
      else
      {
        long l = this.b - this.e;
        this.e = this.b;
        if ((this.d != -1) && (paramLong <= this.c))
        {
          if (a(localInputStream, arrayOfByte2) == -1)
          {
            paramLong = l;
          }
          else if (this.b - this.e >= paramLong - l)
          {
            this.e = ((int)(paramLong - l + this.e));
          }
          else
          {
            paramLong = l + this.b - this.e;
            this.e = this.b;
          }
        }
        else
        {
          paramLong = localInputStream.skip(paramLong - l);
          paramLong = l + paramLong;
        }
      }
    }
  }
}
