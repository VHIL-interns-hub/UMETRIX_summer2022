package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

class ShareCompatICS
{
  private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";
  
  ShareCompatICS() {}
  
  public static void configureMenuItem(MenuItem paramMenuItem, Activity paramActivity, Intent paramIntent)
  {
    Object localObject = paramMenuItem.getActionProvider();
    if (!(localObject instanceof ShareActionProvider)) {}
    for (localObject = new ShareActionProvider(paramActivity);; localObject = (ShareActionProvider)localObject)
    {
      ((ShareActionProvider)localObject).setShareHistoryFileName(".sharecompat_" + paramActivity.getClass().getName());
      ((ShareActionProvider)localObject).setShareIntent(paramIntent);
      paramMenuItem.setActionProvider((ActionProvider)localObject);
      return;
    }
  }
}
