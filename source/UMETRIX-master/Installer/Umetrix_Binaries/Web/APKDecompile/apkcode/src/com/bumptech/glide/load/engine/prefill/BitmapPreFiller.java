package com.bumptech.glide.load.engine.prefill;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;

public final class BitmapPreFiller
{
  private final MemoryCache a;
  private final BitmapPool b;
  private final DecodeFormat c;
  private final Handler d = new Handler(Looper.getMainLooper());
  
  public BitmapPreFiller(MemoryCache paramMemoryCache, BitmapPool paramBitmapPool, DecodeFormat paramDecodeFormat)
  {
    this.a = paramMemoryCache;
    this.b = paramBitmapPool;
    this.c = paramDecodeFormat;
  }
}
