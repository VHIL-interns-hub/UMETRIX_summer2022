package android.support.v4.content;

import android.content.Context;
import android.content.Intent;

class ContextCompatHoneycomb
{
  static void a(Context paramContext, Intent[] paramArrayOfIntent)
  {
    paramContext.startActivities(paramArrayOfIntent);
  }
}
