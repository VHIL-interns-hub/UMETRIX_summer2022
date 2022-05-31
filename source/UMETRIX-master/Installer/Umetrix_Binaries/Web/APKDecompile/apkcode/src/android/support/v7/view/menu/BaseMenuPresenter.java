package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class BaseMenuPresenter
  implements MenuPresenter
{
  protected Context a;
  protected Context b;
  protected MenuBuilder c;
  protected LayoutInflater d;
  protected LayoutInflater e;
  protected MenuView f;
  private MenuPresenter.Callback g;
  private int h;
  private int i;
  private int j;
  
  public BaseMenuPresenter(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public MenuPresenter.Callback a()
  {
    return this.g;
  }
  
  public MenuView a(ViewGroup paramViewGroup)
  {
    if (this.f == null)
    {
      this.f = ((MenuView)this.d.inflate(this.h, paramViewGroup, false));
      this.f.a(this.c);
      b(true);
    }
    return this.f;
  }
  
  public View a(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof MenuView.ItemView)) {}
    for (paramView = (MenuView.ItemView)paramView;; paramView = b(paramViewGroup))
    {
      a(paramMenuItemImpl, paramView);
      return (View)paramView;
    }
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this.b = paramContext;
    this.e = LayoutInflater.from(this.b);
    this.c = paramMenuBuilder;
  }
  
  public void a(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (this.g != null) {
      this.g.a(paramMenuBuilder, paramBoolean);
    }
  }
  
  public abstract void a(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView);
  
  public void a(MenuPresenter.Callback paramCallback)
  {
    this.g = paramCallback;
  }
  
  protected void a(View paramView, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramView);
    }
    ((ViewGroup)this.f).addView(paramView, paramInt);
  }
  
  public boolean a(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return true;
  }
  
  public boolean a(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean a(SubMenuBuilder paramSubMenuBuilder)
  {
    if (this.g != null) {
      return this.g.a(paramSubMenuBuilder);
    }
    return false;
  }
  
  protected boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public MenuView.ItemView b(ViewGroup paramViewGroup)
  {
    return (MenuView.ItemView)this.d.inflate(this.i, paramViewGroup, false);
  }
  
  public void b(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.f;
    if (localViewGroup == null) {}
    label198:
    label204:
    for (;;)
    {
      return;
      int m;
      if (this.c != null)
      {
        this.c.j();
        ArrayList localArrayList = this.c.i();
        int i1 = localArrayList.size();
        int n = 0;
        int k = 0;
        m = k;
        if (n < i1)
        {
          MenuItemImpl localMenuItemImpl2 = (MenuItemImpl)localArrayList.get(n);
          if (!a(k, localMenuItemImpl2)) {
            break label198;
          }
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof MenuView.ItemView)) {}
          for (MenuItemImpl localMenuItemImpl1 = ((MenuView.ItemView)localView1).getItemData();; localMenuItemImpl1 = null)
          {
            View localView2 = a(localMenuItemImpl2, localView1, localViewGroup);
            if (localMenuItemImpl2 != localMenuItemImpl1)
            {
              localView2.setPressed(false);
              ViewCompat.p(localView2);
            }
            if (localView2 != localView1) {
              a(localView2, k);
            }
            k += 1;
            n += 1;
            break;
          }
        }
      }
      for (;;)
      {
        if (m >= localViewGroup.getChildCount()) {
          break label204;
        }
        if (!a(localViewGroup, m))
        {
          m += 1;
          continue;
          break;
          m = 0;
        }
      }
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
}
