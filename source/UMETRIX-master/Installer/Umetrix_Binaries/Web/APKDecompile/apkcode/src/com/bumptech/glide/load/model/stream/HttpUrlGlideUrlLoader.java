package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;

public class HttpUrlGlideUrlLoader
  implements ModelLoader
{
  private final ModelCache a;
  
  public HttpUrlGlideUrlLoader()
  {
    this(null);
  }
  
  public HttpUrlGlideUrlLoader(ModelCache paramModelCache)
  {
    this.a = paramModelCache;
  }
  
  public DataFetcher a(GlideUrl paramGlideUrl, int paramInt1, int paramInt2)
  {
    GlideUrl localGlideUrl = paramGlideUrl;
    if (this.a != null)
    {
      localGlideUrl = (GlideUrl)this.a.a(paramGlideUrl, 0, 0);
      if (localGlideUrl != null) {
        break label54;
      }
      this.a.a(paramGlideUrl, 0, 0, paramGlideUrl);
      localGlideUrl = paramGlideUrl;
    }
    label54:
    for (;;)
    {
      return new HttpUrlFetcher(localGlideUrl);
    }
  }
}
