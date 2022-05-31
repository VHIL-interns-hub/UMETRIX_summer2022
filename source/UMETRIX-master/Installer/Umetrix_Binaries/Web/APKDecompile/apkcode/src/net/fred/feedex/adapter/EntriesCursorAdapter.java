package net.fred.feedex.adapter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.TextDrawable.IShapeBuilder;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import net.fred.feedex.utils.NetworkUtils;
import net.fred.feedex.utils.StringUtils;

public class EntriesCursorAdapter
  extends ResourceCursorAdapter
{
  private final Uri a;
  private final boolean b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public EntriesCursorAdapter(Context paramContext, Uri paramUri, Cursor paramCursor, boolean paramBoolean)
  {
    super(paramContext, 2130968614, paramCursor, 0);
    this.a = paramUri;
    this.b = paramBoolean;
    a(paramCursor);
  }
  
  private void a(Cursor paramCursor)
  {
    if ((paramCursor != null) && (paramCursor.getCount() > 0))
    {
      this.c = paramCursor.getColumnIndex("_id");
      this.d = paramCursor.getColumnIndex("title");
      this.e = paramCursor.getColumnIndex("image_url");
      this.f = paramCursor.getColumnIndex("date");
      this.g = paramCursor.getColumnIndex("isread");
      this.h = paramCursor.getColumnIndex("favorite");
      this.j = paramCursor.getColumnIndex("name");
      this.i = paramCursor.getColumnIndex("feedid");
    }
  }
  
  public void a(long paramLong)
  {
    new EntriesCursorAdapter.3(this, paramLong).start();
  }
  
  public void a(long paramLong, View paramView)
  {
    paramView = (EntriesCursorAdapter.ViewHolder)paramView.getTag(2131689476);
    boolean bool;
    if (paramView != null)
    {
      if (paramView.e) {
        break label67;
      }
      bool = true;
      paramView.e = bool;
      if (!paramView.e) {
        break label73;
      }
      paramView.a.setEnabled(false);
      paramView.b.setEnabled(false);
    }
    for (;;)
    {
      new EntriesCursorAdapter.1(this, paramLong, paramView).start();
      return;
      label67:
      bool = false;
      break;
      label73:
      paramView.a.setEnabled(true);
      paramView.b.setEnabled(true);
    }
  }
  
  public void b(long paramLong, View paramView)
  {
    paramView = (EntriesCursorAdapter.ViewHolder)paramView.getTag(2131689476);
    boolean bool;
    if (paramView != null)
    {
      if (paramView.f) {
        break label59;
      }
      bool = true;
      paramView.f = bool;
      if (!paramView.f) {
        break label65;
      }
      paramView.d.setVisibility(0);
    }
    for (;;)
    {
      new EntriesCursorAdapter.2(this, paramView, paramLong).start();
      return;
      label59:
      bool = false;
      break;
      label65:
      paramView.d.setVisibility(4);
    }
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    String str1 = null;
    if (paramView.getTag(2131689476) == null)
    {
      localViewHolder = new EntriesCursorAdapter.ViewHolder(null);
      localViewHolder.a = ((TextView)paramView.findViewById(16908308));
      localViewHolder.b = ((TextView)paramView.findViewById(16908309));
      localViewHolder.c = ((ImageView)paramView.findViewById(2131689593));
      localViewHolder.d = ((ImageView)paramView.findViewById(2131689594));
      paramView.setTag(2131689476, localViewHolder);
    }
    EntriesCursorAdapter.ViewHolder localViewHolder = (EntriesCursorAdapter.ViewHolder)paramView.getTag(2131689476);
    paramView = paramCursor.getString(this.d);
    localViewHolder.a.setText(paramView);
    long l = paramCursor.getLong(this.i);
    String str2 = paramCursor.getString(this.j);
    paramView = paramCursor.getString(this.e);
    int k;
    label192:
    label238:
    boolean bool;
    if (TextUtils.isEmpty(paramView))
    {
      k = ColorGenerator.a.a(Long.valueOf(l));
      if (str2 == null) {
        break label433;
      }
      if (str2.length() >= 2) {
        break label419;
      }
      paramView = str2.toUpperCase();
      paramView = TextDrawable.a().a(paramView, k);
      if (str1 == null) {
        break label440;
      }
      Glide.b(paramContext).a(str1).a().a(paramView).b(paramView).a(localViewHolder.c);
      if (paramCursor.getInt(this.h) != 1) {
        break label460;
      }
      bool = true;
      label255:
      localViewHolder.f = bool;
      paramView = localViewHolder.d;
      if (!localViewHolder.f) {
        break label466;
      }
      k = 0;
      label279:
      paramView.setVisibility(k);
      if ((!this.b) || (this.j <= -1)) {
        break label496;
      }
      if (str2 == null) {
        break label472;
      }
      localViewHolder.b.setText(Html.fromHtml("<font color='#247ab0'>" + str2 + "</font>" + ", " + StringUtils.a(paramCursor.getLong(this.f))));
    }
    for (;;)
    {
      if (!paramCursor.isNull(this.g)) {
        break label520;
      }
      localViewHolder.a.setEnabled(true);
      localViewHolder.b.setEnabled(true);
      localViewHolder.e = false;
      return;
      str1 = NetworkUtils.a(paramCursor.getLong(this.c), paramView);
      break;
      label419:
      paramView = str2.substring(0, 2).toUpperCase();
      break label192;
      label433:
      paramView = "";
      break label192;
      label440:
      Glide.a(localViewHolder.c);
      localViewHolder.c.setImageDrawable(paramView);
      break label238;
      label460:
      bool = false;
      break label255;
      label466:
      k = 4;
      break label279;
      label472:
      localViewHolder.b.setText(StringUtils.a(paramCursor.getLong(this.f)));
      continue;
      label496:
      localViewHolder.b.setText(StringUtils.a(paramCursor.getLong(this.f)));
    }
    label520:
    localViewHolder.a.setEnabled(false);
    localViewHolder.b.setEnabled(false);
    localViewHolder.e = true;
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
