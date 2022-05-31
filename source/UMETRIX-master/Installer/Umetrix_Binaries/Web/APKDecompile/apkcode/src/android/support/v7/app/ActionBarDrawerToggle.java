package android.support.v7.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private final ActionBarDrawerToggle.Delegate a;
  private final DrawerLayout b;
  private ActionBarDrawerToggle.DrawerToggle c;
  private Drawable d;
  private boolean e = true;
  private boolean f;
  private final int g;
  private final int h;
  private View.OnClickListener i;
  private boolean j = false;
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2)
  {
    this(paramActivity, null, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  ActionBarDrawerToggle(Activity paramActivity, Toolbar paramToolbar, DrawerLayout paramDrawerLayout, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (paramToolbar != null)
    {
      this.a = new ActionBarDrawerToggle.ToolbarCompatDelegate(paramToolbar);
      paramToolbar.setNavigationOnClickListener(new ActionBarDrawerToggle.1(this));
      this.b = paramDrawerLayout;
      this.g = paramInt1;
      this.h = paramInt2;
      if (paramDrawable != null) {
        break label180;
      }
    }
    label180:
    for (this.c = new ActionBarDrawerToggle.DrawerArrowDrawableToggle(paramActivity, this.a.b());; this.c = ((ActionBarDrawerToggle.DrawerToggle)paramDrawable))
    {
      this.d = b();
      return;
      if ((paramActivity instanceof ActionBarDrawerToggle.DelegateProvider))
      {
        this.a = ((ActionBarDrawerToggle.DelegateProvider)paramActivity).b();
        break;
      }
      if (Build.VERSION.SDK_INT >= 18)
      {
        this.a = new ActionBarDrawerToggle.JellybeanMr2Delegate(paramActivity, null);
        break;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.a = new ActionBarDrawerToggle.HoneycombDelegate(paramActivity, null);
        break;
      }
      this.a = new ActionBarDrawerToggle.DummyDelegate(paramActivity);
      break;
    }
  }
  
  private void c()
  {
    int k = this.b.a(8388611);
    if ((this.b.h(8388611)) && (k != 2)) {
      this.b.f(8388611);
    }
    while (k == 1) {
      return;
    }
    this.b.e(8388611);
  }
  
  public void a()
  {
    Drawable localDrawable;
    if (this.b.g(8388611))
    {
      this.c.a(1.0F);
      if (this.e)
      {
        localDrawable = (Drawable)this.c;
        if (!this.b.g(8388611)) {
          break label74;
        }
      }
    }
    label74:
    for (int k = this.h;; k = this.g)
    {
      a(localDrawable, k);
      return;
      this.c.a(0.0F);
      break;
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(Configuration paramConfiguration)
  {
    if (!this.f) {
      this.d = b();
    }
    a();
  }
  
  void a(Drawable paramDrawable, int paramInt)
  {
    if ((!this.j) && (!this.a.c()))
    {
      Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
      this.j = true;
    }
    this.a.a(paramDrawable, paramInt);
  }
  
  public void a(View paramView)
  {
    this.c.a(1.0F);
    if (this.e) {
      b(this.h);
    }
  }
  
  public void a(View paramView, float paramFloat)
  {
    this.c.a(Math.min(1.0F, Math.max(0.0F, paramFloat)));
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (this.e))
    {
      c();
      return true;
    }
    return false;
  }
  
  Drawable b()
  {
    return this.a.a();
  }
  
  void b(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void b(View paramView)
  {
    this.c.a(0.0F);
    if (this.e) {
      b(this.g);
    }
  }
}
