package net.fred.feedex.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import net.fred.feedex.provider.FeedData.FeedColumns;
import net.fred.feedex.utils.UiUtils;

public class FeedsCursorAdapter
  extends CursorLoaderExpandableListAdapter
{
  private int a = -1;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  
  public FeedsCursorAdapter(Activity paramActivity, Uri paramUri)
  {
    super(paramActivity, paramUri, 2130968615, 2130968615);
  }
  
  private void c(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    try
    {
      if (this.a == -1)
      {
        this.a = paramCursor.getColumnIndex("isgroup");
        this.b = paramCursor.getColumnIndex("name");
        this.c = paramCursor.getColumnIndex("_id");
        this.d = paramCursor.getColumnIndex("url");
        this.e = paramCursor.getColumnIndex("icon");
      }
      return;
    }
    finally
    {
      paramCursor = finally;
      throw paramCursor;
    }
  }
  
  protected Uri a(Cursor paramCursor)
  {
    return FeedData.FeedColumns.c(paramCursor.getLong(this.c));
  }
  
  protected void a(Context paramContext, Cursor paramCursor)
  {
    c(paramCursor);
  }
  
  protected void a(View paramView, Context paramContext, Cursor paramCursor)
  {
    paramView.findViewById(2131689595).setVisibility(4);
    TextView localTextView = (TextView)paramView.findViewById(16908308);
    paramView = UiUtils.a(paramCursor.getLong(this.c), paramCursor, this.e);
    if (paramView != null)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(paramContext.getResources(), paramView), null, null, null);
      if (!paramCursor.isNull(this.b)) {
        break label107;
      }
    }
    label107:
    for (paramView = paramCursor.getString(this.d);; paramView = paramCursor.getString(this.b))
    {
      localTextView.setText(paramView);
      return;
      localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break;
    }
  }
  
  protected void a(View paramView, Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131689595);
    if (paramCursor.getInt(this.a) == 1)
    {
      localImageView.setVisibility(0);
      paramView = (TextView)paramView.findViewById(16908308);
      paramView.setEnabled(true);
      paramView.setText(paramCursor.getString(this.b));
      paramView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      paramView.setText(paramCursor.getString(this.b));
      if (paramBoolean)
      {
        localImageView.setImageResource(2130837595);
        return;
      }
      localImageView.setImageResource(2130837594);
      return;
    }
    a(paramView, paramContext, paramCursor);
    localImageView.setVisibility(8);
  }
  
  public void b(Cursor paramCursor)
  {
    c(paramCursor);
  }
  
  public void notifyDataSetChanged()
  {
    c(null);
    super.notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    c(null);
    super.notifyDataSetInvalidated();
  }
}
