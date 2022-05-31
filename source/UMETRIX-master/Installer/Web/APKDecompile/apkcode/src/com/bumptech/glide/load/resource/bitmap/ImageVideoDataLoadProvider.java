package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.ImageVideoWrapperEncoder;
import com.bumptech.glide.provider.DataLoadProvider;

public class ImageVideoDataLoadProvider
  implements DataLoadProvider
{
  private final ImageVideoBitmapDecoder a;
  private final ResourceDecoder b;
  private final ResourceEncoder c;
  private final ImageVideoWrapperEncoder d;
  
  public ImageVideoDataLoadProvider(DataLoadProvider paramDataLoadProvider1, DataLoadProvider paramDataLoadProvider2)
  {
    this.c = paramDataLoadProvider1.d();
    this.d = new ImageVideoWrapperEncoder(paramDataLoadProvider1.c(), paramDataLoadProvider2.c());
    this.b = paramDataLoadProvider1.a();
    this.a = new ImageVideoBitmapDecoder(paramDataLoadProvider1.b(), paramDataLoadProvider2.b());
  }
  
  public ResourceDecoder a()
  {
    return this.b;
  }
  
  public ResourceDecoder b()
  {
    return this.a;
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
