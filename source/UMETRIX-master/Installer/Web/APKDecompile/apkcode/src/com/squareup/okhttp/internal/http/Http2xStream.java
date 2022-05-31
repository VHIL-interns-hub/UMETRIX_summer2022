package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedStream;
import com.squareup.okhttp.internal.framed.Header;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Timeout;

public final class Http2xStream
  implements HttpStream
{
  private static final ByteString a = ByteString.a("connection");
  private static final ByteString b = ByteString.a("host");
  private static final ByteString c = ByteString.a("keep-alive");
  private static final ByteString d = ByteString.a("proxy-connection");
  private static final ByteString e = ByteString.a("transfer-encoding");
  private static final ByteString f = ByteString.a("te");
  private static final ByteString g = ByteString.a("encoding");
  private static final ByteString h = ByteString.a("upgrade");
  private static final List i = Util.a(new ByteString[] { a, b, c, d, e, Header.b, Header.c, Header.d, Header.e, Header.f, Header.g });
  private static final List j = Util.a(new ByteString[] { a, b, c, d, e });
  private static final List k = Util.a(new ByteString[] { a, b, c, d, f, e, g, h, Header.b, Header.c, Header.d, Header.e, Header.f, Header.g });
  private static final List l = Util.a(new ByteString[] { a, b, c, d, f, e, g, h });
  private final StreamAllocation m;
  private final FramedConnection n;
  private HttpEngine o;
  private FramedStream p;
  
  public Http2xStream(StreamAllocation paramStreamAllocation, FramedConnection paramFramedConnection)
  {
    this.m = paramStreamAllocation;
    this.n = paramFramedConnection;
  }
  
  public static Response.Builder a(List paramList)
  {
    Object localObject1 = null;
    Object localObject2 = "HTTP/1.1";
    Headers.Builder localBuilder = new Headers.Builder();
    int i5 = paramList.size();
    int i1 = 0;
    while (i1 < i5)
    {
      ByteString localByteString = ((Header)paramList.get(i1)).h;
      String str2 = ((Header)paramList.get(i1)).i.a();
      int i2 = 0;
      if (i2 < str2.length())
      {
        int i4 = str2.indexOf(0, i2);
        int i3 = i4;
        if (i4 == -1) {
          i3 = str2.length();
        }
        String str1 = str2.substring(i2, i3);
        if (localByteString.equals(Header.a)) {
          localObject1 = str1;
        }
        for (;;)
        {
          i2 = i3 + 1;
          break;
          if (localByteString.equals(Header.g)) {
            localObject2 = str1;
          } else if (!j.contains(localByteString)) {
            localBuilder.a(localByteString.a(), str1);
          }
        }
      }
      i1 += 1;
    }
    if (localObject1 == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    paramList = StatusLine.a((String)localObject2 + " " + localObject1);
    return new Response.Builder().a(Protocol.c).a(paramList.b).a(paramList.c).a(localBuilder.a());
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + '\000' + paramString2;
  }
  
  public static Response.Builder b(List paramList)
  {
    Object localObject = null;
    Headers.Builder localBuilder = new Headers.Builder();
    int i2 = paramList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      ByteString localByteString = ((Header)paramList.get(i1)).h;
      String str = ((Header)paramList.get(i1)).i.a();
      if (localByteString.equals(Header.a)) {
        localObject = str;
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (!l.contains(localByteString)) {
          localBuilder.a(localByteString.a(), str);
        }
      }
    }
    if (localObject == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    paramList = StatusLine.a("HTTP/1.1 " + localObject);
    return new Response.Builder().a(Protocol.d).a(paramList.b).a(paramList.c).a(localBuilder.a());
  }
  
  public static List b(Request paramRequest)
  {
    Headers localHeaders = paramRequest.f();
    ArrayList localArrayList = new ArrayList(localHeaders.a() + 5);
    localArrayList.add(new Header(Header.b, paramRequest.e()));
    localArrayList.add(new Header(Header.c, RequestLine.a(paramRequest.a())));
    localArrayList.add(new Header(Header.g, "HTTP/1.1"));
    localArrayList.add(new Header(Header.f, Util.a(paramRequest.a())));
    localArrayList.add(new Header(Header.d, paramRequest.a().c()));
    paramRequest = new LinkedHashSet();
    int i3 = localHeaders.a();
    int i1 = 0;
    if (i1 < i3)
    {
      ByteString localByteString = ByteString.a(localHeaders.a(i1).toLowerCase(Locale.US));
      if (i.contains(localByteString)) {}
      label321:
      for (;;)
      {
        i1 += 1;
        break;
        String str = localHeaders.b(i1);
        if (paramRequest.add(localByteString))
        {
          localArrayList.add(new Header(localByteString, str));
        }
        else
        {
          int i2 = 0;
          for (;;)
          {
            if (i2 >= localArrayList.size()) {
              break label321;
            }
            if (((Header)localArrayList.get(i2)).h.equals(localByteString))
            {
              localArrayList.set(i2, new Header(localByteString, a(((Header)localArrayList.get(i2)).i.a(), str)));
              break;
            }
            i2 += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static List c(Request paramRequest)
  {
    Headers localHeaders = paramRequest.f();
    ArrayList localArrayList = new ArrayList(localHeaders.a() + 4);
    localArrayList.add(new Header(Header.b, paramRequest.e()));
    localArrayList.add(new Header(Header.c, RequestLine.a(paramRequest.a())));
    localArrayList.add(new Header(Header.e, Util.a(paramRequest.a())));
    localArrayList.add(new Header(Header.d, paramRequest.a().c()));
    int i1 = 0;
    int i2 = localHeaders.a();
    while (i1 < i2)
    {
      paramRequest = ByteString.a(localHeaders.a(i1).toLowerCase(Locale.US));
      if (!k.contains(paramRequest)) {
        localArrayList.add(new Header(paramRequest, localHeaders.b(i1)));
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public ResponseBody a(Response paramResponse)
  {
    Http2xStream.StreamFinishingSource localStreamFinishingSource = new Http2xStream.StreamFinishingSource(this, this.p.g());
    return new RealResponseBody(paramResponse.f(), Okio.a(localStreamFinishingSource));
  }
  
  public Sink a(Request paramRequest, long paramLong)
  {
    return this.p.h();
  }
  
  public void a()
  {
    if (this.p != null) {
      this.p.b(ErrorCode.l);
    }
  }
  
  public void a(Request paramRequest)
  {
    if (this.p != null) {
      return;
    }
    this.o.b();
    boolean bool = this.o.a(paramRequest);
    if (this.n.a() == Protocol.d) {}
    for (paramRequest = c(paramRequest);; paramRequest = b(paramRequest))
    {
      this.p = this.n.a(paramRequest, bool, true);
      this.p.e().a(this.o.a.b(), TimeUnit.MILLISECONDS);
      this.p.f().a(this.o.a.c(), TimeUnit.MILLISECONDS);
      return;
    }
  }
  
  public void a(HttpEngine paramHttpEngine)
  {
    this.o = paramHttpEngine;
  }
  
  public void a(RetryableSink paramRetryableSink)
  {
    paramRetryableSink.a(this.p.h());
  }
  
  public Response.Builder b()
  {
    if (this.n.a() == Protocol.d) {
      return b(this.p.d());
    }
    return a(this.p.d());
  }
  
  public void c()
  {
    this.p.h().close();
  }
}
