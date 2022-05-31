package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;

public abstract interface DataLoadProvider
{
  public abstract ResourceDecoder a();
  
  public abstract ResourceDecoder b();
  
  public abstract Encoder c();
  
  public abstract ResourceEncoder d();
}
