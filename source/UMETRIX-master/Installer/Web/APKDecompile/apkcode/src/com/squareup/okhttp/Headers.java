package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class Headers
{
  private final String[] a;
  
  private Headers(Headers.Builder paramBuilder)
  {
    this.a = ((String[])Headers.Builder.a(paramBuilder).toArray(new String[Headers.Builder.a(paramBuilder).size()]));
  }
  
  private static String a(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase(paramArrayOfString[i])) {
        return paramArrayOfString[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public int a()
  {
    return this.a.length / 2;
  }
  
  public String a(int paramInt)
  {
    paramInt *= 2;
    if ((paramInt < 0) || (paramInt >= this.a.length)) {
      return null;
    }
    return this.a[paramInt];
  }
  
  public String a(String paramString)
  {
    return a(this.a, paramString);
  }
  
  public Headers.Builder b()
  {
    Headers.Builder localBuilder = new Headers.Builder();
    Collections.addAll(Headers.Builder.a(localBuilder), this.a);
    return localBuilder;
  }
  
  public String b(int paramInt)
  {
    paramInt = paramInt * 2 + 1;
    if ((paramInt < 0) || (paramInt >= this.a.length)) {
      return null;
    }
    return this.a[paramInt];
  }
  
  public Date b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return HttpDate.a(paramString);
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = a();
    while (i < j)
    {
      localStringBuilder.append(a(i)).append(": ").append(b(i)).append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}
