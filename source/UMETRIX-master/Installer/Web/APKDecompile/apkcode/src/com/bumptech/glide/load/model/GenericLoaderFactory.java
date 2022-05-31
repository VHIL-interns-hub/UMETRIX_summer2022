package com.bumptech.glide.load.model;

import android.content.Context;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GenericLoaderFactory
{
  private static final ModelLoader c = new GenericLoaderFactory.1();
  private final Map a = new HashMap();
  private final Map b = new HashMap();
  private final Context d;
  
  public GenericLoaderFactory(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
  }
  
  private void a(Class paramClass1, Class paramClass2, ModelLoader paramModelLoader)
  {
    Map localMap = (Map)this.b.get(paramClass1);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.b.put(paramClass1, localObject);
    }
    ((Map)localObject).put(paramClass2, paramModelLoader);
  }
  
  private void b(Class paramClass1, Class paramClass2)
  {
    a(paramClass1, paramClass2, c);
  }
  
  private ModelLoader c(Class paramClass1, Class paramClass2)
  {
    paramClass1 = (Map)this.b.get(paramClass1);
    if (paramClass1 != null) {
      return (ModelLoader)paramClass1.get(paramClass2);
    }
    return null;
  }
  
  private ModelLoaderFactory d(Class paramClass1, Class paramClass2)
  {
    Object localObject1 = (Map)this.a.get(paramClass1);
    if (localObject1 != null) {}
    for (localObject1 = (ModelLoaderFactory)((Map)localObject1).get(paramClass2);; localObject1 = null)
    {
      Object localObject2 = localObject1;
      Iterator localIterator;
      if (localObject1 == null) {
        localIterator = this.a.keySet().iterator();
      }
      while (localIterator.hasNext())
      {
        localObject2 = (Class)localIterator.next();
        if (((Class)localObject2).isAssignableFrom(paramClass1))
        {
          localObject2 = (Map)this.a.get(localObject2);
          if (localObject2 != null)
          {
            localObject2 = (ModelLoaderFactory)((Map)localObject2).get(paramClass2);
            localObject1 = localObject2;
            if (localObject2 != null) {
              return localObject2;
            }
          }
        }
      }
      return localObject1;
    }
  }
  
  public ModelLoader a(Class paramClass1, Class paramClass2)
  {
    for (;;)
    {
      ModelLoader localModelLoader;
      try
      {
        localModelLoader = c(paramClass1, paramClass2);
        if (localModelLoader != null)
        {
          boolean bool = c.equals(localModelLoader);
          paramClass1 = localModelLoader;
          if (bool) {
            paramClass1 = null;
          }
          return paramClass1;
        }
        ModelLoaderFactory localModelLoaderFactory = d(paramClass1, paramClass2);
        if (localModelLoaderFactory != null)
        {
          localModelLoader = localModelLoaderFactory.a(this.d, this);
          a(paramClass1, paramClass2, localModelLoader);
          paramClass1 = localModelLoader;
          continue;
        }
        b(paramClass1, paramClass2);
      }
      finally {}
      paramClass1 = localModelLoader;
    }
  }
  
  public ModelLoaderFactory a(Class paramClass1, Class paramClass2, ModelLoaderFactory paramModelLoaderFactory)
  {
    try
    {
      this.b.clear();
      Map localMap = (Map)this.a.get(paramClass1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new HashMap();
        this.a.put(paramClass1, localObject);
      }
      paramClass2 = (ModelLoaderFactory)((Map)localObject).put(paramClass2, paramModelLoaderFactory);
      paramClass1 = paramClass2;
      if (paramClass2 != null)
      {
        paramModelLoaderFactory = this.a.values().iterator();
        boolean bool;
        do
        {
          paramClass1 = paramClass2;
          if (!paramModelLoaderFactory.hasNext()) {
            break;
          }
          bool = ((Map)paramModelLoaderFactory.next()).containsValue(paramClass2);
        } while (!bool);
        paramClass1 = null;
      }
      return paramClass1;
    }
    finally {}
  }
}
