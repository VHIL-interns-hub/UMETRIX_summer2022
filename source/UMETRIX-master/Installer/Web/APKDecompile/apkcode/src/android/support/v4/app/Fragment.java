package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener
{
  private static final SimpleArrayMap Z = new SimpleArrayMap();
  static final Object a = new Object();
  boolean A;
  boolean B;
  boolean C;
  boolean D;
  boolean E = true;
  boolean F;
  int G;
  ViewGroup H;
  View I;
  View J;
  boolean K;
  boolean L = true;
  LoaderManagerImpl M;
  boolean N;
  boolean O;
  Object P = null;
  Object Q = a;
  Object R = null;
  Object S = a;
  Object T = null;
  Object U = a;
  Boolean V;
  Boolean W;
  SharedElementCallback X = null;
  SharedElementCallback Y = null;
  int b = 0;
  View c;
  int d;
  Bundle e;
  SparseArray f;
  int g = -1;
  String h;
  Bundle i;
  Fragment j;
  int k = -1;
  int l;
  boolean m;
  boolean n;
  boolean o;
  boolean p;
  boolean q;
  int r;
  FragmentManagerImpl s;
  FragmentHostCallback t;
  FragmentManagerImpl u;
  Fragment v;
  int w;
  int x;
  String y;
  boolean z;
  
  public Fragment() {}
  
  public static Fragment a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }
  
  public static Fragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Class localClass2 = (Class)Z.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        Z.put(paramString, localClass1);
      }
      paramContext = (Fragment)localClass1.newInstance();
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.i = paramBundle;
      }
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", paramContext);
    }
  }
  
  static boolean b(Context paramContext, String paramString)
  {
    try
    {
      Class localClass2 = (Class)Z.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        Z.put(paramString, localClass1);
      }
      boolean bool = Fragment.class.isAssignableFrom(localClass1);
      return bool;
    }
    catch (ClassNotFoundException paramContext) {}
    return false;
  }
  
  void A()
  {
    if (this.u != null)
    {
      this.u.i();
      this.u.e();
    }
    this.b = 5;
    this.F = false;
    i();
    if (!this.F) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }
    if (this.u != null)
    {
      this.u.m();
      this.u.e();
    }
  }
  
  void B()
  {
    onLowMemory();
    if (this.u != null) {
      this.u.s();
    }
  }
  
  void C()
  {
    if (this.u != null) {
      this.u.n();
    }
    this.b = 4;
    this.F = false;
    j();
    if (!this.F) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }
  }
  
  void D()
  {
    if (this.u != null) {
      this.u.o();
    }
    this.b = 3;
    this.F = false;
    k();
    if (!this.F) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }
  }
  
  void E()
  {
    if (this.u != null) {
      this.u.p();
    }
    this.b = 2;
    if (this.N)
    {
      this.N = false;
      if (!this.O)
      {
        this.O = true;
        this.M = this.t.a(this.h, this.N, false);
      }
      if (this.M != null)
      {
        if (!this.t.j()) {
          break label88;
        }
        this.M.d();
      }
    }
    return;
    label88:
    this.M.c();
  }
  
  void F()
  {
    if (this.u != null) {
      this.u.q();
    }
    this.b = 1;
    this.F = false;
    l();
    if (!this.F) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }
    if (this.M != null) {
      this.M.f();
    }
  }
  
  void G()
  {
    if (this.u != null) {
      this.u.r();
    }
    this.b = 0;
    this.F = false;
    m();
    if (!this.F) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }
  }
  
  Fragment a(String paramString)
  {
    if (paramString.equals(this.h)) {
      return this;
    }
    if (this.u != null) {
      return this.u.b(paramString);
    }
    return null;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  public Animation a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void a(int paramInt, Fragment paramFragment)
  {
    this.g = paramInt;
    if (paramFragment != null)
    {
      this.h = (paramFragment.h + ":" + this.g);
      return;
    }
    this.h = ("android:fragment:" + this.g);
  }
  
  public void a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  @Deprecated
  public void a(Activity paramActivity)
  {
    this.F = true;
  }
  
  @Deprecated
  public void a(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.F = true;
  }
  
  public void a(Context paramContext)
  {
    this.F = true;
    if (this.t == null) {}
    for (paramContext = null;; paramContext = this.t.f())
    {
      if (paramContext != null)
      {
        this.F = false;
        a(paramContext);
      }
      return;
    }
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.F = true;
    if (this.t == null) {}
    for (paramContext = null;; paramContext = this.t.f())
    {
      if (paramContext != null)
      {
        this.F = false;
        a(paramContext, paramAttributeSet, paramBundle);
      }
      return;
    }
  }
  
  void a(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    if (this.u != null) {
      this.u.a(paramConfiguration);
    }
  }
  
  final void a(Bundle paramBundle)
  {
    if (this.f != null)
    {
      this.J.restoreHierarchyState(this.f);
      this.f = null;
    }
    this.F = false;
    e(paramBundle);
    if (!this.F) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }
  }
  
  public void a(Menu paramMenu) {}
  
  public void a(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  public void a(View paramView, Bundle paramBundle) {}
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.w));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.x));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.y);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.b);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.g);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.h);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.r);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.m);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.n);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.o);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.p);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.z);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.A);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.E);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.D);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.B);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.C);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.L);
    if (this.s != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.s);
    }
    if (this.t != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.t);
    }
    if (this.v != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.v);
    }
    if (this.i != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.i);
    }
    if (this.e != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.e);
    }
    if (this.f != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.f);
    }
    if (this.j != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.j);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.l);
    }
    if (this.G != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(this.G);
    }
    if (this.H != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.H);
    }
    if (this.I != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.I);
    }
    if (this.J != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.I);
    }
    if (this.c != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(this.c);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(this.d);
    }
    if (this.M != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loader Manager:");
      this.M.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (this.u != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Child " + this.u + ":");
      this.u.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  final boolean a()
  {
    return this.r > 0;
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public final FragmentActivity b()
  {
    if (this.t == null) {
      return null;
    }
    return (FragmentActivity)this.t.f();
  }
  
  public LayoutInflater b(Bundle paramBundle)
  {
    paramBundle = this.t.b();
    d();
    LayoutInflaterCompat.a(paramBundle, this.u.t());
    return paramBundle;
  }
  
  View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.u != null) {
      this.u.i();
    }
    return a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void b(Menu paramMenu) {}
  
  boolean b(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (!this.z)
    {
      boolean bool1 = bool3;
      if (this.D)
      {
        bool1 = bool3;
        if (this.E)
        {
          bool1 = true;
          a(paramMenu, paramMenuInflater);
        }
      }
      bool2 = bool1;
      if (this.u != null) {
        bool2 = bool1 | this.u.a(paramMenu, paramMenuInflater);
      }
    }
    return bool2;
  }
  
  public boolean b(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public final Resources c()
  {
    if (this.t == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    return this.t.g().getResources();
  }
  
  public void c(Bundle paramBundle)
  {
    this.F = true;
  }
  
  boolean c(Menu paramMenu)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (!this.z)
    {
      boolean bool1 = bool3;
      if (this.D)
      {
        bool1 = bool3;
        if (this.E)
        {
          bool1 = true;
          a(paramMenu);
        }
      }
      bool2 = bool1;
      if (this.u != null) {
        bool2 = bool1 | this.u.a(paramMenu);
      }
    }
    return bool2;
  }
  
  boolean c(MenuItem paramMenuItem)
  {
    if (!this.z)
    {
      if ((this.D) && (this.E) && (a(paramMenuItem))) {}
      while ((this.u != null) && (this.u.a(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  public final FragmentManager d()
  {
    if (this.u == null)
    {
      y();
      if (this.b < 5) {
        break label31;
      }
      this.u.m();
    }
    for (;;)
    {
      return this.u;
      label31:
      if (this.b >= 4) {
        this.u.l();
      } else if (this.b >= 2) {
        this.u.k();
      } else if (this.b >= 1) {
        this.u.j();
      }
    }
  }
  
  public void d(Bundle paramBundle)
  {
    this.F = true;
  }
  
  void d(Menu paramMenu)
  {
    if (!this.z)
    {
      if ((this.D) && (this.E)) {
        b(paramMenu);
      }
      if (this.u != null) {
        this.u.b(paramMenu);
      }
    }
  }
  
  boolean d(MenuItem paramMenuItem)
  {
    if (!this.z)
    {
      if (b(paramMenuItem)) {}
      while ((this.u != null) && (this.u.b(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  public void e(Bundle paramBundle)
  {
    this.F = true;
  }
  
  public final boolean e()
  {
    return (this.t != null) && (this.m);
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public void f(Bundle paramBundle) {}
  
  public final boolean f()
  {
    return this.z;
  }
  
  public View g()
  {
    return this.I;
  }
  
  void g(Bundle paramBundle)
  {
    if (this.u != null) {
      this.u.i();
    }
    this.b = 1;
    this.F = false;
    c(paramBundle);
    if (!this.F) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        if (this.u == null) {
          y();
        }
        this.u.a(paramBundle, null);
        this.u.j();
      }
    }
  }
  
  public void h()
  {
    this.F = true;
    if (!this.N)
    {
      this.N = true;
      if (!this.O)
      {
        this.O = true;
        this.M = this.t.a(this.h, this.N, false);
      }
      if (this.M != null) {
        this.M.b();
      }
    }
  }
  
  void h(Bundle paramBundle)
  {
    if (this.u != null) {
      this.u.i();
    }
    this.b = 2;
    this.F = false;
    d(paramBundle);
    if (!this.F) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }
    if (this.u != null) {
      this.u.k();
    }
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public void i()
  {
    this.F = true;
  }
  
  void i(Bundle paramBundle)
  {
    f(paramBundle);
    if (this.u != null)
    {
      Parcelable localParcelable = this.u.h();
      if (localParcelable != null) {
        paramBundle.putParcelable("android:support:fragments", localParcelable);
      }
    }
  }
  
  public void j()
  {
    this.F = true;
  }
  
  public void k()
  {
    this.F = true;
  }
  
  public void l()
  {
    this.F = true;
  }
  
  public void m()
  {
    this.F = true;
    if (!this.O)
    {
      this.O = true;
      this.M = this.t.a(this.h, this.N, false);
    }
    if (this.M != null) {
      this.M.h();
    }
  }
  
  void n()
  {
    this.g = -1;
    this.h = null;
    this.m = false;
    this.n = false;
    this.o = false;
    this.p = false;
    this.q = false;
    this.r = 0;
    this.s = null;
    this.u = null;
    this.t = null;
    this.w = 0;
    this.x = 0;
    this.y = null;
    this.z = false;
    this.A = false;
    this.C = false;
    this.M = null;
    this.N = false;
    this.O = false;
  }
  
  public void o()
  {
    this.F = true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.F = true;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    b().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onLowMemory()
  {
    this.F = true;
  }
  
  public void p() {}
  
  public Object q()
  {
    return this.P;
  }
  
  public Object r()
  {
    if (this.Q == a) {
      return q();
    }
    return this.Q;
  }
  
  public Object s()
  {
    return this.R;
  }
  
  public Object t()
  {
    if (this.S == a) {
      return s();
    }
    return this.S;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    DebugUtils.a(this, localStringBuilder);
    if (this.g >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.g);
    }
    if (this.w != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.w));
    }
    if (this.y != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.y);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public Object u()
  {
    return this.T;
  }
  
  public Object v()
  {
    if (this.U == a) {
      return u();
    }
    return this.U;
  }
  
  public boolean w()
  {
    if (this.W == null) {
      return true;
    }
    return this.W.booleanValue();
  }
  
  public boolean x()
  {
    if (this.V == null) {
      return true;
    }
    return this.V.booleanValue();
  }
  
  void y()
  {
    this.u = new FragmentManagerImpl();
    this.u.a(this.t, new Fragment.1(this), this);
  }
  
  void z()
  {
    if (this.u != null)
    {
      this.u.i();
      this.u.e();
    }
    this.b = 4;
    this.F = false;
    h();
    if (!this.F) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }
    if (this.u != null) {
      this.u.l();
    }
    if (this.M != null) {
      this.M.g();
    }
  }
}
