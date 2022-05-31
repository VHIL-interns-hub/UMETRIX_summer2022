package com.bumptech.glide.request.target;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

public class SquaringDrawable
  extends GlideDrawable
{
  private GlideDrawable a;
  private SquaringDrawable.State b;
  private boolean c;
  
  public SquaringDrawable(GlideDrawable paramGlideDrawable, int paramInt)
  {
    this(new SquaringDrawable.State(paramGlideDrawable.getConstantState(), paramInt), paramGlideDrawable, null);
  }
  
  SquaringDrawable(SquaringDrawable.State paramState, GlideDrawable paramGlideDrawable, Resources paramResources)
  {
    this.b = paramState;
    if (paramGlideDrawable == null)
    {
      if (paramResources != null)
      {
        this.a = ((GlideDrawable)SquaringDrawable.State.a(paramState).newDrawable(paramResources));
        return;
      }
      this.a = ((GlideDrawable)SquaringDrawable.State.a(paramState).newDrawable());
      return;
    }
    this.a = paramGlideDrawable;
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public boolean a()
  {
    return this.a.a();
  }
  
  public void clearColorFilter()
  {
    this.a.clearColorFilter();
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.a.draw(paramCanvas);
  }
  
  @TargetApi(19)
  public int getAlpha()
  {
    return this.a.getAlpha();
  }
  
  @TargetApi(11)
  public Drawable.Callback getCallback()
  {
    return this.a.getCallback();
  }
  
  public int getChangingConfigurations()
  {
    return this.a.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.b;
  }
  
  public Drawable getCurrent()
  {
    return this.a.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return SquaringDrawable.State.b(this.b);
  }
  
  public int getIntrinsicWidth()
  {
    return SquaringDrawable.State.b(this.b);
  }
  
  public int getMinimumHeight()
  {
    return this.a.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.a.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.a.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.a.getPadding(paramRect);
  }
  
  public void invalidateSelf()
  {
    super.invalidateSelf();
    this.a.invalidateSelf();
  }
  
  public boolean isRunning()
  {
    return this.a.isRunning();
  }
  
  public Drawable mutate()
  {
    if ((!this.c) && (super.mutate() == this))
    {
      this.a = ((GlideDrawable)this.a.mutate());
      this.b = new SquaringDrawable.State(this.b);
      this.c = true;
    }
    return this;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    super.scheduleSelf(paramRunnable, paramLong);
    this.a.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setBounds(Rect paramRect)
  {
    super.setBounds(paramRect);
    this.a.setBounds(paramRect);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    this.a.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    this.a.setColorFilter(paramInt, paramMode);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.a.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.a.setFilterBitmap(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.a.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start()
  {
    this.a.start();
  }
  
  public void stop()
  {
    this.a.stop();
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    super.unscheduleSelf(paramRunnable);
    this.a.unscheduleSelf(paramRunnable);
  }
}
