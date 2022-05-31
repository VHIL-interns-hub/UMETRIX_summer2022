package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

public class ChildLoadProvider
  implements LoadProvider, Cloneable
{
  private final LoadProvider a;
  private ResourceDecoder b;
  private ResourceDecoder c;
  private ResourceEncoder d;
  private ResourceTranscoder e;
  private Encoder f;
  
  public ChildLoadProvider(LoadProvider paramLoadProvider)
  {
    this.a = paramLoadProvider;
  }
  
  public ResourceDecoder a()
  {
    if (this.b != null) {
      return this.b;
    }
    return this.a.a();
  }
  
  public void a(Encoder paramEncoder)
  {
    this.f = paramEncoder;
  }
  
  public void a(ResourceDecoder paramResourceDecoder)
  {
    this.c = paramResourceDecoder;
  }
  
  public ResourceDecoder b()
  {
    if (this.c != null) {
      return this.c;
    }
    return this.a.b();
  }
  
  public Encoder c()
  {
    if (this.f != null) {
      return this.f;
    }
    return this.a.c();
  }
  
  public ResourceEncoder d()
  {
    if (this.d != null) {
      return this.d;
    }
    return this.a.d();
  }
  
  public ModelLoader e()
  {
    return this.a.e();
  }
  
  public ResourceTranscoder f()
  {
    if (this.e != null) {
      return this.e;
    }
    return this.a.f();
  }
  
  public ChildLoadProvider g()
  {
    try
    {
      ChildLoadProvider localChildLoadProvider = (ChildLoadProvider)super.clone();
      return localChildLoadProvider;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
}
