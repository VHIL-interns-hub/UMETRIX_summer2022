package com.bumptech.glide.gifencoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

public class AnimatedGifEncoder
{
  private int a;
  private int b;
  private Integer c = null;
  private int d;
  private int e = -1;
  private int f = 0;
  private boolean g = false;
  private OutputStream h;
  private Bitmap i;
  private byte[] j;
  private byte[] k;
  private int l;
  private byte[] m;
  private boolean[] n = new boolean['?'];
  private int o = 7;
  private int p = -1;
  private boolean q = false;
  private boolean r = true;
  private boolean s = false;
  private int t = 10;
  private boolean u;
  
  public AnimatedGifEncoder() {}
  
  private void a(String paramString)
  {
    int i1 = 0;
    while (i1 < paramString.length())
    {
      this.h.write((byte)paramString.charAt(i1));
      i1 += 1;
    }
  }
  
  private int b(int paramInt)
  {
    int i2 = 0;
    if (this.m == null) {
      i3 = -1;
    }
    int i4;
    int i5;
    int i6;
    int i1;
    int i7;
    do
    {
      return i3;
      i4 = Color.red(paramInt);
      i5 = Color.green(paramInt);
      i6 = Color.blue(paramInt);
      i1 = 16777216;
      i7 = this.m.length;
      paramInt = 0;
      i3 = paramInt;
    } while (i2 >= i7);
    byte[] arrayOfByte = this.m;
    int i3 = i2 + 1;
    i2 = i4 - (arrayOfByte[i2] & 0xFF);
    arrayOfByte = this.m;
    int i8 = i3 + 1;
    i3 = i5 - (arrayOfByte[i3] & 0xFF);
    int i9 = i6 - (this.m[i8] & 0xFF);
    i2 = i2 * i2 + i3 * i3 + i9 * i9;
    i3 = i8 / 3;
    if ((this.n[i3] != 0) && (i2 < i1))
    {
      i1 = i3;
      paramInt = i2;
    }
    for (;;)
    {
      i3 = i1;
      i2 = i8 + 1;
      i1 = paramInt;
      paramInt = i3;
      break;
      i2 = paramInt;
      paramInt = i1;
      i1 = i2;
    }
  }
  
  private void b()
  {
    int i2 = this.j.length;
    int i4 = i2 / 3;
    this.k = new byte[i4];
    NeuQuant localNeuQuant = new NeuQuant(this.j, i2, this.t);
    this.m = localNeuQuant.d();
    i2 = 0;
    while (i2 < this.m.length)
    {
      int i1 = this.m[i2];
      this.m[i2] = this.m[(i2 + 2)];
      this.m[(i2 + 2)] = i1;
      this.n[(i2 / 3)] = false;
      i2 += 3;
    }
    i2 = 0;
    int i3 = 0;
    while (i2 < i4)
    {
      byte[] arrayOfByte = this.j;
      int i7 = i3 + 1;
      int i5 = arrayOfByte[i3];
      arrayOfByte = this.j;
      int i6 = i7 + 1;
      i7 = arrayOfByte[i7];
      arrayOfByte = this.j;
      i3 = i6 + 1;
      i5 = localNeuQuant.a(i5 & 0xFF, i7 & 0xFF, arrayOfByte[i6] & 0xFF);
      this.n[i5] = true;
      this.k[i2] = ((byte)i5);
      i2 += 1;
    }
    this.j = null;
    this.l = 8;
    this.o = 7;
    if (this.c != null) {
      this.d = b(this.c.intValue());
    }
    while (!this.u) {
      return;
    }
    this.d = b(0);
  }
  
  private void c()
  {
    boolean bool = false;
    int i1 = this.i.getWidth();
    int i2 = this.i.getHeight();
    if ((i1 != this.a) || (i2 != this.b))
    {
      localObject = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_8888);
      new Canvas((Bitmap)localObject).drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
      this.i = ((Bitmap)localObject);
    }
    Object localObject = new int[i1 * i2];
    this.i.getPixels((int[])localObject, 0, i1, 0, 0, i1, i2);
    this.j = new byte[localObject.length * 3];
    this.u = false;
    int i5 = localObject.length;
    i1 = 0;
    int i4 = 0;
    i2 = 0;
    while (i1 < i5)
    {
      int i6 = localObject[i1];
      int i3 = i4;
      if (i6 == 0) {
        i3 = i4 + 1;
      }
      byte[] arrayOfByte = this.j;
      i4 = i2 + 1;
      arrayOfByte[i2] = ((byte)(i6 & 0xFF));
      arrayOfByte = this.j;
      int i7 = i4 + 1;
      arrayOfByte[i4] = ((byte)(i6 >> 8 & 0xFF));
      arrayOfByte = this.j;
      i2 = i7 + 1;
      arrayOfByte[i7] = ((byte)(i6 >> 16 & 0xFF));
      i1 += 1;
      i4 = i3;
    }
    double d1 = i4 * 100 / localObject.length;
    if (d1 > 4.0D) {
      bool = true;
    }
    this.u = bool;
    if (Log.isLoggable("AnimatedGifEncoder", 3)) {
      Log.d("AnimatedGifEncoder", "got pixels for frame with " + d1 + "% transparent pixels");
    }
  }
  
  private void c(int paramInt)
  {
    this.h.write(paramInt & 0xFF);
    this.h.write(paramInt >> 8 & 0xFF);
  }
  
  private void d()
  {
    this.h.write(33);
    this.h.write(249);
    this.h.write(4);
    int i1;
    int i2;
    if ((this.c == null) && (!this.u))
    {
      i1 = 0;
      i2 = 0;
    }
    for (;;)
    {
      if (this.p >= 0) {
        i1 = this.p & 0x7;
      }
      this.h.write(i1 << 2 | 0x0 | 0x0 | i2);
      c(this.f);
      this.h.write(this.d);
      this.h.write(0);
      return;
      i2 = 1;
      i1 = 2;
    }
  }
  
  private void e()
  {
    this.h.write(44);
    c(0);
    c(0);
    c(this.a);
    c(this.b);
    if (this.r)
    {
      this.h.write(0);
      return;
    }
    this.h.write(this.o | 0x80);
  }
  
  private void f()
  {
    c(this.a);
    c(this.b);
    this.h.write(this.o | 0xF0);
    this.h.write(0);
    this.h.write(0);
  }
  
  private void g()
  {
    this.h.write(33);
    this.h.write(255);
    this.h.write(11);
    a("NETSCAPE2.0");
    this.h.write(3);
    this.h.write(1);
    c(this.e);
    this.h.write(0);
  }
  
  private void h()
  {
    this.h.write(this.m, 0, this.m.length);
    int i2 = this.m.length;
    int i1 = 0;
    while (i1 < 768 - i2)
    {
      this.h.write(0);
      i1 += 1;
    }
  }
  
  private void i()
  {
    new LZWEncoder(this.a, this.b, this.k, this.l).b(this.h);
  }
  
  public void a(int paramInt)
  {
    this.f = Math.round(paramInt / 10.0F);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.g) && (!this.r)) {
      return;
    }
    this.a = paramInt1;
    this.b = paramInt2;
    if (this.a < 1) {
      this.a = 320;
    }
    if (this.b < 1) {
      this.b = 240;
    }
    this.s = true;
  }
  
  public boolean a()
  {
    if (!this.g) {
      return false;
    }
    this.g = false;
    try
    {
      this.h.write(59);
      this.h.flush();
      if (this.q) {
        this.h.close();
      }
      bool = true;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    this.d = 0;
    this.h = null;
    this.i = null;
    this.j = null;
    this.k = null;
    this.m = null;
    this.q = false;
    this.r = true;
    return bool;
  }
  
  public boolean a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (!this.g)) {
      return false;
    }
    try
    {
      if (!this.s) {
        a(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      this.i = paramBitmap;
      c();
      b();
      if (this.r)
      {
        f();
        h();
        if (this.e >= 0) {
          g();
        }
      }
      d();
      e();
      if (!this.r) {
        h();
      }
      i();
      this.r = false;
      return true;
    }
    catch (IOException paramBitmap) {}
    return false;
  }
  
  public boolean a(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      return false;
    }
    boolean bool = true;
    this.q = false;
    this.h = paramOutputStream;
    try
    {
      a("GIF89a");
      this.g = bool;
      return bool;
    }
    catch (IOException paramOutputStream)
    {
      for (;;)
      {
        bool = false;
      }
    }
  }
}
