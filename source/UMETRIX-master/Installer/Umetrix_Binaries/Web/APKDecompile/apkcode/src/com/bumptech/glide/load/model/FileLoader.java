package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;

public class FileLoader
  implements ModelLoader
{
  private final ModelLoader a;
  
  public FileLoader(ModelLoader paramModelLoader)
  {
    this.a = paramModelLoader;
  }
  
  public DataFetcher a(File paramFile, int paramInt1, int paramInt2)
  {
    return this.a.a(Uri.fromFile(paramFile), paramInt1, paramInt2);
  }
}
