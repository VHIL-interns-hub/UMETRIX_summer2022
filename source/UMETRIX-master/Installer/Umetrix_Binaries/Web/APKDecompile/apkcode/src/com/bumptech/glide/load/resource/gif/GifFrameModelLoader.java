package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;

class GifFrameModelLoader
  implements ModelLoader
{
  GifFrameModelLoader() {}
  
  public DataFetcher a(GifDecoder paramGifDecoder, int paramInt1, int paramInt2)
  {
    return new GifFrameModelLoader.GifFrameDataFetcher(paramGifDecoder);
  }
}
