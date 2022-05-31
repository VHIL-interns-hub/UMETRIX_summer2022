package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.animation.GlideAnimation.ViewAdapter;

public abstract class ImageViewTarget
  extends ViewTarget
  implements GlideAnimation.ViewAdapter
{
  public ImageViewTarget(ImageView paramImageView)
  {
    super(paramImageView);
  }
  
  public void a(Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
  
  public void a(Exception paramException, Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
  
  protected abstract void a(Object paramObject);
  
  public void a(Object paramObject, GlideAnimation paramGlideAnimation)
  {
    if ((paramGlideAnimation == null) || (!paramGlideAnimation.a(paramObject, this))) {
      a(paramObject);
    }
  }
  
  public Drawable b()
  {
    return ((ImageView)this.a).getDrawable();
  }
  
  public void b(Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
  
  public void c(Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
}
