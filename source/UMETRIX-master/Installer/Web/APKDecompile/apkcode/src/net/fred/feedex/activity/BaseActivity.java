package net.fred.feedex.activity;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import net.fred.feedex.Constants;

public abstract class BaseActivity
  extends AppCompatActivity
{
  private boolean m;
  private boolean n;
  private View o;
  private BaseActivity.OnFullScreenListener p;
  
  public BaseActivity() {}
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.m = true;
      if (g() != null) {
        g().c();
      }
      getWindow().addFlags(1024);
      getWindow().clearFlags(2048);
      if (this.p != null) {
        this.p.a(false, paramBoolean2);
      }
    }
    do
    {
      return;
      this.m = false;
      if (g() != null) {
        g().b();
      }
      getWindow().addFlags(2048);
      getWindow().clearFlags(1024);
    } while (this.p == null);
    this.p.a();
  }
  
  public void a(BaseActivity.OnFullScreenListener paramOnFullScreenListener)
  {
    this.p = paramOnFullScreenListener;
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  @SuppressLint({"InlinedApi"})
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        if (g() != null) {
          g().c();
        }
        this.o.setSystemUiVisibility(3846);
        return;
      }
      a(true, true);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (g() != null) {
        g().b();
      }
      this.o.setSystemUiVisibility(0);
      return;
    }
    a(false, true);
  }
  
  public boolean k()
  {
    return (this.m) || (this.n);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.o = getWindow().getDecorView();
    if (Build.VERSION.SDK_INT >= 19) {
      this.o.setOnSystemUiVisibilityChangeListener(new BaseActivity.1(this));
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(Integer.MIN_VALUE);
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("STATE_IS_IMMERSIVE_FULLSCREEN")) {
      c(true);
    }
    for (;;)
    {
      super.onRestoreInstanceState(paramBundle);
      return;
      if (paramBundle.getBoolean("STATE_IS_NORMAL_FULLSCREEN")) {
        b(true);
      }
    }
  }
  
  protected void onResume()
  {
    if (Constants.a != null) {
      Constants.a.cancel(0);
    }
    super.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("STATE_IS_NORMAL_FULLSCREEN", this.m);
    paramBundle.putBoolean("STATE_IS_IMMERSIVE_FULLSCREEN", this.n);
    super.onSaveInstanceState(paramBundle);
  }
}
