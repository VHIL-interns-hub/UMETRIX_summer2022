package com.squareup.okhttp.internal.framed;

import java.util.List;
import okio.BufferedSource;

public abstract interface PushObserver
{
  public static final PushObserver a = new PushObserver.1();
  
  public abstract void a(int paramInt, ErrorCode paramErrorCode);
  
  public abstract boolean a(int paramInt, List paramList);
  
  public abstract boolean a(int paramInt, List paramList, boolean paramBoolean);
  
  public abstract boolean a(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean);
}
