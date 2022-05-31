package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;

public class StreamBitmapDataLoadProvider
  implements DataLoadProvider
{
  private final StreamBitmapDecoder a;
  private final BitmapEncoder b;
  private final StreamEncoder c = new StreamEncoder();
  private final FileToStreamDecoder d;
  
  public StreamBitmapDataLoadProvider(BitmapPool paramBitmapPool, DecodeFormat paramDecodeFormat)
  {
    this.a = new StreamBitmapDecoder(paramBitmapPool, paramDecodeFormat);
    this.b = new BitmapEncoder();
    this.d = new FileToStreamDecoder(this.a);
  }
  
  public ResourceDecoder a()
  {
    return this.d;
  }
  
  public ResourceDecoder b()
  {
    return this.a;
  }
  
  public Encoder c()
  {
    return this.c;
  }
  
  public ResourceEncoder d()
  {
    return this.b;
  }
}
