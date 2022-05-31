package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

class AppCompatSeekBarHelper
  extends AppCompatProgressBarHelper
{
  private static final int[] b = { 16843074 };
  private final SeekBar c;
  
  AppCompatSeekBarHelper(SeekBar paramSeekBar, AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    super(paramSeekBar, paramAppCompatDrawableManager);
    this.c = paramSeekBar;
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = TintTypedArray.a(this.c.getContext(), paramAttributeSet, b, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.b(0);
    if (localDrawable != null) {
      this.c.setThumb(localDrawable);
    }
    paramAttributeSet.a();
  }
}
