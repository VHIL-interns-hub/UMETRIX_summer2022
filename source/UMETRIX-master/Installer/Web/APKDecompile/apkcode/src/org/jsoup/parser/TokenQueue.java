package org.jsoup.parser;

import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;

public class TokenQueue
{
  private String a;
  private int b = 0;
  
  public TokenQueue(String paramString)
  {
    Validate.a(paramString);
    this.a = paramString;
  }
  
  public static String f(String paramString)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramString.toCharArray();
    int k = paramString.length;
    int j = 0;
    if (i < k)
    {
      char c = paramString[i];
      if (c == '\\') {
        if ((j != 0) && (j == 92)) {
          localStringBuilder.append(c);
        }
      }
      for (;;)
      {
        i += 1;
        j = c;
        break;
        localStringBuilder.append(c);
      }
    }
    return localStringBuilder.toString();
  }
  
  private int i()
  {
    return this.a.length() - this.b;
  }
  
  public String a(char paramChar1, char paramChar2)
  {
    int i1 = 0;
    int i2 = 0;
    int i = -1;
    int j = -1;
    if (a())
    {
      label18:
      if (i >= 0) {
        return this.a.substring(j, i);
      }
    }
    else
    {
      Character localCharacter = Character.valueOf(d());
      int m;
      int k;
      int n;
      if (i1 != 0)
      {
        m = i2;
        k = j;
        if (i1 == 92) {}
      }
      else
      {
        if (!localCharacter.equals(Character.valueOf(paramChar1))) {
          break label159;
        }
        n = i2 + 1;
        m = n;
        k = j;
        if (j == -1)
        {
          k = this.b;
          m = n;
        }
      }
      for (;;)
      {
        n = i;
        if (m > 0)
        {
          n = i;
          if (i1 != 0) {
            n = this.b;
          }
        }
        i1 = localCharacter.charValue();
        i2 = m;
        i = n;
        j = k;
        if (m > 0) {
          break;
        }
        i = n;
        j = k;
        break label18;
        label159:
        m = i2;
        k = j;
        if (localCharacter.equals(Character.valueOf(paramChar2)))
        {
          m = i2 - 1;
          k = j;
        }
      }
    }
    return "";
  }
  
  public boolean a()
  {
    return i() == 0;
  }
  
  public boolean a(String paramString)
  {
    return this.a.regionMatches(true, this.b, paramString, 0, paramString.length());
  }
  
  public boolean a(char... paramVarArgs)
  {
    if (a()) {}
    for (;;)
    {
      return false;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        if (this.a.charAt(this.b) == k) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean a(String... paramVarArgs)
  {
    boolean bool2 = false;
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (a(paramVarArgs[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public String b(String... paramVarArgs)
  {
    int i = this.b;
    while ((!a()) && (!a(paramVarArgs))) {
      this.b += 1;
    }
    return this.a.substring(i, this.b);
  }
  
  public boolean b()
  {
    return (!a()) && (StringUtil.b(this.a.charAt(this.b)));
  }
  
  public boolean b(String paramString)
  {
    if (a(paramString))
    {
      this.b += paramString.length();
      return true;
    }
    return false;
  }
  
  public void c(String paramString)
  {
    if (!a(paramString)) {
      throw new IllegalStateException("Queue did not match expected sequence");
    }
    int i = paramString.length();
    if (i > i()) {
      throw new IllegalStateException("Queue not long enough to consume sequence");
    }
    this.b = (i + this.b);
  }
  
  public boolean c()
  {
    return (!a()) && (Character.isLetterOrDigit(this.a.charAt(this.b)));
  }
  
  public char d()
  {
    String str = this.a;
    int i = this.b;
    this.b = (i + 1);
    return str.charAt(i);
  }
  
  public String d(String paramString)
  {
    int i = this.a.indexOf(paramString, this.b);
    if (i != -1)
    {
      paramString = this.a.substring(this.b, i);
      this.b += paramString.length();
      return paramString;
    }
    return h();
  }
  
  public String e(String paramString)
  {
    String str = d(paramString);
    b(paramString);
    return str;
  }
  
  public boolean e()
  {
    for (boolean bool = false; b(); bool = true) {
      this.b += 1;
    }
    return bool;
  }
  
  public String f()
  {
    int i = this.b;
    while (!a())
    {
      if (!c()) {
        if (!a(new char[] { 124, 95, 45 })) {
          break;
        }
      }
      this.b += 1;
    }
    return this.a.substring(i, this.b);
  }
  
  public String g()
  {
    int i = this.b;
    while (!a())
    {
      if (!c()) {
        if (!a(new char[] { 45, 95 })) {
          break;
        }
      }
      this.b += 1;
    }
    return this.a.substring(i, this.b);
  }
  
  public String h()
  {
    String str = this.a.substring(this.b, this.a.length());
    this.b = this.a.length();
    return str;
  }
  
  public String toString()
  {
    return this.a.substring(this.b);
  }
}
