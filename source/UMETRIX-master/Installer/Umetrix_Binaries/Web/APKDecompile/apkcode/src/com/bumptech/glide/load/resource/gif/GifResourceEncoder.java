package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifencoder.AnimatedGifEncoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.OutputStream;

public class GifResourceEncoder
  implements ResourceEncoder
{
  private static final GifResourceEncoder.Factory a = new GifResourceEncoder.Factory();
  private final GifDecoder.BitmapProvider b;
  private final BitmapPool c;
  private final GifResourceEncoder.Factory d;
  
  public GifResourceEncoder(BitmapPool paramBitmapPool)
  {
    this(paramBitmapPool, a);
  }
  
  GifResourceEncoder(BitmapPool paramBitmapPool, GifResourceEncoder.Factory paramFactory)
  {
    this.c = paramBitmapPool;
    this.b = new GifBitmapProvider(paramBitmapPool);
    this.d = paramFactory;
  }
  
  private GifDecoder a(byte[] paramArrayOfByte)
  {
    Object localObject = this.d.a();
    ((GifHeaderParser)localObject).a(paramArrayOfByte);
    localObject = ((GifHeaderParser)localObject).b();
    GifDecoder localGifDecoder = this.d.a(this.b);
    localGifDecoder.a((GifHeader)localObject, paramArrayOfByte);
    localGifDecoder.a();
    return localGifDecoder;
  }
  
  private Resource a(Bitmap paramBitmap, Transformation paramTransformation, GifDrawable paramGifDrawable)
  {
    paramBitmap = this.d.a(paramBitmap, this.c);
    paramTransformation = paramTransformation.a(paramBitmap, paramGifDrawable.getIntrinsicWidth(), paramGifDrawable.getIntrinsicHeight());
    if (!paramBitmap.equals(paramTransformation)) {
      paramBitmap.d();
    }
    return paramTransformation;
  }
  
  private boolean a(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    try
    {
      paramOutputStream.write(paramArrayOfByte);
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      if (Log.isLoggable("GifEncoder", 3)) {
        Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", paramArrayOfByte);
      }
    }
    return false;
  }
  
  public String a()
  {
    return "";
  }
  
  public boolean a(Resource paramResource, OutputStream paramOutputStream)
  {
    boolean bool1 = false;
    long l = LogTime.a();
    paramResource = (GifDrawable)paramResource.b();
    Transformation localTransformation = paramResource.c();
    if ((localTransformation instanceof UnitTransformation)) {
      bool1 = a(paramResource.d(), paramOutputStream);
    }
    GifDecoder localGifDecoder;
    boolean bool2;
    do
    {
      AnimatedGifEncoder localAnimatedGifEncoder;
      do
      {
        return bool1;
        localGifDecoder = a(paramResource.d());
        localAnimatedGifEncoder = this.d.b();
      } while (!localAnimatedGifEncoder.a(paramOutputStream));
      int i = 0;
      while (i < localGifDecoder.c())
      {
        paramOutputStream = a(localGifDecoder.f(), localTransformation, paramResource);
        try
        {
          bool1 = localAnimatedGifEncoder.a((Bitmap)paramOutputStream.b());
          if (!bool1) {
            return false;
          }
          localAnimatedGifEncoder.a(localGifDecoder.a(localGifDecoder.d()));
          localGifDecoder.a();
          paramOutputStream.d();
          i += 1;
        }
        finally
        {
          paramOutputStream.d();
        }
      }
      bool2 = localAnimatedGifEncoder.a();
      bool1 = bool2;
    } while (!Log.isLoggable("GifEncoder", 2));
    Log.v("GifEncoder", "Encoded gif with " + localGifDecoder.c() + " frames and " + paramResource.d().length + " bytes in " + LogTime.a(l) + " ms");
    return bool2;
  }
}
