package com.squareup.okhttp.internal.framed;

import okio.BufferedSink;
import okio.BufferedSource;

public abstract interface Variant
{
  public abstract FrameReader a(BufferedSource paramBufferedSource, boolean paramBoolean);
  
  public abstract FrameWriter a(BufferedSink paramBufferedSink, boolean paramBoolean);
}
