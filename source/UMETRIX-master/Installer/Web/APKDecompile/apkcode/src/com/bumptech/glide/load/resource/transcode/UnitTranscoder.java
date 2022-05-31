package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.engine.Resource;

public class UnitTranscoder
  implements ResourceTranscoder
{
  private static final UnitTranscoder a = new UnitTranscoder();
  
  public UnitTranscoder() {}
  
  public static ResourceTranscoder b()
  {
    return a;
  }
  
  public Resource a(Resource paramResource)
  {
    return paramResource;
  }
  
  public String a()
  {
    return "";
  }
}
