package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.load.engine.Resource;

public abstract class DrawableResource
  implements Resource
{
  protected final Drawable a;
  
  public DrawableResource(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      throw new NullPointerException("Drawable must not be null!");
    }
    this.a = paramDrawable;
  }
  
  public final Drawable a()
  {
    return this.a.getConstantState().newDrawable();
  }
}
