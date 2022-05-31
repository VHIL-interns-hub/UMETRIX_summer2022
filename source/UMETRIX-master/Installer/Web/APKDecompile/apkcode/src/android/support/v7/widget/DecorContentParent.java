package android.support.v7.widget;

import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Menu;
import android.view.Window.Callback;

public abstract interface DecorContentParent
{
  public abstract void a(int paramInt);
  
  public abstract void a(Menu paramMenu, MenuPresenter.Callback paramCallback);
  
  public abstract boolean d();
  
  public abstract boolean e();
  
  public abstract boolean f();
  
  public abstract boolean g();
  
  public abstract boolean h();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract void setWindowCallback(Window.Callback paramCallback);
  
  public abstract void setWindowTitle(CharSequence paramCharSequence);
}
