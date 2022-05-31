package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.OutputStream;

public class GifBitmapWrapperResourceEncoder
  implements ResourceEncoder
{
  private final ResourceEncoder a;
  private final ResourceEncoder b;
  private String c;
  
  public GifBitmapWrapperResourceEncoder(ResourceEncoder paramResourceEncoder1, ResourceEncoder paramResourceEncoder2)
  {
    this.a = paramResourceEncoder1;
    this.b = paramResourceEncoder2;
  }
  
  public String a()
  {
    if (this.c == null) {
      this.c = (this.a.a() + this.b.a());
    }
    return this.c;
  }
  
  public boolean a(Resource paramResource, OutputStream paramOutputStream)
  {
    paramResource = (GifBitmapWrapper)paramResource.b();
    Resource localResource = paramResource.b();
    if (localResource != null) {
      return this.a.a(localResource, paramOutputStream);
    }
    return this.b.a(paramResource.c(), paramOutputStream);
  }
}
