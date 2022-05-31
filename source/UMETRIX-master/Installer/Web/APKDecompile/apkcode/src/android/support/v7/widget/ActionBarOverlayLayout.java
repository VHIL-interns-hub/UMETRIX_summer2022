package android.support.v7.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements NestedScrollingParent, DecorContentParent
{
  static final int[] a = { R.attr.actionBarSize, 16842841 };
  private final Runnable A = new ActionBarOverlayLayout.3(this);
  private final NestedScrollingParentHelper B;
  private int b;
  private int c = 0;
  private ContentFrameLayout d;
  private ActionBarContainer e;
  private DecorToolbar f;
  private Drawable g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private int m;
  private int n;
  private final Rect o = new Rect();
  private final Rect p = new Rect();
  private final Rect q = new Rect();
  private final Rect r = new Rect();
  private final Rect s = new Rect();
  private final Rect t = new Rect();
  private ActionBarOverlayLayout.ActionBarVisibilityCallback u;
  private final int v = 600;
  private ScrollerCompat w;
  private ViewPropertyAnimatorCompat x;
  private final ViewPropertyAnimatorListener y = new ActionBarOverlayLayout.1(this);
  private final Runnable z = new ActionBarOverlayLayout.2(this);
  
  public ActionBarOverlayLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    this.B = new NestedScrollingParentHelper(this);
  }
  
  private DecorToolbar a(View paramView)
  {
    if ((paramView instanceof DecorToolbar)) {
      return (DecorToolbar)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    throw new IllegalStateException("Can't make a decor toolbar out of " + paramView.getClass().getSimpleName());
  }
  
  private void a(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(a);
    this.b = localTypedArray.getDimensionPixelSize(0, 0);
    this.g = localTypedArray.getDrawable(1);
    if (this.g == null)
    {
      bool1 = true;
      setWillNotDraw(bool1);
      localTypedArray.recycle();
      if (paramContext.getApplicationInfo().targetSdkVersion >= 19) {
        break label90;
      }
    }
    label90:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.h = bool1;
      this.w = ScrollerCompat.a(paramContext);
      return;
      bool1 = false;
      break;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    this.w.a(0, 0, 0, (int)paramFloat2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    if (this.w.e() > this.e.getHeight()) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool2 = false;
    paramView = (ActionBarOverlayLayout.LayoutParams)paramView.getLayoutParams();
    boolean bool1 = bool2;
    if (paramBoolean1)
    {
      bool1 = bool2;
      if (paramView.leftMargin != paramRect.left)
      {
        paramView.leftMargin = paramRect.left;
        bool1 = true;
      }
    }
    paramBoolean1 = bool1;
    if (paramBoolean2)
    {
      paramBoolean1 = bool1;
      if (paramView.topMargin != paramRect.top)
      {
        paramView.topMargin = paramRect.top;
        paramBoolean1 = true;
      }
    }
    paramBoolean2 = paramBoolean1;
    if (paramBoolean4)
    {
      paramBoolean2 = paramBoolean1;
      if (paramView.rightMargin != paramRect.right)
      {
        paramView.rightMargin = paramRect.right;
        paramBoolean2 = true;
      }
    }
    if ((paramBoolean3) && (paramView.bottomMargin != paramRect.bottom))
    {
      paramView.bottomMargin = paramRect.bottom;
      return true;
    }
    return paramBoolean2;
  }
  
  private void k()
  {
    removeCallbacks(this.z);
    removeCallbacks(this.A);
    if (this.x != null) {
      this.x.b();
    }
  }
  
  private void l()
  {
    k();
    postDelayed(this.z, 600L);
  }
  
  private void m()
  {
    k();
    postDelayed(this.A, 600L);
  }
  
  private void n()
  {
    k();
    this.z.run();
  }
  
  private void o()
  {
    k();
    this.A.run();
  }
  
  public ActionBarOverlayLayout.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new ActionBarOverlayLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    c();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      this.f.f();
      return;
    case 5: 
      this.f.g();
      return;
    }
    setOverlayMode(true);
  }
  
  public void a(Menu paramMenu, MenuPresenter.Callback paramCallback)
  {
    c();
    this.f.a(paramMenu, paramCallback);
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  protected ActionBarOverlayLayout.LayoutParams b()
  {
    return new ActionBarOverlayLayout.LayoutParams(-1, -1);
  }
  
  void c()
  {
    if (this.d == null)
    {
      this.d = ((ContentFrameLayout)findViewById(R.id.action_bar_activity_content));
      this.e = ((ActionBarContainer)findViewById(R.id.action_bar_container));
      this.f = a(findViewById(R.id.action_bar));
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ActionBarOverlayLayout.LayoutParams;
  }
  
  public boolean d()
  {
    c();
    return this.f.h();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.g != null) && (!this.h)) {
      if (this.e.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i1 = (int)(this.e.getBottom() + ViewCompat.i(this.e) + 0.5F);; i1 = 0)
    {
      this.g.setBounds(0, i1, getWidth(), this.g.getIntrinsicHeight() + i1);
      this.g.draw(paramCanvas);
      return;
    }
  }
  
  public boolean e()
  {
    c();
    return this.f.i();
  }
  
  public boolean f()
  {
    c();
    return this.f.j();
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    c();
    if ((ViewCompat.m(this) & 0x100) != 0) {}
    boolean bool = a(this.e, paramRect, true, true, false, true);
    this.r.set(paramRect);
    ViewUtils.a(this, this.r, this.o);
    if (!this.p.equals(this.o))
    {
      this.p.set(this.o);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  public boolean g()
  {
    c();
    return this.f.k();
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ActionBarOverlayLayout.LayoutParams(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    if (this.e != null) {
      return -(int)ViewCompat.i(this.e);
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.B.a();
  }
  
  public CharSequence getTitle()
  {
    c();
    return this.f.e();
  }
  
  public boolean h()
  {
    c();
    return this.f.l();
  }
  
  public void i()
  {
    c();
    this.f.m();
  }
  
  public void j()
  {
    c();
    this.f.n();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    a(getContext());
    ViewCompat.n(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    k();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt3 = getPaddingLeft();
    getPaddingRight();
    paramInt4 = getPaddingTop();
    getPaddingBottom();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        ActionBarOverlayLayout.LayoutParams localLayoutParams = (ActionBarOverlayLayout.LayoutParams)localView.getLayoutParams();
        int i1 = localView.getMeasuredWidth();
        int i2 = localView.getMeasuredHeight();
        int i3 = localLayoutParams.leftMargin + paramInt3;
        int i4 = localLayoutParams.topMargin + paramInt4;
        localView.layout(i3, i4, i1 + i3, i2 + i4);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    c();
    measureChildWithMargins(this.e, paramInt1, 0, paramInt2, 0);
    Object localObject = (ActionBarOverlayLayout.LayoutParams)this.e.getLayoutParams();
    int i6 = Math.max(0, this.e.getMeasuredWidth() + ((ActionBarOverlayLayout.LayoutParams)localObject).leftMargin + ((ActionBarOverlayLayout.LayoutParams)localObject).rightMargin);
    int i1 = this.e.getMeasuredHeight();
    int i2 = ((ActionBarOverlayLayout.LayoutParams)localObject).topMargin;
    int i5 = Math.max(0, ((ActionBarOverlayLayout.LayoutParams)localObject).bottomMargin + (i1 + i2));
    int i4 = ViewUtils.a(0, ViewCompat.h(this.e));
    int i3;
    if ((ViewCompat.m(this) & 0x100) != 0)
    {
      i2 = 1;
      if (i2 == 0) {
        break label448;
      }
      i3 = this.b;
      i1 = i3;
      if (this.j)
      {
        i1 = i3;
        if (this.e.getTabContainer() != null) {
          i1 = i3 + this.b;
        }
      }
    }
    for (;;)
    {
      label153:
      this.q.set(this.o);
      this.s.set(this.r);
      if ((!this.i) && (i2 == 0))
      {
        localObject = this.q;
        ((Rect)localObject).top = (i1 + ((Rect)localObject).top);
        localObject = this.q;
      }
      for (((Rect)localObject).bottom += 0;; ((Rect)localObject).bottom += 0)
      {
        a(this.d, this.q, true, true, true, true);
        if (!this.t.equals(this.s))
        {
          this.t.set(this.s);
          this.d.a(this.s);
        }
        measureChildWithMargins(this.d, paramInt1, 0, paramInt2, 0);
        localObject = (ActionBarOverlayLayout.LayoutParams)this.d.getLayoutParams();
        i1 = Math.max(i6, this.d.getMeasuredWidth() + ((ActionBarOverlayLayout.LayoutParams)localObject).leftMargin + ((ActionBarOverlayLayout.LayoutParams)localObject).rightMargin);
        i2 = this.d.getMeasuredHeight();
        i3 = ((ActionBarOverlayLayout.LayoutParams)localObject).topMargin;
        i2 = Math.max(i5, ((ActionBarOverlayLayout.LayoutParams)localObject).bottomMargin + (i2 + i3));
        i3 = ViewUtils.a(i4, ViewCompat.h(this.d));
        i4 = getPaddingLeft();
        i5 = getPaddingRight();
        i2 = Math.max(i2 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(ViewCompat.a(Math.max(i1 + (i4 + i5), getSuggestedMinimumWidth()), paramInt1, i3), ViewCompat.a(i2, paramInt2, i3 << 16));
        return;
        i2 = 0;
        break;
        label448:
        if (this.e.getVisibility() == 8) {
          break label510;
        }
        i1 = this.e.getMeasuredHeight();
        break label153;
        localObject = this.s;
        ((Rect)localObject).top = (i1 + ((Rect)localObject).top);
        localObject = this.s;
      }
      label510:
      i1 = 0;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((!this.k) || (!paramBoolean)) {
      return false;
    }
    if (a(paramFloat1, paramFloat2)) {
      o();
    }
    for (;;)
    {
      this.l = true;
      return true;
      n();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.m += paramInt2;
    setActionBarHideOffset(this.m);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.B.a(paramView1, paramView2, paramInt);
    this.m = getActionBarHideOffset();
    k();
    if (this.u != null) {
      this.u.p();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (this.e.getVisibility() != 0)) {
      return false;
    }
    return this.k;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.k) && (!this.l))
    {
      if (this.m > this.e.getHeight()) {
        break label49;
      }
      l();
    }
    for (;;)
    {
      if (this.u != null) {
        this.u.q();
      }
      return;
      label49:
      m();
    }
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    c();
    int i3 = this.n;
    this.n = paramInt;
    int i1;
    int i2;
    if ((paramInt & 0x4) == 0)
    {
      i1 = 1;
      if ((paramInt & 0x100) == 0) {
        break label120;
      }
      i2 = 1;
      label49:
      if (this.u != null)
      {
        ActionBarOverlayLayout.ActionBarVisibilityCallback localActionBarVisibilityCallback = this.u;
        if (i2 != 0) {
          break label125;
        }
        label66:
        localActionBarVisibilityCallback.g(bool);
        if ((i1 == 0) && (i2 != 0)) {
          break label131;
        }
        this.u.n();
      }
    }
    for (;;)
    {
      if ((((i3 ^ paramInt) & 0x100) != 0) && (this.u != null)) {
        ViewCompat.n(this);
      }
      return;
      i1 = 0;
      break;
      label120:
      i2 = 0;
      break label49;
      label125:
      bool = false;
      break label66;
      label131:
      this.u.o();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.c = paramInt;
    if (this.u != null) {
      this.u.c(paramInt);
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    k();
    paramInt = Math.max(0, Math.min(paramInt, this.e.getHeight()));
    ViewCompat.a(this.e, -paramInt);
  }
  
  public void setActionBarVisibilityCallback(ActionBarOverlayLayout.ActionBarVisibilityCallback paramActionBarVisibilityCallback)
  {
    this.u = paramActionBarVisibilityCallback;
    if (getWindowToken() != null)
    {
      this.u.c(this.c);
      if (this.n != 0)
      {
        onWindowSystemUiVisibilityChanged(this.n);
        ViewCompat.n(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.k)
    {
      this.k = paramBoolean;
      if (!paramBoolean)
      {
        k();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    c();
    this.f.a(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    c();
    this.f.a(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    c();
    this.f.b(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.h = paramBoolean;
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    c();
    this.f.a(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    c();
    this.f.a(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}
