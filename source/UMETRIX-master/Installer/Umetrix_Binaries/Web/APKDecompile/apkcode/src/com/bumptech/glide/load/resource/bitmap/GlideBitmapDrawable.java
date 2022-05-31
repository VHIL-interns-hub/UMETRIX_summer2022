package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import android.view.Gravity;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

public class GlideBitmapDrawable
  extends GlideDrawable
{
  private final Rect a = new Rect();
  private int b;
  private int c;
  private boolean d;
  private boolean e;
  private GlideBitmapDrawable.BitmapState f;
  
  public GlideBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    this(paramResources, new GlideBitmapDrawable.BitmapState(paramBitmap));
  }
  
  GlideBitmapDrawable(Resources paramResources, GlideBitmapDrawable.BitmapState paramBitmapState)
  {
    if (paramBitmapState == null) {
      throw new NullPointerException("BitmapState must not be null");
    }
    this.f = paramBitmapState;
    int i;
    if (paramResources != null)
    {
      int j = paramResources.getDisplayMetrics().densityDpi;
      i = j;
      if (j == 0) {
        i = 160;
      }
      paramBitmapState.b = i;
    }
    for (;;)
    {
      this.b = paramBitmapState.a.getScaledWidth(i);
      this.c = paramBitmapState.a.getScaledHeight(i);
      return;
      i = paramBitmapState.b;
    }
  }
  
  public void a(int paramInt) {}
  
  public boolean a()
  {
    return false;
  }
  
  public Bitmap b()
  {
    return this.f.a;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.d)
    {
      Gravity.apply(119, this.b, this.c, getBounds(), this.a);
      this.d = false;
    }
    paramCanvas.drawBitmap(this.f.a, null, this.a, this.f.c);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.f;
  }
  
  public int getIntrinsicHeight()
  {
    return this.c;
  }
  
  public int getIntrinsicWidth()
  {
    return this.b;
  }
  
  public int getOpacity()
  {
    Bitmap localBitmap = this.f.a;
    if ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.f.c.getAlpha() < 255)) {
      return -3;
    }
    return -1;
  }
  
  public boolean isRunning()
  {
    return false;
  }
  
  public Drawable mutate()
  {
    if ((!this.e) && (super.mutate() == this))
    {
      this.f = new GlideBitmapDrawable.BitmapState(this.f);
      this.e = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.d = true;
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.f.c.getAlpha() != paramInt)
    {
      this.f.a(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.f.a(paramColorFilter);
    invalidateSelf();
  }
  
  public void start() {}
  
  public void stop() {}
}
