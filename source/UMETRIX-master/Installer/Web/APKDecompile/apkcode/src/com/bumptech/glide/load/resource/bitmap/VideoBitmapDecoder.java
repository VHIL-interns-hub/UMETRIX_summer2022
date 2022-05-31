package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class VideoBitmapDecoder
  implements BitmapDecoder
{
  private static final VideoBitmapDecoder.MediaMetadataRetrieverFactory a = new VideoBitmapDecoder.MediaMetadataRetrieverFactory();
  private VideoBitmapDecoder.MediaMetadataRetrieverFactory b;
  private int c;
  
  public VideoBitmapDecoder()
  {
    this(a, -1);
  }
  
  VideoBitmapDecoder(VideoBitmapDecoder.MediaMetadataRetrieverFactory paramMediaMetadataRetrieverFactory, int paramInt)
  {
    this.b = paramMediaMetadataRetrieverFactory;
    this.c = paramInt;
  }
  
  public Bitmap a(ParcelFileDescriptor paramParcelFileDescriptor, BitmapPool paramBitmapPool, int paramInt1, int paramInt2, DecodeFormat paramDecodeFormat)
  {
    paramDecodeFormat = this.b.a();
    paramDecodeFormat.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    if (this.c >= 0) {}
    for (paramBitmapPool = paramDecodeFormat.getFrameAtTime(this.c);; paramBitmapPool = paramDecodeFormat.getFrameAtTime())
    {
      paramDecodeFormat.release();
      paramParcelFileDescriptor.close();
      return paramBitmapPool;
    }
  }
  
  public String a()
  {
    return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
  }
}
