package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.color;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

class AppCompatDelegateImplV7
  extends AppCompatDelegateImplBase
  implements LayoutInflaterFactory, MenuBuilder.Callback
{
  private boolean A;
  private AppCompatDelegateImplV7.PanelFeatureState[] B;
  private AppCompatDelegateImplV7.PanelFeatureState C;
  private boolean D;
  private boolean E;
  private int F;
  private final Runnable G = new AppCompatDelegateImplV7.1(this);
  private boolean H;
  private Rect I;
  private Rect J;
  private AppCompatViewInflater K;
  ActionMode m;
  ActionBarContextView n;
  PopupWindow o;
  Runnable p;
  ViewPropertyAnimatorCompat q = null;
  private DecorContentParent r;
  private AppCompatDelegateImplV7.ActionMenuPresenterCallback s;
  private AppCompatDelegateImplV7.PanelMenuPresenterCallback t;
  private boolean u;
  private ViewGroup v;
  private TextView w;
  private View x;
  private boolean y;
  private boolean z;
  
  AppCompatDelegateImplV7(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  private AppCompatDelegateImplV7.PanelFeatureState a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = this.B;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new AppCompatDelegateImplV7.PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      this.B = ((AppCompatDelegateImplV7.PanelFeatureState[])localObject1);
    }
    localObject2 = localObject1[paramInt];
    if (localObject2 == null)
    {
      localObject2 = new AppCompatDelegateImplV7.PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
      return localObject2;
    }
    return localObject2;
  }
  
  private AppCompatDelegateImplV7.PanelFeatureState a(Menu paramMenu)
  {
    AppCompatDelegateImplV7.PanelFeatureState[] arrayOfPanelFeatureState = this.B;
    int i;
    int j;
    if (arrayOfPanelFeatureState != null)
    {
      i = arrayOfPanelFeatureState.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label57;
      }
      AppCompatDelegateImplV7.PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.j == paramMenu))
      {
        return localPanelFeatureState;
        i = 0;
        break;
      }
      j += 1;
    }
    label57:
    return null;
  }
  
  private void a(int paramInt, AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      AppCompatDelegateImplV7.PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < this.B.length) {
            localPanelFeatureState = this.B[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.j;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((AppCompatDelegateImplV7.PanelFeatureState)localObject1).o)) {}
    while (o()) {
      return;
    }
    this.c.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  private void a(AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int k = -1;
    if ((paramPanelFeatureState.o) || (o())) {}
    Object localObject;
    int i;
    label112:
    label117:
    label121:
    label123:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramPanelFeatureState.a == 0)
          {
            localObject = this.a;
            if ((((Context)localObject).getResources().getConfiguration().screenLayout & 0xF) != 4) {
              break label112;
            }
            i = 1;
            if (((Context)localObject).getApplicationInfo().targetSdkVersion < 11) {
              break label117;
            }
          }
          for (int j = 1;; j = 0)
          {
            if ((i != 0) && (j != 0)) {
              break label121;
            }
            localObject = p();
            if ((localObject == null) || (((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.a, paramPanelFeatureState.j))) {
              break label123;
            }
            a(paramPanelFeatureState, true);
            return;
            i = 0;
            break;
          }
        }
        localObject = (WindowManager)this.a.getSystemService("window");
      } while ((localObject == null) || (!b(paramPanelFeatureState, paramKeyEvent)));
      if ((paramPanelFeatureState.g != null) && (!paramPanelFeatureState.q)) {
        break label398;
      }
      if (paramPanelFeatureState.g != null) {
        break;
      }
    } while ((!a(paramPanelFeatureState)) || (paramPanelFeatureState.g == null));
    label187:
    if ((c(paramPanelFeatureState)) && (paramPanelFeatureState.a()))
    {
      paramKeyEvent = paramPanelFeatureState.h.getLayoutParams();
      if (paramKeyEvent != null) {
        break label434;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label398:
    label434:
    for (;;)
    {
      i = paramPanelFeatureState.b;
      paramPanelFeatureState.g.setBackgroundResource(i);
      ViewParent localViewParent = paramPanelFeatureState.h.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(paramPanelFeatureState.h);
      }
      paramPanelFeatureState.g.addView(paramPanelFeatureState.h, paramKeyEvent);
      if (!paramPanelFeatureState.h.hasFocus()) {
        paramPanelFeatureState.h.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramPanelFeatureState.n = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.d, paramPanelFeatureState.e, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramPanelFeatureState.c;
        paramKeyEvent.windowAnimations = paramPanelFeatureState.f;
        ((WindowManager)localObject).addView(paramPanelFeatureState.g, paramKeyEvent);
        paramPanelFeatureState.o = true;
        return;
        if ((!paramPanelFeatureState.q) || (paramPanelFeatureState.g.getChildCount() <= 0)) {
          break label187;
        }
        paramPanelFeatureState.g.removeAllViews();
        break label187;
        break;
        if (paramPanelFeatureState.i != null)
        {
          paramKeyEvent = paramPanelFeatureState.i.getLayoutParams();
          if (paramKeyEvent != null)
          {
            i = k;
            if (paramKeyEvent.width == -1) {
              continue;
            }
          }
        }
        i = -2;
      }
    }
  }
  
  private void a(AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.a == 0) && (this.r != null) && (this.r.e())) {
      b(paramPanelFeatureState.j);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.a.getSystemService("window");
      if ((localWindowManager != null) && (paramPanelFeatureState.o) && (paramPanelFeatureState.g != null))
      {
        localWindowManager.removeView(paramPanelFeatureState.g);
        if (paramBoolean) {
          a(paramPanelFeatureState.a, paramPanelFeatureState, null);
        }
      }
      paramPanelFeatureState.m = false;
      paramPanelFeatureState.n = false;
      paramPanelFeatureState.o = false;
      paramPanelFeatureState.h = null;
      paramPanelFeatureState.q = true;
    } while (this.C != paramPanelFeatureState);
    this.C = null;
  }
  
  private void a(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((this.r != null) && (this.r.d()) && ((!ViewConfigurationCompat.b(ViewConfiguration.get(this.a))) || (this.r.f())))
    {
      paramMenuBuilder = p();
      if ((!this.r.e()) || (!paramBoolean)) {
        if ((paramMenuBuilder != null) && (!o()))
        {
          if ((this.E) && ((this.F & 0x1) != 0))
          {
            this.b.getDecorView().removeCallbacks(this.G);
            this.G.run();
          }
          AppCompatDelegateImplV7.PanelFeatureState localPanelFeatureState = a(0, true);
          if ((localPanelFeatureState.j != null) && (!localPanelFeatureState.r) && (paramMenuBuilder.onPreparePanel(0, localPanelFeatureState.i, localPanelFeatureState.j)))
          {
            paramMenuBuilder.onMenuOpened(108, localPanelFeatureState.j);
            this.r.g();
          }
        }
      }
      do
      {
        return;
        this.r.h();
      } while (o());
      paramMenuBuilder.onPanelClosed(108, a(0, true).j);
      return;
    }
    paramMenuBuilder = a(0, true);
    paramMenuBuilder.q = true;
    a(paramMenuBuilder, false);
    a(paramMenuBuilder, null);
  }
  
  private boolean a(AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.a(m());
    paramPanelFeatureState.g = new AppCompatDelegateImplV7.ListMenuDecorView(this, paramPanelFeatureState.l);
    paramPanelFeatureState.c = 81;
    return true;
  }
  
  private boolean a(AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramKeyEvent.isSystem()) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        do
        {
          return bool2;
          if (!paramPanelFeatureState.m)
          {
            bool1 = bool2;
            if (!b(paramPanelFeatureState, paramKeyEvent)) {}
          }
          else
          {
            bool1 = bool2;
            if (paramPanelFeatureState.j != null) {
              bool1 = paramPanelFeatureState.j.performShortcut(paramInt1, paramKeyEvent, paramInt2);
            }
          }
          bool2 = bool1;
        } while (!bool1);
        bool2 = bool1;
      } while ((paramInt2 & 0x1) != 0);
      bool2 = bool1;
    } while (this.r != null);
    a(paramPanelFeatureState, true);
    return bool1;
  }
  
  private boolean a(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.b.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View)) || (ViewCompat.v((View)paramViewParent))) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
  }
  
  private void b(MenuBuilder paramMenuBuilder)
  {
    if (this.A) {
      return;
    }
    this.A = true;
    this.r.j();
    Window.Callback localCallback = p();
    if ((localCallback != null) && (!o())) {
      localCallback.onPanelClosed(108, paramMenuBuilder);
    }
    this.A = false;
  }
  
  private boolean b(AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.a;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if (((paramPanelFeatureState.a == 0) || (paramPanelFeatureState.a == 108)) && (this.r != null))
    {
      localTypedValue = new TypedValue();
      localTheme = localContext.getTheme();
      localTheme.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
      localObject1 = null;
      if (localTypedValue.resourceId != 0)
      {
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        Object localObject2 = localObject1;
        if (localTypedValue.resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(localTypedValue.resourceId, true);
        }
        if (localObject2 == null) {
          break label203;
        }
        localObject1 = new ContextThemeWrapper(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new MenuBuilder((Context)localObject1);
      ((MenuBuilder)localObject1).a(this);
      paramPanelFeatureState.a((MenuBuilder)localObject1);
      return true;
      localTheme.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      break;
      label203:
      localObject1 = localContext;
    }
  }
  
  private boolean b(AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (o()) {
      return false;
    }
    if (paramPanelFeatureState.m) {
      return true;
    }
    if ((this.C != null) && (this.C != paramPanelFeatureState)) {
      a(this.C, false);
    }
    Window.Callback localCallback = p();
    if (localCallback != null) {
      paramPanelFeatureState.i = localCallback.onCreatePanelView(paramPanelFeatureState.a);
    }
    if ((paramPanelFeatureState.a == 0) || (paramPanelFeatureState.a == 108)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.r != null)) {
        this.r.i();
      }
      if ((paramPanelFeatureState.i != null) || ((i != 0) && ((l() instanceof ToolbarActionBar)))) {
        break label408;
      }
      if ((paramPanelFeatureState.j != null) && (!paramPanelFeatureState.r)) {
        break label278;
      }
      if ((paramPanelFeatureState.j == null) && ((!b(paramPanelFeatureState)) || (paramPanelFeatureState.j == null))) {
        break;
      }
      if ((i != 0) && (this.r != null))
      {
        if (this.s == null) {
          this.s = new AppCompatDelegateImplV7.ActionMenuPresenterCallback(this, null);
        }
        this.r.a(paramPanelFeatureState.j, this.s);
      }
      paramPanelFeatureState.j.g();
      if (localCallback.onCreatePanelMenu(paramPanelFeatureState.a, paramPanelFeatureState.j)) {
        break label273;
      }
      paramPanelFeatureState.a(null);
      if ((i == 0) || (this.r == null)) {
        break;
      }
      this.r.a(null, this.s);
      return false;
    }
    label273:
    paramPanelFeatureState.r = false;
    label278:
    paramPanelFeatureState.j.g();
    if (paramPanelFeatureState.s != null)
    {
      paramPanelFeatureState.j.b(paramPanelFeatureState.s);
      paramPanelFeatureState.s = null;
    }
    if (!localCallback.onPreparePanel(0, paramPanelFeatureState.i, paramPanelFeatureState.j))
    {
      if ((i != 0) && (this.r != null)) {
        this.r.a(null, this.s);
      }
      paramPanelFeatureState.j.h();
      return false;
    }
    if (paramKeyEvent != null)
    {
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label430;
      }
    }
    label408:
    label430:
    for (boolean bool = true;; bool = false)
    {
      paramPanelFeatureState.p = bool;
      paramPanelFeatureState.j.setQwertyMode(paramPanelFeatureState.p);
      paramPanelFeatureState.j.h();
      paramPanelFeatureState.m = true;
      paramPanelFeatureState.n = false;
      this.C = paramPanelFeatureState;
      return true;
      i = -1;
      break;
    }
  }
  
  private boolean c(AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState)
  {
    if (paramPanelFeatureState.i != null)
    {
      paramPanelFeatureState.h = paramPanelFeatureState.i;
      return true;
    }
    if (paramPanelFeatureState.j == null) {
      return false;
    }
    if (this.t == null) {
      this.t = new AppCompatDelegateImplV7.PanelMenuPresenterCallback(this, null);
    }
    paramPanelFeatureState.h = ((View)paramPanelFeatureState.a(this.t));
    if (paramPanelFeatureState.h != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void d(int paramInt)
  {
    a(a(paramInt, true), true);
  }
  
  private boolean d(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getRepeatCount() == 0)
    {
      AppCompatDelegateImplV7.PanelFeatureState localPanelFeatureState = a(paramInt, true);
      if (!localPanelFeatureState.o) {
        return b(localPanelFeatureState, paramKeyEvent);
      }
    }
    return false;
  }
  
  private void e(int paramInt)
  {
    this.F |= 1 << paramInt;
    if (!this.E)
    {
      ViewCompat.a(this.b.getDecorView(), this.G);
      this.E = true;
    }
  }
  
  private boolean e(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    if (this.m != null) {
      return false;
    }
    AppCompatDelegateImplV7.PanelFeatureState localPanelFeatureState = a(paramInt, true);
    if ((paramInt == 0) && (this.r != null) && (this.r.d()) && (!ViewConfigurationCompat.b(ViewConfiguration.get(this.a)))) {
      if (!this.r.e())
      {
        if ((o()) || (!b(localPanelFeatureState, paramKeyEvent))) {
          break label229;
        }
        bool1 = this.r.g();
      }
    }
    for (;;)
    {
      if (bool1)
      {
        paramKeyEvent = (AudioManager)this.a.getSystemService("audio");
        if (paramKeyEvent == null) {
          break label216;
        }
        paramKeyEvent.playSoundEffect(0);
      }
      label122:
      return bool1;
      bool1 = this.r.h();
      continue;
      if ((!localPanelFeatureState.o) && (!localPanelFeatureState.n)) {
        break;
      }
      bool1 = localPanelFeatureState.o;
      a(localPanelFeatureState, true);
    }
    if (localPanelFeatureState.m)
    {
      if (!localPanelFeatureState.r) {
        break label234;
      }
      localPanelFeatureState.m = false;
    }
    label216:
    label229:
    label234:
    for (boolean bool1 = b(localPanelFeatureState, paramKeyEvent);; bool1 = true)
    {
      if (bool1)
      {
        a(localPanelFeatureState, paramKeyEvent);
        bool1 = bool2;
        break;
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
        break label122;
      }
      bool1 = false;
      break;
    }
  }
  
  private void f(int paramInt)
  {
    AppCompatDelegateImplV7.PanelFeatureState localPanelFeatureState = a(paramInt, true);
    if (localPanelFeatureState.j != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.j.a(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.s = localBundle;
      }
      localPanelFeatureState.j.g();
      localPanelFeatureState.j.clear();
    }
    localPanelFeatureState.r = true;
    localPanelFeatureState.q = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.r != null))
    {
      localPanelFeatureState = a(0, false);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.m = false;
        b(localPanelFeatureState, null);
      }
    }
  }
  
  private int g(int paramInt)
  {
    int j = 1;
    int k = 1;
    int i1 = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.n != null) && ((this.n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.n.getLayoutParams();
      if (this.n.isShown())
      {
        if (this.I == null)
        {
          this.I = new Rect();
          this.J = new Rect();
        }
        localObject2 = this.I;
        Rect localRect = this.J;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        ViewUtils.a(this.v, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label355;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.x != null) {
            break label279;
          }
          this.x = new View(this.a);
          this.x.setBackgroundColor(this.a.getResources().getColor(R.color.abc_input_method_navigation_guard));
          this.v.addView(this.x, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label201:
          if (this.x == null) {
            break label317;
          }
          label208:
          j = paramInt;
          if (!this.j)
          {
            j = paramInt;
            if (k != 0) {
              j = 0;
            }
          }
          paramInt = j;
          j = i;
          i = k;
          label233:
          if (j != 0) {
            this.n.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.x != null)
      {
        localObject1 = this.x;
        if (i == 0) {
          break label342;
        }
      }
      label279:
      label317:
      label342:
      for (i = i1;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        return paramInt;
        i = 0;
        break;
        localObject2 = this.x.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.x.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i = 1;
        break label201;
        k = 0;
        break label208;
        if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == 0) {
          break label348;
        }
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
        i = 0;
        break label233;
      }
      label348:
      j = 0;
      i = 0;
      break label233;
      label355:
      i = 0;
      break label201;
      i = 0;
    }
  }
  
  private int h(int paramInt)
  {
    int i;
    if (paramInt == 8)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      i = 108;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != 9);
    Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
    return 109;
  }
  
  private void s()
  {
    if (!this.u)
    {
      this.v = t();
      Object localObject = q();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        b((CharSequence)localObject);
      }
      u();
      a(this.v);
      this.u = true;
      localObject = a(0, false);
      if ((!o()) && ((localObject == null) || (((AppCompatDelegateImplV7.PanelFeatureState)localObject).j == null))) {
        e(108);
      }
    }
  }
  
  private ViewGroup t()
  {
    Object localObject = this.a.obtainStyledAttributes(R.styleable.AppCompatTheme);
    if (!((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowActionBar))
    {
      ((TypedArray)localObject).recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }
    if (((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false))
    {
      c(1);
      if (((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
        c(109);
      }
      if (((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
        c(10);
      }
      this.k = ((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
      ((TypedArray)localObject).recycle();
      localObject = LayoutInflater.from(this.a);
      if (this.l) {
        break label422;
      }
      if (!this.k) {
        break label263;
      }
      localObject = (ViewGroup)((LayoutInflater)localObject).inflate(R.layout.abc_dialog_title_material, null);
      this.i = false;
      this.h = false;
    }
    for (;;)
    {
      if (localObject == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
        if (!((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
          break;
        }
        c(108);
        break;
        label263:
        if (!this.h) {
          break label626;
        }
        localObject = new TypedValue();
        this.a.getTheme().resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject, true);
        if (((TypedValue)localObject).resourceId != 0) {}
        for (localObject = new ContextThemeWrapper(this.a, ((TypedValue)localObject).resourceId);; localObject = this.a)
        {
          localObject = (ViewGroup)LayoutInflater.from((Context)localObject).inflate(R.layout.abc_screen_toolbar, null);
          this.r = ((DecorContentParent)((ViewGroup)localObject).findViewById(R.id.decor_content_parent));
          this.r.setWindowCallback(p());
          if (this.i) {
            this.r.a(109);
          }
          if (this.y) {
            this.r.a(2);
          }
          if (this.z) {
            this.r.a(5);
          }
          break;
        }
        label422:
        if (this.j) {}
        for (localObject = (ViewGroup)((LayoutInflater)localObject).inflate(R.layout.abc_screen_simple_overlay_action_mode, null);; localObject = (ViewGroup)((LayoutInflater)localObject).inflate(R.layout.abc_screen_simple, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label479;
          }
          ViewCompat.a((View)localObject, new AppCompatDelegateImplV7.2(this));
          break;
        }
        label479:
        ((FitWindowsViewGroup)localObject).setOnFitSystemWindowsListener(new AppCompatDelegateImplV7.3(this));
        continue;
      }
      if (this.r == null) {
        this.w = ((TextView)((ViewGroup)localObject).findViewById(R.id.title));
      }
      ViewUtils.b((View)localObject);
      ViewGroup localViewGroup = (ViewGroup)this.b.findViewById(16908290);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject).findViewById(R.id.action_bar_activity_content);
      while (localViewGroup.getChildCount() > 0)
      {
        View localView = localViewGroup.getChildAt(0);
        localViewGroup.removeViewAt(0);
        localContentFrameLayout.addView(localView);
      }
      this.b.setContentView((View)localObject);
      localViewGroup.setId(-1);
      localContentFrameLayout.setId(16908290);
      if ((localViewGroup instanceof FrameLayout)) {
        ((FrameLayout)localViewGroup).setForeground(null);
      }
      localContentFrameLayout.setAttachListener(new AppCompatDelegateImplV7.4(this));
      return localObject;
      label626:
      localObject = null;
    }
  }
  
  private void u()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.v.findViewById(16908290);
    Object localObject = this.b.getDecorView();
    localContentFrameLayout.a(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.a.obtainStyledAttributes(R.styleable.AppCompatTheme);
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private void v()
  {
    if (this.q != null) {
      this.q.b();
    }
  }
  
  private void w()
  {
    if (this.u) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  private void x()
  {
    if (this.r != null) {
      this.r.j();
    }
    if (this.o != null)
    {
      this.b.getDecorView().removeCallbacks(this.p);
      if (!this.o.isShowing()) {}
    }
    try
    {
      this.o.dismiss();
      this.o = null;
      v();
      AppCompatDelegateImplV7.PanelFeatureState localPanelFeatureState = a(0, false);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.j != null)) {
        localPanelFeatureState.j.close();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public ActionMode a(ActionMode.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.m != null) {
      this.m.c();
    }
    paramCallback = new AppCompatDelegateImplV7.ActionModeCallbackWrapperV7(this, paramCallback);
    ActionBar localActionBar = a();
    if (localActionBar != null)
    {
      this.m = localActionBar.a(paramCallback);
      if ((this.m != null) && (this.e != null)) {
        this.e.a(this.m);
      }
    }
    if (this.m == null) {
      this.m = b(paramCallback);
    }
    return this.m;
  }
  
  public View a(int paramInt)
  {
    s();
    return this.b.findViewById(paramInt);
  }
  
  public final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = b(paramView, paramString, paramContext, paramAttributeSet);
    if (localView != null) {
      return localView;
    }
    return c(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  void a(int paramInt, Menu paramMenu)
  {
    if (paramInt == 108)
    {
      paramMenu = a();
      if (paramMenu != null) {
        paramMenu.f(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      paramMenu = a(paramInt, true);
    } while (!paramMenu.o);
    a(paramMenu, false);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((this.h) && (this.u))
    {
      ActionBar localActionBar = a();
      if (localActionBar != null) {
        localActionBar.a(paramConfiguration);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (((this.c instanceof Activity)) && (NavUtils.b((Activity)this.c) != null))
    {
      paramBundle = l();
      if (paramBundle == null) {
        this.H = true;
      }
    }
    else
    {
      return;
    }
    paramBundle.d(true);
  }
  
  public void a(MenuBuilder paramMenuBuilder)
  {
    a(paramMenuBuilder, true);
  }
  
  public void a(Toolbar paramToolbar)
  {
    if (!(this.c instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = a();
    if ((localActionBar instanceof WindowDecorActionBar)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    this.g = null;
    if (localActionBar != null) {
      localActionBar.j();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new ToolbarActionBar(paramToolbar, ((Activity)this.a).getTitle(), this.d);
      this.f = paramToolbar;
      this.b.setCallback(paramToolbar.k());
    }
    for (;;)
    {
      e();
      return;
      this.f = null;
      this.b.setCallback(this.d);
    }
  }
  
  public void a(View paramView)
  {
    s();
    ViewGroup localViewGroup = (ViewGroup)this.v.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.c.onContentChanged();
  }
  
  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    s();
    ViewGroup localViewGroup = (ViewGroup)this.v.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.c.onContentChanged();
  }
  
  void a(ViewGroup paramViewGroup) {}
  
  boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = a();
    if ((localObject != null) && (((ActionBar)localObject).a(paramInt, paramKeyEvent))) {}
    boolean bool;
    do
    {
      do
      {
        return true;
        if ((this.C == null) || (!a(this.C, paramKeyEvent.getKeyCode(), paramKeyEvent, 1))) {
          break;
        }
      } while (this.C == null);
      this.C.n = true;
      return true;
      if (this.C != null) {
        break;
      }
      localObject = a(0, true);
      b((AppCompatDelegateImplV7.PanelFeatureState)localObject, paramKeyEvent);
      bool = a((AppCompatDelegateImplV7.PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
      ((AppCompatDelegateImplV7.PanelFeatureState)localObject).m = false;
    } while (bool);
    return false;
  }
  
  public boolean a(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = p();
    if ((localCallback != null) && (!o()))
    {
      paramMenuBuilder = a(paramMenuBuilder.p());
      if (paramMenuBuilder != null) {
        return localCallback.onMenuItemSelected(paramMenuBuilder.a, paramMenuItem);
      }
    }
    return false;
  }
  
  boolean a(KeyEvent paramKeyEvent)
  {
    int i = 1;
    if ((paramKeyEvent.getKeyCode() == 82) && (this.c.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    int j = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() == 0) {}
    while (i != 0)
    {
      return c(j, paramKeyEvent);
      i = 0;
    }
    return b(j, paramKeyEvent);
  }
  
  ActionMode b(ActionMode.Callback paramCallback)
  {
    v();
    if (this.m != null) {
      this.m.c();
    }
    AppCompatDelegateImplV7.ActionModeCallbackWrapperV7 localActionModeCallbackWrapperV7 = new AppCompatDelegateImplV7.ActionModeCallbackWrapperV7(this, paramCallback);
    if ((this.e != null) && (!o())) {}
    for (;;)
    {
      try
      {
        ActionMode localActionMode = this.e.a(localActionModeCallbackWrapperV7);
        if (localActionMode != null)
        {
          this.m = localActionMode;
          if ((this.m != null) && (this.e != null)) {
            this.e.a(this.m);
          }
          return this.m;
        }
      }
      catch (AbstractMethodError localAbstractMethodError)
      {
        localObject1 = null;
        continue;
        Object localObject2;
        if (this.n == null)
        {
          if (!this.k) {
            continue;
          }
          localObject2 = new TypedValue();
          localObject1 = this.a.getTheme();
          ((Resources.Theme)localObject1).resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject2, true);
          if (((TypedValue)localObject2).resourceId != 0)
          {
            Resources.Theme localTheme = this.a.getResources().newTheme();
            localTheme.setTo((Resources.Theme)localObject1);
            localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
            localObject1 = new ContextThemeWrapper(this.a, 0);
            ((Context)localObject1).getTheme().setTo(localTheme);
            this.n = new ActionBarContextView((Context)localObject1);
            this.o = new PopupWindow((Context)localObject1, null, R.attr.actionModePopupWindowStyle);
            PopupWindowCompat.a(this.o, 2);
            this.o.setContentView(this.n);
            this.o.setWidth(-1);
            ((Context)localObject1).getTheme().resolveAttribute(R.attr.actionBarSize, (TypedValue)localObject2, true);
            int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, ((Context)localObject1).getResources().getDisplayMetrics());
            this.n.setContentHeight(i);
            this.o.setHeight(-2);
            this.p = new AppCompatDelegateImplV7.5(this);
          }
        }
        else
        {
          if (this.n == null) {
            continue;
          }
          v();
          this.n.c();
          localObject1 = this.n.getContext();
          localObject2 = this.n;
          if (this.o != null) {
            continue;
          }
          bool = true;
          localObject1 = new StandaloneActionMode((Context)localObject1, (ActionBarContextView)localObject2, localActionModeCallbackWrapperV7, bool);
          if (!paramCallback.a((ActionMode)localObject1, ((ActionMode)localObject1).b())) {
            continue;
          }
          ((ActionMode)localObject1).d();
          this.n.a((ActionMode)localObject1);
          this.m = ((ActionMode)localObject1);
          ViewCompat.b(this.n, 0.0F);
          this.q = ViewCompat.k(this.n).a(1.0F);
          this.q.a(new AppCompatDelegateImplV7.6(this));
          if (this.o == null) {
            continue;
          }
          this.b.getDecorView().post(this.p);
          continue;
        }
        localObject1 = this.a;
        continue;
        localObject1 = (ViewStubCompat)this.v.findViewById(R.id.action_mode_bar_stub);
        if (localObject1 == null) {
          continue;
        }
        ((ViewStubCompat)localObject1).setLayoutInflater(LayoutInflater.from(m()));
        this.n = ((ActionBarContextView)((ViewStubCompat)localObject1).a());
        continue;
        boolean bool = false;
        continue;
        this.m = null;
        continue;
      }
      Object localObject1 = null;
    }
  }
  
  View b(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((this.c instanceof LayoutInflater.Factory))
    {
      paramView = ((LayoutInflater.Factory)this.c).onCreateView(paramString, paramContext, paramAttributeSet);
      if (paramView != null) {
        return paramView;
      }
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    s();
    ViewGroup localViewGroup = (ViewGroup)this.v.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.a).inflate(paramInt, localViewGroup);
    this.c.onContentChanged();
  }
  
  public void b(Bundle paramBundle)
  {
    s();
  }
  
  public void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    s();
    ((ViewGroup)this.v.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.c.onContentChanged();
  }
  
  void b(CharSequence paramCharSequence)
  {
    if (this.r != null) {
      this.r.setWindowTitle(paramCharSequence);
    }
    do
    {
      return;
      if (l() != null)
      {
        l().b(paramCharSequence);
        return;
      }
    } while (this.w == null);
    this.w.setText(paramCharSequence);
  }
  
  boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = true;
    switch (paramInt)
    {
    }
    do
    {
      bool1 = false;
      boolean bool2;
      do
      {
        return bool1;
        e(0, paramKeyEvent);
        return true;
        bool2 = this.D;
        this.D = false;
        paramKeyEvent = a(0, false);
        if ((paramKeyEvent == null) || (!paramKeyEvent.o)) {
          break;
        }
      } while (bool2);
      a(paramKeyEvent, true);
      return true;
    } while (!r());
    return true;
  }
  
  boolean b(int paramInt, Menu paramMenu)
  {
    if (paramInt == 108)
    {
      paramMenu = a();
      if (paramMenu != null) {
        paramMenu.f(true);
      }
      return true;
    }
    return false;
  }
  
  public View c(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    boolean bool1;
    if (Build.VERSION.SDK_INT < 21)
    {
      bool1 = true;
      if (this.K == null) {
        this.K = new AppCompatViewInflater();
      }
      if ((!bool1) || (!a((ViewParent)paramView))) {
        break label74;
      }
    }
    label74:
    for (boolean bool2 = true;; bool2 = false)
    {
      return this.K.a(paramView, paramString, paramContext, paramAttributeSet, bool2, bool1, true, bool1);
      bool1 = false;
      break;
    }
  }
  
  public void c()
  {
    ActionBar localActionBar = a();
    if (localActionBar != null) {
      localActionBar.e(false);
    }
  }
  
  public boolean c(int paramInt)
  {
    paramInt = h(paramInt);
    if ((this.l) && (paramInt == 108)) {
      return false;
    }
    if ((this.h) && (paramInt == 1)) {
      this.h = false;
    }
    switch (paramInt)
    {
    default: 
      return this.b.requestFeature(paramInt);
    case 108: 
      w();
      this.h = true;
      return true;
    case 109: 
      w();
      this.i = true;
      return true;
    case 10: 
      w();
      this.j = true;
      return true;
    case 2: 
      w();
      this.y = true;
      return true;
    case 5: 
      w();
      this.z = true;
      return true;
    }
    w();
    this.l = true;
    return true;
  }
  
  boolean c(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      if (Build.VERSION.SDK_INT < 11) {
        a(paramInt, paramKeyEvent);
      }
      return false;
    case 82: 
      d(0, paramKeyEvent);
      return true;
    }
    if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
    for (;;)
    {
      this.D = bool;
      break;
      bool = false;
    }
  }
  
  public void d()
  {
    ActionBar localActionBar = a();
    if (localActionBar != null) {
      localActionBar.e(true);
    }
  }
  
  public void e()
  {
    ActionBar localActionBar = a();
    if ((localActionBar != null) && (localActionBar.g())) {
      return;
    }
    e(0);
  }
  
  public void f()
  {
    super.f();
    if (this.f != null)
    {
      this.f.j();
      this.f = null;
    }
  }
  
  public void h()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.a);
    if (localLayoutInflater.getFactory() == null) {
      LayoutInflaterCompat.a(localLayoutInflater, this);
    }
    while ((LayoutInflaterCompat.a(localLayoutInflater) instanceof AppCompatDelegateImplV7)) {
      return;
    }
    Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
  }
  
  public void k()
  {
    s();
    if ((!this.h) || (this.f != null)) {}
    for (;;)
    {
      return;
      if ((this.c instanceof Activity)) {
        this.f = new WindowDecorActionBar((Activity)this.c, this.i);
      }
      while (this.f != null)
      {
        this.f.d(this.H);
        return;
        if ((this.c instanceof Dialog)) {
          this.f = new WindowDecorActionBar((Dialog)this.c);
        }
      }
    }
  }
  
  boolean r()
  {
    if (this.m != null) {
      this.m.c();
    }
    ActionBar localActionBar;
    do
    {
      return true;
      localActionBar = a();
    } while ((localActionBar != null) && (localActionBar.h()));
    return false;
  }
}
