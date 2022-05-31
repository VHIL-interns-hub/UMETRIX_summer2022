package net.fred.feedex.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import java.util.Locale;
import net.fred.feedex.provider.FeedDataContentProvider;
import net.fred.feedex.utils.UiUtils;

public class AddGoogleNewsActivity
  extends BaseActivity
{
  private static final int[] m = { 2131165253, 2131165254, 2131165245, 2131165251, 2131165246, 2131165250, 2131165249, 2131165247 };
  private static final String[] n = { null, "w", "b", "t", "e", "s", "snc", "m" };
  private static final int[] o = { 2131689559, 2131689560, 2131689561, 2131689562, 2131689563, 2131689564, 2131689565, 2131689566 };
  
  public AddGoogleNewsActivity() {}
  
  public void onClickCancel(View paramView)
  {
    finish();
  }
  
  public void onClickOk(View paramView)
  {
    int i = 0;
    while (i < m.length)
    {
      if (((CheckBox)findViewById(o[i])).isChecked())
      {
        String str = "http://news.google.com/news?hl=" + Locale.getDefault().getLanguage() + "&output=rss";
        paramView = str;
        if (n[i] != null) {
          paramView = str + "&topic=" + n[i];
        }
        FeedDataContentProvider.a(this, paramView, getString(m[i]), true);
      }
      i += 1;
    }
    setResult(-1);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    UiUtils.a(this);
    super.onCreate(paramBundle);
    setResult(0);
    setContentView(2130968602);
    a((Toolbar)findViewById(2131689558));
    g().a(true);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return false;
  }
}
