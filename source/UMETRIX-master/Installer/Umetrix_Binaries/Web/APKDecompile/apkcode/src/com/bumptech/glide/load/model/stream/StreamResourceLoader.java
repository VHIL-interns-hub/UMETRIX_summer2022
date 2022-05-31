package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ResourceLoader;

public class StreamResourceLoader
  extends ResourceLoader
  implements StreamModelLoader
{
  public StreamResourceLoader(Context paramContext, ModelLoader paramModelLoader)
  {
    super(paramContext, paramModelLoader);
  }
}
