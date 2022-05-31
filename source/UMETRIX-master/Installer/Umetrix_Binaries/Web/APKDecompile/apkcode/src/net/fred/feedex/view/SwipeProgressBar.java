package net.fred.feedex.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

final class SwipeProgressBar
{
  private static final Interpolator a = ;
  private final Paint b = new Paint();
  private final RectF c = new RectF();
  private float d;
  private long e;
  private long f;
  private boolean g;
  private int h;
  private int i;
  private int j;
  private int k;
  private View l;
  private Rect m = new Rect();
  
  public SwipeProgressBar(View paramView)
  {
    this.l = paramView;
    this.h = -1291845632;
    this.i = Integer.MIN_VALUE;
    this.j = 1291845632;
    this.k = 436207616;
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3)
  {
    this.b.setColor(paramInt);
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramFloat2 = a.getInterpolation(paramFloat3);
    paramCanvas.scale(paramFloat2, paramFloat2);
    paramCanvas.drawCircle(0.0F, 0.0F, paramFloat1, this.b);
    paramCanvas.restore();
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.b.setColor(this.h);
    paramCanvas.drawCircle(paramInt1, paramInt2, paramInt1 * this.d, this.b);
  }
  
  void a()
  {
    if (!this.g)
    {
      this.d = 0.0F;
      this.e = AnimationUtils.currentAnimationTimeMillis();
      this.g = true;
      this.l.postInvalidate();
    }
  }
  
  void a(float paramFloat)
  {
    this.d = paramFloat;
    this.e = 0L;
    ViewCompat.b(this.l);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
  }
  
  void a(Canvas paramCanvas)
  {
    int i1 = this.m.width();
    int i4 = this.m.height();
    int i2 = i1 / 2;
    int i3 = i4 / 2;
    int n = paramCanvas.save();
    paramCanvas.clipRect(this.m);
    long l3;
    float f1;
    float f2;
    if ((this.g) || (this.f > 0L))
    {
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.e;
      l3 = (l1 - this.e) / 2000L;
      f1 = (float)((l1 - l2) % 2000L) / 20.0F;
      if (this.g) {
        break label603;
      }
      if (l1 - this.f >= 1000L)
      {
        this.f = 0L;
        return;
      }
      f2 = (float)((l1 - this.f) % 1000L) / 10.0F / 100.0F;
      float f3 = i1 / 2;
      f2 = a.getInterpolation(f2) * f3;
      this.c.set(i2 - f2, 0.0F, f2 + i2, i4);
      paramCanvas.saveLayerAlpha(this.c, 0, 0);
    }
    label600:
    label603:
    for (i1 = 1;; i1 = 0)
    {
      if (l3 == 0L)
      {
        paramCanvas.drawColor(this.h);
        if ((f1 >= 0.0F) && (f1 <= 25.0F))
        {
          f2 = (25.0F + f1) * 2.0F / 100.0F;
          a(paramCanvas, i2, i3, this.h, f2);
        }
        if ((f1 >= 0.0F) && (f1 <= 50.0F))
        {
          f2 = 2.0F * f1 / 100.0F;
          a(paramCanvas, i2, i3, this.i, f2);
        }
        if ((f1 >= 25.0F) && (f1 <= 75.0F))
        {
          f2 = (f1 - 25.0F) * 2.0F / 100.0F;
          a(paramCanvas, i2, i3, this.j, f2);
        }
        if ((f1 >= 50.0F) && (f1 <= 100.0F))
        {
          f2 = (f1 - 50.0F) * 2.0F / 100.0F;
          a(paramCanvas, i2, i3, this.k, f2);
        }
        if ((f1 >= 75.0F) && (f1 <= 100.0F))
        {
          f1 = (f1 - 75.0F) * 2.0F / 100.0F;
          a(paramCanvas, i2, i3, this.h, f1);
        }
        if ((this.d <= 0.0F) || (i1 == 0)) {
          break label600;
        }
        paramCanvas.restoreToCount(n);
        n = paramCanvas.save();
        paramCanvas.clipRect(this.m);
        a(paramCanvas, i2, i3);
      }
      for (;;)
      {
        ViewCompat.b(this.l);
        i1 = n;
        for (;;)
        {
          paramCanvas.restoreToCount(i1);
          return;
          if ((f1 >= 0.0F) && (f1 < 25.0F))
          {
            paramCanvas.drawColor(this.k);
            break;
          }
          if ((f1 >= 25.0F) && (f1 < 50.0F))
          {
            paramCanvas.drawColor(this.h);
            break;
          }
          if ((f1 >= 50.0F) && (f1 < 75.0F))
          {
            paramCanvas.drawColor(this.i);
            break;
          }
          paramCanvas.drawColor(this.j);
          break;
          i1 = n;
          if (this.d > 0.0F)
          {
            i1 = n;
            if (this.d <= 1.0D)
            {
              a(paramCanvas, i2, i3);
              i1 = n;
            }
          }
        }
      }
    }
  }
  
  void b()
  {
    if (this.g)
    {
      this.d = 0.0F;
      this.f = AnimationUtils.currentAnimationTimeMillis();
      this.g = false;
      this.l.postInvalidate();
    }
  }
  
  void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.m.left = paramInt1;
    this.m.top = paramInt2;
    this.m.right = paramInt3;
    this.m.bottom = paramInt4;
  }
}
