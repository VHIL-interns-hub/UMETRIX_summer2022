package okio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class Okio
{
  private static final Logger a = Logger.getLogger(Okio.class.getName());
  
  private Okio() {}
  
  public static BufferedSink a(Sink paramSink)
  {
    if (paramSink == null) {
      throw new IllegalArgumentException("sink == null");
    }
    return new RealBufferedSink(paramSink);
  }
  
  public static BufferedSource a(Source paramSource)
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    return new RealBufferedSource(paramSource);
  }
  
  private static Sink a(OutputStream paramOutputStream, Timeout paramTimeout)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    if (paramTimeout == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    return new Okio.1(paramTimeout, paramOutputStream);
  }
  
  public static Sink a(Socket paramSocket)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    AsyncTimeout localAsyncTimeout = c(paramSocket);
    return localAsyncTimeout.a(a(paramSocket.getOutputStream(), localAsyncTimeout));
  }
  
  private static Source a(InputStream paramInputStream, Timeout paramTimeout)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    if (paramTimeout == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    return new Okio.2(paramTimeout, paramInputStream);
  }
  
  public static Source b(Socket paramSocket)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    AsyncTimeout localAsyncTimeout = c(paramSocket);
    return localAsyncTimeout.a(a(paramSocket.getInputStream(), localAsyncTimeout));
  }
  
  private static AsyncTimeout c(Socket paramSocket)
  {
    return new Okio.3(paramSocket);
  }
}
