package android.support.v4.os;

import android.os.Parcel;

public abstract interface ParcelableCompatCreatorCallbacks
{
  public abstract Object a(Parcel paramParcel, ClassLoader paramClassLoader);
  
  public abstract Object[] a(int paramInt);
}
