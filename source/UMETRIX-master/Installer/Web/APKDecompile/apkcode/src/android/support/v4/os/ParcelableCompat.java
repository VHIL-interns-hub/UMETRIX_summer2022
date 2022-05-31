package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public final class ParcelableCompat
{
  public static Parcelable.Creator a(ParcelableCompatCreatorCallbacks paramParcelableCompatCreatorCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 13) {
      return ParcelableCompatCreatorHoneycombMR2Stub.a(paramParcelableCompatCreatorCallbacks);
    }
    return new ParcelableCompat.CompatCreator(paramParcelableCompatCreatorCallbacks);
  }
}
