package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.UriLoader;

public class FileDescriptorUriLoader
  extends UriLoader
  implements FileDescriptorModelLoader
{
  public FileDescriptorUriLoader(Context paramContext, ModelLoader paramModelLoader)
  {
    super(paramContext, paramModelLoader);
  }
  
  protected DataFetcher a(Context paramContext, Uri paramUri)
  {
    return new FileDescriptorLocalUriFetcher(paramContext, paramUri);
  }
  
  protected DataFetcher a(Context paramContext, String paramString)
  {
    return new FileDescriptorAssetPathFetcher(paramContext.getApplicationContext().getAssets(), paramString);
  }
}
