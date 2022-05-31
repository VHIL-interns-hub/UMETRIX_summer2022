package net.fred.feedex.adapter;

import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

public abstract class CursorLoaderExpandableListAdapter
  extends BaseExpandableListAdapter
{
  private final Activity a;
  private final LoaderManager.LoaderCallbacks b = new CursorLoaderExpandableListAdapter.1(this);
  private final LoaderManager c;
  private final Uri d;
  private final int e;
  private final int f;
  private final int g;
  private final LayoutInflater h;
  private final SparseArray i = new SparseArray();
  private Cursor j;
  private final LoaderManager.LoaderCallbacks k = new CursorLoaderExpandableListAdapter.2(this);
  
  public CursorLoaderExpandableListAdapter(Activity paramActivity, Uri paramUri, int paramInt1, int paramInt2)
  {
    this(paramActivity, paramUri, paramInt1, paramInt1, paramInt2);
  }
  
  public CursorLoaderExpandableListAdapter(Activity paramActivity, Uri paramUri, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramActivity;
    this.c = paramActivity.getLoaderManager();
    this.d = paramUri;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = ((LayoutInflater)paramActivity.getSystemService("layout_inflater"));
    this.c.restartLoader(0, null, this.k);
  }
  
  private void a()
  {
    int m = 0;
    while (m < this.i.size())
    {
      int n = this.i.keyAt(m);
      this.i.put(n, new Pair(((Pair)this.i.get(n)).first, Boolean.valueOf(true)));
      m += 1;
    }
  }
  
  public Cursor a(int paramInt)
  {
    if ((this.j != null) && (!this.j.isClosed())) {
      this.j.moveToPosition(paramInt);
    }
    return this.j;
  }
  
  public Cursor a(int paramInt1, int paramInt2)
  {
    Pair localPair = (Pair)this.i.get(paramInt1);
    if ((localPair != null) && (!((Cursor)localPair.first).isClosed()))
    {
      ((Cursor)localPair.first).moveToPosition(paramInt2);
      return (Cursor)localPair.first;
    }
    return null;
  }
  
  protected abstract Uri a(Cursor paramCursor);
  
  public View a(ViewGroup paramViewGroup)
  {
    return this.h.inflate(this.g, paramViewGroup, false);
  }
  
  public View a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = this.h;
    if (paramBoolean) {}
    for (int m = this.f;; m = this.e) {
      return localLayoutInflater.inflate(m, paramViewGroup, false);
    }
  }
  
  protected abstract void a(Context paramContext, Cursor paramCursor);
  
  protected abstract void a(View paramView, Context paramContext, Cursor paramCursor);
  
  protected abstract void a(View paramView, Context paramContext, Cursor paramCursor, boolean paramBoolean);
  
  public void b(Cursor paramCursor) {}
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Pair localPair = (Pair)this.i.get(paramInt1);
    if ((localPair != null) && (!((Cursor)localPair.first).isClosed()) && (((Cursor)localPair.first).moveToPosition(paramInt2))) {
      return ((Cursor)localPair.first).getLong(((Cursor)localPair.first).getColumnIndex("_id"));
    }
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Pair localPair = (Pair)this.i.get(paramInt1);
    if ((localPair == null) || (((Cursor)localPair.first).isClosed()) || (!((Cursor)localPair.first).moveToPosition(paramInt2))) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramViewGroup);
    }
    a(localView, this.a, (Cursor)localPair.first);
    return localView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    Pair localPair = (Pair)this.i.get(paramInt);
    if (((localPair == null) || (((Boolean)localPair.second).booleanValue())) && (this.j != null) && (!this.j.isClosed()) && (this.j.moveToPosition(paramInt)))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("uri", a(this.j));
      this.c.restartLoader(paramInt + 1, localBundle, this.b);
    }
    if ((localPair != null) && (!((Cursor)localPair.first).isClosed())) {
      return ((Cursor)localPair.first).getCount();
    }
    return 0;
  }
  
  public int getGroupCount()
  {
    if ((this.j != null) && (!this.j.isClosed())) {
      return this.j.getCount();
    }
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    if ((this.j != null) && (!this.j.isClosed()) && (this.j.moveToPosition(paramInt))) {
      return this.j.getLong(this.j.getColumnIndex("_id"));
    }
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.j == null) || (this.j.isClosed()) || (!this.j.moveToPosition(paramInt))) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramBoolean, paramViewGroup);
    }
    a(localView, this.a, this.j, paramBoolean);
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void onGroupCollapsed(int paramInt)
  {
    this.c.destroyLoader(paramInt + 1);
    this.i.delete(paramInt);
  }
}
