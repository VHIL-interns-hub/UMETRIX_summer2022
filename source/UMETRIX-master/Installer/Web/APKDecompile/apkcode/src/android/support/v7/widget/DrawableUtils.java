package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;

class DrawableUtils
{
  public static final Rect a = new Rect();
  private static Class b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      b = Class.forName("android.graphics.Insets");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
  }
  
  static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    }
    do
    {
      return paramMode;
      return PorterDuff.Mode.SRC_OVER;
      return PorterDuff.Mode.SRC_IN;
      return PorterDuff.Mode.SRC_ATOP;
      return PorterDuff.Mode.MULTIPLY;
      return PorterDuff.Mode.SCREEN;
    } while (Build.VERSION.SDK_INT < 11);
    return PorterDuff.Mode.valueOf("ADD");
  }
  
  static void a(Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()))) {
      c(paramDrawable);
    }
  }
  
  static boolean b(Drawable paramDrawable)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramDrawable instanceof LayerDrawable)) {
      if (Build.VERSION.SDK_INT >= 16) {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return bool1;
                bool1 = false;
              }
              if (!(paramDrawable instanceof InsetDrawable)) {
                break;
              }
              bool1 = bool2;
            } while (Build.VERSION.SDK_INT >= 14);
            return false;
            if (!(paramDrawable instanceof StateListDrawable)) {
              break;
            }
            bool1 = bool2;
          } while (Build.VERSION.SDK_INT >= 8);
          return false;
          if (!(paramDrawable instanceof GradientDrawable)) {
            break;
          }
          bool1 = bool2;
        } while (Build.VERSION.SDK_INT >= 14);
        return false;
        if (!(paramDrawable instanceof DrawableContainer)) {
          break;
        }
        paramDrawable = paramDrawable.getConstantState();
        bool1 = bool2;
      } while (!(paramDrawable instanceof DrawableContainer.DrawableContainerState));
      paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
      int j = paramDrawable.length;
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= j) {
          break;
        }
        if (!b(paramDrawable[i])) {
          return false;
        }
        i += 1;
      }
      if ((paramDrawable instanceof android.support.v4.graphics.drawable.DrawableWrapper)) {
        return b(((android.support.v4.graphics.drawable.DrawableWrapper)paramDrawable).a());
      }
      bool1 = bool2;
    } while (!(paramDrawable instanceof android.support.v7.graphics.drawable.DrawableWrapper));
    return b(((android.support.v7.graphics.drawable.DrawableWrapper)paramDrawable).a());
  }
  
  private static void c(Drawable paramDrawable)
  {
    int[] arrayOfInt = paramDrawable.getState();
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {
      paramDrawable.setState(ThemeUtils.e);
    }
    for (;;)
    {
      paramDrawable.setState(arrayOfInt);
      return;
      paramDrawable.setState(ThemeUtils.h);
    }
  }
}
