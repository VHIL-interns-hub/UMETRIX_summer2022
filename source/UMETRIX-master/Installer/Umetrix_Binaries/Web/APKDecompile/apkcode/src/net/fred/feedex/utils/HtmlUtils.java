package net.fred.feedex.utils;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class HtmlUtils
{
  private static final Whitelist a = Whitelist.a().a(new String[] { "iframe", "video", "audio", "source", "track" }).a("iframe", new String[] { "src", "frameborder", "height", "width" }).a("video", new String[] { "src", "controls", "height", "width", "poster" }).a("audio", new String[] { "src", "controls" }).a("source", new String[] { "src", "type" }).a("track", new String[] { "src", "kind", "srclang", "label" });
  private static final Pattern b = Pattern.compile("<img\\s+[^>]*src=\\s*['\"]([^'\"]+)['\"][^>]*>", 2);
  private static final Pattern c = Pattern.compile("<div class=('|\")mf-viral('|\")><table border=('|\")0('|\")>.*", 2);
  private static final Pattern d = Pattern.compile("\\s+src=[^>]+\\s+original[-]*src=(\"|')", 2);
  private static final Pattern e = Pattern.compile("<img\\s+(height=['\"]1['\"]\\s+width=['\"]1['\"]|width=['\"]1['\"]\\s+height=['\"]1['\"])\\s+[^>]*src=\\s*['\"]([^'\"]+)['\"][^>]*>", 2);
  private static final Pattern f = Pattern.compile("\\s+(href|src)=(\"|')//", 2);
  private static final Pattern g = Pattern.compile("<img\\s+[^>]*src=\\s*['\"]([^'\"]+)\\.img['\"][^>]*>", 2);
  private static final Pattern h = Pattern.compile("^(\\s*<br\\s*[/]*>\\s*)*", 2);
  private static final Pattern i = Pattern.compile("(\\s*<br\\s*[/]*>\\s*)*$", 2);
  private static final Pattern j = Pattern.compile("(\\s*<br\\s*[/]*>\\s*){3,}", 2);
  private static final Pattern k = Pattern.compile("<a\\s+[^>]*></a>", 2);
  
  public static String a(String paramString, long paramLong)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      boolean bool = NetworkUtils.a();
      ArrayList localArrayList = new ArrayList();
      localObject = b.matcher(paramString);
      while (((Matcher)localObject).find())
      {
        String str1 = ((Matcher)localObject).group(1).replace(" ", "%20");
        String str2 = NetworkUtils.b(paramLong, str1);
        if (new File(str2).exists()) {
          paramString = paramString.replace(str1, "file://" + str2);
        } else if (bool) {
          localArrayList.add(str1);
        }
      }
      localObject = paramString;
      if (!localArrayList.isEmpty())
      {
        new Thread(new HtmlUtils.1(paramLong, localArrayList)).start();
        localObject = paramString;
      }
    }
    return localObject;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = c.matcher(paramString1).replaceAll("");
    paramString1 = str;
    if (str != null)
    {
      paramString1 = c.matcher(str).replaceAll("");
      paramString1 = Jsoup.a(d.matcher(paramString1).replaceAll(" src=$1"), paramString2, a);
      paramString1 = e.matcher(paramString1).replaceAll("");
      paramString1 = g.matcher(paramString1).replaceAll("");
      paramString1 = k.matcher(paramString1).replaceAll("");
      paramString1 = f.matcher(paramString1).replaceAll(" $1=$2http://");
      paramString1 = h.matcher(paramString1).replaceAll("");
      paramString1 = i.matcher(paramString1).replaceAll("");
      paramString1 = j.matcher(paramString1).replaceAll("<br><br>");
    }
    return paramString1;
  }
  
  public static String a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (c(str)) {
        return str;
      }
    }
    return null;
  }
  
  public static ArrayList a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = b.matcher(paramString);
      while (paramString.find()) {
        localArrayList.add(paramString.group(1).replace(" ", "%20"));
      }
    }
    return localArrayList;
  }
  
  public static String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = b.matcher(paramString);
      while (paramString.find())
      {
        String str = paramString.group(1).replace(" ", "%20");
        if (c(str)) {
          return str;
        }
      }
    }
    return null;
  }
  
  private static boolean c(String paramString)
  {
    return (!paramString.endsWith(".gif")) && (!paramString.endsWith(".GIF")) && (!paramString.endsWith(".img")) && (!paramString.endsWith(".IMG"));
  }
}
