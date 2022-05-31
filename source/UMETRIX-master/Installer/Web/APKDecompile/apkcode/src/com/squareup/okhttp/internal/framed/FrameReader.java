package com.squareup.okhttp.internal.framed;

import java.io.Closeable;

public abstract interface FrameReader
  extends Closeable
{
  public abstract void a();
  
  public abstract boolean a(FrameReader.Handler paramHandler);
}
