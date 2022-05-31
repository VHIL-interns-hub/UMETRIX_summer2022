package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;
import okio.InflaterSource;
import okio.Okio;

class NameValueBlockReader
{
  private final InflaterSource a = new InflaterSource(new NameValueBlockReader.1(this, paramBufferedSource), new NameValueBlockReader.2(this));
  private int b;
  private final BufferedSource c = Okio.a(this.a);
  
  public NameValueBlockReader(BufferedSource paramBufferedSource) {}
  
  private ByteString b()
  {
    int i = this.c.l();
    return this.c.c(i);
  }
  
  private void c()
  {
    if (this.b > 0)
    {
      this.a.b();
      if (this.b != 0) {
        throw new IOException("compressedLimit > 0: " + this.b);
      }
    }
  }
  
  public List a(int paramInt)
  {
    this.b += paramInt;
    int i = this.c.l();
    if (i < 0) {
      throw new IOException("numberOfPairs < 0: " + i);
    }
    if (i > 1024) {
      throw new IOException("numberOfPairs > 1024: " + i);
    }
    ArrayList localArrayList = new ArrayList(i);
    paramInt = 0;
    while (paramInt < i)
    {
      ByteString localByteString1 = b().e();
      ByteString localByteString2 = b();
      if (localByteString1.f() == 0) {
        throw new IOException("name.size == 0");
      }
      localArrayList.add(new Header(localByteString1, localByteString2));
      paramInt += 1;
    }
    c();
    return localArrayList;
  }
  
  public void a()
  {
    this.c.close();
  }
}
