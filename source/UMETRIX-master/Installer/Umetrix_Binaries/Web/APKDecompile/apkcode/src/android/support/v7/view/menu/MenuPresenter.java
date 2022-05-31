package android.support.v7.view.menu;

import android.content.Context;

public abstract interface MenuPresenter
{
  public abstract void a(Context paramContext, MenuBuilder paramMenuBuilder);
  
  public abstract void a(MenuBuilder paramMenuBuilder, boolean paramBoolean);
  
  public abstract boolean a(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl);
  
  public abstract boolean a(SubMenuBuilder paramSubMenuBuilder);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract boolean b(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl);
}
