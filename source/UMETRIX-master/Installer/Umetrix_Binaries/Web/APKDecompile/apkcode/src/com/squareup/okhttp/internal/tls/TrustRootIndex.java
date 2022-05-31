package com.squareup.okhttp.internal.tls;

import java.security.cert.X509Certificate;

public abstract interface TrustRootIndex
{
  public abstract X509Certificate a(X509Certificate paramX509Certificate);
}
