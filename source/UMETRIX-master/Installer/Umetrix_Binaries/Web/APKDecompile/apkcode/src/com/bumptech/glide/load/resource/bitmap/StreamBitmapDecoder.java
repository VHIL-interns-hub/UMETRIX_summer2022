package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.InputStream;

public class StreamBitmapDecoder
  implements ResourceDecoder
{
  private final Downsampler a;
  private BitmapPool b;
  private DecodeFormat c;
  private String d;
  
  public StreamBitmapDecoder(BitmapPool paramBitmapPool, DecodeFormat paramDecodeFormat)
  {
    this(Downsampler.a, paramBitmapPool, paramDecodeFormat);
  }
  
  public StreamBitmapDecoder(Downsampler paramDownsampler, BitmapPool paramBitmapPool, DecodeFormat paramDecodeFormat)
  {
    this.a = paramDownsampler;
    this.b = paramBitmapPool;
    this.c = paramDecodeFormat;
  }
  
  public Resource a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    return BitmapResource.a(this.a.a(paramInputStream, this.b, paramInt1, paramInt2, this.c), this.b);
  }
  
  public String a()
  {
    if (this.d == null) {
      this.d = ("StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.a.a() + this.c.name());
    }
    return this.d;
  }
}
