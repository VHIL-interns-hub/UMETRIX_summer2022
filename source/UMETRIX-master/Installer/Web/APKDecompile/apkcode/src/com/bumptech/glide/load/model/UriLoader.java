package com.bumptech.glide.load.model;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;

public abstract class UriLoader
  implements ModelLoader
{
  private final Context a;
  private final ModelLoader b;
  
  public UriLoader(Context paramContext, ModelLoader paramModelLoader)
  {
    this.a = paramContext;
    this.b = paramModelLoader;
  }
  
  private static boolean a(String paramString)
  {
    return ("file".equals(paramString)) || ("content".equals(paramString)) || ("android.resource".equals(paramString));
  }
  
  protected abstract DataFetcher a(Context paramContext, Uri paramUri);
  
  protected abstract DataFetcher a(Context paramContext, String paramString);
  
  public final DataFetcher a(Uri paramUri, int paramInt1, int paramInt2)
  {
    String str = paramUri.getScheme();
    Object localObject2 = null;
    Object localObject1;
    if (a(str)) {
      if (AssetUriParser.a(paramUri))
      {
        paramUri = AssetUriParser.b(paramUri);
        localObject1 = a(this.a, paramUri);
      }
    }
    do
    {
      do
      {
        return localObject1;
        return a(this.a, paramUri);
        localObject1 = localObject2;
      } while (this.b == null);
      if ("http".equals(str)) {
        break;
      }
      localObject1 = localObject2;
    } while (!"https".equals(str));
    return this.b.a(new GlideUrl(paramUri.toString()), paramInt1, paramInt2);
  }
}
