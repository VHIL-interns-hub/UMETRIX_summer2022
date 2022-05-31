package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;

public class SimpleResource
  implements Resource
{
  protected final Object a;
  
  public SimpleResource(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("Data must not be null");
    }
    this.a = paramObject;
  }
  
  public final Object b()
  {
    return this.a;
  }
  
  public final int c()
  {
    return 1;
  }
  
  public void d() {}
}
