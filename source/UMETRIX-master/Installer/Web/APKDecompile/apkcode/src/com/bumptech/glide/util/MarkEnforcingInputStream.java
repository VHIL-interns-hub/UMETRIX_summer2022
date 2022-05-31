package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.InputStream;

public class MarkEnforcingInputStream
  extends FilterInputStream
{
  private int a = Integer.MIN_VALUE;
  
  public MarkEnforcingInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private long a(long paramLong)
  {
    long l;
    if (this.a == 0) {
      l = -1L;
    }
    do
    {
      do
      {
        return l;
        l = paramLong;
      } while (this.a == Integer.MIN_VALUE);
      l = paramLong;
    } while (paramLong <= this.a);
    return this.a;
  }
  
  private void b(long paramLong)
  {
    if ((this.a != Integer.MIN_VALUE) && (paramLong != -1L)) {
      this.a = ((int)(this.a - paramLong));
    }
  }
  
  public int available()
  {
    if (this.a == Integer.MIN_VALUE) {
      return super.available();
    }
    return Math.min(this.a, super.available());
  }
  
  public void mark(int paramInt)
  {
    super.mark(paramInt);
    this.a = paramInt;
  }
  
  public int read()
  {
    if (a(1L) == -1L) {
      return -1;
    }
    int i = super.read();
    b(1L);
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = (int)a(paramInt2);
    if (paramInt2 == -1) {
      return -1;
    }
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    b(paramInt1);
    return paramInt1;
  }
  
  public void reset()
  {
    super.reset();
    this.a = Integer.MIN_VALUE;
  }
  
  public long skip(long paramLong)
  {
    paramLong = a(paramLong);
    if (paramLong == -1L) {
      return -1L;
    }
    paramLong = super.skip(paramLong);
    b(paramLong);
    return paramLong;
  }
}
