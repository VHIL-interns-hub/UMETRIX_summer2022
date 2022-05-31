package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.ChildLoadProvider;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.GenericRequest;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.animation.NoAnimation;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.Util;

public class GenericRequestBuilder
  implements Cloneable
{
  private boolean A;
  private Drawable B;
  private int C;
  protected final Class a;
  protected final Context b;
  protected final Glide c;
  protected final Class d;
  protected final RequestTracker e;
  protected final Lifecycle f;
  private ChildLoadProvider g;
  private Object h;
  private Key i = EmptySignature.a();
  private boolean j;
  private int k;
  private int l;
  private RequestListener m;
  private Float n;
  private GenericRequestBuilder o;
  private Float p = Float.valueOf(1.0F);
  private Drawable q;
  private Drawable r;
  private Priority s = null;
  private boolean t = true;
  private GlideAnimationFactory u = NoAnimation.a();
  private int v = -1;
  private int w = -1;
  private DiskCacheStrategy x = DiskCacheStrategy.d;
  private Transformation y = UnitTransformation.b();
  private boolean z;
  
  GenericRequestBuilder(Context paramContext, Class paramClass1, LoadProvider paramLoadProvider, Class paramClass2, Glide paramGlide, RequestTracker paramRequestTracker, Lifecycle paramLifecycle)
  {
    this.b = paramContext;
    this.a = paramClass1;
    this.d = paramClass2;
    this.c = paramGlide;
    this.e = paramRequestTracker;
    this.f = paramLifecycle;
    paramClass2 = localObject;
    if (paramLoadProvider != null) {
      paramClass2 = new ChildLoadProvider(paramLoadProvider);
    }
    this.g = paramClass2;
    if (paramContext == null) {
      throw new NullPointerException("Context can't be null");
    }
    if ((paramClass1 != null) && (paramLoadProvider == null)) {
      throw new NullPointerException("LoadProvider must not be null");
    }
  }
  
  private Priority a()
  {
    if (this.s == Priority.d) {
      return Priority.c;
    }
    if (this.s == Priority.c) {
      return Priority.b;
    }
    return Priority.a;
  }
  
  private Request a(Target paramTarget, float paramFloat, Priority paramPriority, RequestCoordinator paramRequestCoordinator)
  {
    return GenericRequest.a(this.g, this.h, this.i, this.b, paramPriority, paramTarget, paramFloat, this.q, this.k, this.r, this.l, this.B, this.C, this.m, paramRequestCoordinator, this.c.b(), this.y, this.d, this.t, this.u, this.w, this.v, this.x);
  }
  
  private Request a(Target paramTarget, ThumbnailRequestCoordinator paramThumbnailRequestCoordinator)
  {
    if (this.o != null)
    {
      if (this.A) {
        throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
      }
      if (this.o.u.equals(NoAnimation.a())) {
        this.o.u = this.u;
      }
      if (this.o.s == null) {
        this.o.s = a();
      }
      if ((Util.a(this.w, this.v)) && (!Util.a(this.o.w, this.o.v))) {
        this.o.b(this.w, this.v);
      }
      paramThumbnailRequestCoordinator = new ThumbnailRequestCoordinator(paramThumbnailRequestCoordinator);
      Request localRequest = a(paramTarget, this.p.floatValue(), this.s, paramThumbnailRequestCoordinator);
      this.A = true;
      paramTarget = this.o.a(paramTarget, paramThumbnailRequestCoordinator);
      this.A = false;
      paramThumbnailRequestCoordinator.a(localRequest, paramTarget);
      return paramThumbnailRequestCoordinator;
    }
    if (this.n != null)
    {
      paramThumbnailRequestCoordinator = new ThumbnailRequestCoordinator(paramThumbnailRequestCoordinator);
      paramThumbnailRequestCoordinator.a(a(paramTarget, this.p.floatValue(), this.s, paramThumbnailRequestCoordinator), a(paramTarget, this.n.floatValue(), a(), paramThumbnailRequestCoordinator));
      return paramThumbnailRequestCoordinator;
    }
    return a(paramTarget, this.p.floatValue(), this.s, paramThumbnailRequestCoordinator);
  }
  
  private Request b(Target paramTarget)
  {
    if (this.s == null) {
      this.s = Priority.c;
    }
    return a(paramTarget, null);
  }
  
  GenericRequestBuilder a(GlideAnimationFactory paramGlideAnimationFactory)
  {
    if (paramGlideAnimationFactory == null) {
      throw new NullPointerException("Animation factory must not be null!");
    }
    this.u = paramGlideAnimationFactory;
    return this;
  }
  
  public Target a(ImageView paramImageView)
  {
    
    if (paramImageView == null) {
      throw new IllegalArgumentException("You must pass in a non null View");
    }
    if ((!this.z) && (paramImageView.getScaleType() != null)) {
      switch (GenericRequestBuilder.2.a[paramImageView.getScaleType().ordinal()])
      {
      }
    }
    for (;;)
    {
      return a(this.c.a(paramImageView, this.d));
      f();
      continue;
      e();
    }
  }
  
  public Target a(Target paramTarget)
  {
    
    if (paramTarget == null) {
      throw new IllegalArgumentException("You must pass in a non null Target");
    }
    if (!this.j) {
      throw new IllegalArgumentException("You must first set a model (try #load())");
    }
    Request localRequest = paramTarget.c();
    if (localRequest != null)
    {
      localRequest.d();
      this.e.b(localRequest);
      localRequest.a();
    }
    localRequest = b(paramTarget);
    paramTarget.a(localRequest);
    this.f.a(paramTarget);
    this.e.a(localRequest);
    return paramTarget;
  }
  
  public GenericRequestBuilder b(int paramInt1, int paramInt2)
  {
    if (!Util.a(paramInt1, paramInt2)) {
      throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }
    this.w = paramInt1;
    this.v = paramInt2;
    return this;
  }
  
  public GenericRequestBuilder b(Encoder paramEncoder)
  {
    if (this.g != null) {
      this.g.a(paramEncoder);
    }
    return this;
  }
  
  public GenericRequestBuilder b(Key paramKey)
  {
    if (paramKey == null) {
      throw new NullPointerException("Signature must not be null");
    }
    this.i = paramKey;
    return this;
  }
  
  public GenericRequestBuilder b(ResourceDecoder paramResourceDecoder)
  {
    if (this.g != null) {
      this.g.a(paramResourceDecoder);
    }
    return this;
  }
  
  public GenericRequestBuilder b(DiskCacheStrategy paramDiskCacheStrategy)
  {
    this.x = paramDiskCacheStrategy;
    return this;
  }
  
  public GenericRequestBuilder b(Object paramObject)
  {
    this.h = paramObject;
    this.j = true;
    return this;
  }
  
  public GenericRequestBuilder b(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.t = paramBoolean;
      return this;
    }
  }
  
  public GenericRequestBuilder b(Transformation... paramVarArgs)
  {
    this.z = true;
    if (paramVarArgs.length == 1)
    {
      this.y = paramVarArgs[0];
      return this;
    }
    this.y = new MultiTransformation(paramVarArgs);
    return this;
  }
  
  public GenericRequestBuilder c(Drawable paramDrawable)
  {
    this.r = paramDrawable;
    return this;
  }
  
  public GenericRequestBuilder d(Drawable paramDrawable)
  {
    this.q = paramDrawable;
    return this;
  }
  
  void e() {}
  
  void f() {}
  
  /* Error */
  public GenericRequestBuilder g()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 314	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	com/bumptech/glide/GenericRequestBuilder
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 120	com/bumptech/glide/GenericRequestBuilder:g	Lcom/bumptech/glide/provider/ChildLoadProvider;
    //   12: ifnull +18 -> 30
    //   15: aload_0
    //   16: getfield 120	com/bumptech/glide/GenericRequestBuilder:g	Lcom/bumptech/glide/provider/ChildLoadProvider;
    //   19: invokevirtual 317	com/bumptech/glide/provider/ChildLoadProvider:g	()Lcom/bumptech/glide/provider/ChildLoadProvider;
    //   22: astore_1
    //   23: aload_2
    //   24: aload_1
    //   25: putfield 120	com/bumptech/glide/GenericRequestBuilder:g	Lcom/bumptech/glide/provider/ChildLoadProvider;
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_1
    //   32: goto -9 -> 23
    //   35: astore_1
    //   36: new 319	java/lang/RuntimeException
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 322	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	GenericRequestBuilder
    //   22	10	1	localChildLoadProvider	ChildLoadProvider
    //   35	6	1	localCloneNotSupportedException	CloneNotSupportedException
    //   7	22	2	localGenericRequestBuilder	GenericRequestBuilder
    // Exception table:
    //   from	to	target	type
    //   0	23	35	java/lang/CloneNotSupportedException
    //   23	28	35	java/lang/CloneNotSupportedException
  }
}
