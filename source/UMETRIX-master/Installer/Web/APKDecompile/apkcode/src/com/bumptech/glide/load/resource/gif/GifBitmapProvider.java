package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

class GifBitmapProvider
  implements GifDecoder.BitmapProvider
{
  private final BitmapPool a;
  
  public GifBitmapProvider(BitmapPool paramBitmapPool)
  {
    this.a = paramBitmapPool;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return this.a.b(paramInt1, paramInt2, paramConfig);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (!this.a.a(paramBitmap)) {
      paramBitmap.recycle();
    }
  }
}
