package com.bumptech.glide.request.target;

import android.view.View;
import com.bumptech.glide.request.Request;

public abstract class ViewTarget
  extends BaseTarget
{
  private static boolean b = false;
  private static Integer c = null;
  protected final View a;
  private final ViewTarget.SizeDeterminer d;
  
  public ViewTarget(View paramView)
  {
    if (paramView == null) {
      throw new NullPointerException("View must not be null!");
    }
    this.a = paramView;
    this.d = new ViewTarget.SizeDeterminer(paramView);
  }
  
  private void a(Object paramObject)
  {
    if (c == null)
    {
      b = true;
      this.a.setTag(paramObject);
      return;
    }
    this.a.setTag(c.intValue(), paramObject);
  }
  
  private Object g()
  {
    if (c == null) {
      return this.a.getTag();
    }
    return this.a.getTag(c.intValue());
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(Request paramRequest)
  {
    a(paramRequest);
  }
  
  public void a(SizeReadyCallback paramSizeReadyCallback)
  {
    this.d.a(paramSizeReadyCallback);
  }
  
  public Request c()
  {
    Object localObject = g();
    if (localObject != null)
    {
      if ((localObject instanceof Request)) {
        return (Request)localObject;
      }
      throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }
    return null;
  }
  
  public String toString()
  {
    return "Target for: " + this.a;
  }
}
