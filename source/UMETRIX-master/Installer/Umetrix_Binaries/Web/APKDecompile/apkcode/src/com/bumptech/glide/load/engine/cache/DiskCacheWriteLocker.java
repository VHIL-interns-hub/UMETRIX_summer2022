package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

final class DiskCacheWriteLocker
{
  private final Map a = new HashMap();
  private final DiskCacheWriteLocker.WriteLockPool b = new DiskCacheWriteLocker.WriteLockPool(null);
  
  DiskCacheWriteLocker() {}
  
  void a(Key paramKey)
  {
    try
    {
      DiskCacheWriteLocker.WriteLock localWriteLock2 = (DiskCacheWriteLocker.WriteLock)this.a.get(paramKey);
      DiskCacheWriteLocker.WriteLock localWriteLock1 = localWriteLock2;
      if (localWriteLock2 == null)
      {
        localWriteLock1 = this.b.a();
        this.a.put(paramKey, localWriteLock1);
      }
      localWriteLock1.b += 1;
      localWriteLock1.a.lock();
      return;
    }
    finally {}
  }
  
  void b(Key paramKey)
  {
    DiskCacheWriteLocker.WriteLock localWriteLock1;
    for (;;)
    {
      try
      {
        localWriteLock1 = (DiskCacheWriteLocker.WriteLock)this.a.get(paramKey);
        if ((localWriteLock1 != null) && (localWriteLock1.b > 0)) {
          break;
        }
        paramKey = new StringBuilder().append("Cannot release a lock that is not held, key: ").append(paramKey).append(", interestedThreads: ");
        if (localWriteLock1 == null)
        {
          i = 0;
          throw new IllegalArgumentException(i);
        }
      }
      finally {}
      i = localWriteLock1.b;
    }
    int i = localWriteLock1.b - 1;
    localWriteLock1.b = i;
    if (i == 0)
    {
      DiskCacheWriteLocker.WriteLock localWriteLock2 = (DiskCacheWriteLocker.WriteLock)this.a.remove(paramKey);
      if (!localWriteLock2.equals(localWriteLock1)) {
        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + localWriteLock1 + ", but actually removed: " + localWriteLock2 + ", key: " + paramKey);
      }
      this.b.a(localWriteLock2);
    }
    localWriteLock1.a.unlock();
  }
}
