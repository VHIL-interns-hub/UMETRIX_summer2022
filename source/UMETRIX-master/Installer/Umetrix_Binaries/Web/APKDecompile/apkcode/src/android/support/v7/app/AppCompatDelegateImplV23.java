package android.support.v7.app;

import android.content.Context;
import android.view.Window;
import android.view.Window.Callback;

class AppCompatDelegateImplV23
  extends AppCompatDelegateImplV14
{
  AppCompatDelegateImplV23(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new AppCompatDelegateImplV23.AppCompatWindowCallbackV23(this, paramCallback);
  }
}
