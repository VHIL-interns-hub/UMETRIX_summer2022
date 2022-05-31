package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;

public class UnitTransformation
  implements Transformation
{
  private static final Transformation a = new UnitTransformation();
  
  public UnitTransformation() {}
  
  public static UnitTransformation b()
  {
    return (UnitTransformation)a;
  }
  
  public Resource a(Resource paramResource, int paramInt1, int paramInt2)
  {
    return paramResource;
  }
  
  public String a()
  {
    return "";
  }
}
