package net.fred.feedex.view;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;

public class AutoSummaryListPreference
  extends ListPreference
{
  public AutoSummaryListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDialogClosed(boolean paramBoolean)
  {
    super.onDialogClosed(paramBoolean);
    if (paramBoolean) {
      setSummary(getEntry());
    }
  }
  
  protected void onSetInitialValue(boolean paramBoolean, Object paramObject)
  {
    super.onSetInitialValue(paramBoolean, paramObject);
    setSummary(getEntry());
  }
}
