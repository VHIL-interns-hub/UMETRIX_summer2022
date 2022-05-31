package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

public final class CertificatePinner
{
  public static final CertificatePinner a = new CertificatePinner.Builder().a();
  private final Map b;
  
  private CertificatePinner(CertificatePinner.Builder paramBuilder)
  {
    this.b = Util.a(CertificatePinner.Builder.a(paramBuilder));
  }
  
  public static String a(Certificate paramCertificate)
  {
    if (!(paramCertificate instanceof X509Certificate)) {
      throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
    return "sha1/" + a((X509Certificate)paramCertificate).b();
  }
  
  private static ByteString a(X509Certificate paramX509Certificate)
  {
    return Util.a(ByteString.a(paramX509Certificate.getPublicKey().getEncoded()));
  }
  
  Set a(String paramString)
  {
    Set localSet = (Set)this.b.get(paramString);
    int i = paramString.indexOf('.');
    if (i != paramString.lastIndexOf('.')) {}
    for (paramString = (Set)this.b.get("*." + paramString.substring(i + 1));; paramString = null)
    {
      Object localObject;
      if ((localSet == null) && (paramString == null)) {
        localObject = null;
      }
      do
      {
        return localObject;
        if ((localSet != null) && (paramString != null))
        {
          localObject = new LinkedHashSet();
          ((Set)localObject).addAll(localSet);
          ((Set)localObject).addAll(paramString);
          return localObject;
        }
        localObject = localSet;
      } while (localSet != null);
      return paramString;
    }
  }
  
  public void a(String paramString, List paramList)
  {
    int j = 0;
    Set localSet = a(paramString);
    if (localSet == null) {
      return;
    }
    int k = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label62;
      }
      if (localSet.contains(a((X509Certificate)paramList.get(i)))) {
        break;
      }
      i += 1;
    }
    label62:
    StringBuilder localStringBuilder = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
    k = paramList.size();
    i = j;
    while (i < k)
    {
      X509Certificate localX509Certificate = (X509Certificate)paramList.get(i);
      localStringBuilder.append("\n    ").append(a(localX509Certificate)).append(": ").append(localX509Certificate.getSubjectDN().getName());
      i += 1;
    }
    localStringBuilder.append("\n  Pinned certificates for ").append(paramString).append(":");
    paramString = localSet.iterator();
    while (paramString.hasNext())
    {
      paramList = (ByteString)paramString.next();
      localStringBuilder.append("\n    sha1/").append(paramList.b());
    }
    throw new SSLPeerUnverifiedException(localStringBuilder.toString());
  }
}
