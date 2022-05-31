package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

class DrawableCompatApi23
{
  public static int a(Drawable paramDrawable)
  {
    return paramDrawable.getLayoutDirection();
  }
  
  public static void a(Drawable paramDrawable, int paramInt)
  {
    paramDrawable.setLayoutDirection(paramInt);
  }
}
