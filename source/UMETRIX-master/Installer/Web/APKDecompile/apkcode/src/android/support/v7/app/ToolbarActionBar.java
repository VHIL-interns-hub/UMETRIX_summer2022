package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.ListAdapter;
import java.util.ArrayList;

class ToolbarActionBar
  extends ActionBar
{
  private DecorToolbar a;
  private boolean b;
  private Window.Callback c;
  private boolean d;
  private boolean e;
  private ArrayList f = new ArrayList();
  private ListMenuPresenter g;
  private final Runnable h = new ToolbarActionBar.1(this);
  private final Toolbar.OnMenuItemClickListener i = new ToolbarActionBar.2(this);
  
  public ToolbarActionBar(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.a = new ToolbarWidgetWrapper(paramToolbar, false);
    this.c = new ToolbarActionBar.ToolbarCallbackWrapper(this, paramCallback);
    this.a.a(this.c);
    paramToolbar.setOnMenuItemClickListener(this.i);
    this.a.a(paramCharSequence);
  }
  
  private View a(Menu paramMenu)
  {
    b(paramMenu);
    if ((paramMenu == null) || (this.g == null)) {}
    while (this.g.a().getCount() <= 0) {
      return null;
    }
    return (View)this.g.a(this.a.a());
  }
  
  private void b(Menu paramMenu)
  {
    Object localObject;
    Resources.Theme localTheme;
    if ((this.g == null) && ((paramMenu instanceof MenuBuilder)))
    {
      paramMenu = (MenuBuilder)paramMenu;
      localObject = this.a.b();
      TypedValue localTypedValue = new TypedValue();
      localTheme = ((Context)localObject).getResources().newTheme();
      localTheme.setTo(((Context)localObject).getTheme());
      localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
      if (localTypedValue.resourceId == 0) {
        break label170;
      }
      localTheme.applyStyle(localTypedValue.resourceId, true);
    }
    for (;;)
    {
      localObject = new ContextThemeWrapper((Context)localObject, 0);
      ((Context)localObject).getTheme().setTo(localTheme);
      this.g = new ListMenuPresenter((Context)localObject, R.layout.abc_list_menu_item_layout);
      this.g.a(new ToolbarActionBar.PanelMenuPresenterCallback(this, null));
      paramMenu.a(this.g);
      return;
      label170:
      localTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
    }
  }
  
  private Menu m()
  {
    if (!this.d)
    {
      this.a.a(new ToolbarActionBar.ActionMenuPresenterCallback(this, null), new ToolbarActionBar.MenuBuilderCallback(this, null));
      this.d = true;
    }
    return this.a.r();
  }
  
  public int a()
  {
    return this.a.o();
  }
  
  public void a(float paramFloat)
  {
    ViewCompat.c(this.a.a(), paramFloat);
  }
  
  public void a(int paramInt)
  {
    DecorToolbar localDecorToolbar = this.a;
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = this.a.b().getText(paramInt);; localCharSequence = null)
    {
      localDecorToolbar.b(localCharSequence);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = this.a.o();
    this.a.c(j & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.a.b(paramDrawable);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.a.b(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int j = 4;; j = 0)
    {
      a(j, 4);
      return;
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Menu localMenu = m();
    int j;
    if (localMenu != null)
    {
      if (paramKeyEvent == null) {
        break label56;
      }
      j = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(j).getKeyboardType() == 1) {
        break label61;
      }
    }
    label56:
    label61:
    for (boolean bool = true;; bool = false)
    {
      localMenu.setQwertyMode(bool);
      localMenu.performShortcut(paramInt, paramKeyEvent, 0);
      return true;
      j = -1;
      break;
    }
  }
  
  public void b()
  {
    this.a.e(0);
  }
  
  public void b(int paramInt)
  {
    this.a.d(paramInt);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.a.a(paramCharSequence);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    this.a.e(8);
  }
  
  public void d(boolean paramBoolean) {}
  
  public boolean d()
  {
    return this.a.q() == 0;
  }
  
  public Context e()
  {
    return this.a.b();
  }
  
  public void e(boolean paramBoolean) {}
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean == this.e) {}
    for (;;)
    {
      return;
      this.e = paramBoolean;
      int k = this.f.size();
      int j = 0;
      while (j < k)
      {
        ((ActionBar.OnMenuVisibilityListener)this.f.get(j)).a(paramBoolean);
        j += 1;
      }
    }
  }
  
  public boolean g()
  {
    this.a.a().removeCallbacks(this.h);
    ViewCompat.a(this.a.a(), this.h);
    return true;
  }
  
  public boolean h()
  {
    if (this.a.c())
    {
      this.a.d();
      return true;
    }
    return false;
  }
  
  public boolean i()
  {
    ViewGroup localViewGroup = this.a.a();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  void j()
  {
    this.a.a().removeCallbacks(this.h);
  }
  
  public Window.Callback k()
  {
    return this.c;
  }
  
  void l()
  {
    Menu localMenu = m();
    if ((localMenu instanceof MenuBuilder)) {}
    for (localMenuBuilder = (MenuBuilder)localMenu;; localMenuBuilder = null)
    {
      if (localMenuBuilder != null) {
        localMenuBuilder.g();
      }
      try
      {
        localMenu.clear();
        if ((!this.c.onCreatePanelMenu(0, localMenu)) || (!this.c.onPreparePanel(0, null, localMenu))) {
          localMenu.clear();
        }
        return;
      }
      finally
      {
        if (localMenuBuilder == null) {
          break;
        }
        localMenuBuilder.h();
      }
    }
  }
}
