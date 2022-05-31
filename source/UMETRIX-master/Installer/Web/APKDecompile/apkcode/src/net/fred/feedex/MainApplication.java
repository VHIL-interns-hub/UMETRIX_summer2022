package net.fred.feedex;

import android.app.Application;
import android.content.Context;
import net.fred.feedex.utils.PrefUtils;

public class MainApplication
  extends Application
{
  private static Context a;
  
  public MainApplication() {}
  
  public static Context a()
  {
    return a;
  }
  
  public void onCreate()
  {
    super.onCreate();
    a = getApplicationContext();
    PrefUtils.b("IS_REFRESHING", false);
  }
}
