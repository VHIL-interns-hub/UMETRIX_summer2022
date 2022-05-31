package android.support.v7.widget;

import android.content.res.Resources.Theme;
import android.widget.SpinnerAdapter;

public abstract interface ThemedSpinnerAdapter
  extends SpinnerAdapter
{
  public abstract Resources.Theme a();
  
  public abstract void a(Resources.Theme paramTheme);
}
