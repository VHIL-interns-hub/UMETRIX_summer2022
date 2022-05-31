package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class HttpsURLConnectionImpl
  extends DelegatingHttpsURLConnection
{
  private final HttpURLConnectionImpl a;
  
  public HttpsURLConnectionImpl(HttpURLConnectionImpl paramHttpURLConnectionImpl)
  {
    super(paramHttpURLConnectionImpl);
    this.a = paramHttpURLConnectionImpl;
  }
  
  public HttpsURLConnectionImpl(URL paramURL, OkHttpClient paramOkHttpClient)
  {
    this(new HttpURLConnectionImpl(paramURL, paramOkHttpClient));
  }
  
  protected Handshake a()
  {
    if (this.a.c == null) {
      throw new IllegalStateException("Connection has not yet been established");
    }
    if (this.a.c.e()) {
      return this.a.c.f().e();
    }
    return this.a.d;
  }
  
  public HostnameVerifier getHostnameVerifier()
  {
    return this.a.a.k();
  }
  
  public SSLSocketFactory getSSLSocketFactory()
  {
    return this.a.a.j();
  }
  
  public void setFixedLengthStreamingMode(long paramLong)
  {
    this.a.setFixedLengthStreamingMode(paramLong);
  }
  
  public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.a.a.a(paramHostnameVerifier);
  }
  
  public void setSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.a.a.a(paramSSLSocketFactory);
  }
}
