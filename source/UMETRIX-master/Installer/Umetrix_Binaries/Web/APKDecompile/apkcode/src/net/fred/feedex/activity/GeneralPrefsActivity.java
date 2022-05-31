package net.fred.feedex.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import net.fred.feedex.utils.UiUtils;

public class GeneralPrefsActivity
  extends BaseActivity
{
  public GeneralPrefsActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    UiUtils.a(this);
    super.onCreate(paramBundle);
    setContentView(2130968606);
    a((Toolbar)findViewById(2131689558));
    g().a(true);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return true;
    }
    finish();
    return true;
  }
}
