package com.squareup.okhttp;

public abstract interface Interceptor
{
  public abstract Response a(Interceptor.Chain paramChain);
}
