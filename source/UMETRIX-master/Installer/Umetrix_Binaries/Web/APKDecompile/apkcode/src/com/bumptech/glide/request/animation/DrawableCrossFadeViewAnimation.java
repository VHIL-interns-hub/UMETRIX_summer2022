package com.bumptech.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

public class DrawableCrossFadeViewAnimation
  implements GlideAnimation
{
  private final GlideAnimation a;
  private final int b;
  
  public DrawableCrossFadeViewAnimation(GlideAnimation paramGlideAnimation, int paramInt)
  {
    this.a = paramGlideAnimation;
    this.b = paramInt;
  }
  
  public boolean a(Drawable paramDrawable, GlideAnimation.ViewAdapter paramViewAdapter)
  {
    Drawable localDrawable = paramViewAdapter.b();
    if (localDrawable != null)
    {
      paramDrawable = new TransitionDrawable(new Drawable[] { localDrawable, paramDrawable });
      paramDrawable.setCrossFadeEnabled(true);
      paramDrawable.startTransition(this.b);
      paramViewAdapter.c(paramDrawable);
      return true;
    }
    this.a.a(paramDrawable, paramViewAdapter);
    return false;
  }
}
