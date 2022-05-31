package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageHelper
{
  private final ImageView a;
  private final AppCompatDrawableManager b;
  
  public AppCompatImageHelper(ImageView paramImageView, AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    this.a = paramImageView;
    this.b = paramAppCompatDrawableManager;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.b != null) {}
      for (Drawable localDrawable = this.b.a(this.a.getContext(), paramInt);; localDrawable = ContextCompat.a(this.a.getContext(), paramInt))
      {
        if (localDrawable != null) {
          DrawableUtils.a(localDrawable);
        }
        this.a.setImageDrawable(localDrawable);
        return;
      }
    }
    this.a.setImageDrawable(null);
  }
  
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = TintTypedArray.a(this.a.getContext(), paramAttributeSet, R.styleable.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = paramAttributeSet.b(R.styleable.AppCompatImageView_android_src);
      if (localDrawable != null) {
        this.a.setImageDrawable(localDrawable);
      }
      paramInt = paramAttributeSet.g(R.styleable.AppCompatImageView_srcCompat, -1);
      if (paramInt != -1)
      {
        localDrawable = this.b.a(this.a.getContext(), paramInt);
        if (localDrawable != null) {
          this.a.setImageDrawable(localDrawable);
        }
      }
      localDrawable = this.a.getDrawable();
      if (localDrawable != null) {
        DrawableUtils.a(localDrawable);
      }
      return;
    }
    finally
    {
      paramAttributeSet.a();
    }
  }
}
