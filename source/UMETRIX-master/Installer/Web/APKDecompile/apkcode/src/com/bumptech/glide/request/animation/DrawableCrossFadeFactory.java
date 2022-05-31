package com.bumptech.glide.request.animation;

public class DrawableCrossFadeFactory
  implements GlideAnimationFactory
{
  private final ViewAnimationFactory a;
  private final int b;
  private DrawableCrossFadeViewAnimation c;
  private DrawableCrossFadeViewAnimation d;
  
  public DrawableCrossFadeFactory()
  {
    this(300);
  }
  
  public DrawableCrossFadeFactory(int paramInt)
  {
    this(new ViewAnimationFactory(new DrawableCrossFadeFactory.DefaultAnimationFactory(paramInt)), paramInt);
  }
  
  DrawableCrossFadeFactory(ViewAnimationFactory paramViewAnimationFactory, int paramInt)
  {
    this.a = paramViewAnimationFactory;
    this.b = paramInt;
  }
  
  private GlideAnimation a()
  {
    if (this.c == null) {
      this.c = new DrawableCrossFadeViewAnimation(this.a.a(false, true), this.b);
    }
    return this.c;
  }
  
  private GlideAnimation b()
  {
    if (this.d == null) {
      this.d = new DrawableCrossFadeViewAnimation(this.a.a(false, false), this.b);
    }
    return this.d;
  }
  
  public GlideAnimation a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return NoAnimation.b();
    }
    if (paramBoolean2) {
      return a();
    }
    return b();
  }
}
