package com.bumptech.glide.provider;

import com.bumptech.glide.util.MultiClassKey;
import java.util.HashMap;
import java.util.Map;

public class DataLoadProviderRegistry
{
  private static final MultiClassKey a = new MultiClassKey();
  private final Map b = new HashMap();
  
  public DataLoadProviderRegistry() {}
  
  public DataLoadProvider a(Class paramClass1, Class paramClass2)
  {
    synchronized (a)
    {
      a.a(paramClass1, paramClass2);
      paramClass2 = (DataLoadProvider)this.b.get(a);
      paramClass1 = paramClass2;
      if (paramClass2 == null) {
        paramClass1 = EmptyDataLoadProvider.e();
      }
      return paramClass1;
    }
  }
  
  public void a(Class paramClass1, Class paramClass2, DataLoadProvider paramDataLoadProvider)
  {
    this.b.put(new MultiClassKey(paramClass1, paramClass2), paramDataLoadProvider);
  }
}
