package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.DataFetcher;
import java.net.URL;

public class UrlLoader
  implements ModelLoader
{
  private final ModelLoader a;
  
  public UrlLoader(ModelLoader paramModelLoader)
  {
    this.a = paramModelLoader;
  }
  
  public DataFetcher a(URL paramURL, int paramInt1, int paramInt2)
  {
    return this.a.a(new GlideUrl(paramURL), paramInt1, paramInt2);
  }
}
