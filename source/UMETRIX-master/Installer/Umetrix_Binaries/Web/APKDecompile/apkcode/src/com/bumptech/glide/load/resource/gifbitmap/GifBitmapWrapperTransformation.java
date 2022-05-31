package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;

public class GifBitmapWrapperTransformation
  implements Transformation
{
  private final Transformation a;
  private final Transformation b;
  
  GifBitmapWrapperTransformation(Transformation paramTransformation1, Transformation paramTransformation2)
  {
    this.a = paramTransformation1;
    this.b = paramTransformation2;
  }
  
  public GifBitmapWrapperTransformation(BitmapPool paramBitmapPool, Transformation paramTransformation)
  {
    this(paramTransformation, new GifDrawableTransformation(paramTransformation, paramBitmapPool));
  }
  
  public Resource a(Resource paramResource, int paramInt1, int paramInt2)
  {
    Resource localResource1 = ((GifBitmapWrapper)paramResource.b()).b();
    Resource localResource2 = ((GifBitmapWrapper)paramResource.b()).c();
    Object localObject;
    if ((localResource1 != null) && (this.a != null))
    {
      localResource2 = this.a.a(localResource1, paramInt1, paramInt2);
      localObject = paramResource;
      if (!localResource1.equals(localResource2)) {
        localObject = new GifBitmapWrapperResource(new GifBitmapWrapper(localResource2, ((GifBitmapWrapper)paramResource.b()).c()));
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = paramResource;
        } while (localResource2 == null);
        localObject = paramResource;
      } while (this.b == null);
      localResource1 = this.b.a(localResource2, paramInt1, paramInt2);
      localObject = paramResource;
    } while (localResource2.equals(localResource1));
    return new GifBitmapWrapperResource(new GifBitmapWrapper(((GifBitmapWrapper)paramResource.b()).b(), localResource1));
  }
  
  public String a()
  {
    return this.a.a();
  }
}
