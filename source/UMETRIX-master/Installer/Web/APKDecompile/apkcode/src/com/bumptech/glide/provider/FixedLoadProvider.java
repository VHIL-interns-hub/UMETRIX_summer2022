package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

public class FixedLoadProvider
  implements LoadProvider
{
  private final ModelLoader a;
  private final ResourceTranscoder b;
  private final DataLoadProvider c;
  
  public FixedLoadProvider(ModelLoader paramModelLoader, ResourceTranscoder paramResourceTranscoder, DataLoadProvider paramDataLoadProvider)
  {
    if (paramModelLoader == null) {
      throw new NullPointerException("ModelLoader must not be null");
    }
    this.a = paramModelLoader;
    if (paramResourceTranscoder == null) {
      throw new NullPointerException("Transcoder must not be null");
    }
    this.b = paramResourceTranscoder;
    if (paramDataLoadProvider == null) {
      throw new NullPointerException("DataLoadProvider must not be null");
    }
    this.c = paramDataLoadProvider;
  }
  
  public ResourceDecoder a()
  {
    return this.c.a();
  }
  
  public ResourceDecoder b()
  {
    return this.c.b();
  }
  
  public Encoder c()
  {
    return this.c.c();
  }
  
  public ResourceEncoder d()
  {
    return this.c.d();
  }
  
  public ModelLoader e()
  {
    return this.a;
  }
  
  public ResourceTranscoder f()
  {
    return this.b;
  }
}
