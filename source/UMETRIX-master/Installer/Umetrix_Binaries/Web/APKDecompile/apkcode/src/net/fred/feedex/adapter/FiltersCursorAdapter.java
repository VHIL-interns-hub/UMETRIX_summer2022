package net.fred.feedex.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class FiltersCursorAdapter
  extends ResourceCursorAdapter
{
  private int a;
  private int b;
  private int c;
  private int d = -1;
  
  public FiltersCursorAdapter(Context paramContext, Cursor paramCursor)
  {
    super(paramContext, 2130968616, paramCursor, 0);
    a(paramCursor);
  }
  
  private void a(Cursor paramCursor)
  {
    if ((paramCursor != null) && (paramCursor.getCount() > 0))
    {
      this.a = paramCursor.getColumnIndex("filtertext");
      this.b = paramCursor.getColumnIndex("isappliedtotitle");
      this.c = paramCursor.getColumnIndex("isacceptrule");
    }
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(16908308);
    TextView localTextView2 = (TextView)paramView.findViewById(16908309);
    TextView localTextView3 = (TextView)paramView.findViewById(2131689597);
    label69:
    int j;
    if (paramCursor.getPosition() == this.d)
    {
      paramView.setBackgroundResource(17170451);
      if (paramCursor.getInt(this.c) != 1) {
        break label158;
      }
      i = 1;
      if (i == 0) {
        break label164;
      }
      j = 2131165205;
      label78:
      localTextView1.setText(j);
      if (i == 0) {
        break label171;
      }
      i = paramContext.getResources().getColor(17170453);
      label101:
      localTextView1.setTextColor(i);
      localTextView2.setText(paramCursor.getString(this.a));
      if (paramCursor.getInt(this.b) != 1) {
        break label185;
      }
    }
    label158:
    label164:
    label171:
    label185:
    for (int i = 2131165239;; i = 2131165238)
    {
      localTextView3.setText(i);
      return;
      paramView.setBackgroundResource(17170445);
      break;
      i = 0;
      break label69;
      j = 2131165286;
      break label78;
      i = paramContext.getResources().getColor(17170455);
      break label101;
    }
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    a(paramCursor);
    super.changeCursor(paramCursor);
  }
  
  public void notifyDataSetChanged()
  {
    a(null);
    super.notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    a(null);
    super.notifyDataSetInvalidated();
  }
  
  public Cursor swapCursor(Cursor paramCursor)
  {
    a(paramCursor);
    return super.swapCursor(paramCursor);
  }
}
