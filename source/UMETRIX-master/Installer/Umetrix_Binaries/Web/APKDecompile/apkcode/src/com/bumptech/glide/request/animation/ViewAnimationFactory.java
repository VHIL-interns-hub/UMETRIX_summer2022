package com.bumptech.glide.request.animation;

public class ViewAnimationFactory
  implements GlideAnimationFactory
{
  private final ViewAnimation.AnimationFactory a;
  private GlideAnimation b;
  
  ViewAnimationFactory(ViewAnimation.AnimationFactory paramAnimationFactory)
  {
    this.a = paramAnimationFactory;
  }
  
  public GlideAnimation a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) || (!paramBoolean2)) {
      return NoAnimation.b();
    }
    if (this.b == null) {
      this.b = new ViewAnimation(this.a);
    }
    return this.b;
  }
}
