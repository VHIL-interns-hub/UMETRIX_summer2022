package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord
  extends FragmentTransaction
  implements Runnable
{
  static final boolean a;
  final FragmentManagerImpl b;
  BackStackRecord.Op c;
  BackStackRecord.Op d;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  boolean l;
  boolean m = true;
  String n;
  boolean o;
  int p = -1;
  int q;
  CharSequence r;
  int s;
  CharSequence t;
  ArrayList u;
  ArrayList v;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl)
  {
    this.b = paramFragmentManagerImpl;
  }
  
  private BackStackRecord.TransitionState a(SparseArray paramSparseArray1, SparseArray paramSparseArray2, boolean paramBoolean)
  {
    int i5 = 0;
    a(paramSparseArray2);
    BackStackRecord.TransitionState localTransitionState = new BackStackRecord.TransitionState(this);
    localTransitionState.d = new View(this.b.o.g());
    int i2 = 0;
    int i1 = 0;
    int i3 = i5;
    int i4 = i1;
    if (i2 < paramSparseArray1.size())
    {
      if (!a(paramSparseArray1.keyAt(i2), localTransitionState, paramBoolean, paramSparseArray1, paramSparseArray2)) {
        break label169;
      }
      i1 = 1;
    }
    label169:
    for (;;)
    {
      i2 += 1;
      break;
      while (i3 < paramSparseArray2.size())
      {
        i2 = paramSparseArray2.keyAt(i3);
        i1 = i4;
        if (paramSparseArray1.get(i2) == null)
        {
          i1 = i4;
          if (a(i2, localTransitionState, paramBoolean, paramSparseArray1, paramSparseArray2)) {
            i1 = 1;
          }
        }
        i3 += 1;
        i4 = i1;
      }
      paramSparseArray1 = localTransitionState;
      if (i4 == 0) {
        paramSparseArray1 = null;
      }
      return paramSparseArray1;
    }
  }
  
  private ArrayMap a(BackStackRecord.TransitionState paramTransitionState, Fragment paramFragment, boolean paramBoolean)
  {
    ArrayMap localArrayMap2 = new ArrayMap();
    ArrayMap localArrayMap1 = localArrayMap2;
    if (this.u != null)
    {
      FragmentTransitionCompat21.a(localArrayMap2, paramFragment.g());
      if (!paramBoolean) {
        break label82;
      }
      localArrayMap2.a(this.v);
    }
    label82:
    for (localArrayMap1 = localArrayMap2; paramBoolean; localArrayMap1 = a(this.u, this.v, localArrayMap2))
    {
      if (paramFragment.X != null) {
        paramFragment.X.a(this.v, localArrayMap1);
      }
      a(paramTransitionState, localArrayMap1, false);
      return localArrayMap1;
    }
    if (paramFragment.Y != null) {
      paramFragment.Y.a(this.v, localArrayMap1);
    }
    b(paramTransitionState, localArrayMap1, false);
    return localArrayMap1;
  }
  
  private ArrayMap a(BackStackRecord.TransitionState paramTransitionState, boolean paramBoolean, Fragment paramFragment)
  {
    ArrayMap localArrayMap = b(paramTransitionState, paramFragment, paramBoolean);
    if (paramBoolean)
    {
      if (paramFragment.Y != null) {
        paramFragment.Y.a(this.v, localArrayMap);
      }
      a(paramTransitionState, localArrayMap, true);
      return localArrayMap;
    }
    if (paramFragment.X != null) {
      paramFragment.X.a(this.v, localArrayMap);
    }
    b(paramTransitionState, localArrayMap, true);
    return localArrayMap;
  }
  
  private static ArrayMap a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayMap paramArrayMap)
  {
    if (paramArrayMap.isEmpty()) {
      return paramArrayMap;
    }
    ArrayMap localArrayMap = new ArrayMap();
    int i2 = paramArrayList1.size();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = (View)paramArrayMap.get(paramArrayList1.get(i1));
      if (localView != null) {
        localArrayMap.put(paramArrayList2.get(i1), localView);
      }
      i1 += 1;
    }
    return localArrayMap;
  }
  
  private static Object a(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 == null) || (paramFragment2 == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment1 = paramFragment2.v();; paramFragment1 = paramFragment1.u()) {
      return FragmentTransitionCompat21.b(paramFragment1);
    }
  }
  
  private static Object a(Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.t();; paramFragment = paramFragment.q()) {
      return FragmentTransitionCompat21.a(paramFragment);
    }
  }
  
  private static Object a(Object paramObject, Fragment paramFragment, ArrayList paramArrayList, ArrayMap paramArrayMap, View paramView)
  {
    Object localObject = paramObject;
    if (paramObject != null) {
      localObject = FragmentTransitionCompat21.a(paramObject, paramFragment.g(), paramArrayList, paramArrayMap, paramView);
    }
    return localObject;
  }
  
  private void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    paramFragment.s = this.b;
    if (paramString != null)
    {
      if ((paramFragment.y != null) && (!paramString.equals(paramFragment.y))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.y + " now " + paramString);
      }
      paramFragment.y = paramString;
    }
    if (paramInt1 != 0)
    {
      if ((paramFragment.w != 0) && (paramFragment.w != paramInt1)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.w + " now " + paramInt1);
      }
      paramFragment.w = paramInt1;
      paramFragment.x = paramInt1;
    }
    paramString = new BackStackRecord.Op();
    paramString.c = paramInt2;
    paramString.d = paramFragment;
    a(paramString);
  }
  
  private void a(BackStackRecord.TransitionState paramTransitionState, int paramInt, Object paramObject)
  {
    if (this.b.g != null)
    {
      int i1 = 0;
      if (i1 < this.b.g.size())
      {
        Fragment localFragment = (Fragment)this.b.g.get(i1);
        if ((localFragment.I != null) && (localFragment.H != null) && (localFragment.x == paramInt))
        {
          if (!localFragment.z) {
            break label125;
          }
          if (!paramTransitionState.b.contains(localFragment.I))
          {
            FragmentTransitionCompat21.a(paramObject, localFragment.I, true);
            paramTransitionState.b.add(localFragment.I);
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          label125:
          FragmentTransitionCompat21.a(paramObject, localFragment.I, false);
          paramTransitionState.b.remove(localFragment.I);
        }
      }
    }
  }
  
  private void a(BackStackRecord.TransitionState paramTransitionState, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayMap paramArrayMap)
  {
    if (paramBoolean) {}
    for (paramTransitionState = paramFragment2.X;; paramTransitionState = paramFragment1.X)
    {
      if (paramTransitionState != null) {
        paramTransitionState.b(new ArrayList(paramArrayMap.keySet()), new ArrayList(paramArrayMap.values()), null);
      }
      return;
    }
  }
  
  private void a(BackStackRecord.TransitionState paramTransitionState, ArrayMap paramArrayMap, boolean paramBoolean)
  {
    int i1;
    int i2;
    label13:
    String str;
    Object localObject;
    if (this.v == null)
    {
      i1 = 0;
      i2 = 0;
      if (i2 >= i1) {
        return;
      }
      str = (String)this.u.get(i2);
      localObject = (View)paramArrayMap.get((String)this.v.get(i2));
      if (localObject != null)
      {
        localObject = FragmentTransitionCompat21.a((View)localObject);
        if (!paramBoolean) {
          break label103;
        }
        a(paramTransitionState.a, str, (String)localObject);
      }
    }
    for (;;)
    {
      i2 += 1;
      break label13;
      i1 = this.v.size();
      break;
      label103:
      a(paramTransitionState.a, (String)localObject, str);
    }
  }
  
  private void a(BackStackRecord.TransitionState paramTransitionState, View paramView, Object paramObject, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayList paramArrayList)
  {
    paramView.getViewTreeObserver().addOnPreDrawListener(new BackStackRecord.2(this, paramView, paramObject, paramArrayList, paramTransitionState, paramBoolean, paramFragment1, paramFragment2));
  }
  
  private static void a(BackStackRecord.TransitionState paramTransitionState, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (paramArrayList1 != null)
    {
      int i1 = 0;
      while (i1 < paramArrayList1.size())
      {
        String str1 = (String)paramArrayList1.get(i1);
        String str2 = (String)paramArrayList2.get(i1);
        a(paramTransitionState.a, str1, str2);
        i1 += 1;
      }
    }
  }
  
  private void a(ArrayMap paramArrayMap, BackStackRecord.TransitionState paramTransitionState)
  {
    if ((this.v != null) && (!paramArrayMap.isEmpty()))
    {
      paramArrayMap = (View)paramArrayMap.get(this.v.get(0));
      if (paramArrayMap != null) {
        paramTransitionState.c.a = paramArrayMap;
      }
    }
  }
  
  private static void a(ArrayMap paramArrayMap, String paramString1, String paramString2)
  {
    int i1;
    if ((paramString1 != null) && (paramString2 != null)) {
      i1 = 0;
    }
    while (i1 < paramArrayMap.size())
    {
      if (paramString1.equals(paramArrayMap.c(i1)))
      {
        paramArrayMap.a(i1, paramString2);
        return;
      }
      i1 += 1;
    }
    paramArrayMap.put(paramString1, paramString2);
  }
  
  private void a(SparseArray paramSparseArray)
  {
    int i2 = paramSparseArray.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Fragment localFragment = (Fragment)paramSparseArray.valueAt(i1);
      if (localFragment.b < 1)
      {
        this.b.c(localFragment);
        this.b.a(localFragment, 1, 0, 0, false);
      }
      i1 += 1;
    }
  }
  
  private static void a(SparseArray paramSparseArray1, SparseArray paramSparseArray2, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i1 = paramFragment.x;
      if ((i1 != 0) && (!paramFragment.f()))
      {
        if ((paramFragment.e()) && (paramFragment.g() != null) && (paramSparseArray1.get(i1) == null)) {
          paramSparseArray1.put(i1, paramFragment);
        }
        if (paramSparseArray2.get(i1) == paramFragment) {
          paramSparseArray2.remove(i1);
        }
      }
    }
  }
  
  private void a(View paramView, BackStackRecord.TransitionState paramTransitionState, int paramInt, Object paramObject)
  {
    paramView.getViewTreeObserver().addOnPreDrawListener(new BackStackRecord.3(this, paramView, paramTransitionState, paramInt, paramObject));
  }
  
  private boolean a(int paramInt, BackStackRecord.TransitionState paramTransitionState, boolean paramBoolean, SparseArray paramSparseArray1, SparseArray paramSparseArray2)
  {
    ViewGroup localViewGroup = (ViewGroup)this.b.p.a(paramInt);
    if (localViewGroup == null) {
      return false;
    }
    Object localObject2 = (Fragment)paramSparseArray2.get(paramInt);
    Object localObject4 = (Fragment)paramSparseArray1.get(paramInt);
    Object localObject3 = a((Fragment)localObject2, paramBoolean);
    paramSparseArray2 = a((Fragment)localObject2, (Fragment)localObject4, paramBoolean);
    Object localObject5 = b((Fragment)localObject4, paramBoolean);
    paramSparseArray1 = null;
    ArrayList localArrayList1 = new ArrayList();
    if (paramSparseArray2 != null)
    {
      localObject1 = a(paramTransitionState, (Fragment)localObject4, paramBoolean);
      if (((ArrayMap)localObject1).isEmpty())
      {
        paramSparseArray1 = null;
        paramSparseArray2 = null;
        if ((localObject3 != null) || (paramSparseArray2 != null) || (localObject5 != null)) {
          break label208;
        }
        return false;
      }
      if (!paramBoolean) {
        break label198;
      }
    }
    label198:
    for (paramSparseArray1 = ((Fragment)localObject4).X;; paramSparseArray1 = ((Fragment)localObject2).X)
    {
      if (paramSparseArray1 != null) {
        paramSparseArray1.a(new ArrayList(((ArrayMap)localObject1).keySet()), new ArrayList(((ArrayMap)localObject1).values()), null);
      }
      a(paramTransitionState, localViewGroup, paramSparseArray2, (Fragment)localObject2, (Fragment)localObject4, paramBoolean, localArrayList1);
      paramSparseArray1 = (SparseArray)localObject1;
      break;
    }
    label208:
    Object localObject1 = new ArrayList();
    localObject4 = a(localObject5, (Fragment)localObject4, (ArrayList)localObject1, paramSparseArray1, paramTransitionState.d);
    if ((this.v != null) && (paramSparseArray1 != null))
    {
      localObject5 = (View)paramSparseArray1.get(this.v.get(0));
      if (localObject5 != null)
      {
        if (localObject4 != null) {
          FragmentTransitionCompat21.a(localObject4, (View)localObject5);
        }
        if (paramSparseArray2 != null) {
          FragmentTransitionCompat21.a(paramSparseArray2, (View)localObject5);
        }
      }
    }
    localObject5 = new BackStackRecord.1(this, (Fragment)localObject2);
    ArrayList localArrayList2 = new ArrayList();
    ArrayMap localArrayMap = new ArrayMap();
    boolean bool = true;
    if (localObject2 != null) {
      if (!paramBoolean) {
        break label462;
      }
    }
    label462:
    for (bool = ((Fragment)localObject2).x();; bool = ((Fragment)localObject2).w())
    {
      localObject2 = FragmentTransitionCompat21.a(localObject3, localObject4, paramSparseArray2, bool);
      if (localObject2 != null)
      {
        FragmentTransitionCompat21.a(localObject3, paramSparseArray2, localViewGroup, (FragmentTransitionCompat21.ViewRetriever)localObject5, paramTransitionState.d, paramTransitionState.c, paramTransitionState.a, localArrayList2, paramSparseArray1, localArrayMap, localArrayList1);
        a(localViewGroup, paramTransitionState, paramInt, localObject2);
        FragmentTransitionCompat21.a(localObject2, paramTransitionState.d, true);
        a(paramTransitionState, paramInt, localObject2);
        FragmentTransitionCompat21.a(localViewGroup, localObject2);
        FragmentTransitionCompat21.a(localViewGroup, paramTransitionState.d, localObject3, localArrayList2, localObject4, (ArrayList)localObject1, paramSparseArray2, localArrayList1, localObject2, paramTransitionState.b, localArrayMap);
      }
      if (localObject2 == null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private ArrayMap b(BackStackRecord.TransitionState paramTransitionState, Fragment paramFragment, boolean paramBoolean)
  {
    ArrayMap localArrayMap = new ArrayMap();
    paramFragment = paramFragment.g();
    paramTransitionState = localArrayMap;
    if (paramFragment != null)
    {
      paramTransitionState = localArrayMap;
      if (this.u != null)
      {
        FragmentTransitionCompat21.a(localArrayMap, paramFragment);
        if (!paramBoolean) {
          break label57;
        }
        paramTransitionState = a(this.u, this.v, localArrayMap);
      }
    }
    return paramTransitionState;
    label57:
    localArrayMap.a(this.v);
    return localArrayMap;
  }
  
  private static Object b(Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.r();; paramFragment = paramFragment.s()) {
      return FragmentTransitionCompat21.a(paramFragment);
    }
  }
  
  private void b(BackStackRecord.TransitionState paramTransitionState, ArrayMap paramArrayMap, boolean paramBoolean)
  {
    int i2 = paramArrayMap.size();
    int i1 = 0;
    if (i1 < i2)
    {
      String str1 = (String)paramArrayMap.b(i1);
      String str2 = FragmentTransitionCompat21.a((View)paramArrayMap.c(i1));
      if (paramBoolean) {
        a(paramTransitionState.a, str1, str2);
      }
      for (;;)
      {
        i1 += 1;
        break;
        a(paramTransitionState.a, str2, str1);
      }
    }
  }
  
  private void b(SparseArray paramSparseArray1, SparseArray paramSparseArray2)
  {
    if (!this.b.p.a()) {}
    BackStackRecord.Op localOp;
    do
    {
      return;
      localOp = this.c;
    } while (localOp == null);
    switch (localOp.c)
    {
    }
    for (;;)
    {
      localOp = localOp.a;
      break;
      b(paramSparseArray1, paramSparseArray2, localOp.d);
      continue;
      Object localObject1 = localOp.d;
      if (this.b.g != null)
      {
        int i1 = 0;
        if (i1 < this.b.g.size())
        {
          Fragment localFragment = (Fragment)this.b.g.get(i1);
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (localFragment.x != ((Fragment)localObject1).x) {}
          }
          else
          {
            if (localFragment != localObject1) {
              break label197;
            }
            localObject2 = null;
            paramSparseArray2.remove(localFragment.x);
          }
          for (;;)
          {
            i1 += 1;
            localObject1 = localObject2;
            break;
            label197:
            a(paramSparseArray1, paramSparseArray2, localFragment);
            localObject2 = localObject1;
          }
        }
      }
      b(paramSparseArray1, paramSparseArray2, localOp.d);
      continue;
      a(paramSparseArray1, paramSparseArray2, localOp.d);
      continue;
      a(paramSparseArray1, paramSparseArray2, localOp.d);
      continue;
      b(paramSparseArray1, paramSparseArray2, localOp.d);
      continue;
      a(paramSparseArray1, paramSparseArray2, localOp.d);
      continue;
      b(paramSparseArray1, paramSparseArray2, localOp.d);
    }
  }
  
  private void b(SparseArray paramSparseArray1, SparseArray paramSparseArray2, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i1 = paramFragment.x;
      if (i1 != 0)
      {
        if (!paramFragment.e()) {
          paramSparseArray2.put(i1, paramFragment);
        }
        if (paramSparseArray1.get(i1) == paramFragment) {
          paramSparseArray1.remove(i1);
        }
      }
    }
  }
  
  public int a()
  {
    return a(true);
  }
  
  int a(boolean paramBoolean)
  {
    if (this.o) {
      throw new IllegalStateException("commit already called");
    }
    if (FragmentManagerImpl.a)
    {
      Log.v("FragmentManager", "Commit: " + this);
      a("  ", null, new PrintWriter(new LogWriter("FragmentManager")), null);
    }
    this.o = true;
    if (this.l) {}
    for (this.p = this.b.a(this);; this.p = -1)
    {
      this.b.a(this, paramBoolean);
      return this.p;
    }
  }
  
  public BackStackRecord.TransitionState a(boolean paramBoolean, BackStackRecord.TransitionState paramTransitionState, SparseArray paramSparseArray1, SparseArray paramSparseArray2)
  {
    if (FragmentManagerImpl.a)
    {
      Log.v("FragmentManager", "popFromBackStack: " + this);
      a("  ", null, new PrintWriter(new LogWriter("FragmentManager")), null);
    }
    BackStackRecord.TransitionState localTransitionState = paramTransitionState;
    if (a)
    {
      if (paramTransitionState != null) {
        break label223;
      }
      if (paramSparseArray1.size() == 0)
      {
        localTransitionState = paramTransitionState;
        if (paramSparseArray2.size() == 0) {}
      }
      else
      {
        localTransitionState = a(paramSparseArray1, paramSparseArray2, true);
      }
    }
    label100:
    a(-1);
    int i1;
    label113:
    int i2;
    label121:
    int i3;
    if (localTransitionState != null)
    {
      i1 = 0;
      if (localTransitionState == null) {
        break label257;
      }
      i2 = 0;
      paramTransitionState = this.d;
      if (paramTransitionState == null) {
        break label546;
      }
      if (localTransitionState == null) {
        break label266;
      }
      i3 = 0;
      label138:
      if (localTransitionState == null) {
        break label275;
      }
    }
    label223:
    label257:
    label266:
    label275:
    for (int i4 = 0;; i4 = paramTransitionState.h) {
      switch (paramTransitionState.c)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + paramTransitionState.c);
        localTransitionState = paramTransitionState;
        if (paramBoolean) {
          break label100;
        }
        a(paramTransitionState, this.v, this.u);
        localTransitionState = paramTransitionState;
        break label100;
        i1 = this.k;
        break label113;
        i2 = this.j;
        break label121;
        i3 = paramTransitionState.g;
        break label138;
      }
    }
    paramSparseArray1 = paramTransitionState.d;
    paramSparseArray1.G = i4;
    this.b.a(paramSparseArray1, FragmentManagerImpl.c(i2), i1);
    for (;;)
    {
      paramTransitionState = paramTransitionState.b;
      break;
      paramSparseArray1 = paramTransitionState.d;
      if (paramSparseArray1 != null)
      {
        paramSparseArray1.G = i4;
        this.b.a(paramSparseArray1, FragmentManagerImpl.c(i2), i1);
      }
      if (paramTransitionState.i != null)
      {
        i4 = 0;
        while (i4 < paramTransitionState.i.size())
        {
          paramSparseArray1 = (Fragment)paramTransitionState.i.get(i4);
          paramSparseArray1.G = i3;
          this.b.a(paramSparseArray1, false);
          i4 += 1;
        }
        paramSparseArray1 = paramTransitionState.d;
        paramSparseArray1.G = i3;
        this.b.a(paramSparseArray1, false);
        continue;
        paramSparseArray1 = paramTransitionState.d;
        paramSparseArray1.G = i3;
        this.b.c(paramSparseArray1, FragmentManagerImpl.c(i2), i1);
        continue;
        paramSparseArray1 = paramTransitionState.d;
        paramSparseArray1.G = i4;
        this.b.b(paramSparseArray1, FragmentManagerImpl.c(i2), i1);
        continue;
        paramSparseArray1 = paramTransitionState.d;
        paramSparseArray1.G = i3;
        this.b.e(paramSparseArray1, FragmentManagerImpl.c(i2), i1);
        continue;
        paramSparseArray1 = paramTransitionState.d;
        paramSparseArray1.G = i3;
        this.b.d(paramSparseArray1, FragmentManagerImpl.c(i2), i1);
      }
    }
    label546:
    if (paramBoolean)
    {
      this.b.a(this.b.n, FragmentManagerImpl.c(i2), i1, true);
      localTransitionState = null;
    }
    if (this.p >= 0)
    {
      this.b.b(this.p);
      this.p = -1;
    }
    return localTransitionState;
  }
  
  public FragmentTransaction a(Fragment paramFragment, String paramString)
  {
    a(0, paramFragment, paramString, 1);
    return this;
  }
  
  void a(int paramInt)
  {
    if (!this.l) {}
    for (;;)
    {
      return;
      if (FragmentManagerImpl.a) {
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + paramInt);
      }
      for (BackStackRecord.Op localOp = this.c; localOp != null; localOp = localOp.a)
      {
        Fragment localFragment;
        if (localOp.d != null)
        {
          localFragment = localOp.d;
          localFragment.r += paramInt;
          if (FragmentManagerImpl.a) {
            Log.v("FragmentManager", "Bump nesting of " + localOp.d + " to " + localOp.d.r);
          }
        }
        if (localOp.i != null)
        {
          int i1 = localOp.i.size() - 1;
          while (i1 >= 0)
          {
            localFragment = (Fragment)localOp.i.get(i1);
            localFragment.r += paramInt;
            if (FragmentManagerImpl.a) {
              Log.v("FragmentManager", "Bump nesting of " + localFragment + " to " + localFragment.r);
            }
            i1 -= 1;
          }
        }
      }
    }
  }
  
  void a(BackStackRecord.Op paramOp)
  {
    if (this.c == null)
    {
      this.d = paramOp;
      this.c = paramOp;
    }
    for (;;)
    {
      paramOp.e = this.f;
      paramOp.f = this.g;
      paramOp.g = this.h;
      paramOp.h = this.i;
      this.e += 1;
      return;
      paramOp.b = this.d;
      this.d.a = paramOp;
      this.d = paramOp;
    }
  }
  
  public void a(SparseArray paramSparseArray1, SparseArray paramSparseArray2)
  {
    if (!this.b.p.a()) {}
    BackStackRecord.Op localOp;
    do
    {
      return;
      localOp = this.d;
    } while (localOp == null);
    switch (localOp.c)
    {
    }
    for (;;)
    {
      localOp = localOp.b;
      break;
      a(paramSparseArray1, paramSparseArray2, localOp.d);
      continue;
      if (localOp.i != null)
      {
        int i1 = localOp.i.size() - 1;
        while (i1 >= 0)
        {
          b(paramSparseArray1, paramSparseArray2, (Fragment)localOp.i.get(i1));
          i1 -= 1;
        }
      }
      a(paramSparseArray1, paramSparseArray2, localOp.d);
      continue;
      b(paramSparseArray1, paramSparseArray2, localOp.d);
      continue;
      b(paramSparseArray1, paramSparseArray2, localOp.d);
      continue;
      a(paramSparseArray1, paramSparseArray2, localOp.d);
      continue;
      b(paramSparseArray1, paramSparseArray2, localOp.d);
      continue;
      a(paramSparseArray1, paramSparseArray2, localOp.d);
    }
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    a(paramString, paramPrintWriter, true);
  }
  
  public void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.n);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.p);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.o);
      if (this.j != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.j));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.k));
      }
      if ((this.f != 0) || (this.g != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.f));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.g));
      }
      if ((this.h != 0) || (this.i != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.h));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.i));
      }
      if ((this.q != 0) || (this.r != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.q));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.r);
      }
      if ((this.s != 0) || (this.t != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.s));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.t);
      }
    }
    if (this.c != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      String str2 = paramString + "    ";
      BackStackRecord.Op localOp = this.c;
      int i1 = 0;
      while (localOp != null)
      {
        String str1;
        int i2;
        switch (localOp.c)
        {
        default: 
          str1 = "cmd=" + localOp.c;
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str1);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(localOp.d);
          if (paramBoolean)
          {
            if ((localOp.e != 0) || (localOp.f != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localOp.e));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localOp.f));
            }
            if ((localOp.g != 0) || (localOp.h != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localOp.g));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localOp.h));
            }
          }
          if ((localOp.i == null) || (localOp.i.size() <= 0)) {
            break label807;
          }
          i2 = 0;
          label641:
          if (i2 >= localOp.i.size()) {
            break label807;
          }
          paramPrintWriter.print(str2);
          if (localOp.i.size() == 1) {
            paramPrintWriter.print("Removed: ");
          }
          break;
        }
        for (;;)
        {
          paramPrintWriter.println(localOp.i.get(i2));
          i2 += 1;
          break label641;
          str1 = "NULL";
          break;
          str1 = "ADD";
          break;
          str1 = "REPLACE";
          break;
          str1 = "REMOVE";
          break;
          str1 = "HIDE";
          break;
          str1 = "SHOW";
          break;
          str1 = "DETACH";
          break;
          str1 = "ATTACH";
          break;
          if (i2 == 0) {
            paramPrintWriter.println("Removed:");
          }
          paramPrintWriter.print(str2);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i2);
          paramPrintWriter.print(": ");
        }
        label807:
        localOp = localOp.a;
        i1 += 1;
      }
    }
  }
  
  public String b()
  {
    return this.n;
  }
  
  public void run()
  {
    if (FragmentManagerImpl.a) {
      Log.v("FragmentManager", "Run: " + this);
    }
    if ((this.l) && (this.p < 0)) {
      throw new IllegalStateException("addToBackStack() called after commit()");
    }
    a(1);
    Object localObject1;
    if (a)
    {
      localObject1 = new SparseArray();
      localObject2 = new SparseArray();
      b((SparseArray)localObject1, (SparseArray)localObject2);
    }
    for (Object localObject2 = a((SparseArray)localObject1, (SparseArray)localObject2, false);; localObject2 = null)
    {
      int i1;
      label113:
      int i2;
      label120:
      BackStackRecord.Op localOp;
      int i3;
      if (localObject2 != null)
      {
        i1 = 0;
        if (localObject2 == null) {
          break label232;
        }
        i2 = 0;
        localOp = this.c;
        if (localOp == null) {
          break label721;
        }
        if (localObject2 == null) {
          break label240;
        }
        i3 = 0;
        label138:
        if (localObject2 == null) {
          break label249;
        }
      }
      label232:
      label240:
      label249:
      for (int i4 = 0;; i4 = localOp.f) {
        switch (localOp.c)
        {
        default: 
          throw new IllegalArgumentException("Unknown cmd: " + localOp.c);
          i1 = this.k;
          break label113;
          i2 = this.j;
          break label120;
          i3 = localOp.e;
          break label138;
        }
      }
      localObject1 = localOp.d;
      ((Fragment)localObject1).G = i3;
      this.b.a((Fragment)localObject1, false);
      for (;;)
      {
        localOp = localOp.a;
        break;
        localObject1 = localOp.d;
        int i6 = ((Fragment)localObject1).x;
        Object localObject3 = localObject1;
        if (this.b.g != null)
        {
          int i5 = this.b.g.size() - 1;
          localObject3 = localObject1;
          if (i5 >= 0)
          {
            localObject3 = (Fragment)this.b.g.get(i5);
            if (FragmentManagerImpl.a) {
              Log.v("FragmentManager", "OP_REPLACE: adding=" + localObject1 + " old=" + localObject3);
            }
            if (((Fragment)localObject3).x == i6) {
              if (localObject3 == localObject1)
              {
                localObject1 = null;
                localOp.d = null;
              }
            }
            for (;;)
            {
              i5 -= 1;
              break;
              if (localOp.i == null) {
                localOp.i = new ArrayList();
              }
              localOp.i.add(localObject3);
              ((Fragment)localObject3).G = i4;
              if (this.l)
              {
                ((Fragment)localObject3).r += 1;
                if (FragmentManagerImpl.a) {
                  Log.v("FragmentManager", "Bump nesting of " + localObject3 + " to " + ((Fragment)localObject3).r);
                }
              }
              this.b.a((Fragment)localObject3, i2, i1);
            }
          }
        }
        if (localObject3 != null)
        {
          ((Fragment)localObject3).G = i3;
          this.b.a((Fragment)localObject3, false);
          continue;
          localObject1 = localOp.d;
          ((Fragment)localObject1).G = i4;
          this.b.a((Fragment)localObject1, i2, i1);
          continue;
          localObject1 = localOp.d;
          ((Fragment)localObject1).G = i4;
          this.b.b((Fragment)localObject1, i2, i1);
          continue;
          localObject1 = localOp.d;
          ((Fragment)localObject1).G = i3;
          this.b.c((Fragment)localObject1, i2, i1);
          continue;
          localObject1 = localOp.d;
          ((Fragment)localObject1).G = i4;
          this.b.d((Fragment)localObject1, i2, i1);
          continue;
          localObject1 = localOp.d;
          ((Fragment)localObject1).G = i3;
          this.b.e((Fragment)localObject1, i2, i1);
        }
      }
      label721:
      this.b.a(this.b.n, i2, i1, true);
      if (this.l) {
        this.b.b(this);
      }
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.p >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.p);
    }
    if (this.n != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.n);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
