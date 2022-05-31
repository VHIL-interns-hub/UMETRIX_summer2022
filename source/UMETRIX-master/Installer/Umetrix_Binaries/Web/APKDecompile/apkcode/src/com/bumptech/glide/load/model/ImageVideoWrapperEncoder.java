package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import java.io.OutputStream;

public class ImageVideoWrapperEncoder
  implements Encoder
{
  private final Encoder a;
  private final Encoder b;
  private String c;
  
  public ImageVideoWrapperEncoder(Encoder paramEncoder1, Encoder paramEncoder2)
  {
    this.a = paramEncoder1;
    this.b = paramEncoder2;
  }
  
  public String a()
  {
    if (this.c == null) {
      this.c = (this.a.a() + this.b.a());
    }
    return this.c;
  }
  
  public boolean a(ImageVideoWrapper paramImageVideoWrapper, OutputStream paramOutputStream)
  {
    if (paramImageVideoWrapper.a() != null) {
      return this.a.a(paramImageVideoWrapper.a(), paramOutputStream);
    }
    return this.b.a(paramImageVideoWrapper.b(), paramOutputStream);
  }
}
