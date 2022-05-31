package com.squareup.okhttp;

import java.net.Proxy;

public abstract interface Authenticator
{
  public abstract Request a(Proxy paramProxy, Response paramResponse);
  
  public abstract Request b(Proxy paramProxy, Response paramResponse);
}
