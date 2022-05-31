package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class BitmapImageViewTarget
  extends ImageViewTarget
{
  public BitmapImageViewTarget(ImageView paramImageView)
  {
    super(paramImageView);
  }
  
  protected void a(Bitmap paramBitmap)
  {
    ((ImageView)this.a).setImageBitmap(paramBitmap);
  }
}
