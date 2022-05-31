package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import java.io.IOException;

public class ImageVideoBitmapDecoder
  implements ResourceDecoder
{
  private final ResourceDecoder a;
  private final ResourceDecoder b;
  
  public ImageVideoBitmapDecoder(ResourceDecoder paramResourceDecoder1, ResourceDecoder paramResourceDecoder2)
  {
    this.a = paramResourceDecoder1;
    this.b = paramResourceDecoder2;
  }
  
  public Resource a(ImageVideoWrapper paramImageVideoWrapper, int paramInt1, int paramInt2)
  {
    Object localObject1 = paramImageVideoWrapper.a();
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = this.a.a(localObject1, paramInt1, paramInt2);
        Object localObject3 = localObject1;
        if (localObject1 == null)
        {
          paramImageVideoWrapper = paramImageVideoWrapper.b();
          localObject3 = localObject1;
          if (paramImageVideoWrapper != null) {
            localObject3 = this.b.a(paramImageVideoWrapper, paramInt1, paramInt2);
          }
        }
        return localObject3;
      }
      catch (IOException localIOException)
      {
        if (Log.isLoggable("ImageVideoDecoder", 2)) {
          Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", localIOException);
        }
      }
      Object localObject2 = null;
    }
  }
  
  public String a()
  {
    return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
  }
}
