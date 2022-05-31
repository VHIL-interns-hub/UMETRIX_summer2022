package net.fred.feedex.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LongSparseArray;
import android.util.TypedValue;
import net.fred.feedex.MainApplication;

public class UiUtils
{
  private static final LongSparseArray a = new LongSparseArray();
  
  public static int a(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, MainApplication.a().getResources().getDisplayMetrics());
  }
  
  public static Bitmap a(long paramLong, Cursor paramCursor, int paramInt)
  {
    Bitmap localBitmap2 = (Bitmap)a.a(paramLong);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      paramCursor = paramCursor.getBlob(paramInt);
      localBitmap1 = localBitmap2;
      if (paramCursor != null)
      {
        localBitmap1 = localBitmap2;
        if (paramCursor.length > 0)
        {
          localBitmap1 = a(paramCursor, 18);
          a.b(paramLong, localBitmap1);
        }
      }
    }
    return localBitmap1;
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.getWidth() != 0) && (paramArrayOfByte.getHeight() != 0))
      {
        paramInt = a(paramInt);
        if (paramArrayOfByte.getHeight() == paramInt) {
          return paramArrayOfByte;
        }
        Bitmap localBitmap = Bitmap.createScaledBitmap(paramArrayOfByte, paramInt, paramInt, false);
        paramArrayOfByte.recycle();
        return localBitmap;
      }
    }
    return null;
    return paramArrayOfByte;
  }
  
  public static void a(Activity paramActivity)
  {
    if (!PrefUtils.a("lighttheme", false)) {
      paramActivity.setTheme(2131493107);
    }
  }
}
