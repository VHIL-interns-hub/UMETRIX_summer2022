package com.bumptech.glide.request.target;

import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;

public class GlideDrawableImageViewTarget
  extends ImageViewTarget
{
  private int b;
  private GlideDrawable c;
  
  public GlideDrawableImageViewTarget(ImageView paramImageView)
  {
    this(paramImageView, -1);
  }
  
  public GlideDrawableImageViewTarget(ImageView paramImageView, int paramInt)
  {
    super(paramImageView);
    this.b = paramInt;
  }
  
  protected void a(GlideDrawable paramGlideDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramGlideDrawable);
  }
  
  public void a(GlideDrawable paramGlideDrawable, GlideAnimation paramGlideAnimation)
  {
    Object localObject = paramGlideDrawable;
    if (!paramGlideDrawable.a())
    {
      float f1 = ((ImageView)this.a).getWidth() / ((ImageView)this.a).getHeight();
      float f2 = paramGlideDrawable.getIntrinsicWidth() / paramGlideDrawable.getIntrinsicHeight();
      localObject = paramGlideDrawable;
      if (Math.abs(f1 - 1.0F) <= 0.05F)
      {
        localObject = paramGlideDrawable;
        if (Math.abs(f2 - 1.0F) <= 0.05F) {
          localObject = new SquaringDrawable(paramGlideDrawable, ((ImageView)this.a).getWidth());
        }
      }
    }
    super.a(localObject, paramGlideAnimation);
    this.c = ((GlideDrawable)localObject);
    ((GlideDrawable)localObject).a(this.b);
    ((GlideDrawable)localObject).start();
  }
  
  public void d()
  {
    if (this.c != null) {
      this.c.start();
    }
  }
  
  public void e()
  {
    if (this.c != null) {
      this.c.stop();
    }
  }
}
