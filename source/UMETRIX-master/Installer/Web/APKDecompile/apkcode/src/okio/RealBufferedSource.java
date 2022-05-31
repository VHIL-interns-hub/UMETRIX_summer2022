package okio;

import java.io.EOFException;
import java.io.InputStream;

final class RealBufferedSource
  implements BufferedSource
{
  public final Buffer a;
  public final Source b;
  private boolean c;
  
  public RealBufferedSource(Source paramSource)
  {
    this(paramSource, new Buffer());
  }
  
  public RealBufferedSource(Source paramSource, Buffer paramBuffer)
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    this.a = paramBuffer;
    this.b = paramSource;
  }
  
  public long a(byte paramByte)
  {
    return a(paramByte, 0L);
  }
  
  public long a(byte paramByte, long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    long l;
    do
    {
      l = paramLong;
      if (paramLong < this.a.b) {
        break;
      }
    } while (this.b.a(this.a, 2048L) != -1L);
    return -1L;
    do
    {
      paramLong = this.a.a(paramByte, l);
      if (paramLong != -1L) {
        break;
      }
      l = this.a.b;
    } while (this.b.a(this.a, 2048L) != -1L);
    return -1L;
    return paramLong;
  }
  
  public long a(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if ((this.a.b == 0L) && (this.b.a(this.a, 2048L) == -1L)) {
      return -1L;
    }
    paramLong = Math.min(paramLong, this.a.b);
    return this.a.a(paramBuffer, paramLong);
  }
  
  public Timeout a()
  {
    return this.b.a();
  }
  
  public void a(long paramLong)
  {
    if (!b(paramLong)) {
      throw new EOFException();
    }
  }
  
  public boolean b(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    while (this.a.b < paramLong) {
      if (this.b.a(this.a, 2048L) == -1L) {
        return false;
      }
    }
    return true;
  }
  
  public Buffer c()
  {
    return this.a;
  }
  
  public ByteString c(long paramLong)
  {
    a(paramLong);
    return this.a.c(paramLong);
  }
  
  public void close()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.b.close();
    this.a.t();
  }
  
  public byte[] f(long paramLong)
  {
    a(paramLong);
    return this.a.f(paramLong);
  }
  
  public void g(long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    do
    {
      long l = Math.min(paramLong, this.a.b());
      this.a.g(l);
      paramLong -= l;
      if (paramLong <= 0L) {
        break;
      }
    } while ((this.a.b != 0L) || (this.b.a(this.a, 2048L) != -1L));
    throw new EOFException();
  }
  
  public boolean g()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    return (this.a.g()) && (this.b.a(this.a, 2048L) == -1L);
  }
  
  public InputStream h()
  {
    return new RealBufferedSource.1(this);
  }
  
  public byte j()
  {
    a(1L);
    return this.a.j();
  }
  
  public short k()
  {
    a(2L);
    return this.a.k();
  }
  
  public int l()
  {
    a(4L);
    return this.a.l();
  }
  
  public short m()
  {
    a(2L);
    return this.a.m();
  }
  
  public int n()
  {
    a(4L);
    return this.a.n();
  }
  
  public long o()
  {
    a(1L);
    int i = 0;
    while (b(i + 1))
    {
      byte b1 = this.a.b(i);
      if (((b1 < 48) || (b1 > 57)) && ((b1 < 97) || (b1 > 102)) && ((b1 < 65) || (b1 > 70)))
      {
        if (i != 0) {
          break;
        }
        throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[] { Byte.valueOf(b1) }));
      }
      i += 1;
    }
    return this.a.o();
  }
  
  public String r()
  {
    long l = a((byte)10);
    if (l == -1L)
    {
      Buffer localBuffer = new Buffer();
      this.a.a(localBuffer, 0L, Math.min(32L, this.a.b()));
      throw new EOFException("\\n not found: size=" + this.a.b() + " content=" + localBuffer.p().d() + "...");
    }
    return this.a.e(l);
  }
  
  public String toString()
  {
    return "buffer(" + this.b + ")";
  }
}
