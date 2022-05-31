package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.SupportMenuInflater;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.view.Window.Callback;

abstract class AppCompatDelegateImplBase
  extends AppCompatDelegate
{
  final Context a;
  final Window b;
  final Window.Callback c;
  final Window.Callback d;
  final AppCompatCallback e;
  ActionBar f;
  MenuInflater g;
  boolean h;
  boolean i;
  boolean j;
  boolean k;
  boolean l;
  private CharSequence m;
  private boolean n;
  
  AppCompatDelegateImplBase(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    this.a = paramContext;
    this.b = paramWindow;
    this.e = paramAppCompatCallback;
    this.c = this.b.getCallback();
    if ((this.c instanceof AppCompatDelegateImplBase.AppCompatWindowCallbackBase)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.d = a(this.c);
    this.b.setCallback(this.d);
  }
  
  public ActionBar a()
  {
    k();
    return this.f;
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new AppCompatDelegateImplBase.AppCompatWindowCallbackBase(this, paramCallback);
  }
  
  abstract void a(int paramInt, Menu paramMenu);
  
  public final void a(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
    b(paramCharSequence);
  }
  
  abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  abstract boolean a(KeyEvent paramKeyEvent);
  
  abstract ActionMode b(ActionMode.Callback paramCallback);
  
  public MenuInflater b()
  {
    if (this.g == null)
    {
      k();
      if (this.f == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = this.f.e();; localContext = this.a)
    {
      this.g = new SupportMenuInflater(localContext);
      return this.g;
    }
  }
  
  abstract void b(CharSequence paramCharSequence);
  
  abstract boolean b(int paramInt, Menu paramMenu);
  
  public void c(Bundle paramBundle) {}
  
  public void f()
  {
    this.n = true;
  }
  
  public final ActionBarDrawerToggle.Delegate g()
  {
    return new AppCompatDelegateImplBase.ActionBarDrawableToggleImpl(this, null);
  }
  
  public boolean i()
  {
    return false;
  }
  
  abstract void k();
  
  final ActionBar l()
  {
    return this.f;
  }
  
  final Context m()
  {
    Context localContext = null;
    Object localObject = a();
    if (localObject != null) {
      localContext = ((ActionBar)localObject).e();
    }
    localObject = localContext;
    if (localContext == null) {
      localObject = this.a;
    }
    return localObject;
  }
  
  public boolean n()
  {
    return false;
  }
  
  final boolean o()
  {
    return this.n;
  }
  
  final Window.Callback p()
  {
    return this.b.getCallback();
  }
  
  final CharSequence q()
  {
    if ((this.c instanceof Activity)) {
      return ((Activity)this.c).getTitle();
    }
    return this.m;
  }
}
