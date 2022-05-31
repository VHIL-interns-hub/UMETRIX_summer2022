package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.disklrucache.DiskLruCache.Value;
import com.bumptech.glide.load.Key;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper
  implements DiskCache
{
  private static DiskLruCacheWrapper a = null;
  private final DiskCacheWriteLocker b = new DiskCacheWriteLocker();
  private final SafeKeyGenerator c;
  private final File d;
  private final int e;
  private DiskLruCache f;
  
  protected DiskLruCacheWrapper(File paramFile, int paramInt)
  {
    this.d = paramFile;
    this.e = paramInt;
    this.c = new SafeKeyGenerator();
  }
  
  private DiskLruCache a()
  {
    try
    {
      if (this.f == null) {
        this.f = DiskLruCache.a(this.d, 1, 1, this.e);
      }
      DiskLruCache localDiskLruCache = this.f;
      return localDiskLruCache;
    }
    finally {}
  }
  
  public static DiskCache a(File paramFile, int paramInt)
  {
    try
    {
      if (a == null) {
        a = new DiskLruCacheWrapper(paramFile, paramInt);
      }
      paramFile = a;
      return paramFile;
    }
    finally {}
  }
  
  public File a(Key paramKey)
  {
    paramKey = this.c.a(paramKey);
    Object localObject = null;
    try
    {
      DiskLruCache.Value localValue = a().a(paramKey);
      paramKey = localObject;
      if (localValue != null) {
        paramKey = localValue.a(0);
      }
    }
    catch (IOException localIOException)
    {
      do
      {
        paramKey = localObject;
      } while (!Log.isLoggable("DiskLruCacheWrapper", 5));
      Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", localIOException);
    }
    return paramKey;
    return null;
  }
  
  /* Error */
  public void a(Key paramKey, DiskCache.Writer paramWriter)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper:c	Lcom/bumptech/glide/load/engine/cache/SafeKeyGenerator;
    //   4: aload_1
    //   5: invokevirtual 58	com/bumptech/glide/load/engine/cache/SafeKeyGenerator:a	(Lcom/bumptech/glide/load/Key;)Ljava/lang/String;
    //   8: astore_3
    //   9: aload_0
    //   10: getfield 32	com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper:b	Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker;
    //   13: aload_1
    //   14: invokevirtual 86	com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker:a	(Lcom/bumptech/glide/load/Key;)V
    //   17: aload_0
    //   18: invokespecial 60	com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper:a	()Lcom/bumptech/glide/disklrucache/DiskLruCache;
    //   21: aload_3
    //   22: invokevirtual 89	com/bumptech/glide/disklrucache/DiskLruCache:b	(Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +25 -> 52
    //   30: aload_2
    //   31: aload_3
    //   32: iconst_0
    //   33: invokevirtual 92	com/bumptech/glide/disklrucache/DiskLruCache$Editor:a	(I)Ljava/io/File;
    //   36: invokeinterface 97 2 0
    //   41: ifeq +7 -> 48
    //   44: aload_3
    //   45: invokevirtual 99	com/bumptech/glide/disklrucache/DiskLruCache$Editor:a	()V
    //   48: aload_3
    //   49: invokevirtual 101	com/bumptech/glide/disklrucache/DiskLruCache$Editor:c	()V
    //   52: aload_0
    //   53: getfield 32	com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper:b	Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker;
    //   56: aload_1
    //   57: invokevirtual 103	com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker:b	(Lcom/bumptech/glide/load/Key;)V
    //   60: return
    //   61: astore_2
    //   62: aload_3
    //   63: invokevirtual 101	com/bumptech/glide/disklrucache/DiskLruCache$Editor:c	()V
    //   66: aload_2
    //   67: athrow
    //   68: astore_2
    //   69: ldc 70
    //   71: iconst_5
    //   72: invokestatic 76	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   75: ifeq +12 -> 87
    //   78: ldc 70
    //   80: ldc 105
    //   82: aload_2
    //   83: invokestatic 82	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   86: pop
    //   87: aload_0
    //   88: getfield 32	com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper:b	Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker;
    //   91: aload_1
    //   92: invokevirtual 103	com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker:b	(Lcom/bumptech/glide/load/Key;)V
    //   95: return
    //   96: astore_2
    //   97: aload_0
    //   98: getfield 32	com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper:b	Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker;
    //   101: aload_1
    //   102: invokevirtual 103	com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker:b	(Lcom/bumptech/glide/load/Key;)V
    //   105: aload_2
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	DiskLruCacheWrapper
    //   0	107	1	paramKey	Key
    //   0	107	2	paramWriter	DiskCache.Writer
    //   8	55	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	48	61	finally
    //   17	26	68	java/io/IOException
    //   48	52	68	java/io/IOException
    //   62	68	68	java/io/IOException
    //   17	26	96	finally
    //   48	52	96	finally
    //   62	68	96	finally
    //   69	87	96	finally
  }
  
  public void b(Key paramKey)
  {
    paramKey = this.c.a(paramKey);
    try
    {
      a().c(paramKey);
      return;
    }
    catch (IOException paramKey)
    {
      while (!Log.isLoggable("DiskLruCacheWrapper", 5)) {}
      Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", paramKey);
    }
  }
}
