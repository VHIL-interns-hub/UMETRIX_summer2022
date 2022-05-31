package org.jsoup.helper;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public final class DataUtil
{
  private static final Pattern a = Pattern.compile("(?i)\\bcharset=\\s*(?:\"|')?([^\\s,;\"']*)");
  private static final char[] b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  
  static String a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      paramString = a.matcher(paramString);
      if (paramString.find())
      {
        paramString = paramString.group(1).trim().replace("charset=", "");
        if (paramString.length() != 0) {
          try
          {
            if (Charset.isSupported(paramString)) {
              return paramString;
            }
            paramString = paramString.toUpperCase(Locale.ENGLISH);
            boolean bool = Charset.isSupported(paramString);
            if (bool) {
              return paramString;
            }
          }
          catch (IllegalCharsetNameException paramString) {}
        }
      }
    }
    return null;
  }
  
  static ByteBuffer a(InputStream paramInputStream)
  {
    return a(paramInputStream, 0);
  }
  
  static ByteBuffer a(InputStream paramInputStream, int paramInt)
  {
    int i = 1;
    boolean bool;
    label20:
    byte[] arrayOfByte;
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramInt >= 0)
    {
      bool = true;
      Validate.a(bool, "maxSize must be 0 (unlimited) or larger");
      if (paramInt <= 0) {
        break label66;
      }
      arrayOfByte = new byte[131072];
      localByteArrayOutputStream = new ByteArrayOutputStream(131072);
    }
    for (;;)
    {
      int k = paramInputStream.read(arrayOfByte);
      if (k == -1) {}
      for (;;)
      {
        return ByteBuffer.wrap(localByteArrayOutputStream.toByteArray());
        bool = false;
        break;
        label66:
        i = 0;
        break label20;
        j = paramInt;
        if (i == 0) {
          break label100;
        }
        if (k <= paramInt) {
          break label95;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, paramInt);
      }
      label95:
      int j = paramInt - k;
      label100:
      localByteArrayOutputStream.write(arrayOfByte, 0, k);
      paramInt = j;
    }
  }
  
  public static Document a(InputStream paramInputStream, String paramString1, String paramString2)
  {
    return a(a(paramInputStream), paramString1, paramString2, Parser.b());
  }
  
  static Document a(ByteBuffer paramByteBuffer, String paramString1, String paramString2, Parser paramParser)
  {
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (paramString1 == null)
    {
      localObject3 = Charset.forName("UTF-8").decode(paramByteBuffer).toString();
      localObject4 = paramParser.a((String)localObject3, paramString2);
      localObject5 = ((Document)localObject4).b("meta[http-equiv=content-type], meta[charset]").c();
      if (localObject5 == null) {
        break label304;
      }
      if (!((Element)localObject5).g("http-equiv")) {
        break label315;
      }
    }
    Object localObject1;
    label304:
    label315:
    for (String str = a(((Element)localObject5).f("content"));; localObject1 = null)
    {
      Object localObject2 = str;
      if (str == null)
      {
        localObject2 = str;
        if (((Element)localObject5).g("charset")) {
          localObject2 = str;
        }
      }
      for (;;)
      {
        try
        {
          if (Charset.isSupported(((Element)localObject5).f("charset"))) {
            localObject2 = ((Element)localObject5).f("charset");
          }
          if ((localObject2 == null) || (((String)localObject2).length() == 0) || (((String)localObject2).equals("UTF-8"))) {
            break label304;
          }
          paramString1 = ((String)localObject2).trim().replaceAll("[\"']", "");
          paramByteBuffer.rewind();
          localObject2 = Charset.forName(paramString1).decode(paramByteBuffer).toString();
          str = null;
          localObject3 = str;
          localObject5 = localObject2;
          localObject4 = paramString1;
          if (((String)localObject2).length() > 0)
          {
            localObject3 = str;
            localObject5 = localObject2;
            localObject4 = paramString1;
            if (((String)localObject2).charAt(0) == 65279)
            {
              paramByteBuffer.rewind();
              localObject5 = Charset.forName("UTF-8").decode(paramByteBuffer).toString().substring(1);
              localObject4 = "UTF-8";
              localObject3 = null;
            }
          }
          paramByteBuffer = (ByteBuffer)localObject3;
          if (localObject3 == null)
          {
            paramByteBuffer = paramParser.a((String)localObject5, paramString2);
            paramByteBuffer.e().a((String)localObject4);
          }
          return paramByteBuffer;
        }
        catch (IllegalCharsetNameException localIllegalCharsetNameException)
        {
          localObject2 = null;
          continue;
        }
        Validate.a(paramString1, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
        localObject2 = Charset.forName(paramString1).decode(paramByteBuffer).toString();
        localObject1 = null;
        continue;
        localObject1 = localObject4;
        localObject2 = localObject3;
      }
    }
  }
}
