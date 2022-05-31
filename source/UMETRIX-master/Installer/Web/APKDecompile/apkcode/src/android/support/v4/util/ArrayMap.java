package android.support.v4.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayMap
  extends SimpleArrayMap
  implements Map
{
  MapCollections a;
  
  public ArrayMap() {}
  
  public ArrayMap(int paramInt)
  {
    super(paramInt);
  }
  
  private MapCollections b()
  {
    if (this.a == null) {
      this.a = new ArrayMap.1(this);
    }
    return this.a;
  }
  
  public boolean a(Collection paramCollection)
  {
    return MapCollections.c(this, paramCollection);
  }
  
  public Set entrySet()
  {
    return b().d();
  }
  
  public Set keySet()
  {
    return b().e();
  }
  
  public void putAll(Map paramMap)
  {
    a(this.h + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public Collection values()
  {
    return b().f();
  }
}
