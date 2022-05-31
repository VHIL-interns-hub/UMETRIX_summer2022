package com.squareup.okhttp.internal;

import com.squareup.okhttp.Route;
import java.util.LinkedHashSet;
import java.util.Set;

public final class RouteDatabase
{
  private final Set a = new LinkedHashSet();
  
  public RouteDatabase() {}
  
  public void a(Route paramRoute)
  {
    try
    {
      this.a.add(paramRoute);
      return;
    }
    finally
    {
      paramRoute = finally;
      throw paramRoute;
    }
  }
  
  public void b(Route paramRoute)
  {
    try
    {
      this.a.remove(paramRoute);
      return;
    }
    finally
    {
      paramRoute = finally;
      throw paramRoute;
    }
  }
  
  public boolean c(Route paramRoute)
  {
    try
    {
      boolean bool = this.a.contains(paramRoute);
      return bool;
    }
    finally
    {
      paramRoute = finally;
      throw paramRoute;
    }
  }
}
