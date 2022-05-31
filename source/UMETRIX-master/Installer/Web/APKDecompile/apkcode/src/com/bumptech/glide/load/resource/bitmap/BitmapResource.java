package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public class BitmapResource
  implements Resource
{
  private final Bitmap a;
  private final BitmapPool b;
  
  public BitmapResource(Bitmap paramBitmap, BitmapPool paramBitmapPool)
  {
    if (paramBitmap == null) {
      throw new NullPointerException("Bitmap must not be null");
    }
    if (paramBitmapPool == null) {
      throw new NullPointerException("BitmapPool must not be null");
    }
    this.a = paramBitmap;
    this.b = paramBitmapPool;
  }
  
  public static BitmapResource a(Bitmap paramBitmap, BitmapPool paramBitmapPool)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new BitmapResource(paramBitmap, paramBitmapPool);
  }
  
  public Bitmap a()
  {
    return this.a;
  }
  
  public int c()
  {
    return Util.a(this.a);
  }
  
  public void d()
  {
    if (!this.b.a(this.a)) {
      this.a.recycle();
    }
  }
}
