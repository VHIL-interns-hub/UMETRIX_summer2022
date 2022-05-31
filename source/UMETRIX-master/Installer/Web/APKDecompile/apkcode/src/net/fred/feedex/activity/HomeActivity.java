package net.fred.feedex.activity;

import android.app.AlertDialog.Builder;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import java.io.File;
import net.fred.feedex.adapter.DrawerAdapter;
import net.fred.feedex.fragment.EntriesListFragment;
import net.fred.feedex.parser.OPML;
import net.fred.feedex.provider.FeedData.EntryColumns;
import net.fred.feedex.provider.FeedData.FeedColumns;
import net.fred.feedex.service.FetcherService;
import net.fred.feedex.service.RefreshService;
import net.fred.feedex.utils.PrefUtils;
import net.fred.feedex.utils.UiUtils;

public class HomeActivity
  extends BaseActivity
  implements LoaderManager.LoaderCallbacks
{
  private EntriesListFragment m;
  private DrawerLayout n;
  private View o;
  private ListView p;
  private DrawerAdapter q;
  private ActionBarDrawerToggle r;
  private CharSequence s;
  private int t;
  
  public HomeActivity() {}
  
  private void b(int paramInt)
  {
    this.t = paramInt;
    long l;
    Object localObject;
    boolean bool;
    switch (paramInt)
    {
    default: 
      l = this.q.getItemId(paramInt);
      if (this.q.b(paramInt))
      {
        localObject = FeedData.EntryColumns.b(l);
        bool = true;
        this.s = this.q.a(paramInt);
        label73:
        if (!((Uri)localObject).equals(this.m.b())) {
          this.m.a((Uri)localObject, bool);
        }
        this.p.setItemChecked(paramInt, true);
        if (PrefUtils.a("FIRST_OPEN", true))
        {
          PrefUtils.b("FIRST_OPEN", false);
          if (this.n != null) {
            this.n.postDelayed(new HomeActivity.5(this), 500L);
          }
          localObject = new AlertDialog.Builder(this);
          AlertDialog.Builder localBuilder = ((AlertDialog.Builder)localObject).setTitle(2131165335);
          String str1 = getString(2131165252);
          String str2 = getString(2131165206);
          HomeActivity.6 local6 = new HomeActivity.6(this);
          localBuilder.setItems(new CharSequence[] { str1, str2 }, local6);
          ((AlertDialog.Builder)localObject).show();
        }
        switch (this.t)
        {
        default: 
          g().a(this.s);
        }
      }
      break;
    }
    for (;;)
    {
      invalidateOptionsMenu();
      return;
      localObject = FeedData.EntryColumns.d;
      bool = true;
      break label73;
      localObject = FeedData.EntryColumns.c;
      bool = true;
      break label73;
      localObject = FeedData.EntryColumns.e;
      bool = true;
      break label73;
      localObject = FeedData.EntryColumns.a(l);
      bool = false;
      break;
      g().a(2131165332);
      continue;
      g().a(2131165208);
      continue;
      g().a(2131165230);
    }
  }
  
  public void a(Loader paramLoader, Cursor paramCursor)
  {
    if (this.q != null)
    {
      this.q.a(paramCursor);
      return;
    }
    this.q = new DrawerAdapter(this, paramCursor);
    this.p.setAdapter(this.q);
    this.p.post(new HomeActivity.4(this));
  }
  
  public void onBackPressed()
  {
    if (this.n.g(8388611))
    {
      this.n.f(8388611);
      return;
    }
    super.onBackPressed();
  }
  
  public void onClickAdd(View paramView)
  {
    paramView = new AlertDialog.Builder(this);
    AlertDialog.Builder localBuilder = paramView.setTitle(2131165257);
    String str1 = getString(2131165206);
    String str2 = getString(2131165252);
    HomeActivity.3 local3 = new HomeActivity.3(this);
    localBuilder.setItems(new CharSequence[] { str1, str2 }, local3);
    paramView.show();
  }
  
  public void onClickEditFeeds(View paramView)
  {
    startActivity(new Intent(this, EditFeedsListActivity.class));
  }
  
  public void onClickSettings(View paramView)
  {
    startActivity(new Intent(this, GeneralPrefsActivity.class));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.r != null) {
      this.r.a(paramConfiguration);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    UiUtils.a(this);
    super.onCreate(paramBundle);
    setContentView(2130968607);
    this.m = ((EntriesListFragment)getFragmentManager().findFragmentById(2131689615));
    this.s = getTitle();
    a((Toolbar)findViewById(2131689558));
    g().a(true);
    this.o = findViewById(2131689616);
    this.p = ((ListView)findViewById(2131689614));
    this.p.setChoiceMode(1);
    this.p.setOnItemClickListener(new HomeActivity.1(this));
    this.n = ((DrawerLayout)findViewById(2131689576));
    if (this.n != null)
    {
      this.n.a(2130837592, 8388611);
      this.r = new ActionBarDrawerToggle(this, this.n, 2131165220, 2131165219);
      this.n.setDrawerListener(this.r);
    }
    if (paramBundle != null) {
      this.t = paramBundle.getInt("STATE_CURRENT_DRAWER_POS");
    }
    getLoaderManager().initLoader(0, null, this);
    if (PrefUtils.a("refresh.enabled", true)) {
      startService(new Intent(this, RefreshService.class));
    }
    for (;;)
    {
      if ((PrefUtils.a("refreshonopen.enabled", false)) && (!PrefUtils.a("IS_REFRESHING", false))) {
        startService(new Intent(this, FetcherService.class).setAction("net.fred.feedex.REFRESH"));
      }
      if ((ContextCompat.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) && (new File(OPML.a).exists()))
      {
        if (!ActivityCompat.a(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
          break;
        }
        paramBundle = new AlertDialog.Builder(this);
        paramBundle.setMessage(2131165323).setPositiveButton(17039370, new HomeActivity.2(this));
        paramBundle.show();
      }
      return;
      stopService(new Intent(this, RefreshService.class));
    }
    ActivityCompat.a(this, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 1);
  }
  
  public Loader onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = new CursorLoader(this, FeedData.FeedColumns.f, new String[] { "_id", "url", "name", "isgroup", "icon", "lastupdate", "error", "(SELECT COUNT(*) FROM entries WHERE isread IS NULL AND feedid=feeds._id)" }, null, null, null);
    paramBundle.setUpdateThrottle(200L);
    return paramBundle;
  }
  
  public void onLoaderReset(Loader paramLoader)
  {
    this.q.a(null);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    b(0);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return ((this.r != null) && (this.r.a(paramMenuItem))) || (super.onOptionsItemSelected(paramMenuItem));
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    if (this.r != null) {
      this.r.a();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while ((paramArrayOfInt.length <= 0) || (paramArrayOfInt[0] != 0));
    new Thread(new HomeActivity.7(this)).start();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("STATE_CURRENT_DRAWER_POS", this.t);
    super.onSaveInstanceState(paramBundle);
  }
}
