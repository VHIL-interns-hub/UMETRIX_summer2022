package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.OutputStream;

public class NullResourceEncoder
  implements ResourceEncoder
{
  private static final NullResourceEncoder a = new NullResourceEncoder();
  
  public NullResourceEncoder() {}
  
  public static NullResourceEncoder b()
  {
    return a;
  }
  
  public String a()
  {
    return "";
  }
  
  public boolean a(Resource paramResource, OutputStream paramOutputStream)
  {
    return false;
  }
}
