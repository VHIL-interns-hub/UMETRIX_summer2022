package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class IntentCompatHoneycomb
{
  public static Intent a(ComponentName paramComponentName)
  {
    return Intent.makeMainActivity(paramComponentName);
  }
}
