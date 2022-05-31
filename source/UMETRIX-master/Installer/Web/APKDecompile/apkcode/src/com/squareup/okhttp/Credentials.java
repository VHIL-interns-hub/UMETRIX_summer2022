package com.squareup.okhttp;

import java.io.UnsupportedEncodingException;
import okio.ByteString;

public final class Credentials
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = ByteString.a((paramString1 + ":" + paramString2).getBytes("ISO-8859-1")).b();
      paramString1 = "Basic " + paramString1;
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new AssertionError();
    }
  }
}
