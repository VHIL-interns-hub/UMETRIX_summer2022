package net.fred.feedex.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

public abstract class BaseLoader
  extends AsyncTaskLoader
{
  private Object a;
  
  protected BaseLoader(Context paramContext)
  {
    super(paramContext);
  }
  
  public void deliverResult(Object paramObject)
  {
    if (isReset()) {
      return;
    }
    this.a = paramObject;
    super.deliverResult(paramObject);
  }
  
  protected void onReset()
  {
    super.onReset();
    onStopLoading();
    this.a = null;
  }
  
  protected void onStartLoading()
  {
    if (this.a != null) {
      deliverResult(this.a);
    }
    if ((takeContentChanged()) || (this.a == null)) {
      forceLoad();
    }
  }
  
  protected void onStopLoading()
  {
    cancelLoad();
  }
}
