package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;

public class FileDecoder
  implements ResourceDecoder
{
  public FileDecoder() {}
  
  public Resource a(File paramFile, int paramInt1, int paramInt2)
  {
    return new FileResource(paramFile);
  }
  
  public String a()
  {
    return "";
  }
}
