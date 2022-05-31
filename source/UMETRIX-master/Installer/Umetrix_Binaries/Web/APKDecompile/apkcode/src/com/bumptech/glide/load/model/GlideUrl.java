package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.util.Map;

public class GlideUrl
{
  private final URL a;
  private final Headers b;
  private final String c;
  private String d;
  private URL e;
  
  public GlideUrl(String paramString)
  {
    this(paramString, Headers.b);
  }
  
  public GlideUrl(String paramString, Headers paramHeaders)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("String url must not be empty or null: " + paramString);
    }
    if (paramHeaders == null) {
      throw new IllegalArgumentException("Headers must not be null");
    }
    this.c = paramString;
    this.a = null;
    this.b = paramHeaders;
  }
  
  public GlideUrl(URL paramURL)
  {
    this(paramURL, Headers.b);
  }
  
  public GlideUrl(URL paramURL, Headers paramHeaders)
  {
    if (paramURL == null) {
      throw new IllegalArgumentException("URL must not be null!");
    }
    if (paramHeaders == null) {
      throw new IllegalArgumentException("Headers must not be null");
    }
    this.a = paramURL;
    this.c = null;
    this.b = paramHeaders;
  }
  
  private URL d()
  {
    if (this.e == null) {
      this.e = new URL(e());
    }
    return this.e;
  }
  
  private String e()
  {
    if (TextUtils.isEmpty(this.d))
    {
      String str2 = this.c;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.a.toString();
      }
      this.d = Uri.encode(str1, "@#&=*+-_.,:!?()/~'%");
    }
    return this.d;
  }
  
  public URL a()
  {
    return d();
  }
  
  public Map b()
  {
    return this.b.a();
  }
  
  public String c()
  {
    if (this.c != null) {
      return this.c;
    }
    return this.a.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof GlideUrl))
    {
      paramObject = (GlideUrl)paramObject;
      bool1 = bool2;
      if (c().equals(paramObject.c()))
      {
        bool1 = bool2;
        if (this.b.equals(paramObject.b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return c().hashCode() * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    return c() + '\n' + this.b.toString();
  }
}
