package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public abstract class ActionMode
{
  private Object a;
  private boolean b;
  
  public ActionMode() {}
  
  public abstract MenuInflater a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(View paramView);
  
  public abstract void a(CharSequence paramCharSequence);
  
  public void a(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public abstract Menu b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(CharSequence paramCharSequence);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract CharSequence f();
  
  public abstract CharSequence g();
  
  public boolean h()
  {
    return false;
  }
  
  public abstract View i();
  
  public Object j()
  {
    return this.a;
  }
  
  public boolean k()
  {
    return this.b;
  }
}
