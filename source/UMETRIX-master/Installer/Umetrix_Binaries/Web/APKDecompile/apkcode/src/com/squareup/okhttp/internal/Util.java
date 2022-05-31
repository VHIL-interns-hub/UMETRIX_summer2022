package com.squareup.okhttp.internal;

import com.squareup.okhttp.HttpUrl;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Util
{
  public static final byte[] a = new byte[0];
  public static final String[] b = new String[0];
  public static final Charset c = Charset.forName("UTF-8");
  
  public static String a(HttpUrl paramHttpUrl)
  {
    if (paramHttpUrl.h() != HttpUrl.a(paramHttpUrl.c())) {
      return paramHttpUrl.g() + ":" + paramHttpUrl.h();
    }
    return paramHttpUrl.g();
  }
  
  public static String a(String paramString)
  {
    int m = paramString.length();
    int i = 0;
    int j;
    for (;;)
    {
      localObject = paramString;
      if (i >= m) {
        break label119;
      }
      j = paramString.codePointAt(i);
      if ((j <= 31) || (j >= 127)) {
        break;
      }
      i += Character.charCount(j);
    }
    Object localObject = new Buffer();
    ((Buffer)localObject).a(paramString, 0, i);
    if (i < m)
    {
      int k = paramString.codePointAt(i);
      if ((k > 31) && (k < 127)) {}
      for (j = k;; j = 63)
      {
        ((Buffer)localObject).a(j);
        i = Character.charCount(k) + i;
        break;
      }
    }
    localObject = ((Buffer)localObject).q();
    label119:
    return localObject;
  }
  
  public static List a(List paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public static List a(Object... paramVarArgs)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramVarArgs.clone()));
  }
  
  private static List a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfObject1.length;
    int i = 0;
    if (i < k)
    {
      Object localObject1 = paramArrayOfObject1[i];
      int m = paramArrayOfObject2.length;
      int j = 0;
      for (;;)
      {
        if (j < m)
        {
          Object localObject2 = paramArrayOfObject2[j];
          if (localObject1.equals(localObject2)) {
            localArrayList.add(localObject2);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    return localArrayList;
  }
  
  public static Map a(Map paramMap)
  {
    return Collections.unmodifiableMap(new LinkedHashMap(paramMap));
  }
  
  public static ThreadFactory a(String paramString, boolean paramBoolean)
  {
    return new Util.1(paramString, paramBoolean);
  }
  
  public static ByteString a(ByteString paramByteString)
  {
    try
    {
      paramByteString = ByteString.a(MessageDigest.getInstance("SHA-1").digest(paramByteString.g()));
      return paramByteString;
    }
    catch (NoSuchAlgorithmException paramByteString)
    {
      throw new AssertionError(paramByteString);
    }
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) < 0L) || (paramLong2 > paramLong1) || (paramLong1 - paramLong2 < paramLong3)) {
      throw new ArrayIndexOutOfBoundsException();
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void a(Closeable paramCloseable1, Closeable paramCloseable2)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        paramCloseable1.close();
        paramCloseable1 = localObject;
      }
      catch (Throwable paramCloseable1)
      {
        continue;
      }
      try
      {
        paramCloseable2.close();
        paramCloseable2 = paramCloseable1;
      }
      catch (Throwable localThrowable)
      {
        paramCloseable2 = paramCloseable1;
        if (paramCloseable1 != null) {
          continue;
        }
        paramCloseable2 = localThrowable;
        continue;
        if (!(paramCloseable2 instanceof IOException)) {
          continue;
        }
        throw ((IOException)paramCloseable2);
        if (!(paramCloseable2 instanceof RuntimeException)) {
          continue;
        }
        throw ((RuntimeException)paramCloseable2);
        if (!(paramCloseable2 instanceof Error)) {
          continue;
        }
        throw ((Error)paramCloseable2);
        throw new AssertionError(paramCloseable2);
      }
    }
    if (paramCloseable2 == null) {
      return;
    }
  }
  
  public static void a(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (AssertionError paramSocket)
    {
      while (a(paramSocket)) {}
      throw paramSocket;
    }
    catch (RuntimeException paramSocket)
    {
      throw paramSocket;
    }
    catch (Exception paramSocket) {}
  }
  
  public static boolean a(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static boolean a(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = b(paramSource, paramInt, paramTimeUnit);
      return bool;
    }
    catch (IOException paramSource) {}
    return false;
  }
  
  public static boolean a(String[] paramArrayOfString, String paramString)
  {
    return Arrays.asList(paramArrayOfString).contains(paramString);
  }
  
  public static Object[] a(Class paramClass, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    paramArrayOfObject1 = a(paramArrayOfObject1, paramArrayOfObject2);
    return paramArrayOfObject1.toArray((Object[])Array.newInstance(paramClass, paramArrayOfObject1.size()));
  }
  
  public static boolean b(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
  {
    long l2 = System.nanoTime();
    long l1;
    if (paramSource.a().e_()) {
      l1 = paramSource.a().d() - l2;
    }
    for (;;)
    {
      paramSource.a().a(Math.min(l1, paramTimeUnit.toNanos(paramInt)) + l2);
      try
      {
        paramTimeUnit = new Buffer();
        while (paramSource.a(paramTimeUnit, 2048L) != -1L) {
          paramTimeUnit.t();
        }
      }
      catch (InterruptedIOException paramTimeUnit)
      {
        if (l1 == Long.MAX_VALUE) {
          paramSource.a().f();
        }
        for (;;)
        {
          return false;
          l1 = Long.MAX_VALUE;
          break;
          if (l1 == Long.MAX_VALUE) {
            paramSource.a().f();
          }
          for (;;)
          {
            return true;
            paramSource.a().a(l1 + l2);
          }
          paramSource.a().a(l1 + l2);
        }
      }
      finally
      {
        if (l1 != Long.MAX_VALUE) {
          break label188;
        }
      }
    }
    paramSource.a().f();
    for (;;)
    {
      throw paramTimeUnit;
      label188:
      paramSource.a().a(l1 + l2);
    }
  }
  
  public static String[] b(String[] paramArrayOfString, String paramString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[(arrayOfString.length - 1)] = paramString;
    return arrayOfString;
  }
}
