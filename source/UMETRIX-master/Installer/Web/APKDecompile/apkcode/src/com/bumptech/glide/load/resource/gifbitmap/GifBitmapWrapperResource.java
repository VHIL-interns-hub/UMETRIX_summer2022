package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.engine.Resource;

public class GifBitmapWrapperResource
  implements Resource
{
  private final GifBitmapWrapper a;
  
  public GifBitmapWrapperResource(GifBitmapWrapper paramGifBitmapWrapper)
  {
    if (paramGifBitmapWrapper == null) {
      throw new NullPointerException("Data must not be null");
    }
    this.a = paramGifBitmapWrapper;
  }
  
  public GifBitmapWrapper a()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.a.a();
  }
  
  public void d()
  {
    Resource localResource = this.a.b();
    if (localResource != null) {
      localResource.d();
    }
    localResource = this.a.c();
    if (localResource != null) {
      localResource.d();
    }
  }
}
