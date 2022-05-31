package net.fred.feedex.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import net.fred.feedex.view.SwipeRefreshLayout;
import net.fred.feedex.view.SwipeRefreshLayout.OnRefreshListener;

public abstract class SwipeRefreshListFragment
  extends ListFragment
  implements SwipeRefreshLayout.OnRefreshListener
{
  private SwipeRefreshLayout a;
  private ListView b;
  
  public SwipeRefreshListFragment() {}
  
  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle);
  
  public void c()
  {
    this.a.setRefreshing(true);
  }
  
  public void d()
  {
    this.a.setRefreshing(false);
  }
  
  public void e()
  {
    this.a.setEnabled(false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = new SwipeRefreshListFragment.1(this, paramLayoutInflater.getContext());
    a(paramLayoutInflater, this.a, paramBundle);
    this.b = ((ListView)this.a.findViewById(16908298));
    if (this.b != null) {
      this.b.addHeaderView(new View(this.b.getContext()));
    }
    return this.a;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.a.a(17170459, 17170451, 17170459, 17170451);
    this.a.setOnRefreshListener(this);
  }
}
