package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;

public abstract class LocalUriFetcher
  implements DataFetcher
{
  private final Uri a;
  private final Context b;
  private Object c;
  
  public LocalUriFetcher(Context paramContext, Uri paramUri)
  {
    this.b = paramContext.getApplicationContext();
    this.a = paramUri;
  }
  
  public final Object a(Priority paramPriority)
  {
    paramPriority = this.b.getContentResolver();
    this.c = b(this.a, paramPriority);
    return this.c;
  }
  
  public void a()
  {
    if (this.c != null) {}
    try
    {
      a(this.c);
      return;
    }
    catch (IOException localIOException)
    {
      while (!Log.isLoggable("LocalUriFetcher", 2)) {}
      Log.v("LocalUriFetcher", "failed to close data", localIOException);
    }
  }
  
  protected abstract void a(Object paramObject);
  
  protected abstract Object b(Uri paramUri, ContentResolver paramContentResolver);
  
  public String b()
  {
    return this.a.toString();
  }
  
  public void c() {}
}
