package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.KeyEvent;

public abstract class ActionBar
{
  public ActionBar() {}
  
  public abstract int a();
  
  public ActionMode a(ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }
  }
  
  public abstract void a(int paramInt);
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Drawable paramDrawable) {}
  
  public abstract void a(CharSequence paramCharSequence);
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public abstract void b();
  
  public void b(int paramInt) {}
  
  public void b(CharSequence paramCharSequence) {}
  
  public void b(boolean paramBoolean) {}
  
  public abstract void c();
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }
  }
  
  public void d(boolean paramBoolean) {}
  
  public abstract boolean d();
  
  public Context e()
  {
    return null;
  }
  
  public void e(boolean paramBoolean) {}
  
  public int f()
  {
    return 0;
  }
  
  public void f(boolean paramBoolean) {}
  
  public boolean g()
  {
    return false;
  }
  
  public boolean h()
  {
    return false;
  }
  
  boolean i()
  {
    return false;
  }
  
  void j() {}
}
