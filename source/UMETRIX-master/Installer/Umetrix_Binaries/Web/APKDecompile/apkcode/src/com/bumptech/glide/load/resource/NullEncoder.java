package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.Encoder;
import java.io.OutputStream;

public class NullEncoder
  implements Encoder
{
  private static final NullEncoder a = new NullEncoder();
  
  public NullEncoder() {}
  
  public static Encoder b()
  {
    return a;
  }
  
  public String a()
  {
    return "";
  }
  
  public boolean a(Object paramObject, OutputStream paramOutputStream)
  {
    return false;
  }
}
