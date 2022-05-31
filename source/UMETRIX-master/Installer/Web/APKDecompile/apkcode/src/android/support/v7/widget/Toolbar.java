package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private boolean A;
  private final ArrayList B = new ArrayList();
  private final ArrayList C = new ArrayList();
  private final int[] D = new int[2];
  private Toolbar.OnMenuItemClickListener E;
  private final ActionMenuView.OnMenuItemClickListener F = new Toolbar.1(this);
  private ToolbarWidgetWrapper G;
  private ActionMenuPresenter H;
  private Toolbar.ExpandedActionViewMenuPresenter I;
  private MenuPresenter.Callback J;
  private MenuBuilder.Callback K;
  private boolean L;
  private final Runnable M = new Toolbar.2(this);
  private final AppCompatDrawableManager N;
  View a;
  private ActionMenuView b;
  private TextView c;
  private TextView d;
  private ImageButton e;
  private ImageView f;
  private Drawable g;
  private CharSequence h;
  private ImageButton i;
  private Context j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private final RtlSpacingHelper t = new RtlSpacingHelper();
  private int u = 8388627;
  private CharSequence v;
  private CharSequence w;
  private int x;
  private int y;
  private boolean z;
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TintTypedArray.a(getContext(), paramAttributeSet, R.styleable.Toolbar, paramInt, 0);
    this.l = paramContext.g(R.styleable.Toolbar_titleTextAppearance, 0);
    this.m = paramContext.g(R.styleable.Toolbar_subtitleTextAppearance, 0);
    this.u = paramContext.c(R.styleable.Toolbar_android_gravity, this.u);
    this.n = 48;
    paramInt = paramContext.d(R.styleable.Toolbar_titleMargins, 0);
    this.s = paramInt;
    this.r = paramInt;
    this.q = paramInt;
    this.p = paramInt;
    paramInt = paramContext.d(R.styleable.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      this.p = paramInt;
    }
    paramInt = paramContext.d(R.styleable.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      this.q = paramInt;
    }
    paramInt = paramContext.d(R.styleable.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      this.r = paramInt;
    }
    paramInt = paramContext.d(R.styleable.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      this.s = paramInt;
    }
    this.o = paramContext.e(R.styleable.Toolbar_maxButtonHeight, -1);
    paramInt = paramContext.d(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
    int i1 = paramContext.d(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
    int i2 = paramContext.e(R.styleable.Toolbar_contentInsetLeft, 0);
    int i3 = paramContext.e(R.styleable.Toolbar_contentInsetRight, 0);
    this.t.b(i2, i3);
    if ((paramInt != Integer.MIN_VALUE) || (i1 != Integer.MIN_VALUE)) {
      this.t.a(paramInt, i1);
    }
    this.g = paramContext.a(R.styleable.Toolbar_collapseIcon);
    this.h = paramContext.c(R.styleable.Toolbar_collapseContentDescription);
    paramAttributeSet = paramContext.c(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.c(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.j = getContext();
    setPopupTheme(paramContext.g(R.styleable.Toolbar_popupTheme, 0));
    paramAttributeSet = paramContext.a(R.styleable.Toolbar_navigationIcon);
    if (paramAttributeSet != null) {
      setNavigationIcon(paramAttributeSet);
    }
    paramAttributeSet = paramContext.c(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setNavigationContentDescription(paramAttributeSet);
    }
    paramAttributeSet = paramContext.a(R.styleable.Toolbar_logo);
    if (paramAttributeSet != null) {
      setLogo(paramAttributeSet);
    }
    paramAttributeSet = paramContext.c(R.styleable.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setLogoDescription(paramAttributeSet);
    }
    if (paramContext.f(R.styleable.Toolbar_titleTextColor)) {
      setTitleTextColor(paramContext.b(R.styleable.Toolbar_titleTextColor, -1));
    }
    if (paramContext.f(R.styleable.Toolbar_subtitleTextColor)) {
      setSubtitleTextColor(paramContext.b(R.styleable.Toolbar_subtitleTextColor, -1));
    }
    paramContext.a();
    this.N = AppCompatDrawableManager.a();
  }
  
  private int a(int paramInt)
  {
    int i1 = paramInt & 0x70;
    paramInt = i1;
    switch (i1)
    {
    default: 
      paramInt = this.u & 0x70;
    }
    return paramInt;
  }
  
  private int a(View paramView, int paramInt)
  {
    Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)paramView.getLayoutParams();
    int i2 = paramView.getMeasuredHeight();
    int i1;
    int i3;
    int i4;
    if (paramInt > 0)
    {
      paramInt = (i2 - paramInt) / 2;
      switch (a(localLayoutParams.a))
      {
      default: 
        i1 = getPaddingTop();
        i3 = getPaddingBottom();
        i4 = getHeight();
        paramInt = (i4 - i1 - i3 - i2) / 2;
        if (paramInt < localLayoutParams.topMargin) {
          paramInt = localLayoutParams.topMargin;
        }
        break;
      }
    }
    for (;;)
    {
      return paramInt + i1;
      paramInt = 0;
      break;
      return getPaddingTop() - paramInt;
      return getHeight() - getPaddingBottom() - i2 - localLayoutParams.bottomMargin - paramInt;
      i2 = i4 - i3 - i2 - paramInt - i1;
      if (i2 < localLayoutParams.bottomMargin) {
        paramInt = Math.max(0, paramInt - (localLayoutParams.bottomMargin - i2));
      }
    }
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int i2 = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int i3 = Math.max(0, i1) + Math.max(0, i2);
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramArrayOfInt[1] = Math.max(0, -i2);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + i3 + paramInt2, localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    return paramView.getMeasuredWidth() + i3;
  }
  
  private int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)paramView.getLayoutParams();
    int i1 = localLayoutParams.leftMargin - paramArrayOfInt[0];
    paramInt1 = Math.max(0, i1) + paramInt1;
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramInt2 = a(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i1, paramView.getMeasuredHeight() + paramInt2);
    return localLayoutParams.rightMargin + i1 + paramInt1;
  }
  
  private int a(List paramList, int[] paramArrayOfInt)
  {
    int i4 = paramArrayOfInt[0];
    int i3 = paramArrayOfInt[1];
    int i5 = paramList.size();
    int i2 = 0;
    int i1 = 0;
    while (i2 < i5)
    {
      paramArrayOfInt = (View)paramList.get(i2);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)paramArrayOfInt.getLayoutParams();
      i4 = localLayoutParams.leftMargin - i4;
      i3 = localLayoutParams.rightMargin - i3;
      int i6 = Math.max(0, i4);
      int i7 = Math.max(0, i3);
      i4 = Math.max(0, -i4);
      i3 = Math.max(0, -i3);
      int i8 = paramArrayOfInt.getMeasuredWidth();
      i2 += 1;
      i1 += i8 + i6 + i7;
    }
    return i1;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824)
    {
      paramInt1 = paramInt2;
      if (paramInt5 >= 0)
      {
        paramInt1 = paramInt5;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt5);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i1, paramInt1);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = i();
    }
    for (;;)
    {
      ((Toolbar.LayoutParams)localObject).b = 1;
      if ((!paramBoolean) || (this.a == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.C.add(paramView);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = a((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (Toolbar.LayoutParams)localObject;
      }
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void a(List paramList, int paramInt)
  {
    int i1 = 1;
    int i2 = 0;
    if (ViewCompat.e(this) == 1) {}
    int i4;
    int i3;
    View localView;
    Toolbar.LayoutParams localLayoutParams;
    for (;;)
    {
      i4 = getChildCount();
      i3 = GravityCompat.a(paramInt, ViewCompat.e(this));
      paramList.clear();
      paramInt = i2;
      if (i1 == 0) {
        break;
      }
      paramInt = i4 - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localLayoutParams = (Toolbar.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.b == 0) && (a(localView)) && (b(localLayoutParams.a) == i3)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
      i1 = 0;
    }
    while (paramInt < i4)
    {
      localView = getChildAt(paramInt);
      localLayoutParams = (Toolbar.LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams.b == 0) && (a(localView)) && (b(localLayoutParams.a) == i3)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private boolean a(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private int b(int paramInt)
  {
    int i2 = ViewCompat.e(this);
    int i1 = GravityCompat.a(paramInt, i2) & 0x7;
    paramInt = i1;
    switch (i1)
    {
    case 2: 
    case 4: 
    default: 
      if (i2 == 1) {
        paramInt = 5;
      }
      break;
    case 1: 
    case 3: 
    case 5: 
      return paramInt;
    }
    return 3;
  }
  
  private int b(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = MarginLayoutParamsCompat.a(paramView);
    return MarginLayoutParamsCompat.b(paramView) + i1;
  }
  
  private int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)paramView.getLayoutParams();
    int i1 = localLayoutParams.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i1);
    paramArrayOfInt[1] = Math.max(0, -i1);
    paramInt2 = a(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i1, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (localLayoutParams.leftMargin + i1);
  }
  
  private int c(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = paramView.topMargin;
    return paramView.bottomMargin + i1;
  }
  
  private boolean d(View paramView)
  {
    return (paramView.getParent() == this) || (this.C.contains(paramView));
  }
  
  private MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(getContext());
  }
  
  private void l()
  {
    if (this.f == null) {
      this.f = new ImageView(getContext());
    }
  }
  
  private void m()
  {
    n();
    if (this.b.d() == null)
    {
      MenuBuilder localMenuBuilder = (MenuBuilder)this.b.getMenu();
      if (this.I == null) {
        this.I = new Toolbar.ExpandedActionViewMenuPresenter(this, null);
      }
      this.b.setExpandedActionViewsExclusive(true);
      localMenuBuilder.a(this.I, this.j);
    }
  }
  
  private void n()
  {
    if (this.b == null)
    {
      this.b = new ActionMenuView(getContext());
      this.b.setPopupTheme(this.k);
      this.b.setOnMenuItemClickListener(this.F);
      this.b.a(this.J, this.K);
      Toolbar.LayoutParams localLayoutParams = i();
      localLayoutParams.a = (0x800005 | this.n & 0x70);
      this.b.setLayoutParams(localLayoutParams);
      a(this.b, false);
    }
  }
  
  private void o()
  {
    if (this.e == null)
    {
      this.e = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      Toolbar.LayoutParams localLayoutParams = i();
      localLayoutParams.a = (0x800003 | this.n & 0x70);
      this.e.setLayoutParams(localLayoutParams);
    }
  }
  
  private void p()
  {
    if (this.i == null)
    {
      this.i = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      this.i.setImageDrawable(this.g);
      this.i.setContentDescription(this.h);
      Toolbar.LayoutParams localLayoutParams = i();
      localLayoutParams.a = (0x800003 | this.n & 0x70);
      localLayoutParams.b = 2;
      this.i.setLayoutParams(localLayoutParams);
      this.i.setOnClickListener(new Toolbar.3(this));
    }
  }
  
  private void q()
  {
    removeCallbacks(this.M);
    post(this.M);
  }
  
  private boolean r()
  {
    if (!this.L) {
      return false;
    }
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label56;
      }
      View localView = getChildAt(i1);
      if ((a(localView)) && (localView.getMeasuredWidth() > 0) && (localView.getMeasuredHeight() > 0)) {
        break;
      }
      i1 += 1;
    }
    label56:
    return true;
  }
  
  public Toolbar.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new Toolbar.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected Toolbar.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof Toolbar.LayoutParams)) {
      return new Toolbar.LayoutParams((Toolbar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams)) {
      return new Toolbar.LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new Toolbar.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new Toolbar.LayoutParams(paramLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.t.a(paramInt1, paramInt2);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    this.l = paramInt;
    if (this.c != null) {
      this.c.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void a(MenuBuilder paramMenuBuilder, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramMenuBuilder == null) && (this.b == null)) {}
    MenuBuilder localMenuBuilder;
    do
    {
      return;
      n();
      localMenuBuilder = this.b.d();
    } while (localMenuBuilder == paramMenuBuilder);
    if (localMenuBuilder != null)
    {
      localMenuBuilder.b(this.H);
      localMenuBuilder.b(this.I);
    }
    if (this.I == null) {
      this.I = new Toolbar.ExpandedActionViewMenuPresenter(this, null);
    }
    paramActionMenuPresenter.d(true);
    if (paramMenuBuilder != null)
    {
      paramMenuBuilder.a(paramActionMenuPresenter, this.j);
      paramMenuBuilder.a(this.I, this.j);
    }
    for (;;)
    {
      this.b.setPopupTheme(this.k);
      this.b.setPresenter(paramActionMenuPresenter);
      this.H = paramActionMenuPresenter;
      return;
      paramActionMenuPresenter.a(this.j, null);
      this.I.a(this.j, null);
      paramActionMenuPresenter.b(true);
      this.I.b(true);
    }
  }
  
  public void a(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.J = paramCallback;
    this.K = paramCallback1;
    if (this.b != null) {
      this.b.a(paramCallback, paramCallback1);
    }
  }
  
  public boolean a()
  {
    return (getVisibility() == 0) && (this.b != null) && (this.b.a());
  }
  
  public void b(Context paramContext, int paramInt)
  {
    this.m = paramInt;
    if (this.d != null) {
      this.d.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public boolean b()
  {
    return (this.b != null) && (this.b.g());
  }
  
  public boolean c()
  {
    return (this.b != null) && (this.b.h());
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof Toolbar.LayoutParams));
  }
  
  public boolean d()
  {
    return (this.b != null) && (this.b.e());
  }
  
  public boolean e()
  {
    return (this.b != null) && (this.b.f());
  }
  
  public void f()
  {
    if (this.b != null) {
      this.b.i();
    }
  }
  
  public boolean g()
  {
    return (this.I != null) && (this.I.b != null);
  }
  
  public int getContentInsetEnd()
  {
    return this.t.d();
  }
  
  public int getContentInsetLeft()
  {
    return this.t.a();
  }
  
  public int getContentInsetRight()
  {
    return this.t.b();
  }
  
  public int getContentInsetStart()
  {
    return this.t.c();
  }
  
  public Drawable getLogo()
  {
    if (this.f != null) {
      return this.f.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    if (this.f != null) {
      return this.f.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    m();
    return this.b.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    if (this.e != null) {
      return this.e.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    if (this.e != null) {
      return this.e.getDrawable();
    }
    return null;
  }
  
  public Drawable getOverflowIcon()
  {
    m();
    return this.b.getOverflowIcon();
  }
  
  public int getPopupTheme()
  {
    return this.k;
  }
  
  public CharSequence getSubtitle()
  {
    return this.w;
  }
  
  public CharSequence getTitle()
  {
    return this.v;
  }
  
  public DecorToolbar getWrapper()
  {
    if (this.G == null) {
      this.G = new ToolbarWidgetWrapper(this, true);
    }
    return this.G;
  }
  
  public void h()
  {
    if (this.I == null) {}
    for (MenuItemImpl localMenuItemImpl = null;; localMenuItemImpl = this.I.b)
    {
      if (localMenuItemImpl != null) {
        localMenuItemImpl.collapseActionView();
      }
      return;
    }
  }
  
  protected Toolbar.LayoutParams i()
  {
    return new Toolbar.LayoutParams(-2, -2);
  }
  
  void j()
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = getChildAt(i1);
      if ((((Toolbar.LayoutParams)localView.getLayoutParams()).b != 2) && (localView != this.b))
      {
        removeViewAt(i1);
        this.C.add(localView);
      }
      i1 -= 1;
    }
  }
  
  void k()
  {
    int i1 = this.C.size() - 1;
    while (i1 >= 0)
    {
      addView((View)this.C.get(i1));
      i1 -= 1;
    }
    this.C.clear();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.M);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.a(paramMotionEvent);
    if (i1 == 9) {
      this.A = false;
    }
    if (!this.A)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i1 == 9) && (!bool)) {
        this.A = true;
      }
    }
    if ((i1 == 10) || (i1 == 3)) {
      this.A = false;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3;
    int i6;
    int i9;
    int i1;
    int i7;
    int i8;
    int i10;
    int[] arrayOfInt;
    int i5;
    if (ViewCompat.e(this) == 1)
    {
      i3 = 1;
      i6 = getWidth();
      i9 = getHeight();
      i1 = getPaddingLeft();
      i7 = getPaddingRight();
      i8 = getPaddingTop();
      i10 = getPaddingBottom();
      paramInt4 = i6 - i7;
      arrayOfInt = this.D;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      i5 = ViewCompat.j(this);
      if (!a(this.e)) {
        break label1565;
      }
      if (i3 == 0) {
        break label876;
      }
      paramInt4 = b(this.e, paramInt4, arrayOfInt, i5);
      paramInt1 = i1;
    }
    for (;;)
    {
      label111:
      paramInt2 = paramInt4;
      paramInt3 = paramInt1;
      if (a(this.i))
      {
        if (i3 != 0)
        {
          paramInt2 = b(this.i, paramInt4, arrayOfInt, i5);
          paramInt3 = paramInt1;
        }
      }
      else
      {
        label151:
        paramInt1 = paramInt2;
        paramInt4 = paramInt3;
        if (a(this.b))
        {
          if (i3 == 0) {
            break label915;
          }
          paramInt4 = a(this.b, paramInt3, arrayOfInt, i5);
          paramInt1 = paramInt2;
        }
        label191:
        arrayOfInt[0] = Math.max(0, getContentInsetLeft() - paramInt4);
        arrayOfInt[1] = Math.max(0, getContentInsetRight() - (i6 - i7 - paramInt1));
        paramInt3 = Math.max(paramInt4, getContentInsetLeft());
        paramInt4 = Math.min(paramInt1, i6 - i7 - getContentInsetRight());
        paramInt2 = paramInt4;
        paramInt1 = paramInt3;
        if (a(this.a))
        {
          if (i3 == 0) {
            break label936;
          }
          paramInt2 = b(this.a, paramInt4, arrayOfInt, i5);
          paramInt1 = paramInt3;
        }
        label293:
        if (!a(this.f)) {
          break label1559;
        }
        if (i3 == 0) {
          break label957;
        }
        paramInt2 = b(this.f, paramInt2, arrayOfInt, i5);
        paramInt3 = paramInt1;
      }
      for (;;)
      {
        label326:
        paramBoolean = a(this.c);
        boolean bool = a(this.d);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (Toolbar.LayoutParams)this.c.getLayoutParams();
          paramInt1 = ((Toolbar.LayoutParams)localObject1).topMargin;
          paramInt4 = this.c.getMeasuredHeight();
          paramInt1 = 0 + (((Toolbar.LayoutParams)localObject1).bottomMargin + (paramInt1 + paramInt4));
        }
        int i2;
        if (bool)
        {
          localObject1 = (Toolbar.LayoutParams)this.d.getLayoutParams();
          paramInt4 = ((Toolbar.LayoutParams)localObject1).topMargin;
          i2 = this.d.getMeasuredHeight();
        }
        for (int i4 = ((Toolbar.LayoutParams)localObject1).bottomMargin + (paramInt4 + i2) + paramInt1;; i4 = paramInt1)
        {
          label464:
          Object localObject2;
          if (!paramBoolean)
          {
            paramInt4 = paramInt2;
            paramInt1 = paramInt3;
            if (!bool) {}
          }
          else
          {
            if (!paramBoolean) {
              break label975;
            }
            localObject1 = this.c;
            if (!bool) {
              break label984;
            }
            localObject2 = this.d;
            label475:
            localObject1 = (Toolbar.LayoutParams)((View)localObject1).getLayoutParams();
            localObject2 = (Toolbar.LayoutParams)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.c.getMeasuredWidth() <= 0)) && ((!bool) || (this.d.getMeasuredWidth() <= 0))) {
              break label993;
            }
            i2 = 1;
            label527:
            switch (this.u & 0x70)
            {
            default: 
              paramInt1 = (i9 - i8 - i10 - i4) / 2;
              if (paramInt1 < ((Toolbar.LayoutParams)localObject1).topMargin + this.r) {
                paramInt1 = ((Toolbar.LayoutParams)localObject1).topMargin + this.r;
              }
              break;
            }
          }
          label599:
          label604:
          label620:
          label876:
          label915:
          label936:
          label957:
          label975:
          label984:
          label993:
          label1113:
          label1527:
          label1544:
          label1550:
          for (;;)
          {
            paramInt1 = i8 + paramInt1;
            if (i3 != 0) {
              if (i2 != 0)
              {
                paramInt4 = this.p;
                paramInt4 -= arrayOfInt[1];
                paramInt2 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1544;
                }
                localObject1 = (Toolbar.LayoutParams)this.c.getLayoutParams();
                paramInt4 = paramInt2 - this.c.getMeasuredWidth();
                i3 = this.c.getMeasuredHeight() + paramInt1;
                this.c.layout(paramInt4, paramInt1, paramInt2, i3);
                i4 = this.q;
                paramInt1 = i3 + ((Toolbar.LayoutParams)localObject1).bottomMargin;
                paramInt4 -= i4;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (Toolbar.LayoutParams)this.d.getLayoutParams();
                paramInt1 = ((Toolbar.LayoutParams)localObject1).topMargin + paramInt1;
                i3 = this.d.getMeasuredWidth();
                i4 = this.d.getMeasuredHeight() + paramInt1;
                this.d.layout(paramInt2 - i3, paramInt1, paramInt2, i4);
                paramInt1 = this.q;
                i3 = ((Toolbar.LayoutParams)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt2 - paramInt1;; paramInt1 = paramInt2)
              {
                if (i2 != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt2)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt3;
                  a(this.B, 3);
                  paramInt3 = this.B.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)this.B.get(paramInt2), paramInt1, arrayOfInt, i5);
                      paramInt2 += 1;
                      continue;
                      i3 = 0;
                      break;
                      paramInt1 = a(this.e, i1, arrayOfInt, i5);
                      break label111;
                      paramInt3 = a(this.i, paramInt1, arrayOfInt, i5);
                      paramInt2 = paramInt4;
                      break label151;
                      paramInt1 = b(this.b, paramInt2, arrayOfInt, i5);
                      paramInt4 = paramInt3;
                      break label191;
                      paramInt1 = a(this.a, paramInt3, arrayOfInt, i5);
                      paramInt2 = paramInt4;
                      break label293;
                      paramInt3 = a(this.f, paramInt1, arrayOfInt, i5);
                      break label326;
                      localObject1 = this.d;
                      break label464;
                      localObject2 = this.c;
                      break label475;
                      i2 = 0;
                      break label527;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((Toolbar.LayoutParams)localObject1).topMargin + paramInt1 + this.r;
                      break label604;
                      paramInt4 = i9 - i10 - i4 - paramInt1 - i8;
                      if (paramInt4 >= ((Toolbar.LayoutParams)localObject1).bottomMargin + this.s) {
                        break label1550;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((Toolbar.LayoutParams)localObject2).bottomMargin + this.s - paramInt4));
                      break label599;
                      paramInt1 = i9 - i10 - ((Toolbar.LayoutParams)localObject2).bottomMargin - this.s - i4;
                      break label604;
                      paramInt4 = 0;
                      break label620;
                      if (i2 != 0)
                      {
                        paramInt4 = this.p;
                        paramInt4 -= arrayOfInt[0];
                        paramInt3 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1527;
                        }
                        localObject1 = (Toolbar.LayoutParams)this.c.getLayoutParams();
                        i3 = this.c.getMeasuredWidth() + paramInt3;
                        paramInt4 = this.c.getMeasuredHeight() + paramInt1;
                        this.c.layout(paramInt3, paramInt1, i3, paramInt4);
                        i4 = this.q;
                        paramInt1 = ((Toolbar.LayoutParams)localObject1).bottomMargin;
                        i3 += i4;
                        paramInt1 += paramInt4;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (bool)
                    {
                      localObject1 = (Toolbar.LayoutParams)this.d.getLayoutParams();
                      paramInt4 = paramInt1 + ((Toolbar.LayoutParams)localObject1).topMargin;
                      paramInt1 = this.d.getMeasuredWidth() + paramInt3;
                      i4 = this.d.getMeasuredHeight() + paramInt4;
                      this.d.layout(paramInt3, paramInt4, paramInt1, i4);
                      paramInt4 = this.q;
                      i4 = ((Toolbar.LayoutParams)localObject1).bottomMargin;
                    }
                    for (i4 = paramInt4 + paramInt1;; i4 = paramInt3)
                    {
                      paramInt4 = paramInt2;
                      paramInt1 = paramInt3;
                      if (i2 == 0) {
                        break;
                      }
                      paramInt1 = Math.max(i3, i4);
                      paramInt4 = paramInt2;
                      break;
                      paramInt4 = 0;
                      break label1113;
                      a(this.B, 5);
                      paramInt3 = this.B.size();
                      paramInt2 = 0;
                      while (paramInt2 < paramInt3)
                      {
                        paramInt4 = b((View)this.B.get(paramInt2), paramInt4, arrayOfInt, i5);
                        paramInt2 += 1;
                      }
                      a(this.B, 1);
                      paramInt3 = a(this.B, arrayOfInt);
                      paramInt2 = (i6 - i1 - i7) / 2 + i1 - paramInt3 / 2;
                      paramInt3 += paramInt2;
                      if (paramInt2 < paramInt1) {}
                      for (;;)
                      {
                        paramInt4 = this.B.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)this.B.get(paramInt1), paramInt2, arrayOfInt, i5);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt2;
                        if (paramInt3 > paramInt4) {
                          paramInt1 = paramInt2 - (paramInt3 - paramInt4);
                        }
                      }
                      this.B.clear();
                      return;
                    }
                    i3 = paramInt3;
                  }
                }
              }
              paramInt4 = paramInt2;
            }
          }
        }
        label1559:
        paramInt3 = paramInt1;
      }
      label1565:
      paramInt1 = i1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = 0;
    int i3 = 0;
    int[] arrayOfInt = this.D;
    int i5;
    int i6;
    int i1;
    int i7;
    int i2;
    int i8;
    label529:
    View localView;
    if (ViewUtils.a(this))
    {
      i5 = 0;
      i6 = 1;
      i1 = 0;
      if (a(this.e))
      {
        a(this.e, paramInt1, 0, paramInt2, 0, this.o);
        i1 = this.e.getMeasuredWidth() + b(this.e);
        i4 = Math.max(0, this.e.getMeasuredHeight() + c(this.e));
        i3 = ViewUtils.a(0, ViewCompat.h(this.e));
      }
      i7 = i1;
      i1 = i3;
      i2 = i4;
      if (a(this.i))
      {
        a(this.i, paramInt1, 0, paramInt2, 0, this.o);
        i7 = this.i.getMeasuredWidth() + b(this.i);
        i2 = Math.max(i4, this.i.getMeasuredHeight() + c(this.i));
        i1 = ViewUtils.a(i3, ViewCompat.h(this.i));
      }
      i3 = getContentInsetStart();
      i8 = 0 + Math.max(i3, i7);
      arrayOfInt[i6] = Math.max(0, i3 - i7);
      i6 = 0;
      i3 = i1;
      i4 = i2;
      if (a(this.b))
      {
        a(this.b, paramInt1, i8, paramInt2, 0, this.o);
        i6 = this.b.getMeasuredWidth() + b(this.b);
        i4 = Math.max(i2, this.b.getMeasuredHeight() + c(this.b));
        i3 = ViewUtils.a(i1, ViewCompat.h(this.b));
      }
      i1 = getContentInsetEnd();
      i7 = i8 + Math.max(i1, i6);
      arrayOfInt[i5] = Math.max(0, i1 - i6);
      i6 = i7;
      i1 = i3;
      i2 = i4;
      if (a(this.a))
      {
        i6 = i7 + a(this.a, paramInt1, i7, paramInt2, 0, arrayOfInt);
        i2 = Math.max(i4, this.a.getMeasuredHeight() + c(this.a));
        i1 = ViewUtils.a(i3, ViewCompat.h(this.a));
      }
      i3 = i6;
      i4 = i1;
      i5 = i2;
      if (a(this.f))
      {
        i3 = i6 + a(this.f, paramInt1, i6, paramInt2, 0, arrayOfInt);
        i5 = Math.max(i2, this.f.getMeasuredHeight() + c(this.f));
        i4 = ViewUtils.a(i1, ViewCompat.h(this.f));
      }
      i7 = getChildCount();
      i6 = 0;
      i2 = i5;
      i1 = i4;
      i4 = i6;
      i6 = i3;
      if (i4 >= i7) {
        break label635;
      }
      localView = getChildAt(i4);
      if (((Toolbar.LayoutParams)localView.getLayoutParams()).b != 0) {
        break label938;
      }
      if (a(localView)) {
        break label585;
      }
    }
    label585:
    label635:
    label938:
    for (;;)
    {
      i4 += 1;
      break label529;
      i5 = 1;
      i6 = 0;
      break;
      i6 += a(localView, paramInt1, i6, paramInt2, 0, arrayOfInt);
      i2 = Math.max(i2, localView.getMeasuredHeight() + c(localView));
      i1 = ViewUtils.a(i1, ViewCompat.h(localView));
      continue;
      i5 = 0;
      i4 = 0;
      int i9 = this.r + this.s;
      int i10 = this.p + this.q;
      i3 = i1;
      if (a(this.c))
      {
        a(this.c, paramInt1, i6 + i10, paramInt2, i9, arrayOfInt);
        i3 = this.c.getMeasuredWidth();
        i5 = b(this.c) + i3;
        i4 = this.c.getMeasuredHeight() + c(this.c);
        i3 = ViewUtils.a(i1, ViewCompat.h(this.c));
      }
      i8 = i4;
      i7 = i5;
      i1 = i3;
      if (a(this.d))
      {
        i7 = Math.max(i5, a(this.d, paramInt1, i6 + i10, paramInt2, i9 + i4, arrayOfInt));
        i8 = i4 + (this.d.getMeasuredHeight() + c(this.d));
        i1 = ViewUtils.a(i3, ViewCompat.h(this.d));
      }
      i2 = Math.max(i2, i8);
      i5 = getPaddingLeft();
      i8 = getPaddingRight();
      i3 = getPaddingTop();
      i4 = getPaddingBottom();
      i5 = ViewCompat.a(Math.max(i7 + i6 + (i5 + i8), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i1);
      paramInt1 = ViewCompat.a(Math.max(i2 + (i3 + i4), getSuggestedMinimumHeight()), paramInt2, i1 << 16);
      if (r()) {
        paramInt1 = 0;
      }
      setMeasuredDimension(i5, paramInt1);
      return;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    Toolbar.SavedState localSavedState = (Toolbar.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (this.b != null) {}
    for (paramParcelable = this.b.d();; paramParcelable = null)
    {
      if ((localSavedState.a != 0) && (this.I != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(localSavedState.a);
        if (paramParcelable != null) {
          MenuItemCompat.b(paramParcelable);
        }
      }
      if (localSavedState.b) {
        q();
      }
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    RtlSpacingHelper localRtlSpacingHelper = this.t;
    if (paramInt == 1) {}
    for (;;)
    {
      localRtlSpacingHelper.a(bool);
      return;
      bool = false;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Toolbar.SavedState localSavedState = new Toolbar.SavedState(super.onSaveInstanceState());
    if ((this.I != null) && (this.I.b != null)) {
      localSavedState.a = this.I.b.getItemId();
    }
    localSavedState.b = b();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.a(paramMotionEvent);
    if (i1 == 0) {
      this.z = false;
    }
    if (!this.z)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i1 == 0) && (!bool)) {
        this.z = true;
      }
    }
    if ((i1 == 1) || (i1 == 3)) {
      this.z = false;
    }
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.L = paramBoolean;
    requestLayout();
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(this.N.a(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      l();
      if (!d(this.f)) {
        a(this.f, true);
      }
    }
    for (;;)
    {
      if (this.f != null) {
        this.f.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.f != null) && (d(this.f)))
      {
        removeView(this.f);
        this.C.remove(this.f);
      }
    }
  }
  
  public void setLogoDescription(int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      l();
    }
    if (this.f != null) {
      this.f.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getContext().getText(paramInt);; localCharSequence = null)
    {
      setNavigationContentDescription(localCharSequence);
      return;
    }
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      o();
    }
    if (this.e != null) {
      this.e.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(this.N.a(getContext(), paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      o();
      if (!d(this.e)) {
        a(this.e, true);
      }
    }
    for (;;)
    {
      if (this.e != null) {
        this.e.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.e != null) && (d(this.e)))
      {
        removeView(this.e);
        this.C.remove(this.e);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    o();
    this.e.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.E = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    m();
    this.b.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.k != paramInt)
    {
      this.k = paramInt;
      if (paramInt == 0) {
        this.j = getContext();
      }
    }
    else
    {
      return;
    }
    this.j = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.d == null)
      {
        Context localContext = getContext();
        this.d = new TextView(localContext);
        this.d.setSingleLine();
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        if (this.m != 0) {
          this.d.setTextAppearance(localContext, this.m);
        }
        if (this.y != 0) {
          this.d.setTextColor(this.y);
        }
      }
      if (!d(this.d)) {
        a(this.d, true);
      }
    }
    for (;;)
    {
      if (this.d != null) {
        this.d.setText(paramCharSequence);
      }
      this.w = paramCharSequence;
      return;
      if ((this.d != null) && (d(this.d)))
      {
        removeView(this.d);
        this.C.remove(this.d);
      }
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    this.y = paramInt;
    if (this.d != null) {
      this.d.setTextColor(paramInt);
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.c == null)
      {
        Context localContext = getContext();
        this.c = new TextView(localContext);
        this.c.setSingleLine();
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        if (this.l != 0) {
          this.c.setTextAppearance(localContext, this.l);
        }
        if (this.x != 0) {
          this.c.setTextColor(this.x);
        }
      }
      if (!d(this.c)) {
        a(this.c, true);
      }
    }
    for (;;)
    {
      if (this.c != null) {
        this.c.setText(paramCharSequence);
      }
      this.v = paramCharSequence;
      return;
      if ((this.c != null) && (d(this.c)))
      {
        removeView(this.c);
        this.C.remove(this.c);
      }
    }
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.x = paramInt;
    if (this.c != null) {
      this.c.setTextColor(paramInt);
    }
  }
}
