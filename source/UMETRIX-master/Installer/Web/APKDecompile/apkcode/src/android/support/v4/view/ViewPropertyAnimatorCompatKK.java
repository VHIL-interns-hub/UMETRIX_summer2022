package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

class ViewPropertyAnimatorCompatKK
{
  public static void a(View paramView, ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
  {
    ViewPropertyAnimatorCompatKK.1 local1 = null;
    if (paramViewPropertyAnimatorUpdateListener != null) {
      local1 = new ViewPropertyAnimatorCompatKK.1(paramViewPropertyAnimatorUpdateListener, paramView);
    }
    paramView.animate().setUpdateListener(local1);
  }
}
