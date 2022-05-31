package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.layout;
import android.support.v7.widget.ListPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;

public class MenuPopupHelper
  implements MenuPresenter, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  static final int a = R.layout.abc_popup_menu_item_layout;
  boolean b;
  private final Context c;
  private final LayoutInflater d;
  private final MenuBuilder e;
  private final MenuPopupHelper.MenuAdapter f;
  private final boolean g;
  private final int h;
  private final int i;
  private final int j;
  private View k;
  private ListPopupWindow l;
  private ViewTreeObserver m;
  private MenuPresenter.Callback n;
  private ViewGroup o;
  private boolean p;
  private int q;
  private int r = 0;
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView)
  {
    this(paramContext, paramMenuBuilder, paramView, false, R.attr.popupMenuStyle);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramMenuBuilder, paramView, paramBoolean, paramInt, 0);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.c = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.e = paramMenuBuilder;
    this.f = new MenuPopupHelper.MenuAdapter(this, this.e);
    this.g = paramBoolean;
    this.i = paramInt1;
    this.j = paramInt2;
    Resources localResources = paramContext.getResources();
    this.h = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.k = paramView;
    paramMenuBuilder.a(this, paramContext);
  }
  
  private int g()
  {
    MenuPopupHelper.MenuAdapter localMenuAdapter = this.f;
    int i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i6 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i7 = localMenuAdapter.getCount();
    int i2 = 0;
    int i3 = 0;
    View localView = null;
    int i1 = 0;
    int i4 = i1;
    if (i2 < i7)
    {
      i4 = localMenuAdapter.getItemViewType(i2);
      if (i4 == i3) {
        break label157;
      }
      i3 = i4;
      localView = null;
      label69:
      if (this.o == null) {
        this.o = new FrameLayout(this.c);
      }
      localView = localMenuAdapter.getView(i2, localView, this.o);
      localView.measure(i5, i6);
      i4 = localView.getMeasuredWidth();
      if (i4 >= this.h) {
        i4 = this.h;
      }
    }
    else
    {
      return i4;
    }
    if (i4 > i1) {
      i1 = i4;
    }
    for (;;)
    {
      i2 += 1;
      break;
      label157:
      break label69;
    }
  }
  
  public void a()
  {
    if (!d()) {
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }
  }
  
  public void a(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void a(Context paramContext, MenuBuilder paramMenuBuilder) {}
  
  public void a(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (paramMenuBuilder != this.e) {}
    do
    {
      return;
      e();
    } while (this.n == null);
    this.n.a(paramMenuBuilder, paramBoolean);
  }
  
  public void a(MenuPresenter.Callback paramCallback)
  {
    this.n = paramCallback;
  }
  
  public void a(View paramView)
  {
    this.k = paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean a(SubMenuBuilder paramSubMenuBuilder)
  {
    MenuPopupHelper localMenuPopupHelper;
    int i1;
    if (paramSubMenuBuilder.hasVisibleItems())
    {
      localMenuPopupHelper = new MenuPopupHelper(this.c, paramSubMenuBuilder, this.k);
      localMenuPopupHelper.a(this.n);
      int i2 = paramSubMenuBuilder.size();
      i1 = 0;
      if (i1 >= i2) {
        break label120;
      }
      MenuItem localMenuItem = paramSubMenuBuilder.getItem(i1);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      localMenuPopupHelper.a(bool);
      if (localMenuPopupHelper.d())
      {
        if (this.n != null) {
          this.n.a(paramSubMenuBuilder);
        }
        return true;
        i1 += 1;
        break;
      }
      return false;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.p = false;
    if (this.f != null) {
      this.f.notifyDataSetChanged();
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
  
  public ListPopupWindow c()
  {
    return this.l;
  }
  
  public boolean d()
  {
    int i1 = 0;
    this.l = new ListPopupWindow(this.c, null, this.i, this.j);
    this.l.a(this);
    this.l.a(this);
    this.l.a(this.f);
    this.l.a(true);
    View localView = this.k;
    if (localView != null)
    {
      if (this.m == null) {
        i1 = 1;
      }
      this.m = localView.getViewTreeObserver();
      if (i1 != 0) {
        this.m.addOnGlobalLayoutListener(this);
      }
      this.l.a(localView);
      this.l.d(this.r);
      if (!this.p)
      {
        this.q = g();
        this.p = true;
      }
      this.l.f(this.q);
      this.l.g(2);
      this.l.c();
      this.l.m().setOnKeyListener(this);
      return true;
    }
    return false;
  }
  
  public void e()
  {
    if (f()) {
      this.l.i();
    }
  }
  
  public boolean f()
  {
    return (this.l != null) && (this.l.k());
  }
  
  public void onDismiss()
  {
    this.l = null;
    this.e.close();
    if (this.m != null)
    {
      if (!this.m.isAlive()) {
        this.m = this.k.getViewTreeObserver();
      }
      this.m.removeGlobalOnLayoutListener(this);
      this.m = null;
    }
  }
  
  public void onGlobalLayout()
  {
    if (f())
    {
      View localView = this.k;
      if ((localView != null) && (localView.isShown())) {
        break label28;
      }
      e();
    }
    label28:
    while (!f()) {
      return;
    }
    this.l.c();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.f;
    MenuPopupHelper.MenuAdapter.a(paramAdapterView).a(paramAdapterView.a(paramInt), 0);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      e();
      return true;
    }
    return false;
  }
}
