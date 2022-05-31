package com.bumptech.glide.request.animation;

import android.view.View;

public class ViewAnimation
  implements GlideAnimation
{
  private final ViewAnimation.AnimationFactory a;
  
  ViewAnimation(ViewAnimation.AnimationFactory paramAnimationFactory)
  {
    this.a = paramAnimationFactory;
  }
  
  public boolean a(Object paramObject, GlideAnimation.ViewAdapter paramViewAdapter)
  {
    paramObject = paramViewAdapter.a();
    if (paramObject != null)
    {
      paramObject.clearAnimation();
      paramObject.startAnimation(this.a.a());
    }
    return false;
  }
}
