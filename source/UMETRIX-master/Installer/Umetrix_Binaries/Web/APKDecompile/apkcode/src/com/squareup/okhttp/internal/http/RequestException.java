package com.squareup.okhttp.internal.http;

import java.io.IOException;

public final class RequestException
  extends Exception
{
  public IOException a()
  {
    return (IOException)super.getCause();
  }
}
