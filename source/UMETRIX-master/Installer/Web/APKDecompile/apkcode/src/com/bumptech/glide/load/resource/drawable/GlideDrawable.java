package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

public abstract class GlideDrawable
  extends Drawable
  implements Animatable
{
  public GlideDrawable() {}
  
  public abstract void a(int paramInt);
  
  public abstract boolean a();
}
