package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.DataFetcher;

public class ImageVideoModelLoader
  implements ModelLoader
{
  private final ModelLoader a;
  private final ModelLoader b;
  
  public ImageVideoModelLoader(ModelLoader paramModelLoader1, ModelLoader paramModelLoader2)
  {
    if ((paramModelLoader1 == null) && (paramModelLoader2 == null)) {
      throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
    }
    this.a = paramModelLoader1;
    this.b = paramModelLoader2;
  }
  
  public DataFetcher a(Object paramObject, int paramInt1, int paramInt2)
  {
    ImageVideoModelLoader.ImageVideoFetcher localImageVideoFetcher = null;
    if (this.a != null) {}
    for (DataFetcher localDataFetcher = this.a.a(paramObject, paramInt1, paramInt2);; localDataFetcher = null)
    {
      if (this.b != null) {}
      for (paramObject = this.b.a(paramObject, paramInt1, paramInt2);; paramObject = null)
      {
        if ((localDataFetcher != null) || (paramObject != null)) {
          localImageVideoFetcher = new ImageVideoModelLoader.ImageVideoFetcher(localDataFetcher, paramObject);
        }
        return localImageVideoFetcher;
      }
    }
  }
}
