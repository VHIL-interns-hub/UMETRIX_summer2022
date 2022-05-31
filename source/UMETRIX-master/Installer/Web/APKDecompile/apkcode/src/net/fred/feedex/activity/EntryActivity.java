package net.fred.feedex.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import net.fred.feedex.fragment.EntryFragment;
import net.fred.feedex.utils.PrefUtils;
import net.fred.feedex.utils.UiUtils;

public class EntryActivity
  extends BaseActivity
{
  private EntryFragment m;
  
  public EntryActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    UiUtils.a(this);
    super.onCreate(paramBundle);
    setContentView(2130968604);
    this.m = ((EntryFragment)getFragmentManager().findFragmentById(2131689554));
    if (paramBundle == null) {
      this.m.a(getIntent().getData());
    }
    a((Toolbar)findViewById(2131689558));
    g().a(true);
    if (PrefUtils.a("display_entries_fullscreen", false)) {
      c(true);
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.m.a(paramIntent.getData());
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = false;
    if (paramMenuItem.getItemId() == 16908332)
    {
      paramMenuItem = getIntent().getExtras();
      if ((paramMenuItem != null) && (paramMenuItem.getBoolean("fromWidget", false))) {
        startActivity(new Intent(this, HomeActivity.class));
      }
      finish();
      bool = true;
    }
    return bool;
  }
}
