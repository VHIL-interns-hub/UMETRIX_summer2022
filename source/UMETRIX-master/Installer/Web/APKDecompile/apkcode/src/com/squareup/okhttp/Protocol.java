package com.squareup.okhttp;

import java.io.IOException;

public enum Protocol
{
  private final String e;
  
  private Protocol(String paramString)
  {
    this.e = paramString;
  }
  
  public static Protocol a(String paramString)
  {
    if (paramString.equals(a.e)) {
      return a;
    }
    if (paramString.equals(b.e)) {
      return b;
    }
    if (paramString.equals(d.e)) {
      return d;
    }
    if (paramString.equals(c.e)) {
      return c;
    }
    throw new IOException("Unexpected protocol: " + paramString);
  }
  
  public String toString()
  {
    return this.e;
  }
}
