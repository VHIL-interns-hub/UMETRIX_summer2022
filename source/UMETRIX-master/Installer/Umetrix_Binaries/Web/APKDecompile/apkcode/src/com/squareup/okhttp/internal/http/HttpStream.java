package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import okio.Sink;

public abstract interface HttpStream
{
  public abstract ResponseBody a(Response paramResponse);
  
  public abstract Sink a(Request paramRequest, long paramLong);
  
  public abstract void a();
  
  public abstract void a(Request paramRequest);
  
  public abstract void a(HttpEngine paramHttpEngine);
  
  public abstract void a(RetryableSink paramRetryableSink);
  
  public abstract Response.Builder b();
  
  public abstract void c();
}
