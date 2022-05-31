package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;

public class EmptyDataLoadProvider
  implements DataLoadProvider
{
  private static final DataLoadProvider a = new EmptyDataLoadProvider();
  
  public EmptyDataLoadProvider() {}
  
  public static DataLoadProvider e()
  {
    return a;
  }
  
  public ResourceDecoder a()
  {
    return null;
  }
  
  public ResourceDecoder b()
  {
    return null;
  }
  
  public Encoder c()
  {
    return null;
  }
  
  public ResourceEncoder d()
  {
    return null;
  }
}
