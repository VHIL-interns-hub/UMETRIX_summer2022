package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;

public abstract class BaseTarget
  implements Target
{
  private Request a;
  
  public BaseTarget() {}
  
  public void a(Drawable paramDrawable) {}
  
  public void a(Request paramRequest)
  {
    this.a = paramRequest;
  }
  
  public void a(Exception paramException, Drawable paramDrawable) {}
  
  public void b(Drawable paramDrawable) {}
  
  public Request c()
  {
    return this.a;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
}
