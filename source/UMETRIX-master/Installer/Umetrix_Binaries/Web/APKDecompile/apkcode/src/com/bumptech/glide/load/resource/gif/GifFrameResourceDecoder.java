package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

class GifFrameResourceDecoder
  implements ResourceDecoder
{
  private final BitmapPool a;
  
  public GifFrameResourceDecoder(BitmapPool paramBitmapPool)
  {
    this.a = paramBitmapPool;
  }
  
  public Resource a(GifDecoder paramGifDecoder, int paramInt1, int paramInt2)
  {
    return BitmapResource.a(paramGifDecoder.f(), this.a);
  }
  
  public String a()
  {
    return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
  }
}
