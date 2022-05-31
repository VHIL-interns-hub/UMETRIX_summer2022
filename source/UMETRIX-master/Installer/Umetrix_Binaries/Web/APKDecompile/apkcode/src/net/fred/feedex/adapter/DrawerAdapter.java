package net.fred.feedex.adapter;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Map;
import net.fred.feedex.MainApplication;
import net.fred.feedex.provider.FeedData.EntryColumns;
import net.fred.feedex.utils.StringUtils;
import net.fred.feedex.utils.UiUtils;

public class DrawerAdapter
  extends BaseAdapter
{
  private static final int a = Color.parseColor("#EEEEEE");
  private static final int b = Color.parseColor("#BBBBBB");
  private static final String c = MainApplication.a().getString(2131165213);
  private final Map d = new DrawerAdapter.1(this, 101, 0.75F, true);
  private final Context e;
  private Cursor f;
  private int g;
  private int h;
  
  public DrawerAdapter(Context paramContext, Cursor paramCursor)
  {
    this.e = paramContext;
    this.f = paramCursor;
    a();
  }
  
  private void a()
  {
    this.h = 0;
    this.g = 0;
    Cursor localCursor = this.e.getContentResolver().query(FeedData.EntryColumns.c, new String[] { "(SELECT COUNT(*) FROM entries WHERE isread IS NULL)", "(SELECT COUNT(*) FROM entries WHERE favorite=1)" }, null, null, null);
    if (localCursor != null)
    {
      if (localCursor.moveToFirst())
      {
        this.g = localCursor.getInt(0);
        this.h = localCursor.getInt(1);
      }
      localCursor.close();
    }
  }
  
  public String a(int paramInt)
  {
    if ((this.f != null) && (this.f.moveToPosition(paramInt - 3)))
    {
      if (this.f.isNull(2)) {
        return this.f.getString(1);
      }
      return this.f.getString(2);
    }
    return null;
  }
  
  public void a(Cursor paramCursor)
  {
    this.f = paramCursor;
    a();
    notifyDataSetChanged();
  }
  
  public boolean b(int paramInt)
  {
    return (this.f != null) && (this.f.moveToPosition(paramInt - 3)) && (this.f.getInt(3) == 1);
  }
  
  public int getCount()
  {
    if (this.f != null) {
      return this.f.getCount() + 3;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.f != null) && (this.f.moveToPosition(paramInt - 3))) {
      return this.f.getLong(0);
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = ((LayoutInflater)this.e.getSystemService("layout_inflater")).inflate(2130968613, paramViewGroup, false);
      paramView = new DrawerAdapter.ViewHolder(null);
      paramView.a = ((ImageView)localView.findViewById(16908294));
      paramView.b = ((TextView)localView.findViewById(16908308));
      paramView.c = ((TextView)localView.findViewById(16908309));
      paramView.d = ((TextView)localView.findViewById(2131689591));
      paramView.e = localView.findViewById(2131689592);
      localView.setTag(2131689476, paramView);
    }
    DrawerAdapter.ViewHolder localViewHolder = (DrawerAdapter.ViewHolder)localView.getTag(2131689476);
    localViewHolder.a.setImageDrawable(null);
    localViewHolder.b.setText("");
    localViewHolder.b.setTextColor(a);
    localViewHolder.b.setAllCaps(false);
    localViewHolder.c.setVisibility(8);
    localViewHolder.d.setText("");
    localView.setPadding(0, 0, 0, 0);
    localViewHolder.e.setVisibility(8);
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 2)) {}
    switch (paramInt)
    {
    default: 
      if ((this.f != null) && (this.f.moveToPosition(paramInt - 3)))
      {
        paramViewGroup = localViewHolder.b;
        if (!this.f.isNull(2)) {
          break label460;
        }
      }
      break;
    }
    label460:
    for (paramView = this.f.getString(1);; paramView = this.f.getString(2))
    {
      paramViewGroup.setText(paramView);
      if (this.f.getInt(3) != 1) {
        break label474;
      }
      localViewHolder.b.setTextColor(b);
      localViewHolder.b.setAllCaps(true);
      localViewHolder.e.setVisibility(0);
      return localView;
      localViewHolder.b.setText(2131165332);
      localViewHolder.a.setImageResource(2130837598);
      if (this.g == 0) {
        break;
      }
      localViewHolder.d.setText(String.valueOf(this.g));
      break;
      localViewHolder.b.setText(2131165208);
      localViewHolder.a.setImageResource(2130837598);
      break;
      localViewHolder.b.setText(2131165230);
      localViewHolder.a.setImageResource(2130837600);
      if (this.h == 0) {
        break;
      }
      localViewHolder.d.setText(String.valueOf(this.h));
      break;
    }
    label474:
    localViewHolder.c.setVisibility(0);
    long l;
    if (this.f.isNull(6))
    {
      l = this.f.getLong(5);
      paramViewGroup = (String)this.d.get(Long.valueOf(l));
      paramView = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = this.e.getString(2131165333) + c;
        if (l == 0L)
        {
          paramView = paramView + this.e.getString(2131165272);
          label596:
          this.d.put(Long.valueOf(l), paramView);
        }
      }
      else
      {
        localViewHolder.c.setText(paramView);
        label621:
        paramView = UiUtils.a(this.f.getLong(0), this.f, 4);
        if (paramView == null) {
          break label758;
        }
        localViewHolder.a.setImageBitmap(paramView);
      }
    }
    for (;;)
    {
      paramInt = this.f.getInt(7);
      if (paramInt == 0) {
        break;
      }
      localViewHolder.d.setText(String.valueOf(paramInt));
      return localView;
      paramView = paramView + StringUtils.a(l);
      break label596;
      localViewHolder.c.setText(new StringBuilder(this.e.getString(2131165223)).append(c).append(this.f.getString(6)));
      break label621;
      label758:
      localViewHolder.a.setImageResource(2130903040);
    }
  }
}
