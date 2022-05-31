package net.fred.feedex.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;
import net.fred.feedex.utils.UiUtils;

public class AboutActivity
  extends BaseActivity
{
  public AboutActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    UiUtils.a(this);
    super.onCreate(paramBundle);
    setContentView(2130968601);
    a((Toolbar)findViewById(2131689558));
    g().a(true);
    paramBundle = getPackageManager();
    try
    {
      paramBundle = paramBundle.getPackageInfo(getPackageName(), 0);
      paramBundle = "Flym version " + paramBundle.versionName;
      ((TextView)findViewById(2131689555)).setText(paramBundle);
      ((TextView)findViewById(2131689556)).setText(Html.fromHtml(getString(2131165336)));
      return;
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      for (;;)
      {
        paramBundle = "Flym";
      }
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
}
