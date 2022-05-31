package com.bumptech.glide.load.model.file_descriptor;

import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.ModelLoader;

public class FileDescriptorFileLoader
  extends FileLoader
  implements FileDescriptorModelLoader
{
  public FileDescriptorFileLoader(ModelLoader paramModelLoader)
  {
    super(paramModelLoader);
  }
}
