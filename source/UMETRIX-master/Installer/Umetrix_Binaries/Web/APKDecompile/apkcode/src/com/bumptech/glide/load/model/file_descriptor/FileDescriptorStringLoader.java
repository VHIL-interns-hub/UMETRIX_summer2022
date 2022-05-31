package com.bumptech.glide.load.model.file_descriptor;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.StringLoader;

public class FileDescriptorStringLoader
  extends StringLoader
  implements FileDescriptorModelLoader
{
  public FileDescriptorStringLoader(ModelLoader paramModelLoader)
  {
    super(paramModelLoader);
  }
}
