package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GifResourceDecoder
  implements ResourceDecoder
{
  private static final GifResourceDecoder.GifHeaderParserPool a = new GifResourceDecoder.GifHeaderParserPool();
  private static final GifResourceDecoder.GifDecoderPool b = new GifResourceDecoder.GifDecoderPool();
  private final Context c;
  private final GifResourceDecoder.GifHeaderParserPool d;
  private final BitmapPool e;
  private final GifResourceDecoder.GifDecoderPool f;
  private final GifBitmapProvider g;
  
  public GifResourceDecoder(Context paramContext, BitmapPool paramBitmapPool)
  {
    this(paramContext, paramBitmapPool, a, b);
  }
  
  GifResourceDecoder(Context paramContext, BitmapPool paramBitmapPool, GifResourceDecoder.GifHeaderParserPool paramGifHeaderParserPool, GifResourceDecoder.GifDecoderPool paramGifDecoderPool)
  {
    this.c = paramContext;
    this.e = paramBitmapPool;
    this.f = paramGifDecoderPool;
    this.g = new GifBitmapProvider(paramBitmapPool);
    this.d = paramGifHeaderParserPool;
  }
  
  private Bitmap a(GifDecoder paramGifDecoder, GifHeader paramGifHeader, byte[] paramArrayOfByte)
  {
    paramGifDecoder.a(paramGifHeader, paramArrayOfByte);
    paramGifDecoder.a();
    return paramGifDecoder.f();
  }
  
  private GifDrawableResource a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, GifHeaderParser paramGifHeaderParser, GifDecoder paramGifDecoder)
  {
    paramGifHeaderParser = paramGifHeaderParser.b();
    if ((paramGifHeaderParser.a() <= 0) || (paramGifHeaderParser.b() != 0)) {}
    do
    {
      return null;
      paramGifDecoder = a(paramGifDecoder, paramGifHeaderParser, paramArrayOfByte);
    } while (paramGifDecoder == null);
    UnitTransformation localUnitTransformation = UnitTransformation.b();
    return new GifDrawableResource(new GifDrawable(this.c, this.g, this.e, localUnitTransformation, paramInt1, paramInt2, paramGifHeaderParser, paramArrayOfByte, paramGifDecoder));
  }
  
  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(16384);
    try
    {
      byte[] arrayOfByte = new byte['?'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramInputStream)
    {
      Log.w("GifResourceDecoder", "Error reading data from stream", paramInputStream);
    }
    for (;;)
    {
      localByteArrayOutputStream.flush();
    }
  }
  
  public GifDrawableResource a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    Object localObject1 = a(paramInputStream);
    paramInputStream = this.d.a((byte[])localObject1);
    GifDecoder localGifDecoder = this.f.a(this.g);
    try
    {
      localObject1 = a((byte[])localObject1, paramInt1, paramInt2, paramInputStream, localGifDecoder);
      return localObject1;
    }
    finally
    {
      this.d.a(paramInputStream);
      this.f.a(localGifDecoder);
    }
  }
  
  public String a()
  {
    return "";
  }
}
