package org.jsoup.nodes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.Set;
import org.jsoup.helper.StringUtil;

public class Entities
{
  private static final Map a;
  private static final Map b;
  private static final Map c;
  private static final Map d;
  private static final Map e;
  private static final Object[][] f = { { "quot", Integer.valueOf(34) }, { "amp", Integer.valueOf(38) }, { "lt", Integer.valueOf(60) }, { "gt", Integer.valueOf(62) } };
  
  static
  {
    b = new HashMap();
    c = d("entities-base.properties");
    d = a(c);
    a = d("entities-full.properties");
    e = a(a);
    Object[][] arrayOfObject = f;
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object[] arrayOfObject1 = arrayOfObject[i];
      char c1 = (char)((Integer)arrayOfObject1[1]).intValue();
      b.put(Character.valueOf(c1), (String)arrayOfObject1[0]);
      i += 1;
    }
  }
  
  private Entities() {}
  
  private static Map a(Map paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      Character localCharacter = (Character)((Map.Entry)localObject).getValue();
      localObject = (String)((Map.Entry)localObject).getKey();
      if (localHashMap.containsKey(localCharacter))
      {
        if (((String)localObject).toLowerCase().equals(localObject)) {
          localHashMap.put(localCharacter, localObject);
        }
      }
      else {
        localHashMap.put(localCharacter, localObject);
      }
    }
    return localHashMap;
  }
  
  static void a(StringBuilder paramStringBuilder, String paramString, Document.OutputSettings paramOutputSettings, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Entities.EscapeMode localEscapeMode = paramOutputSettings.a();
    paramOutputSettings = paramOutputSettings.b();
    Entities.CoreCharset localCoreCharset = Entities.CoreCharset.a(paramOutputSettings.charset().name());
    Map localMap = localEscapeMode.a();
    int i1 = paramString.length();
    int n = 0;
    int k = 0;
    int m = 0;
    int i2;
    int i;
    if (n < i1)
    {
      i2 = paramString.codePointAt(n);
      if (!paramBoolean2) {
        break label479;
      }
      if (StringUtil.b(i2))
      {
        if (paramBoolean3)
        {
          j = k;
          i = m;
          if (k == 0) {}
        }
        else
        {
          if (m == 0) {
            break label125;
          }
          i = m;
        }
        for (j = k;; j = k)
        {
          n = Character.charCount(i2) + n;
          k = j;
          m = i;
          break;
          label125:
          paramStringBuilder.append(' ');
          i = 1;
        }
      }
      i = 0;
    }
    for (int j = 1;; j = k)
    {
      if (i2 < 65536)
      {
        char c1 = (char)i2;
        switch (c1)
        {
        default: 
          if (a(localCoreCharset, c1, paramOutputSettings)) {
            paramStringBuilder.append(c1);
          }
          break;
        }
        for (;;)
        {
          break;
          paramStringBuilder.append("&amp;");
          continue;
          if (localEscapeMode != Entities.EscapeMode.a)
          {
            paramStringBuilder.append("&nbsp;");
          }
          else
          {
            paramStringBuilder.append("&#xa0;");
            continue;
            if ((!paramBoolean1) || (localEscapeMode == Entities.EscapeMode.a))
            {
              paramStringBuilder.append("&lt;");
            }
            else
            {
              paramStringBuilder.append(c1);
              continue;
              if (!paramBoolean1)
              {
                paramStringBuilder.append("&gt;");
              }
              else
              {
                paramStringBuilder.append(c1);
                continue;
                if (paramBoolean1)
                {
                  paramStringBuilder.append("&quot;");
                }
                else
                {
                  paramStringBuilder.append(c1);
                  continue;
                  if (localMap.containsKey(Character.valueOf(c1))) {
                    paramStringBuilder.append('&').append((String)localMap.get(Character.valueOf(c1))).append(';');
                  } else {
                    paramStringBuilder.append("&#x").append(Integer.toHexString(i2)).append(';');
                  }
                }
              }
            }
          }
        }
      }
      String str = new String(Character.toChars(i2));
      if (paramOutputSettings.canEncode(str))
      {
        paramStringBuilder.append(str);
        break;
      }
      paramStringBuilder.append("&#x").append(Integer.toHexString(i2)).append(';');
      break;
      return;
      label479:
      i = m;
    }
  }
  
  public static boolean a(String paramString)
  {
    return a.containsKey(paramString);
  }
  
  private static boolean a(Entities.CoreCharset paramCoreCharset, char paramChar, CharsetEncoder paramCharsetEncoder)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    switch (Entities.1.a[paramCoreCharset.ordinal()])
    {
    default: 
      bool1 = paramCharsetEncoder.canEncode(paramChar);
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramChar < '?');
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return c.containsKey(paramString);
  }
  
  public static Character c(String paramString)
  {
    return (Character)a.get(paramString);
  }
  
  private static Map d(String paramString)
  {
    Object localObject = new Properties();
    HashMap localHashMap = new HashMap();
    try
    {
      InputStream localInputStream = Entities.class.getResourceAsStream(paramString);
      ((Properties)localObject).load(localInputStream);
      localInputStream.close();
      paramString = ((Properties)localObject).entrySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (Map.Entry)paramString.next();
        char c1 = (char)Integer.parseInt((String)((Map.Entry)localObject).getValue(), 16);
        localHashMap.put((String)((Map.Entry)localObject).getKey(), Character.valueOf(c1));
      }
      return localIOException;
    }
    catch (IOException localIOException)
    {
      throw new MissingResourceException("Error loading entities resource: " + localIOException.getMessage(), "Entities", paramString);
    }
  }
}
