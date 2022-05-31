package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class ConnectionPool
{
  private static final ConnectionPool c;
  final RouteDatabase a = new RouteDatabase();
  private final Executor d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.a("OkHttp ConnectionPool", true));
  private final int e;
  private final long f;
  private Runnable g = new ConnectionPool.1(this);
  private final Deque h = new ArrayDeque();
  
  static
  {
    boolean bool;
    String str1;
    String str2;
    String str3;
    if (!ConnectionPool.class.desiredAssertionStatus())
    {
      bool = true;
      b = bool;
      str1 = System.getProperty("http.keepAlive");
      str2 = System.getProperty("http.keepAliveDuration");
      str3 = System.getProperty("http.maxConnections");
      if (str2 == null) {
        break label74;
      }
    }
    label74:
    for (long l = Long.parseLong(str2);; l = 300000L)
    {
      if ((str1 == null) || (Boolean.parseBoolean(str1))) {
        break label81;
      }
      c = new ConnectionPool(0, l);
      return;
      bool = false;
      break;
    }
    label81:
    if (str3 != null)
    {
      c = new ConnectionPool(Integer.parseInt(str3), l);
      return;
    }
    c = new ConnectionPool(5, l);
  }
  
  public ConnectionPool(int paramInt, long paramLong)
  {
    this(paramInt, paramLong, TimeUnit.MILLISECONDS);
  }
  
  public ConnectionPool(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.e = paramInt;
    this.f = paramTimeUnit.toNanos(paramLong);
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("keepAliveDuration <= 0: " + paramLong);
    }
  }
  
  private int a(RealConnection paramRealConnection, long paramLong)
  {
    List localList = paramRealConnection.f;
    int i = 0;
    while (i < localList.size()) {
      if (((Reference)localList.get(i)).get() != null)
      {
        i += 1;
      }
      else
      {
        Internal.a.warning("A connection to " + paramRealConnection.a().a().a() + " was leaked. Did you forget to close a response body?");
        localList.remove(i);
        paramRealConnection.g = true;
        if (localList.isEmpty())
        {
          paramRealConnection.h = (paramLong - this.f);
          return 0;
        }
      }
    }
    return localList.size();
  }
  
  public static ConnectionPool a()
  {
    return c;
  }
  
  long a(long paramLong)
  {
    Object localObject1 = null;
    long l1 = Long.MIN_VALUE;
    for (;;)
    {
      int j;
      int i;
      try
      {
        Iterator localIterator = this.h.iterator();
        j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          RealConnection localRealConnection = (RealConnection)localIterator.next();
          if (a(localRealConnection, paramLong) > 0)
          {
            i += 1;
            continue;
          }
          long l2 = paramLong - localRealConnection.h;
          if (l2 <= l1) {
            break label179;
          }
          localObject1 = localRealConnection;
          l1 = l2;
          break label179;
        }
        if ((l1 >= this.f) || (j > this.e))
        {
          this.h.remove(localObject1);
          Util.a(localObject1.d());
          return 0L;
        }
        if (j > 0)
        {
          paramLong = this.f;
          return paramLong - l1;
        }
      }
      finally {}
      if (i > 0)
      {
        paramLong = this.f;
        return paramLong;
      }
      return -1L;
      label179:
      j += 1;
    }
  }
  
  RealConnection a(Address paramAddress, StreamAllocation paramStreamAllocation)
  {
    if ((!b) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      RealConnection localRealConnection = (RealConnection)localIterator.next();
      if ((localRealConnection.f.size() < localRealConnection.e()) && (paramAddress.equals(localRealConnection.a().a)) && (!localRealConnection.g))
      {
        paramStreamAllocation.a(localRealConnection);
        return localRealConnection;
      }
    }
    return null;
  }
  
  void a(RealConnection paramRealConnection)
  {
    if ((!b) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if (this.h.isEmpty()) {
      this.d.execute(this.g);
    }
    this.h.add(paramRealConnection);
  }
  
  boolean b(RealConnection paramRealConnection)
  {
    if ((!b) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if ((paramRealConnection.g) || (this.e == 0))
    {
      this.h.remove(paramRealConnection);
      return true;
    }
    notifyAll();
    return false;
  }
}
