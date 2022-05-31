package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.data.DataFetcher;

public class ResourceLoader
  implements ModelLoader
{
  private final ModelLoader a;
  private final Resources b;
  
  public ResourceLoader(Context paramContext, ModelLoader paramModelLoader)
  {
    this(paramContext.getResources(), paramModelLoader);
  }
  
  public ResourceLoader(Resources paramResources, ModelLoader paramModelLoader)
  {
    this.b = paramResources;
    this.a = paramModelLoader;
  }
  
  public DataFetcher a(Integer paramInteger, int paramInt1, int paramInt2)
  {
    DataFetcher localDataFetcher = null;
    try
    {
      Uri localUri = Uri.parse("android.resource://" + this.b.getResourcePackageName(paramInteger.intValue()) + '/' + this.b.getResourceTypeName(paramInteger.intValue()) + '/' + this.b.getResourceEntryName(paramInteger.intValue()));
      paramInteger = localUri;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        if (Log.isLoggable("ResourceLoader", 5)) {
          Log.w("ResourceLoader", "Received invalid resource id: " + paramInteger, localNotFoundException);
        }
        paramInteger = null;
      }
    }
    if (paramInteger != null) {
      localDataFetcher = this.a.a(paramInteger, paramInt1, paramInt2);
    }
    return localDataFetcher;
  }
}
