package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

public class NestedScrollingParentHelper
{
  private final ViewGroup a;
  private int b;
  
  public NestedScrollingParentHelper(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(View paramView)
  {
    this.b = 0;
  }
  
  public void a(View paramView1, View paramView2, int paramInt)
  {
    this.b = paramInt;
  }
}
