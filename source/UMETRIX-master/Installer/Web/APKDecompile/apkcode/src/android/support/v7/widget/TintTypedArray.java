package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class TintTypedArray
{
  private final Context a;
  private final TypedArray b;
  
  private TintTypedArray(Context paramContext, TypedArray paramTypedArray)
  {
    this.a = paramContext;
    this.b = paramTypedArray;
  }
  
  public static TintTypedArray a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    return new TintTypedArray(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt));
  }
  
  public static TintTypedArray a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return new TintTypedArray(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, paramInt1, paramInt2));
  }
  
  public float a(int paramInt, float paramFloat)
  {
    return this.b.getFloat(paramInt, paramFloat);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return this.b.getInt(paramInt1, paramInt2);
  }
  
  public Drawable a(int paramInt)
  {
    if (this.b.hasValue(paramInt))
    {
      int i = this.b.getResourceId(paramInt, 0);
      if (i != 0) {
        return AppCompatDrawableManager.a().a(this.a, i);
      }
    }
    return this.b.getDrawable(paramInt);
  }
  
  public void a()
  {
    this.b.recycle();
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    return this.b.getBoolean(paramInt, paramBoolean);
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    return this.b.getColor(paramInt1, paramInt2);
  }
  
  public Drawable b(int paramInt)
  {
    if (this.b.hasValue(paramInt))
    {
      paramInt = this.b.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return AppCompatDrawableManager.a().a(this.a, paramInt, true);
      }
    }
    return null;
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    return this.b.getInteger(paramInt1, paramInt2);
  }
  
  public CharSequence c(int paramInt)
  {
    return this.b.getText(paramInt);
  }
  
  public int d(int paramInt1, int paramInt2)
  {
    return this.b.getDimensionPixelOffset(paramInt1, paramInt2);
  }
  
  public String d(int paramInt)
  {
    return this.b.getString(paramInt);
  }
  
  public int e(int paramInt1, int paramInt2)
  {
    return this.b.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public CharSequence[] e(int paramInt)
  {
    return this.b.getTextArray(paramInt);
  }
  
  public int f(int paramInt1, int paramInt2)
  {
    return this.b.getLayoutDimension(paramInt1, paramInt2);
  }
  
  public boolean f(int paramInt)
  {
    return this.b.hasValue(paramInt);
  }
  
  public int g(int paramInt1, int paramInt2)
  {
    return this.b.getResourceId(paramInt1, paramInt2);
  }
}
