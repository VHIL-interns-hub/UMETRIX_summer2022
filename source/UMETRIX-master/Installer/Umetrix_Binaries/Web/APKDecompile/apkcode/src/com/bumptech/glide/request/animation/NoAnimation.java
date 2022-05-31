package com.bumptech.glide.request.animation;

public class NoAnimation
  implements GlideAnimation
{
  private static final NoAnimation a = new NoAnimation();
  private static final GlideAnimationFactory b = new NoAnimation.NoAnimationFactory();
  
  public NoAnimation() {}
  
  public static GlideAnimationFactory a()
  {
    return b;
  }
  
  public static GlideAnimation b()
  {
    return a;
  }
  
  public boolean a(Object paramObject, GlideAnimation.ViewAdapter paramViewAdapter)
  {
    return false;
  }
}
