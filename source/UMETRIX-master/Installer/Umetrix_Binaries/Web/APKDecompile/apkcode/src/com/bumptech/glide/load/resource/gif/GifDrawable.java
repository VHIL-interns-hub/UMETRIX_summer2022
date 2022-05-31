package com.bumptech.glide.load.resource.gif;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.view.Gravity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

public class GifDrawable
  extends GlideDrawable
  implements GifFrameLoader.FrameCallback
{
  private final Paint a;
  private final Rect b = new Rect();
  private final GifDrawable.GifState c;
  private final GifDecoder d;
  private final GifFrameLoader e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i = true;
  private int j;
  private int k = -1;
  private boolean l;
  
  public GifDrawable(Context paramContext, GifDecoder.BitmapProvider paramBitmapProvider, BitmapPool paramBitmapPool, Transformation paramTransformation, int paramInt1, int paramInt2, GifHeader paramGifHeader, byte[] paramArrayOfByte, Bitmap paramBitmap)
  {
    this(new GifDrawable.GifState(paramGifHeader, paramArrayOfByte, paramContext, paramTransformation, paramInt1, paramInt2, paramBitmapProvider, paramBitmapPool, paramBitmap));
  }
  
  GifDrawable(GifDrawable.GifState paramGifState)
  {
    if (paramGifState == null) {
      throw new NullPointerException("GifState must not be null");
    }
    this.c = paramGifState;
    this.d = new GifDecoder(paramGifState.g);
    this.a = new Paint();
    this.d.a(paramGifState.a, paramGifState.b);
    this.e = new GifFrameLoader(paramGifState.c, this, this.d, paramGifState.e, paramGifState.f);
    this.e.a(paramGifState.d);
  }
  
  public GifDrawable(GifDrawable paramGifDrawable, Bitmap paramBitmap, Transformation paramTransformation)
  {
    this(new GifDrawable.GifState(paramGifDrawable.c.a, paramGifDrawable.c.b, paramGifDrawable.c.c, paramTransformation, paramGifDrawable.c.e, paramGifDrawable.c.f, paramGifDrawable.c.g, paramGifDrawable.c.h, paramBitmap));
  }
  
  private void g()
  {
    this.j = 0;
  }
  
  private void h()
  {
    this.e.c();
    invalidateSelf();
  }
  
  private void i()
  {
    if (this.d.c() == 1) {
      invalidateSelf();
    }
    while (this.f) {
      return;
    }
    this.f = true;
    this.e.a();
    invalidateSelf();
  }
  
  private void j()
  {
    this.f = false;
    this.e.b();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt <= 0) && (paramInt != -1) && (paramInt != 0)) {
      throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
    }
    if (paramInt == 0)
    {
      this.k = this.d.e();
      return;
    }
    this.k = paramInt;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public Bitmap b()
  {
    return this.c.i;
  }
  
  @TargetApi(11)
  public void b(int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (getCallback() == null))
    {
      stop();
      h();
    }
    do
    {
      return;
      invalidateSelf();
      if (paramInt == this.d.c() - 1) {
        this.j += 1;
      }
    } while ((this.k == -1) || (this.j < this.k));
    stop();
  }
  
  public Transformation c()
  {
    return this.c.d;
  }
  
  public byte[] d()
  {
    return this.c.b;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.h) {
      return;
    }
    if (this.l)
    {
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.b);
      this.l = false;
    }
    Bitmap localBitmap = this.e.d();
    if (localBitmap != null) {}
    for (;;)
    {
      paramCanvas.drawBitmap(localBitmap, null, this.b, this.a);
      return;
      localBitmap = this.c.i;
    }
  }
  
  public int e()
  {
    return this.d.c();
  }
  
  public void f()
  {
    this.h = true;
    this.c.h.a(this.c.i);
    this.e.c();
    this.e.b();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.c;
  }
  
  public int getIntrinsicHeight()
  {
    return this.c.i.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.c.i.getWidth();
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.f;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.l = true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.i = paramBoolean1;
    if (!paramBoolean1) {
      j();
    }
    for (;;)
    {
      return super.setVisible(paramBoolean1, paramBoolean2);
      if (this.g) {
        i();
      }
    }
  }
  
  public void start()
  {
    this.g = true;
    g();
    if (this.i) {
      i();
    }
  }
  
  public void stop()
  {
    this.g = false;
    j();
    if (Build.VERSION.SDK_INT < 11) {
      h();
    }
  }
}
