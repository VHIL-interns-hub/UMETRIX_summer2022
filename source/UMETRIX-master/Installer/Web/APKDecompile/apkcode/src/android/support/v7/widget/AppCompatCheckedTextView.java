package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView
  extends CheckedTextView
{
  private static final int[] a = { 16843016 };
  private AppCompatDrawableManager b;
  private AppCompatTextHelper c = AppCompatTextHelper.a(this);
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843720);
  }
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(TintContextWrapper.a(paramContext), paramAttributeSet, paramInt);
    this.c.a(paramAttributeSet, paramInt);
    this.c.a();
    this.b = AppCompatDrawableManager.a();
    paramContext = TintTypedArray.a(getContext(), paramAttributeSet, a, paramInt, 0);
    setCheckMarkDrawable(paramContext.a(0));
    paramContext.a();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.c != null) {
      this.c.a();
    }
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    if (this.b != null)
    {
      setCheckMarkDrawable(this.b.a(getContext(), paramInt));
      return;
    }
    super.setCheckMarkDrawable(paramInt);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.c != null) {
      this.c.a(paramContext, paramInt);
    }
  }
}
