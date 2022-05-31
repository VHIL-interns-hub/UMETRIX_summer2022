package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.Log;

public class MemorySizeCalculator
{
  private final int a;
  private final int b;
  private final Context c;
  
  public MemorySizeCalculator(Context paramContext)
  {
    this(paramContext, (ActivityManager)paramContext.getSystemService("activity"), new MemorySizeCalculator.DisplayMetricsScreenDimensions(paramContext.getResources().getDisplayMetrics()));
  }
  
  MemorySizeCalculator(Context paramContext, ActivityManager paramActivityManager, MemorySizeCalculator.ScreenDimensions paramScreenDimensions)
  {
    this.c = paramContext;
    int i = a(paramActivityManager);
    int k = paramScreenDimensions.a() * paramScreenDimensions.b() * 4;
    int j = k * 4;
    k *= 2;
    if (k + j <= i)
    {
      this.b = k;
      this.a = j;
      if (Log.isLoggable("MemorySizeCalculator", 3))
      {
        paramContext = new StringBuilder().append("Calculated memory cache size: ").append(a(this.b)).append(" pool size: ").append(a(this.a)).append(" memory class limited? ");
        if (k + j <= i) {
          break label217;
        }
      }
    }
    label217:
    for (boolean bool = true;; bool = false)
    {
      Log.d("MemorySizeCalculator", bool + " max size: " + a(i) + " memoryClass: " + paramActivityManager.getMemoryClass() + " isLowMemoryDevice: " + b(paramActivityManager));
      return;
      int m = Math.round(i / 6.0F);
      this.b = (m * 2);
      this.a = (m * 4);
      break;
    }
  }
  
  private static int a(ActivityManager paramActivityManager)
  {
    int i = paramActivityManager.getMemoryClass();
    boolean bool = b(paramActivityManager);
    float f2 = i * 1024 * 1024;
    if (bool) {}
    for (float f1 = 0.33F;; f1 = 0.4F) {
      return Math.round(f1 * f2);
    }
  }
  
  private String a(int paramInt)
  {
    return Formatter.formatFileSize(this.c, paramInt);
  }
  
  @TargetApi(19)
  private static boolean b(ActivityManager paramActivityManager)
  {
    int i = Build.VERSION.SDK_INT;
    return (i < 11) || ((i >= 19) && (paramActivityManager.isLowRamDevice()));
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.a;
  }
}
