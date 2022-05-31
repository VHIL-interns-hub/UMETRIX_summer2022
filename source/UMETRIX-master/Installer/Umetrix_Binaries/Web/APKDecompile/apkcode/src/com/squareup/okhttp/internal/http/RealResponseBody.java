package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody
  extends ResponseBody
{
  private final Headers a;
  private final BufferedSource b;
  
  public RealResponseBody(Headers paramHeaders, BufferedSource paramBufferedSource)
  {
    this.a = paramHeaders;
    this.b = paramBufferedSource;
  }
  
  public long a()
  {
    return OkHeaders.a(this.a);
  }
  
  public BufferedSource c()
  {
    return this.b;
  }
}
