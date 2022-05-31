package com.squareup.okhttp.internal;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

public abstract class Internal
{
  public static final Logger a = Logger.getLogger(OkHttpClient.class.getName());
  public static Internal b;
  
  public Internal() {}
  
  public abstract HttpUrl a(String paramString);
  
  public abstract InternalCache a(OkHttpClient paramOkHttpClient);
  
  public abstract RouteDatabase a(ConnectionPool paramConnectionPool);
  
  public abstract RealConnection a(ConnectionPool paramConnectionPool, Address paramAddress, StreamAllocation paramStreamAllocation);
  
  public abstract void a(ConnectionSpec paramConnectionSpec, SSLSocket paramSSLSocket, boolean paramBoolean);
  
  public abstract void a(Headers.Builder paramBuilder, String paramString);
  
  public abstract boolean a(ConnectionPool paramConnectionPool, RealConnection paramRealConnection);
  
  public abstract void b(ConnectionPool paramConnectionPool, RealConnection paramRealConnection);
}
