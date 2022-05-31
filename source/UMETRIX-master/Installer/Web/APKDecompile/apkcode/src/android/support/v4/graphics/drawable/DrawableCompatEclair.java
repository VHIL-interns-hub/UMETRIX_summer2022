package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

class DrawableCompatEclair
{
  public static Drawable a(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof DrawableWrapperEclair)) {
      localObject = new DrawableWrapperEclair(paramDrawable);
    }
    return localObject;
  }
}
