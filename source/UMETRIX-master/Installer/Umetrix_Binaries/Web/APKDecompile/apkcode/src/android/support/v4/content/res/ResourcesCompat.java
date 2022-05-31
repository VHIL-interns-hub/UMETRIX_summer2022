package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class ResourcesCompat
{
  public static Drawable a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ResourcesCompatApi21.a(paramResources, paramInt, paramTheme);
    }
    return paramResources.getDrawable(paramInt);
  }
}
