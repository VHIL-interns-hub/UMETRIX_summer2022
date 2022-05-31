package com.squareup.okhttp;

import java.io.Closeable;
import java.io.InputStream;
import okio.BufferedSource;

public abstract class ResponseBody
  implements Closeable
{
  public ResponseBody() {}
  
  public abstract long a();
  
  public final InputStream b()
  {
    return c().h();
  }
  
  public abstract BufferedSource c();
  
  public void close()
  {
    c().close();
  }
}
