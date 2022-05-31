package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new BackStackState.1();
  final int[] a;
  final int b;
  final int c;
  final String d;
  final int e;
  final int f;
  final CharSequence g;
  final int h;
  final CharSequence i;
  final ArrayList j;
  final ArrayList k;
  
  public BackStackState(Parcel paramParcel)
  {
    this.a = paramParcel.createIntArray();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.h = paramParcel.readInt();
    this.i = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.j = paramParcel.createStringArrayList();
    this.k = paramParcel.createStringArrayList();
  }
  
  public BackStackState(BackStackRecord paramBackStackRecord)
  {
    BackStackRecord.Op localOp = paramBackStackRecord.c;
    int n;
    for (int m = 0; localOp != null; m = n)
    {
      n = m;
      if (localOp.i != null) {
        n = m + localOp.i.size();
      }
      localOp = localOp.a;
    }
    this.a = new int[m + paramBackStackRecord.e * 7];
    if (!paramBackStackRecord.l) {
      throw new IllegalStateException("Not on back stack");
    }
    localOp = paramBackStackRecord.c;
    m = 0;
    if (localOp != null)
    {
      int[] arrayOfInt = this.a;
      n = m + 1;
      arrayOfInt[m] = localOp.c;
      arrayOfInt = this.a;
      int i1 = n + 1;
      if (localOp.d != null) {}
      for (m = localOp.d.g;; m = -1)
      {
        arrayOfInt[n] = m;
        arrayOfInt = this.a;
        m = i1 + 1;
        arrayOfInt[i1] = localOp.e;
        arrayOfInt = this.a;
        n = m + 1;
        arrayOfInt[m] = localOp.f;
        arrayOfInt = this.a;
        m = n + 1;
        arrayOfInt[n] = localOp.g;
        arrayOfInt = this.a;
        n = m + 1;
        arrayOfInt[m] = localOp.h;
        if (localOp.i == null) {
          break label314;
        }
        i1 = localOp.i.size();
        arrayOfInt = this.a;
        m = n + 1;
        arrayOfInt[n] = i1;
        n = 0;
        while (n < i1)
        {
          this.a[m] = ((Fragment)localOp.i.get(n)).g;
          n += 1;
          m += 1;
        }
      }
      for (;;)
      {
        localOp = localOp.a;
        break;
        label314:
        arrayOfInt = this.a;
        m = n + 1;
        arrayOfInt[n] = 0;
      }
    }
    this.b = paramBackStackRecord.j;
    this.c = paramBackStackRecord.k;
    this.d = paramBackStackRecord.n;
    this.e = paramBackStackRecord.p;
    this.f = paramBackStackRecord.q;
    this.g = paramBackStackRecord.r;
    this.h = paramBackStackRecord.s;
    this.i = paramBackStackRecord.t;
    this.j = paramBackStackRecord.u;
    this.k = paramBackStackRecord.v;
  }
  
  public BackStackRecord a(FragmentManagerImpl paramFragmentManagerImpl)
  {
    BackStackRecord localBackStackRecord = new BackStackRecord(paramFragmentManagerImpl);
    int i1 = 0;
    int m = 0;
    while (m < this.a.length)
    {
      BackStackRecord.Op localOp = new BackStackRecord.Op();
      Object localObject = this.a;
      int n = m + 1;
      localOp.c = localObject[m];
      if (FragmentManagerImpl.a) {
        Log.v("FragmentManager", "Instantiate " + localBackStackRecord + " op #" + i1 + " base fragment #" + this.a[n]);
      }
      localObject = this.a;
      m = n + 1;
      n = localObject[n];
      if (n >= 0) {}
      for (localOp.d = ((Fragment)paramFragmentManagerImpl.f.get(n));; localOp.d = null)
      {
        localObject = this.a;
        n = m + 1;
        localOp.e = localObject[m];
        localObject = this.a;
        m = n + 1;
        localOp.f = localObject[n];
        localObject = this.a;
        n = m + 1;
        localOp.g = localObject[m];
        localObject = this.a;
        m = n + 1;
        localOp.h = localObject[n];
        localObject = this.a;
        n = m + 1;
        int i3 = localObject[m];
        m = n;
        if (i3 <= 0) {
          break;
        }
        localOp.i = new ArrayList(i3);
        int i2 = 0;
        for (;;)
        {
          m = n;
          if (i2 >= i3) {
            break;
          }
          if (FragmentManagerImpl.a) {
            Log.v("FragmentManager", "Instantiate " + localBackStackRecord + " set remove fragment #" + this.a[n]);
          }
          localObject = (Fragment)paramFragmentManagerImpl.f.get(this.a[n]);
          localOp.i.add(localObject);
          i2 += 1;
          n += 1;
        }
      }
      localBackStackRecord.a(localOp);
      i1 += 1;
    }
    localBackStackRecord.j = this.b;
    localBackStackRecord.k = this.c;
    localBackStackRecord.n = this.d;
    localBackStackRecord.p = this.e;
    localBackStackRecord.l = true;
    localBackStackRecord.q = this.f;
    localBackStackRecord.r = this.g;
    localBackStackRecord.s = this.h;
    localBackStackRecord.t = this.i;
    localBackStackRecord.u = this.j;
    localBackStackRecord.v = this.k;
    localBackStackRecord.a(1);
    return localBackStackRecord;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    TextUtils.writeToParcel(this.g, paramParcel, 0);
    paramParcel.writeInt(this.h);
    TextUtils.writeToParcel(this.i, paramParcel, 0);
    paramParcel.writeStringList(this.j);
    paramParcel.writeStringList(this.k);
  }
}
