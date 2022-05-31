package com.squareup.okhttp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okio.Buffer;

public final class HttpUrl
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final int f;
  private final List g;
  private final List h;
  private final String i;
  private final String j;
  
  private HttpUrl(HttpUrl.Builder paramBuilder)
  {
    this.b = paramBuilder.a;
    this.c = a(paramBuilder.b, false);
    this.d = a(paramBuilder.c, false);
    this.e = paramBuilder.d;
    this.f = paramBuilder.a();
    this.g = a(paramBuilder.f, false);
    if (paramBuilder.g != null) {}
    for (Object localObject1 = a(paramBuilder.g, true);; localObject1 = null)
    {
      this.h = ((List)localObject1);
      localObject1 = localObject2;
      if (paramBuilder.h != null) {
        localObject1 = a(paramBuilder.h, false);
      }
      this.i = ((String)localObject1);
      this.j = paramBuilder.toString();
      return;
    }
  }
  
  static int a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    return -1;
  }
  
  public static int a(String paramString)
  {
    if (paramString.equals("http")) {
      return 80;
    }
    if (paramString.equals("https")) {
      return 443;
    }
    return -1;
  }
  
  static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString1.codePointAt(k);
      if ((m < 32) || (m == 127) || ((m >= 128) && (paramBoolean3)) || (paramString2.indexOf(m) != -1) || ((m == 37) && (!paramBoolean1)) || ((m == 43) && (paramBoolean2)))
      {
        Buffer localBuffer = new Buffer();
        localBuffer.a(paramString1, paramInt1, k);
        a(localBuffer, paramString1, k, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3);
        return localBuffer.q();
      }
      k += Character.charCount(m);
    }
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString.charAt(k);
      if ((m == 37) || ((m == 43) && (paramBoolean)))
      {
        Buffer localBuffer = new Buffer();
        localBuffer.a(paramString, paramInt1, k);
        a(localBuffer, paramString, k, paramInt2, paramBoolean);
        return localBuffer.q();
      }
      k += 1;
    }
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return a(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  static String a(String paramString, boolean paramBoolean)
  {
    return a(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private List a(List paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      if (paramList != null) {}
      for (paramList = a(paramList, paramBoolean);; paramList = null)
      {
        localArrayList.add(paramList);
        break;
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  static void a(StringBuilder paramStringBuilder, List paramList)
  {
    int m = paramList.size();
    int k = 0;
    while (k < m)
    {
      paramStringBuilder.append('/');
      paramStringBuilder.append((String)paramList.get(k));
      k += 1;
    }
  }
  
  static void a(Buffer paramBuffer, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1 = null;
    if (paramInt1 < paramInt2)
    {
      int k = paramString1.codePointAt(paramInt1);
      Object localObject3;
      if (paramBoolean1)
      {
        localObject3 = localObject1;
        if (k != 9)
        {
          localObject3 = localObject1;
          if (k != 10)
          {
            localObject3 = localObject1;
            if (k != 12)
            {
              if (k != 13) {
                break label79;
              }
              localObject3 = localObject1;
            }
          }
        }
      }
      for (;;)
      {
        paramInt1 += Character.charCount(k);
        localObject1 = localObject3;
        break;
        label79:
        Object localObject2;
        if ((k == 43) && (paramBoolean2))
        {
          if (paramBoolean1) {}
          for (localObject2 = "+";; localObject2 = "%2B")
          {
            paramBuffer.a((String)localObject2);
            localObject3 = localObject1;
            break;
          }
        }
        if ((k < 32) || (k == 127) || ((k >= 128) && (paramBoolean3)) || (paramString2.indexOf(k) != -1) || ((k == 37) && (!paramBoolean1)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Buffer();
          }
          ((Buffer)localObject2).a(k);
          for (;;)
          {
            localObject3 = localObject2;
            if (((Buffer)localObject2).g()) {
              break;
            }
            int m = ((Buffer)localObject2).j() & 0xFF;
            paramBuffer.b(37);
            paramBuffer.b(a[(m >> 4 & 0xF)]);
            paramBuffer.b(a[(m & 0xF)]);
          }
        }
        paramBuffer.a(k);
        localObject3 = localObject1;
      }
    }
  }
  
  static void a(Buffer paramBuffer, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 < paramInt2)
    {
      int k = paramString.codePointAt(paramInt1);
      if ((k == 37) && (paramInt1 + 2 < paramInt2))
      {
        int m = a(paramString.charAt(paramInt1 + 1));
        int n = a(paramString.charAt(paramInt1 + 2));
        if ((m == -1) || (n == -1)) {
          break label111;
        }
        paramBuffer.b((m << 4) + n);
        paramInt1 += 2;
      }
      for (;;)
      {
        paramInt1 += Character.charCount(k);
        break;
        if ((k == 43) && (paramBoolean)) {
          paramBuffer.b(32);
        } else {
          label111:
          paramBuffer.a(k);
        }
      }
    }
  }
  
  private static int b(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    for (;;)
    {
      int k = paramInt2;
      if (paramInt1 < paramInt2)
      {
        if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1) {
          k = paramInt1;
        }
      }
      else {
        return k;
      }
      paramInt1 += 1;
    }
  }
  
  static List b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    if (k <= paramString.length())
    {
      int n = paramString.indexOf('&', k);
      int m = n;
      if (n == -1) {
        m = paramString.length();
      }
      n = paramString.indexOf('=', k);
      if ((n == -1) || (n > m))
      {
        localArrayList.add(paramString.substring(k, m));
        localArrayList.add(null);
      }
      for (;;)
      {
        k = m + 1;
        break;
        localArrayList.add(paramString.substring(k, n));
        localArrayList.add(paramString.substring(n + 1, m));
      }
    }
    return localArrayList;
  }
  
  static void b(StringBuilder paramStringBuilder, List paramList)
  {
    int m = paramList.size();
    int k = 0;
    while (k < m)
    {
      String str1 = (String)paramList.get(k);
      String str2 = (String)paramList.get(k + 1);
      if (k > 0) {
        paramStringBuilder.append('&');
      }
      paramStringBuilder.append(str1);
      if (str2 != null)
      {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      }
      k += 2;
    }
  }
  
  static HttpUrl d(String paramString)
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    HttpUrl.Builder.ParseResult localParseResult = localBuilder.a(null, paramString);
    switch (HttpUrl.1.a[localParseResult.ordinal()])
    {
    default: 
      throw new MalformedURLException("Invalid URL: " + localParseResult + " for " + paramString);
    case 1: 
      return localBuilder.c();
    }
    throw new UnknownHostException("Invalid host: " + paramString);
  }
  
  public URL a()
  {
    try
    {
      URL localURL = new URL(this.j);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new RuntimeException(localMalformedURLException);
    }
  }
  
  public URI b()
  {
    try
    {
      URI localURI = new URI(n().b().toString());
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IllegalStateException("not valid as a java.net.URI: " + this.j);
    }
  }
  
  public HttpUrl c(String paramString)
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    if (localBuilder.a(this, paramString) == HttpUrl.Builder.ParseResult.a) {
      return localBuilder.c();
    }
    return null;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return this.b.equals("https");
  }
  
  public String e()
  {
    if (this.c.isEmpty()) {
      return "";
    }
    int k = this.b.length() + 3;
    int m = b(this.j, k, this.j.length(), ":@");
    return this.j.substring(k, m);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof HttpUrl)) && (((HttpUrl)paramObject).j.equals(this.j));
  }
  
  public String f()
  {
    if (this.d.isEmpty()) {
      return "";
    }
    int k = this.j.indexOf(':', this.b.length() + 3);
    int m = this.j.indexOf('@');
    return this.j.substring(k + 1, m);
  }
  
  public String g()
  {
    return this.e;
  }
  
  public int h()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    return this.j.hashCode();
  }
  
  public String i()
  {
    int k = this.j.indexOf('/', this.b.length() + 3);
    int m = b(this.j, k, this.j.length(), "?#");
    return this.j.substring(k, m);
  }
  
  public List j()
  {
    int k = this.j.indexOf('/', this.b.length() + 3);
    int m = b(this.j, k, this.j.length(), "?#");
    ArrayList localArrayList = new ArrayList();
    while (k < m)
    {
      int n = k + 1;
      k = b(this.j, n, m, "/");
      localArrayList.add(this.j.substring(n, k));
    }
    return localArrayList;
  }
  
  public String k()
  {
    if (this.h == null) {
      return null;
    }
    int k = this.j.indexOf('?') + 1;
    int m = b(this.j, k + 1, this.j.length(), "#");
    return this.j.substring(k, m);
  }
  
  public String l()
  {
    if (this.h == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, this.h);
    return localStringBuilder.toString();
  }
  
  public String m()
  {
    if (this.i == null) {
      return null;
    }
    int k = this.j.indexOf('#');
    return this.j.substring(k + 1);
  }
  
  public HttpUrl.Builder n()
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    localBuilder.a = this.b;
    localBuilder.b = e();
    localBuilder.c = f();
    localBuilder.d = this.e;
    if (this.f != a(this.b)) {}
    for (int k = this.f;; k = -1)
    {
      localBuilder.e = k;
      localBuilder.f.clear();
      localBuilder.f.addAll(j());
      localBuilder.c(k());
      localBuilder.h = m();
      return localBuilder;
    }
  }
  
  public String toString()
  {
    return this.j;
  }
}
