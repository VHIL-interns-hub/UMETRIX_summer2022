package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool
  implements BitmapPool
{
  private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
  private final LruPoolStrategy b;
  private final Set c;
  private final int d;
  private final LruBitmapPool.BitmapTracker e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public LruBitmapPool(int paramInt)
  {
    this(paramInt, e(), f());
  }
  
  LruBitmapPool(int paramInt, LruPoolStrategy paramLruPoolStrategy, Set paramSet)
  {
    this.d = paramInt;
    this.f = paramInt;
    this.b = paramLruPoolStrategy;
    this.c = paramSet;
    this.e = new LruBitmapPool.NullBitmapTracker(null);
  }
  
  private void b()
  {
    b(this.f);
  }
  
  /* Error */
  private void b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 64	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:g	I
    //   6: iload_1
    //   7: if_icmple +43 -> 50
    //   10: aload_0
    //   11: getfield 51	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:b	Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   14: invokeinterface 69 1 0
    //   19: astore_2
    //   20: aload_2
    //   21: ifnonnull +32 -> 53
    //   24: ldc 71
    //   26: iconst_5
    //   27: invokestatic 77	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   30: ifeq +15 -> 45
    //   33: ldc 71
    //   35: ldc 79
    //   37: invokestatic 83	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aload_0
    //   42: invokespecial 85	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:d	()V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 64	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:g	I
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: getfield 60	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:e	Lcom/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$BitmapTracker;
    //   57: aload_2
    //   58: invokeinterface 90 2 0
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 64	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:g	I
    //   68: aload_0
    //   69: getfield 51	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:b	Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   72: aload_2
    //   73: invokeinterface 93 2 0
    //   78: isub
    //   79: putfield 64	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:g	I
    //   82: aload_2
    //   83: invokevirtual 98	android/graphics/Bitmap:recycle	()V
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 100	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:k	I
    //   91: iconst_1
    //   92: iadd
    //   93: putfield 100	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:k	I
    //   96: ldc 71
    //   98: iconst_3
    //   99: invokestatic 77	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   102: ifeq +37 -> 139
    //   105: ldc 71
    //   107: new 102	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   114: ldc 105
    //   116: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: getfield 51	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:b	Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   123: aload_2
    //   124: invokeinterface 112 2 0
    //   129: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   138: pop
    //   139: aload_0
    //   140: invokespecial 120	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:c	()V
    //   143: goto -141 -> 2
    //   146: astore_2
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	LruBitmapPool
    //   0	151	1	paramInt	int
    //   19	105	2	localBitmap	Bitmap
    //   146	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	146	finally
    //   24	45	146	finally
    //   45	50	146	finally
    //   53	139	146	finally
    //   139	143	146	finally
  }
  
  private void c()
  {
    if (Log.isLoggable("LruBitmapPool", 2)) {
      d();
    }
  }
  
  private void d()
  {
    Log.v("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f + "\nStrategy=" + this.b);
  }
  
  private static LruPoolStrategy e()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return new SizeConfigStrategy();
    }
    return new AttributeStrategy();
  }
  
  private static Set f()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(Arrays.asList(Bitmap.Config.values()));
    if (Build.VERSION.SDK_INT >= 19) {
      localHashSet.add(null);
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      paramConfig = b(paramInt1, paramInt2, paramConfig);
      if (paramConfig != null) {
        paramConfig.eraseColor(0);
      }
      return paramConfig;
    }
    finally {}
  }
  
  public void a()
  {
    if (Log.isLoggable("LruBitmapPool", 3)) {
      Log.d("LruBitmapPool", "clearMemory");
    }
    b(0);
  }
  
  @SuppressLint({"InlinedApi"})
  public void a(int paramInt)
  {
    if (Log.isLoggable("LruBitmapPool", 3)) {
      Log.d("LruBitmapPool", "trimMemory, level=" + paramInt);
    }
    if (paramInt >= 60) {
      a();
    }
    while (paramInt < 40) {
      return;
    }
    b(this.f / 2);
  }
  
  public boolean a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      try
      {
        throw new NullPointerException("Bitmap must not be null");
      }
      finally {}
    }
    if ((!paramBitmap.isMutable()) || (this.b.c(paramBitmap) > this.f) || (!this.c.contains(paramBitmap.getConfig()))) {
      if (Log.isLoggable("LruBitmapPool", 2)) {
        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.b.b(paramBitmap) + ", is mutable: " + paramBitmap.isMutable() + ", is allowed config: " + this.c.contains(paramBitmap.getConfig()));
      }
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      int m = this.b.c(paramBitmap);
      this.b.a(paramBitmap);
      this.e.a(paramBitmap);
      this.j += 1;
      this.g = (m + this.g);
      if (Log.isLoggable("LruBitmapPool", 2)) {
        Log.v("LruBitmapPool", "Put bitmap in pool=" + this.b.b(paramBitmap));
      }
      c();
      b();
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(12)
  public Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:b	Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   6: astore 5
    //   8: aload_3
    //   9: ifnull +133 -> 142
    //   12: aload_3
    //   13: astore 4
    //   15: aload 5
    //   17: iload_1
    //   18: iload_2
    //   19: aload 4
    //   21: invokeinterface 244 4 0
    //   26: astore 4
    //   28: aload 4
    //   30: ifnonnull +120 -> 150
    //   33: ldc 71
    //   35: iconst_3
    //   36: invokestatic 77	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   39: ifeq +39 -> 78
    //   42: ldc 71
    //   44: new 102	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   51: ldc -10
    //   53: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 51	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:b	Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   60: iload_1
    //   61: iload_2
    //   62: aload_3
    //   63: invokeinterface 249 4 0
    //   68: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: aload_0
    //   79: aload_0
    //   80: getfield 131	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:i	I
    //   83: iconst_1
    //   84: iadd
    //   85: putfield 131	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:i	I
    //   88: ldc 71
    //   90: iconst_2
    //   91: invokestatic 77	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   94: ifeq +39 -> 133
    //   97: ldc 71
    //   99: new 102	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   106: ldc -5
    //   108: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: getfield 51	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:b	Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   115: iload_1
    //   116: iload_2
    //   117: aload_3
    //   118: invokeinterface 249 4 0
    //   123: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 149	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   132: pop
    //   133: aload_0
    //   134: invokespecial 120	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:c	()V
    //   137: aload_0
    //   138: monitorexit
    //   139: aload 4
    //   141: areturn
    //   142: getstatic 31	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:a	Landroid/graphics/Bitmap$Config;
    //   145: astore 4
    //   147: goto -132 -> 15
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 124	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:h	I
    //   155: iconst_1
    //   156: iadd
    //   157: putfield 124	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:h	I
    //   160: aload_0
    //   161: aload_0
    //   162: getfield 64	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:g	I
    //   165: aload_0
    //   166: getfield 51	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:b	Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
    //   169: aload 4
    //   171: invokeinterface 93 2 0
    //   176: isub
    //   177: putfield 64	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:g	I
    //   180: aload_0
    //   181: getfield 60	com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool:e	Lcom/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$BitmapTracker;
    //   184: aload 4
    //   186: invokeinterface 90 2 0
    //   191: getstatic 154	android/os/Build$VERSION:SDK_INT	I
    //   194: bipush 12
    //   196: if_icmplt -108 -> 88
    //   199: aload 4
    //   201: iconst_1
    //   202: invokevirtual 255	android/graphics/Bitmap:setHasAlpha	(Z)V
    //   205: goto -117 -> 88
    //   208: astore_3
    //   209: aload_0
    //   210: monitorexit
    //   211: aload_3
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	LruBitmapPool
    //   0	213	1	paramInt1	int
    //   0	213	2	paramInt2	int
    //   0	213	3	paramConfig	Bitmap.Config
    //   13	187	4	localObject	Object
    //   6	10	5	localLruPoolStrategy	LruPoolStrategy
    // Exception table:
    //   from	to	target	type
    //   2	8	208	finally
    //   15	28	208	finally
    //   33	78	208	finally
    //   78	88	208	finally
    //   88	133	208	finally
    //   133	137	208	finally
    //   142	147	208	finally
    //   150	205	208	finally
  }
}
