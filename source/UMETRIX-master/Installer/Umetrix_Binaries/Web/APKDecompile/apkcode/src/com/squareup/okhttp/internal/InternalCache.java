package com.squareup.okhttp.internal;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.CacheStrategy;

public abstract interface InternalCache
{
  public abstract Response a(Request paramRequest);
  
  public abstract CacheRequest a(Response paramResponse);
  
  public abstract void a();
  
  public abstract void a(Response paramResponse1, Response paramResponse2);
  
  public abstract void a(CacheStrategy paramCacheStrategy);
  
  public abstract void b(Request paramRequest);
}
