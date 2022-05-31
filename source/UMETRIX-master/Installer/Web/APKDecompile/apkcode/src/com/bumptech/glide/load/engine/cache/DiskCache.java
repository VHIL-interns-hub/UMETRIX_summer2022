package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;

public abstract interface DiskCache
{
  public abstract File a(Key paramKey);
  
  public abstract void a(Key paramKey, DiskCache.Writer paramWriter);
  
  public abstract void b(Key paramKey);
}
