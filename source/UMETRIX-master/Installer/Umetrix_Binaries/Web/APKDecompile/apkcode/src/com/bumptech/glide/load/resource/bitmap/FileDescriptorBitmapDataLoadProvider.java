package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.NullEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;

public class FileDescriptorBitmapDataLoadProvider
  implements DataLoadProvider
{
  private final ResourceDecoder a;
  private final FileDescriptorBitmapDecoder b;
  private final BitmapEncoder c;
  private final Encoder d;
  
  public FileDescriptorBitmapDataLoadProvider(BitmapPool paramBitmapPool, DecodeFormat paramDecodeFormat)
  {
    this.a = new FileToStreamDecoder(new StreamBitmapDecoder(paramBitmapPool, paramDecodeFormat));
    this.b = new FileDescriptorBitmapDecoder(paramBitmapPool, paramDecodeFormat);
    this.c = new BitmapEncoder();
    this.d = NullEncoder.b();
  }
  
  public ResourceDecoder a()
  {
    return this.a;
  }
  
  public ResourceDecoder b()
  {
    return this.b;
  }
  
  public Encoder c()
  {
    return this.d;
  }
  
  public ResourceEncoder d()
  {
    return this.c;
  }
}
