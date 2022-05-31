package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.appcompat.R.layout;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

public class ListMenuPresenter
  implements MenuPresenter, AdapterView.OnItemClickListener
{
  Context a;
  LayoutInflater b;
  MenuBuilder c;
  ExpandedMenuView d;
  int e;
  int f;
  ListMenuPresenter.MenuAdapter g;
  private int h;
  private MenuPresenter.Callback i;
  
  public ListMenuPresenter(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.e = paramInt2;
  }
  
  public ListMenuPresenter(Context paramContext, int paramInt)
  {
    this(paramInt, 0);
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
  }
  
  public MenuView a(ViewGroup paramViewGroup)
  {
    if (this.d == null)
    {
      this.d = ((ExpandedMenuView)this.b.inflate(R.layout.abc_expanded_menu_layout, paramViewGroup, false));
      if (this.g == null) {
        this.g = new ListMenuPresenter.MenuAdapter(this);
      }
      this.d.setAdapter(this.g);
      this.d.setOnItemClickListener(this);
    }
    return this.d;
  }
  
  public ListAdapter a()
  {
    if (this.g == null) {
      this.g = new ListMenuPresenter.MenuAdapter(this);
    }
    return this.g;
  }
  
  public void a(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    if (this.e != 0)
    {
      this.a = new ContextThemeWrapper(paramContext, this.e);
      this.b = LayoutInflater.from(this.a);
    }
    for (;;)
    {
      this.c = paramMenuBuilder;
      if (this.g != null) {
        this.g.notifyDataSetChanged();
      }
      return;
      if (this.a != null)
      {
        this.a = paramContext;
        if (this.b == null) {
          this.b = LayoutInflater.from(this.a);
        }
      }
    }
  }
  
  public void a(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (this.i != null) {
      this.i.a(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void a(MenuPresenter.Callback paramCallback)
  {
    this.i = paramCallback;
  }
  
  public boolean a(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean a(SubMenuBuilder paramSubMenuBuilder)
  {
    if (!paramSubMenuBuilder.hasVisibleItems()) {
      return false;
    }
    new MenuDialogHelper(paramSubMenuBuilder).a(null);
    if (this.i != null) {
      this.i.a(paramSubMenuBuilder);
    }
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.g != null) {
      this.g.notifyDataSetChanged();
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.c.a(this.g.a(paramInt), this, 0);
  }
}
