package org.jsoup.parser;

import java.util.Arrays;
import java.util.Locale;
import org.jsoup.helper.Validate;

final class CharacterReader
{
  private final char[] a;
  private final int b;
  private int c = 0;
  private int d = 0;
  private final String[] e = new String['?'];
  
  CharacterReader(String paramString)
  {
    Validate.a(paramString);
    this.a = paramString.toCharArray();
    this.b = this.a.length;
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    int k = 0;
    char[] arrayOfChar = this.a;
    Object localObject = this.e;
    if (paramInt2 > 12) {
      localObject = new String(arrayOfChar, paramInt1, paramInt2);
    }
    String str;
    do
    {
      return localObject;
      int i = paramInt1;
      int j = 0;
      while (k < paramInt2)
      {
        int m = arrayOfChar[i];
        k += 1;
        j = m + j * 31;
        i += 1;
      }
      i = j & localObject.length - 1;
      str = localObject[i];
      if (str == null)
      {
        str = new String(arrayOfChar, paramInt1, paramInt2);
        localObject[i] = str;
        return str;
      }
      localObject = str;
    } while (a(paramInt1, paramInt2, str));
    return new String(arrayOfChar, paramInt1, paramInt2);
  }
  
  int a()
  {
    return this.c;
  }
  
  int a(char paramChar)
  {
    int i = this.c;
    while (i < this.b)
    {
      if (paramChar == this.a[i]) {
        return i - this.c;
      }
      i += 1;
    }
    return -1;
  }
  
  int a(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.charAt(0);
    int j;
    for (int i = this.c; i < this.b; i = j + 1)
    {
      j = i;
      if (m != this.a[i])
      {
        j = i;
        do
        {
          i = j + 1;
          j = i;
          if (i >= this.b) {
            break;
          }
          j = i;
        } while (m != this.a[i]);
        j = i;
      }
      int k = j + 1;
      int n = paramCharSequence.length() + k - 1;
      if ((j < this.b) && (n <= this.b))
      {
        i = 1;
        while ((k < n) && (paramCharSequence.charAt(i) == this.a[k]))
        {
          k += 1;
          i += 1;
        }
        if (k == n) {
          return j - this.c;
        }
      }
    }
    return -1;
  }
  
  String a(String paramString)
  {
    int i = a(paramString);
    if (i != -1)
    {
      paramString = a(this.c, i);
      this.c = (i + this.c);
      return paramString;
    }
    return k();
  }
  
  String a(char... paramVarArgs)
  {
    int j = this.c;
    int k = this.b;
    for (;;)
    {
      int m;
      int i;
      if (this.c < k)
      {
        m = paramVarArgs.length;
        i = 0;
      }
      while (i < m)
      {
        int n = paramVarArgs[i];
        if (this.a[this.c] == n)
        {
          if (this.c <= j) {
            break label91;
          }
          return a(j, this.c - j);
        }
        i += 1;
      }
      this.c += 1;
    }
    label91:
    return "";
  }
  
  boolean a(int paramInt1, int paramInt2, String paramString)
  {
    char[] arrayOfChar;
    int i;
    if (paramInt2 == paramString.length())
    {
      arrayOfChar = this.a;
      i = 0;
    }
    for (;;)
    {
      if (paramInt2 != 0)
      {
        if (arrayOfChar[paramInt1] != paramString.charAt(i)) {
          return false;
        }
      }
      else {
        return true;
      }
      i += 1;
      paramInt1 += 1;
      paramInt2 -= 1;
    }
  }
  
  String b(char paramChar)
  {
    int i = a(paramChar);
    if (i != -1)
    {
      String str = a(this.c, i);
      this.c = (i + this.c);
      return str;
    }
    return k();
  }
  
  String b(char... paramVarArgs)
  {
    int i = this.c;
    int j = this.b;
    char[] arrayOfChar = this.a;
    for (;;)
    {
      if ((this.c >= j) || (Arrays.binarySearch(paramVarArgs, arrayOfChar[this.c]) >= 0))
      {
        if (this.c <= i) {
          break;
        }
        return a(i, this.c - i);
      }
      this.c += 1;
    }
    return "";
  }
  
  boolean b()
  {
    return this.c >= this.b;
  }
  
  boolean b(String paramString)
  {
    int j = paramString.length();
    if (j > this.b - this.c) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label53;
      }
      if (paramString.charAt(i) != this.a[(this.c + i)]) {
        break;
      }
      i += 1;
    }
    label53:
    return true;
  }
  
  char c()
  {
    if (this.c >= this.b) {
      return 65535;
    }
    return this.a[this.c];
  }
  
  boolean c(char paramChar)
  {
    return (!b()) && (this.a[this.c] == paramChar);
  }
  
  boolean c(String paramString)
  {
    int j = paramString.length();
    if (j > this.b - this.c) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label59;
      }
      if (Character.toUpperCase(paramString.charAt(i)) != Character.toUpperCase(this.a[(this.c + i)])) {
        break;
      }
      i += 1;
    }
    label59:
    return true;
  }
  
  boolean c(char... paramVarArgs)
  {
    if (b()) {}
    for (;;)
    {
      return false;
      int j = this.a[this.c];
      int k = paramVarArgs.length;
      int i = 0;
      while (i < k)
      {
        if (paramVarArgs[i] == j) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  char d()
  {
    if (this.c >= this.b) {}
    int j;
    for (int i = 65535;; j = this.a[this.c])
    {
      this.c += 1;
      return i;
    }
  }
  
  boolean d(String paramString)
  {
    if (b(paramString))
    {
      this.c += paramString.length();
      return true;
    }
    return false;
  }
  
  boolean d(char[] paramArrayOfChar)
  {
    return (!b()) && (Arrays.binarySearch(paramArrayOfChar, this.a[this.c]) >= 0);
  }
  
  void e()
  {
    this.c -= 1;
  }
  
  boolean e(String paramString)
  {
    if (c(paramString))
    {
      this.c += paramString.length();
      return true;
    }
    return false;
  }
  
  void f()
  {
    this.c += 1;
  }
  
  boolean f(String paramString)
  {
    String str = paramString.toLowerCase(Locale.ENGLISH);
    paramString = paramString.toUpperCase(Locale.ENGLISH);
    return (a(str) > -1) || (a(paramString) > -1);
  }
  
  void g()
  {
    this.d = this.c;
  }
  
  void h()
  {
    this.c = this.d;
  }
  
  String i()
  {
    int i = this.c;
    int j = this.b;
    char[] arrayOfChar = this.a;
    for (;;)
    {
      if (this.c < j)
      {
        int k = arrayOfChar[this.c];
        if ((k != 38) && (k != 60) && (k != 0)) {}
      }
      else
      {
        if (this.c <= i) {
          break;
        }
        return a(i, this.c - i);
      }
      this.c += 1;
    }
    return "";
  }
  
  String j()
  {
    int i = this.c;
    int j = this.b;
    char[] arrayOfChar = this.a;
    for (;;)
    {
      if (this.c < j)
      {
        int k = arrayOfChar[this.c];
        if ((k != 9) && (k != 10) && (k != 13) && (k != 12) && (k != 32) && (k != 47) && (k != 62) && (k != 0)) {}
      }
      else
      {
        if (this.c <= i) {
          break;
        }
        return a(i, this.c - i);
      }
      this.c += 1;
    }
    return "";
  }
  
  String k()
  {
    String str = a(this.c, this.b - this.c);
    this.c = this.b;
    return str;
  }
  
  String l()
  {
    int i = this.c;
    while (this.c < this.b)
    {
      int j = this.a[this.c];
      if (((j < 65) || (j > 90)) && ((j < 97) || (j > 122))) {
        break;
      }
      this.c += 1;
    }
    return a(i, this.c - i);
  }
  
  String m()
  {
    int i = this.c;
    int j;
    while (this.c < this.b)
    {
      j = this.a[this.c];
      if (((j < 65) || (j > 90)) && ((j < 97) || (j > 122))) {
        break;
      }
      this.c += 1;
    }
    while (!b())
    {
      j = this.a[this.c];
      if ((j < 48) || (j > 57)) {
        break;
      }
      this.c += 1;
    }
    return a(i, this.c - i);
  }
  
  String n()
  {
    int i = this.c;
    while (this.c < this.b)
    {
      int j = this.a[this.c];
      if (((j < 48) || (j > 57)) && ((j < 65) || (j > 70)) && ((j < 97) || (j > 102))) {
        break;
      }
      this.c += 1;
    }
    return a(i, this.c - i);
  }
  
  String o()
  {
    int i = this.c;
    while (this.c < this.b)
    {
      int j = this.a[this.c];
      if ((j < 48) || (j > 57)) {
        break;
      }
      this.c += 1;
    }
    return a(i, this.c - i);
  }
  
  boolean p()
  {
    if (b()) {}
    int i;
    do
    {
      return false;
      i = this.a[this.c];
    } while (((i < 65) || (i > 90)) && ((i < 97) || (i > 122)));
    return true;
  }
  
  boolean q()
  {
    if (b()) {}
    int i;
    do
    {
      return false;
      i = this.a[this.c];
    } while ((i < 48) || (i > 57));
    return true;
  }
  
  public String toString()
  {
    return new String(this.a, this.c, this.b - this.c);
  }
}
