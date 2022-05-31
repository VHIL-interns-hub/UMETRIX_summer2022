package net.fred.feedex.fragment;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import net.fred.feedex.MainApplication;
import net.fred.feedex.activity.BaseActivity;
import net.fred.feedex.activity.BaseActivity.OnFullScreenListener;
import net.fred.feedex.provider.FeedData.EntryColumns;
import net.fred.feedex.service.FetcherService;
import net.fred.feedex.utils.PrefUtils;
import net.fred.feedex.view.EntryView.EntryViewManager;

public class EntryFragment
  extends SwipeRefreshFragment
  implements LoaderManager.LoaderCallbacks, BaseActivity.OnFullScreenListener, EntryView.EntryViewManager
{
  private int a = -1;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m = -1;
  private Uri n;
  private long o = -1L;
  private long[] p;
  private boolean q;
  private boolean r = true;
  private ViewPager s;
  private EntryFragment.EntryPagerAdapter t;
  private View u;
  
  public EntryFragment() {}
  
  private void a(Cursor paramCursor)
  {
    String str;
    boolean bool;
    if (paramCursor != null)
    {
      if (!paramCursor.isNull(this.j)) {
        break label170;
      }
      str = paramCursor.getString(this.k);
      BaseActivity localBaseActivity = (BaseActivity)getActivity();
      localBaseActivity.setTitle(str);
      if (paramCursor.getInt(this.f) != 1) {
        break label184;
      }
      bool = true;
      label59:
      this.q = bool;
      localBaseActivity.invalidateOptionsMenu();
      if (!FetcherService.a(this.p[this.m])) {
        break label189;
      }
      h();
      if (!PrefUtils.a("IS_REFRESHING", false)) {
        MainApplication.a().startService(new Intent(MainApplication.a(), FetcherService.class).setAction("net.fred.feedex.MOBILIZE_FEEDS"));
      }
    }
    for (;;)
    {
      if (paramCursor.getInt(this.g) != 1) {
        new Thread(new EntryFragment.5(this, ContentUris.withAppendedId(this.n, this.p[this.m]))).start();
      }
      return;
      label170:
      str = paramCursor.getString(this.j);
      break;
      label184:
      bool = false;
      break label59;
      label189:
      i();
    }
  }
  
  private void a(Uri paramUri, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      startActivityForResult(new Intent("android.intent.action.VIEW").setDataAndType(paramUri, paramString.substring(paramInt1 + 3, paramInt2)), 0);
      return;
    }
    catch (Exception paramString)
    {
      try
      {
        startActivityForResult(new Intent("android.intent.action.VIEW", paramUri), 0);
        return;
      }
      catch (Throwable paramUri)
      {
        Toast.makeText(getActivity(), paramUri.getMessage(), 1).show();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ((BaseActivity)getActivity()).c(paramBoolean);
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968611, paramViewGroup, true);
    this.u = paramLayoutInflater.findViewById(2131689588);
    this.u.setOnClickListener(new EntryFragment.1(this));
    this.s = ((ViewPager)paramLayoutInflater.findViewById(2131689587));
    this.s.setAdapter(this.t);
    if (paramBundle != null)
    {
      this.n = ((Uri)paramBundle.getParcelable("STATE_BASE_URI"));
      this.p = paramBundle.getLongArray("STATE_ENTRIES_IDS");
      this.o = paramBundle.getLong("STATE_INITIAL_ENTRY_ID");
      this.m = paramBundle.getInt("STATE_CURRENT_PAGER_POS");
      this.s.getAdapter().c();
      this.s.setCurrentItem(this.m);
    }
    this.s.a(new EntryFragment.2(this));
    j();
    return paramLayoutInflater;
  }
  
  public void a()
  {
    this.u.setVisibility(8);
  }
  
  public void a(Loader paramLoader, Cursor paramCursor)
  {
    if ((this.n != null) && (paramCursor != null))
    {
      paramCursor.moveToFirst();
      if (this.a == -1)
      {
        this.a = paramCursor.getColumnIndex("title");
        this.b = paramCursor.getColumnIndex("date");
        this.d = paramCursor.getColumnIndex("abstract");
        this.c = paramCursor.getColumnIndex("mobilized");
        this.e = paramCursor.getColumnIndex("link");
        this.f = paramCursor.getColumnIndex("favorite");
        this.g = paramCursor.getColumnIndex("isread");
        this.h = paramCursor.getColumnIndex("enclosure");
        this.i = paramCursor.getColumnIndex("author");
        this.j = paramCursor.getColumnIndex("name");
        this.k = paramCursor.getColumnIndex("url");
        this.l = paramCursor.getColumnIndex("icon");
      }
      int i1 = paramLoader.getId();
      if (i1 != -1) {
        this.t.a(i1, paramCursor, false);
      }
    }
  }
  
  public void a(Uri paramUri)
  {
    this.m = -1;
    this.n = FeedData.EntryColumns.c(paramUri.getPath());
    try
    {
      this.o = Long.parseLong(paramUri.getLastPathSegment());
      if (this.n != null) {
        if (PrefUtils.a("display_oldest_first", false))
        {
          paramUri = " ASC";
          paramUri = MainApplication.a().getContentResolver().query(this.n, FeedData.EntryColumns.a, null, null, "date" + paramUri);
          if ((paramUri == null) || (paramUri.getCount() <= 0)) {
            break label186;
          }
          this.p = new long[paramUri.getCount()];
          int i1 = 0;
          while (paramUri.moveToNext())
          {
            this.p[i1] = paramUri.getLong(0);
            if (this.p[i1] == this.o) {
              this.m = i1;
            }
            i1 += 1;
          }
        }
      }
    }
    catch (Exception paramUri)
    {
      for (;;)
      {
        this.o = -1L;
        continue;
        paramUri = " DESC";
      }
      paramUri.close();
    }
    for (;;)
    {
      label186:
      this.t.c();
      if (this.m != -1) {
        this.s.setCurrentItem(this.m);
      }
      return;
      this.p = null;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (paramBoolean2)) {
      this.u.setVisibility(0);
    }
  }
  
  public void b()
  {
    getActivity().runOnUiThread(new EntryFragment.6(this));
  }
  
  public void c()
  {
    BaseActivity localBaseActivity = (BaseActivity)getActivity();
    int i1;
    if (!this.t.b(this.m).isNull(this.c))
    {
      i1 = 1;
      if (i1 == 0) {
        break label55;
      }
      localBaseActivity.runOnUiThread(new EntryFragment.7(this));
    }
    label55:
    while (k())
    {
      return;
      i1 = 0;
      break;
    }
    NetworkInfo localNetworkInfo = ((ConnectivityManager)localBaseActivity.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED))
    {
      FetcherService.a(new long[] { this.p[this.m] });
      localBaseActivity.startService(new Intent(localBaseActivity, FetcherService.class).setAction("net.fred.feedex.MOBILIZE_FEEDS"));
      localBaseActivity.runOnUiThread(new EntryFragment.8(this));
      return;
    }
    localBaseActivity.runOnUiThread(new EntryFragment.9(this, localBaseActivity));
  }
  
  public void d()
  {
    getActivity().runOnUiThread(new EntryFragment.10(this));
  }
  
  public void e()
  {
    ((BaseActivity)getActivity()).b(true);
  }
  
  public void f()
  {
    ((BaseActivity)getActivity()).b(false);
  }
  
  public FrameLayout g()
  {
    View localView = getView();
    if (localView == null) {
      return null;
    }
    return (FrameLayout)localView.findViewById(2131689589);
  }
  
  public void g_() {}
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    ((BaseActivity)paramActivity).a(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    setHasOptionsMenu(true);
    this.t = new EntryFragment.EntryPagerAdapter(this);
    super.onCreate(paramBundle);
  }
  
  public Loader onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = new CursorLoader(getActivity(), FeedData.EntryColumns.c(this.p[paramInt]), null, null, null, null);
    paramBundle.setUpdateThrottle(1000L);
    return paramBundle;
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(2131755010, paramMenu);
    if (this.q) {
      paramMenu.findItem(2131689624).setTitle(2131165269).setIcon(2130837600);
    }
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
  }
  
  public void onDetach()
  {
    ((BaseActivity)getActivity()).a(null);
    super.onDetach();
  }
  
  public void onLoaderReset(Loader paramLoader)
  {
    this.t.a(paramLoader.getId(), null);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Object localObject;
    if (this.p != null) {
      localObject = getActivity();
    }
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 2131689624: 
    case 2131689625: 
      do
      {
        do
        {
          return true;
          boolean bool;
          if (!this.q)
          {
            bool = true;
            this.q = bool;
            if (!this.q) {
              break label127;
            }
            paramMenuItem.setTitle(2131165269).setIcon(2130837600);
          }
          for (;;)
          {
            new EntryFragment.3(this, ContentUris.withAppendedId(this.n, this.p[this.m])).start();
            return true;
            bool = false;
            break;
            paramMenuItem.setTitle(2131165268).setIcon(2130837601);
          }
          localObject = this.t.b(this.m);
        } while (localObject == null);
        paramMenuItem = ((Cursor)localObject).getString(this.e);
      } while (paramMenuItem == null);
      localObject = ((Cursor)localObject).getString(this.a);
      startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").putExtra("android.intent.extra.SUBJECT", (String)localObject).putExtra("android.intent.extra.TEXT", paramMenuItem).setType("text/plain"), getString(2131165267)));
      return true;
    case 2131689626: 
      a(true);
      return true;
    case 2131689627: 
      label127:
      paramMenuItem = this.t.b(this.m).getString(this.e);
      ((ClipboardManager)((Activity)localObject).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copied Text", paramMenuItem));
      Toast.makeText((Context)localObject, 2131165217, 0).show();
      return true;
    }
    new EntryFragment.4(this, ContentUris.withAppendedId(this.n, this.p[this.m])).start();
    ((Activity)localObject).finish();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    this.t.e();
  }
  
  public void onResume()
  {
    super.onResume();
    this.t.d();
    if (((BaseActivity)getActivity()).k())
    {
      this.u.setVisibility(0);
      return;
    }
    this.u.setVisibility(8);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("STATE_BASE_URI", this.n);
    paramBundle.putLongArray("STATE_ENTRIES_IDS", this.p);
    paramBundle.putLong("STATE_INITIAL_ENTRY_ID", this.o);
    paramBundle.putInt("STATE_CURRENT_PAGER_POS", this.m);
    super.onSaveInstanceState(paramBundle);
  }
}
