package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.HashMap;
import java.util.Map;

class GroupedLinkedMap
{
  private final GroupedLinkedMap.LinkedEntry a = new GroupedLinkedMap.LinkedEntry();
  private final Map b = new HashMap();
  
  GroupedLinkedMap() {}
  
  private void a(GroupedLinkedMap.LinkedEntry paramLinkedEntry)
  {
    d(paramLinkedEntry);
    paramLinkedEntry.b = this.a;
    paramLinkedEntry.a = this.a.a;
    c(paramLinkedEntry);
  }
  
  private void b(GroupedLinkedMap.LinkedEntry paramLinkedEntry)
  {
    d(paramLinkedEntry);
    paramLinkedEntry.b = this.a.b;
    paramLinkedEntry.a = this.a;
    c(paramLinkedEntry);
  }
  
  private static void c(GroupedLinkedMap.LinkedEntry paramLinkedEntry)
  {
    paramLinkedEntry.a.b = paramLinkedEntry;
    paramLinkedEntry.b.a = paramLinkedEntry;
  }
  
  private static void d(GroupedLinkedMap.LinkedEntry paramLinkedEntry)
  {
    paramLinkedEntry.b.a = paramLinkedEntry.a;
    paramLinkedEntry.a.b = paramLinkedEntry.b;
  }
  
  public Object a()
  {
    for (GroupedLinkedMap.LinkedEntry localLinkedEntry = this.a.b; !localLinkedEntry.equals(this.a); localLinkedEntry = localLinkedEntry.b)
    {
      Object localObject = localLinkedEntry.a();
      if (localObject != null) {
        return localObject;
      }
      d(localLinkedEntry);
      this.b.remove(GroupedLinkedMap.LinkedEntry.a(localLinkedEntry));
      ((Poolable)GroupedLinkedMap.LinkedEntry.a(localLinkedEntry)).a();
    }
    return null;
  }
  
  public Object a(Poolable paramPoolable)
  {
    GroupedLinkedMap.LinkedEntry localLinkedEntry = (GroupedLinkedMap.LinkedEntry)this.b.get(paramPoolable);
    if (localLinkedEntry == null)
    {
      localLinkedEntry = new GroupedLinkedMap.LinkedEntry(paramPoolable);
      this.b.put(paramPoolable, localLinkedEntry);
    }
    for (paramPoolable = localLinkedEntry;; paramPoolable = localLinkedEntry)
    {
      a(paramPoolable);
      return paramPoolable.a();
      paramPoolable.a();
    }
  }
  
  public void a(Poolable paramPoolable, Object paramObject)
  {
    GroupedLinkedMap.LinkedEntry localLinkedEntry = (GroupedLinkedMap.LinkedEntry)this.b.get(paramPoolable);
    if (localLinkedEntry == null)
    {
      localLinkedEntry = new GroupedLinkedMap.LinkedEntry(paramPoolable);
      b(localLinkedEntry);
      this.b.put(paramPoolable, localLinkedEntry);
    }
    for (paramPoolable = localLinkedEntry;; paramPoolable = localLinkedEntry)
    {
      paramPoolable.a(paramObject);
      return;
      paramPoolable.a();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GroupedLinkedMap( ");
    GroupedLinkedMap.LinkedEntry localLinkedEntry = this.a.a;
    int i = 0;
    while (!localLinkedEntry.equals(this.a))
    {
      i = 1;
      localStringBuilder.append('{').append(GroupedLinkedMap.LinkedEntry.a(localLinkedEntry)).append(':').append(localLinkedEntry.b()).append("}, ");
      localLinkedEntry = localLinkedEntry.a;
    }
    if (i != 0) {
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    }
    return " )";
  }
}
