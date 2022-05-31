package net.fred.feedex.parser;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Xml;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.fred.feedex.MainApplication;
import net.fred.feedex.provider.FeedData.FeedColumns;
import net.fred.feedex.provider.FeedData.FilterColumns;

public class OPML
{
  public static final String a = Environment.getExternalStorageDirectory() + "/Flym_auto_backup.opml";
  private static final String[] b = { "_id", "isgroup", "name", "url", "retrievefulltext" };
  private static final String[] c = { "filtertext", "isregex", "isappliedtotitle", "isacceptrule" };
  private static final OPML.OPMLParser d = new OPML.OPMLParser(null);
  private static boolean e = true;
  
  public static void a(InputStream paramInputStream)
  {
    Xml.parse(new InputStreamReader(paramInputStream), d);
  }
  
  public static void a(String paramString)
  {
    if (a.equals(paramString)) {
      e = false;
    }
    try
    {
      Xml.parse(new InputStreamReader(new FileInputStream(paramString)), d);
      return;
    }
    finally
    {
      e = true;
    }
  }
  
  public static void b(String paramString)
  {
    if ((a.equals(paramString)) && (!e)) {
      return;
    }
    Cursor localCursor1 = MainApplication.a().getContentResolver().query(FeedData.FeedColumns.g, b, null, null, null);
    StringBuilder localStringBuilder = new StringBuilder("<?xml version='1.0' encoding='utf-8'?>\n<opml version='1.1'>\n<head>\n<title>Flym export</title>\n<dateCreated>");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("</dateCreated>\n</head>\n<body>\n");
    while (localCursor1.moveToNext())
    {
      localStringBuilder.append("\t<outline title='");
      Cursor localCursor2;
      label179:
      label230:
      Cursor localCursor3;
      if (localCursor1.isNull(2))
      {
        str = "";
        localStringBuilder.append(str);
        if (localCursor1.getInt(1) != 1) {
          break label519;
        }
        localStringBuilder.append("'>\n");
        localCursor2 = MainApplication.a().getContentResolver().query(FeedData.FeedColumns.b(localCursor1.getString(0)), b, null, null, null);
        if (!localCursor2.moveToNext()) {
          break label502;
        }
        localStringBuilder.append("\t");
        localStringBuilder.append("\t<outline title='");
        if (!localCursor2.isNull(2)) {
          break label429;
        }
        str = "";
        localStringBuilder.append(str);
        localStringBuilder.append("' type='rss' xmlUrl='");
        localStringBuilder.append(TextUtils.htmlEncode(localCursor2.getString(3)));
        localStringBuilder.append("' retrieveFullText='");
        if (localCursor2.getInt(4) != 1) {
          break label444;
        }
        str = "true";
        localStringBuilder.append(str);
        localCursor3 = MainApplication.a().getContentResolver().query(FeedData.FilterColumns.a(localCursor2.getString(0)), c, null, null, null);
        if (localCursor3.getCount() == 0) {
          break label492;
        }
        localStringBuilder.append("'>\n");
        label281:
        if (!localCursor3.moveToNext()) {
          break label468;
        }
        localStringBuilder.append("\t");
        localStringBuilder.append("\t\t<filter text='");
        localStringBuilder.append(TextUtils.htmlEncode(localCursor3.getString(0)));
        localStringBuilder.append("' isRegex='");
        if (localCursor3.getInt(1) != 1) {
          break label450;
        }
        str = "true";
        label343:
        localStringBuilder.append(str);
        localStringBuilder.append("' isAppliedToTitle='");
        if (localCursor3.getInt(2) != 1) {
          break label456;
        }
        str = "true";
        label371:
        localStringBuilder.append(str);
        localStringBuilder.append("' isAcceptRule='");
        if (localCursor3.getInt(3) != 1) {
          break label462;
        }
      }
      label429:
      label444:
      label450:
      label456:
      label462:
      for (String str = "true";; str = "false")
      {
        localStringBuilder.append(str);
        localStringBuilder.append("'/>\n");
        break label281;
        str = TextUtils.htmlEncode(localCursor1.getString(2));
        break;
        str = TextUtils.htmlEncode(localCursor2.getString(2));
        break label179;
        str = "false";
        break label230;
        str = "false";
        break label343;
        str = "false";
        break label371;
      }
      label468:
      localStringBuilder.append("\t");
      localStringBuilder.append("\t</outline>\n");
      for (;;)
      {
        localCursor3.close();
        break;
        label492:
        localStringBuilder.append("'/>\n");
      }
      label502:
      localCursor2.close();
      localStringBuilder.append("\t</outline>\n");
      continue;
      label519:
      localStringBuilder.append("' type='rss' xmlUrl='");
      localStringBuilder.append(TextUtils.htmlEncode(localCursor1.getString(3)));
      localStringBuilder.append("' retrieveFullText='");
      if (localCursor1.getInt(4) == 1)
      {
        str = "true";
        localStringBuilder.append(str);
        localCursor2 = MainApplication.a().getContentResolver().query(FeedData.FilterColumns.a(localCursor1.getString(0)), c, null, null, null);
        if (localCursor2.getCount() == 0) {
          break label780;
        }
        localStringBuilder.append("'>\n");
        label612:
        if (!localCursor2.moveToNext()) {
          break label763;
        }
        localStringBuilder.append("\t\t<filter text='");
        localStringBuilder.append(TextUtils.htmlEncode(localCursor2.getString(0)));
        localStringBuilder.append("' isRegex='");
        if (localCursor2.getInt(1) != 1) {
          break label745;
        }
        str = "true";
        label667:
        localStringBuilder.append(str);
        localStringBuilder.append("' isAppliedToTitle='");
        if (localCursor2.getInt(2) != 1) {
          break label751;
        }
        str = "true";
        label695:
        localStringBuilder.append(str);
        localStringBuilder.append("' isAcceptRule='");
        if (localCursor2.getInt(3) != 1) {
          break label757;
        }
      }
      label745:
      label751:
      label757:
      for (str = "true";; str = "false")
      {
        localStringBuilder.append(str);
        localStringBuilder.append("'/>\n");
        break label612;
        str = "false";
        break;
        str = "false";
        break label667;
        str = "false";
        break label695;
      }
      label763:
      localStringBuilder.append("\t</outline>\n");
      for (;;)
      {
        localCursor2.close();
        break;
        label780:
        localStringBuilder.append("'/>\n");
      }
    }
    localStringBuilder.append("</body>\n</opml>\n");
    localCursor1.close();
    paramString = new BufferedWriter(new FileWriter(paramString));
    paramString.write(localStringBuilder.toString());
    paramString.close();
  }
}
