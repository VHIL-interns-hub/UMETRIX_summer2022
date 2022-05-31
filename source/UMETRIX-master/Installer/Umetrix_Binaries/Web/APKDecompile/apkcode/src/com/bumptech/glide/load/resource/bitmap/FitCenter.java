package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class FitCenter
  extends BitmapTransformation
{
  public FitCenter(BitmapPool paramBitmapPool)
  {
    super(paramBitmapPool);
  }
  
  protected Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return TransformationUtils.a(paramBitmap, paramBitmapPool, paramInt1, paramInt2);
  }
  
  public String a()
  {
    return "FitCenter.com.bumptech.glide.load.resource.bitmap";
  }
}
