package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import java.net.Proxy.Type;

public final class RequestLine
{
  public static String a(HttpUrl paramHttpUrl)
  {
    String str1 = paramHttpUrl.i();
    String str2 = paramHttpUrl.k();
    paramHttpUrl = str1;
    if (str2 != null) {
      paramHttpUrl = str1 + '?' + str2;
    }
    return paramHttpUrl;
  }
  
  static String a(Request paramRequest, Proxy.Type paramType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRequest.e());
    localStringBuilder.append(' ');
    if (b(paramRequest, paramType)) {
      localStringBuilder.append(paramRequest.a());
    }
    for (;;)
    {
      localStringBuilder.append(" HTTP/1.1");
      return localStringBuilder.toString();
      localStringBuilder.append(a(paramRequest.a()));
    }
  }
  
  private static boolean b(Request paramRequest, Proxy.Type paramType)
  {
    return (!paramRequest.j()) && (paramType == Proxy.Type.HTTP);
  }
}
