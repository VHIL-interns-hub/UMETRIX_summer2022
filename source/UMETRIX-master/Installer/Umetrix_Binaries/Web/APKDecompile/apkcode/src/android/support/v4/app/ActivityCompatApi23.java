package android.support.v4.app;

import android.app.Activity;

class ActivityCompatApi23
{
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    if ((paramActivity instanceof ActivityCompatApi23.RequestPermissionsRequestCodeValidator)) {
      ((ActivityCompatApi23.RequestPermissionsRequestCodeValidator)paramActivity).a(paramInt);
    }
    paramActivity.requestPermissions(paramArrayOfString, paramInt);
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    return paramActivity.shouldShowRequestPermissionRationale(paramString);
  }
}
