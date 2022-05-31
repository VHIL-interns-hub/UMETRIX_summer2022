package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;

public class GifDrawableLoadProvider
  implements DataLoadProvider
{
  private final GifResourceDecoder a;
  private final GifResourceEncoder b;
  private final StreamEncoder c;
  private final FileToStreamDecoder d;
  
  public GifDrawableLoadProvider(Context paramContext, BitmapPool paramBitmapPool)
  {
    this.a = new GifResourceDecoder(paramContext, paramBitmapPool);
    this.d = new FileToStreamDecoder(this.a);
    this.b = new GifResourceEncoder(paramBitmapPool);
    this.c = new StreamEncoder();
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
