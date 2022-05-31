package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.util.Util;

class ResourceRecycler
{
  private boolean a;
  private final Handler b = new Handler(Looper.getMainLooper(), new ResourceRecycler.ResourceRecyclerCallback(null));
  
  ResourceRecycler() {}
  
  public void a(Resource paramResource)
  {
    
    if (this.a)
    {
      this.b.obtainMessage(1, paramResource).sendToTarget();
      return;
    }
    this.a = true;
    paramResource.d();
    this.a = false;
  }
}
