package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.UriLoader;

public class StreamUriLoader
  extends UriLoader
  implements StreamModelLoader
{
  public StreamUriLoader(Context paramContext, ModelLoader paramModelLoader)
  {
    super(paramContext, paramModelLoader);
  }
  
  protected DataFetcher a(Context paramContext, Uri paramUri)
  {
    return new StreamLocalUriFetcher(paramContext, paramUri);
  }
  
  protected DataFetcher a(Context paramContext, String paramString)
  {
    return new StreamAssetPathFetcher(paramContext.getApplicationContext().getAssets(), paramString);
  }
}
