package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class AppCompatCompoundButtonHelper
{
  private final CompoundButton a;
  private final AppCompatDrawableManager b;
  private ColorStateList c = null;
  private PorterDuff.Mode d = null;
  private boolean e = false;
  private boolean f = false;
  private boolean g;
  
  AppCompatCompoundButtonHelper(CompoundButton paramCompoundButton, AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    this.a = paramCompoundButton;
    this.b = paramAppCompatDrawableManager;
  }
  
  int a(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = CompoundButtonCompat.a(this.a);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  ColorStateList a()
  {
    return this.c;
  }
  
  void a(ColorStateList paramColorStateList)
  {
    this.c = paramColorStateList;
    this.e = true;
    d();
  }
  
  void a(PorterDuff.Mode paramMode)
  {
    this.d = paramMode;
    this.f = true;
    d();
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.a.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_android_button))
      {
        paramInt = paramAttributeSet.getResourceId(R.styleable.CompoundButton_android_button, 0);
        if (paramInt != 0) {
          this.a.setButtonDrawable(this.b.a(this.a.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTint)) {
        CompoundButtonCompat.a(this.a, paramAttributeSet.getColorStateList(R.styleable.CompoundButton_buttonTint));
      }
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
        CompoundButtonCompat.a(this.a, DrawableUtils.a(paramAttributeSet.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
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
    return this.d;
  }
  
  void c()
  {
    if (this.g)
    {
      this.g = false;
      return;
    }
    this.g = true;
    d();
  }
  
  void d()
  {
    Drawable localDrawable = CompoundButtonCompat.a(this.a);
    if ((localDrawable != null) && ((this.e) || (this.f)))
    {
      localDrawable = DrawableCompat.f(localDrawable).mutate();
      if (this.e) {
        DrawableCompat.a(localDrawable, this.c);
      }
      if (this.f) {
        DrawableCompat.a(localDrawable, this.d);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.a.getDrawableState());
      }
      this.a.setButtonDrawable(localDrawable);
    }
  }
}
