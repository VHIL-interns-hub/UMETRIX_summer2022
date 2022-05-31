package okio;

import java.io.OutputStream;

public abstract interface BufferedSink
  extends Sink
{
  public abstract long a(Source paramSource);
  
  public abstract BufferedSink b(String paramString);
  
  public abstract BufferedSink b(ByteString paramByteString);
  
  public abstract Buffer c();
  
  public abstract BufferedSink c(byte[] paramArrayOfByte);
  
  public abstract BufferedSink c(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract OutputStream d();
  
  public abstract BufferedSink f();
  
  public abstract BufferedSink f(int paramInt);
  
  public abstract BufferedSink g(int paramInt);
  
  public abstract BufferedSink h(int paramInt);
  
  public abstract BufferedSink i(long paramLong);
  
  public abstract BufferedSink v();
}
