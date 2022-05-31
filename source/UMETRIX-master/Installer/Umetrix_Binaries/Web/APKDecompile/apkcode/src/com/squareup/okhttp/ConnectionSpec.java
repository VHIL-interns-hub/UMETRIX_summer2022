package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpec
{
  public static final ConnectionSpec a = new ConnectionSpec.Builder(true).a(d).a(new TlsVersion[] { TlsVersion.a, TlsVersion.b, TlsVersion.c }).a(true).a();
  public static final ConnectionSpec b = new ConnectionSpec.Builder(a).a(new TlsVersion[] { TlsVersion.c }).a(true).a();
  public static final ConnectionSpec c = new ConnectionSpec.Builder(false).a();
  private static final CipherSuite[] d = { CipherSuite.aK, CipherSuite.aO, CipherSuite.W, CipherSuite.am, CipherSuite.al, CipherSuite.av, CipherSuite.aw, CipherSuite.F, CipherSuite.J, CipherSuite.U, CipherSuite.D, CipherSuite.H, CipherSuite.h };
  private final boolean e;
  private final boolean f;
  private final String[] g;
  private final String[] h;
  
  private ConnectionSpec(ConnectionSpec.Builder paramBuilder)
  {
    this.e = ConnectionSpec.Builder.a(paramBuilder);
    this.g = ConnectionSpec.Builder.b(paramBuilder);
    this.h = ConnectionSpec.Builder.c(paramBuilder);
    this.f = ConnectionSpec.Builder.d(paramBuilder);
  }
  
  private static boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length == 0) || (paramArrayOfString2.length == 0)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        if (Util.a(paramArrayOfString2, paramArrayOfString1[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private ConnectionSpec b(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1;
    if (this.g != null)
    {
      arrayOfString1 = (String[])Util.a(String.class, this.g, paramSSLSocket.getEnabledCipherSuites());
      if (this.h == null) {
        break label109;
      }
    }
    label109:
    for (String[] arrayOfString2 = (String[])Util.a(String.class, this.h, paramSSLSocket.getEnabledProtocols());; arrayOfString2 = paramSSLSocket.getEnabledProtocols())
    {
      String[] arrayOfString3 = arrayOfString1;
      if (paramBoolean)
      {
        arrayOfString3 = arrayOfString1;
        if (Util.a(paramSSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
          arrayOfString3 = Util.b(arrayOfString1, "TLS_FALLBACK_SCSV");
        }
      }
      return new ConnectionSpec.Builder(this).a(arrayOfString3).b(arrayOfString2).a();
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
      break;
    }
  }
  
  public List a()
  {
    if (this.g == null) {
      return null;
    }
    CipherSuite[] arrayOfCipherSuite = new CipherSuite[this.g.length];
    int i = 0;
    while (i < this.g.length)
    {
      arrayOfCipherSuite[i] = CipherSuite.a(this.g[i]);
      i += 1;
    }
    return Util.a(arrayOfCipherSuite);
  }
  
  void a(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    ConnectionSpec localConnectionSpec = b(paramSSLSocket, paramBoolean);
    if (localConnectionSpec.h != null) {
      paramSSLSocket.setEnabledProtocols(localConnectionSpec.h);
    }
    if (localConnectionSpec.g != null) {
      paramSSLSocket.setEnabledCipherSuites(localConnectionSpec.g);
    }
  }
  
  public boolean a(SSLSocket paramSSLSocket)
  {
    if (!this.e) {}
    while (((this.h != null) && (!a(this.h, paramSSLSocket.getEnabledProtocols()))) || ((this.g != null) && (!a(this.g, paramSSLSocket.getEnabledCipherSuites())))) {
      return false;
    }
    return true;
  }
  
  public List b()
  {
    if (this.h == null) {
      return null;
    }
    TlsVersion[] arrayOfTlsVersion = new TlsVersion[this.h.length];
    int i = 0;
    while (i < this.h.length)
    {
      arrayOfTlsVersion[i] = TlsVersion.a(this.h[i]);
      i += 1;
    }
    return Util.a(arrayOfTlsVersion);
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionSpec)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (ConnectionSpec)paramObject;
    } while ((this.e != paramObject.e) || ((this.e) && ((!Arrays.equals(this.g, paramObject.g)) || (!Arrays.equals(this.h, paramObject.h)) || (this.f != paramObject.f))));
    return true;
  }
  
  public int hashCode()
  {
    int i = 17;
    int j;
    int k;
    if (this.e)
    {
      j = Arrays.hashCode(this.g);
      k = Arrays.hashCode(this.h);
      if (!this.f) {
        break label53;
      }
    }
    label53:
    for (i = 0;; i = 1)
    {
      i += ((j + 527) * 31 + k) * 31;
      return i;
    }
  }
  
  public String toString()
  {
    if (!this.e) {
      return "ConnectionSpec()";
    }
    String str1;
    if (this.g != null)
    {
      str1 = a().toString();
      if (this.h == null) {
        break label92;
      }
    }
    label92:
    for (String str2 = b().toString();; str2 = "[all enabled]")
    {
      return "ConnectionSpec(cipherSuites=" + str1 + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.f + ")";
      str1 = "[all enabled]";
      break;
    }
  }
}
