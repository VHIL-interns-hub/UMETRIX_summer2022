package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper
{
  private static final Interpolator v = new ViewDragHelper.1();
  private int a;
  private int b;
  private int c = -1;
  private float[] d;
  private float[] e;
  private float[] f;
  private float[] g;
  private int[] h;
  private int[] i;
  private int[] j;
  private int k;
  private VelocityTracker l;
  private float m;
  private float n;
  private int o;
  private int p;
  private ScrollerCompat q;
  private final ViewDragHelper.Callback r;
  private View s;
  private boolean t;
  private final ViewGroup u;
  private final Runnable w = new ViewDragHelper.2(this);
  
  private ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, ViewDragHelper.Callback paramCallback)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (paramCallback == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.u = paramViewGroup;
    this.r = paramCallback;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.o = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.b = paramViewGroup.getScaledTouchSlop();
    this.m = paramViewGroup.getScaledMaximumFlingVelocity();
    this.n = paramViewGroup.getScaledMinimumFlingVelocity();
    this.q = ScrollerCompat.a(paramContext, v);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 < paramFloat2) {
      paramFloat2 = 0.0F;
    }
    do
    {
      return paramFloat2;
      if (f1 <= paramFloat3) {
        break;
      }
      paramFloat2 = paramFloat3;
    } while (paramFloat1 > 0.0F);
    return -paramFloat3;
    return paramFloat1;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i1 = this.u.getWidth();
    int i2 = i1 / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i1);
    float f1 = i2;
    float f2 = i2;
    f3 = b(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F)) {
      return Math.min(paramInt1, 600);
    }
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = b(paramInt3, (int)this.n, (int)this.m);
    paramInt4 = b(paramInt4, (int)this.n, (int)this.m);
    int i1 = Math.abs(paramInt1);
    int i2 = Math.abs(paramInt2);
    int i3 = Math.abs(paramInt3);
    int i4 = Math.abs(paramInt4);
    int i5 = i3 + i4;
    int i6 = i1 + i2;
    float f1;
    if (paramInt3 != 0)
    {
      f1 = i3 / i5;
      if (paramInt4 == 0) {
        break label165;
      }
    }
    label165:
    for (float f2 = i4 / i5;; f2 = i2 / i6)
    {
      paramInt1 = a(paramInt1, paramInt3, this.r.a(paramView));
      paramInt2 = a(paramInt2, paramInt4, this.r.b(paramView));
      float f3 = paramInt1;
      return (int)(f2 * paramInt2 + f1 * f3);
      f1 = i1 / i6;
      break;
    }
  }
  
  public static ViewDragHelper a(ViewGroup paramViewGroup, float paramFloat, ViewDragHelper.Callback paramCallback)
  {
    paramViewGroup = a(paramViewGroup, paramCallback);
    paramViewGroup.b = ((int)(paramViewGroup.b * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static ViewDragHelper a(ViewGroup paramViewGroup, ViewDragHelper.Callback paramCallback)
  {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramCallback);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.t = true;
    this.r.a(this.s, paramFloat1, paramFloat2);
    this.t = false;
    if (this.a == 1) {
      c(0);
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    f(paramInt);
    float[] arrayOfFloat = this.d;
    this.f[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.e;
    this.g[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.h[paramInt] = e((int)paramFloat1, (int)paramFloat2);
    this.k |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.h[paramInt1] & paramInt2) != paramInt2) || ((this.p & paramInt2) == 0) || ((this.j[paramInt1] & paramInt2) == paramInt2) || ((this.i[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.b) && (paramFloat2 <= this.b))) {}
    do
    {
      return false;
      if ((paramFloat1 < paramFloat2 * 0.5F) && (this.r.b(paramInt2)))
      {
        int[] arrayOfInt = this.j;
        arrayOfInt[paramInt1] |= paramInt2;
        return false;
      }
    } while (((this.i[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.b));
    return true;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.s.getLeft();
    int i2 = this.s.getTop();
    paramInt1 -= i1;
    paramInt2 -= i2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.q.h();
      c(0);
      return false;
    }
    paramInt3 = a(this.s, paramInt1, paramInt2, paramInt3, paramInt4);
    this.q.a(i1, i2, paramInt1, paramInt2, paramInt3);
    c(2);
    return true;
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    if (paramView == null) {
      bool = false;
    }
    label27:
    label80:
    label86:
    do
    {
      int i2;
      do
      {
        return bool;
        int i1;
        if (this.r.a(paramView) > 0)
        {
          i1 = 1;
          if (this.r.b(paramView) <= 0) {
            break label80;
          }
        }
        for (i2 = 1;; i2 = 0)
        {
          if ((i1 == 0) || (i2 == 0)) {
            break label86;
          }
          if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > this.b * this.b) {
            break;
          }
          return false;
          i1 = 0;
          break label27;
        }
        if (i1 == 0) {
          break;
        }
      } while (Math.abs(paramFloat1) > this.b);
      return false;
      if (i2 == 0) {
        break;
      }
    } while (Math.abs(paramFloat2) > this.b);
    return false;
    return false;
  }
  
  private float b(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = Math.abs(paramInt1);
    if (i1 < paramInt2) {
      paramInt2 = 0;
    }
    do
    {
      return paramInt2;
      if (i1 <= paramInt3) {
        break;
      }
      paramInt2 = paramInt3;
    } while (paramInt1 > 0);
    return -paramInt3;
    return paramInt1;
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int i2 = 1;
    if (a(paramFloat1, paramFloat2, paramInt, 1)) {}
    for (;;)
    {
      int i1 = i2;
      if (a(paramFloat2, paramFloat1, paramInt, 4)) {
        i1 = i2 | 0x4;
      }
      i2 = i1;
      if (a(paramFloat1, paramFloat2, paramInt, 2)) {
        i2 = i1 | 0x2;
      }
      i1 = i2;
      if (a(paramFloat2, paramFloat1, paramInt, 8)) {
        i1 = i2 | 0x8;
      }
      if (i1 != 0)
      {
        int[] arrayOfInt = this.i;
        arrayOfInt[paramInt] |= i1;
        this.r.b(i1, paramInt);
      }
      return;
      i2 = 0;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.s.getLeft();
    int i2 = this.s.getTop();
    if (paramInt3 != 0)
    {
      paramInt1 = this.r.a(this.s, paramInt1, paramInt3);
      ViewCompat.e(this.s, paramInt1 - i1);
    }
    for (;;)
    {
      if (paramInt4 != 0)
      {
        paramInt2 = this.r.b(this.s, paramInt2, paramInt4);
        ViewCompat.d(this.s, paramInt2 - i2);
      }
      for (;;)
      {
        if ((paramInt3 != 0) || (paramInt4 != 0)) {
          this.r.a(this.s, paramInt1, paramInt2, paramInt1 - i1, paramInt2 - i2);
        }
        return;
      }
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    int i2 = MotionEventCompat.c(paramMotionEvent);
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = MotionEventCompat.b(paramMotionEvent, i1);
      float f1 = MotionEventCompat.c(paramMotionEvent, i1);
      float f2 = MotionEventCompat.d(paramMotionEvent, i1);
      this.f[i3] = f1;
      this.g[i3] = f2;
      i1 += 1;
    }
  }
  
  private int e(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    if (paramInt1 < this.u.getLeft() + this.o) {
      i2 = 1;
    }
    int i1 = i2;
    if (paramInt2 < this.u.getTop() + this.o) {
      i1 = i2 | 0x4;
    }
    i2 = i1;
    if (paramInt1 > this.u.getRight() - this.o) {
      i2 = i1 | 0x2;
    }
    paramInt1 = i2;
    if (paramInt2 > this.u.getBottom() - this.o) {
      paramInt1 = i2 | 0x8;
    }
    return paramInt1;
  }
  
  private void e(int paramInt)
  {
    if (this.d == null) {
      return;
    }
    this.d[paramInt] = 0.0F;
    this.e[paramInt] = 0.0F;
    this.f[paramInt] = 0.0F;
    this.g[paramInt] = 0.0F;
    this.h[paramInt] = 0;
    this.i[paramInt] = 0;
    this.j[paramInt] = 0;
    this.k &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private void f()
  {
    if (this.d == null) {
      return;
    }
    Arrays.fill(this.d, 0.0F);
    Arrays.fill(this.e, 0.0F);
    Arrays.fill(this.f, 0.0F);
    Arrays.fill(this.g, 0.0F);
    Arrays.fill(this.h, 0);
    Arrays.fill(this.i, 0);
    Arrays.fill(this.j, 0);
    this.k = 0;
  }
  
  private void f(int paramInt)
  {
    if ((this.d == null) || (this.d.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.d != null)
      {
        System.arraycopy(this.d, 0, arrayOfFloat1, 0, this.d.length);
        System.arraycopy(this.e, 0, arrayOfFloat2, 0, this.e.length);
        System.arraycopy(this.f, 0, arrayOfFloat3, 0, this.f.length);
        System.arraycopy(this.g, 0, arrayOfFloat4, 0, this.g.length);
        System.arraycopy(this.h, 0, arrayOfInt1, 0, this.h.length);
        System.arraycopy(this.i, 0, arrayOfInt2, 0, this.i.length);
        System.arraycopy(this.j, 0, arrayOfInt3, 0, this.j.length);
      }
      this.d = arrayOfFloat1;
      this.e = arrayOfFloat2;
      this.f = arrayOfFloat3;
      this.g = arrayOfFloat4;
      this.h = arrayOfInt1;
      this.i = arrayOfInt2;
      this.j = arrayOfInt3;
    }
  }
  
  private void g()
  {
    this.l.computeCurrentVelocity(1000, this.m);
    a(a(VelocityTrackerCompat.a(this.l, this.c), this.n, this.m), a(VelocityTrackerCompat.b(this.l, this.c), this.n, this.m));
  }
  
  private boolean g(int paramInt)
  {
    if (!b(paramInt))
    {
      Log.e("ViewDragHelper", "Ignoring pointerId=" + paramInt + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
      return false;
    }
    return true;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    this.n = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.u) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
    }
    this.s = paramView;
    this.c = paramInt;
    this.r.b(paramView, paramInt);
    c(1);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (!this.t) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return a(paramInt1, paramInt2, (int)VelocityTrackerCompat.a(this.l, this.c), (int)VelocityTrackerCompat.b(this.l, this.c));
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i2 = MotionEventCompat.a(paramMotionEvent);
    int i1 = MotionEventCompat.b(paramMotionEvent);
    if (i2 == 0) {
      e();
    }
    if (this.l == null) {
      this.l = VelocityTracker.obtain();
    }
    this.l.addMovement(paramMotionEvent);
    switch (i2)
    {
    }
    while (this.a == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i1 = MotionEventCompat.b(paramMotionEvent, 0);
      a(f1, f2, i1);
      paramMotionEvent = d((int)f1, (int)f2);
      if ((paramMotionEvent == this.s) && (this.a == 2)) {
        b(paramMotionEvent, i1);
      }
      i2 = this.h[i1];
      if ((this.p & i2) != 0)
      {
        this.r.a(i2 & this.p, i1);
        continue;
        i2 = MotionEventCompat.b(paramMotionEvent, i1);
        f1 = MotionEventCompat.c(paramMotionEvent, i1);
        f2 = MotionEventCompat.d(paramMotionEvent, i1);
        a(f1, f2, i2);
        if (this.a == 0)
        {
          i1 = this.h[i2];
          if ((this.p & i1) != 0) {
            this.r.a(i1 & this.p, i2);
          }
        }
        else if (this.a == 2)
        {
          paramMotionEvent = d((int)f1, (int)f2);
          if (paramMotionEvent == this.s)
          {
            b(paramMotionEvent, i2);
            continue;
            if ((this.d != null) && (this.e != null))
            {
              int i3 = MotionEventCompat.c(paramMotionEvent);
              i1 = 0;
              int i4;
              label352:
              float f3;
              float f4;
              View localView;
              while (i1 < i3)
              {
                i4 = MotionEventCompat.b(paramMotionEvent, i1);
                if (!g(i4))
                {
                  i1 += 1;
                }
                else
                {
                  f1 = MotionEventCompat.c(paramMotionEvent, i1);
                  f2 = MotionEventCompat.d(paramMotionEvent, i1);
                  f3 = f1 - this.d[i4];
                  f4 = f2 - this.e[i4];
                  localView = d((int)f1, (int)f2);
                  if ((localView == null) || (!a(localView, f3, f4))) {
                    break label559;
                  }
                  i2 = 1;
                  label428:
                  if (i2 == 0) {
                    break label565;
                  }
                  int i5 = localView.getLeft();
                  int i6 = (int)f3;
                  i6 = this.r.a(localView, i6 + i5, (int)f3);
                  int i7 = localView.getTop();
                  int i8 = (int)f4;
                  i8 = this.r.b(localView, i8 + i7, (int)f4);
                  int i9 = this.r.a(localView);
                  int i10 = this.r.b(localView);
                  if (((i9 != 0) && ((i9 <= 0) || (i6 != i5))) || ((i10 != 0) && ((i10 <= 0) || (i8 != i7)))) {
                    break label565;
                  }
                }
              }
              for (;;)
              {
                c(paramMotionEvent);
                break;
                label559:
                i2 = 0;
                break label428;
                label565:
                b(f3, f4, i4);
                if (this.a != 1) {
                  if ((i2 == 0) || (!b(localView, i4))) {
                    break label352;
                  }
                }
              }
              e(MotionEventCompat.b(paramMotionEvent, i1));
              continue;
              e();
            }
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2)
  {
    this.s = paramView;
    this.c = -1;
    boolean bool = a(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.a == 0) && (this.s != null)) {
      this.s = null;
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool;
    if (this.a == 2)
    {
      bool = this.q.g();
      int i1 = this.q.b();
      int i2 = this.q.c();
      int i3 = i1 - this.s.getLeft();
      int i4 = i2 - this.s.getTop();
      if (i3 != 0) {
        ViewCompat.e(this.s, i3);
      }
      if (i4 != 0) {
        ViewCompat.d(this.s, i4);
      }
      if ((i3 != 0) || (i4 != 0)) {
        this.r.a(this.s, i1, i2, i3, i4);
      }
      if ((!bool) || (i1 != this.q.d()) || (i2 != this.q.e())) {
        break label188;
      }
      this.q.h();
      bool = false;
    }
    label178:
    label188:
    for (;;)
    {
      if (!bool)
      {
        if (!paramBoolean) {
          break label178;
        }
        this.u.post(this.w);
      }
      while (this.a == 2)
      {
        return true;
        c(0);
      }
      return false;
    }
  }
  
  public int b()
  {
    return this.o;
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    int i1 = 0;
    int i2 = 0;
    int i4 = MotionEventCompat.a(paramMotionEvent);
    int i3 = MotionEventCompat.b(paramMotionEvent);
    if (i4 == 0) {
      e();
    }
    if (this.l == null) {
      this.l = VelocityTracker.obtain();
    }
    this.l.addMovement(paramMotionEvent);
    float f1;
    float f2;
    switch (i4)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              f1 = paramMotionEvent.getX();
              f2 = paramMotionEvent.getY();
              i1 = MotionEventCompat.b(paramMotionEvent, 0);
              paramMotionEvent = d((int)f1, (int)f2);
              a(f1, f2, i1);
              b(paramMotionEvent, i1);
              i2 = this.h[i1];
            } while ((this.p & i2) == 0);
            this.r.a(i2 & this.p, i1);
            return;
            i1 = MotionEventCompat.b(paramMotionEvent, i3);
            f1 = MotionEventCompat.c(paramMotionEvent, i3);
            f2 = MotionEventCompat.d(paramMotionEvent, i3);
            a(f1, f2, i1);
            if (this.a != 0) {
              break;
            }
            b(d((int)f1, (int)f2), i1);
            i2 = this.h[i1];
          } while ((this.p & i2) == 0);
          this.r.a(i2 & this.p, i1);
          return;
        } while (!c((int)f1, (int)f2));
        b(this.s, i1);
        return;
        if (this.a != 1) {
          break;
        }
      } while (!g(this.c));
      i1 = MotionEventCompat.a(paramMotionEvent, this.c);
      f1 = MotionEventCompat.c(paramMotionEvent, i1);
      f2 = MotionEventCompat.d(paramMotionEvent, i1);
      i1 = (int)(f1 - this.f[this.c]);
      i2 = (int)(f2 - this.g[this.c]);
      b(this.s.getLeft() + i1, this.s.getTop() + i2, i1, i2);
      c(paramMotionEvent);
      return;
      i3 = MotionEventCompat.c(paramMotionEvent);
      i1 = i2;
      float f3;
      float f4;
      while (i1 < i3)
      {
        i2 = MotionEventCompat.b(paramMotionEvent, i1);
        if (!g(i2))
        {
          i1 += 1;
        }
        else
        {
          f1 = MotionEventCompat.c(paramMotionEvent, i1);
          f2 = MotionEventCompat.d(paramMotionEvent, i1);
          f3 = f1 - this.d[i2];
          f4 = f2 - this.e[i2];
          b(f3, f4, i2);
          if (this.a != 1) {
            break label490;
          }
        }
      }
      for (;;)
      {
        c(paramMotionEvent);
        return;
        View localView = d((int)f1, (int)f2);
        if ((!a(localView, f3, f4)) || (!b(localView, i2))) {
          break;
        }
      }
    case 6: 
      label490:
      i2 = MotionEventCompat.b(paramMotionEvent, i3);
      if ((this.a == 1) && (i2 == this.c))
      {
        i3 = MotionEventCompat.c(paramMotionEvent);
        if (i1 >= i3) {
          break label692;
        }
        i4 = MotionEventCompat.b(paramMotionEvent, i1);
        if (i4 == this.c) {}
        do
        {
          i1 += 1;
          break;
          f1 = MotionEventCompat.c(paramMotionEvent, i1);
          f2 = MotionEventCompat.d(paramMotionEvent, i1);
        } while ((d((int)f1, (int)f2) != this.s) || (!b(this.s, i4)));
      }
      break;
    }
    label692:
    for (i1 = this.c;; i1 = -1)
    {
      if (i1 == -1) {
        g();
      }
      e(i2);
      return;
      if (this.a == 1) {
        g();
      }
      e();
      return;
      if (this.a == 1) {
        a(0.0F, 0.0F);
      }
      e();
      return;
    }
  }
  
  public boolean b(int paramInt)
  {
    return (this.k & 1 << paramInt) != 0;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (!b(paramInt2)) {
      bool = false;
    }
    label27:
    float f2;
    label105:
    label110:
    do
    {
      float f1;
      do
      {
        return bool;
        int i1;
        if ((paramInt1 & 0x1) == 1)
        {
          i1 = 1;
          if ((paramInt1 & 0x2) != 2) {
            break label105;
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          f1 = this.f[paramInt2] - this.d[paramInt2];
          f2 = this.g[paramInt2] - this.e[paramInt2];
          if ((i1 == 0) || (paramInt1 == 0)) {
            break label110;
          }
          if (f1 * f1 + f2 * f2 > this.b * this.b) {
            break;
          }
          return false;
          i1 = 0;
          break label27;
        }
        if (i1 == 0) {
          break;
        }
      } while (Math.abs(f1) > this.b);
      return false;
      if (paramInt1 == 0) {
        break;
      }
    } while (Math.abs(f2) > this.b);
    return false;
    return false;
  }
  
  boolean b(View paramView, int paramInt)
  {
    if ((paramView == this.s) && (this.c == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.r.a(paramView, paramInt)))
    {
      this.c = paramInt;
      a(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean b(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  public View c()
  {
    return this.s;
  }
  
  void c(int paramInt)
  {
    this.u.removeCallbacks(this.w);
    if (this.a != paramInt)
    {
      this.a = paramInt;
      this.r.a(paramInt);
      if (this.a == 0) {
        this.s = null;
      }
    }
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    return b(this.s, paramInt1, paramInt2);
  }
  
  public int d()
  {
    return this.b;
  }
  
  public View d(int paramInt1, int paramInt2)
  {
    int i1 = this.u.getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = this.u.getChildAt(this.r.c(i1));
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i1 -= 1;
    }
    return null;
  }
  
  public boolean d(int paramInt)
  {
    boolean bool2 = false;
    int i2 = this.d.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (b(paramInt, i1)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public void e()
  {
    this.c = -1;
    f();
    if (this.l != null)
    {
      this.l.recycle();
      this.l = null;
    }
  }
}
