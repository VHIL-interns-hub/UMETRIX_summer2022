package com.squareup.okhttp;

import com.squareup.okhttp.internal.huc.HttpURLConnectionImpl;
import com.squareup.okhttp.internal.huc.HttpsURLConnectionImpl;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public final class OkUrlFactory
  implements Cloneable, URLStreamHandlerFactory
{
  private final OkHttpClient a;
  
  public OkUrlFactory(OkHttpClient paramOkHttpClient)
  {
    this.a = paramOkHttpClient;
  }
  
  public OkUrlFactory a()
  {
    return new OkUrlFactory(this.a.v());
  }
  
  public HttpURLConnection a(URL paramURL)
  {
    return a(paramURL, this.a.d());
  }
  
  HttpURLConnection a(URL paramURL, Proxy paramProxy)
  {
    String str = paramURL.getProtocol();
    OkHttpClient localOkHttpClient = this.a.u();
    localOkHttpClient.a(paramProxy);
    if (str.equals("http")) {
      return new HttpURLConnectionImpl(paramURL, localOkHttpClient);
    }
    if (str.equals("https")) {
      return new HttpsURLConnectionImpl(paramURL, localOkHttpClient);
    }
    throw new IllegalArgumentException("Unexpected protocol: " + str);
  }
  
  public URLStreamHandler createURLStreamHandler(String paramString)
  {
    if ((!paramString.equals("http")) && (!paramString.equals("https"))) {
      return null;
    }
    return new OkUrlFactory.1(this, paramString);
  }
}
