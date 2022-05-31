package com.bumptech.glide.load.resource.transcode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawableResource;

public class GlideBitmapDrawableTranscoder
  implements ResourceTranscoder
{
  private final Resources a;
  private final BitmapPool b;
  
  public GlideBitmapDrawableTranscoder(Resources paramResources, BitmapPool paramBitmapPool)
  {
    this.a = paramResources;
    this.b = paramBitmapPool;
  }
  
  public Resource a(Resource paramResource)
  {
    return new GlideBitmapDrawableResource(new GlideBitmapDrawable(this.a, (Bitmap)paramResource.b()), this.b);
  }
  
  public String a()
  {
    return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
  }
}
