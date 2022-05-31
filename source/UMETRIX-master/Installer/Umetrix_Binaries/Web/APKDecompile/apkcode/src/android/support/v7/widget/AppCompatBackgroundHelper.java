package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;

class AppCompatBackgroundHelper
{
  private final View a;
  private final AppCompatDrawableManager b;
  private TintInfo c;
  private TintInfo d;
  private TintInfo e;
  
  AppCompatBackgroundHelper(View paramView, AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    this.a = paramView;
    this.b = paramAppCompatDrawableManager;
  }
  
  private boolean b(Drawable paramDrawable)
  {
    return (Build.VERSION.SDK_INT == 21) && ((paramDrawable instanceof GradientDrawable));
  }
  
  private void c(Drawable paramDrawable)
  {
    if (this.e == null) {
      this.e = new TintInfo();
    }
    TintInfo localTintInfo = this.e;
    localTintInfo.a();
    Object localObject = ViewCompat.r(this.a);
    if (localObject != null)
    {
      localTintInfo.d = true;
      localTintInfo.a = ((ColorStateList)localObject);
    }
    localObject = ViewCompat.s(this.a);
    if (localObject != null)
    {
      localTintInfo.c = true;
      localTintInfo.b = ((PorterDuff.Mode)localObject);
    }
    if ((localTintInfo.d) || (localTintInfo.c)) {
      AppCompatDrawableManager.a(paramDrawable, localTintInfo, this.a.getDrawableState());
    }
  }
  
  ColorStateList a()
  {
    if (this.d != null) {
      return this.d.a;
    }
    return null;
  }
  
  void a(int paramInt)
  {
    if (this.b != null) {}
    for (ColorStateList localColorStateList = this.b.b(this.a.getContext(), paramInt);; localColorStateList = null)
    {
      b(localColorStateList);
      return;
    }
  }
  
  void a(ColorStateList paramColorStateList)
  {
    if (this.d == null) {
      this.d = new TintInfo();
    }
    this.d.a = paramColorStateList;
    this.d.d = true;
    c();
  }
  
  void a(PorterDuff.Mode paramMode)
  {
    if (this.d == null) {
      this.d = new TintInfo();
    }
    this.d.b = paramMode;
    this.d.c = true;
    c();
  }
  
  void a(Drawable paramDrawable)
  {
    b(null);
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.a.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(R.styleable.ViewBackgroundHelper_android_background))
      {
        ColorStateList localColorStateList = this.b.b(this.a.getContext(), paramAttributeSet.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1));
        if (localColorStateList != null) {
          b(localColorStateList);
        }
      }
      if (paramAttributeSet.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint)) {
        ViewCompat.a(this.a, paramAttributeSet.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
        ViewCompat.a(this.a, DrawableUtils.a(paramAttributeSet.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  PorterDuff.Mode b()
  {
    if (this.d != null) {
      return this.d.b;
    }
    return null;
  }
  
  void b(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.c == null) {
        this.c = new TintInfo();
      }
      this.c.a = paramColorStateList;
      this.c.d = true;
    }
    for (;;)
    {
      c();
      return;
      this.c = null;
    }
  }
  
  void c()
  {
    Drawable localDrawable = this.a.getBackground();
    if (localDrawable != null)
    {
      if (this.d == null) {
        break label35;
      }
      AppCompatDrawableManager.a(localDrawable, this.d, this.a.getDrawableState());
    }
    label35:
    do
    {
      return;
      if (this.c != null)
      {
        AppCompatDrawableManager.a(localDrawable, this.c, this.a.getDrawableState());
        return;
      }
    } while (!b(localDrawable));
    c(localDrawable);
  }
}
