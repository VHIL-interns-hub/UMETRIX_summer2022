package com.bumptech.glide.load.model;

import java.util.Map;

public abstract interface Headers
{
  @Deprecated
  public static final Headers a = new Headers.1();
  public static final Headers b = new LazyHeaders.Builder().a();
  
  public abstract Map a();
}
