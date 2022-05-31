package android.support.v7.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.TaskStackBuilder.SupportParentable;
import android.support.v4.view.KeyEventCompat;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.TintResources;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class AppCompatActivity
  extends FragmentActivity
  implements TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider, AppCompatCallback
{
  private AppCompatDelegate m;
  private int n = 0;
  private boolean o;
  private Resources p;
  
  public AppCompatActivity() {}
  
  public Intent a()
  {
    return NavUtils.a(this);
  }
  
  public ActionMode a(ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public void a(TaskStackBuilder paramTaskStackBuilder)
  {
    paramTaskStackBuilder.a(this);
  }
  
  public void a(ActionMode paramActionMode) {}
  
  public void a(Toolbar paramToolbar)
  {
    j().a(paramToolbar);
  }
  
  public boolean a(Intent paramIntent)
  {
    return NavUtils.a(this, paramIntent);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    j().b(paramView, paramLayoutParams);
  }
  
  public ActionBarDrawerToggle.Delegate b()
  {
    return j().g();
  }
  
  public ActionMode b(ActionMode.Callback paramCallback)
  {
    return j().a(paramCallback);
  }
  
  public void b(Intent paramIntent)
  {
    NavUtils.b(this, paramIntent);
  }
  
  public void b(TaskStackBuilder paramTaskStackBuilder) {}
  
  public void b(ActionMode paramActionMode) {}
  
  public void d()
  {
    j().e();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 19)
    {
      int i = paramKeyEvent.getAction();
      if (i == 0)
      {
        if (KeyEventCompat.a(paramKeyEvent, 2))
        {
          ActionBar localActionBar = g();
          if ((localActionBar != null) && (localActionBar.d()) && (localActionBar.i()))
          {
            this.o = true;
            return true;
          }
        }
      }
      else if ((i == 1) && (this.o))
      {
        this.o = false;
        return true;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public View findViewById(int paramInt)
  {
    return j().a(paramInt);
  }
  
  public ActionBar g()
  {
    return j().a();
  }
  
  public MenuInflater getMenuInflater()
  {
    return j().b();
  }
  
  public Resources getResources()
  {
    if (this.p == null) {
      this.p = new TintResources(this, super.getResources());
    }
    return this.p;
  }
  
  public boolean h()
  {
    Object localObject = a();
    if (localObject != null)
    {
      if (a((Intent)localObject))
      {
        localObject = TaskStackBuilder.a(this);
        a((TaskStackBuilder)localObject);
        b((TaskStackBuilder)localObject);
        ((TaskStackBuilder)localObject).a();
      }
      for (;;)
      {
        try
        {
          ActivityCompat.a(this);
          return true;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          finish();
          continue;
        }
        b(localIllegalStateException);
      }
    }
    return false;
  }
  
  @Deprecated
  public void i() {}
  
  public void invalidateOptionsMenu()
  {
    j().e();
  }
  
  public AppCompatDelegate j()
  {
    if (this.m == null) {
      this.m = AppCompatDelegate.a(this, this);
    }
    return this.m;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    j().a(paramConfiguration);
    if (this.p != null) {
      this.p.updateConfiguration(paramConfiguration, null);
    }
  }
  
  public void onContentChanged()
  {
    i();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppCompatDelegate localAppCompatDelegate = j();
    localAppCompatDelegate.h();
    localAppCompatDelegate.a(paramBundle);
    if ((localAppCompatDelegate.i()) && (this.n != 0))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label55;
      }
      onApplyThemeResource(getTheme(), this.n, false);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      return;
      label55:
      setTheme(this.n);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    j().f();
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    ActionBar localActionBar = g();
    if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((localActionBar.a() & 0x4) != 0)) {
      return h();
    }
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    j().b(paramBundle);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    j().d();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    j().c(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    j().c();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    j().a(paramCharSequence);
  }
  
  public void setContentView(int paramInt)
  {
    j().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    j().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    j().a(paramView, paramLayoutParams);
  }
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    this.n = paramInt;
  }
}
