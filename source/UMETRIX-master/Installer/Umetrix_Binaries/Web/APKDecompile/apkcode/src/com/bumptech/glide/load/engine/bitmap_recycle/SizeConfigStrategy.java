package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

@TargetApi(19)
public class SizeConfigStrategy
  implements LruPoolStrategy
{
  private static final Bitmap.Config[] a = { Bitmap.Config.ARGB_8888, null };
  private static final Bitmap.Config[] b = { Bitmap.Config.RGB_565 };
  private static final Bitmap.Config[] c = { Bitmap.Config.ARGB_4444 };
  private static final Bitmap.Config[] d = { Bitmap.Config.ALPHA_8 };
  private final SizeConfigStrategy.KeyPool e = new SizeConfigStrategy.KeyPool();
  private final GroupedLinkedMap f = new GroupedLinkedMap();
  private final Map g = new HashMap();
  
  public SizeConfigStrategy() {}
  
  private SizeConfigStrategy.Key a(SizeConfigStrategy.Key paramKey, int paramInt, Bitmap.Config paramConfig)
  {
    Bitmap.Config[] arrayOfConfig = b(paramConfig);
    int j = arrayOfConfig.length;
    int i = 0;
    for (;;)
    {
      SizeConfigStrategy.Key localKey = paramKey;
      Bitmap.Config localConfig;
      Integer localInteger;
      if (i < j)
      {
        localConfig = arrayOfConfig[i];
        localInteger = (Integer)a(localConfig).ceilingKey(Integer.valueOf(paramInt));
        if ((localInteger == null) || (localInteger.intValue() > paramInt * 8)) {
          break label131;
        }
        if (localInteger.intValue() == paramInt)
        {
          if (localConfig != null) {
            break label116;
          }
          localKey = paramKey;
          if (paramConfig == null) {
            break label113;
          }
        }
      }
      for (;;)
      {
        this.e.a(paramKey);
        localKey = this.e.a(localInteger.intValue(), localConfig);
        label113:
        label116:
        do
        {
          return localKey;
          localKey = paramKey;
        } while (localConfig.equals(paramConfig));
      }
      label131:
      i += 1;
    }
  }
  
  private NavigableMap a(Bitmap.Config paramConfig)
  {
    NavigableMap localNavigableMap = (NavigableMap)this.g.get(paramConfig);
    Object localObject = localNavigableMap;
    if (localNavigableMap == null)
    {
      localObject = new TreeMap();
      this.g.put(paramConfig, localObject);
    }
    return localObject;
  }
  
  private void a(Integer paramInteger, Bitmap.Config paramConfig)
  {
    paramConfig = a(paramConfig);
    Integer localInteger = (Integer)paramConfig.get(paramInteger);
    if (localInteger.intValue() == 1)
    {
      paramConfig.remove(paramInteger);
      return;
    }
    paramConfig.put(paramInteger, Integer.valueOf(localInteger.intValue() - 1));
  }
  
  private static String b(int paramInt, Bitmap.Config paramConfig)
  {
    return "[" + paramInt + "](" + paramConfig + ")";
  }
  
  private static Bitmap.Config[] b(Bitmap.Config paramConfig)
  {
    switch (SizeConfigStrategy.1.a[paramConfig.ordinal()])
    {
    default: 
      return new Bitmap.Config[] { paramConfig };
    case 1: 
      return a;
    case 2: 
      return b;
    case 3: 
      return c;
    }
    return d;
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = (Bitmap)this.f.a();
    if (localBitmap != null) {
      a(Integer.valueOf(Util.a(localBitmap)), localBitmap.getConfig());
    }
    return localBitmap;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = Util.a(paramInt1, paramInt2, paramConfig);
    paramConfig = a(this.e.a(i, paramConfig), i, paramConfig);
    Bitmap localBitmap = (Bitmap)this.f.a(paramConfig);
    if (localBitmap != null)
    {
      a(Integer.valueOf(Util.a(localBitmap)), localBitmap.getConfig());
      if (localBitmap.getConfig() == null) {
        break label86;
      }
    }
    label86:
    for (paramConfig = localBitmap.getConfig();; paramConfig = Bitmap.Config.ARGB_8888)
    {
      localBitmap.reconfigure(paramInt1, paramInt2, paramConfig);
      return localBitmap;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    int i = Util.a(paramBitmap);
    SizeConfigStrategy.Key localKey = this.e.a(i, paramBitmap.getConfig());
    this.f.a(localKey, paramBitmap);
    paramBitmap = a(paramBitmap.getConfig());
    Integer localInteger = (Integer)paramBitmap.get(Integer.valueOf(SizeConfigStrategy.Key.a(localKey)));
    int j = SizeConfigStrategy.Key.a(localKey);
    if (localInteger == null) {}
    for (i = 1;; i = localInteger.intValue() + 1)
    {
      paramBitmap.put(Integer.valueOf(j), Integer.valueOf(i));
      return;
    }
  }
  
  public String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return b(Util.a(paramInt1, paramInt2, paramConfig), paramConfig);
  }
  
  public String b(Bitmap paramBitmap)
  {
    return b(Util.a(paramBitmap), paramBitmap.getConfig());
  }
  
  public int c(Bitmap paramBitmap)
  {
    return Util.a(paramBitmap);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.f).append(", sortedSizes=(");
    Iterator localIterator = this.g.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(localEntry.getKey()).append('[').append(localEntry.getValue()).append("], ");
    }
    if (!this.g.isEmpty()) {
      localStringBuilder.replace(localStringBuilder.length() - 2, localStringBuilder.length(), "");
    }
    return ")}";
  }
}
