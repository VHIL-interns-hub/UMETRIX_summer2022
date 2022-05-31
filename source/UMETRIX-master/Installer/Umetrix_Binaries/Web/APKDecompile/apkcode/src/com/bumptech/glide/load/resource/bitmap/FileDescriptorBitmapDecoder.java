package com.bumptech.glide.load.resource.bitmap;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class FileDescriptorBitmapDecoder
  implements ResourceDecoder
{
  private final VideoBitmapDecoder a;
  private final BitmapPool b;
  private DecodeFormat c;
  
  public FileDescriptorBitmapDecoder(BitmapPool paramBitmapPool, DecodeFormat paramDecodeFormat)
  {
    this(new VideoBitmapDecoder(), paramBitmapPool, paramDecodeFormat);
  }
  
  public FileDescriptorBitmapDecoder(VideoBitmapDecoder paramVideoBitmapDecoder, BitmapPool paramBitmapPool, DecodeFormat paramDecodeFormat)
  {
    this.a = paramVideoBitmapDecoder;
    this.b = paramBitmapPool;
    this.c = paramDecodeFormat;
  }
  
  public Resource a(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2)
  {
    return BitmapResource.a(this.a.a(paramParcelFileDescriptor, this.b, paramInt1, paramInt2, this.c), this.b);
  }
  
  public String a()
  {
    return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
  }
}
