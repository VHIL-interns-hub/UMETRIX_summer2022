package android.support.v7.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R.string;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;

public class ActivityChooserView
  extends ViewGroup
{
  ActionProvider a;
  private final ActivityChooserView.ActivityChooserViewAdapter b;
  private final ActivityChooserView.Callbacks c;
  private final LinearLayoutCompat d;
  private final FrameLayout e;
  private final ImageView f;
  private final FrameLayout g;
  private final int h;
  private final DataSetObserver i;
  private final ViewTreeObserver.OnGlobalLayoutListener j;
  private ListPopupWindow k;
  private PopupWindow.OnDismissListener l;
  private boolean m;
  private int n;
  private boolean o;
  private int p;
  
  private void a(int paramInt)
  {
    if (this.b.d() == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.j);
    boolean bool;
    int i1;
    label59:
    label90:
    ListPopupWindow localListPopupWindow;
    if (this.g.getVisibility() == 0)
    {
      bool = true;
      int i2 = this.b.c();
      if (!bool) {
        break label190;
      }
      i1 = 1;
      if ((paramInt == Integer.MAX_VALUE) || (i2 <= i1 + paramInt)) {
        break label195;
      }
      this.b.a(true);
      this.b.a(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!localListPopupWindow.k())
      {
        if ((!this.m) && (bool)) {
          break label214;
        }
        this.b.a(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.f(Math.min(this.b.a(), this.h));
      localListPopupWindow.c();
      if (this.a != null) {
        this.a.a(true);
      }
      localListPopupWindow.m().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
      return;
      bool = false;
      break;
      label190:
      i1 = 0;
      break label59;
      label195:
      this.b.a(false);
      this.b.a(paramInt);
      break label90;
      label214:
      this.b.a(false, false);
    }
  }
  
  private ListPopupWindow getListPopupWindow()
  {
    if (this.k == null)
    {
      this.k = new ListPopupWindow(getContext());
      this.k.a(this.b);
      this.k.a(this);
      this.k.a(true);
      this.k.a(this.c);
      this.k.a(this.c);
    }
    return this.k;
  }
  
  public boolean a()
  {
    if ((c()) || (!this.o)) {
      return false;
    }
    this.m = false;
    a(this.n);
    return true;
  }
  
  public boolean b()
  {
    if (c())
    {
      getListPopupWindow().i();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.j);
      }
    }
    return true;
  }
  
  public boolean c()
  {
    return getListPopupWindow().k();
  }
  
  public ActivityChooserModel getDataModel()
  {
    return this.b.d();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ActivityChooserModel localActivityChooserModel = this.b.d();
    if (localActivityChooserModel != null) {
      localActivityChooserModel.registerObserver(this.i);
    }
    this.o = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.b.d();
    if (localObject != null) {
      ((ActivityChooserModel)localObject).unregisterObserver(this.i);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.j);
    }
    if (c()) {
      b();
    }
    this.o = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.d.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!c()) {
      b();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    LinearLayoutCompat localLinearLayoutCompat = this.d;
    int i1 = paramInt2;
    if (this.g.getVisibility() != 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localLinearLayoutCompat, paramInt1, i1);
    setMeasuredDimension(localLinearLayoutCompat.getMeasuredWidth(), localLinearLayoutCompat.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel)
  {
    this.b.a(paramActivityChooserModel);
    if (c())
    {
      b();
      a();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.f.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.f.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.l = paramOnDismissListener;
  }
  
  public void setProvider(ActionProvider paramActionProvider)
  {
    this.a = paramActionProvider;
  }
}
