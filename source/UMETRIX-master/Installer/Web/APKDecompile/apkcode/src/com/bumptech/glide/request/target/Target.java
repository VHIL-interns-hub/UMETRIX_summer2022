package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;

public abstract interface Target
  extends LifecycleListener
{
  public abstract void a(Drawable paramDrawable);
  
  public abstract void a(Request paramRequest);
  
  public abstract void a(SizeReadyCallback paramSizeReadyCallback);
  
  public abstract void a(Exception paramException, Drawable paramDrawable);
  
  public abstract void a(Object paramObject, GlideAnimation paramGlideAnimation);
  
  public abstract void b(Drawable paramDrawable);
  
  public abstract Request c();
}
