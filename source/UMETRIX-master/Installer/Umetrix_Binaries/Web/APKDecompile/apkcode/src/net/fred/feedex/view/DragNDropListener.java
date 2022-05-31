package net.fred.feedex.view;

import android.view.View;
import android.widget.ListView;

public abstract interface DragNDropListener
{
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, ListView paramListView);
  
  public abstract void a(View paramView);
  
  public abstract void b(View paramView);
}
