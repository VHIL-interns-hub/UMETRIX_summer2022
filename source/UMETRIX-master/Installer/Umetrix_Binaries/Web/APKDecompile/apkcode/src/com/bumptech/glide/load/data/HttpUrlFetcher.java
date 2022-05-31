package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpUrlFetcher
  implements DataFetcher
{
  private static final HttpUrlFetcher.HttpUrlConnectionFactory a = new HttpUrlFetcher.DefaultHttpUrlConnectionFactory(null);
  private final GlideUrl b;
  private final HttpUrlFetcher.HttpUrlConnectionFactory c;
  private HttpURLConnection d;
  private InputStream e;
  private volatile boolean f;
  
  public HttpUrlFetcher(GlideUrl paramGlideUrl)
  {
    this(paramGlideUrl, a);
  }
  
  HttpUrlFetcher(GlideUrl paramGlideUrl, HttpUrlFetcher.HttpUrlConnectionFactory paramHttpUrlConnectionFactory)
  {
    this.b = paramGlideUrl;
    this.c = paramHttpUrlConnectionFactory;
  }
  
  private InputStream a(HttpURLConnection paramHttpURLConnection)
  {
    int i;
    if (TextUtils.isEmpty(paramHttpURLConnection.getContentEncoding())) {
      i = paramHttpURLConnection.getContentLength();
    }
    for (this.e = ContentLengthInputStream.a(paramHttpURLConnection.getInputStream(), i);; this.e = paramHttpURLConnection.getInputStream())
    {
      return this.e;
      if (Log.isLoggable("HttpUrlFetcher", 3)) {
        Log.d("HttpUrlFetcher", "Got non empty content encoding: " + paramHttpURLConnection.getContentEncoding());
      }
    }
  }
  
  private InputStream a(URL paramURL1, int paramInt, URL paramURL2, Map paramMap)
  {
    if (paramInt >= 5) {
      throw new IOException("Too many (> 5) redirects!");
    }
    if (paramURL2 != null) {
      try
      {
        if (paramURL1.toURI().equals(paramURL2.toURI())) {
          throw new IOException("In re-direct loop");
        }
      }
      catch (URISyntaxException paramURL2) {}
    }
    this.d = this.c.a(paramURL1);
    paramURL2 = paramMap.entrySet().iterator();
    while (paramURL2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramURL2.next();
      this.d.addRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    this.d.setConnectTimeout(2500);
    this.d.setReadTimeout(2500);
    this.d.setUseCaches(false);
    this.d.setDoInput(true);
    this.d.connect();
    if (this.f) {
      return null;
    }
    int i = this.d.getResponseCode();
    if (i / 100 == 2) {
      return a(this.d);
    }
    if (i / 100 == 3)
    {
      paramURL2 = this.d.getHeaderField("Location");
      if (TextUtils.isEmpty(paramURL2)) {
        throw new IOException("Received empty or null redirect url");
      }
      return a(new URL(paramURL1, paramURL2), paramInt + 1, paramURL1, paramMap);
    }
    if (i == -1) {
      throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
    }
    throw new IOException("Request failed " + i + ": " + this.d.getResponseMessage());
  }
  
  public void a()
  {
    if (this.e != null) {}
    try
    {
      this.e.close();
      if (this.d != null) {
        this.d.disconnect();
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public InputStream b(Priority paramPriority)
  {
    return a(this.b.a(), 0, null, this.b.b());
  }
  
  public String b()
  {
    return this.b.c();
  }
  
  public void c()
  {
    this.f = true;
  }
}
