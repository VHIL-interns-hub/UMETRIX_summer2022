package okio;

final class Segment
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  Segment f;
  Segment g;
  
  Segment()
  {
    this.a = new byte['?'];
    this.e = true;
    this.d = false;
  }
  
  Segment(Segment paramSegment)
  {
    this(paramSegment.a, paramSegment.b, paramSegment.c);
    paramSegment.d = true;
  }
  
  Segment(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.e = false;
    this.d = true;
  }
  
  public Segment a()
  {
    if (this.f != this) {}
    for (Segment localSegment = this.f;; localSegment = null)
    {
      this.g.f = this.f;
      this.f.g = this.g;
      this.f = null;
      this.g = null;
      return localSegment;
    }
  }
  
  public Segment a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.c - this.b)) {
      throw new IllegalArgumentException();
    }
    Segment localSegment = new Segment(this);
    localSegment.c = (localSegment.b + paramInt);
    this.b += paramInt;
    this.g.a(localSegment);
    return localSegment;
  }
  
  public Segment a(Segment paramSegment)
  {
    paramSegment.g = this;
    paramSegment.f = this.f;
    this.f.g = paramSegment;
    this.f = paramSegment;
    return paramSegment;
  }
  
  public void a(Segment paramSegment, int paramInt)
  {
    if (!paramSegment.e) {
      throw new IllegalArgumentException();
    }
    if (paramSegment.c + paramInt > 2048)
    {
      if (paramSegment.d) {
        throw new IllegalArgumentException();
      }
      if (paramSegment.c + paramInt - paramSegment.b > 2048) {
        throw new IllegalArgumentException();
      }
      System.arraycopy(paramSegment.a, paramSegment.b, paramSegment.a, 0, paramSegment.c - paramSegment.b);
      paramSegment.c -= paramSegment.b;
      paramSegment.b = 0;
    }
    System.arraycopy(this.a, this.b, paramSegment.a, paramSegment.c, paramInt);
    paramSegment.c += paramInt;
    this.b += paramInt;
  }
  
  public void b()
  {
    if (this.g == this) {
      throw new IllegalStateException();
    }
    if (!this.g.e) {}
    for (;;)
    {
      return;
      int j = this.c - this.b;
      int k = this.g.c;
      if (this.g.d) {}
      for (int i = 0; j <= i + (2048 - k); i = this.g.b)
      {
        a(this.g, j);
        a();
        SegmentPool.a(this);
        return;
      }
    }
  }
}
