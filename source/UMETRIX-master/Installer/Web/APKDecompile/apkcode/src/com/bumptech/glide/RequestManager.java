package com.bumptech.glide;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.util.Util;

public class RequestManager
  implements LifecycleListener
{
  private final Context a;
  private final Lifecycle b;
  private final RequestManagerTreeNode c;
  private final RequestTracker d;
  private final Glide e;
  private final RequestManager.OptionsApplier f;
  private RequestManager.DefaultOptions g;
  
  public RequestManager(Context paramContext, Lifecycle paramLifecycle, RequestManagerTreeNode paramRequestManagerTreeNode)
  {
    this(paramContext, paramLifecycle, paramRequestManagerTreeNode, new RequestTracker(), new ConnectivityMonitorFactory());
  }
  
  RequestManager(Context paramContext, Lifecycle paramLifecycle, RequestManagerTreeNode paramRequestManagerTreeNode, RequestTracker paramRequestTracker, ConnectivityMonitorFactory paramConnectivityMonitorFactory)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramLifecycle;
    this.c = paramRequestManagerTreeNode;
    this.d = paramRequestTracker;
    this.e = Glide.a(paramContext);
    this.f = new RequestManager.OptionsApplier(this);
    paramContext = paramConnectivityMonitorFactory.a(paramContext, new RequestManager.RequestManagerConnectivityListener(paramRequestTracker));
    if (Util.c()) {
      new Handler(Looper.getMainLooper()).post(new RequestManager.1(this, paramLifecycle));
    }
    for (;;)
    {
      paramLifecycle.a(paramContext);
      return;
      paramLifecycle.a(this);
    }
  }
  
  private DrawableTypeRequest a(Class paramClass)
  {
    ModelLoader localModelLoader1 = Glide.a(paramClass, this.a);
    ModelLoader localModelLoader2 = Glide.b(paramClass, this.a);
    if ((paramClass != null) && (localModelLoader1 == null) && (localModelLoader2 == null)) {
      throw new IllegalArgumentException("Unknown type " + paramClass + ". You must provide a Model of a type for" + " which there is a registered ModelLoader, if you are using a custom model, you must first call" + " Glide#register with a ModelLoaderFactory for your custom model class");
    }
    return (DrawableTypeRequest)this.f.a(new DrawableTypeRequest(paramClass, localModelLoader1, localModelLoader2, this.a, this.e, this.d, this.b, this.f));
  }
  
  private static Class b(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.getClass();
    }
    return null;
  }
  
  public DrawableTypeRequest a(String paramString)
  {
    return (DrawableTypeRequest)g().a(paramString);
  }
  
  public RequestManager.GenericModelRequest a(ModelLoader paramModelLoader, Class paramClass)
  {
    return new RequestManager.GenericModelRequest(this, paramModelLoader, paramClass);
  }
  
  public void a()
  {
    this.e.e();
  }
  
  public void a(int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public void b()
  {
    Util.a();
    this.d.a();
  }
  
  public void c()
  {
    Util.a();
    this.d.b();
  }
  
  public void d()
  {
    c();
  }
  
  public void e()
  {
    b();
  }
  
  public void f()
  {
    this.d.c();
  }
  
  public DrawableTypeRequest g()
  {
    return a(String.class);
  }
}
