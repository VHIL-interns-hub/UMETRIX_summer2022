package net.fred.feedex.fragment;

import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.app.NotificationManager;
import android.content.ContentUris;
import android.content.Intent;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Date;
import java.util.List;
import net.fred.feedex.Constants;
import net.fred.feedex.adapter.EntriesCursorAdapter;
import net.fred.feedex.provider.FeedData.EntryColumns;
import net.fred.feedex.provider.FeedDataContentProvider;
import net.fred.feedex.service.FetcherService;
import net.fred.feedex.utils.PrefUtils;
import net.fred.feedex.utils.UiUtils;

public class EntriesListFragment
  extends SwipeRefreshListFragment
{
  private Uri a;
  private Uri b;
  private boolean c = false;
  private EntriesCursorAdapter d;
  private ListView e;
  private long f = new Date().getTime();
  private final LoaderManager.LoaderCallbacks g = new EntriesListFragment.1(this);
  private final SharedPreferences.OnSharedPreferenceChangeListener h = new EntriesListFragment.2(this);
  private int i;
  private int j = -1;
  private boolean k = false;
  private final LoaderManager.LoaderCallbacks l = new EntriesListFragment.3(this);
  private Button m;
  
  public EntriesListFragment() {}
  
  private void a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramUri;
    if (!paramBoolean2) {
      this.b = this.a;
    }
    this.c = paramBoolean1;
    this.d = new EntriesCursorAdapter(getActivity(), this.a, Constants.b, this.c);
    setListAdapter(this.d);
    this.f = new Date().getTime();
    if (this.a != null) {
      g();
    }
    h();
  }
  
  private void f()
  {
    if (!PrefUtils.a("IS_REFRESHING", false))
    {
      if ((this.a == null) || (FeedDataContentProvider.a.match(this.a) != 9)) {
        break label83;
      }
      getActivity().startService(new Intent(getActivity(), FetcherService.class).setAction("net.fred.feedex.REFRESH").putExtra("feedid", (String)this.a.getPathSegments().get(1)));
    }
    for (;;)
    {
      i();
      return;
      label83:
      getActivity().startService(new Intent(getActivity(), FetcherService.class).setAction("net.fred.feedex.REFRESH"));
    }
  }
  
  private void g()
  {
    LoaderManager localLoaderManager = getLoaderManager();
    localLoaderManager.restartLoader(1, null, this.g);
    localLoaderManager.restartLoader(2, null, this.l);
  }
  
  private void h()
  {
    if (this.i > 0)
    {
      this.m.setText(getResources().getQuantityString(2131296256, this.i, new Object[] { Integer.valueOf(this.i) }));
      this.m.setVisibility(0);
      return;
    }
    this.m.setVisibility(8);
  }
  
  private void i()
  {
    if (PrefUtils.a("IS_REFRESHING", false))
    {
      c();
      return;
    }
    d();
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968612, paramViewGroup, true);
    if (this.d != null) {
      setListAdapter(this.d);
    }
    this.e = ((ListView)paramLayoutInflater.findViewById(16908298));
    this.e.setOnTouchListener(new EntriesListFragment.SwipeGestureListener(this, this.e.getContext()));
    if (PrefUtils.a("DISPLAY_TIP", true))
    {
      paramViewGroup = new TextView(this.e.getContext());
      paramViewGroup.setMinimumHeight(UiUtils.a(70));
      int n = UiUtils.a(10);
      paramViewGroup.setPadding(n, n, n, n);
      paramViewGroup.setText(2131165326);
      paramViewGroup.setGravity(16);
      paramViewGroup.setCompoundDrawablePadding(UiUtils.a(5));
      paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(2130837596, 0, 2130837597, 0);
      paramViewGroup.setClickable(true);
      paramViewGroup.setOnClickListener(new EntriesListFragment.4(this, paramViewGroup));
      this.e.addHeaderView(paramViewGroup);
    }
    this.m = ((Button)paramLayoutInflater.findViewById(2131689590));
    this.m.setOnClickListener(new EntriesListFragment.5(this));
    e();
    return paramLayoutInflater;
  }
  
  public void a(Uri paramUri, boolean paramBoolean)
  {
    a(paramUri, paramBoolean, false);
  }
  
  public Uri b()
  {
    return this.b;
  }
  
  public void g_()
  {
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    setHasOptionsMenu(true);
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.a = ((Uri)paramBundle.getParcelable("STATE_CURRENT_URI"));
      this.b = ((Uri)paramBundle.getParcelable("STATE_ORIGINAL_URI"));
      this.c = paramBundle.getBoolean("STATE_SHOW_FEED_INFO");
      this.f = paramBundle.getLong("STATE_LIST_DISPLAY_DATE");
      this.d = new EntriesCursorAdapter(getActivity(), this.a, Constants.b, this.c);
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(2131755011, paramMenu);
    SearchView localSearchView = (SearchView)paramMenu.findItem(2131689630).getActionView();
    localSearchView.setOnQueryTextListener(new EntriesListFragment.6(this));
    localSearchView.setOnCloseListener(new EntriesListFragment.7(this));
    if (FeedData.EntryColumns.e.equals(this.a)) {
      paramMenu.findItem(2131689629).setVisible(false);
    }
    for (;;)
    {
      super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
      return;
      paramMenu.findItem(2131689632).setVisible(false);
    }
  }
  
  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    if (paramLong >= 0L) {
      startActivity(new Intent("android.intent.action.VIEW", ContentUris.withAppendedId(this.a, paramLong)));
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    case 2131689630: 
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131689632: 
      if (this.d != null)
      {
        paramMenuItem = "";
        Cursor localCursor = this.d.getCursor();
        if ((localCursor != null) && (!localCursor.isClosed()))
        {
          int n = localCursor.getColumnIndex("title");
          int i1 = localCursor.getColumnIndex("link");
          Object localObject = paramMenuItem;
          if (localCursor.moveToFirst()) {
            do
            {
              localObject = paramMenuItem + localCursor.getString(n) + "\n" + localCursor.getString(i1) + "\n\n";
              paramMenuItem = (MenuItem)localObject;
            } while (localCursor.moveToNext());
          }
          startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").putExtra("android.intent.extra.SUBJECT", getString(2131165322)).putExtra("android.intent.extra.TEXT", (String)localObject).setType("text/plain"), getString(2131165267)));
        }
      }
      return true;
    case 2131689629: 
      f();
      return true;
    }
    if (this.d != null)
    {
      this.d.a(this.f);
      if ((this.a != null) && (FeedData.EntryColumns.c.equals(this.a)) && (Constants.a != null)) {
        Constants.a.cancel(0);
      }
    }
    return true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("STATE_CURRENT_URI", this.a);
    paramBundle.putParcelable("STATE_ORIGINAL_URI", this.b);
    paramBundle.putBoolean("STATE_SHOW_FEED_INFO", this.c);
    paramBundle.putLong("STATE_LIST_DISPLAY_DATE", this.f);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    h();
    i();
    PrefUtils.a(this.h);
    if (this.a != null)
    {
      if ((this.i == 0) || (this.j != 0)) {
        break label59;
      }
      this.f = new Date().getTime();
    }
    for (;;)
    {
      g();
      return;
      label59:
      this.k = true;
    }
  }
  
  public void onStop()
  {
    PrefUtils.b(this.h);
    super.onStop();
  }
}
