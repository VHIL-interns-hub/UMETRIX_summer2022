package net.fred.feedex.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import net.fred.feedex.MainApplication;

@TargetApi(18)
public class StringUtils
{
  private static final java.text.DateFormat a = android.text.format.DateFormat.getTimeFormat(MainApplication.a());
  private static java.text.DateFormat b = android.text.format.DateFormat.getDateFormat(MainApplication.a());
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      b = new SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(MainApplication.a().getResources().getConfiguration().locale, "d MMM"));
      return;
    }
  }
  
  public static String a(long paramLong)
  {
    Date localDate = new Date(paramLong);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong);
    Calendar localCalendar2 = Calendar.getInstance();
    if ((localCalendar2.getTimeInMillis() - paramLong < 21600000L) || (localCalendar2.get(5) == localCalendar1.get(5))) {
      return a.format(localDate);
    }
    return b.format(localDate) + ' ' + a.format(localDate);
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = new BigInteger(1, MessageDigest.getInstance("MD5").digest(paramString.getBytes())).toString(16);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return null;
  }
}
