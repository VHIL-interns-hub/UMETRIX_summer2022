package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new FragmentState.1();
  final String a;
  final int b;
  final boolean c;
  final int d;
  final int e;
  final String f;
  final boolean g;
  final boolean h;
  final Bundle i;
  Bundle j;
  Fragment k;
  
  public FragmentState(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      this.c = bool1;
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label110;
      }
      bool1 = true;
      label69:
      this.g = bool1;
      if (paramParcel.readInt() == 0) {
        break label115;
      }
    }
    label110:
    label115:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.h = bool1;
      this.i = paramParcel.readBundle();
      this.j = paramParcel.readBundle();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label69;
    }
  }
  
  public FragmentState(Fragment paramFragment)
  {
    this.a = paramFragment.getClass().getName();
    this.b = paramFragment.g;
    this.c = paramFragment.o;
    this.d = paramFragment.w;
    this.e = paramFragment.x;
    this.f = paramFragment.y;
    this.g = paramFragment.B;
    this.h = paramFragment.A;
    this.i = paramFragment.i;
  }
  
  public Fragment a(FragmentHostCallback paramFragmentHostCallback, Fragment paramFragment)
  {
    if (this.k != null) {
      return this.k;
    }
    Context localContext = paramFragmentHostCallback.g();
    if (this.i != null) {
      this.i.setClassLoader(localContext.getClassLoader());
    }
    this.k = Fragment.a(localContext, this.a, this.i);
    if (this.j != null)
    {
      this.j.setClassLoader(localContext.getClassLoader());
      this.k.e = this.j;
    }
    this.k.a(this.b, paramFragment);
    this.k.o = this.c;
    this.k.q = true;
    this.k.w = this.d;
    this.k.x = this.e;
    this.k.y = this.f;
    this.k.B = this.g;
    this.k.A = this.h;
    this.k.s = paramFragmentHostCallback.d;
    if (FragmentManagerImpl.a) {
      Log.v("FragmentManager", "Instantiated fragment " + this.k);
    }
    return this.k;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    if (this.c)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeString(this.f);
      if (!this.g) {
        break label106;
      }
      paramInt = 1;
      label65:
      paramParcel.writeInt(paramInt);
      if (!this.h) {
        break label111;
      }
    }
    label106:
    label111:
    for (paramInt = m;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.i);
      paramParcel.writeBundle(this.j);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label65;
    }
  }
}
