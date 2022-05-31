package net.fred.feedex.fragment;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;
import java.io.File;
import net.fred.feedex.adapter.FeedsCursorAdapter;
import net.fred.feedex.provider.FeedData.FeedColumns;
import net.fred.feedex.view.DragNDropExpandableListView;

public class EditFeedsListFragment
  extends ListFragment
{
  private final ActionMode.Callback a = new EditFeedsListFragment.1(this);
  private final ActionMode.Callback b = new EditFeedsListFragment.2(this);
  private DragNDropExpandableListView c;
  
  public EditFeedsListFragment() {}
  
  private void a()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    localBuilder.setTitle(2131165289);
    try
    {
      String[] arrayOfString = Environment.getExternalStorageDirectory().list(new EditFeedsListFragment.12(this));
      localBuilder.setItems(arrayOfString, new EditFeedsListFragment.13(this, arrayOfString));
      localBuilder.show();
      return;
    }
    catch (Exception localException)
    {
      Toast.makeText(getActivity(), 2131165227, 1).show();
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, int paramInt1, int paramInt2)
  {
    ContentValues localContentValues = new ContentValues();
    ContentResolver localContentResolver = getActivity().getContentResolver();
    if ((paramBoolean1) && (paramBoolean2))
    {
      localContentValues.put("priority", Integer.valueOf(paramInt1 + 1));
      localContentResolver.update(FeedData.FeedColumns.a(this.c.getItemIdAtPosition(paramInt2)), localContentValues, null, null);
    }
    do
    {
      return;
      if ((!paramBoolean1) && (paramBoolean2))
      {
        localContentValues.put("priority", Integer.valueOf(paramInt1 + 1));
        localContentValues.putNull("groupid");
        localContentResolver.update(FeedData.FeedColumns.a(this.c.getItemIdAtPosition(paramInt2)), localContentValues, null, null);
        return;
      }
    } while (((paramBoolean1) || (paramBoolean2)) && ((!paramBoolean3) || (paramBoolean2)));
    localContentValues.put("priority", Integer.valueOf(ExpandableListView.getPackedPositionChild(paramLong) + 1));
    paramInt1 = this.c.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(paramInt1));
    localContentValues.put("groupid", Long.valueOf(this.c.getItemIdAtPosition(paramInt1)));
    localContentResolver.update(FeedData.FeedColumns.a(this.c.getItemIdAtPosition(paramInt2)), localContentValues, null, null);
  }
  
  private void b()
  {
    if ((Environment.getExternalStorageState().equals("mounted")) || (Environment.getExternalStorageState().equals("mounted_ro"))) {
      try
      {
        Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
        localIntent.setType("text/*");
        startActivityForResult(localIntent, 1);
        return;
      }
      catch (Exception localException)
      {
        a();
        return;
      }
    }
    Toast.makeText(getActivity(), 2131165224, 1).show();
  }
  
  private void c()
  {
    if ((Environment.getExternalStorageState().equals("mounted")) || (Environment.getExternalStorageState().equals("mounted_ro")))
    {
      new Thread(new EditFeedsListFragment.14(this)).start();
      return;
    }
    Toast.makeText(getActivity(), 2131165224, 1).show();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {
        break label37;
      }
      new Thread(new EditFeedsListFragment.11(this, paramIntent)).start();
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label37:
      a();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    setHasOptionsMenu(true);
    super.onCreate(paramBundle);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(2131755013, paramMenu);
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968610, paramViewGroup, false);
    this.c = ((DragNDropExpandableListView)paramLayoutInflater.findViewById(16908298));
    this.c.setFastScrollEnabled(true);
    this.c.setChoiceMode(1);
    this.c.setOnChildClickListener(new EditFeedsListFragment.3(this));
    this.c.setOnGroupClickListener(new EditFeedsListFragment.4(this));
    this.c.setOnItemLongClickListener(new EditFeedsListFragment.5(this));
    this.c.setAdapter(new FeedsCursorAdapter(getActivity(), FeedData.FeedColumns.g));
    this.c.setDragNDropListener(new EditFeedsListFragment.6(this));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    getLoaderManager().destroyLoader(0);
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = super.onOptionsItemSelected(paramMenuItem);
    }
    do
    {
      do
      {
        return bool;
        paramMenuItem = new AlertDialog.Builder(getActivity());
        AlertDialog.Builder localBuilder = paramMenuItem.setTitle(2131165257);
        String str1 = getString(2131165206);
        String str2 = getString(2131165252);
        EditFeedsListFragment.7 local7 = new EditFeedsListFragment.7(this);
        localBuilder.setItems(new CharSequence[] { str1, str2 }, local7);
        paramMenuItem.show();
        return true;
        paramMenuItem = new EditText(getActivity());
        paramMenuItem.setSingleLine(true);
        new AlertDialog.Builder(getActivity()).setTitle(2131165207).setView(paramMenuItem).setPositiveButton(17039370, new EditFeedsListFragment.8(this, paramMenuItem)).setNegativeButton(17039360, null).show();
        return true;
        if (ContextCompat.a(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
          break;
        }
        if (ActivityCompat.a(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE"))
        {
          localBuilder = new AlertDialog.Builder(getActivity());
          localBuilder.setMessage(2131165323).setPositiveButton(17039370, new EditFeedsListFragment.10(this, paramMenuItem)).setNegativeButton(17039360, new EditFeedsListFragment.9(this));
          localBuilder.show();
          return true;
        }
        if (paramMenuItem.getItemId() == 2131689636)
        {
          ActivityCompat.a(getActivity(), new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 2);
          return true;
        }
      } while (paramMenuItem.getItemId() != 2131689635);
      ActivityCompat.a(getActivity(), new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 1);
      return true;
      if (paramMenuItem.getItemId() == 2131689636)
      {
        c();
        return true;
      }
    } while (paramMenuItem.getItemId() != 2131689635);
    b();
    return true;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramArrayOfInt.length <= 0) || (paramArrayOfInt[0] != 0));
      c();
      return;
    } while ((paramArrayOfInt.length <= 0) || (paramArrayOfInt[0] != 0));
    b();
  }
}
