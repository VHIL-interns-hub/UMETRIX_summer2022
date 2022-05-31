package org.jsoup.helper;

public final class Validate
{
  public static void a(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("Object must not be null");
    }
  }
  
  public static void a(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("String must not be empty");
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      throw new IllegalArgumentException(paramString2);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException("Must be true");
    }
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static void a(Object[] paramArrayOfObject)
  {
    a(paramArrayOfObject, "Array must not contain any null objects");
  }
  
  public static void a(Object[] paramArrayOfObject, String paramString)
  {
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfObject[i] == null) {
        throw new IllegalArgumentException(paramString);
      }
      i += 1;
    }
  }
  
  public static void b(String paramString)
  {
    throw new IllegalArgumentException(paramString);
  }
  
  public static void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new IllegalArgumentException("Must be false");
    }
  }
  
  public static void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      throw new IllegalArgumentException(paramString);
    }
  }
}
