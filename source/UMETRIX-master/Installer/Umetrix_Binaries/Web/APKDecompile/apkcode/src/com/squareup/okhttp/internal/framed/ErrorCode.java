package com.squareup.okhttp.internal.framed;

public enum ErrorCode
{
  public final int s;
  public final int t;
  public final int u;
  
  private ErrorCode(int paramInt1, int paramInt2, int paramInt3)
  {
    this.s = paramInt1;
    this.t = paramInt2;
    this.u = paramInt3;
  }
  
  public static ErrorCode a(int paramInt)
  {
    ErrorCode[] arrayOfErrorCode = values();
    int i2 = arrayOfErrorCode.length;
    int i1 = 0;
    while (i1 < i2)
    {
      ErrorCode localErrorCode = arrayOfErrorCode[i1];
      if (localErrorCode.t == paramInt) {
        return localErrorCode;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static ErrorCode b(int paramInt)
  {
    ErrorCode[] arrayOfErrorCode = values();
    int i2 = arrayOfErrorCode.length;
    int i1 = 0;
    while (i1 < i2)
    {
      ErrorCode localErrorCode = arrayOfErrorCode[i1];
      if (localErrorCode.s == paramInt) {
        return localErrorCode;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static ErrorCode c(int paramInt)
  {
    ErrorCode[] arrayOfErrorCode = values();
    int i2 = arrayOfErrorCode.length;
    int i1 = 0;
    while (i1 < i2)
    {
      ErrorCode localErrorCode = arrayOfErrorCode[i1];
      if (localErrorCode.u == paramInt) {
        return localErrorCode;
      }
      i1 += 1;
    }
    return null;
  }
}
