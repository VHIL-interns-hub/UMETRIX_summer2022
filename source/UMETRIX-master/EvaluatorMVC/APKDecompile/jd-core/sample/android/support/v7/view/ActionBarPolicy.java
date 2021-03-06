package android.support.v7.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.bool;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.styleable;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;

public class ActionBarPolicy
{
  private Context mContext;
  
  private ActionBarPolicy(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static ActionBarPolicy get(Context paramContext)
  {
    return new ActionBarPolicy(paramContext);
  }
  
  public boolean enableHomeButtonByDefault()
  {
    return this.mContext.getApplicationInfo().targetSdkVersion < 14;
  }
  
  public int getEmbeddedMenuWidthLimit()
  {
    return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
  }
  
  public int getMaxActionButtons()
  {
    Resources localResources = this.mContext.getResources();
    int i = ConfigurationHelper.getScreenWidthDp(localResources);
    int j = ConfigurationHelper.getScreenHeightDp(localResources);
    if ((ConfigurationHelper.getSmallestScreenWidthDp(localResources) > 600) || (i > 600) || ((i > 960) && (j > 720)) || ((i > 720) && (j > 960))) {
      return 5;
    }
    if ((i >= 500) || ((i > 640) && (j > 480)) || ((i > 480) && (j > 640))) {
      return 4;
    }
    if (i >= 360) {
      return 3;
    }
    return 2;
  }
  
  public int getStackedTabMaxWidth()
  {
    return this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
  }
  
  public int getTabContainerHeight()
  {
    TypedArray localTypedArray = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    int j = localTypedArray.getLayoutDimension(R.styleable.ActionBar_height, 0);
    Resources localResources = this.mContext.getResources();
    int i = j;
    if (!hasEmbeddedTabs()) {
      i = Math.min(j, localResources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
    }
    localTypedArray.recycle();
    return i;
  }
  
  public boolean hasEmbeddedTabs()
  {
    return this.mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
  }
  
  public boolean showsOverflowMenuButton()
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    while (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext))) {
      return true;
    }
    return false;
  }
}
