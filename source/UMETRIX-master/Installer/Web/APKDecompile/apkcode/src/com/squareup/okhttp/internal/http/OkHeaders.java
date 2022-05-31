package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Platform;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class OkHeaders
{
  static final String a = Platform.a().b();
  public static final String b = a + "-Sent-Millis";
  public static final String c = a + "-Received-Millis";
  public static final String d = a + "-Selected-Protocol";
  public static final String e = a + "-Response-Source";
  private static final Comparator f = new OkHeaders.1();
  
  public static long a(Headers paramHeaders)
  {
    return b(paramHeaders.a("Content-Length"));
  }
  
  public static long a(Request paramRequest)
  {
    return a(paramRequest.f());
  }
  
  public static long a(Response paramResponse)
  {
    return a(paramResponse.f());
  }
  
  public static Request a(Authenticator paramAuthenticator, Response paramResponse, Proxy paramProxy)
  {
    if (paramResponse.c() == 407) {
      return paramAuthenticator.b(paramProxy, paramResponse);
    }
    return paramAuthenticator.a(paramProxy, paramResponse);
  }
  
  private static String a(List paramList)
  {
    if (paramList.size() == 1) {
      return (String)paramList.get(0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append("; ");
      }
      localStringBuilder.append((String)paramList.get(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static Map a(Headers paramHeaders, String paramString)
  {
    TreeMap localTreeMap = new TreeMap(f);
    int j = paramHeaders.a();
    int i = 0;
    while (i < j)
    {
      String str1 = paramHeaders.a(i);
      String str2 = paramHeaders.b(i);
      ArrayList localArrayList = new ArrayList();
      List localList = (List)localTreeMap.get(str1);
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      localArrayList.add(str2);
      localTreeMap.put(str1, Collections.unmodifiableList(localArrayList));
      i += 1;
    }
    if (paramString != null) {
      localTreeMap.put(null, Collections.unmodifiableList(Collections.singletonList(paramString)));
    }
    return Collections.unmodifiableMap(localTreeMap);
  }
  
  public static void a(Request.Builder paramBuilder, Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      if ((("Cookie".equalsIgnoreCase(str)) || ("Cookie2".equalsIgnoreCase(str))) && (!((List)localEntry.getValue()).isEmpty())) {
        paramBuilder.b(str, a((List)localEntry.getValue()));
      }
    }
  }
  
  static boolean a(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  private static long b(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  public static List b(Headers paramHeaders, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramHeaders.a();
    int i = 0;
    if (i < k)
    {
      if (!paramString.equalsIgnoreCase(paramHeaders.a(i))) {}
      label177:
      for (;;)
      {
        i += 1;
        break;
        String str1 = paramHeaders.b(i);
        int j = 0;
        for (;;)
        {
          if (j >= str1.length()) {
            break label177;
          }
          int m = HeaderParser.a(str1, j, " ");
          String str2 = str1.substring(j, m).trim();
          j = HeaderParser.a(str1, m);
          if (!str1.regionMatches(true, j, "realm=\"", 0, "realm=\"".length())) {
            break;
          }
          j = "realm=\"".length() + j;
          m = HeaderParser.a(str1, j, "\"");
          String str3 = str1.substring(j, m);
          j = HeaderParser.a(str1, HeaderParser.a(str1, m + 1, ",") + 1);
          localArrayList.add(new Challenge(str2, str3));
        }
      }
    }
    return localArrayList;
  }
}
