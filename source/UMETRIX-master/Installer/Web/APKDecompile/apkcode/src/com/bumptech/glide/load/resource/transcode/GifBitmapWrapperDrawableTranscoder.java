package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;

public class GifBitmapWrapperDrawableTranscoder
  implements ResourceTranscoder
{
  private final ResourceTranscoder a;
  
  public GifBitmapWrapperDrawableTranscoder(ResourceTranscoder paramResourceTranscoder)
  {
    this.a = paramResourceTranscoder;
  }
  
  public Resource a(Resource paramResource)
  {
    paramResource = (GifBitmapWrapper)paramResource.b();
    Resource localResource = paramResource.b();
    if (localResource != null) {
      return this.a.a(localResource);
    }
    return paramResource.c();
  }
  
  public String a()
  {
    return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
  }
}
