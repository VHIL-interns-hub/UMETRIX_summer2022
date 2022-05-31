package com.squareup.okhttp.internal.framed;

import java.io.Closeable;
import java.util.List;
import okio.Buffer;

public abstract interface FrameWriter
  extends Closeable
{
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, List paramList);
  
  public abstract void a(int paramInt, long paramLong);
  
  public abstract void a(int paramInt, ErrorCode paramErrorCode);
  
  public abstract void a(int paramInt, ErrorCode paramErrorCode, byte[] paramArrayOfByte);
  
  public abstract void a(Settings paramSettings);
  
  public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract void a(boolean paramBoolean, int paramInt1, Buffer paramBuffer, int paramInt2);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List paramList);
  
  public abstract void b();
  
  public abstract void b(Settings paramSettings);
  
  public abstract int c();
}
