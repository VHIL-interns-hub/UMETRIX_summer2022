package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.util.MultiClassKey;
import java.util.HashMap;
import java.util.Map;

public class TranscoderRegistry
{
  private static final MultiClassKey a = new MultiClassKey();
  private final Map b = new HashMap();
  
  public TranscoderRegistry() {}
  
  public ResourceTranscoder a(Class paramClass1, Class paramClass2)
  {
    if (paramClass1.equals(paramClass2)) {
      ??? = UnitTranscoder.b();
    }
    for (;;)
    {
      return ???;
      synchronized (a)
      {
        a.a(paramClass1, paramClass2);
        ResourceTranscoder localResourceTranscoder = (ResourceTranscoder)this.b.get(a);
        ??? = localResourceTranscoder;
        if (localResourceTranscoder != null) {
          continue;
        }
        throw new IllegalArgumentException("No transcoder registered for " + paramClass1 + " and " + paramClass2);
      }
    }
  }
  
  public void a(Class paramClass1, Class paramClass2, ResourceTranscoder paramResourceTranscoder)
  {
    this.b.put(new MultiClassKey(paramClass1, paramClass2), paramResourceTranscoder);
  }
}
