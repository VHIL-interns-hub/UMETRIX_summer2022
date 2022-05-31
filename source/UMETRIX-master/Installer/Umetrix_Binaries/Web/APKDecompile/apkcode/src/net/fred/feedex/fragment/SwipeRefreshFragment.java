package net.fred.feedex.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.fred.feedex.view.SwipeRefreshLayout;
import net.fred.feedex.view.SwipeRefreshLayout.OnRefreshListener;

public abstract class SwipeRefreshFragment
  extends Fragment
  implements SwipeRefreshLayout.OnRefreshListener
{
  private SwipeRefreshLayout a;
  
  public SwipeRefreshFragment() {}
  
  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle);
  
  public void h()
  {
    this.a.setRefreshing(true);
  }
  
  public void i()
  {
    this.a.setRefreshing(false);
  }
  
  public void j()
  {
    this.a.setEnabled(false);
  }
  
  public boolean k()
  {
    return this.a.b();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = new SwipeRefreshLayout(paramLayoutInflater.getContext());
    a(paramLayoutInflater, this.a, paramBundle);
    return this.a;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.a.a(17170459, 17170451, 17170459, 17170451);
    this.a.setOnRefreshListener(this);
  }
}
