package net.fred.feedex.widget;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.fred.feedex.provider.FeedData.FeedColumns;

public class WidgetConfigFragment
  extends PreferenceFragment
{
  public WidgetConfigFragment() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099650);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = (WidgetConfigActivity)paramLayoutInflater.getContext();
    paramBundle = (PreferenceCategory)findPreference("widget.visiblefeeds");
    int j = getArguments().getInt("ARG_WIDGET_ID");
    Cursor localCursor = paramViewGroup.getContentResolver().query(FeedData.FeedColumns.e, new String[] { "_id", "ifnull(name,url) as title" }, null, null, null);
    if (localCursor.moveToFirst())
    {
      int[] arrayOfInt = new int[localCursor.getCount() + 1];
      CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(paramViewGroup);
      localCheckBoxPreference.setTitle(2131165209);
      paramBundle.addPreference(localCheckBoxPreference);
      localCheckBoxPreference.setKey("0");
      localCheckBoxPreference.setDisableDependentsState(true);
      arrayOfInt[0] = 0;
      int i = 1;
      while (!localCursor.isAfterLast())
      {
        localCheckBoxPreference = new CheckBoxPreference(paramViewGroup);
        localCheckBoxPreference.setTitle(localCursor.getString(1));
        arrayOfInt[i] = localCursor.getInt(0);
        localCheckBoxPreference.setKey(Integer.toString(arrayOfInt[i]));
        paramBundle.addPreference(localCheckBoxPreference);
        localCheckBoxPreference.setDependency("0");
        localCursor.moveToNext();
        i += 1;
      }
      localCursor.close();
      paramViewGroup.findViewById(2131689620).setOnClickListener(new WidgetConfigFragment.1(this, paramBundle, j, paramViewGroup));
      return paramLayoutInflater;
    }
    localCursor.close();
    paramViewGroup.setResult(-1, new Intent().putExtra("appWidgetId", j));
    return paramLayoutInflater;
  }
}
