package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;

@TargetApi(11)
public class RequestManagerFragment
  extends Fragment
{
  private final ActivityFragmentLifecycle a;
  private final RequestManagerTreeNode b = new RequestManagerFragment.FragmentRequestManagerTreeNode(this, null);
  private RequestManager c;
  private final HashSet d = new HashSet();
  private RequestManagerFragment e;
  
  public RequestManagerFragment()
  {
    this(new ActivityFragmentLifecycle());
  }
  
  @SuppressLint({"ValidFragment"})
  RequestManagerFragment(ActivityFragmentLifecycle paramActivityFragmentLifecycle)
  {
    this.a = paramActivityFragmentLifecycle;
  }
  
  private void a(RequestManagerFragment paramRequestManagerFragment)
  {
    this.d.add(paramRequestManagerFragment);
  }
  
  private void b(RequestManagerFragment paramRequestManagerFragment)
  {
    this.d.remove(paramRequestManagerFragment);
  }
  
  ActivityFragmentLifecycle a()
  {
    return this.a;
  }
  
  public void a(RequestManager paramRequestManager)
  {
    this.c = paramRequestManager;
  }
  
  public RequestManager b()
  {
    return this.c;
  }
  
  public RequestManagerTreeNode c()
  {
    return this.b;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.e = RequestManagerRetriever.a().a(getActivity().getFragmentManager());
    if (this.e != this) {
      this.e.a(this);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.c();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.e != null)
    {
      this.e.b(this);
      this.e = null;
    }
  }
  
  public void onLowMemory()
  {
    if (this.c != null) {
      this.c.a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.a();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.b();
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (this.c != null) {
      this.c.a(paramInt);
    }
  }
}
