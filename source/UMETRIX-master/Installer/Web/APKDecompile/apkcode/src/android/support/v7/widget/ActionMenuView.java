package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView
  extends LinearLayoutCompat
  implements MenuBuilder.ItemInvoker, MenuView
{
  private MenuBuilder a;
  private Context b;
  private int c;
  private boolean d;
  private ActionMenuPresenter e;
  private MenuPresenter.Callback f;
  private MenuBuilder.Callback g;
  private boolean h;
  private int i;
  private int j;
  private int k;
  private ActionMenuView.OnMenuItemClickListener l;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.j = ((int)(56.0F * f1));
    this.k = ((int)(f1 * 4.0F));
    this.b = paramContext;
    this.c = 0;
  }
  
  static int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = false;
    ActionMenuView.LayoutParams localLayoutParams = (ActionMenuView.LayoutParams)paramView.getLayoutParams();
    int m = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.b())) {
        break label184;
      }
      paramInt4 = 1;
      label57:
      if ((paramInt2 <= 0) || ((paramInt4 != 0) && (paramInt2 < 2))) {
        break label190;
      }
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, Integer.MIN_VALUE), m);
      int n = paramView.getMeasuredWidth();
      paramInt3 = n / paramInt1;
      paramInt2 = paramInt3;
      if (n % paramInt1 != 0) {
        paramInt2 = paramInt3 + 1;
      }
      paramInt3 = paramInt2;
      if (paramInt4 != 0)
      {
        paramInt3 = paramInt2;
        if (paramInt2 >= 2) {}
      }
    }
    label184:
    label190:
    for (paramInt3 = 2;; paramInt3 = 0)
    {
      boolean bool1 = bool2;
      if (!localLayoutParams.a)
      {
        bool1 = bool2;
        if (paramInt4 != 0) {
          bool1 = true;
        }
      }
      localLayoutParams.d = bool1;
      localLayoutParams.b = paramInt3;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 * paramInt1, 1073741824), m);
      return paramInt3;
      localActionMenuItemView = null;
      break;
      paramInt4 = 0;
      break label57;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i10 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i9 = View.MeasureSpec.getSize(paramInt2);
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int i7 = getPaddingTop() + getPaddingBottom();
    int i11 = getChildMeasureSpec(paramInt2, i7, -2);
    int i12 = paramInt1 - (m + n);
    paramInt1 = i12 / this.j;
    paramInt2 = this.j;
    if (paramInt1 == 0)
    {
      setMeasuredDimension(i12, 0);
      return;
    }
    int i13 = this.j + i12 % paramInt2 / paramInt1;
    m = 0;
    int i3 = 0;
    int i2 = 0;
    int i4 = 0;
    int i1 = 0;
    long l1 = 0L;
    int i14 = getChildCount();
    int i5 = 0;
    Object localObject;
    boolean bool;
    ActionMenuView.LayoutParams localLayoutParams;
    label274:
    label291:
    int i8;
    for (;;)
    {
      if (i5 < i14)
      {
        localObject = getChildAt(i5);
        if (((View)localObject).getVisibility() == 8)
        {
          paramInt2 = i3;
          n = paramInt1;
          paramInt1 = i4;
          i5 += 1;
          i4 = paramInt1;
          paramInt1 = n;
          i3 = paramInt2;
        }
        else
        {
          bool = localObject instanceof ActionMenuItemView;
          i4 += 1;
          if (bool) {
            ((View)localObject).setPadding(this.k, 0, this.k, 0);
          }
          localLayoutParams = (ActionMenuView.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.f = false;
          localLayoutParams.c = 0;
          localLayoutParams.b = 0;
          localLayoutParams.d = false;
          localLayoutParams.leftMargin = 0;
          localLayoutParams.rightMargin = 0;
          if ((bool) && (((ActionMenuItemView)localObject).b()))
          {
            bool = true;
            localLayoutParams.e = bool;
            if (!localLayoutParams.a) {
              break label402;
            }
            paramInt2 = 1;
            i8 = a((View)localObject, i13, paramInt2, i11, i7);
            i3 = Math.max(i3, i8);
            if (!localLayoutParams.d) {
              break label1233;
            }
          }
        }
      }
    }
    label402:
    label448:
    label485:
    label512:
    label571:
    label597:
    label728:
    label744:
    label777:
    label792:
    label935:
    label1072:
    label1076:
    label1175:
    label1181:
    label1184:
    label1195:
    label1233:
    for (paramInt2 = i2 + 1;; paramInt2 = i2)
    {
      if (localLayoutParams.a) {}
      for (n = 1;; n = i1)
      {
        int i6 = paramInt1 - i8;
        m = Math.max(m, ((View)localObject).getMeasuredHeight());
        if (i8 == 1)
        {
          long l2 = 1 << i5;
          i2 = paramInt2;
          l1 = l2 | l1;
          paramInt2 = i3;
          paramInt1 = i4;
          i1 = n;
          n = i6;
          break;
          bool = false;
          break label274;
          paramInt2 = paramInt1;
          break label291;
          if ((i1 != 0) && (i4 == 2))
          {
            i6 = 1;
            n = 0;
            i5 = paramInt1;
            if ((i2 <= 0) || (i5 <= 0)) {
              break label1195;
            }
            paramInt1 = Integer.MAX_VALUE;
            l2 = 0L;
            paramInt2 = 0;
            i7 = 0;
            if (i7 >= i14) {
              break label571;
            }
            localObject = (ActionMenuView.LayoutParams)getChildAt(i7).getLayoutParams();
            if (((ActionMenuView.LayoutParams)localObject).d) {
              break label512;
            }
            i8 = paramInt2;
            paramInt2 = paramInt1;
            paramInt1 = i8;
          }
          for (;;)
          {
            i8 = i7 + 1;
            i7 = paramInt2;
            paramInt2 = paramInt1;
            paramInt1 = i7;
            i7 = i8;
            break label448;
            i6 = 0;
            break;
            if (((ActionMenuView.LayoutParams)localObject).b < paramInt1)
            {
              paramInt2 = ((ActionMenuView.LayoutParams)localObject).b;
              l2 = 1 << i7;
              paramInt1 = 1;
            }
            else
            {
              if (((ActionMenuView.LayoutParams)localObject).b != paramInt1) {
                break label1184;
              }
              l2 |= 1 << i7;
              i8 = paramInt2 + 1;
              paramInt2 = paramInt1;
              paramInt1 = i8;
            }
          }
          l1 |= l2;
          if (paramInt2 > i5) {}
          for (;;)
          {
            float f2;
            float f1;
            if ((i1 == 0) && (i4 == 1))
            {
              paramInt1 = 1;
              if ((i5 <= 0) || (l1 == 0L) || ((i5 >= i4 - 1) && (paramInt1 == 0) && (i3 <= 1))) {
                break label1072;
              }
              float f3 = Long.bitCount(l1);
              f2 = f3;
              if (paramInt1 != 0) {
                break label1175;
              }
              f1 = f3;
              if ((1L & l1) != 0L)
              {
                f1 = f3;
                if (!((ActionMenuView.LayoutParams)getChildAt(0).getLayoutParams()).e) {
                  f1 = f3 - 0.5F;
                }
              }
              f2 = f1;
              if ((1 << i14 - 1 & l1) == 0L) {
                break label1175;
              }
              f2 = f1;
              if (((ActionMenuView.LayoutParams)getChildAt(i14 - 1).getLayoutParams()).e) {
                break label1175;
              }
              f1 -= 0.5F;
              if (f1 <= 0.0F) {
                break label935;
              }
              paramInt2 = (int)(i5 * i13 / f1);
              i1 = 0;
              paramInt1 = n;
              n = i1;
              for (;;)
              {
                i1 = paramInt1;
                if (n >= i14) {
                  break label1076;
                }
                if ((1 << n & l1) != 0L) {
                  break;
                }
                n += 1;
              }
              n = 0;
              paramInt2 = i5;
              if (n < i14)
              {
                localObject = getChildAt(n);
                localLayoutParams = (ActionMenuView.LayoutParams)((View)localObject).getLayoutParams();
                if ((1 << n & l2) == 0L)
                {
                  if (localLayoutParams.b != paramInt1 + 1) {
                    break label1181;
                  }
                  l1 |= 1 << n;
                }
              }
            }
            for (;;)
            {
              n += 1;
              break label792;
              if ((i6 != 0) && (localLayoutParams.e) && (paramInt2 == 1)) {
                ((View)localObject).setPadding(this.k + i13, 0, this.k, 0);
              }
              localLayoutParams.b += 1;
              localLayoutParams.f = true;
              paramInt2 -= 1;
              continue;
              n = 1;
              i5 = paramInt2;
              break;
              paramInt1 = 0;
              break label597;
              paramInt2 = 0;
              break label744;
              localObject = getChildAt(n);
              localLayoutParams = (ActionMenuView.LayoutParams)((View)localObject).getLayoutParams();
              if ((localObject instanceof ActionMenuItemView))
              {
                localLayoutParams.c = paramInt2;
                localLayoutParams.f = true;
                if ((n == 0) && (!localLayoutParams.e)) {
                  localLayoutParams.leftMargin = (-paramInt2 / 2);
                }
                paramInt1 = 1;
                break label777;
              }
              if (localLayoutParams.a)
              {
                localLayoutParams.c = paramInt2;
                localLayoutParams.f = true;
                localLayoutParams.rightMargin = (-paramInt2 / 2);
                paramInt1 = 1;
                break label777;
              }
              if (n != 0) {
                localLayoutParams.leftMargin = (paramInt2 / 2);
              }
              if (n != i14 - 1) {
                localLayoutParams.rightMargin = (paramInt2 / 2);
              }
              break label777;
              i1 = n;
              if (i1 != 0)
              {
                paramInt1 = 0;
                if (paramInt1 < i14)
                {
                  localObject = getChildAt(paramInt1);
                  localLayoutParams = (ActionMenuView.LayoutParams)((View)localObject).getLayoutParams();
                  if (!localLayoutParams.f) {}
                  for (;;)
                  {
                    paramInt1 += 1;
                    break;
                    paramInt2 = localLayoutParams.b;
                    ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.c + paramInt2 * i13, 1073741824), i11);
                  }
                }
              }
              if (i10 != 1073741824) {}
              for (;;)
              {
                setMeasuredDimension(i12, m);
                return;
                m = i9;
              }
              f1 = f2;
              break label728;
            }
            i8 = paramInt1;
            paramInt1 = paramInt2;
            paramInt2 = i8;
            break label485;
          }
        }
        paramInt1 = i4;
        i1 = i3;
        i3 = i6;
        i2 = paramInt2;
        paramInt2 = i1;
        i1 = n;
        n = i3;
        break;
      }
    }
  }
  
  public ActionMenuView.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new ActionMenuView.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ActionMenuView.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof ActionMenuView.LayoutParams)) {}
      for (paramLayoutParams = new ActionMenuView.LayoutParams((ActionMenuView.LayoutParams)paramLayoutParams);; paramLayoutParams = new ActionMenuView.LayoutParams(paramLayoutParams))
      {
        if (paramLayoutParams.h <= 0) {
          paramLayoutParams.h = 16;
        }
        return paramLayoutParams;
      }
    }
    return b();
  }
  
  public void a(MenuBuilder paramMenuBuilder)
  {
    this.a = paramMenuBuilder;
  }
  
  public void a(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.f = paramCallback;
    this.g = paramCallback1;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  protected boolean a(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 0) {
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof ActionMenuView.ActionMenuChildView)) {
        bool1 = false | ((ActionMenuView.ActionMenuChildView)localView1).d();
      }
    }
    if ((paramInt > 0) && ((localView2 instanceof ActionMenuView.ActionMenuChildView))) {
      return ((ActionMenuView.ActionMenuChildView)localView2).c() | bool1;
    }
    return bool1;
  }
  
  public boolean a(MenuItemImpl paramMenuItemImpl)
  {
    return this.a.a(paramMenuItemImpl, 0);
  }
  
  protected ActionMenuView.LayoutParams b()
  {
    ActionMenuView.LayoutParams localLayoutParams = new ActionMenuView.LayoutParams(-2, -2);
    localLayoutParams.h = 16;
    return localLayoutParams;
  }
  
  public ActionMenuView.LayoutParams c()
  {
    ActionMenuView.LayoutParams localLayoutParams = b();
    localLayoutParams.a = true;
    return localLayoutParams;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof ActionMenuView.LayoutParams));
  }
  
  public MenuBuilder d()
  {
    return this.a;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public boolean e()
  {
    return (this.e != null) && (this.e.d());
  }
  
  public boolean f()
  {
    return (this.e != null) && (this.e.e());
  }
  
  public boolean g()
  {
    return (this.e != null) && (this.e.h());
  }
  
  public Menu getMenu()
  {
    ActionMenuPresenter localActionMenuPresenter;
    if (this.a == null)
    {
      localObject = getContext();
      this.a = new MenuBuilder((Context)localObject);
      this.a.a(new ActionMenuView.MenuBuilderCallback(this, null));
      this.e = new ActionMenuPresenter((Context)localObject);
      this.e.c(true);
      localActionMenuPresenter = this.e;
      if (this.f == null) {
        break label110;
      }
    }
    label110:
    for (Object localObject = this.f;; localObject = new ActionMenuView.ActionMenuPresenterCallback(this, null))
    {
      localActionMenuPresenter.a((MenuPresenter.Callback)localObject);
      this.a.a(this.e, this.b);
      this.e.a(this);
      return this.a;
    }
  }
  
  public Drawable getOverflowIcon()
  {
    getMenu();
    return this.e.c();
  }
  
  public int getPopupTheme()
  {
    return this.c;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public boolean h()
  {
    return (this.e != null) && (this.e.i());
  }
  
  public void i()
  {
    if (this.e != null) {
      this.e.f();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    if (this.e != null)
    {
      this.e.b(false);
      if (this.e.h())
      {
        this.e.e();
        this.e.d();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    i();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.h)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i5 = getChildCount();
    int i4 = (paramInt4 - paramInt2) / 2;
    int i6 = getDividerWidth();
    paramInt4 = 0;
    paramInt2 = 0;
    int n = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    int m = 0;
    paramBoolean = ViewUtils.a(this);
    int i1 = 0;
    View localView;
    ActionMenuView.LayoutParams localLayoutParams;
    if (i1 < i5)
    {
      localView = getChildAt(i1);
      int i2;
      int i3;
      if (localView.getVisibility() == 8)
      {
        i2 = m;
        i3 = n;
        n = paramInt4;
        m = paramInt2;
        paramInt4 = i3;
        paramInt2 = i2;
      }
      for (;;)
      {
        i3 = i1 + 1;
        i1 = n;
        i2 = m;
        m = paramInt2;
        n = paramInt4;
        paramInt2 = i2;
        paramInt4 = i1;
        i1 = i3;
        break;
        localLayoutParams = (ActionMenuView.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.a)
        {
          i2 = localView.getMeasuredWidth();
          m = i2;
          if (a(i1)) {
            m = i2 + i6;
          }
          int i7 = localView.getMeasuredHeight();
          if (paramBoolean)
          {
            i2 = getPaddingLeft();
            i2 = localLayoutParams.leftMargin + i2;
            i3 = i2 + m;
          }
          for (;;)
          {
            int i8 = i4 - i7 / 2;
            localView.layout(i2, i8, i3, i7 + i8);
            i2 = n - m;
            i3 = 1;
            m = paramInt2;
            n = paramInt4;
            paramInt2 = i3;
            paramInt4 = i2;
            break;
            i3 = getWidth() - getPaddingRight() - localLayoutParams.rightMargin;
            i2 = i3 - m;
          }
        }
        i3 = localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
        i2 = paramInt4 + i3;
        paramInt4 = i2;
        if (a(i1)) {
          paramInt4 = i2 + i6;
        }
        i2 = n - i3;
        i3 = paramInt2 + 1;
        n = paramInt4;
        paramInt2 = m;
        paramInt4 = i2;
        m = i3;
      }
    }
    if ((i5 == 1) && (m == 0))
    {
      localView = getChildAt(0);
      paramInt2 = localView.getMeasuredWidth();
      paramInt4 = localView.getMeasuredHeight();
      paramInt1 = (paramInt3 - paramInt1) / 2 - paramInt2 / 2;
      paramInt3 = i4 - paramInt4 / 2;
      localView.layout(paramInt1, paramInt3, paramInt2 + paramInt1, paramInt4 + paramInt3);
      return;
    }
    if (m != 0)
    {
      paramInt1 = 0;
      label462:
      paramInt1 = paramInt2 - paramInt1;
      if (paramInt1 <= 0) {
        break label551;
      }
      paramInt1 = n / paramInt1;
      label475:
      paramInt3 = Math.max(0, paramInt1);
      if (!paramBoolean) {
        break label621;
      }
      paramInt1 = getWidth() - getPaddingRight();
      paramInt2 = 0;
      label498:
      if (paramInt2 < i5)
      {
        localView = getChildAt(paramInt2);
        localLayoutParams = (ActionMenuView.LayoutParams)localView.getLayoutParams();
        if (localView.getVisibility() == 8) {
          break label744;
        }
        if (!localLayoutParams.a) {
          break label556;
        }
      }
    }
    label551:
    label556:
    label621:
    label628:
    label676:
    label741:
    label744:
    for (;;)
    {
      paramInt2 += 1;
      break label498;
      break;
      paramInt1 = 1;
      break label462;
      paramInt1 = 0;
      break label475;
      paramInt1 -= localLayoutParams.rightMargin;
      paramInt4 = localView.getMeasuredWidth();
      m = localView.getMeasuredHeight();
      n = i4 - m / 2;
      localView.layout(paramInt1 - paramInt4, n, paramInt1, m + n);
      paramInt1 -= localLayoutParams.leftMargin + paramInt4 + paramInt3;
      continue;
      paramInt1 = getPaddingLeft();
      paramInt2 = 0;
      if (paramInt2 < i5)
      {
        localView = getChildAt(paramInt2);
        localLayoutParams = (ActionMenuView.LayoutParams)localView.getLayoutParams();
        if (localView.getVisibility() == 8) {
          break label741;
        }
        if (!localLayoutParams.a) {
          break label676;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        break label628;
        break;
        paramInt1 += localLayoutParams.leftMargin;
        paramInt4 = localView.getMeasuredWidth();
        m = localView.getMeasuredHeight();
        n = i4 - m / 2;
        localView.layout(paramInt1, n, paramInt1 + paramInt4, m + n);
        paramInt1 = localLayoutParams.rightMargin + paramInt4 + paramInt3 + paramInt1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.h;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    int n;
    for (boolean bool1 = true;; bool1 = false)
    {
      this.h = bool1;
      if (bool2 != this.h) {
        this.i = 0;
      }
      m = View.MeasureSpec.getSize(paramInt1);
      if ((this.h) && (this.a != null) && (m != this.i))
      {
        this.i = m;
        this.a.b(true);
      }
      n = getChildCount();
      if ((!this.h) || (n <= 0)) {
        break;
      }
      a(paramInt1, paramInt2);
      return;
    }
    int m = 0;
    while (m < n)
    {
      ActionMenuView.LayoutParams localLayoutParams = (ActionMenuView.LayoutParams)getChildAt(m).getLayoutParams();
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = 0;
      m += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.e.d(paramBoolean);
  }
  
  public void setOnMenuItemClickListener(ActionMenuView.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.l = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    getMenu();
    this.e.a(paramDrawable);
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      if (paramInt == 0) {
        this.b = getContext();
      }
    }
    else
    {
      return;
    }
    this.b = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.e = paramActionMenuPresenter;
    this.e.a(this);
  }
}
