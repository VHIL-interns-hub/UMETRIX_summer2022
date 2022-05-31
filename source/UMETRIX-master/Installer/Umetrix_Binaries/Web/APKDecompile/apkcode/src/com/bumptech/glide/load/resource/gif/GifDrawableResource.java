package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

public class GifDrawableResource
  extends DrawableResource
{
  public GifDrawableResource(GifDrawable paramGifDrawable)
  {
    super(paramGifDrawable);
  }
  
  public int c()
  {
    int i = ((GifDrawable)this.a).d().length;
    return Util.a(((GifDrawable)this.a).b()) + i;
  }
  
  public void d()
  {
    ((GifDrawable)this.a).stop();
    ((GifDrawable)this.a).f();
  }
}
