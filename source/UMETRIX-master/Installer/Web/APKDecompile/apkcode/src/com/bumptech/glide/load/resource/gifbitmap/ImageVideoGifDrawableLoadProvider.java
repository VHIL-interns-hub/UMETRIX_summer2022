package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;

public class ImageVideoGifDrawableLoadProvider
  implements DataLoadProvider
{
  private final ResourceDecoder a;
  private final ResourceDecoder b;
  private final ResourceEncoder c;
  private final Encoder d;
  
  public ImageVideoGifDrawableLoadProvider(DataLoadProvider paramDataLoadProvider1, DataLoadProvider paramDataLoadProvider2, BitmapPool paramBitmapPool)
  {
    paramBitmapPool = new GifBitmapWrapperResourceDecoder(paramDataLoadProvider1.b(), paramDataLoadProvider2.b(), paramBitmapPool);
    this.a = new FileToStreamDecoder(new GifBitmapWrapperStreamResourceDecoder(paramBitmapPool));
    this.b = paramBitmapPool;
    this.c = new GifBitmapWrapperResourceEncoder(paramDataLoadProvider1.d(), paramDataLoadProvider2.d());
    this.d = paramDataLoadProvider1.c();
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
