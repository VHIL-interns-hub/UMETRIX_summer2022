package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Buffer
  implements Cloneable, BufferedSink, BufferedSource
{
  private static final byte[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  Segment a;
  long b;
  
  public Buffer() {}
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Util.a(paramArrayOfByte.length, paramInt1, paramInt2);
    Segment localSegment = this.a;
    if (localSegment == null) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      paramInt2 = Math.min(paramInt2, localSegment.c - localSegment.b);
      System.arraycopy(localSegment.a, localSegment.b, paramArrayOfByte, paramInt1, paramInt2);
      localSegment.b += paramInt2;
      this.b -= paramInt2;
      paramInt1 = paramInt2;
    } while (localSegment.b != localSegment.c);
    this.a = localSegment.a();
    SegmentPool.a(localSegment);
    return paramInt2;
  }
  
  public long a(byte paramByte)
  {
    return a(paramByte, 0L);
  }
  
  public long a(byte paramByte, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("fromIndex < 0");
    }
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return -1L;
    }
    long l = 0L;
    int j = ((Segment)localObject1).c - ((Segment)localObject1).b;
    if (paramLong >= j) {}
    for (paramLong -= j;; paramLong = 0L)
    {
      l += j;
      Object localObject2 = ((Segment)localObject1).f;
      localObject1 = localObject2;
      if (localObject2 != this.a) {
        break;
      }
      return -1L;
      localObject2 = ((Segment)localObject1).a;
      int i = (int)(((Segment)localObject1).b + paramLong);
      int k = ((Segment)localObject1).c;
      while (i < k)
      {
        if (localObject2[i] == paramByte) {
          return l + i - ((Segment)localObject1).b;
        }
        i += 1;
      }
    }
  }
  
  public long a(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.b == 0L) {
      return -1L;
    }
    long l = paramLong;
    if (paramLong > this.b) {
      l = this.b;
    }
    paramBuffer.a_(this, l);
    return l;
  }
  
  public long a(Source paramSource)
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramSource.a(this, 2048L);
      if (l2 == -1L) {
        break;
      }
    }
    return l1;
  }
  
  public String a(long paramLong, Charset paramCharset)
  {
    Util.a(this.b, 0L, paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    if (paramLong == 0L) {
      paramCharset = "";
    }
    Segment localSegment;
    String str;
    do
    {
      return paramCharset;
      localSegment = this.a;
      if (localSegment.b + paramLong > localSegment.c) {
        return new String(f(paramLong), paramCharset);
      }
      str = new String(localSegment.a, localSegment.b, (int)paramLong, paramCharset);
      localSegment.b = ((int)(localSegment.b + paramLong));
      this.b -= paramLong;
      paramCharset = str;
    } while (localSegment.b != localSegment.c);
    this.a = localSegment.a();
    SegmentPool.a(localSegment);
    return str;
  }
  
  public Buffer a(int paramInt)
  {
    if (paramInt < 128)
    {
      b(paramInt);
      return this;
    }
    if (paramInt < 2048)
    {
      b(paramInt >> 6 | 0xC0);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt < 65536)
    {
      if ((paramInt >= 55296) && (paramInt <= 57343)) {
        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
      }
      b(paramInt >> 12 | 0xE0);
      b(paramInt >> 6 & 0x3F | 0x80);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt <= 1114111)
    {
      b(paramInt >> 18 | 0xF0);
      b(paramInt >> 12 & 0x3F | 0x80);
      b(paramInt >> 6 & 0x3F | 0x80);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
  }
  
  public Buffer a(String paramString)
  {
    return a(paramString, 0, paramString.length());
  }
  
  public Buffer a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalAccessError("beginIndex < 0: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    }
    int i;
    label136:
    int j;
    label168:
    byte[] arrayOfByte;
    int k;
    if (paramInt2 > paramString.length())
    {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
      i = 0;
      if ((j > 56319) || (i < 56320) || (i > 57343))
      {
        b(63);
        paramInt1 += 1;
      }
    }
    else
    {
      if (paramInt1 >= paramInt2) {
        return this;
      }
      j = paramString.charAt(paramInt1);
      if (j < 128)
      {
        Segment localSegment = e(1);
        arrayOfByte = localSegment.a;
        k = localSegment.c - paramInt1;
        int m = Math.min(paramInt2, 2048 - k);
        i = paramInt1 + 1;
        arrayOfByte[(k + paramInt1)] = ((byte)j);
        paramInt1 = i;
        label241:
        if (paramInt1 < m)
        {
          i = paramString.charAt(paramInt1);
          if (i < 128) {}
        }
        else
        {
          i = paramInt1 + k - localSegment.c;
          localSegment.c += i;
          this.b += i;
        }
      }
    }
    for (;;)
    {
      break label168;
      arrayOfByte[(paramInt1 + k)] = ((byte)i);
      paramInt1 += 1;
      break label241;
      if (j < 2048)
      {
        b(j >> 6 | 0xC0);
        b(j & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else if ((j < 55296) || (j > 57343))
      {
        b(j >> 12 | 0xE0);
        b(j >> 6 & 0x3F | 0x80);
        b(j & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else
      {
        if (paramInt1 + 1 >= paramInt2) {
          break;
        }
        i = paramString.charAt(paramInt1 + 1);
        break label136;
        i = (i & 0xFFFF23FF | (j & 0xFFFF27FF) << 10) + 65536;
        b(i >> 18 | 0xF0);
        b(i >> 12 & 0x3F | 0x80);
        b(i >> 6 & 0x3F | 0x80);
        b(i & 0x3F | 0x80);
        paramInt1 += 2;
      }
    }
    return this;
  }
  
  public Buffer a(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.a(this.b, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    paramBuffer.b += paramLong2;
    Segment localSegment2;
    long l1;
    long l2;
    for (Segment localSegment1 = this.a;; localSegment1 = localSegment1.f)
    {
      localSegment2 = localSegment1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < localSegment1.c - localSegment1.b) {
        break;
      }
      paramLong1 -= localSegment1.c - localSegment1.b;
    }
    label103:
    if (l2 > 0L)
    {
      localSegment1 = new Segment(localSegment2);
      localSegment1.b = ((int)(localSegment1.b + l1));
      localSegment1.c = Math.min(localSegment1.b + (int)l2, localSegment1.c);
      if (paramBuffer.a != null) {
        break label215;
      }
      localSegment1.g = localSegment1;
      localSegment1.f = localSegment1;
      paramBuffer.a = localSegment1;
    }
    for (;;)
    {
      l2 -= localSegment1.c - localSegment1.b;
      localSegment2 = localSegment2.f;
      l1 = 0L;
      break label103;
      break;
      label215:
      paramBuffer.a.g.a(localSegment1);
    }
  }
  
  public Buffer a(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new IllegalArgumentException("byteString == null");
    }
    paramByteString.a(this);
    return this;
  }
  
  public Timeout a()
  {
    return Timeout.b;
  }
  
  public void a(long paramLong)
  {
    if (this.b < paramLong) {
      throw new EOFException();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = a(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j == -1) {
        throw new EOFException();
      }
      i += j;
    }
  }
  
  public void a_(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramBuffer == this) {
      throw new IllegalArgumentException("source == this");
    }
    Util.a(paramBuffer.b, 0L, paramLong);
    if (paramLong > 0L)
    {
      if (paramLong >= paramBuffer.a.c - paramBuffer.a.b) {
        break label189;
      }
      if (this.a == null) {
        break label160;
      }
      localSegment1 = this.a.g;
      if ((localSegment1 == null) || (!localSegment1.e)) {
        break label176;
      }
      l = localSegment1.c;
      if (!localSegment1.d) {
        break label166;
      }
    }
    label160:
    label166:
    for (int i = 0;; i = localSegment1.b)
    {
      if (l + paramLong - i > 2048L) {
        break label176;
      }
      paramBuffer.a.a(localSegment1, (int)paramLong);
      paramBuffer.b -= paramLong;
      this.b += paramLong;
      return;
      localSegment1 = null;
      break;
    }
    label176:
    paramBuffer.a = paramBuffer.a.a((int)paramLong);
    label189:
    Segment localSegment1 = paramBuffer.a;
    long l = localSegment1.c - localSegment1.b;
    paramBuffer.a = localSegment1.a();
    if (this.a == null)
    {
      this.a = localSegment1;
      localSegment1 = this.a;
      Segment localSegment2 = this.a;
      Segment localSegment3 = this.a;
      localSegment2.g = localSegment3;
      localSegment1.f = localSegment3;
    }
    for (;;)
    {
      paramBuffer.b -= l;
      this.b += l;
      paramLong -= l;
      break;
      this.a.g.a(localSegment1).b();
    }
  }
  
  public byte b(long paramLong)
  {
    Util.a(this.b, paramLong, 1L);
    for (Segment localSegment = this.a;; localSegment = localSegment.f)
    {
      int i = localSegment.c - localSegment.b;
      if (paramLong < i) {
        return localSegment.a[(localSegment.b + (int)paramLong)];
      }
      paramLong -= i;
    }
  }
  
  public long b()
  {
    return this.b;
  }
  
  public Buffer b(int paramInt)
  {
    Segment localSegment = e(1);
    byte[] arrayOfByte = localSegment.a;
    int i = localSegment.c;
    localSegment.c = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.b += 1L;
    return this;
  }
  
  public Buffer b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public Buffer b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    Util.a(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      Segment localSegment = e(1);
      int j = Math.min(i - paramInt1, 2048 - localSegment.c);
      System.arraycopy(paramArrayOfByte, paramInt1, localSegment.a, localSegment.c, j);
      paramInt1 += j;
      localSegment.c = (j + localSegment.c);
    }
    this.b += paramInt2;
    return this;
  }
  
  public Buffer c()
  {
    return this;
  }
  
  public Buffer c(int paramInt)
  {
    Segment localSegment = e(2);
    byte[] arrayOfByte = localSegment.a;
    int i = localSegment.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localSegment.c = (j + 1);
    this.b += 2L;
    return this;
  }
  
  public ByteString c(long paramLong)
  {
    return new ByteString(f(paramLong));
  }
  
  public void close() {}
  
  public OutputStream d()
  {
    return new Buffer.1(this);
  }
  
  public String d(long paramLong)
  {
    return a(paramLong, Util.a);
  }
  
  public Buffer d(int paramInt)
  {
    Segment localSegment = e(4);
    byte[] arrayOfByte = localSegment.a;
    int j = localSegment.c;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localSegment.c = (i + 1);
    this.b += 4L;
    return this;
  }
  
  String e(long paramLong)
  {
    if ((paramLong > 0L) && (b(paramLong - 1L) == 13))
    {
      str = d(paramLong - 1L);
      g(2L);
      return str;
    }
    String str = d(paramLong);
    g(1L);
    return str;
  }
  
  public Buffer e()
  {
    return this;
  }
  
  Segment e(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 2048)) {
      throw new IllegalArgumentException();
    }
    Segment localSegment2;
    Segment localSegment1;
    if (this.a == null)
    {
      this.a = SegmentPool.a();
      localSegment2 = this.a;
      Segment localSegment3 = this.a;
      localSegment1 = this.a;
      localSegment3.g = localSegment1;
      localSegment2.f = localSegment1;
    }
    do
    {
      return localSegment1;
      localSegment2 = this.a.g;
      if (localSegment2.c + paramInt > 2048) {
        break;
      }
      localSegment1 = localSegment2;
    } while (localSegment2.e);
    return localSegment2.a(SegmentPool.a());
  }
  
  public boolean equals(Object paramObject)
  {
    long l1 = 0L;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Buffer)) {
      return false;
    }
    paramObject = (Buffer)paramObject;
    if (this.b != paramObject.b) {
      return false;
    }
    if (this.b == 0L) {
      return true;
    }
    Object localObject2 = this.a;
    paramObject = paramObject.a;
    int j = ((Segment)localObject2).b;
    int i = paramObject.b;
    while (l1 < this.b)
    {
      long l2 = Math.min(((Segment)localObject2).c - j, paramObject.c - i);
      int k = 0;
      while (k < l2)
      {
        if (localObject2.a[j] != paramObject.a[i]) {
          return false;
        }
        k += 1;
        i += 1;
        j += 1;
      }
      k = j;
      Object localObject1 = localObject2;
      if (j == ((Segment)localObject2).c)
      {
        localObject1 = ((Segment)localObject2).f;
        k = ((Segment)localObject1).b;
      }
      j = i;
      localObject2 = paramObject;
      if (i == paramObject.c)
      {
        localObject2 = paramObject.f;
        j = ((Segment)localObject2).b;
      }
      l1 += l2;
      i = j;
      j = k;
      paramObject = localObject2;
      localObject2 = localObject1;
    }
    return true;
  }
  
  public BufferedSink f()
  {
    return this;
  }
  
  public byte[] f(long paramLong)
  {
    Util.a(this.b, 0L, paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    byte[] arrayOfByte = new byte[(int)paramLong];
    a(arrayOfByte);
    return arrayOfByte;
  }
  
  public void flush() {}
  
  public void g(long paramLong)
  {
    while (paramLong > 0L)
    {
      if (this.a == null) {
        throw new EOFException();
      }
      int i = (int)Math.min(paramLong, this.a.c - this.a.b);
      this.b -= i;
      long l = paramLong - i;
      Segment localSegment = this.a;
      localSegment.b = (i + localSegment.b);
      paramLong = l;
      if (this.a.b == this.a.c)
      {
        localSegment = this.a;
        this.a = localSegment.a();
        SegmentPool.a(localSegment);
        paramLong = l;
      }
    }
  }
  
  public boolean g()
  {
    return this.b == 0L;
  }
  
  public InputStream h()
  {
    return new Buffer.2(this);
  }
  
  public Buffer h(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    Segment localSegment = e(j);
    byte[] arrayOfByte = localSegment.a;
    int i = localSegment.c + j - 1;
    int k = localSegment.c;
    while (i >= k)
    {
      arrayOfByte[i] = c[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localSegment.c += j;
    paramLong = this.b;
    this.b = (j + paramLong);
    return this;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return 0;
    }
    int j = 1;
    int i;
    Segment localSegment;
    do
    {
      int k = ((Segment)localObject).b;
      int m = ((Segment)localObject).c;
      for (i = j; k < m; i = j + i * 31)
      {
        j = localObject.a[k];
        k += 1;
      }
      localSegment = ((Segment)localObject).f;
      j = i;
      localObject = localSegment;
    } while (localSegment != this.a);
    return i;
  }
  
  public long i()
  {
    long l2 = this.b;
    long l1;
    if (l2 == 0L) {
      l1 = 0L;
    }
    Segment localSegment;
    do
    {
      do
      {
        return l1;
        localSegment = this.a.g;
        l1 = l2;
      } while (localSegment.c >= 2048);
      l1 = l2;
    } while (!localSegment.e);
    return l2 - (localSegment.c - localSegment.b);
  }
  
  public byte j()
  {
    if (this.b == 0L) {
      throw new IllegalStateException("size == 0");
    }
    Segment localSegment = this.a;
    int i = localSegment.b;
    int j = localSegment.c;
    byte[] arrayOfByte = localSegment.a;
    int k = i + 1;
    byte b1 = arrayOfByte[i];
    this.b -= 1L;
    if (k == j)
    {
      this.a = localSegment.a();
      SegmentPool.a(localSegment);
      return b1;
    }
    localSegment.b = k;
    return b1;
  }
  
  public short k()
  {
    if (this.b < 2L) {
      throw new IllegalStateException("size < 2: " + this.b);
    }
    Segment localSegment = this.a;
    int k = localSegment.b;
    int i = localSegment.c;
    if (i - k < 2) {
      return (short)((j() & 0xFF) << 8 | j() & 0xFF);
    }
    byte[] arrayOfByte = localSegment.a;
    int j = k + 1;
    k = arrayOfByte[k];
    int m = j + 1;
    j = arrayOfByte[j];
    this.b -= 2L;
    if (m == i)
    {
      this.a = localSegment.a();
      SegmentPool.a(localSegment);
    }
    for (;;)
    {
      return (short)((k & 0xFF) << 8 | j & 0xFF);
      localSegment.b = m;
    }
  }
  
  public int l()
  {
    if (this.b < 4L) {
      throw new IllegalStateException("size < 4: " + this.b);
    }
    Segment localSegment = this.a;
    int j = localSegment.b;
    int i = localSegment.c;
    if (i - j < 4) {
      return (j() & 0xFF) << 24 | (j() & 0xFF) << 16 | (j() & 0xFF) << 8 | j() & 0xFF;
    }
    byte[] arrayOfByte = localSegment.a;
    int k = j + 1;
    j = arrayOfByte[j];
    int n = k + 1;
    k = arrayOfByte[k];
    int m = n + 1;
    int i1 = arrayOfByte[n];
    n = m + 1;
    j = (j & 0xFF) << 24 | (k & 0xFF) << 16 | (i1 & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
    this.b -= 4L;
    if (n == i)
    {
      this.a = localSegment.a();
      SegmentPool.a(localSegment);
      return j;
    }
    localSegment.b = n;
    return j;
  }
  
  public short m()
  {
    return Util.a(k());
  }
  
  public int n()
  {
    return Util.a(l());
  }
  
  public long o()
  {
    if (this.b == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l2 = 0L;
    int i = 0;
    int j = 0;
    Object localObject = this.a;
    byte[] arrayOfByte = ((Segment)localObject).a;
    int m = ((Segment)localObject).b;
    int n = ((Segment)localObject).c;
    long l1 = l2;
    int k = i;
    label60:
    i = j;
    if (m < n)
    {
      int i1 = arrayOfByte[m];
      if ((i1 >= 48) && (i1 <= 57)) {
        i = i1 - 48;
      }
      for (;;)
      {
        if ((0xF000000000000000 & l1) == 0L) {
          break label302;
        }
        localObject = new Buffer().h(l1).b(i1);
        throw new NumberFormatException("Number too large: " + ((Buffer)localObject).q());
        if ((i1 >= 97) && (i1 <= 102))
        {
          i = i1 - 97 + 10;
        }
        else
        {
          if ((i1 < 65) || (i1 > 70)) {
            break;
          }
          i = i1 - 65 + 10;
        }
      }
      if (k == 0) {
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i1));
      }
      i = 1;
    }
    if (m == n)
    {
      this.a = ((Segment)localObject).a();
      SegmentPool.a((Segment)localObject);
    }
    for (;;)
    {
      if (i == 0)
      {
        j = i;
        i = k;
        l2 = l1;
        if (this.a != null) {
          break;
        }
      }
      this.b -= k;
      return l1;
      label302:
      l2 = i;
      k += 1;
      m += 1;
      l1 = l2 | l1 << 4;
      break label60;
      ((Segment)localObject).b = m;
    }
  }
  
  public ByteString p()
  {
    return new ByteString(s());
  }
  
  public String q()
  {
    try
    {
      String str = a(this.b, Util.a);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public String r()
  {
    long l = a((byte)10);
    if (l == -1L)
    {
      Buffer localBuffer = new Buffer();
      a(localBuffer, 0L, Math.min(32L, this.b));
      throw new EOFException("\\n not found: size=" + b() + " content=" + localBuffer.p().d() + "...");
    }
    return e(l);
  }
  
  public byte[] s()
  {
    try
    {
      byte[] arrayOfByte = f(this.b);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public void t()
  {
    try
    {
      g(this.b);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public String toString()
  {
    if (this.b == 0L) {
      return "Buffer[size=0]";
    }
    Object localObject;
    if (this.b <= 16L)
    {
      localObject = u().p();
      return String.format("Buffer[size=%s data=%s]", new Object[] { Long.valueOf(this.b), ((ByteString)localObject).d() });
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(this.a.a, this.a.b, this.a.c - this.a.b);
      for (localObject = this.a.f; localObject != this.a; localObject = ((Segment)localObject).f) {
        localMessageDigest.update(((Segment)localObject).a, ((Segment)localObject).b, ((Segment)localObject).c - ((Segment)localObject).b);
      }
      localObject = String.format("Buffer[size=%s md5=%s]", new Object[] { Long.valueOf(this.b), ByteString.a(localMessageDigest.digest()).d() });
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError();
    }
  }
  
  public Buffer u()
  {
    Buffer localBuffer = new Buffer();
    if (this.b == 0L) {
      return localBuffer;
    }
    localBuffer.a = new Segment(this.a);
    Segment localSegment1 = localBuffer.a;
    Segment localSegment2 = localBuffer.a;
    Segment localSegment3 = localBuffer.a;
    localSegment2.g = localSegment3;
    localSegment1.f = localSegment3;
    for (localSegment1 = this.a.f; localSegment1 != this.a; localSegment1 = localSegment1.f) {
      localBuffer.a.g.a(new Segment(localSegment1));
    }
    localBuffer.b = this.b;
    return localBuffer;
  }
}
