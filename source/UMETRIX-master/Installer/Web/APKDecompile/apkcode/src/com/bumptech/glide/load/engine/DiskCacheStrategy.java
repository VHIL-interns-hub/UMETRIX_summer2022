package com.bumptech.glide.load.engine;

public enum DiskCacheStrategy
{
  private final boolean e;
  private final boolean f;
  
  private DiskCacheStrategy(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e = paramBoolean1;
    this.f = paramBoolean2;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public boolean b()
  {
    return this.f;
  }
}
