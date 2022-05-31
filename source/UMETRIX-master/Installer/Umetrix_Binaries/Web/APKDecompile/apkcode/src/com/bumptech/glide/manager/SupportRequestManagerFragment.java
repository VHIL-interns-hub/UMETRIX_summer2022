package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;

public class SupportRequestManagerFragment
  extends Fragment
{
  private RequestManager Z;
  private final ActivityFragmentLifecycle aa;
  private final RequestManagerTreeNode ab = new SupportRequestManagerFragment.SupportFragmentRequestManagerTreeNode(this, null);
  private final HashSet ac = new HashSet();
  private SupportRequestManagerFragment ad;
  
  public SupportRequestManagerFragment()
  {
    this(new ActivityFragmentLifecycle());
  }
  
  @SuppressLint({"ValidFragment"})
  public SupportRequestManagerFragment(ActivityFragmentLifecycle paramActivityFragmentLifecycle)
  {
    this.aa = paramActivityFragmentLifecycle;
  }
  
  private void a(SupportRequestManagerFragment paramSupportRequestManagerFragment)
  {
    this.ac.add(paramSupportRequestManagerFragment);
  }
  
  private void b(SupportRequestManagerFragment paramSupportRequestManagerFragment)
  {
    this.ac.remove(paramSupportRequestManagerFragment);
  }
  
  ActivityFragmentLifecycle H()
  {
    return this.aa;
  }
  
  public RequestManager I()
  {
    return this.Z;
  }
  
  public RequestManagerTreeNode J()
  {
    return this.ab;
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    this.ad = RequestManagerRetriever.a().a(b().f());
    if (this.ad != this) {
      this.ad.a(this);
    }
  }
  
  public void a(RequestManager paramRequestManager)
  {
    this.Z = paramRequestManager;
  }
  
  public void h()
  {
    super.h();
    this.aa.a();
  }
  
  public void k()
  {
    super.k();
    this.aa.b();
  }
  
  public void m()
  {
    super.m();
    this.aa.c();
  }
  
  public void o()
  {
    super.o();
    if (this.ad != null)
    {
      this.ad.b(this);
      this.ad = null;
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.Z != null) {
      this.Z.a();
    }
  }
}
