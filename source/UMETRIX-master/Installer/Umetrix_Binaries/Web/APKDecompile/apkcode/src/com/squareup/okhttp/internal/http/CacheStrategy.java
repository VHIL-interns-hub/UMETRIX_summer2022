package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public final class CacheStrategy
{
  public final Request a;
  public final Response b;
  
  private CacheStrategy(Request paramRequest, Response paramResponse)
  {
    this.a = paramRequest;
    this.b = paramResponse;
  }
  
  public static boolean a(Response paramResponse, Request paramRequest)
  {
    switch (paramResponse.c())
    {
    }
    do
    {
      return false;
    } while (((paramResponse.a("Expires") == null) && (paramResponse.l().c() == -1) && (!paramResponse.l().e()) && (!paramResponse.l().d())) || (paramResponse.l().b()) || (paramRequest.i().b()));
    return true;
  }
}
