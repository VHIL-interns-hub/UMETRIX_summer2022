package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.ByteArrayPool;
import java.io.InputStream;

public class GifBitmapWrapperResourceDecoder
  implements ResourceDecoder
{
  private static final GifBitmapWrapperResourceDecoder.ImageTypeParser a = new GifBitmapWrapperResourceDecoder.ImageTypeParser();
  private static final GifBitmapWrapperResourceDecoder.BufferedStreamFactory b = new GifBitmapWrapperResourceDecoder.BufferedStreamFactory();
  private final ResourceDecoder c;
  private final ResourceDecoder d;
  private final BitmapPool e;
  private final GifBitmapWrapperResourceDecoder.ImageTypeParser f;
  private final GifBitmapWrapperResourceDecoder.BufferedStreamFactory g;
  private String h;
  
  public GifBitmapWrapperResourceDecoder(ResourceDecoder paramResourceDecoder1, ResourceDecoder paramResourceDecoder2, BitmapPool paramBitmapPool)
  {
    this(paramResourceDecoder1, paramResourceDecoder2, paramBitmapPool, a, b);
  }
  
  GifBitmapWrapperResourceDecoder(ResourceDecoder paramResourceDecoder1, ResourceDecoder paramResourceDecoder2, BitmapPool paramBitmapPool, GifBitmapWrapperResourceDecoder.ImageTypeParser paramImageTypeParser, GifBitmapWrapperResourceDecoder.BufferedStreamFactory paramBufferedStreamFactory)
  {
    this.c = paramResourceDecoder1;
    this.d = paramResourceDecoder2;
    this.e = paramBitmapPool;
    this.f = paramImageTypeParser;
    this.g = paramBufferedStreamFactory;
  }
  
  private GifBitmapWrapper a(ImageVideoWrapper paramImageVideoWrapper, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramImageVideoWrapper.a() != null) {
      return b(paramImageVideoWrapper, paramInt1, paramInt2, paramArrayOfByte);
    }
    return b(paramImageVideoWrapper, paramInt1, paramInt2);
  }
  
  private GifBitmapWrapper a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    paramInputStream = this.d.a(paramInputStream, paramInt1, paramInt2);
    if (paramInputStream != null)
    {
      GifDrawable localGifDrawable = (GifDrawable)paramInputStream.b();
      if (localGifDrawable.e() > 1) {
        return new GifBitmapWrapper(null, paramInputStream);
      }
      return new GifBitmapWrapper(new BitmapResource(localGifDrawable.b(), this.e), null);
    }
    return null;
  }
  
  private GifBitmapWrapper b(ImageVideoWrapper paramImageVideoWrapper, int paramInt1, int paramInt2)
  {
    paramImageVideoWrapper = this.c.a(paramImageVideoWrapper, paramInt1, paramInt2);
    if (paramImageVideoWrapper != null) {
      return new GifBitmapWrapper(paramImageVideoWrapper, null);
    }
    return null;
  }
  
  private GifBitmapWrapper b(ImageVideoWrapper paramImageVideoWrapper, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    InputStream localInputStream = this.g.a(paramImageVideoWrapper.a(), paramArrayOfByte);
    localInputStream.mark(2048);
    Object localObject = this.f.a(localInputStream);
    localInputStream.reset();
    paramArrayOfByte = null;
    if (localObject == ImageHeaderParser.ImageType.GIF) {
      paramArrayOfByte = a(localInputStream, paramInt1, paramInt2);
    }
    localObject = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      localObject = b(new ImageVideoWrapper(localInputStream, paramImageVideoWrapper.b()), paramInt1, paramInt2);
    }
    return localObject;
  }
  
  public Resource a(ImageVideoWrapper paramImageVideoWrapper, int paramInt1, int paramInt2)
  {
    ByteArrayPool localByteArrayPool = ByteArrayPool.a();
    byte[] arrayOfByte = localByteArrayPool.b();
    try
    {
      paramImageVideoWrapper = a(paramImageVideoWrapper, paramInt1, paramInt2, arrayOfByte);
      localByteArrayPool.a(arrayOfByte);
      if (paramImageVideoWrapper != null) {
        return new GifBitmapWrapperResource(paramImageVideoWrapper);
      }
    }
    finally
    {
      localByteArrayPool.a(arrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    if (this.h == null) {
      this.h = (this.d.a() + this.c.a());
    }
    return this.h;
  }
}
