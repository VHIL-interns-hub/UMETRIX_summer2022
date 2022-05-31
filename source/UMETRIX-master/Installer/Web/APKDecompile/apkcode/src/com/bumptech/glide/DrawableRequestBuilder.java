package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.animation.DrawableCrossFadeFactory;
import com.bumptech.glide.request.target.Target;

public class DrawableRequestBuilder
  extends GenericRequestBuilder
{
  DrawableRequestBuilder(Context paramContext, Class paramClass, LoadProvider paramLoadProvider, Glide paramGlide, RequestTracker paramRequestTracker, Lifecycle paramLifecycle)
  {
    super(paramContext, paramClass, paramLoadProvider, GlideDrawable.class, paramGlide, paramRequestTracker, paramLifecycle);
    c();
  }
  
  public DrawableRequestBuilder a()
  {
    return a(new Transformation[] { this.c.c() });
  }
  
  public DrawableRequestBuilder a(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    return this;
  }
  
  public DrawableRequestBuilder a(Drawable paramDrawable)
  {
    super.d(paramDrawable);
    return this;
  }
  
  public DrawableRequestBuilder a(Encoder paramEncoder)
  {
    super.b(paramEncoder);
    return this;
  }
  
  public DrawableRequestBuilder a(Key paramKey)
  {
    super.b(paramKey);
    return this;
  }
  
  public DrawableRequestBuilder a(ResourceDecoder paramResourceDecoder)
  {
    super.b(paramResourceDecoder);
    return this;
  }
  
  public DrawableRequestBuilder a(DiskCacheStrategy paramDiskCacheStrategy)
  {
    super.b(paramDiskCacheStrategy);
    return this;
  }
  
  public DrawableRequestBuilder a(Object paramObject)
  {
    super.b(paramObject);
    return this;
  }
  
  public DrawableRequestBuilder a(boolean paramBoolean)
  {
    super.b(paramBoolean);
    return this;
  }
  
  public DrawableRequestBuilder a(Transformation... paramVarArgs)
  {
    super.b(paramVarArgs);
    return this;
  }
  
  public Target a(ImageView paramImageView)
  {
    return super.a(paramImageView);
  }
  
  public DrawableRequestBuilder b()
  {
    return a(new Transformation[] { this.c.d() });
  }
  
  public DrawableRequestBuilder b(Drawable paramDrawable)
  {
    super.c(paramDrawable);
    return this;
  }
  
  public final DrawableRequestBuilder c()
  {
    super.a(new DrawableCrossFadeFactory());
    return this;
  }
  
  public DrawableRequestBuilder d()
  {
    return (DrawableRequestBuilder)super.g();
  }
  
  void e()
  {
    b();
  }
  
  void f()
  {
    a();
  }
}
