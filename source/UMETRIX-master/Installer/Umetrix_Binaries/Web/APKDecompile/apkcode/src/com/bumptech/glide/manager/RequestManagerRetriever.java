package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever
  implements Handler.Callback
{
  private static final RequestManagerRetriever c = new RequestManagerRetriever();
  final Map a = new HashMap();
  final Map b = new HashMap();
  private volatile RequestManager d;
  private final Handler e = new Handler(Looper.getMainLooper(), this);
  
  RequestManagerRetriever() {}
  
  public static RequestManagerRetriever a()
  {
    return c;
  }
  
  private RequestManager b(Context paramContext)
  {
    if (this.d == null) {}
    try
    {
      if (this.d == null) {
        this.d = new RequestManager(paramContext.getApplicationContext(), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode());
      }
      return this.d;
    }
    finally {}
  }
  
  @TargetApi(17)
  private static void b(Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed())) {
      throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }
  }
  
  @TargetApi(11)
  public RequestManager a(Activity paramActivity)
  {
    if ((Util.c()) || (Build.VERSION.SDK_INT < 11)) {
      return a(paramActivity.getApplicationContext());
    }
    b(paramActivity);
    return a(paramActivity, paramActivity.getFragmentManager());
  }
  
  public RequestManager a(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("You cannot start a load on a null Context");
    }
    if ((Util.b()) && (!(paramContext instanceof Application)))
    {
      if ((paramContext instanceof FragmentActivity)) {
        return a((FragmentActivity)paramContext);
      }
      if ((paramContext instanceof Activity)) {
        return a((Activity)paramContext);
      }
      if ((paramContext instanceof ContextWrapper)) {
        return a(((ContextWrapper)paramContext).getBaseContext());
      }
    }
    return b(paramContext);
  }
  
  @TargetApi(11)
  RequestManager a(Context paramContext, android.app.FragmentManager paramFragmentManager)
  {
    RequestManagerFragment localRequestManagerFragment = a(paramFragmentManager);
    RequestManager localRequestManager = localRequestManagerFragment.b();
    paramFragmentManager = localRequestManager;
    if (localRequestManager == null)
    {
      paramFragmentManager = new RequestManager(paramContext, localRequestManagerFragment.a(), localRequestManagerFragment.c());
      localRequestManagerFragment.a(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  RequestManager a(Context paramContext, android.support.v4.app.FragmentManager paramFragmentManager)
  {
    SupportRequestManagerFragment localSupportRequestManagerFragment = a(paramFragmentManager);
    RequestManager localRequestManager = localSupportRequestManagerFragment.I();
    paramFragmentManager = localRequestManager;
    if (localRequestManager == null)
    {
      paramFragmentManager = new RequestManager(paramContext, localSupportRequestManagerFragment.H(), localSupportRequestManagerFragment.J());
      localSupportRequestManagerFragment.a(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  public RequestManager a(FragmentActivity paramFragmentActivity)
  {
    if (Util.c()) {
      return a(paramFragmentActivity.getApplicationContext());
    }
    b(paramFragmentActivity);
    return a(paramFragmentActivity, paramFragmentActivity.f());
  }
  
  @TargetApi(17)
  RequestManagerFragment a(android.app.FragmentManager paramFragmentManager)
  {
    RequestManagerFragment localRequestManagerFragment2 = (RequestManagerFragment)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    RequestManagerFragment localRequestManagerFragment1 = localRequestManagerFragment2;
    if (localRequestManagerFragment2 == null)
    {
      localRequestManagerFragment2 = (RequestManagerFragment)this.a.get(paramFragmentManager);
      localRequestManagerFragment1 = localRequestManagerFragment2;
      if (localRequestManagerFragment2 == null)
      {
        localRequestManagerFragment1 = new RequestManagerFragment();
        this.a.put(paramFragmentManager, localRequestManagerFragment1);
        paramFragmentManager.beginTransaction().add(localRequestManagerFragment1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.e.obtainMessage(1, paramFragmentManager).sendToTarget();
      }
    }
    return localRequestManagerFragment1;
  }
  
  SupportRequestManagerFragment a(android.support.v4.app.FragmentManager paramFragmentManager)
  {
    SupportRequestManagerFragment localSupportRequestManagerFragment2 = (SupportRequestManagerFragment)paramFragmentManager.a("com.bumptech.glide.manager");
    SupportRequestManagerFragment localSupportRequestManagerFragment1 = localSupportRequestManagerFragment2;
    if (localSupportRequestManagerFragment2 == null)
    {
      localSupportRequestManagerFragment2 = (SupportRequestManagerFragment)this.b.get(paramFragmentManager);
      localSupportRequestManagerFragment1 = localSupportRequestManagerFragment2;
      if (localSupportRequestManagerFragment2 == null)
      {
        localSupportRequestManagerFragment1 = new SupportRequestManagerFragment();
        this.b.put(paramFragmentManager, localSupportRequestManagerFragment1);
        paramFragmentManager.a().a(localSupportRequestManagerFragment1, "com.bumptech.glide.manager").a();
        this.e.obtainMessage(2, paramFragmentManager).sendToTarget();
      }
    }
    return localSupportRequestManagerFragment1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    boolean bool = true;
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
      localObject1 = null;
      paramMessage = localObject2;
    }
    for (;;)
    {
      if ((bool) && (localObject1 == null) && (Log.isLoggable("RMRetriever", 5))) {
        Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + paramMessage);
      }
      return bool;
      paramMessage = (android.app.FragmentManager)paramMessage.obj;
      localObject1 = this.a.remove(paramMessage);
      continue;
      paramMessage = (android.support.v4.app.FragmentManager)paramMessage.obj;
      localObject1 = this.b.remove(paramMessage);
    }
  }
}
