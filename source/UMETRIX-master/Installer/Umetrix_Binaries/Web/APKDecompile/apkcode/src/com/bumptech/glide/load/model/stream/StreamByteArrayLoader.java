package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.data.ByteArrayFetcher;
import com.bumptech.glide.load.data.DataFetcher;

public class StreamByteArrayLoader
  implements StreamModelLoader
{
  private final String a;
  
  public StreamByteArrayLoader()
  {
    this("");
  }
  
  @Deprecated
  public StreamByteArrayLoader(String paramString)
  {
    this.a = paramString;
  }
  
  public DataFetcher a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ByteArrayFetcher(paramArrayOfByte, this.a);
  }
}
