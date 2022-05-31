package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ByteArrayFetcher
  implements DataFetcher
{
  private final byte[] a;
  private final String b;
  
  public ByteArrayFetcher(byte[] paramArrayOfByte, String paramString)
  {
    this.a = paramArrayOfByte;
    this.b = paramString;
  }
  
  public void a() {}
  
  public InputStream b(Priority paramPriority)
  {
    return new ByteArrayInputStream(this.a);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void c() {}
}
