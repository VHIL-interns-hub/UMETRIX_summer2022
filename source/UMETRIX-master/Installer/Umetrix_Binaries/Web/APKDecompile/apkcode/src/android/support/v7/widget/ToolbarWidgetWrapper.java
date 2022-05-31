package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.drawable;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.string;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class ToolbarWidgetWrapper
  implements DecorToolbar
{
  private Toolbar a;
  private int b;
  private View c;
  private View d;
  private Drawable e;
  private Drawable f;
  private Drawable g;
  private boolean h;
  private CharSequence i;
  private CharSequence j;
  private CharSequence k;
  private Window.Callback l;
  private boolean m;
  private ActionMenuPresenter n;
  private int o = 0;
  private final AppCompatDrawableManager p;
  private int q = 0;
  private Drawable r;
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
  }
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.a = paramToolbar;
    this.i = paramToolbar.getTitle();
    this.j = paramToolbar.getSubtitle();
    boolean bool;
    if (this.i != null)
    {
      bool = true;
      this.h = bool;
      this.g = paramToolbar.getNavigationIcon();
      if (!paramBoolean) {
        break label495;
      }
      paramToolbar = TintTypedArray.a(paramToolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      Object localObject = paramToolbar.c(R.styleable.ActionBar_title);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        b((CharSequence)localObject);
      }
      localObject = paramToolbar.c(R.styleable.ActionBar_subtitle);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        c((CharSequence)localObject);
      }
      localObject = paramToolbar.a(R.styleable.ActionBar_logo);
      if (localObject != null) {
        d((Drawable)localObject);
      }
      localObject = paramToolbar.a(R.styleable.ActionBar_icon);
      if ((this.g == null) && (localObject != null)) {
        a((Drawable)localObject);
      }
      localObject = paramToolbar.a(R.styleable.ActionBar_homeAsUpIndicator);
      if (localObject != null) {
        b((Drawable)localObject);
      }
      c(paramToolbar.a(R.styleable.ActionBar_displayOptions, 0));
      int i1 = paramToolbar.g(R.styleable.ActionBar_customNavigationLayout, 0);
      if (i1 != 0)
      {
        a(LayoutInflater.from(this.a.getContext()).inflate(i1, this.a, false));
        c(this.b | 0x10);
      }
      i1 = paramToolbar.f(R.styleable.ActionBar_height, 0);
      if (i1 > 0)
      {
        localObject = this.a.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = i1;
        this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      i1 = paramToolbar.d(R.styleable.ActionBar_contentInsetStart, -1);
      int i2 = paramToolbar.d(R.styleable.ActionBar_contentInsetEnd, -1);
      if ((i1 >= 0) || (i2 >= 0)) {
        this.a.a(Math.max(i1, 0), Math.max(i2, 0));
      }
      i1 = paramToolbar.g(R.styleable.ActionBar_titleTextStyle, 0);
      if (i1 != 0) {
        this.a.a(this.a.getContext(), i1);
      }
      i1 = paramToolbar.g(R.styleable.ActionBar_subtitleTextStyle, 0);
      if (i1 != 0) {
        this.a.b(this.a.getContext(), i1);
      }
      i1 = paramToolbar.g(R.styleable.ActionBar_popupTheme, 0);
      if (i1 != 0) {
        this.a.setPopupTheme(i1);
      }
      paramToolbar.a();
    }
    for (;;)
    {
      this.p = AppCompatDrawableManager.a();
      f(paramInt1);
      this.k = this.a.getNavigationContentDescription();
      c(this.p.a(b(), paramInt2));
      this.a.setNavigationOnClickListener(new ToolbarWidgetWrapper.1(this));
      return;
      bool = false;
      break;
      label495:
      this.b = s();
    }
  }
  
  private void e(CharSequence paramCharSequence)
  {
    this.i = paramCharSequence;
    if ((this.b & 0x8) != 0) {
      this.a.setTitle(paramCharSequence);
    }
  }
  
  private int s()
  {
    int i1 = 11;
    if (this.a.getNavigationIcon() != null) {
      i1 = 15;
    }
    return i1;
  }
  
  private void t()
  {
    Drawable localDrawable = null;
    if ((this.b & 0x2) != 0)
    {
      if ((this.b & 0x1) == 0) {
        break label49;
      }
      if (this.f == null) {
        break label41;
      }
      localDrawable = this.f;
    }
    for (;;)
    {
      this.a.setLogo(localDrawable);
      return;
      label41:
      localDrawable = this.e;
      continue;
      label49:
      localDrawable = this.e;
    }
  }
  
  private void u()
  {
    if ((this.b & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.k)) {
        this.a.setNavigationContentDescription(this.q);
      }
    }
    else {
      return;
    }
    this.a.setNavigationContentDescription(this.k);
  }
  
  private void v()
  {
    Toolbar localToolbar;
    if ((this.b & 0x4) != 0)
    {
      localToolbar = this.a;
      if (this.g == null) {
        break label32;
      }
    }
    label32:
    for (Drawable localDrawable = this.g;; localDrawable = this.r)
    {
      localToolbar.setNavigationIcon(localDrawable);
      return;
    }
  }
  
  public ViewPropertyAnimatorCompat a(int paramInt, long paramLong)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.k(this.a);
    if (paramInt == 0) {}
    for (float f1 = 1.0F;; f1 = 0.0F) {
      return localViewPropertyAnimatorCompat.a(f1).a(paramLong).a(new ToolbarWidgetWrapper.2(this, paramInt));
    }
  }
  
  public ViewGroup a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = this.p.a(b(), paramInt);; localDrawable = null)
    {
      a(localDrawable);
      return;
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    this.e = paramDrawable;
    t();
  }
  
  public void a(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.a.a(paramCallback, paramCallback1);
  }
  
  public void a(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if ((this.c != null) && (this.c.getParent() == this.a)) {
      this.a.removeView(this.c);
    }
    this.c = paramScrollingTabContainerView;
    if ((paramScrollingTabContainerView != null) && (this.o == 2))
    {
      this.a.addView(this.c, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.a = 8388691;
      paramScrollingTabContainerView.setAllowCollapse(true);
    }
  }
  
  public void a(Menu paramMenu, MenuPresenter.Callback paramCallback)
  {
    if (this.n == null)
    {
      this.n = new ActionMenuPresenter(this.a.getContext());
      this.n.a(R.id.action_menu_presenter);
    }
    this.n.a(paramCallback);
    this.a.a((MenuBuilder)paramMenu, this.n);
  }
  
  public void a(View paramView)
  {
    if ((this.d != null) && ((this.b & 0x10) != 0)) {
      this.a.removeView(this.d);
    }
    this.d = paramView;
    if ((paramView != null) && ((this.b & 0x10) != 0)) {
      this.a.addView(this.d);
    }
  }
  
  public void a(Window.Callback paramCallback)
  {
    this.l = paramCallback;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (!this.h) {
      e(paramCharSequence);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.setCollapsible(paramBoolean);
  }
  
  public Context b()
  {
    return this.a.getContext();
  }
  
  public void b(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = this.p.a(b(), paramInt);; localDrawable = null)
    {
      d(localDrawable);
      return;
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    this.g = paramDrawable;
    v();
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.h = true;
    e(paramCharSequence);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(int paramInt)
  {
    int i1 = this.b ^ paramInt;
    this.b = paramInt;
    if (i1 != 0)
    {
      if ((i1 & 0x4) != 0)
      {
        if ((paramInt & 0x4) == 0) {
          break label115;
        }
        v();
        u();
      }
      if ((i1 & 0x3) != 0) {
        t();
      }
      if ((i1 & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label126;
        }
        this.a.setTitle(this.i);
        this.a.setSubtitle(this.j);
      }
    }
    for (;;)
    {
      if (((i1 & 0x10) != 0) && (this.d != null))
      {
        if ((paramInt & 0x10) == 0) {
          break label145;
        }
        this.a.addView(this.d);
      }
      return;
      label115:
      this.a.setNavigationIcon(null);
      break;
      label126:
      this.a.setTitle(null);
      this.a.setSubtitle(null);
    }
    label145:
    this.a.removeView(this.d);
  }
  
  public void c(Drawable paramDrawable)
  {
    if (this.r != paramDrawable)
    {
      this.r = paramDrawable;
      v();
    }
  }
  
  public void c(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
    if ((this.b & 0x8) != 0) {
      this.a.setSubtitle(paramCharSequence);
    }
  }
  
  public boolean c()
  {
    return this.a.g();
  }
  
  public void d()
  {
    this.a.h();
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 0) {}
    for (Object localObject = null;; localObject = b().getString(paramInt))
    {
      d((CharSequence)localObject);
      return;
    }
  }
  
  public void d(Drawable paramDrawable)
  {
    this.f = paramDrawable;
    t();
  }
  
  public void d(CharSequence paramCharSequence)
  {
    this.k = paramCharSequence;
    u();
  }
  
  public CharSequence e()
  {
    return this.a.getTitle();
  }
  
  public void e(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
  
  public void f()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public void f(int paramInt)
  {
    if (paramInt == this.q) {}
    do
    {
      return;
      this.q = paramInt;
    } while (!TextUtils.isEmpty(this.a.getNavigationContentDescription()));
    d(this.q);
  }
  
  public void g()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public boolean h()
  {
    return this.a.a();
  }
  
  public boolean i()
  {
    return this.a.b();
  }
  
  public boolean j()
  {
    return this.a.c();
  }
  
  public boolean k()
  {
    return this.a.d();
  }
  
  public boolean l()
  {
    return this.a.e();
  }
  
  public void m()
  {
    this.m = true;
  }
  
  public void n()
  {
    this.a.f();
  }
  
  public int o()
  {
    return this.b;
  }
  
  public int p()
  {
    return this.o;
  }
  
  public int q()
  {
    return this.a.getVisibility();
  }
  
  public Menu r()
  {
    return this.a.getMenu();
  }
}
