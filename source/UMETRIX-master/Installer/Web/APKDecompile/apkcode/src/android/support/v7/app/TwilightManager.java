package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import java.util.Calendar;

class TwilightManager
{
  private static final TwilightManager.TwilightState a = new TwilightManager.TwilightState(null);
  private final Context b;
  private final LocationManager c;
  
  TwilightManager(Context paramContext)
  {
    this.b = paramContext;
    this.c = ((LocationManager)paramContext.getSystemService("location"));
  }
  
  private Location a(String paramString)
  {
    if (this.c != null) {
      try
      {
        if (this.c.isProviderEnabled(paramString))
        {
          paramString = this.c.getLastKnownLocation(paramString);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.d("TwilightManager", "Failed to get last known location", paramString);
      }
    }
    return null;
  }
  
  private void a(Location paramLocation)
  {
    TwilightManager.TwilightState localTwilightState = a;
    long l1 = System.currentTimeMillis();
    TwilightCalculator localTwilightCalculator = TwilightCalculator.a();
    localTwilightCalculator.a(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = localTwilightCalculator.a;
    localTwilightCalculator.a(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (localTwilightCalculator.c == 1) {}
    long l3;
    long l4;
    long l5;
    for (boolean bool = true;; bool = false)
    {
      l3 = localTwilightCalculator.b;
      l4 = localTwilightCalculator.a;
      localTwilightCalculator.a(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = localTwilightCalculator.b;
      if ((l3 != -1L) && (l4 != -1L)) {
        break;
      }
      l1 = 43200000L + l1;
      localTwilightState.a = bool;
      localTwilightState.b = l2;
      localTwilightState.c = l3;
      localTwilightState.d = l4;
      localTwilightState.e = l5;
      localTwilightState.f = l1;
      return;
    }
    if (l1 > l4) {
      l1 = 0L + l5;
    }
    for (;;)
    {
      l1 += 60000L;
      break;
      if (l1 > l3) {
        l1 = 0L + l4;
      } else {
        l1 = 0L + l3;
      }
    }
  }
  
  private boolean a(TwilightManager.TwilightState paramTwilightState)
  {
    return (paramTwilightState != null) && (paramTwilightState.f > System.currentTimeMillis());
  }
  
  private Location b()
  {
    Object localObject1 = null;
    if (PermissionChecker.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {}
    for (Location localLocation = a("network");; localLocation = null)
    {
      if (PermissionChecker.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        localObject1 = a("gps");
      }
      if ((localObject1 != null) && (localLocation != null))
      {
        Object localObject2 = localLocation;
        if (((Location)localObject1).getTime() > localLocation.getTime()) {
          localObject2 = localObject1;
        }
        return localObject2;
      }
      if (localObject1 != null) {}
      for (;;)
      {
        return localObject1;
        localObject1 = localLocation;
      }
    }
  }
  
  boolean a()
  {
    TwilightManager.TwilightState localTwilightState = a;
    if (a(localTwilightState)) {
      return localTwilightState.a;
    }
    Location localLocation = b();
    if (localLocation != null)
    {
      a(localLocation);
      return localTwilightState.a;
    }
    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
    int i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }
}
