package net.fred.feedex.fragment;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.text.TextUtils;
import net.fred.feedex.MainApplication;
import net.fred.feedex.utils.PrefUtils;

public class GeneralPrefsFragment
  extends PreferenceFragment
{
  public GeneralPrefsFragment() {}
  
  private void a()
  {
    Preference localPreference = findPreference("notifications.ringtone");
    Object localObject = Uri.parse(PrefUtils.a("notifications.ringtone", ""));
    if (TextUtils.isEmpty(((Uri)localObject).toString()))
    {
      localPreference.setSummary(2131165308);
      return;
    }
    localObject = RingtoneManager.getRingtone(MainApplication.a(), (Uri)localObject);
    if (localObject == null)
    {
      localPreference.setSummary(2131165308);
      return;
    }
    localPreference.setSummary(((Ringtone)localObject).getTitle(MainApplication.a()));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099648);
    a();
    findPreference("refresh.enabled").setOnPreferenceChangeListener(new GeneralPrefsFragment.1(this));
    findPreference("lighttheme").setOnPreferenceChangeListener(new GeneralPrefsFragment.2(this));
  }
  
  public void onResume()
  {
    a();
    super.onResume();
  }
}
