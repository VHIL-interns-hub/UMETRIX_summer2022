package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback
  extends FragmentContainer
{
  private final Activity a;
  final Context b;
  final int c;
  final FragmentManagerImpl d = new FragmentManagerImpl();
  private final Handler e;
  private SimpleArrayMap f;
  private boolean g;
  private LoaderManagerImpl h;
  private boolean i;
  private boolean j;
  
  FragmentHostCallback(Activity paramActivity, Context paramContext, Handler paramHandler, int paramInt)
  {
    this.a = paramActivity;
    this.b = paramContext;
    this.e = paramHandler;
    this.c = paramInt;
  }
  
  FragmentHostCallback(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, paramFragmentActivity.a, 0);
  }
  
  LoaderManagerImpl a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f == null) {
      this.f = new SimpleArrayMap();
    }
    LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.f.get(paramString);
    if (localLoaderManagerImpl == null)
    {
      if (paramBoolean2)
      {
        localLoaderManagerImpl = new LoaderManagerImpl(paramString, this, paramBoolean1);
        this.f.put(paramString, localLoaderManagerImpl);
      }
      return localLoaderManagerImpl;
    }
    localLoaderManagerImpl.a(this);
    return localLoaderManagerImpl;
  }
  
  public View a(int paramInt)
  {
    return null;
  }
  
  void a(SimpleArrayMap paramSimpleArrayMap)
  {
    this.f = paramSimpleArrayMap;
  }
  
  void a(String paramString)
  {
    if (this.f != null)
    {
      LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.f.get(paramString);
      if ((localLoaderManagerImpl != null) && (!localLoaderManagerImpl.f))
      {
        localLoaderManagerImpl.h();
        this.f.remove(paramString);
      }
    }
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (this.h == null) {}
    while (!this.j) {
      return;
    }
    this.j = false;
    if (paramBoolean)
    {
      this.h.d();
      return;
    }
    this.h.c();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(Fragment paramFragment)
  {
    return true;
  }
  
  public LayoutInflater b()
  {
    return (LayoutInflater)this.b.getSystemService("layout_inflater");
  }
  
  void b(Fragment paramFragment) {}
  
  void b(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.j);
    if (this.h != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.h)));
      paramPrintWriter.println(":");
      this.h.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public void c() {}
  
  public boolean d()
  {
    return true;
  }
  
  public int e()
  {
    return this.c;
  }
  
  Activity f()
  {
    return this.a;
  }
  
  Context g()
  {
    return this.b;
  }
  
  Handler h()
  {
    return this.e;
  }
  
  FragmentManagerImpl i()
  {
    return this.d;
  }
  
  boolean j()
  {
    return this.g;
  }
  
  void k()
  {
    if (this.j) {
      return;
    }
    this.j = true;
    if (this.h != null) {
      this.h.b();
    }
    for (;;)
    {
      this.i = true;
      return;
      if (!this.i)
      {
        this.h = a("(root)", this.j, false);
        if ((this.h != null) && (!this.h.e)) {
          this.h.b();
        }
      }
    }
  }
  
  void l()
  {
    if (this.h == null) {
      return;
    }
    this.h.h();
  }
  
  void m()
  {
    if (this.f != null)
    {
      int m = this.f.size();
      LoaderManagerImpl[] arrayOfLoaderManagerImpl = new LoaderManagerImpl[m];
      int k = m - 1;
      while (k >= 0)
      {
        arrayOfLoaderManagerImpl[k] = ((LoaderManagerImpl)this.f.c(k));
        k -= 1;
      }
      k = 0;
      while (k < m)
      {
        LoaderManagerImpl localLoaderManagerImpl = arrayOfLoaderManagerImpl[k];
        localLoaderManagerImpl.e();
        localLoaderManagerImpl.g();
        k += 1;
      }
    }
  }
  
  SimpleArrayMap n()
  {
    int m = 0;
    int n;
    if (this.f != null)
    {
      int i1 = this.f.size();
      LoaderManagerImpl[] arrayOfLoaderManagerImpl = new LoaderManagerImpl[i1];
      int k = i1 - 1;
      while (k >= 0)
      {
        arrayOfLoaderManagerImpl[k] = ((LoaderManagerImpl)this.f.c(k));
        k -= 1;
      }
      k = 0;
      n = k;
      if (m < i1)
      {
        LoaderManagerImpl localLoaderManagerImpl = arrayOfLoaderManagerImpl[m];
        if (localLoaderManagerImpl.f) {
          k = 1;
        }
        for (;;)
        {
          m += 1;
          break;
          localLoaderManagerImpl.h();
          this.f.remove(localLoaderManagerImpl.d);
        }
      }
    }
    else
    {
      n = 0;
    }
    if (n != 0) {
      return this.f;
    }
    return null;
  }
}
