package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.v7.appcompat.R.style;
import android.view.LayoutInflater;

public class ContextThemeWrapper
  extends ContextWrapper
{
  private int a;
  private Resources.Theme b;
  private LayoutInflater c;
  
  public ContextThemeWrapper(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramInt;
  }
  
  public ContextThemeWrapper(Context paramContext, Resources.Theme paramTheme)
  {
    super(paramContext);
    this.b = paramTheme;
  }
  
  private void b()
  {
    if (this.b == null) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.b = getResources().newTheme();
        Resources.Theme localTheme = getBaseContext().getTheme();
        if (localTheme != null) {
          this.b.setTo(localTheme);
        }
      }
      a(this.b, this.a, bool);
      return;
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  protected void a(Resources.Theme paramTheme, int paramInt, boolean paramBoolean)
  {
    paramTheme.applyStyle(paramInt, true);
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.c == null) {
        this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return this.c;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public Resources.Theme getTheme()
  {
    if (this.b != null) {
      return this.b;
    }
    if (this.a == 0) {
      this.a = R.style.Theme_AppCompat_Light;
    }
    b();
    return this.b;
  }
  
  public void setTheme(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      b();
    }
  }
}
