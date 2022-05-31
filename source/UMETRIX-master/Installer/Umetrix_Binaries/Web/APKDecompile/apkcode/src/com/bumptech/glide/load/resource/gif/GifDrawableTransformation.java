package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

public class GifDrawableTransformation
  implements Transformation
{
  private final Transformation a;
  private final BitmapPool b;
  
  public GifDrawableTransformation(Transformation paramTransformation, BitmapPool paramBitmapPool)
  {
    this.a = paramTransformation;
    this.b = paramBitmapPool;
  }
  
  public Resource a(Resource paramResource, int paramInt1, int paramInt2)
  {
    GifDrawable localGifDrawable = (GifDrawable)paramResource.b();
    Bitmap localBitmap = ((GifDrawable)paramResource.b()).b();
    Object localObject = new BitmapResource(localBitmap, this.b);
    localObject = (Bitmap)this.a.a((Resource)localObject, paramInt1, paramInt2).b();
    if (!localObject.equals(localBitmap)) {
      paramResource = new GifDrawableResource(new GifDrawable(localGifDrawable, (Bitmap)localObject, this.a));
    }
    return paramResource;
  }
  
  public String a()
  {
    return this.a.a();
  }
}
