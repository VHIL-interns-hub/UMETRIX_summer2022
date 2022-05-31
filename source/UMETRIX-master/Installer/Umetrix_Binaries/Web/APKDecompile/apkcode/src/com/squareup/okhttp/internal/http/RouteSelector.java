package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Dns;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.RouteDatabase;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class RouteSelector
{
  private final Address a;
  private final RouteDatabase b;
  private Proxy c;
  private InetSocketAddress d;
  private List e = Collections.emptyList();
  private int f;
  private List g = Collections.emptyList();
  private int h;
  private final List i = new ArrayList();
  
  public RouteSelector(Address paramAddress, RouteDatabase paramRouteDatabase)
  {
    this.a = paramAddress;
    this.b = paramRouteDatabase;
    a(paramAddress.a(), paramAddress.j());
  }
  
  static String a(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {
      return paramInetSocketAddress.getHostName();
    }
    return localInetAddress.getHostAddress();
  }
  
  private void a(HttpUrl paramHttpUrl, Proxy paramProxy)
  {
    if (paramProxy != null) {
      this.e = Collections.singletonList(paramProxy);
    }
    for (;;)
    {
      this.f = 0;
      return;
      this.e = new ArrayList();
      paramHttpUrl = this.a.i().select(paramHttpUrl.b());
      if (paramHttpUrl != null) {
        this.e.addAll(paramHttpUrl);
      }
      this.e.removeAll(Collections.singleton(Proxy.NO_PROXY));
      this.e.add(Proxy.NO_PROXY);
    }
  }
  
  private void a(Proxy paramProxy)
  {
    this.g = new ArrayList();
    Object localObject;
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS)) {
      localObject = this.a.b();
    }
    InetSocketAddress localInetSocketAddress;
    for (int j = this.a.c(); (j < 1) || (j > 65535); j = localInetSocketAddress.getPort())
    {
      throw new SocketException("No route to " + (String)localObject + ":" + j + "; port is out of range");
      localObject = paramProxy.address();
      if (!(localObject instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + localObject.getClass());
      }
      localInetSocketAddress = (InetSocketAddress)localObject;
      localObject = a(localInetSocketAddress);
    }
    if (paramProxy.type() == Proxy.Type.SOCKS) {
      this.g.add(InetSocketAddress.createUnresolved((String)localObject, j));
    }
    for (;;)
    {
      this.h = 0;
      return;
      paramProxy = this.a.d().a((String)localObject);
      int m = paramProxy.size();
      int k = 0;
      while (k < m)
      {
        localObject = (InetAddress)paramProxy.get(k);
        this.g.add(new InetSocketAddress((InetAddress)localObject, j));
        k += 1;
      }
    }
  }
  
  private boolean c()
  {
    return this.f < this.e.size();
  }
  
  private Proxy d()
  {
    if (!c()) {
      throw new SocketException("No route to " + this.a.b() + "; exhausted proxy configurations: " + this.e);
    }
    Object localObject = this.e;
    int j = this.f;
    this.f = (j + 1);
    localObject = (Proxy)((List)localObject).get(j);
    a((Proxy)localObject);
    return localObject;
  }
  
  private boolean e()
  {
    return this.h < this.g.size();
  }
  
  private InetSocketAddress f()
  {
    if (!e()) {
      throw new SocketException("No route to " + this.a.b() + "; exhausted inet socket addresses: " + this.g);
    }
    List localList = this.g;
    int j = this.h;
    this.h = (j + 1);
    return (InetSocketAddress)localList.get(j);
  }
  
  private boolean g()
  {
    return !this.i.isEmpty();
  }
  
  private Route h()
  {
    return (Route)this.i.remove(0);
  }
  
  public void a(Route paramRoute, IOException paramIOException)
  {
    if ((paramRoute.b().type() != Proxy.Type.DIRECT) && (this.a.i() != null)) {
      this.a.i().connectFailed(this.a.a().b(), paramRoute.b().address(), paramIOException);
    }
    this.b.a(paramRoute);
  }
  
  public boolean a()
  {
    return (e()) || (c()) || (g());
  }
  
  public Route b()
  {
    Object localObject;
    if (!e()) {
      if (!c())
      {
        if (!g()) {
          throw new NoSuchElementException();
        }
        localObject = h();
      }
    }
    Route localRoute;
    do
    {
      return localObject;
      this.c = d();
      this.d = f();
      localRoute = new Route(this.a, this.c, this.d);
      localObject = localRoute;
    } while (!this.b.c(localRoute));
    this.i.add(localRoute);
    return b();
  }
}
