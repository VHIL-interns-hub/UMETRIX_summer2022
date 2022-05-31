package com.squareup.okhttp.internal.framed;

import java.util.Arrays;

public final class Settings
{
  private int a;
  private int b;
  private int c;
  private final int[] d = new int[10];
  
  public Settings() {}
  
  Settings a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= this.d.length) {
      return this;
    }
    int i = 1 << paramInt1;
    this.a |= i;
    if ((paramInt2 & 0x1) != 0)
    {
      this.b |= i;
      if ((paramInt2 & 0x2) == 0) {
        break label86;
      }
    }
    label86:
    for (this.c = (i | this.c);; this.c = ((i ^ 0xFFFFFFFF) & this.c))
    {
      this.d[paramInt1] = paramInt3;
      return this;
      this.b &= (i ^ 0xFFFFFFFF);
      break;
    }
  }
  
  void a()
  {
    this.c = 0;
    this.b = 0;
    this.a = 0;
    Arrays.fill(this.d, 0);
  }
  
  void a(Settings paramSettings)
  {
    int i = 0;
    if (i < 10)
    {
      if (!paramSettings.a(i)) {}
      for (;;)
      {
        i += 1;
        break;
        a(i, paramSettings.c(i), paramSettings.b(i));
      }
    }
  }
  
  boolean a(int paramInt)
  {
    return (1 << paramInt & this.a) != 0;
  }
  
  int b()
  {
    return Integer.bitCount(this.a);
  }
  
  int b(int paramInt)
  {
    return this.d[paramInt];
  }
  
  int c()
  {
    if ((0x2 & this.a) != 0) {
      return this.d[1];
    }
    return -1;
  }
  
  int c(int paramInt)
  {
    int i = 0;
    if (h(paramInt)) {
      i = 2;
    }
    int j = i;
    if (g(paramInt)) {
      j = i | 0x1;
    }
    return j;
  }
  
  int d(int paramInt)
  {
    if ((0x10 & this.a) != 0) {
      paramInt = this.d[4];
    }
    return paramInt;
  }
  
  int e(int paramInt)
  {
    if ((0x20 & this.a) != 0) {
      paramInt = this.d[5];
    }
    return paramInt;
  }
  
  int f(int paramInt)
  {
    if ((0x80 & this.a) != 0) {
      paramInt = this.d[7];
    }
    return paramInt;
  }
  
  boolean g(int paramInt)
  {
    return (1 << paramInt & this.b) != 0;
  }
  
  boolean h(int paramInt)
  {
    return (1 << paramInt & this.c) != 0;
  }
}
