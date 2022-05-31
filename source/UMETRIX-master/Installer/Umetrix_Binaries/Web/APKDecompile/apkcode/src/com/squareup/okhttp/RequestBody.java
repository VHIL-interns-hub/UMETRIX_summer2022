package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import okio.BufferedSink;

public abstract class RequestBody
{
  public RequestBody() {}
  
  public static RequestBody a(MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    return a(paramMediaType, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static RequestBody a(MediaType paramMediaType, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("content == null");
    }
    Util.a(paramArrayOfByte.length, paramInt1, paramInt2);
    return new RequestBody.2(paramMediaType, paramInt2, paramArrayOfByte, paramInt1);
  }
  
  public long a()
  {
    return -1L;
  }
  
  public abstract void a(BufferedSink paramBufferedSink);
}
