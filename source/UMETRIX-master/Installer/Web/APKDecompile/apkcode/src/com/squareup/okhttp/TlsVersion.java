package com.squareup.okhttp;

public enum TlsVersion
{
  final String e;
  
  private TlsVersion(String paramString)
  {
    this.e = paramString;
  }
  
  public static TlsVersion a(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Unexpected TLS version: " + paramString);
        if (paramString.equals("TLSv1.2"))
        {
          i = 0;
          continue;
          if (paramString.equals("TLSv1.1"))
          {
            i = 1;
            continue;
            if (paramString.equals("TLSv1"))
            {
              i = 2;
              continue;
              if (paramString.equals("SSLv3")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return a;
    return b;
    return c;
    return d;
  }
}
