package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HeaderParser;
import java.util.concurrent.TimeUnit;

public final class CacheControl
{
  public static final CacheControl a = new CacheControl.Builder().a().c();
  public static final CacheControl b = new CacheControl.Builder().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();
  String c;
  private final boolean d;
  private final boolean e;
  private final int f;
  private final int g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  private final int k;
  private final int l;
  private final boolean m;
  private final boolean n;
  
  private CacheControl(CacheControl.Builder paramBuilder)
  {
    this.d = paramBuilder.a;
    this.e = paramBuilder.b;
    this.f = paramBuilder.c;
    this.g = -1;
    this.h = false;
    this.i = false;
    this.j = false;
    this.k = paramBuilder.d;
    this.l = paramBuilder.e;
    this.m = paramBuilder.f;
    this.n = paramBuilder.g;
  }
  
  private CacheControl(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, String paramString)
  {
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramBoolean3;
    this.i = paramBoolean4;
    this.j = paramBoolean5;
    this.k = paramInt3;
    this.l = paramInt4;
    this.m = paramBoolean6;
    this.n = paramBoolean7;
    this.c = paramString;
  }
  
  public static CacheControl a(Headers paramHeaders)
  {
    boolean bool5 = false;
    int i6 = -1;
    int i5 = -1;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    int i4 = -1;
    int i3 = -1;
    boolean bool3 = false;
    boolean bool2 = false;
    int i1 = 1;
    int i13 = paramHeaders.a();
    int i7 = 0;
    Object localObject1 = null;
    boolean bool1 = false;
    while (i7 < i13)
    {
      Object localObject2 = paramHeaders.a(i7);
      String str1 = paramHeaders.b(i7);
      int i8;
      if (((String)localObject2).equalsIgnoreCase("Cache-Control")) {
        if (localObject1 != null)
        {
          i1 = 0;
          i8 = 0;
        }
      }
      for (;;)
      {
        label89:
        localObject2 = localObject1;
        bool14 = bool5;
        i12 = i6;
        i11 = i5;
        bool13 = bool7;
        bool12 = bool6;
        bool11 = bool4;
        i10 = i4;
        i9 = i3;
        bool10 = bool3;
        bool9 = bool2;
        i2 = i1;
        bool8 = bool1;
        if (i8 >= str1.length()) {
          break label603;
        }
        i2 = HeaderParser.a(str1, i8, "=,;");
        String str2 = str1.substring(i8, i2).trim();
        if ((i2 == str1.length()) || (str1.charAt(i2) == ',') || (str1.charAt(i2) == ';'))
        {
          i2 += 1;
          localObject2 = null;
        }
        for (;;)
        {
          if (!"no-cache".equalsIgnoreCase(str2)) {
            break label341;
          }
          bool1 = true;
          i8 = i2;
          break label89;
          localObject1 = str1;
          break;
          if (!((String)localObject2).equalsIgnoreCase("Pragma")) {
            break label554;
          }
          i1 = 0;
          break;
          i8 = HeaderParser.a(str1, i2 + 1);
          if ((i8 < str1.length()) && (str1.charAt(i8) == '"'))
          {
            i2 = i8 + 1;
            i8 = HeaderParser.a(str1, i2, "\"");
            localObject2 = str1.substring(i2, i8);
            i2 = i8 + 1;
          }
          else
          {
            i2 = HeaderParser.a(str1, i8, ",;");
            localObject2 = str1.substring(i8, i2).trim();
          }
        }
        label341:
        if ("no-store".equalsIgnoreCase(str2))
        {
          bool5 = true;
          i8 = i2;
        }
        else if ("max-age".equalsIgnoreCase(str2))
        {
          i6 = HeaderParser.b((String)localObject2, -1);
          i8 = i2;
        }
        else if ("s-maxage".equalsIgnoreCase(str2))
        {
          i5 = HeaderParser.b((String)localObject2, -1);
          i8 = i2;
        }
        else if ("private".equalsIgnoreCase(str2))
        {
          bool7 = true;
          i8 = i2;
        }
        else if ("public".equalsIgnoreCase(str2))
        {
          bool6 = true;
          i8 = i2;
        }
        else if ("must-revalidate".equalsIgnoreCase(str2))
        {
          bool4 = true;
          i8 = i2;
        }
        else if ("max-stale".equalsIgnoreCase(str2))
        {
          i4 = HeaderParser.b((String)localObject2, Integer.MAX_VALUE);
          i8 = i2;
        }
        else if ("min-fresh".equalsIgnoreCase(str2))
        {
          i3 = HeaderParser.b((String)localObject2, -1);
          i8 = i2;
        }
        else if ("only-if-cached".equalsIgnoreCase(str2))
        {
          bool3 = true;
          i8 = i2;
        }
        else
        {
          i8 = i2;
          if ("no-transform".equalsIgnoreCase(str2))
          {
            bool2 = true;
            i8 = i2;
          }
        }
      }
      label554:
      boolean bool8 = bool1;
      int i2 = i1;
      boolean bool9 = bool2;
      boolean bool10 = bool3;
      int i9 = i3;
      int i10 = i4;
      boolean bool11 = bool4;
      boolean bool12 = bool6;
      boolean bool13 = bool7;
      int i11 = i5;
      int i12 = i6;
      boolean bool14 = bool5;
      localObject2 = localObject1;
      label603:
      i7 += 1;
      bool1 = bool8;
      localObject1 = localObject2;
      bool5 = bool14;
      i6 = i12;
      i5 = i11;
      bool7 = bool13;
      bool6 = bool12;
      bool4 = bool11;
      i4 = i10;
      i3 = i9;
      bool3 = bool10;
      bool2 = bool9;
      i1 = i2;
    }
    if (i1 == 0) {}
    for (paramHeaders = null;; paramHeaders = localObject1) {
      return new CacheControl(bool1, bool5, i6, i5, bool7, bool6, bool4, i4, i3, bool3, bool2, paramHeaders);
    }
  }
  
  private String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.d) {
      localStringBuilder.append("no-cache, ");
    }
    if (this.e) {
      localStringBuilder.append("no-store, ");
    }
    if (this.f != -1) {
      localStringBuilder.append("max-age=").append(this.f).append(", ");
    }
    if (this.g != -1) {
      localStringBuilder.append("s-maxage=").append(this.g).append(", ");
    }
    if (this.h) {
      localStringBuilder.append("private, ");
    }
    if (this.i) {
      localStringBuilder.append("public, ");
    }
    if (this.j) {
      localStringBuilder.append("must-revalidate, ");
    }
    if (this.k != -1) {
      localStringBuilder.append("max-stale=").append(this.k).append(", ");
    }
    if (this.l != -1) {
      localStringBuilder.append("min-fresh=").append(this.l).append(", ");
    }
    if (this.m) {
      localStringBuilder.append("only-if-cached, ");
    }
    if (this.n) {
      localStringBuilder.append("no-transform, ");
    }
    if (localStringBuilder.length() == 0) {
      return "";
    }
    localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public boolean d()
  {
    return this.h;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public boolean f()
  {
    return this.j;
  }
  
  public int g()
  {
    return this.k;
  }
  
  public int h()
  {
    return this.l;
  }
  
  public boolean i()
  {
    return this.m;
  }
  
  public String toString()
  {
    String str = this.c;
    if (str != null) {
      return str;
    }
    str = j();
    this.c = str;
    return str;
  }
}
