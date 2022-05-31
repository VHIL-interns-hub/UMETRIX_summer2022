package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

public class GifHeaderParser
{
  private final byte[] a = new byte['?'];
  private ByteBuffer b;
  private GifHeader c;
  private int d = 0;
  
  public GifHeaderParser() {}
  
  private int[] a(int paramInt)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramInt * 3];
    try
    {
      this.b.get(arrayOfByte);
      int[] arrayOfInt2 = new int['?'];
      int j = 0;
      int[] arrayOfInt1;
      for (;;)
      {
        arrayOfInt1 = arrayOfInt2;
        if (i >= paramInt) {
          break;
        }
        int n = j + 1;
        int k = arrayOfByte[j];
        int m = n + 1;
        n = arrayOfByte[n];
        j = m + 1;
        arrayOfInt2[i] = ((k & 0xFF) << 16 | 0xFF000000 | (n & 0xFF) << 8 | arrayOfByte[m] & 0xFF);
        i += 1;
      }
      return arrayOfInt1;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      arrayOfInt1 = null;
      if (Log.isLoggable("GifHeaderParser", 3)) {
        Log.d("GifHeaderParser", "Format Error Reading Color Table", localBufferUnderflowException);
      }
      this.c.b = 1;
    }
  }
  
  private void c()
  {
    this.b = null;
    Arrays.fill(this.a, (byte)0);
    this.c = new GifHeader();
    this.d = 0;
  }
  
  private void d()
  {
    int i = 0;
    while ((i == 0) && (!o())) {
      switch (m())
      {
      default: 
        this.c.b = 1;
        break;
      case 44: 
        if (this.c.d == null) {
          this.c.d = new GifFrame();
        }
        f();
        break;
      case 33: 
        switch (m())
        {
        default: 
          k();
          break;
        case 249: 
          this.c.d = new GifFrame();
          e();
          break;
        case 255: 
          l();
          String str = "";
          int j = 0;
          while (j < 11)
          {
            str = str + (char)this.a[j];
            j += 1;
          }
          if (str.equals("NETSCAPE2.0")) {
            g();
          } else {
            k();
          }
          break;
        case 254: 
          k();
          break;
        case 1: 
          k();
        }
        break;
      case 59: 
        i = 1;
      }
    }
  }
  
  private void e()
  {
    boolean bool = true;
    m();
    int i = m();
    this.c.d.g = ((i & 0x1C) >> 2);
    if (this.c.d.g == 0) {
      this.c.d.g = 1;
    }
    GifFrame localGifFrame = this.c.d;
    if ((i & 0x1) != 0) {}
    for (;;)
    {
      localGifFrame.f = bool;
      int j = n();
      i = j;
      if (j < 3) {
        i = 10;
      }
      this.c.d.i = (i * 10);
      this.c.d.h = m();
      m();
      return;
      bool = false;
    }
  }
  
  private void f()
  {
    boolean bool = true;
    this.c.d.a = n();
    this.c.d.b = n();
    this.c.d.c = n();
    this.c.d.d = n();
    int j = m();
    int i;
    int k;
    if ((j & 0x80) != 0)
    {
      i = 1;
      k = (int)Math.pow(2.0D, (j & 0x7) + 1);
      localObject = this.c.d;
      if ((j & 0x40) == 0) {
        break label165;
      }
      label105:
      ((GifFrame)localObject).e = bool;
      if (i == 0) {
        break label171;
      }
    }
    label165:
    label171:
    for (this.c.d.k = a(k);; this.c.d.k = null)
    {
      this.c.d.j = this.b.position();
      j();
      if (!o()) {
        break label185;
      }
      return;
      i = 0;
      break;
      bool = false;
      break label105;
    }
    label185:
    Object localObject = this.c;
    ((GifHeader)localObject).c += 1;
    this.c.e.add(this.c.d);
  }
  
  private void g()
  {
    do
    {
      l();
      if (this.a[0] == 1)
      {
        int i = this.a[1];
        int j = this.a[2];
        this.c.m = (i & 0xFF | (j & 0xFF) << 8);
      }
    } while ((this.d > 0) && (!o()));
  }
  
  private void h()
  {
    String str = "";
    int i = 0;
    while (i < 6)
    {
      str = str + (char)m();
      i += 1;
    }
    if (!str.startsWith("GIF")) {
      this.c.b = 1;
    }
    do
    {
      return;
      i();
    } while ((!this.c.h) || (o()));
    this.c.a = a(this.c.i);
    this.c.l = this.c.a[this.c.j];
  }
  
  private void i()
  {
    this.c.f = n();
    this.c.g = n();
    int i = m();
    GifHeader localGifHeader = this.c;
    if ((i & 0x80) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localGifHeader.h = bool;
      this.c.i = (2 << (i & 0x7));
      this.c.j = m();
      this.c.k = m();
      return;
    }
  }
  
  private void j()
  {
    m();
    k();
  }
  
  private void k()
  {
    int i;
    do
    {
      i = m();
      this.b.position(this.b.position() + i);
    } while (i > 0);
  }
  
  private int l()
  {
    int m = 0;
    int i = 0;
    this.d = m();
    if (this.d > 0)
    {
      int j = 0;
      for (;;)
      {
        int k = j;
        m = i;
        try
        {
          if (i < this.d)
          {
            k = j;
            j = this.d - i;
            k = j;
            this.b.get(this.a, i, j);
            i += j;
          }
        }
        catch (Exception localException)
        {
          if (Log.isLoggable("GifHeaderParser", 3)) {
            Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + k + " blockSize: " + this.d, localException);
          }
          this.c.b = 1;
          m = i;
        }
      }
    }
    return m;
  }
  
  private int m()
  {
    try
    {
      int i = this.b.get();
      return i & 0xFF;
    }
    catch (Exception localException)
    {
      this.c.b = 1;
    }
    return 0;
  }
  
  private int n()
  {
    return this.b.getShort();
  }
  
  private boolean o()
  {
    return this.c.b != 0;
  }
  
  public GifHeaderParser a(byte[] paramArrayOfByte)
  {
    c();
    if (paramArrayOfByte != null)
    {
      this.b = ByteBuffer.wrap(paramArrayOfByte);
      this.b.rewind();
      this.b.order(ByteOrder.LITTLE_ENDIAN);
      return this;
    }
    this.b = null;
    this.c.b = 2;
    return this;
  }
  
  public void a()
  {
    this.b = null;
    this.c = null;
  }
  
  public GifHeader b()
  {
    if (this.b == null) {
      throw new IllegalStateException("You must call setData() before parseHeader()");
    }
    if (o()) {
      return this.c;
    }
    h();
    if (!o())
    {
      d();
      if (this.c.c < 0) {
        this.c.b = 1;
      }
    }
    return this.c;
  }
}
