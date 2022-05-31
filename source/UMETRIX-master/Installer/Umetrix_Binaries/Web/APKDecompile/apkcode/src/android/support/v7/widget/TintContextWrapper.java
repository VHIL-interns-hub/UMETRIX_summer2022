package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper
  extends ContextWrapper
{
  private static final ArrayList a = new ArrayList();
  private Resources b;
  private final Resources.Theme c = getResources().newTheme();
  
  private TintContextWrapper(Context paramContext)
  {
    super(paramContext);
    this.c.setTo(paramContext.getTheme());
  }
  
  public static Context a(Context paramContext)
  {
    Object localObject = paramContext;
    int j;
    int i;
    if (b(paramContext))
    {
      j = a.size();
      i = 0;
    }
    while (i < j)
    {
      localObject = (WeakReference)a.get(i);
      if (localObject != null) {}
      for (localObject = (TintContextWrapper)((WeakReference)localObject).get(); (localObject != null) && (((TintContextWrapper)localObject).getBaseContext() == paramContext); localObject = null) {
        return localObject;
      }
      i += 1;
    }
    paramContext = new TintContextWrapper(paramContext);
    a.add(new WeakReference(paramContext));
    return paramContext;
  }
  
  private static boolean b(Context paramContext)
  {
    if ((paramContext instanceof TintContextWrapper)) {}
    while ((paramContext.getResources() instanceof TintResources)) {
      return false;
    }
    return true;
  }
  
  public Resources getResources()
  {
    if (this.b == null) {
      this.b = new TintResources(this, super.getResources());
    }
    return this.b;
  }
  
  public Resources.Theme getTheme()
  {
    return this.c;
  }
  
  public void setTheme(int paramInt)
  {
    this.c.applyStyle(paramInt, true);
  }
}
