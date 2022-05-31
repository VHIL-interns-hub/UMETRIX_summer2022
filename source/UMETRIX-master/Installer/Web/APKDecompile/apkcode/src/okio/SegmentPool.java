package okio;

final class SegmentPool
{
  static Segment a;
  static long b;
  
  private SegmentPool() {}
  
  static Segment a()
  {
    try
    {
      if (a != null)
      {
        Segment localSegment = a;
        a = localSegment.f;
        localSegment.f = null;
        b -= 2048L;
        return localSegment;
      }
      return new Segment();
    }
    finally {}
  }
  
  static void a(Segment paramSegment)
  {
    if ((paramSegment.f != null) || (paramSegment.g != null)) {
      throw new IllegalArgumentException();
    }
    if (paramSegment.d) {
      return;
    }
    try
    {
      if (b + 2048L > 65536L) {
        return;
      }
    }
    finally {}
    b += 2048L;
    paramSegment.f = a;
    paramSegment.c = 0;
    paramSegment.b = 0;
    a = paramSegment;
  }
}
