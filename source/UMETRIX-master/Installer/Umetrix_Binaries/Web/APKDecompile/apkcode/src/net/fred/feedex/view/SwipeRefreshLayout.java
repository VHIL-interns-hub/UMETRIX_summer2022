package net.fred.feedex.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;

public class SwipeRefreshLayout
  extends ViewGroup
{
  private static final int[] a = { 16842766 };
  private final DecelerateInterpolator b;
  private final AccelerateInterpolator c;
  private SwipeProgressBar d;
  private View e;
  private int f;
  private SwipeRefreshLayout.OnRefreshListener g;
  private MotionEvent h;
  private int i;
  private final Animation j = new SwipeRefreshLayout.1(this);
  private boolean k = false;
  private int l;
  private float m = -1.0F;
  private float n;
  private int o;
  private float p = 0.0F;
  private Animation q = new SwipeRefreshLayout.2(this);
  private float r = 0.0F;
  private final Animation.AnimationListener s = new SwipeRefreshLayout.3(this);
  private int t;
  private int u;
  private final Animation.AnimationListener v = new SwipeRefreshLayout.4(this);
  private boolean w;
  private final Runnable x = new SwipeRefreshLayout.5(this);
  private final Runnable y = new SwipeRefreshLayout.6(this);
  
  public SwipeRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.l = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.o = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.d = new SwipeProgressBar(this);
    this.t = ((int)(getResources().getDisplayMetrics().density * 4.0F));
    this.b = new DecelerateInterpolator(2.0F);
    this.c = new AccelerateInterpolator(1.5F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void a(int paramInt)
  {
    int i2 = this.e.getTop();
    int i1;
    if (paramInt > this.m) {
      i1 = (int)this.m;
    }
    for (;;)
    {
      setTargetOffsetTopAndBottom(i1 - i2);
      return;
      i1 = paramInt;
      if (paramInt < 0) {
        i1 = 0;
      }
    }
  }
  
  private void a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.i = paramInt;
    this.j.reset();
    this.j.setDuration(this.o);
    this.j.setAnimationListener(paramAnimationListener);
    this.j.setInterpolator(this.b);
    this.e.startAnimation(this.j);
  }
  
  private void c()
  {
    if (this.e == null)
    {
      if ((getChildCount() > 1) && (!isInEditMode())) {
        throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
      }
      this.e = getChildAt(0);
      this.f = (this.e.getTop() + getPaddingTop());
    }
    if ((this.m == -1.0F) && (getParent() != null) && (((View)getParent()).getHeight() > 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.m = ((int)Math.min(((View)getParent()).getHeight() * 0.6F, localDisplayMetrics.density * 120.0F));
    }
  }
  
  private void d()
  {
    removeCallbacks(this.y);
    this.x.run();
    setRefreshing(true);
    this.g.g_();
  }
  
  private void e()
  {
    removeCallbacks(this.y);
    postDelayed(this.y, 300L);
  }
  
  private void setTargetOffsetTopAndBottom(int paramInt)
  {
    this.e.offsetTopAndBottom(paramInt);
    this.u = this.e.getTop();
  }
  
  private void setTriggerPercentage(float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      this.r = 0.0F;
      return;
    }
    this.r = paramFloat;
    this.d.a(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c();
    Resources localResources = getResources();
    paramInt1 = localResources.getColor(paramInt1);
    paramInt2 = localResources.getColor(paramInt2);
    paramInt3 = localResources.getColor(paramInt3);
    paramInt4 = localResources.getColor(paramInt4);
    this.d.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT < 14)
    {
      if ((this.e instanceof AbsListView))
      {
        AbsListView localAbsListView = (AbsListView)this.e;
        return (localAbsListView.getChildCount() > 0) && ((localAbsListView.getFirstVisiblePosition() > 0) || (localAbsListView.getChildAt(0).getTop() < localAbsListView.getPaddingTop()));
      }
      if (this.e.getScrollY() > 0) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return ViewCompat.b(this.e, -1);
  }
  
  public boolean b()
  {
    return this.k;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.d.a(paramCanvas);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    removeCallbacks(this.y);
    removeCallbacks(this.x);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.x);
    removeCallbacks(this.y);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    c();
    if ((this.w) && (paramMotionEvent.getAction() == 0)) {
      this.w = false;
    }
    boolean bool1 = bool2;
    if (isEnabled())
    {
      bool1 = bool2;
      if (!this.w)
      {
        bool1 = bool2;
        if (!a()) {
          bool1 = onTouchEvent(paramMotionEvent);
        }
      }
    }
    if (!bool1) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    this.d.b(0, 0, paramInt1, this.t);
    if (getChildCount() == 0) {
      return;
    }
    View localView = getChildAt(0);
    paramInt3 = getPaddingLeft();
    paramInt4 = this.u + getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((getChildCount() > 1) && (!isInEditMode())) {
      throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
    }
    if (getChildCount() > 0) {
      getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return false;
        this.r = 0.0F;
        this.h = MotionEvent.obtain(paramMotionEvent);
        this.n = this.h.getY();
        return false;
      } while ((this.h == null) || (this.w));
      float f3 = paramMotionEvent.getY();
      float f2 = f3 - this.h.getY();
      if (f2 > this.l)
      {
        if (f2 > this.m)
        {
          d();
          return true;
        }
        setTriggerPercentage(this.c.getInterpolation(f2 / this.m));
        float f1 = f2;
        if (this.n > f3) {
          f1 = f2 - this.l;
        }
        a((int)f1);
        if ((this.n > f3) && (this.e.getTop() < this.l))
        {
          removeCallbacks(this.y);
          label196:
          this.n = paramMotionEvent.getY();
        }
      }
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      e();
      break label196;
      if (this.h == null) {
        break;
      }
      this.h.recycle();
      this.h = null;
      return false;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener paramOnRefreshListener)
  {
    this.g = paramOnRefreshListener;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (this.k != paramBoolean)
    {
      c();
      this.r = 0.0F;
      this.k = paramBoolean;
      if (this.k) {
        this.d.a();
      }
    }
    else
    {
      return;
    }
    this.d.b();
  }
}
