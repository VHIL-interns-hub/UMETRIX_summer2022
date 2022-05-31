package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.logging.Logger;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public final class Http2
  implements Variant
{
  private static final Logger a = Logger.getLogger(Http2.FrameLogger.class.getName());
  private static final ByteString b = ByteString.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  
  public Http2() {}
  
  private static int b(int paramInt, byte paramByte, short paramShort)
  {
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort > s) {
      throw d("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
    }
    return (short)(s - paramShort);
  }
  
  private static int b(BufferedSource paramBufferedSource)
  {
    return (paramBufferedSource.j() & 0xFF) << 16 | (paramBufferedSource.j() & 0xFF) << 8 | paramBufferedSource.j() & 0xFF;
  }
  
  private static void b(BufferedSink paramBufferedSink, int paramInt)
  {
    paramBufferedSink.h(paramInt >>> 16 & 0xFF);
    paramBufferedSink.h(paramInt >>> 8 & 0xFF);
    paramBufferedSink.h(paramInt & 0xFF);
  }
  
  private static IllegalArgumentException c(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
  }
  
  private static IOException d(String paramString, Object... paramVarArgs)
  {
    throw new IOException(String.format(paramString, paramVarArgs));
  }
  
  public FrameReader a(BufferedSource paramBufferedSource, boolean paramBoolean)
  {
    return new Http2.Reader(paramBufferedSource, 4096, paramBoolean);
  }
  
  public FrameWriter a(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    return new Http2.Writer(paramBufferedSink, paramBoolean);
  }
}
