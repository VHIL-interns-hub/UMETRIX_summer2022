package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.LruCache;

class SafeKeyGenerator
{
  private final LruCache a = new LruCache(1000);
  
  SafeKeyGenerator() {}
  
  /* Error */
  public String a(com.bumptech.glide.load.Key paramKey)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/bumptech/glide/load/engine/cache/SafeKeyGenerator:a	Lcom/bumptech/glide/util/LruCache;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 17	com/bumptech/glide/load/engine/cache/SafeKeyGenerator:a	Lcom/bumptech/glide/util/LruCache;
    //   11: aload_1
    //   12: invokevirtual 27	com/bumptech/glide/util/LruCache:b	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 29	java/lang/String
    //   18: astore_2
    //   19: aload_3
    //   20: monitorexit
    //   21: aload_2
    //   22: astore_3
    //   23: aload_2
    //   24: ifnonnull +47 -> 71
    //   27: ldc 31
    //   29: invokestatic 37	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   32: astore_3
    //   33: aload_1
    //   34: aload_3
    //   35: invokeinterface 42 2 0
    //   40: aload_3
    //   41: invokevirtual 46	java/security/MessageDigest:digest	()[B
    //   44: invokestatic 51	com/bumptech/glide/util/Util:a	([B)Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 17	com/bumptech/glide/load/engine/cache/SafeKeyGenerator:a	Lcom/bumptech/glide/util/LruCache;
    //   54: astore_3
    //   55: aload_3
    //   56: monitorenter
    //   57: aload_0
    //   58: getfield 17	com/bumptech/glide/load/engine/cache/SafeKeyGenerator:a	Lcom/bumptech/glide/util/LruCache;
    //   61: aload_1
    //   62: aload_2
    //   63: invokevirtual 54	com/bumptech/glide/util/LruCache:b	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: aload_3
    //   68: monitorexit
    //   69: aload_2
    //   70: astore_3
    //   71: aload_3
    //   72: areturn
    //   73: astore_1
    //   74: aload_3
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore_3
    //   79: aload_3
    //   80: invokevirtual 57	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   83: goto -33 -> 50
    //   86: astore_3
    //   87: aload_3
    //   88: invokevirtual 58	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   91: goto -41 -> 50
    //   94: astore_1
    //   95: aload_3
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	SafeKeyGenerator
    //   0	99	1	paramKey	com.bumptech.glide.load.Key
    //   18	52	2	localObject1	Object
    //   78	2	3	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   86	10	3	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    // Exception table:
    //   from	to	target	type
    //   7	21	73	finally
    //   74	76	73	finally
    //   27	48	78	java/io/UnsupportedEncodingException
    //   27	48	86	java/security/NoSuchAlgorithmException
    //   57	69	94	finally
    //   95	97	94	finally
  }
}
