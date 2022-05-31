package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.ModelLoader;

public class StreamFileLoader
  extends FileLoader
  implements StreamModelLoader
{
  public StreamFileLoader(ModelLoader paramModelLoader)
  {
    super(paramModelLoader);
  }
}
