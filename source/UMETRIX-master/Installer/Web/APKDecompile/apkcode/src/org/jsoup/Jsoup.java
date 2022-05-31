package org.jsoup;

import java.io.InputStream;
import org.jsoup.helper.DataUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;

public class Jsoup
{
  public static String a(String paramString1, String paramString2, Whitelist paramWhitelist)
  {
    paramString1 = a(paramString1, paramString2);
    return new Cleaner(paramWhitelist).a(paramString1).b().w();
  }
  
  public static Document a(InputStream paramInputStream, String paramString1, String paramString2)
  {
    return DataUtil.a(paramInputStream, paramString1, paramString2);
  }
  
  public static Document a(String paramString1, String paramString2)
  {
    return Parser.b(paramString1, paramString2);
  }
}
