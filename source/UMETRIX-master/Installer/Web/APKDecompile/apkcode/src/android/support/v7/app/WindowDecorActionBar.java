package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

public class WindowDecorActionBar
  extends ActionBar
  implements ActionBarOverlayLayout.ActionBarVisibilityCallback
{
  private static final Interpolator i;
  private static final Interpolator j;
  private static final boolean k;
  private boolean A;
  private int B = 0;
  private boolean C = true;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G = true;
  private ViewPropertyAnimatorCompatSet H;
  private boolean I;
  WindowDecorActionBar.ActionModeImpl a;
  ActionMode b;
  ActionMode.Callback c;
  boolean d;
  final ViewPropertyAnimatorListener e = new WindowDecorActionBar.1(this);
  final ViewPropertyAnimatorListener f = new WindowDecorActionBar.2(this);
  final ViewPropertyAnimatorUpdateListener g = new WindowDecorActionBar.3(this);
  private Context l;
  private Context m;
  private Activity n;
  private Dialog o;
  private ActionBarOverlayLayout p;
  private ActionBarContainer q;
  private DecorToolbar r;
  private ActionBarContextView s;
  private View t;
  private ScrollingTabContainerView u;
  private ArrayList v = new ArrayList();
  private int w = -1;
  private boolean x;
  private boolean y;
  private ArrayList z = new ArrayList();
  
  static
  {
    boolean bool2 = true;
    if (!WindowDecorActionBar.class.desiredAssertionStatus())
    {
      bool1 = true;
      h = bool1;
      i = new AccelerateInterpolator();
      j = new DecelerateInterpolator();
      if (Build.VERSION.SDK_INT < 14) {
        break label56;
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public WindowDecorActionBar(Activity paramActivity, boolean paramBoolean)
  {
    this.n = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    a(paramActivity);
    if (!paramBoolean) {
      this.t = paramActivity.findViewById(16908290);
    }
  }
  
  public WindowDecorActionBar(Dialog paramDialog)
  {
    this.o = paramDialog;
    a(paramDialog.getWindow().getDecorView());
  }
  
  private void a(View paramView)
  {
    this.p = ((ActionBarOverlayLayout)paramView.findViewById(R.id.decor_content_parent));
    if (this.p != null) {
      this.p.setActionBarVisibilityCallback(this);
    }
    this.r = b(paramView.findViewById(R.id.action_bar));
    this.s = ((ActionBarContextView)paramView.findViewById(R.id.action_context_bar));
    this.q = ((ActionBarContainer)paramView.findViewById(R.id.action_bar_container));
    if ((this.r == null) || (this.s == null) || (this.q == null)) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
    }
    this.l = this.r.b();
    int i1;
    if ((this.r.o() & 0x4) != 0)
    {
      i1 = 1;
      if (i1 != 0) {
        this.x = true;
      }
      paramView = ActionBarPolicy.a(this.l);
      if ((!paramView.f()) && (i1 == 0)) {
        break label264;
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      k(paramView.d());
      paramView = this.l.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      if (paramView.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
        c(true);
      }
      i1 = paramView.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
      if (i1 != 0) {
        a(i1);
      }
      paramView.recycle();
      return;
      i1 = 0;
      break;
    }
  }
  
  private DecorToolbar b(View paramView)
  {
    if ((paramView instanceof DecorToolbar)) {
      return (DecorToolbar)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    if ("Can't make a decor toolbar out of " + paramView != null) {}
    for (paramView = paramView.getClass().getSimpleName();; paramView = "null") {
      throw new IllegalStateException(paramView);
    }
  }
  
  private static boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private void k(boolean paramBoolean)
  {
    boolean bool = true;
    this.A = paramBoolean;
    int i1;
    label45:
    label78:
    Object localObject;
    if (!this.A)
    {
      this.r.a(null);
      this.q.setTabContainer(this.u);
      if (l() != 2) {
        break label155;
      }
      i1 = 1;
      if (this.u != null)
      {
        if (i1 == 0) {
          break label160;
        }
        this.u.setVisibility(0);
        if (this.p != null) {
          ViewCompat.n(this.p);
        }
      }
      localObject = this.r;
      if ((this.A) || (i1 == 0)) {
        break label172;
      }
      paramBoolean = true;
      label97:
      ((DecorToolbar)localObject).a(paramBoolean);
      localObject = this.p;
      if ((this.A) || (i1 == 0)) {
        break label177;
      }
    }
    label155:
    label160:
    label172:
    label177:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(paramBoolean);
      return;
      this.q.setTabContainer(null);
      this.r.a(this.u);
      break;
      i1 = 0;
      break label45;
      this.u.setVisibility(8);
      break label78;
      paramBoolean = false;
      break label97;
    }
  }
  
  private void l(boolean paramBoolean)
  {
    if (b(this.D, this.E, this.F)) {
      if (!this.G)
      {
        this.G = true;
        h(paramBoolean);
      }
    }
    while (!this.G) {
      return;
    }
    this.G = false;
    i(paramBoolean);
  }
  
  private void r()
  {
    if (!this.F)
    {
      this.F = true;
      if (this.p != null) {
        this.p.setShowingForActionMode(true);
      }
      l(false);
    }
  }
  
  private void s()
  {
    if (this.F)
    {
      this.F = false;
      if (this.p != null) {
        this.p.setShowingForActionMode(false);
      }
      l(false);
    }
  }
  
  public int a()
  {
    return this.r.o();
  }
  
  public ActionMode a(ActionMode.Callback paramCallback)
  {
    if (this.a != null) {
      this.a.c();
    }
    this.p.setHideOnContentScrollEnabled(false);
    this.s.c();
    paramCallback = new WindowDecorActionBar.ActionModeImpl(this, this.s.getContext(), paramCallback);
    if (paramCallback.e())
    {
      paramCallback.d();
      this.s.a(paramCallback);
      j(true);
      this.s.sendAccessibilityEvent(32);
      this.a = paramCallback;
      return paramCallback;
    }
    return null;
  }
  
  public void a(float paramFloat)
  {
    ViewCompat.c(this.q, paramFloat);
  }
  
  public void a(int paramInt)
  {
    a(this.l.getString(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = this.r.o();
    if ((paramInt2 & 0x4) != 0) {
      this.x = true;
    }
    this.r.c(i1 & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public void a(Configuration paramConfiguration)
  {
    k(ActionBarPolicy.a(this.l).d());
  }
  
  public void a(Drawable paramDrawable)
  {
    this.r.b(paramDrawable);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.r.b(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 4;; i1 = 0)
    {
      a(i1, 4);
      return;
    }
  }
  
  public void b()
  {
    if (this.D)
    {
      this.D = false;
      l(false);
    }
  }
  
  public void b(int paramInt)
  {
    this.r.d(paramInt);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.r.a(paramCharSequence);
  }
  
  public void b(boolean paramBoolean)
  {
    this.r.b(paramBoolean);
  }
  
  public void c()
  {
    if (!this.D)
    {
      this.D = true;
      l(false);
    }
  }
  
  public void c(int paramInt)
  {
    this.B = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.p.a())) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.d = paramBoolean;
    this.p.setHideOnContentScrollEnabled(paramBoolean);
  }
  
  public void d(boolean paramBoolean)
  {
    if (!this.x) {
      a(paramBoolean);
    }
  }
  
  public boolean d()
  {
    int i1 = m();
    return (this.G) && ((i1 == 0) || (f() < i1));
  }
  
  public Context e()
  {
    int i1;
    if (this.m == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.l.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      i1 = localTypedValue.resourceId;
      if (i1 == 0) {
        break label61;
      }
    }
    label61:
    for (this.m = new ContextThemeWrapper(this.l, i1);; this.m = this.l) {
      return this.m;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.I = paramBoolean;
    if ((!paramBoolean) && (this.H != null)) {
      this.H.b();
    }
  }
  
  public int f()
  {
    return this.p.getActionBarHideOffset();
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean == this.y) {}
    for (;;)
    {
      return;
      this.y = paramBoolean;
      int i2 = this.z.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((ActionBar.OnMenuVisibilityListener)this.z.get(i1)).a(paramBoolean);
        i1 += 1;
      }
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.H != null) {
      this.H.b();
    }
    this.q.setVisibility(0);
    if ((this.B == 0) && (k) && ((this.I) || (paramBoolean)))
    {
      ViewCompat.a(this.q, 0.0F);
      float f2 = -this.q.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp77_75 = localObject;
        tmp77_75[0] = 0;
        Object tmp81_77 = tmp77_75;
        tmp81_77[1] = 0;
        tmp81_77;
        this.q.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      ViewCompat.a(this.q, f1);
      Object localObject = new ViewPropertyAnimatorCompatSet();
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.k(this.q).b(0.0F);
      localViewPropertyAnimatorCompat.a(this.g);
      ((ViewPropertyAnimatorCompatSet)localObject).a(localViewPropertyAnimatorCompat);
      if ((this.C) && (this.t != null))
      {
        ViewCompat.a(this.t, f1);
        ((ViewPropertyAnimatorCompatSet)localObject).a(ViewCompat.k(this.t).b(0.0F));
      }
      ((ViewPropertyAnimatorCompatSet)localObject).a(j);
      ((ViewPropertyAnimatorCompatSet)localObject).a(250L);
      ((ViewPropertyAnimatorCompatSet)localObject).a(this.f);
      this.H = ((ViewPropertyAnimatorCompatSet)localObject);
      ((ViewPropertyAnimatorCompatSet)localObject).a();
    }
    for (;;)
    {
      if (this.p != null) {
        ViewCompat.n(this.p);
      }
      return;
      ViewCompat.b(this.q, 1.0F);
      ViewCompat.a(this.q, 0.0F);
      if ((this.C) && (this.t != null)) {
        ViewCompat.a(this.t, 0.0F);
      }
      this.f.b(null);
    }
  }
  
  public boolean h()
  {
    if ((this.r != null) && (this.r.c()))
    {
      this.r.d();
      return true;
    }
    return false;
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.H != null) {
      this.H.b();
    }
    if ((this.B == 0) && (k) && ((this.I) || (paramBoolean)))
    {
      ViewCompat.b(this.q, 1.0F);
      this.q.setTransitioning(true);
      ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      float f2 = -this.q.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp86_84 = localObject;
        tmp86_84[0] = 0;
        Object tmp90_86 = tmp86_84;
        tmp90_86[1] = 0;
        tmp90_86;
        this.q.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = ViewCompat.k(this.q).b(f1);
      ((ViewPropertyAnimatorCompat)localObject).a(this.g);
      localViewPropertyAnimatorCompatSet.a((ViewPropertyAnimatorCompat)localObject);
      if ((this.C) && (this.t != null)) {
        localViewPropertyAnimatorCompatSet.a(ViewCompat.k(this.t).b(f1));
      }
      localViewPropertyAnimatorCompatSet.a(i);
      localViewPropertyAnimatorCompatSet.a(250L);
      localViewPropertyAnimatorCompatSet.a(this.e);
      this.H = localViewPropertyAnimatorCompatSet;
      localViewPropertyAnimatorCompatSet.a();
      return;
    }
    this.e.b(null);
  }
  
  public boolean i()
  {
    ViewGroup localViewGroup = this.r.a();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  public void j(boolean paramBoolean)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1;
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2;
    if (paramBoolean)
    {
      r();
      if (!paramBoolean) {
        break label68;
      }
      localViewPropertyAnimatorCompat1 = this.r.a(4, 100L);
      localViewPropertyAnimatorCompat2 = this.s.a(0, 200L);
    }
    for (;;)
    {
      ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      localViewPropertyAnimatorCompatSet.a(localViewPropertyAnimatorCompat1, localViewPropertyAnimatorCompat2);
      localViewPropertyAnimatorCompatSet.a();
      return;
      s();
      break;
      label68:
      localViewPropertyAnimatorCompat2 = this.r.a(0, 200L);
      localViewPropertyAnimatorCompat1 = this.s.a(8, 100L);
    }
  }
  
  void k()
  {
    if (this.c != null)
    {
      this.c.a(this.b);
      this.b = null;
      this.c = null;
    }
  }
  
  public int l()
  {
    return this.r.p();
  }
  
  public int m()
  {
    return this.q.getHeight();
  }
  
  public void n()
  {
    if (this.E)
    {
      this.E = false;
      l(true);
    }
  }
  
  public void o()
  {
    if (!this.E)
    {
      this.E = true;
      l(true);
    }
  }
  
  public void p()
  {
    if (this.H != null)
    {
      this.H.b();
      this.H = null;
    }
  }
  
  public void q() {}
}
