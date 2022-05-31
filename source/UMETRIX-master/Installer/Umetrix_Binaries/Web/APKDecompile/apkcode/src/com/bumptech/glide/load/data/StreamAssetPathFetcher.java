package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.InputStream;

public class StreamAssetPathFetcher
  extends AssetPathFetcher
{
  public StreamAssetPathFetcher(AssetManager paramAssetManager, String paramString)
  {
    super(paramAssetManager, paramString);
  }
  
  protected void a(InputStream paramInputStream)
  {
    paramInputStream.close();
  }
  
  protected InputStream b(AssetManager paramAssetManager, String paramString)
  {
    return paramAssetManager.open(paramString);
  }
}
