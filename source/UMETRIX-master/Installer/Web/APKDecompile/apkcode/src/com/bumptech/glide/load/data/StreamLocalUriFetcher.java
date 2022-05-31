package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

public class StreamLocalUriFetcher
  extends LocalUriFetcher
{
  public StreamLocalUriFetcher(Context paramContext, Uri paramUri)
  {
    super(paramContext, paramUri);
  }
  
  protected InputStream a(Uri paramUri, ContentResolver paramContentResolver)
  {
    return paramContentResolver.openInputStream(paramUri);
  }
  
  protected void a(InputStream paramInputStream)
  {
    paramInputStream.close();
  }
}
