package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.Engine.LoadStatus;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public final class GenericRequest
  implements Request, ResourceCallback, SizeReadyCallback
{
  private static final Queue a = Util.a(0);
  private Resource A;
  private Engine.LoadStatus B;
  private long C;
  private GenericRequest.Status D;
  private final String b = String.valueOf(hashCode());
  private Key c;
  private Drawable d;
  private int e;
  private int f;
  private int g;
  private Context h;
  private Transformation i;
  private LoadProvider j;
  private RequestCoordinator k;
  private Object l;
  private Class m;
  private boolean n;
  private Priority o;
  private Target p;
  private RequestListener q;
  private float r;
  private Engine s;
  private GlideAnimationFactory t;
  private int u;
  private int v;
  private DiskCacheStrategy w;
  private Drawable x;
  private Drawable y;
  private boolean z;
  
  private GenericRequest() {}
  
  public static GenericRequest a(LoadProvider paramLoadProvider, Object paramObject, Key paramKey, Context paramContext, Priority paramPriority, Target paramTarget, float paramFloat, Drawable paramDrawable1, int paramInt1, Drawable paramDrawable2, int paramInt2, Drawable paramDrawable3, int paramInt3, RequestListener paramRequestListener, RequestCoordinator paramRequestCoordinator, Engine paramEngine, Transformation paramTransformation, Class paramClass, boolean paramBoolean, GlideAnimationFactory paramGlideAnimationFactory, int paramInt4, int paramInt5, DiskCacheStrategy paramDiskCacheStrategy)
  {
    GenericRequest localGenericRequest2 = (GenericRequest)a.poll();
    GenericRequest localGenericRequest1 = localGenericRequest2;
    if (localGenericRequest2 == null) {
      localGenericRequest1 = new GenericRequest();
    }
    localGenericRequest1.b(paramLoadProvider, paramObject, paramKey, paramContext, paramPriority, paramTarget, paramFloat, paramDrawable1, paramInt1, paramDrawable2, paramInt2, paramDrawable3, paramInt3, paramRequestListener, paramRequestCoordinator, paramEngine, paramTransformation, paramClass, paramBoolean, paramGlideAnimationFactory, paramInt4, paramInt5, paramDiskCacheStrategy);
    return localGenericRequest1;
  }
  
  private void a(Resource paramResource, Object paramObject)
  {
    boolean bool = p();
    this.D = GenericRequest.Status.d;
    this.A = paramResource;
    if ((this.q == null) || (!this.q.a(paramObject, this.l, this.p, this.z, bool)))
    {
      GlideAnimation localGlideAnimation = this.t.a(this.z, bool);
      this.p.a(paramObject, localGlideAnimation);
    }
    q();
    if (Log.isLoggable("GenericRequest", 2)) {
      a("Resource ready in " + LogTime.a(this.C) + " size: " + paramResource.c() * 9.5367431640625E-7D + " fromCache: " + this.z);
    }
  }
  
  private void a(String paramString)
  {
    Log.v("GenericRequest", paramString + " this: " + this.b);
  }
  
  private static void a(String paramString1, Object paramObject, String paramString2)
  {
    if (paramObject == null)
    {
      paramString1 = new StringBuilder(paramString1);
      paramString1.append(" must not be null");
      if (paramString2 != null)
      {
        paramString1.append(", ");
        paramString1.append(paramString2);
      }
      throw new NullPointerException(paramString1.toString());
    }
  }
  
  private void b(Resource paramResource)
  {
    this.s.a(paramResource);
    this.A = null;
  }
  
  private void b(LoadProvider paramLoadProvider, Object paramObject, Key paramKey, Context paramContext, Priority paramPriority, Target paramTarget, float paramFloat, Drawable paramDrawable1, int paramInt1, Drawable paramDrawable2, int paramInt2, Drawable paramDrawable3, int paramInt3, RequestListener paramRequestListener, RequestCoordinator paramRequestCoordinator, Engine paramEngine, Transformation paramTransformation, Class paramClass, boolean paramBoolean, GlideAnimationFactory paramGlideAnimationFactory, int paramInt4, int paramInt5, DiskCacheStrategy paramDiskCacheStrategy)
  {
    this.j = paramLoadProvider;
    this.l = paramObject;
    this.c = paramKey;
    this.d = paramDrawable3;
    this.e = paramInt3;
    this.h = paramContext.getApplicationContext();
    this.o = paramPriority;
    this.p = paramTarget;
    this.r = paramFloat;
    this.x = paramDrawable1;
    this.f = paramInt1;
    this.y = paramDrawable2;
    this.g = paramInt2;
    this.q = paramRequestListener;
    this.k = paramRequestCoordinator;
    this.s = paramEngine;
    this.i = paramTransformation;
    this.m = paramClass;
    this.n = paramBoolean;
    this.t = paramGlideAnimationFactory;
    this.u = paramInt4;
    this.v = paramInt5;
    this.w = paramDiskCacheStrategy;
    this.D = GenericRequest.Status.a;
    if (paramObject != null)
    {
      a("ModelLoader", paramLoadProvider.e(), "try .using(ModelLoader)");
      a("Transcoder", paramLoadProvider.f(), "try .as*(Class).transcode(ResourceTranscoder)");
      a("Transformation", paramTransformation, "try .transform(UnitTransformation.get())");
      if (!paramDiskCacheStrategy.a()) {
        break label267;
      }
      a("SourceEncoder", paramLoadProvider.c(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
    }
    for (;;)
    {
      if ((paramDiskCacheStrategy.a()) || (paramDiskCacheStrategy.b())) {
        a("CacheDecoder", paramLoadProvider.a(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
      }
      if (paramDiskCacheStrategy.b()) {
        a("Encoder", paramLoadProvider.d(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
      }
      return;
      label267:
      a("SourceDecoder", paramLoadProvider.b(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
    }
  }
  
  private void b(Exception paramException)
  {
    if (!o()) {
      return;
    }
    if (this.l == null) {}
    for (Object localObject2 = k();; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = l();
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = m();
      }
      this.p.a(paramException, (Drawable)localObject2);
      return;
    }
  }
  
  private Drawable k()
  {
    if ((this.d == null) && (this.e > 0)) {
      this.d = this.h.getResources().getDrawable(this.e);
    }
    return this.d;
  }
  
  private Drawable l()
  {
    if ((this.y == null) && (this.g > 0)) {
      this.y = this.h.getResources().getDrawable(this.g);
    }
    return this.y;
  }
  
  private Drawable m()
  {
    if ((this.x == null) && (this.f > 0)) {
      this.x = this.h.getResources().getDrawable(this.f);
    }
    return this.x;
  }
  
  private boolean n()
  {
    return (this.k == null) || (this.k.a(this));
  }
  
  private boolean o()
  {
    return (this.k == null) || (this.k.b(this));
  }
  
  private boolean p()
  {
    return (this.k == null) || (!this.k.c());
  }
  
  private void q()
  {
    if (this.k != null) {
      this.k.c(this);
    }
  }
  
  public void a()
  {
    this.j = null;
    this.l = null;
    this.h = null;
    this.p = null;
    this.x = null;
    this.y = null;
    this.d = null;
    this.q = null;
    this.k = null;
    this.i = null;
    this.t = null;
    this.z = false;
    this.B = null;
    a.offer(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (Log.isLoggable("GenericRequest", 2)) {
      a("Got onSizeReady in " + LogTime.a(this.C));
    }
    if (this.D != GenericRequest.Status.c) {
      return;
    }
    this.D = GenericRequest.Status.b;
    paramInt1 = Math.round(this.r * paramInt1);
    paramInt2 = Math.round(this.r * paramInt2);
    DataFetcher localDataFetcher = this.j.e().a(this.l, paramInt1, paramInt2);
    if (localDataFetcher == null)
    {
      a(new Exception("Failed to load model: '" + this.l + "'"));
      return;
    }
    ResourceTranscoder localResourceTranscoder = this.j.f();
    if (Log.isLoggable("GenericRequest", 2)) {
      a("finished setup for calling load in " + LogTime.a(this.C));
    }
    this.z = true;
    this.B = this.s.a(this.c, paramInt1, paramInt2, localDataFetcher, this.j, this.i, localResourceTranscoder, this.o, this.n, this.w, this);
    if (this.A != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.z = bool;
      if (!Log.isLoggable("GenericRequest", 2)) {
        break;
      }
      a("finished onSizeReady in " + LogTime.a(this.C));
      return;
    }
  }
  
  public void a(Resource paramResource)
  {
    if (paramResource == null)
    {
      a(new Exception("Expected to receive a Resource<R> with an object of " + this.m + " inside, but instead got null."));
      return;
    }
    Object localObject2 = paramResource.b();
    if ((localObject2 == null) || (!this.m.isAssignableFrom(localObject2.getClass())))
    {
      b(paramResource);
      StringBuilder localStringBuilder = new StringBuilder().append("Expected to receive an object of ").append(this.m).append(" but instead got ");
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = localObject2.getClass();
        localObject1 = localStringBuilder.append(localObject1).append("{").append(localObject2).append("}").append(" inside Resource{").append(paramResource).append("}.");
        if (localObject2 == null) {
          break label186;
        }
      }
      label186:
      for (paramResource = "";; paramResource = " To indicate failure return a null Resource object, rather than a Resource object containing null data.")
      {
        a(new Exception(paramResource));
        return;
        localObject1 = "";
        break;
      }
    }
    if (!n())
    {
      b(paramResource);
      this.D = GenericRequest.Status.d;
      return;
    }
    a(paramResource, localObject2);
  }
  
  public void a(Exception paramException)
  {
    if (Log.isLoggable("GenericRequest", 3)) {
      Log.d("GenericRequest", "load failed", paramException);
    }
    this.D = GenericRequest.Status.e;
    if ((this.q == null) || (!this.q.a(paramException, this.l, this.p, p()))) {
      b(paramException);
    }
  }
  
  public void b()
  {
    this.C = LogTime.a();
    if (this.l == null)
    {
      a(null);
      return;
    }
    this.D = GenericRequest.Status.c;
    if (Util.a(this.u, this.v)) {
      a(this.u, this.v);
    }
    for (;;)
    {
      if ((!g()) && (!j()) && (o())) {
        this.p.a(m());
      }
      if (!Log.isLoggable("GenericRequest", 2)) {
        break;
      }
      a("finished run method in " + LogTime.a(this.C));
      return;
      this.p.a(this);
    }
  }
  
  void c()
  {
    this.D = GenericRequest.Status.f;
    if (this.B != null)
    {
      this.B.a();
      this.B = null;
    }
  }
  
  public void d()
  {
    
    if (this.D == GenericRequest.Status.g) {
      return;
    }
    c();
    if (this.A != null) {
      b(this.A);
    }
    if (o()) {
      this.p.b(m());
    }
    this.D = GenericRequest.Status.g;
  }
  
  public void e()
  {
    d();
    this.D = GenericRequest.Status.h;
  }
  
  public boolean f()
  {
    return (this.D == GenericRequest.Status.b) || (this.D == GenericRequest.Status.c);
  }
  
  public boolean g()
  {
    return this.D == GenericRequest.Status.d;
  }
  
  public boolean h()
  {
    return g();
  }
  
  public boolean i()
  {
    return (this.D == GenericRequest.Status.f) || (this.D == GenericRequest.Status.g);
  }
  
  public boolean j()
  {
    return this.D == GenericRequest.Status.e;
  }
}
