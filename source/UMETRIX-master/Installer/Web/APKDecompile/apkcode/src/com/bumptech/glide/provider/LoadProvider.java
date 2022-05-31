package com.bumptech.glide.provider;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

public abstract interface LoadProvider
  extends DataLoadProvider
{
  public abstract ModelLoader e();
  
  public abstract ResourceTranscoder f();
}
