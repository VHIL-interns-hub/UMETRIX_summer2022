package com.squareup.okhttp.internal.framed;

import okio.ByteString;

public final class Header
{
  public static final ByteString a = ByteString.a(":status");
  public static final ByteString b = ByteString.a(":method");
  public static final ByteString c = ByteString.a(":path");
  public static final ByteString d = ByteString.a(":scheme");
  public static final ByteString e = ByteString.a(":authority");
  public static final ByteString f = ByteString.a(":host");
  public static final ByteString g = ByteString.a(":version");
  public final ByteString h;
  public final ByteString i;
  final int j;
  
  public Header(String paramString1, String paramString2)
  {
    this(ByteString.a(paramString1), ByteString.a(paramString2));
  }
  
  public Header(ByteString paramByteString, String paramString)
  {
    this(paramByteString, ByteString.a(paramString));
  }
  
  public Header(ByteString paramByteString1, ByteString paramByteString2)
  {
    this.h = paramByteString1;
    this.i = paramByteString2;
    this.j = (paramByteString1.f() + 32 + paramByteString2.f());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Header))
    {
      paramObject = (Header)paramObject;
      bool1 = bool2;
      if (this.h.equals(paramObject.h))
      {
        bool1 = bool2;
        if (this.i.equals(paramObject.i)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (this.h.hashCode() + 527) * 31 + this.i.hashCode();
  }
  
  public String toString()
  {
    return String.format("%s: %s", new Object[] { this.h.a(), this.i.a() });
  }
}
