package com.squareup.okhttp.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class HttpDate
{
  private static final TimeZone a = TimeZone.getTimeZone("GMT");
  private static final ThreadLocal b = new HttpDate.1();
  private static final String[] c = { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z" };
  private static final DateFormat[] d = new DateFormat[c.length];
  
  public static String a(Date paramDate)
  {
    return ((DateFormat)b.get()).format(paramDate);
  }
  
  public static Date a(String paramString)
  {
    int i = 0;
    Object localObject;
    if (paramString.length() == 0) {
      localObject = null;
    }
    ParsePosition localParsePosition;
    do
    {
      return localObject;
      localParsePosition = new ParsePosition(0);
      localObject = ((DateFormat)b.get()).parse(paramString, localParsePosition);
    } while (localParsePosition.getIndex() == paramString.length());
    for (;;)
    {
      synchronized (c)
      {
        int j = c.length;
        if (i >= j) {
          break;
        }
        DateFormat localDateFormat = d[i];
        localObject = localDateFormat;
        if (localDateFormat == null)
        {
          localObject = new SimpleDateFormat(c[i], Locale.US);
          ((DateFormat)localObject).setTimeZone(a);
          d[i] = localObject;
        }
        localParsePosition.setIndex(0);
        localObject = ((DateFormat)localObject).parse(paramString, localParsePosition);
        if (localParsePosition.getIndex() != 0) {
          return localObject;
        }
      }
      i += 1;
    }
    return null;
  }
}
