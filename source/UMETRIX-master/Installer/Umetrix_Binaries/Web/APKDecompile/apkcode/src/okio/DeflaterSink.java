package okio;

import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class DeflaterSink
  implements Sink
{
  private final BufferedSink a;
  private final Deflater b;
  private boolean c;
  
  DeflaterSink(BufferedSink paramBufferedSink, Deflater paramDeflater)
  {
    if (paramBufferedSink == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramDeflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = paramBufferedSink;
    this.b = paramDeflater;
  }
  
  public DeflaterSink(Sink paramSink, Deflater paramDeflater)
  {
    this(Okio.a(paramSink), paramDeflater);
  }
  
  @IgnoreJRERequirement
  private void a(boolean paramBoolean)
  {
    Buffer localBuffer = this.a.c();
    Segment localSegment;
    label119:
    do
    {
      localSegment = localBuffer.e(1);
      if (paramBoolean) {}
      for (int i = this.b.deflate(localSegment.a, localSegment.c, 2048 - localSegment.c, 2);; i = this.b.deflate(localSegment.a, localSegment.c, 2048 - localSegment.c))
      {
        if (i <= 0) {
          break label119;
        }
        localSegment.c += i;
        localBuffer.b += i;
        this.a.v();
        break;
      }
    } while (!this.b.needsInput());
    if (localSegment.b == localSegment.c)
    {
      localBuffer.a = localSegment.a();
      SegmentPool.a(localSegment);
    }
  }
  
  public Timeout a()
  {
    return this.a.a();
  }
  
  public void a_(Buffer paramBuffer, long paramLong)
  {
    Util.a(paramBuffer.b, 0L, paramLong);
    while (paramLong > 0L)
    {
      Segment localSegment = paramBuffer.a;
      int i = (int)Math.min(paramLong, localSegment.c - localSegment.b);
      this.b.setInput(localSegment.a, localSegment.b, i);
      a(false);
      paramBuffer.b -= i;
      localSegment.b += i;
      if (localSegment.b == localSegment.c)
      {
        paramBuffer.a = localSegment.a();
        SegmentPool.a(localSegment);
      }
      paramLong -= i;
    }
  }
  
  void b()
  {
    this.b.finish();
    a(false);
  }
  
  public void close()
  {
    if (this.c) {}
    for (;;)
    {
      return;
      Object localObject3 = null;
      try
      {
        b();
        try
        {
          this.b.end();
          localObject1 = localObject3;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            Object localObject1;
            label34:
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
        }
        try
        {
          this.a.close();
          localObject3 = localObject1;
        }
        catch (Throwable localThrowable3)
        {
          localObject3 = localObject2;
          if (localObject2 != null) {
            break label34;
          }
          localObject3 = localThrowable3;
          break label34;
        }
        this.c = true;
        if (localObject3 == null) {
          continue;
        }
        Util.a(localObject3);
        return;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        for (;;) {}
      }
    }
  }
  
  public void flush()
  {
    a(true);
    this.a.flush();
  }
  
  public String toString()
  {
    return "DeflaterSink(" + this.a + ")";
  }
}
