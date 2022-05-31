package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

abstract interface LruPoolStrategy
{
  public abstract Bitmap a();
  
  public abstract Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public abstract String b(Bitmap paramBitmap);
  
  public abstract int c(Bitmap paramBitmap);
}
