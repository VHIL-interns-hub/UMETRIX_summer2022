package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.GenericTranscodeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.RequestManager.GenericModelRequest;
import com.bumptech.glide.RequestManager.GenericModelRequest.GenericTypeRequest;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.NullEncoder;

class GifFrameLoader
{
  private final GifFrameLoader.FrameCallback a;
  private final GifDecoder b;
  private final Handler c;
  private boolean d = false;
  private boolean e = false;
  private GenericRequestBuilder f;
  private GifFrameLoader.DelayTarget g;
  private boolean h;
  
  public GifFrameLoader(Context paramContext, GifFrameLoader.FrameCallback paramFrameCallback, GifDecoder paramGifDecoder, int paramInt1, int paramInt2)
  {
    this(paramFrameCallback, paramGifDecoder, null, a(paramContext, paramGifDecoder, paramInt1, paramInt2, Glide.a(paramContext).a()));
  }
  
  GifFrameLoader(GifFrameLoader.FrameCallback paramFrameCallback, GifDecoder paramGifDecoder, Handler paramHandler, GenericRequestBuilder paramGenericRequestBuilder)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper(), new GifFrameLoader.FrameLoaderCallback(this, null));
    }
    this.a = paramFrameCallback;
    this.b = paramGifDecoder;
    this.c = localHandler;
    this.f = paramGenericRequestBuilder;
  }
  
  private static GenericRequestBuilder a(Context paramContext, GifDecoder paramGifDecoder, int paramInt1, int paramInt2, BitmapPool paramBitmapPool)
  {
    paramBitmapPool = new GifFrameResourceDecoder(paramBitmapPool);
    GifFrameModelLoader localGifFrameModelLoader = new GifFrameModelLoader();
    Encoder localEncoder = NullEncoder.b();
    return Glide.b(paramContext).a(localGifFrameModelLoader, GifDecoder.class).a(paramGifDecoder).a(Bitmap.class).b(localEncoder).b(paramBitmapPool).b(true).b(DiskCacheStrategy.b).b(paramInt1, paramInt2);
  }
  
  private void e()
  {
    if ((!this.d) || (this.e)) {
      return;
    }
    this.e = true;
    this.b.a();
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.b.b();
    GifFrameLoader.DelayTarget localDelayTarget = new GifFrameLoader.DelayTarget(this.c, this.b.d(), l1 + l2);
    this.f.b(new GifFrameLoader.FrameSignature()).a(localDelayTarget);
  }
  
  public void a()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.h = false;
    e();
  }
  
  public void a(Transformation paramTransformation)
  {
    if (paramTransformation == null) {
      throw new NullPointerException("Transformation must not be null");
    }
    this.f = this.f.b(new Transformation[] { paramTransformation });
  }
  
  void a(GifFrameLoader.DelayTarget paramDelayTarget)
  {
    if (this.h)
    {
      this.c.obtainMessage(2, paramDelayTarget).sendToTarget();
      return;
    }
    GifFrameLoader.DelayTarget localDelayTarget = this.g;
    this.g = paramDelayTarget;
    this.a.b(GifFrameLoader.DelayTarget.a(paramDelayTarget));
    if (localDelayTarget != null) {
      this.c.obtainMessage(2, localDelayTarget).sendToTarget();
    }
    this.e = false;
    e();
  }
  
  public void b()
  {
    this.d = false;
  }
  
  public void c()
  {
    b();
    if (this.g != null)
    {
      Glide.a(this.g);
      this.g = null;
    }
    this.h = true;
  }
  
  public Bitmap d()
  {
    if (this.g != null) {
      return this.g.a();
    }
    return null;
  }
}
