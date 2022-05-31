package net.fred.feedex.utils;

import android.text.TextUtils;
import android.util.Log;

public class Dog
{
  private static String a()
  {
    Object localObject = Thread.currentThread().getStackTrace();
    if ((localObject != null) && (localObject.length > 4))
    {
      String str = localObject[4].getClassName();
      if (TextUtils.isEmpty(str)) {
        localObject = "Unknown";
      }
      int i;
      do
      {
        return localObject;
        i = str.lastIndexOf(".");
        localObject = str;
      } while (i <= -1);
      return str.substring(i + 1);
    }
    return "Unknown";
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    Log.e(a(), paramString, paramThrowable);
  }
}
