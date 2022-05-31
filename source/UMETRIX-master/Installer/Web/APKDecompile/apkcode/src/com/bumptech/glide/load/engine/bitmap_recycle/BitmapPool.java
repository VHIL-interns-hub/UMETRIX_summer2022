package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public abstract interface BitmapPool
{
  public abstract Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract boolean a(Bitmap paramBitmap);
  
  public abstract Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
}
