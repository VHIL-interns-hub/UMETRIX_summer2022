package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class ActionProvider
{
  private final Context a;
  private ActionProvider.SubUiVisibilityListener b;
  private ActionProvider.VisibilityListener c;
  
  public ActionProvider(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public abstract View a();
  
  public View a(MenuItem paramMenuItem)
  {
    return a();
  }
  
  public void a(ActionProvider.SubUiVisibilityListener paramSubUiVisibilityListener)
  {
    this.b = paramSubUiVisibilityListener;
  }
  
  public void a(ActionProvider.VisibilityListener paramVisibilityListener)
  {
    if ((this.c != null) && (paramVisibilityListener != null)) {
      Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
    }
    this.c = paramVisibilityListener;
  }
  
  public void a(SubMenu paramSubMenu) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    this.c = null;
    this.b = null;
  }
}
