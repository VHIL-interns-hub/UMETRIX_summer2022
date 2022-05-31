package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MultiTransformation
  implements Transformation
{
  private final Collection a;
  private String b;
  
  @SafeVarargs
  public MultiTransformation(Transformation... paramVarArgs)
  {
    if (paramVarArgs.length < 1) {
      throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
    this.a = Arrays.asList(paramVarArgs);
  }
  
  public Resource a(Resource paramResource, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.a.iterator();
    Resource localResource;
    for (Object localObject = paramResource; localIterator.hasNext(); localObject = localResource)
    {
      localResource = ((Transformation)localIterator.next()).a((Resource)localObject, paramInt1, paramInt2);
      if ((localObject != null) && (!localObject.equals(paramResource)) && (!localObject.equals(localResource))) {
        ((Resource)localObject).d();
      }
    }
    return localObject;
  }
  
  public String a()
  {
    if (this.b == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((Transformation)localIterator.next()).a());
      }
      this.b = localStringBuilder.toString();
    }
    return this.b;
  }
}
