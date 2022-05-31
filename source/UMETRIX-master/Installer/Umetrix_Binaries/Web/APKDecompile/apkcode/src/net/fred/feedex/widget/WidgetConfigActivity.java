package net.fred.feedex.widget;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WidgetConfigActivity
  extends AppCompatActivity
{
  public WidgetConfigActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    int i = 0;
    super.onCreate(paramBundle);
    setResult(0);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      i = localBundle.getInt("appWidgetId", 0);
    }
    if (i == 0) {
      finish();
    }
    setContentView(2130968636);
    if (paramBundle == null)
    {
      paramBundle = new WidgetConfigFragment();
      localBundle = new Bundle();
      localBundle.putInt("ARG_WIDGET_ID", i);
      paramBundle.setArguments(localBundle);
      getFragmentManager().beginTransaction().replace(2131689619, paramBundle).commit();
    }
  }
}
