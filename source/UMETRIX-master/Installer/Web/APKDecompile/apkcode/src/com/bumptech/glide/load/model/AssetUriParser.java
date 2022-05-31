package com.bumptech.glide.load.model;

import android.net.Uri;
import java.util.List;

final class AssetUriParser
{
  private static final int a = "file:///android_asset/".length();
  
  public static boolean a(Uri paramUri)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ("file".equals(paramUri.getScheme()))
    {
      bool1 = bool2;
      if (!paramUri.getPathSegments().isEmpty())
      {
        bool1 = bool2;
        if ("android_asset".equals(paramUri.getPathSegments().get(0))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String b(Uri paramUri)
  {
    return paramUri.toString().substring(a);
  }
}
