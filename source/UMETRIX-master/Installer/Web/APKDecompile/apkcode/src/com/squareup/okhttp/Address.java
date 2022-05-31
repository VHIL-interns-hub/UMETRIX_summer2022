package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address
{
  final HttpUrl a;
  final Dns b;
  final SocketFactory c;
  final Authenticator d;
  final List e;
  final List f;
  final ProxySelector g;
  final Proxy h;
  final SSLSocketFactory i;
  final HostnameVerifier j;
  final CertificatePinner k;
  
  public Address(String paramString, int paramInt, Dns paramDns, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, CertificatePinner paramCertificatePinner, Authenticator paramAuthenticator, Proxy paramProxy, List paramList1, List paramList2, ProxySelector paramProxySelector)
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    if (paramSSLSocketFactory != null) {}
    for (String str = "https";; str = "http")
    {
      this.a = localBuilder.a(str).b(paramString).a(paramInt).c();
      if (paramDns != null) {
        break;
      }
      throw new IllegalArgumentException("dns == null");
    }
    this.b = paramDns;
    if (paramSocketFactory == null) {
      throw new IllegalArgumentException("socketFactory == null");
    }
    this.c = paramSocketFactory;
    if (paramAuthenticator == null) {
      throw new IllegalArgumentException("authenticator == null");
    }
    this.d = paramAuthenticator;
    if (paramList1 == null) {
      throw new IllegalArgumentException("protocols == null");
    }
    this.e = Util.a(paramList1);
    if (paramList2 == null) {
      throw new IllegalArgumentException("connectionSpecs == null");
    }
    this.f = Util.a(paramList2);
    if (paramProxySelector == null) {
      throw new IllegalArgumentException("proxySelector == null");
    }
    this.g = paramProxySelector;
    this.h = paramProxy;
    this.i = paramSSLSocketFactory;
    this.j = paramHostnameVerifier;
    this.k = paramCertificatePinner;
  }
  
  public HttpUrl a()
  {
    return this.a;
  }
  
  @Deprecated
  public String b()
  {
    return this.a.g();
  }
  
  @Deprecated
  public int c()
  {
    return this.a.h();
  }
  
  public Dns d()
  {
    return this.b;
  }
  
  public SocketFactory e()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Address))
    {
      paramObject = (Address)paramObject;
      bool1 = bool2;
      if (this.a.equals(paramObject.a))
      {
        bool1 = bool2;
        if (this.b.equals(paramObject.b))
        {
          bool1 = bool2;
          if (this.d.equals(paramObject.d))
          {
            bool1 = bool2;
            if (this.e.equals(paramObject.e))
            {
              bool1 = bool2;
              if (this.f.equals(paramObject.f))
              {
                bool1 = bool2;
                if (this.g.equals(paramObject.g))
                {
                  bool1 = bool2;
                  if (Util.a(this.h, paramObject.h))
                  {
                    bool1 = bool2;
                    if (Util.a(this.i, paramObject.i))
                    {
                      bool1 = bool2;
                      if (Util.a(this.j, paramObject.j))
                      {
                        bool1 = bool2;
                        if (Util.a(this.k, paramObject.k)) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public Authenticator f()
  {
    return this.d;
  }
  
  public List g()
  {
    return this.e;
  }
  
  public List h()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    int i2 = 0;
    int i3 = this.a.hashCode();
    int i4 = this.b.hashCode();
    int i5 = this.d.hashCode();
    int i6 = this.e.hashCode();
    int i7 = this.f.hashCode();
    int i8 = this.g.hashCode();
    int m;
    int n;
    if (this.h != null)
    {
      m = this.h.hashCode();
      if (this.i == null) {
        break label185;
      }
      n = this.i.hashCode();
      label91:
      if (this.j == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (int i1 = this.j.hashCode();; i1 = 0)
    {
      if (this.k != null) {
        i2 = this.k.hashCode();
      }
      return (i1 + (n + (m + ((((((i3 + 527) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31) * 31) * 31) * 31 + i2;
      m = 0;
      break;
      n = 0;
      break label91;
    }
  }
  
  public ProxySelector i()
  {
    return this.g;
  }
  
  public Proxy j()
  {
    return this.h;
  }
  
  public SSLSocketFactory k()
  {
    return this.i;
  }
  
  public HostnameVerifier l()
  {
    return this.j;
  }
  
  public CertificatePinner m()
  {
    return this.k;
  }
}
