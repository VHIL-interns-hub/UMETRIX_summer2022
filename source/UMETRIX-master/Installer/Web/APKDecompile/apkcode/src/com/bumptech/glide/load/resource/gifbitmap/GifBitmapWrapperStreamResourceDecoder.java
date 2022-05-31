package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import java.io.InputStream;

public class GifBitmapWrapperStreamResourceDecoder
  implements ResourceDecoder
{
  private final ResourceDecoder a;
  
  public GifBitmapWrapperStreamResourceDecoder(ResourceDecoder paramResourceDecoder)
  {
    this.a = paramResourceDecoder;
  }
  
  public Resource a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    return this.a.a(new ImageVideoWrapper(paramInputStream, null), paramInt1, paramInt2);
  }
  
  public String a()
  {
    return this.a.a();
  }
}
