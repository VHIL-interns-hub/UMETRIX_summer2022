package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ResourceLoader;

public class FileDescriptorResourceLoader
  extends ResourceLoader
  implements FileDescriptorModelLoader
{
  public FileDescriptorResourceLoader(Context paramContext, ModelLoader paramModelLoader)
  {
    super(paramContext, paramModelLoader);
  }
}
