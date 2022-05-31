package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb
{
  private static final int[] a = { 16843531 };
  
  public static Drawable a(Activity paramActivity)
  {
    paramActivity = paramActivity.obtainStyledAttributes(a);
    Drawable localDrawable = paramActivity.getDrawable(0);
    paramActivity.recycle();
    return localDrawable;
  }
  
  public static ActionBarDrawerToggleHoneycomb.SetIndicatorInfo a(ActionBarDrawerToggleHoneycomb.SetIndicatorInfo paramSetIndicatorInfo, Activity paramActivity, int paramInt)
  {
    ActionBarDrawerToggleHoneycomb.SetIndicatorInfo localSetIndicatorInfo = paramSetIndicatorInfo;
    if (paramSetIndicatorInfo == null) {
      localSetIndicatorInfo = new ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(paramActivity);
    }
    if (localSetIndicatorInfo.a != null) {}
    try
    {
      paramSetIndicatorInfo = paramActivity.getActionBar();
      localSetIndicatorInfo.b.invoke(paramSetIndicatorInfo, new Object[] { Integer.valueOf(paramInt) });
      if (Build.VERSION.SDK_INT <= 19) {
        paramSetIndicatorInfo.setSubtitle(paramSetIndicatorInfo.getSubtitle());
      }
      return localSetIndicatorInfo;
    }
    catch (Exception paramSetIndicatorInfo)
    {
      Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", paramSetIndicatorInfo);
    }
    return localSetIndicatorInfo;
  }
  
  public static ActionBarDrawerToggleHoneycomb.SetIndicatorInfo a(ActionBarDrawerToggleHoneycomb.SetIndicatorInfo paramSetIndicatorInfo, Activity paramActivity, Drawable paramDrawable, int paramInt)
  {
    paramSetIndicatorInfo = new ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(paramActivity);
    if (paramSetIndicatorInfo.a != null) {
      try
      {
        paramActivity = paramActivity.getActionBar();
        paramSetIndicatorInfo.a.invoke(paramActivity, new Object[] { paramDrawable });
        paramSetIndicatorInfo.b.invoke(paramActivity, new Object[] { Integer.valueOf(paramInt) });
        return paramSetIndicatorInfo;
      }
      catch (Exception paramActivity)
      {
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", paramActivity);
        return paramSetIndicatorInfo;
      }
    }
    if (paramSetIndicatorInfo.c != null)
    {
      paramSetIndicatorInfo.c.setImageDrawable(paramDrawable);
      return paramSetIndicatorInfo;
    }
    Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
    return paramSetIndicatorInfo;
  }
}
