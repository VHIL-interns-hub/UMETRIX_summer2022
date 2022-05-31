package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

public abstract interface DrawableWrapper
{
  public abstract Drawable a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(ColorStateList paramColorStateList);
  
  public abstract void a(PorterDuff.Mode paramMode);
  
  public abstract void a(Drawable paramDrawable);
}
