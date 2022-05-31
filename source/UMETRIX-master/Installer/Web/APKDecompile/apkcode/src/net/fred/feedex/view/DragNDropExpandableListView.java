package net.fred.feedex.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;

public class DragNDropExpandableListView
  extends ExpandableListView
{
  private boolean a;
  private int b;
  private int c;
  private ImageView d;
  private DragNDropListener e;
  
  public DragNDropExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    if (this.d != null)
    {
      if (this.e != null) {
        this.e.a(getChildAt(paramInt));
      }
      this.d.setVisibility(8);
      ((WindowManager)getContext().getSystemService("window")).removeView(this.d);
      this.d.setImageDrawable(null);
      this.d = null;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.d != null)
    {
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.d.getLayoutParams();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = (paramInt2 - this.c);
      ((WindowManager)getContext().getSystemService("window")).updateViewLayout(this.d, localLayoutParams);
      if (this.e != null) {
        this.e.a(paramInt1, paramInt2, null);
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    a(paramInt1);
    View localView = getChildAt(paramInt1);
    if (localView == null) {
      return;
    }
    if (this.e != null) {
      this.e.b(localView);
    }
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.gravity = 48;
    localLayoutParams.x = 0;
    localLayoutParams.y = (paramInt2 - this.c);
    localLayoutParams.height = -2;
    localLayoutParams.width = -2;
    localLayoutParams.flags = 920;
    localLayoutParams.format = -3;
    localLayoutParams.windowAnimations = 0;
    Context localContext = getContext();
    ImageView localImageView = new ImageView(localContext);
    localView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(localView.getDrawingCache());
    localView.setDrawingCacheEnabled(false);
    localImageView.setBackgroundResource(17170451);
    localImageView.setImageBitmap(localBitmap);
    ((WindowManager)localContext.getSystemService("window")).addView(localImageView, localLayoutParams);
    this.d = localImageView;
  }
  
  public long getItemIdAtPosition(int paramInt)
  {
    long l = getExpandableListPosition(paramInt);
    if (ExpandableListView.getPackedPositionType(l) == 0) {
      return getExpandableListAdapter().getGroupId(ExpandableListView.getPackedPositionGroup(l));
    }
    return getExpandableListAdapter().getChildId(ExpandableListView.getPackedPositionGroup(l), ExpandableListView.getPackedPositionChild(l));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (paramMotionEvent.getActionIndex() != 0)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    int j = paramMotionEvent.getAction();
    int k = (int)paramMotionEvent.getX(0);
    int i = (int)paramMotionEvent.getY(0);
    if ((j == 0) && (k > getWidth() - 80)) {
      this.a = true;
    }
    if (!this.a) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (j)
    {
    case 1: 
    default: 
      this.a = false;
      i = pointToPosition(k, i);
      a(this.b - getFirstVisiblePosition());
      if ((this.e != null) && (this.b != -1) && (i != -1)) {
        this.e.a(this.b, i);
      }
      break;
    }
    while ((paramMotionEvent.getPointerCount() <= 1) || (super.onTouchEvent(paramMotionEvent)))
    {
      return true;
      this.b = pointToPosition(k, i);
      if (this.b != -1)
      {
        j = this.b - getFirstVisiblePosition();
        this.c = (i - getChildAt(j).getTop());
        this.c -= (int)paramMotionEvent.getRawY() - i;
        b(j, i);
        a(0, i);
        continue;
        a(0, i);
      }
    }
  }
  
  public void setDragNDropListener(DragNDropListener paramDragNDropListener)
  {
    this.e = paramDragNDropListener;
  }
}
