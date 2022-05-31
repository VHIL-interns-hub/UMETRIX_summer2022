package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;

public class StringLoader
  implements ModelLoader
{
  private final ModelLoader a;
  
  public StringLoader(ModelLoader paramModelLoader)
  {
    this.a = paramModelLoader;
  }
  
  private static Uri a(String paramString)
  {
    return Uri.fromFile(new File(paramString));
  }
  
  public DataFetcher a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject;
    if (paramString.startsWith("/")) {
      localObject = a(paramString);
    }
    for (;;)
    {
      return this.a.a(localObject, paramInt1, paramInt2);
      Uri localUri = Uri.parse(paramString);
      localObject = localUri;
      if (localUri.getScheme() == null) {
        localObject = a(paramString);
      }
    }
  }
}
