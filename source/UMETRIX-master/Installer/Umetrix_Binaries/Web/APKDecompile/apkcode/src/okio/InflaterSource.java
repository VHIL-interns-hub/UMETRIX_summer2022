package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource
  implements Source
{
  private final BufferedSource a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  InflaterSource(BufferedSource paramBufferedSource, Inflater paramInflater)
  {
    if (paramBufferedSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramInflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = paramBufferedSource;
    this.b = paramInflater;
  }
  
  public InflaterSource(Source paramSource, Inflater paramInflater)
  {
    this(Okio.a(paramSource), paramInflater);
  }
  
  private void c()
  {
    if (this.c == 0) {
      return;
    }
    int i = this.c - this.b.getRemaining();
    this.c -= i;
    this.a.g(i);
  }
  
  public long a(Buffer paramBuffer, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.d) {
      throw new IllegalStateException("closed");
    }
    if (paramLong == 0L) {
      return 0L;
    }
    for (;;)
    {
      boolean bool = b();
      try
      {
        Segment localSegment = paramBuffer.e(1);
        int i = this.b.inflate(localSegment.a, localSegment.c, 2048 - localSegment.c);
        if (i > 0)
        {
          localSegment.c += i;
          paramBuffer.b += i;
          return i;
        }
        if ((this.b.finished()) || (this.b.needsDictionary()))
        {
          c();
          if (localSegment.b == localSegment.c)
          {
            paramBuffer.a = localSegment.a();
            SegmentPool.a(localSegment);
          }
        }
        else
        {
          if (!bool) {
            continue;
          }
          throw new EOFException("source exhausted prematurely");
        }
      }
      catch (DataFormatException paramBuffer)
      {
        throw new IOException(paramBuffer);
      }
    }
    return -1L;
  }
  
  public Timeout a()
  {
    return this.a.a();
  }
  
  public boolean b()
  {
    if (!this.b.needsInput()) {
      return false;
    }
    c();
    if (this.b.getRemaining() != 0) {
      throw new IllegalStateException("?");
    }
    if (this.a.g()) {
      return true;
    }
    Segment localSegment = this.a.c().a;
    this.c = (localSegment.c - localSegment.b);
    this.b.setInput(localSegment.a, localSegment.b, this.c);
    return false;
  }
  
  public void close()
  {
    if (this.d) {
      return;
    }
    this.b.end();
    this.d = true;
    this.a.close();
  }
}
