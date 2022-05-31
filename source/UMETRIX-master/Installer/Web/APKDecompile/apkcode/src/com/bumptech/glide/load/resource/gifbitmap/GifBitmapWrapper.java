package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.engine.Resource;

public class GifBitmapWrapper
{
  private final Resource a;
  private final Resource b;
  
  public GifBitmapWrapper(Resource paramResource1, Resource paramResource2)
  {
    if ((paramResource1 != null) && (paramResource2 != null)) {
      throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
    }
    if ((paramResource1 == null) && (paramResource2 == null)) {
      throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
    }
    this.b = paramResource1;
    this.a = paramResource2;
  }
  
  public int a()
  {
    if (this.b != null) {
      return this.b.c();
    }
    return this.a.c();
  }
  
  public Resource b()
  {
    return this.b;
  }
  
  public Resource c()
  {
    return this.a;
  }
}
