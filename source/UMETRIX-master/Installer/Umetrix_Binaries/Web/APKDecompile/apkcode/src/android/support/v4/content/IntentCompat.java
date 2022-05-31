package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class IntentCompat
{
  private static final IntentCompat.IntentCompatImpl a = new IntentCompat.IntentCompatImplBase();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 15)
    {
      a = new IntentCompat.IntentCompatImplIcsMr1();
      return;
    }
    if (i >= 11)
    {
      a = new IntentCompat.IntentCompatImplHC();
      return;
    }
  }
  
  public static Intent a(ComponentName paramComponentName)
  {
    return a.a(paramComponentName);
  }
}
