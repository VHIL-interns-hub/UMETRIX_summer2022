package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class CenterCrop
  extends BitmapTransformation
{
  public CenterCrop(BitmapPool paramBitmapPool)
  {
    super(paramBitmapPool);
  }
  
  protected Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap.getConfig() != null) {}
    for (Object localObject = paramBitmap.getConfig();; localObject = Bitmap.Config.ARGB_8888)
    {
      localObject = paramBitmapPool.a(paramInt1, paramInt2, (Bitmap.Config)localObject);
      paramBitmap = TransformationUtils.a((Bitmap)localObject, paramBitmap, paramInt1, paramInt2);
      if ((localObject != null) && (localObject != paramBitmap) && (!paramBitmapPool.a((Bitmap)localObject))) {
        ((Bitmap)localObject).recycle();
      }
      return paramBitmap;
    }
  }
  
  public String a()
  {
    return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
  }
}
