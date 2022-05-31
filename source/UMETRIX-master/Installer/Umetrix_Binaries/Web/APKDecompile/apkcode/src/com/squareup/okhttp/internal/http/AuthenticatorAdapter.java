package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.List;

public final class AuthenticatorAdapter
  implements com.squareup.okhttp.Authenticator
{
  public static final com.squareup.okhttp.Authenticator a = new AuthenticatorAdapter();
  
  public AuthenticatorAdapter() {}
  
  private InetAddress a(Proxy paramProxy, HttpUrl paramHttpUrl)
  {
    if ((paramProxy != null) && (paramProxy.type() != Proxy.Type.DIRECT)) {
      return ((InetSocketAddress)paramProxy.address()).getAddress();
    }
    return InetAddress.getByName(paramHttpUrl.g());
  }
  
  public Request a(Proxy paramProxy, Response paramResponse)
  {
    List localList = paramResponse.k();
    paramResponse = paramResponse.a();
    HttpUrl localHttpUrl = paramResponse.a();
    int j = localList.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (Challenge)localList.get(i);
      if (!"Basic".equalsIgnoreCase(((Challenge)localObject).a())) {}
      do
      {
        i += 1;
        break;
        localObject = java.net.Authenticator.requestPasswordAuthentication(localHttpUrl.g(), a(paramProxy, localHttpUrl), localHttpUrl.h(), localHttpUrl.c(), ((Challenge)localObject).b(), ((Challenge)localObject).a(), localHttpUrl.a(), Authenticator.RequestorType.SERVER);
      } while (localObject == null);
      paramProxy = Credentials.a(((PasswordAuthentication)localObject).getUserName(), new String(((PasswordAuthentication)localObject).getPassword()));
      return paramResponse.h().a("Authorization", paramProxy).a();
    }
    return null;
  }
  
  public Request b(Proxy paramProxy, Response paramResponse)
  {
    List localList = paramResponse.k();
    paramResponse = paramResponse.a();
    HttpUrl localHttpUrl = paramResponse.a();
    int j = localList.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (Challenge)localList.get(i);
      if (!"Basic".equalsIgnoreCase(((Challenge)localObject).a())) {}
      do
      {
        i += 1;
        break;
        InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramProxy.address();
        localObject = java.net.Authenticator.requestPasswordAuthentication(localInetSocketAddress.getHostName(), a(paramProxy, localHttpUrl), localInetSocketAddress.getPort(), localHttpUrl.c(), ((Challenge)localObject).b(), ((Challenge)localObject).a(), localHttpUrl.a(), Authenticator.RequestorType.PROXY);
      } while (localObject == null);
      paramProxy = Credentials.a(((PasswordAuthentication)localObject).getUserName(), new String(((PasswordAuthentication)localObject).getPassword()));
      return paramResponse.h().a("Proxy-Authorization", paramProxy).a();
    }
    return null;
  }
}
