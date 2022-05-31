package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.view.Window.Callback;

class AppCompatDelegateImplV14
  extends AppCompatDelegateImplV11
{
  private static TwilightManager r;
  private int s = -100;
  private boolean t;
  private boolean u = true;
  
  AppCompatDelegateImplV14(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  private int d(int paramInt)
  {
    int j = 2;
    int i = j;
    switch (paramInt)
    {
    case 1: 
    default: 
      i = 1;
    case 2: 
      return i;
    case 0: 
      if (t().a()) {}
      for (paramInt = 2;; paramInt = 1) {
        return paramInt;
      }
    }
    i = j;
    switch (((UiModeManager)this.a.getSystemService("uimode")).getNightMode())
    {
    case 2: 
    case 1: 
    default: 
      return 1;
    }
    return 0;
  }
  
  private boolean e(int paramInt)
  {
    boolean bool = false;
    Resources localResources = this.a.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int i = localConfiguration.uiMode;
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      if ((i & 0x30) != paramInt)
      {
        localConfiguration.uiMode = (localConfiguration.uiMode & 0xFFFFFFCF | paramInt);
        localResources.updateConfiguration(localConfiguration, null);
        bool = true;
      }
      return bool;
      paramInt = 16;
      continue;
      paramInt = 32;
    }
  }
  
  private int s()
  {
    if (this.s == -100) {}
    for (int i = j();; i = this.s) {
      return d(i);
    }
  }
  
  private TwilightManager t()
  {
    if (r == null) {
      r = new TwilightManager(this.a.getApplicationContext());
    }
    return r;
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new AppCompatDelegateImplV14.AppCompatWindowCallbackV14(this, paramCallback);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if ((paramBundle != null) && (this.s == -100)) {
      this.s = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public void c(Bundle paramBundle)
  {
    super.c(paramBundle);
    if (this.s != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.s);
    }
  }
  
  public boolean i()
  {
    this.t = true;
    return e(s());
  }
  
  public boolean n()
  {
    return this.u;
  }
}
