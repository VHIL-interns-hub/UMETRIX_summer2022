package org.jsoup.helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class StringUtil
{
  private static final String[] a = { "", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          " };
  
  public static String a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("width must be > 0");
    }
    if (paramInt < a.length) {
      return a[paramInt];
    }
    char[] arrayOfChar = new char[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfChar[i] = ' ';
      i += 1;
    }
    return String.valueOf(arrayOfChar);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new URL(paramString1);
      return "";
    }
    catch (MalformedURLException paramString1)
    {
      try
      {
        return a(paramString1, paramString2).toExternalForm();
      }
      catch (MalformedURLException paramString1) {}
      paramString1 = paramString1;
      paramString1 = new URL(paramString2).toExternalForm();
      return paramString1;
    }
  }
  
  public static String a(Collection paramCollection, String paramString)
  {
    return a(paramCollection.iterator(), paramString);
  }
  
  public static String a(Iterator paramIterator, String paramString)
  {
    if (!paramIterator.hasNext()) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = paramIterator.next().toString();
      localObject = str;
    } while (!paramIterator.hasNext());
    Object localObject = new StringBuilder(64).append(str);
    while (paramIterator.hasNext())
    {
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(paramIterator.next());
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static URL a(URL paramURL, String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("?")) {
      str = paramURL.getPath() + paramString;
    }
    paramString = paramURL;
    if (str.indexOf('.') == 0)
    {
      paramString = paramURL;
      if (paramURL.getFile().indexOf('/') != 0) {
        paramString = new URL(paramURL.getProtocol(), paramURL.getHost(), paramURL.getPort(), "/" + paramURL.getFile());
      }
    }
    return new URL(paramString, str);
  }
  
  public static void a(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean)
  {
    int i1 = paramString.length();
    int j = 0;
    int m = 0;
    int n = 0;
    if (j < i1)
    {
      int i2 = paramString.codePointAt(j);
      int k;
      int i;
      if (b(i2)) {
        if (paramBoolean)
        {
          k = m;
          i = n;
          if (m == 0) {}
        }
        else
        {
          if (n == 0) {
            break label86;
          }
          i = n;
          k = m;
        }
      }
      for (;;)
      {
        j += Character.charCount(i2);
        m = k;
        n = i;
        break;
        label86:
        paramStringBuilder.append(' ');
        i = 1;
        k = m;
        continue;
        paramStringBuilder.appendCodePoint(i2);
        k = 1;
        i = 0;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramString == null) || (paramString.length() == 0))
    {
      bool1 = true;
      return bool1;
    }
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label51;
      }
      bool1 = bool2;
      if (!b(paramString.codePointAt(i))) {
        break;
      }
      i += 1;
    }
    label51:
    return true;
  }
  
  public static boolean a(String paramString, String... paramVarArgs)
  {
    boolean bool2 = false;
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramVarArgs[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 32) || (paramInt == 9) || (paramInt == 10) || (paramInt == 12) || (paramInt == 13);
  }
  
  public static boolean b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label43;
      }
      if (!Character.isDigit(paramString.codePointAt(i))) {
        break;
      }
      i += 1;
    }
    label43:
    return true;
  }
  
  public static boolean b(String paramString, String[] paramArrayOfString)
  {
    return Arrays.binarySearch(paramArrayOfString, paramString) >= 0;
  }
}
