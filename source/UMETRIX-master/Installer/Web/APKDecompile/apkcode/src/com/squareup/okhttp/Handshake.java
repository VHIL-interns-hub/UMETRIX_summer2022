package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class Handshake
{
  private final String a;
  private final List b;
  private final List c;
  
  private Handshake(String paramString, List paramList1, List paramList2)
  {
    this.a = paramString;
    this.b = paramList1;
    this.c = paramList2;
  }
  
  public static Handshake a(SSLSession paramSSLSession)
  {
    String str = paramSSLSession.getCipherSuite();
    if (str == null) {
      throw new IllegalStateException("cipherSuite == null");
    }
    try
    {
      Object localObject = paramSSLSession.getPeerCertificates();
      if (localObject != null)
      {
        localObject = Util.a((Object[])localObject);
        paramSSLSession = paramSSLSession.getLocalCertificates();
        if (paramSSLSession == null) {
          break label77;
        }
        paramSSLSession = Util.a(paramSSLSession);
        return new Handshake(str, (List)localObject, paramSSLSession);
      }
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      for (;;)
      {
        List localList = null;
        continue;
        localList = Collections.emptyList();
        continue;
        label77:
        paramSSLSession = Collections.emptyList();
      }
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public List b()
  {
    return this.b;
  }
  
  public Principal c()
  {
    if (!this.b.isEmpty()) {
      return ((X509Certificate)this.b.get(0)).getSubjectX500Principal();
    }
    return null;
  }
  
  public List d()
  {
    return this.c;
  }
  
  public Principal e()
  {
    if (!this.c.isEmpty()) {
      return ((X509Certificate)this.c.get(0)).getSubjectX500Principal();
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Handshake)) {}
    do
    {
      return false;
      paramObject = (Handshake)paramObject;
    } while ((!this.a.equals(paramObject.a)) || (!this.b.equals(paramObject.b)) || (!this.c.equals(paramObject.c)));
    return true;
  }
  
  public int hashCode()
  {
    return ((this.a.hashCode() + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
  }
}
