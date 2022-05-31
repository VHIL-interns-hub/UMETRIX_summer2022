package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

public class GlideBitmapDrawableResource
  extends DrawableResource
{
  private final BitmapPool b;
  
  public GlideBitmapDrawableResource(GlideBitmapDrawable paramGlideBitmapDrawable, BitmapPool paramBitmapPool)
  {
    super(paramGlideBitmapDrawable);
    this.b = paramBitmapPool;
  }
  
  public int c()
  {
    return Util.a(((GlideBitmapDrawable)this.a).b());
  }
  
  public void d()
  {
    this.b.a(((GlideBitmapDrawable)this.a).b());
  }
}
