package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;

public abstract class AssetPathFetcher
  implements DataFetcher
{
  private final String a;
  private final AssetManager b;
  private Object c;
  
  public AssetPathFetcher(AssetManager paramAssetManager, String paramString)
  {
    this.b = paramAssetManager;
    this.a = paramString;
  }
  
  protected abstract Object a(AssetManager paramAssetManager, String paramString);
  
  public Object a(Priority paramPriority)
  {
    this.c = a(this.b, this.a);
    return this.c;
  }
  
  public void a()
  {
    if (this.c == null) {}
    do
    {
      return;
      try
      {
        a(this.c);
        return;
      }
      catch (IOException localIOException) {}
    } while (!Log.isLoggable("AssetUriFetcher", 2));
    Log.v("AssetUriFetcher", "Failed to close data", localIOException);
  }
  
  protected abstract void a(Object paramObject);
  
  public String b()
  {
    return this.a;
  }
  
  public void c() {}
}
