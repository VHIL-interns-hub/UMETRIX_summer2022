package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public abstract class BitmapTransformation
  implements Transformation
{
  private BitmapPool a;
  
  public BitmapTransformation(BitmapPool paramBitmapPool)
  {
    this.a = paramBitmapPool;
  }
  
  protected abstract Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public final Resource a(Resource paramResource, int paramInt1, int paramInt2)
  {
    if (!Util.a(paramInt1, paramInt2)) {
      throw new IllegalArgumentException("Cannot apply transformation on width: " + paramInt1 + " or height: " + paramInt2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
    Bitmap localBitmap1 = (Bitmap)paramResource.b();
    int i = paramInt1;
    if (paramInt1 == Integer.MIN_VALUE) {
      i = localBitmap1.getWidth();
    }
    paramInt1 = paramInt2;
    if (paramInt2 == Integer.MIN_VALUE) {
      paramInt1 = localBitmap1.getHeight();
    }
    Bitmap localBitmap2 = a(this.a, localBitmap1, i, paramInt1);
    if (localBitmap1.equals(localBitmap2)) {
      return paramResource;
    }
    return BitmapResource.a(localBitmap2, this.a);
  }
}
