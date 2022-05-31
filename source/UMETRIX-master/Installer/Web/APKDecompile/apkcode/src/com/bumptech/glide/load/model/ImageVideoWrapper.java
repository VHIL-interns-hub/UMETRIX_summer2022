package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public class ImageVideoWrapper
{
  private final InputStream a;
  private final ParcelFileDescriptor b;
  
  public ImageVideoWrapper(InputStream paramInputStream, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.a = paramInputStream;
    this.b = paramParcelFileDescriptor;
  }
  
  public InputStream a()
  {
    return this.a;
  }
  
  public ParcelFileDescriptor b()
  {
    return this.b;
  }
}
