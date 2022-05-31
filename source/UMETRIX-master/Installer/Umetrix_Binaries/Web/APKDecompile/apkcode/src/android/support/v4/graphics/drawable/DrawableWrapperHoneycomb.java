package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class DrawableWrapperHoneycomb
  extends DrawableWrapperDonut
{
  DrawableWrapperHoneycomb(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  DrawableWrapperHoneycomb(DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState, Resources paramResources)
  {
    super(paramDrawableWrapperState, paramResources);
  }
  
  DrawableWrapperDonut.DrawableWrapperState b()
  {
    return new DrawableWrapperHoneycomb.DrawableWrapperStateHoneycomb(this.b, null);
  }
  
  public void jumpToCurrentState()
  {
    this.c.jumpToCurrentState();
  }
}
