package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.OutputStream;

public class BitmapEncoder
  implements ResourceEncoder
{
  private Bitmap.CompressFormat a;
  private int b;
  
  public BitmapEncoder()
  {
    this(null, 90);
  }
  
  public BitmapEncoder(Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    this.a = paramCompressFormat;
    this.b = paramInt;
  }
  
  private Bitmap.CompressFormat a(Bitmap paramBitmap)
  {
    if (this.a != null) {
      return this.a;
    }
    if (paramBitmap.hasAlpha()) {
      return Bitmap.CompressFormat.PNG;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  public String a()
  {
    return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
  }
  
  public boolean a(Resource paramResource, OutputStream paramOutputStream)
  {
    paramResource = (Bitmap)paramResource.b();
    long l = LogTime.a();
    Bitmap.CompressFormat localCompressFormat = a(paramResource);
    paramResource.compress(localCompressFormat, this.b, paramOutputStream);
    if (Log.isLoggable("BitmapEncoder", 2)) {
      Log.v("BitmapEncoder", "Compressed with type: " + localCompressFormat + " of size " + Util.a(paramResource) + " in " + LogTime.a(l));
    }
    return true;
  }
}
