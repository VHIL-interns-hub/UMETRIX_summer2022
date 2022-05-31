package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.ResourceDecoder;

public class FileToStreamDecoder
  implements ResourceDecoder
{
  private static final FileToStreamDecoder.FileOpener a = new FileToStreamDecoder.FileOpener();
  private ResourceDecoder b;
  private final FileToStreamDecoder.FileOpener c;
  
  public FileToStreamDecoder(ResourceDecoder paramResourceDecoder)
  {
    this(paramResourceDecoder, a);
  }
  
  FileToStreamDecoder(ResourceDecoder paramResourceDecoder, FileToStreamDecoder.FileOpener paramFileOpener)
  {
    this.b = paramResourceDecoder;
    this.c = paramFileOpener;
  }
  
  /* Error */
  public com.bumptech.glide.load.engine.Resource a(java.io.File paramFile, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 30	com/bumptech/glide/load/resource/file/FileToStreamDecoder:c	Lcom/bumptech/glide/load/resource/file/FileToStreamDecoder$FileOpener;
    //   7: aload_1
    //   8: invokevirtual 36	com/bumptech/glide/load/resource/file/FileToStreamDecoder$FileOpener:a	(Ljava/io/File;)Ljava/io/InputStream;
    //   11: astore_1
    //   12: aload_1
    //   13: astore 4
    //   15: aload_0
    //   16: getfield 28	com/bumptech/glide/load/resource/file/FileToStreamDecoder:b	Lcom/bumptech/glide/load/ResourceDecoder;
    //   19: aload_1
    //   20: iload_2
    //   21: iload_3
    //   22: invokeinterface 39 4 0
    //   27: astore 5
    //   29: aload_1
    //   30: ifnull +7 -> 37
    //   33: aload_1
    //   34: invokevirtual 44	java/io/InputStream:close	()V
    //   37: aload 5
    //   39: areturn
    //   40: astore_1
    //   41: aload 4
    //   43: ifnull +8 -> 51
    //   46: aload 4
    //   48: invokevirtual 44	java/io/InputStream:close	()V
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: aload 5
    //   56: areturn
    //   57: astore 4
    //   59: goto -8 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	FileToStreamDecoder
    //   0	62	1	paramFile	java.io.File
    //   0	62	2	paramInt1	int
    //   0	62	3	paramInt2	int
    //   1	46	4	localFile	java.io.File
    //   57	1	4	localIOException	java.io.IOException
    //   27	28	5	localResource	com.bumptech.glide.load.engine.Resource
    // Exception table:
    //   from	to	target	type
    //   3	12	40	finally
    //   15	29	40	finally
    //   33	37	53	java/io/IOException
    //   46	51	57	java/io/IOException
  }
  
  public String a()
  {
    return "";
  }
}
