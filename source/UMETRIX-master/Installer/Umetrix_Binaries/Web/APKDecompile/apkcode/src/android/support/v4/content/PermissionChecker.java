package android.support.v4.content;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.support.v4.app.AppOpsManagerCompat;

public final class PermissionChecker
{
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, Process.myPid(), Process.myUid(), paramContext.getPackageName());
  }
  
  public static int a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramContext.checkPermission(paramString1, paramInt1, paramInt2) == -1) {}
    String str;
    do
    {
      return -1;
      str = AppOpsManagerCompat.a(paramString1);
      if (str == null) {
        return 0;
      }
      paramString1 = paramString2;
      if (paramString2 != null) {
        break;
      }
      paramString1 = paramContext.getPackageManager().getPackagesForUid(paramInt2);
    } while ((paramString1 == null) || (paramString1.length <= 0));
    paramString1 = paramString1[0];
    if (AppOpsManagerCompat.a(paramContext, str, paramString1) != 0) {
      return -2;
    }
    return 0;
  }
}
