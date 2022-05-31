package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
  extends ViewGroup
{
  private static final int[] a = { 16842931 };
  private static final ViewPager.ViewPositionComparator ai = new ViewPager.ViewPositionComparator();
  private static final Comparator c = new ViewPager.1();
  private static final Interpolator d = new ViewPager.2();
  private int A = 1;
  private boolean B;
  private boolean C;
  private int D;
  private int E;
  private int F;
  private float G;
  private float H;
  private float I;
  private float J;
  private int K = -1;
  private VelocityTracker L;
  private int M;
  private int N;
  private int O;
  private int P;
  private boolean Q;
  private EdgeEffectCompat R;
  private EdgeEffectCompat S;
  private boolean T = true;
  private boolean U = false;
  private boolean V;
  private int W;
  private List aa;
  private ViewPager.OnPageChangeListener ab;
  private ViewPager.OnPageChangeListener ac;
  private ViewPager.OnAdapterChangeListener ad;
  private ViewPager.PageTransformer ae;
  private Method af;
  private int ag;
  private ArrayList ah;
  private final Runnable aj = new ViewPager.3(this);
  private int ak = 0;
  private int b;
  private final ArrayList e = new ArrayList();
  private final ViewPager.ItemInfo f = new ViewPager.ItemInfo();
  private final Rect g = new Rect();
  private PagerAdapter h;
  private int i;
  private int j = -1;
  private Parcelable k = null;
  private ClassLoader l = null;
  private Scroller m;
  private boolean n;
  private ViewPager.PagerObserver o;
  private int p;
  private Drawable q;
  private int r;
  private int s;
  private float t = -3.4028235E38F;
  private float u = Float.MAX_VALUE;
  private int v;
  private int w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public ViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.O) && (Math.abs(paramInt2) > this.M))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.e.size() > 0)
        {
          ViewPager.ItemInfo localItemInfo1 = (ViewPager.ItemInfo)this.e.get(0);
          ViewPager.ItemInfo localItemInfo2 = (ViewPager.ItemInfo)this.e.get(this.e.size() - 1);
          paramInt2 = Math.max(localItemInfo1.b, Math.min(paramInt1, localItemInfo2.b));
        }
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.i) {}
    for (float f1 = 0.4F;; f1 = 0.6F)
    {
      paramInt1 = (int)(f1 + (paramInt1 + paramFloat));
      break;
    }
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      return paramRect;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.e.isEmpty()))
    {
      if (!this.m.isFinished())
      {
        this.m.setFinalX(getCurrentItem() * getClientWidth());
        return;
      }
      int i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      f1 = getScrollX() / (paramInt2 - i3 - i4 + paramInt4);
      scrollTo((int)((paramInt1 - i1 - i2 + paramInt3) * f1), getScrollY());
      return;
    }
    ViewPager.ItemInfo localItemInfo = b(this.i);
    if (localItemInfo != null) {}
    for (float f1 = Math.min(localItemInfo.e, this.u);; f1 = 0.0F)
    {
      paramInt1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      a(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    ViewPager.ItemInfo localItemInfo = b(paramInt1);
    float f1;
    if (localItemInfo != null) {
      f1 = getClientWidth();
    }
    for (int i1 = (int)(Math.max(this.t, Math.min(localItemInfo.e, this.u)) * f1);; i1 = 0)
    {
      if (paramBoolean1)
      {
        a(i1, 0, paramInt2);
        if (paramBoolean2) {
          e(paramInt1);
        }
        return;
      }
      if (paramBoolean2) {
        e(paramInt1);
      }
      a(false);
      scrollTo(i1, 0);
      d(i1);
      return;
    }
  }
  
  private void a(ViewPager.ItemInfo paramItemInfo1, int paramInt, ViewPager.ItemInfo paramItemInfo2)
  {
    int i4 = this.h.a();
    int i1 = getClientWidth();
    float f2;
    if (i1 > 0)
    {
      f2 = this.p / i1;
      if (paramItemInfo2 == null) {
        break label409;
      }
      i1 = paramItemInfo2.b;
      if (i1 < paramItemInfo1.b)
      {
        f1 = paramItemInfo2.e + paramItemInfo2.d + f2;
        i1 += 1;
        i2 = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i1 > paramItemInfo1.b) || (i2 >= this.e.size())) {
          break label409;
        }
        for (paramItemInfo2 = (ViewPager.ItemInfo)this.e.get(i2);; paramItemInfo2 = (ViewPager.ItemInfo)this.e.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 <= paramItemInfo2.b) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 >= this.e.size() - 1) {
            break;
          }
          i2 += 1;
        }
        f2 = 0.0F;
        break;
        while (i3 < paramItemInfo2.b)
        {
          f3 += this.h.a(i3) + f2;
          i3 += 1;
        }
        paramItemInfo2.e = f3;
        f1 = f3 + (paramItemInfo2.d + f2);
        i1 = i3 + 1;
      }
    }
    if (i1 > paramItemInfo1.b)
    {
      i2 = this.e.size() - 1;
      f1 = paramItemInfo2.e;
      i1 -= 1;
      while ((i1 >= paramItemInfo1.b) && (i2 >= 0))
      {
        for (paramItemInfo2 = (ViewPager.ItemInfo)this.e.get(i2);; paramItemInfo2 = (ViewPager.ItemInfo)this.e.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 >= paramItemInfo2.b) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 <= 0) {
            break;
          }
          i2 -= 1;
        }
        while (i3 > paramItemInfo2.b)
        {
          f3 -= this.h.a(i3) + f2;
          i3 -= 1;
        }
        f1 = f3 - (paramItemInfo2.d + f2);
        paramItemInfo2.e = f1;
        i1 = i3 - 1;
      }
    }
    label409:
    int i3 = this.e.size();
    float f3 = paramItemInfo1.e;
    i1 = paramItemInfo1.b - 1;
    if (paramItemInfo1.b == 0)
    {
      f1 = paramItemInfo1.e;
      this.t = f1;
      if (paramItemInfo1.b != i4 - 1) {
        break label550;
      }
      f1 = paramItemInfo1.e + paramItemInfo1.d - 1.0F;
      label475:
      this.u = f1;
      i2 = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (i2 < 0) {
        break label603;
      }
      paramItemInfo2 = (ViewPager.ItemInfo)this.e.get(i2);
      for (;;)
      {
        if (i1 > paramItemInfo2.b)
        {
          f1 -= this.h.a(i1) + f2;
          i1 -= 1;
          continue;
          f1 = -3.4028235E38F;
          break;
          label550:
          f1 = Float.MAX_VALUE;
          break label475;
        }
      }
      f1 -= paramItemInfo2.d + f2;
      paramItemInfo2.e = f1;
      if (paramItemInfo2.b == 0) {
        this.t = f1;
      }
      i1 -= 1;
      i2 -= 1;
    }
    label603:
    float f1 = paramItemInfo1.e + paramItemInfo1.d + f2;
    int i2 = paramItemInfo1.b + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramItemInfo1 = (ViewPager.ItemInfo)this.e.get(i1);
      while (paramInt < paramItemInfo1.b)
      {
        f1 = this.h.a(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (paramItemInfo1.b == i4 - 1) {
        this.u = (paramItemInfo1.d + f1 - 1.0F);
      }
      paramItemInfo1.e = f1;
      f1 += paramItemInfo1.d + f2;
      paramInt += 1;
      i1 += 1;
    }
    this.U = false;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.b(paramMotionEvent);
    if (MotionEventCompat.b(paramMotionEvent, i1) == this.K) {
      if (i1 != 0) {
        break label56;
      }
    }
    label56:
    for (i1 = 1;; i1 = 0)
    {
      this.G = MotionEventCompat.c(paramMotionEvent, i1);
      this.K = MotionEventCompat.b(paramMotionEvent, i1);
      if (this.L != null) {
        this.L.clear();
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i1;
    if (this.ak == 2)
    {
      i1 = 1;
      if (i1 != 0)
      {
        setScrollingCacheEnabled(false);
        if (this.m.isFinished()) {
          break label170;
        }
      }
    }
    label170:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 != 0)
      {
        this.m.abortAnimation();
        i2 = getScrollX();
        i3 = getScrollY();
        int i4 = this.m.getCurrX();
        int i5 = this.m.getCurrY();
        if ((i2 != i4) || (i3 != i5))
        {
          scrollTo(i4, i5);
          if (i4 != i2) {
            d(i4);
          }
        }
      }
      this.z = false;
      int i3 = 0;
      i2 = i1;
      i1 = i3;
      while (i1 < this.e.size())
      {
        ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.e.get(i1);
        if (localItemInfo.c)
        {
          localItemInfo.c = false;
          i2 = 1;
        }
        i1 += 1;
      }
      i1 = 0;
      break;
    }
    if (i2 != 0)
    {
      if (paramBoolean) {
        ViewCompat.a(this, this.aj);
      }
    }
    else {
      return;
    }
    this.aj.run();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.E) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.E) && (paramFloat2 < 0.0F));
  }
  
  private void b(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.ab != null) {
      this.ab.a(paramInt1, paramFloat, paramInt2);
    }
    if (this.aa != null)
    {
      int i2 = this.aa.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ViewPager.OnPageChangeListener localOnPageChangeListener = (ViewPager.OnPageChangeListener)this.aa.get(i1);
        if (localOnPageChangeListener != null) {
          localOnPageChangeListener.a(paramInt1, paramFloat, paramInt2);
        }
        i1 += 1;
      }
    }
    if (this.ac != null) {
      this.ac.a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i3 = getChildCount();
    int i1 = 0;
    if (i1 < i3)
    {
      if (paramBoolean) {}
      for (int i2 = 2;; i2 = 0)
      {
        ViewCompat.a(getChildAt(i1), i2, null);
        i1 += 1;
        break;
      }
    }
  }
  
  private boolean b(float paramFloat)
  {
    int i2 = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1 = this.G;
    this.G = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int i3 = getClientWidth();
    paramFloat = i3 * this.t;
    f1 = i3;
    float f3 = this.u;
    ViewPager.ItemInfo localItemInfo1 = (ViewPager.ItemInfo)this.e.get(0);
    ViewPager.ItemInfo localItemInfo2 = (ViewPager.ItemInfo)this.e.get(this.e.size() - 1);
    if (localItemInfo1.b != 0) {
      paramFloat = localItemInfo1.e * i3;
    }
    for (int i1 = 0;; i1 = 1)
    {
      if (localItemInfo2.b != this.h.a() - 1)
      {
        f1 = localItemInfo2.e * i3;
        i2 = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          f1 = paramFloat;
          if (i1 != 0)
          {
            bool1 = this.R.a(Math.abs(paramFloat - f2) / i3);
            f1 = paramFloat;
          }
        }
        for (;;)
        {
          this.G += f1 - (int)f1;
          scrollTo((int)f1, getScrollY());
          d((int)f1);
          return bool1;
          if (f2 > f1)
          {
            bool1 = bool2;
            if (i2 != 0) {
              bool1 = this.S.a(Math.abs(f2 - f1) / i3);
            }
          }
          else
          {
            f1 = f2;
          }
        }
        f1 *= f3;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private boolean d(int paramInt)
  {
    boolean bool = false;
    if (this.e.size() == 0)
    {
      this.V = false;
      a(0, 0.0F, 0);
      if (!this.V) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      ViewPager.ItemInfo localItemInfo = j();
      int i2 = getClientWidth();
      int i3 = this.p;
      float f1 = this.p / i2;
      int i1 = localItemInfo.b;
      f1 = (paramInt / i2 - localItemInfo.e) / (localItemInfo.d + f1);
      paramInt = (int)((i3 + i2) * f1);
      this.V = false;
      a(i1, f1, paramInt);
      if (!this.V) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private void e(int paramInt)
  {
    if (this.ab != null) {
      this.ab.a(paramInt);
    }
    if (this.aa != null)
    {
      int i2 = this.aa.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ViewPager.OnPageChangeListener localOnPageChangeListener = (ViewPager.OnPageChangeListener)this.aa.get(i1);
        if (localOnPageChangeListener != null) {
          localOnPageChangeListener.a(paramInt);
        }
        i1 += 1;
      }
    }
    if (this.ac != null) {
      this.ac.a(paramInt);
    }
  }
  
  private void f(int paramInt)
  {
    if (this.ab != null) {
      this.ab.b(paramInt);
    }
    if (this.aa != null)
    {
      int i2 = this.aa.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ViewPager.OnPageChangeListener localOnPageChangeListener = (ViewPager.OnPageChangeListener)this.aa.get(i1);
        if (localOnPageChangeListener != null) {
          localOnPageChangeListener.b(paramInt);
        }
        i1 += 1;
      }
    }
    if (this.ac != null) {
      this.ac.b(paramInt);
    }
  }
  
  private void g()
  {
    int i2;
    for (int i1 = 0; i1 < getChildCount(); i1 = i2 + 1)
    {
      i2 = i1;
      if (!((ViewPager.LayoutParams)getChildAt(i1).getLayoutParams()).a)
      {
        removeViewAt(i1);
        i2 = i1 - 1;
      }
    }
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void h()
  {
    if (this.ag != 0)
    {
      if (this.ah == null) {
        this.ah = new ArrayList();
      }
      for (;;)
      {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          View localView = getChildAt(i1);
          this.ah.add(localView);
          i1 += 1;
        }
        this.ah.clear();
      }
      Collections.sort(this.ah, ai);
    }
  }
  
  private boolean i()
  {
    this.K = -1;
    k();
    return this.R.c() | this.S.c();
  }
  
  private ViewPager.ItemInfo j()
  {
    int i1 = getClientWidth();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int i3;
    int i2;
    Object localObject1;
    label53:
    Object localObject2;
    ViewPager.ItemInfo localItemInfo;
    if (i1 > 0)
    {
      f1 = getScrollX() / i1;
      if (i1 <= 0) {
        break label214;
      }
      f2 = this.p / i1;
      f4 = 0.0F;
      f3 = 0.0F;
      i3 = -1;
      i1 = 0;
      i2 = 1;
      localObject1 = null;
      localObject2 = localObject1;
      if (i1 < this.e.size())
      {
        localItemInfo = (ViewPager.ItemInfo)this.e.get(i1);
        if ((i2 != 0) || (localItemInfo.b == i3 + 1)) {
          break label249;
        }
        localItemInfo = this.f;
        localItemInfo.e = (f4 + f3 + f2);
        localItemInfo.b = (i3 + 1);
        localItemInfo.d = this.h.a(localItemInfo.b);
        i1 -= 1;
      }
    }
    label214:
    label219:
    label249:
    for (;;)
    {
      f3 = localItemInfo.e;
      f4 = localItemInfo.d;
      if (i2 == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i1 != this.e.size() - 1)) {
          break label219;
        }
        localObject2 = localItemInfo;
      }
      return localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      i3 = localItemInfo.b;
      f4 = localItemInfo.d;
      i2 = 0;
      i1 += 1;
      localObject1 = localItemInfo;
      break label53;
    }
  }
  
  private void k()
  {
    this.B = false;
    this.C = false;
    if (this.L != null)
    {
      this.L.recycle();
      this.L = null;
    }
  }
  
  private void setScrollState(int paramInt)
  {
    if (this.ak == paramInt) {
      return;
    }
    this.ak = paramInt;
    if (this.ae != null) {
      if (paramInt == 0) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      f(paramInt);
      return;
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.y != paramBoolean) {
      this.y = paramBoolean;
    }
  }
  
  float a(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  ViewPager.ItemInfo a(int paramInt1, int paramInt2)
  {
    ViewPager.ItemInfo localItemInfo = new ViewPager.ItemInfo();
    localItemInfo.b = paramInt1;
    localItemInfo.a = this.h.a(this, paramInt1);
    localItemInfo.d = this.h.a(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.e.size()))
    {
      this.e.add(localItemInfo);
      return localItemInfo;
    }
    this.e.add(paramInt2, localItemInfo);
    return localItemInfo;
  }
  
  ViewPager.ItemInfo a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.e.size())
    {
      ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.e.get(i1);
      if (this.h.a(paramView, localItemInfo.a)) {
        return localItemInfo;
      }
      i1 += 1;
    }
    return null;
  }
  
  void a()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.m = new Scroller(localContext, d);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f1 = localContext.getResources().getDisplayMetrics().density;
    this.F = ViewConfigurationCompat.a(localViewConfiguration);
    this.M = ((int)(400.0F * f1));
    this.N = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.R = new EdgeEffectCompat(localContext);
    this.S = new EdgeEffectCompat(localContext);
    this.O = ((int)(25.0F * f1));
    this.P = ((int)(2.0F * f1));
    this.D = ((int)(16.0F * f1));
    ViewCompat.a(this, new ViewPager.MyAccessibilityDelegate(this));
    if (ViewCompat.c(this) == 0) {
      ViewCompat.c(this, 1);
    }
    ViewCompat.a(this, new ViewPager.4(this));
  }
  
  void a(int paramInt)
  {
    Object localObject2;
    if (this.i != paramInt)
    {
      localObject2 = b(this.i);
      this.i = paramInt;
    }
    for (;;)
    {
      if (this.h == null) {
        h();
      }
      do
      {
        return;
        if (this.z)
        {
          h();
          return;
        }
      } while (getWindowToken() == null);
      this.h.a(this);
      paramInt = this.A;
      int i7 = Math.max(0, this.i - paramInt);
      int i5 = this.h.a();
      int i6 = Math.min(i5 - 1, paramInt + this.i);
      Object localObject1;
      if (i5 != this.b) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.b + ", found: " + i5 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.h.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject1 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      if (paramInt < this.e.size())
      {
        localObject1 = (ViewPager.ItemInfo)this.e.get(paramInt);
        if (((ViewPager.ItemInfo)localObject1).b >= this.i) {
          if (((ViewPager.ItemInfo)localObject1).b != this.i) {
            break label1249;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (i5 > 0)) {}
        for (Object localObject3 = a(this.i, paramInt);; localObject3 = localObject1)
        {
          int i4;
          label321:
          int i8;
          label334:
          int i1;
          float f3;
          int i3;
          int i2;
          Object localObject4;
          float f1;
          if (localObject3 != null)
          {
            i4 = paramInt - 1;
            if (i4 < 0) {
              break label617;
            }
            localObject1 = (ViewPager.ItemInfo)this.e.get(i4);
            i8 = getClientWidth();
            if (i8 > 0) {
              break label623;
            }
            f2 = 0.0F;
            i1 = this.i;
            f3 = 0.0F;
            i3 = i1 - 1;
            i2 = paramInt;
            localObject4 = localObject1;
            if (i3 >= 0)
            {
              if ((f3 < f2) || (i3 >= i7)) {
                break label778;
              }
              if (localObject4 != null) {
                break label644;
              }
            }
            f1 = ((ViewPager.ItemInfo)localObject3).d;
            paramInt = i2 + 1;
            if (f1 < 2.0F)
            {
              if (paramInt >= this.e.size()) {
                break label898;
              }
              localObject1 = (ViewPager.ItemInfo)this.e.get(paramInt);
              label421:
              if (i8 > 0) {
                break label904;
              }
            }
          }
          label440:
          label498:
          label617:
          label623:
          label644:
          label769:
          label778:
          label898:
          label904:
          for (float f2 = 0.0F;; f2 = getPaddingRight() / i8 + 2.0F)
          {
            i1 = this.i;
            i1 += 1;
            if (i1 < i5)
            {
              if ((f1 < f2) || (i1 <= i6)) {
                break label1000;
              }
              if (localObject1 != null) {
                break label919;
              }
            }
            a((ViewPager.ItemInfo)localObject3, i2, (ViewPager.ItemInfo)localObject2);
            localObject2 = this.h;
            paramInt = this.i;
            if (localObject3 == null) {
              break label1122;
            }
            localObject1 = ((ViewPager.ItemInfo)localObject3).a;
            ((PagerAdapter)localObject2).b(this, paramInt, localObject1);
            this.h.b(this);
            i1 = getChildCount();
            paramInt = 0;
            while (paramInt < i1)
            {
              localObject2 = getChildAt(paramInt);
              localObject1 = (ViewPager.LayoutParams)((View)localObject2).getLayoutParams();
              ((ViewPager.LayoutParams)localObject1).f = paramInt;
              if ((!((ViewPager.LayoutParams)localObject1).a) && (((ViewPager.LayoutParams)localObject1).c == 0.0F))
              {
                localObject2 = a((View)localObject2);
                if (localObject2 != null)
                {
                  ((ViewPager.LayoutParams)localObject1).c = ((ViewPager.ItemInfo)localObject2).d;
                  ((ViewPager.LayoutParams)localObject1).e = ((ViewPager.ItemInfo)localObject2).b;
                }
              }
              paramInt += 1;
            }
            paramInt += 1;
            break;
            localObject1 = null;
            break label321;
            f2 = 2.0F - ((ViewPager.ItemInfo)localObject3).d + getPaddingLeft() / i8;
            break label334;
            localObject1 = localObject4;
            paramInt = i4;
            f1 = f3;
            i1 = i2;
            if (i3 == localObject4.b)
            {
              localObject1 = localObject4;
              paramInt = i4;
              f1 = f3;
              i1 = i2;
              if (!localObject4.c)
              {
                this.e.remove(i4);
                this.h.a(this, i3, localObject4.a);
                paramInt = i4 - 1;
                i1 = i2 - 1;
                if (paramInt < 0) {
                  break label769;
                }
                localObject1 = (ViewPager.ItemInfo)this.e.get(paramInt);
                f1 = f3;
              }
            }
            for (;;)
            {
              i3 -= 1;
              localObject4 = localObject1;
              i4 = paramInt;
              f3 = f1;
              i2 = i1;
              break;
              localObject1 = null;
              f1 = f3;
              continue;
              if ((localObject4 != null) && (i3 == localObject4.b))
              {
                f1 = f3 + localObject4.d;
                paramInt = i4 - 1;
                if (paramInt >= 0)
                {
                  localObject1 = (ViewPager.ItemInfo)this.e.get(paramInt);
                  i1 = i2;
                }
                else
                {
                  localObject1 = null;
                  i1 = i2;
                }
              }
              else
              {
                f1 = f3 + a(i3, i4 + 1).d;
                i1 = i2 + 1;
                if (i4 >= 0)
                {
                  localObject1 = (ViewPager.ItemInfo)this.e.get(i4);
                  paramInt = i4;
                }
                else
                {
                  localObject1 = null;
                  paramInt = i4;
                }
              }
            }
            localObject1 = null;
            break label421;
          }
          label919:
          if ((i1 == ((ViewPager.ItemInfo)localObject1).b) && (!((ViewPager.ItemInfo)localObject1).c))
          {
            this.e.remove(paramInt);
            this.h.a(this, i1, ((ViewPager.ItemInfo)localObject1).a);
            if (paramInt < this.e.size()) {
              localObject1 = (ViewPager.ItemInfo)this.e.get(paramInt);
            }
          }
          for (;;)
          {
            i1 += 1;
            break label440;
            localObject1 = null;
            continue;
            label1000:
            if ((localObject1 != null) && (i1 == ((ViewPager.ItemInfo)localObject1).b))
            {
              f3 = ((ViewPager.ItemInfo)localObject1).d;
              paramInt += 1;
              if (paramInt < this.e.size()) {}
              for (localObject1 = (ViewPager.ItemInfo)this.e.get(paramInt);; localObject1 = null)
              {
                f1 += f3;
                break;
              }
            }
            localObject1 = a(i1, paramInt);
            paramInt += 1;
            f3 = ((ViewPager.ItemInfo)localObject1).d;
            if (paramInt < this.e.size()) {}
            for (localObject1 = (ViewPager.ItemInfo)this.e.get(paramInt);; localObject1 = null)
            {
              f1 += f3;
              break;
            }
            label1122:
            localObject1 = null;
            break label498;
            h();
            if (!hasFocus()) {
              break;
            }
            localObject1 = findFocus();
            if (localObject1 != null) {}
            for (localObject1 = b((View)localObject1);; localObject1 = null)
            {
              if ((localObject1 != null) && (((ViewPager.ItemInfo)localObject1).b == this.i)) {
                break label1237;
              }
              paramInt = 0;
              for (;;)
              {
                if (paramInt >= getChildCount()) {
                  break label1231;
                }
                localObject1 = getChildAt(paramInt);
                localObject2 = a((View)localObject1);
                if ((localObject2 != null) && (((ViewPager.ItemInfo)localObject2).b == this.i) && (((View)localObject1).requestFocus(2))) {
                  break;
                }
                paramInt += 1;
              }
              label1231:
              break;
            }
            label1237:
            break;
          }
        }
        label1249:
        localObject1 = null;
      }
      localObject2 = null;
    }
  }
  
  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    View localView;
    if (this.W > 0)
    {
      int i6 = getScrollX();
      i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i7 = getWidth();
      int i8 = getChildCount();
      int i5 = 0;
      while (i5 < i8)
      {
        localView = getChildAt(i5);
        ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
        int i4;
        int i3;
        if (!localLayoutParams.a)
        {
          i4 = i1;
          i3 = i2;
          i5 += 1;
          i1 = i4;
          i2 = i3;
        }
        else
        {
          switch (localLayoutParams.b & 0x7)
          {
          case 2: 
          case 4: 
          default: 
            i3 = i1;
            i4 = i2;
            i2 = i1;
            i1 = i4;
          }
          for (;;)
          {
            int i9 = i3 + i6 - localView.getLeft();
            i3 = i1;
            i4 = i2;
            if (i9 == 0) {
              break;
            }
            localView.offsetLeftAndRight(i9);
            i3 = i1;
            i4 = i2;
            break;
            i3 = localView.getWidth();
            i4 = i3 + i1;
            i3 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = Math.max((i7 - localView.getMeasuredWidth()) / 2, i1);
            i4 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = i7 - i2 - localView.getMeasuredWidth();
            i9 = localView.getMeasuredWidth();
            i4 = i1;
            i1 = i2 + i9;
            i2 = i4;
          }
        }
      }
    }
    b(paramInt1, paramFloat, paramInt2);
    if (this.ae != null)
    {
      paramInt2 = getScrollX();
      i1 = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < i1)
      {
        localView = getChildAt(paramInt1);
        if (((ViewPager.LayoutParams)localView.getLayoutParams()).a) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
          this.ae.a(localView, paramFloat);
        }
      }
    }
    this.V = true;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i1;
    if ((this.m != null) && (!this.m.isFinished()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label125;
      }
      if (!this.n) {
        break label113;
      }
      i1 = this.m.getCurrX();
      label54:
      this.m.abortAnimation();
      setScrollingCacheEnabled(false);
    }
    int i2;
    int i3;
    for (;;)
    {
      i2 = getScrollY();
      i3 = paramInt1 - i1;
      paramInt2 -= i2;
      if ((i3 != 0) || (paramInt2 != 0)) {
        break label134;
      }
      a(false);
      c();
      setScrollState(0);
      return;
      i1 = 0;
      break;
      label113:
      i1 = this.m.getStartX();
      break label54;
      label125:
      i1 = getScrollX();
    }
    label134:
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int i4 = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(i3) * 1.0F / paramInt1);
    float f1 = i4;
    float f2 = i4;
    f3 = a(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt3)) * 4;; paramInt1 = (int)((Math.abs(i3) / (f1 * f2 + this.p) + 1.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.n = false;
      this.m.startScroll(i1, i2, i3, paramInt2, paramInt1);
      ViewCompat.b(this);
      return;
      f1 = paramInt1;
      f2 = this.h.a(this.i);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.z = false;
    a(paramInt, paramBoolean, false);
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.h == null) || (this.h.a() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.i == paramInt1) && (this.e.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    for (;;)
    {
      paramInt1 = this.A;
      if ((i1 <= this.i + paramInt1) && (i1 >= this.i - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.e.size())
      {
        ((ViewPager.ItemInfo)this.e.get(paramInt1)).c = true;
        paramInt1 += 1;
      }
      i1 = paramInt1;
      if (paramInt1 >= this.h.a()) {
        i1 = this.h.a() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.i != i1) {
      paramBoolean2 = true;
    }
    if (this.T)
    {
      this.i = i1;
      if (paramBoolean2) {
        e(i1);
      }
      requestLayout();
      return;
    }
    a(i1);
    a(i1, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  public void a(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.aa == null) {
      this.aa = new ArrayList();
    }
    this.aa.add(paramOnPageChangeListener);
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      }
    }
    do
    {
      do
      {
        return false;
        return c(17);
        return c(66);
      } while (Build.VERSION.SDK_INT < 11);
      if (KeyEventCompat.a(paramKeyEvent)) {
        return c(2);
      }
    } while (!KeyEventCompat.a(paramKeyEvent, 1));
    return c(1);
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      i1 = localViewGroup.getChildCount() - 1;
      if (i1 >= 0)
      {
        localView = localViewGroup.getChildAt(i1);
        if ((paramInt2 + i2 < localView.getLeft()) || (paramInt2 + i2 >= localView.getRight()) || (paramInt3 + i3 < localView.getTop()) || (paramInt3 + i3 >= localView.getBottom()) || (!a(localView, true, paramInt1, paramInt2 + i2 - localView.getLeft(), paramInt3 + i3 - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (ViewCompat.a(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i1 -= 1;
      break;
    }
    return false;
  }
  
  public void addFocusables(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    int i2 = paramArrayList.size();
    int i3 = getDescendantFocusability();
    if (i3 != 393216)
    {
      int i1 = 0;
      while (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        if (localView.getVisibility() == 0)
        {
          ViewPager.ItemInfo localItemInfo = a(localView);
          if ((localItemInfo != null) && (localItemInfo.b == this.i)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i1 += 1;
      }
    }
    if (((i3 == 262144) && (i2 != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
    }
    paramArrayList.add(this);
  }
  
  public void addTouchables(ArrayList paramArrayList)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        ViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.b == this.i)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)paramLayoutParams;
      localLayoutParams.a |= paramView instanceof ViewPager.Decor;
      if (this.x)
      {
        if ((localLayoutParams != null) && (localLayoutParams.a)) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localLayoutParams.d = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  ViewPager.ItemInfo b(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.e.size())
    {
      ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.e.get(i1);
      if (localItemInfo.b == paramInt) {
        return localItemInfo;
      }
      i1 += 1;
    }
    return null;
  }
  
  ViewPager.ItemInfo b(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return a(paramView);
  }
  
  void b()
  {
    int i7 = this.h.a();
    this.b = i7;
    int i1;
    int i2;
    int i3;
    int i5;
    int i4;
    label67:
    Object localObject;
    int i6;
    if ((this.e.size() < this.A * 2 + 1) && (this.e.size() < i7))
    {
      i1 = 1;
      i2 = this.i;
      i3 = 0;
      i5 = 0;
      i4 = i1;
      i1 = i2;
      i2 = i3;
      i3 = i5;
      if (i3 >= this.e.size()) {
        break label299;
      }
      localObject = (ViewPager.ItemInfo)this.e.get(i3);
      i5 = this.h.a(((ViewPager.ItemInfo)localObject).a);
      if (i5 != -1) {
        break label157;
      }
      i5 = i3;
      i6 = i2;
      i3 = i4;
      i2 = i1;
      i1 = i6;
      i4 = i5;
    }
    for (;;)
    {
      i5 = i3;
      i6 = i2;
      i3 = i4 + 1;
      i2 = i1;
      i1 = i6;
      i4 = i5;
      break label67;
      i1 = 0;
      break;
      label157:
      if (i5 == -2)
      {
        this.e.remove(i3);
        i4 = i3 - 1;
        i3 = i2;
        if (i2 == 0)
        {
          this.h.a(this);
          i3 = 1;
        }
        this.h.a(this, ((ViewPager.ItemInfo)localObject).b, ((ViewPager.ItemInfo)localObject).a);
        if (this.i == ((ViewPager.ItemInfo)localObject).b)
        {
          i2 = Math.max(0, Math.min(this.i, i7 - 1));
          i1 = i3;
          i3 = 1;
        }
      }
      else
      {
        if (((ViewPager.ItemInfo)localObject).b != i5)
        {
          if (((ViewPager.ItemInfo)localObject).b == this.i) {
            i1 = i5;
          }
          ((ViewPager.ItemInfo)localObject).b = i5;
          i5 = i1;
          i6 = 1;
          i4 = i3;
          i1 = i2;
          i2 = i5;
          i3 = i6;
          continue;
          label299:
          if (i2 != 0) {
            this.h.b(this);
          }
          Collections.sort(this.e, c);
          if (i4 != 0)
          {
            i3 = getChildCount();
            i2 = 0;
            while (i2 < i3)
            {
              localObject = (ViewPager.LayoutParams)getChildAt(i2).getLayoutParams();
              if (!((ViewPager.LayoutParams)localObject).a) {
                ((ViewPager.LayoutParams)localObject).c = 0.0F;
              }
              i2 += 1;
            }
            a(i1, false, true);
            requestLayout();
          }
          return;
        }
        i5 = i1;
        i6 = i4;
        i4 = i3;
        i1 = i2;
        i2 = i5;
        i3 = i6;
        continue;
      }
      i2 = i1;
      i5 = 1;
      i1 = i3;
      i3 = i5;
    }
  }
  
  void c()
  {
    a(this.i);
  }
  
  public boolean c(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int i2;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label329;
      }
      if (paramInt != 17) {
        break label266;
      }
      i1 = a(this.g, localView).left;
      i2 = a(this.g, (View)localObject).left;
      if ((localObject != null) && (i1 >= i2))
      {
        bool = d();
        label89:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label375;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label382;
      }
      if (localObject != this) {}
    }
    label266:
    label329:
    label375:
    label382:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label89;
        if (paramInt == 66)
        {
          i1 = a(this.g, localView).left;
          i2 = a(this.g, (View)localObject).left;
          if ((localObject != null) && (i1 <= i2))
          {
            bool = e();
            break label89;
          }
          bool = localView.requestFocus();
          break label89;
          if ((paramInt == 17) || (paramInt == 1))
          {
            bool = d();
            break label89;
          }
          if ((paramInt == 66) || (paramInt == 2))
          {
            bool = e();
            break label89;
          }
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.h == null) {}
    int i1;
    int i2;
    do
    {
      return false;
      i1 = getClientWidth();
      i2 = getScrollX();
      if (paramInt < 0)
      {
        if (i2 > (int)(i1 * this.t)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (paramInt <= 0);
    if (i2 < (int)(i1 * this.u)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof ViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    this.n = true;
    if ((!this.m.isFinished()) && (this.m.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.m.getCurrX();
      int i4 = this.m.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!d(i3))
        {
          this.m.abortAnimation();
          scrollTo(0, i4);
        }
      }
      ViewCompat.b(this);
      return;
    }
    a(true);
  }
  
  boolean d()
  {
    if (this.i > 0)
    {
      a(this.i - 1, true);
      return true;
    }
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break;
      }
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        ViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.b == this.i) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i1 += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i3 = 0;
    int i1 = 0;
    int i4 = ViewCompat.a(this);
    boolean bool;
    if ((i4 == 0) || ((i4 == 1) && (this.h != null) && (this.h.a() > 1)))
    {
      int i2;
      if (!this.R.a())
      {
        i3 = paramCanvas.save();
        i1 = getHeight() - getPaddingTop() - getPaddingBottom();
        i4 = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i1 + getPaddingTop(), this.t * i4);
        this.R.a(i1, i4);
        i2 = false | this.R.a(paramCanvas);
        paramCanvas.restoreToCount(i3);
      }
      i3 = i2;
      if (!this.S.a())
      {
        i4 = paramCanvas.save();
        i3 = getWidth();
        int i5 = getHeight();
        int i6 = getPaddingTop();
        int i7 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.u + 1.0F) * i3);
        this.S.a(i5 - i6 - i7, i3);
        bool = i2 | this.S.a(paramCanvas);
        paramCanvas.restoreToCount(i4);
      }
    }
    for (;;)
    {
      if (bool) {
        ViewCompat.b(this);
      }
      return;
      this.R.b();
      this.S.b();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.q;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  boolean e()
  {
    if ((this.h != null) && (this.i < this.h.a() - 1))
    {
      a(this.i + 1, true);
      return true;
    }
    return false;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewPager.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewPager.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter()
  {
    return this.h;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (this.ag == 2) {
      i1 = paramInt1 - 1 - paramInt2;
    }
    return ((ViewPager.LayoutParams)((View)this.ah.get(i1)).getLayoutParams()).f;
  }
  
  public int getCurrentItem()
  {
    return this.i;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.A;
  }
  
  public int getPageMargin()
  {
    return this.p;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.T = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.aj);
    if ((this.m != null) && (!this.m.isFinished())) {
      this.m.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i3;
    int i4;
    float f3;
    Object localObject;
    float f1;
    int i5;
    int i1;
    int i6;
    int i2;
    if ((this.p > 0) && (this.q != null) && (this.e.size() > 0) && (this.h != null))
    {
      i3 = getScrollX();
      i4 = getWidth();
      f3 = this.p / i4;
      localObject = (ViewPager.ItemInfo)this.e.get(0);
      f1 = ((ViewPager.ItemInfo)localObject).e;
      i5 = this.e.size();
      i1 = ((ViewPager.ItemInfo)localObject).b;
      i6 = ((ViewPager.ItemInfo)this.e.get(i5 - 1)).b;
      i2 = 0;
    }
    for (;;)
    {
      float f2;
      if (i1 < i6)
      {
        while ((i1 > ((ViewPager.ItemInfo)localObject).b) && (i2 < i5))
        {
          localObject = this.e;
          i2 += 1;
          localObject = (ViewPager.ItemInfo)((ArrayList)localObject).get(i2);
        }
        if (i1 != ((ViewPager.ItemInfo)localObject).b) {
          break label271;
        }
        f2 = (((ViewPager.ItemInfo)localObject).e + ((ViewPager.ItemInfo)localObject).d) * i4;
      }
      label271:
      float f4;
      for (f1 = ((ViewPager.ItemInfo)localObject).e + ((ViewPager.ItemInfo)localObject).d + f3;; f1 += f4 + f3)
      {
        if (this.p + f2 > i3)
        {
          this.q.setBounds((int)f2, this.r, (int)(this.p + f2 + 0.5F), this.s);
          this.q.draw(paramCanvas);
        }
        if (f2 <= i3 + i4) {
          break;
        }
        return;
        f4 = this.h.a(i1);
        f2 = (f1 + f4) * i4;
      }
      i1 += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 == 3) || (i1 == 1)) {
      i();
    }
    do
    {
      return false;
      if (i1 == 0) {
        break;
      }
      if (this.B) {
        return true;
      }
    } while (this.C);
    switch (i1)
    {
    }
    for (;;)
    {
      if (this.L == null) {
        this.L = VelocityTracker.obtain();
      }
      this.L.addMovement(paramMotionEvent);
      return this.B;
      i1 = this.K;
      if (i1 != -1)
      {
        i1 = MotionEventCompat.a(paramMotionEvent, i1);
        float f2 = MotionEventCompat.c(paramMotionEvent, i1);
        float f1 = f2 - this.G;
        float f4 = Math.abs(f1);
        float f3 = MotionEventCompat.d(paramMotionEvent, i1);
        float f5 = Math.abs(f3 - this.J);
        if ((f1 != 0.0F) && (!a(this.G, f1)) && (a(this, false, (int)f1, (int)f2, (int)f3)))
        {
          this.G = f2;
          this.H = f3;
          this.C = true;
          return false;
        }
        if ((f4 > this.F) && (0.5F * f4 > f5))
        {
          this.B = true;
          c(true);
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.I + this.F;
            label282:
            this.G = f1;
            this.H = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.B) && (b(f2)))
        {
          ViewCompat.b(this);
          break;
          f1 = this.I - this.F;
          break label282;
          if (f5 > this.F) {
            this.C = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.I = f1;
        this.G = f1;
        f1 = paramMotionEvent.getY();
        this.J = f1;
        this.H = f1;
        this.K = MotionEventCompat.b(paramMotionEvent, 0);
        this.C = false;
        this.n = true;
        this.m.computeScrollOffset();
        if ((this.ak == 2) && (Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.P))
        {
          this.m.abortAnimation();
          this.z = false;
          c();
          this.B = true;
          c(true);
          setScrollState(1);
        }
        else
        {
          a(false);
          this.B = false;
          continue;
          a(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i6 = getChildCount();
    int i8 = paramInt3 - paramInt1;
    int i7 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i1 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i9 = getScrollX();
    int i2 = 0;
    int i4 = 0;
    View localView;
    ViewPager.LayoutParams localLayoutParams;
    int i10;
    int i3;
    label154:
    int i5;
    if (i4 < i6)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() == 8) {
        break label671;
      }
      localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.a) {
        break label671;
      }
      paramInt4 = localLayoutParams.b;
      i10 = localLayoutParams.b;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt2;
        i3 = paramInt2;
        switch (i10 & 0x70)
        {
        default: 
          i5 = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = i5;
          label204:
          paramInt4 += i9;
          localView.layout(paramInt4, paramInt3, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt3);
          i2 += 1;
          paramInt4 = i1;
          paramInt3 = i3;
          i1 = paramInt1;
          paramInt1 = i2;
        }
        break;
      }
    }
    for (;;)
    {
      i4 += 1;
      i3 = paramInt3;
      i2 = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i1;
      i1 = paramInt4;
      paramInt2 = i3;
      break;
      i3 = localView.getMeasuredWidth();
      paramInt4 = paramInt2;
      i3 += paramInt2;
      break label154;
      paramInt4 = Math.max((i8 - localView.getMeasuredWidth()) / 2, paramInt2);
      i3 = paramInt2;
      break label154;
      i3 = localView.getMeasuredWidth();
      paramInt4 = i1 + localView.getMeasuredWidth();
      i5 = i8 - i1 - i3;
      i1 = paramInt4;
      i3 = paramInt2;
      paramInt4 = i5;
      break label154;
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      i5 += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i5;
      break label204;
      i5 = Math.max((i7 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i5;
      break label204;
      i5 = i7 - paramInt3 - localView.getMeasuredHeight();
      i10 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i10;
      paramInt3 = i5;
      break label204;
      i1 = i8 - paramInt2 - i1;
      paramInt4 = 0;
      while (paramInt4 < i6)
      {
        localView = getChildAt(paramInt4);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.a)
          {
            ViewPager.ItemInfo localItemInfo = a(localView);
            if (localItemInfo != null)
            {
              float f1 = i1;
              i3 = (int)(localItemInfo.e * f1) + paramInt2;
              if (localLayoutParams.d)
              {
                localLayoutParams.d = false;
                f1 = i1;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.c * f1), 1073741824), View.MeasureSpec.makeMeasureSpec(i7 - paramInt1 - paramInt3, 1073741824));
              }
              localView.layout(i3, paramInt1, localView.getMeasuredWidth() + i3, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
        paramInt4 += 1;
      }
      this.r = paramInt1;
      this.s = (i7 - paramInt3);
      this.W = i2;
      if (this.T) {
        a(this.i, false, 0, false);
      }
      this.T = false;
      return;
      label671:
      paramInt4 = i2;
      i2 = paramInt1;
      i3 = paramInt2;
      paramInt1 = paramInt4;
      paramInt4 = i1;
      i1 = paramInt3;
      paramInt2 = i2;
      paramInt3 = i3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.E = Math.min(paramInt1 / 10, this.D);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i9 = getChildCount();
    int i3 = 0;
    View localView;
    int i1;
    int i2;
    ViewPager.LayoutParams localLayoutParams;
    int i4;
    int i6;
    label183:
    int i5;
    if (i3 < i9)
    {
      localView = getChildAt(i3);
      i1 = paramInt1;
      i2 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
        i1 = paramInt1;
        i2 = paramInt2;
        if (localLayoutParams != null)
        {
          i1 = paramInt1;
          i2 = paramInt2;
          if (localLayoutParams.a)
          {
            i1 = localLayoutParams.b & 0x7;
            i4 = localLayoutParams.b & 0x70;
            i6 = Integer.MIN_VALUE;
            i2 = Integer.MIN_VALUE;
            if ((i4 != 48) && (i4 != 80)) {
              break label333;
            }
            i4 = 1;
            if ((i1 != 3) && (i1 != 5)) {
              break label339;
            }
            i5 = 1;
            label198:
            if (i4 == 0) {
              break label345;
            }
            i1 = 1073741824;
            label208:
            if (localLayoutParams.width == -2) {
              break label528;
            }
            i6 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label522;
            }
            i1 = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i8;
      if (localLayoutParams.height != -2)
      {
        i7 = 1073741824;
        i2 = i7;
        if (localLayoutParams.height != -1)
        {
          i8 = localLayoutParams.height;
          i2 = i7;
        }
      }
      for (int i7 = i8;; i7 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i1, i6), View.MeasureSpec.makeMeasureSpec(i7, i2));
        if (i4 != 0)
        {
          i2 = paramInt2 - localView.getMeasuredHeight();
          i1 = paramInt1;
        }
        for (;;)
        {
          i3 += 1;
          paramInt1 = i1;
          paramInt2 = i2;
          break;
          label333:
          i4 = 0;
          break label183;
          label339:
          i5 = 0;
          break label198;
          label345:
          i1 = i6;
          if (i5 == 0) {
            break label208;
          }
          i2 = 1073741824;
          i1 = i6;
          break label208;
          i1 = paramInt1;
          i2 = paramInt2;
          if (i5 != 0)
          {
            i1 = paramInt1 - localView.getMeasuredWidth();
            i2 = paramInt2;
          }
        }
        this.v = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.w = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.x = true;
        c();
        this.x = false;
        i1 = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i1)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.a))
            {
              float f1 = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.c * f1), 1073741824), this.w);
            }
          }
          paramInt2 += 1;
        }
        return;
      }
      label522:
      i1 = paramInt1;
      continue;
      label528:
      i6 = i1;
      i1 = paramInt1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i3 = -1;
    int i2 = getChildCount();
    int i1;
    if ((paramInt & 0x2) != 0)
    {
      i3 = 1;
      i1 = 0;
    }
    while (i1 != i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        ViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.b == this.i) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i1 = i2 - 1;
          i2 = -1;
          continue;
        }
      }
      i1 += i3;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.h != null)
    {
      this.h.a(paramParcelable.b, paramParcelable.c);
      a(paramParcelable.a, false, true);
      return;
    }
    this.j = paramParcelable.a;
    this.k = paramParcelable.b;
    this.l = paramParcelable.c;
  }
  
  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.i;
    if (this.h != null) {
      localSavedState.b = this.h.b();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      a(paramInt1, paramInt3, this.p, this.p);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.Q) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.h == null) || (this.h.a() == 0)) {
      return false;
    }
    if (this.L == null) {
      this.L = VelocityTracker.obtain();
    }
    this.L.addMovement(paramMotionEvent);
    boolean bool1 = bool2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1) {
        ViewCompat.b(this);
      }
      return true;
      this.m.abortAnimation();
      this.z = false;
      c();
      float f1 = paramMotionEvent.getX();
      this.I = f1;
      this.G = f1;
      f1 = paramMotionEvent.getY();
      this.J = f1;
      this.H = f1;
      this.K = MotionEventCompat.b(paramMotionEvent, 0);
      bool1 = bool2;
      continue;
      int i1;
      float f2;
      if (!this.B)
      {
        i1 = MotionEventCompat.a(paramMotionEvent, this.K);
        if (i1 == -1)
        {
          bool1 = i();
          continue;
        }
        f1 = MotionEventCompat.c(paramMotionEvent, i1);
        float f3 = Math.abs(f1 - this.G);
        f2 = MotionEventCompat.d(paramMotionEvent, i1);
        float f4 = Math.abs(f2 - this.H);
        if ((f3 > this.F) && (f3 > f4))
        {
          this.B = true;
          c(true);
          if (f1 - this.I <= 0.0F) {
            break label393;
          }
        }
      }
      Object localObject;
      label393:
      for (f1 = this.I + this.F;; f1 = this.I - this.F)
      {
        this.G = f1;
        this.H = f2;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        bool1 = bool2;
        if (!this.B) {
          break;
        }
        bool1 = false | b(MotionEventCompat.c(paramMotionEvent, MotionEventCompat.a(paramMotionEvent, this.K)));
        break;
      }
      bool1 = bool2;
      if (this.B)
      {
        localObject = this.L;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.N);
        i1 = (int)VelocityTrackerCompat.a((VelocityTracker)localObject, this.K);
        this.z = true;
        int i2 = getClientWidth();
        int i3 = getScrollX();
        localObject = j();
        a(a(((ViewPager.ItemInfo)localObject).b, (i3 / i2 - ((ViewPager.ItemInfo)localObject).e) / ((ViewPager.ItemInfo)localObject).d, i1, (int)(MotionEventCompat.c(paramMotionEvent, MotionEventCompat.a(paramMotionEvent, this.K)) - this.I)), true, true, i1);
        bool1 = i();
        continue;
        bool1 = bool2;
        if (this.B)
        {
          a(this.i, true, 0, false);
          bool1 = i();
          continue;
          i1 = MotionEventCompat.b(paramMotionEvent);
          this.G = MotionEventCompat.c(paramMotionEvent, i1);
          this.K = MotionEventCompat.b(paramMotionEvent, i1);
          bool1 = bool2;
          continue;
          a(paramMotionEvent);
          this.G = MotionEventCompat.c(paramMotionEvent, MotionEventCompat.a(paramMotionEvent, this.K));
          bool1 = bool2;
        }
      }
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.x)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (this.h != null)
    {
      this.h.a(null);
      this.h.a(this);
      int i1 = 0;
      while (i1 < this.e.size())
      {
        localObject = (ViewPager.ItemInfo)this.e.get(i1);
        this.h.a(this, ((ViewPager.ItemInfo)localObject).b, ((ViewPager.ItemInfo)localObject).a);
        i1 += 1;
      }
      this.h.b(this);
      this.e.clear();
      g();
      this.i = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.h;
    this.h = paramPagerAdapter;
    this.b = 0;
    boolean bool;
    if (this.h != null)
    {
      if (this.o == null) {
        this.o = new ViewPager.PagerObserver(this, null);
      }
      this.h.a(this.o);
      this.z = false;
      bool = this.T;
      this.T = true;
      this.b = this.h.a();
      if (this.j < 0) {
        break label257;
      }
      this.h.a(this.k, this.l);
      a(this.j, false, true);
      this.j = -1;
      this.k = null;
      this.l = null;
    }
    for (;;)
    {
      if ((this.ad != null) && (localObject != paramPagerAdapter)) {
        this.ad.a((PagerAdapter)localObject, paramPagerAdapter);
      }
      return;
      label257:
      if (!bool) {
        c();
      } else {
        requestLayout();
      }
    }
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (this.af == null)) {}
    try
    {
      this.af = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          this.af.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (Exception localException)
        {
          Log.e("ViewPager", "Error changing children drawing order", localException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.z = false;
    if (!this.T) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 1)
    {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      i1 = 1;
    }
    if (i1 != this.A)
    {
      this.A = i1;
      c();
    }
  }
  
  void setOnAdapterChangeListener(ViewPager.OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    this.ad = paramOnAdapterChangeListener;
  }
  
  @Deprecated
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.ab = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i1 = this.p;
    this.p = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.q = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.q);
  }
}
