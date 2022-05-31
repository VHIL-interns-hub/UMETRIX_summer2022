package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.NullResourceEncoder;
import com.bumptech.glide.provider.DataLoadProvider;

public class StreamFileDataLoadProvider
  implements DataLoadProvider
{
  private static final StreamFileDataLoadProvider.ErrorSourceDecoder a = new StreamFileDataLoadProvider.ErrorSourceDecoder(null);
  private final ResourceDecoder b = new FileDecoder();
  private final Encoder c = new StreamEncoder();
  
  public StreamFileDataLoadProvider() {}
  
  public ResourceDecoder a()
  {
    return this.b;
  }
  
  public ResourceDecoder b()
  {
    return a;
  }
  
  public Encoder c()
  {
    return this.c;
  }
  
  public ResourceEncoder d()
  {
    return NullResourceEncoder.b();
  }
}
