package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class FragmentTransitionCompat21
{
  public static Object a(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject != null) {
      localObject = ((Transition)paramObject).clone();
    }
    return localObject;
  }
  
  public static Object a(Object paramObject, View paramView1, ArrayList paramArrayList, Map paramMap, View paramView2)
  {
    Object localObject = paramObject;
    if (paramObject != null)
    {
      b(paramArrayList, paramView1);
      if (paramMap != null) {
        paramArrayList.removeAll(paramMap.values());
      }
      if (paramArrayList.isEmpty()) {
        localObject = null;
      }
    }
    else
    {
      return localObject;
    }
    paramArrayList.add(paramView2);
    b((Transition)paramObject, paramArrayList);
    return paramObject;
  }
  
  public static Object a(Object paramObject1, Object paramObject2, Object paramObject3, boolean paramBoolean)
  {
    Transition localTransition = (Transition)paramObject1;
    paramObject1 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    if ((localTransition != null) && (paramObject1 != null)) {}
    for (;;)
    {
      if (paramBoolean)
      {
        paramObject2 = new TransitionSet();
        if (localTransition != null) {
          paramObject2.addTransition(localTransition);
        }
        if (paramObject1 != null) {
          paramObject2.addTransition(paramObject1);
        }
        if (paramObject3 != null) {
          paramObject2.addTransition(paramObject3);
        }
        return paramObject2;
      }
      paramObject2 = null;
      if ((paramObject1 != null) && (localTransition != null)) {
        paramObject1 = new TransitionSet().addTransition(paramObject1).addTransition(localTransition).setOrdering(1);
      }
      while (paramObject3 != null)
      {
        paramObject2 = new TransitionSet();
        if (paramObject1 != null) {
          paramObject2.addTransition(paramObject1);
        }
        paramObject2.addTransition(paramObject3);
        return paramObject2;
        if (paramObject1 == null)
        {
          paramObject1 = paramObject2;
          if (localTransition != null) {
            paramObject1 = localTransition;
          }
        }
      }
      return paramObject1;
      paramBoolean = true;
    }
  }
  
  public static String a(View paramView)
  {
    return paramView.getTransitionName();
  }
  
  private static void a(Transition paramTransition, FragmentTransitionCompat21.EpicenterView paramEpicenterView)
  {
    if (paramTransition != null) {
      paramTransition.setEpicenterCallback(new FragmentTransitionCompat21.3(paramEpicenterView));
    }
  }
  
  public static void a(View paramView1, View paramView2, Object paramObject1, ArrayList paramArrayList1, Object paramObject2, ArrayList paramArrayList2, Object paramObject3, ArrayList paramArrayList3, Object paramObject4, ArrayList paramArrayList4, Map paramMap)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    paramObject4 = (Transition)paramObject4;
    if (paramObject4 != null) {
      paramView1.getViewTreeObserver().addOnPreDrawListener(new FragmentTransitionCompat21.4(paramView1, paramObject1, paramArrayList1, paramObject2, paramArrayList2, paramObject3, paramArrayList3, paramMap, paramArrayList4, paramObject4, paramView2));
    }
  }
  
  public static void a(ViewGroup paramViewGroup, Object paramObject)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }
  
  public static void a(Object paramObject, View paramView)
  {
    ((Transition)paramObject).setEpicenterCallback(new FragmentTransitionCompat21.1(c(paramView)));
  }
  
  public static void a(Object paramObject, View paramView, Map paramMap, ArrayList paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    paramArrayList.clear();
    paramArrayList.addAll(paramMap.values());
    paramMap = paramObject.getTargets();
    paramMap.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      a(paramMap, (View)paramArrayList.get(i));
      i += 1;
    }
    paramArrayList.add(paramView);
    b(paramObject, paramArrayList);
  }
  
  public static void a(Object paramObject, View paramView, boolean paramBoolean)
  {
    ((Transition)paramObject).excludeTarget(paramView, paramBoolean);
  }
  
  public static void a(Object paramObject1, Object paramObject2, View paramView1, FragmentTransitionCompat21.ViewRetriever paramViewRetriever, View paramView2, FragmentTransitionCompat21.EpicenterView paramEpicenterView, Map paramMap1, ArrayList paramArrayList1, Map paramMap2, Map paramMap3, ArrayList paramArrayList2)
  {
    if ((paramObject1 != null) || (paramObject2 != null))
    {
      paramObject1 = (Transition)paramObject1;
      if (paramObject1 != null) {
        paramObject1.addTarget(paramView2);
      }
      if (paramObject2 != null) {
        a(paramObject2, paramView2, paramMap2, paramArrayList2);
      }
      if (paramViewRetriever != null) {
        paramView1.getViewTreeObserver().addOnPreDrawListener(new FragmentTransitionCompat21.2(paramView1, paramObject1, paramView2, paramViewRetriever, paramMap1, paramMap3, paramArrayList1));
      }
      a(paramObject1, paramEpicenterView);
    }
  }
  
  public static void a(Object paramObject, ArrayList paramArrayList)
  {
    paramObject = (Transition)paramObject;
    int i;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      int j = paramObject.getTransitionCount();
      i = 0;
      while (i < j)
      {
        a(paramObject.getTransitionAt(i), paramArrayList);
        i += 1;
      }
    }
    if (!a(paramObject))
    {
      List localList = paramObject.getTargets();
      if ((localList != null) && (localList.size() == paramArrayList.size()) && (localList.containsAll(paramArrayList)))
      {
        i = paramArrayList.size() - 1;
        while (i >= 0)
        {
          paramObject.removeTarget((View)paramArrayList.get(i));
          i -= 1;
        }
      }
    }
  }
  
  private static void a(List paramList, View paramView)
  {
    int k = paramList.size();
    if (a(paramList, paramView, k)) {}
    for (;;)
    {
      return;
      paramList.add(paramView);
      int i = k;
      while (i < paramList.size())
      {
        paramView = (View)paramList.get(i);
        if ((paramView instanceof ViewGroup))
        {
          paramView = (ViewGroup)paramView;
          int m = paramView.getChildCount();
          int j = 0;
          while (j < m)
          {
            View localView = paramView.getChildAt(j);
            if (!a(paramList, localView, k)) {
              paramList.add(localView);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  public static void a(Map paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = paramView.getTransitionName();
      if (str != null) {
        paramMap.put(str, paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          a(paramMap, paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  private static boolean a(Transition paramTransition)
  {
    return (!a(paramTransition.getTargetIds())) || (!a(paramTransition.getTargetNames())) || (!a(paramTransition.getTargetTypes()));
  }
  
  private static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  private static boolean a(List paramList, View paramView, int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramInt)
      {
        if (paramList.get(i) == paramView) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static Object b(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      paramObject = (Transition)paramObject;
    } while (paramObject == null);
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition(paramObject);
    return localTransitionSet;
  }
  
  public static void b(Object paramObject, ArrayList paramArrayList)
  {
    int i = 0;
    paramObject = (Transition)paramObject;
    int j;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.getTransitionCount();
      while (i < j)
      {
        b(paramObject.getTransitionAt(i), paramArrayList);
        i += 1;
      }
    }
    if ((!a(paramObject)) && (a(paramObject.getTargets())))
    {
      j = paramArrayList.size();
      i = 0;
      while (i < j)
      {
        paramObject.addTarget((View)paramArrayList.get(i));
        i += 1;
      }
    }
  }
  
  private static void b(ArrayList paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      if (!(paramView instanceof ViewGroup)) {
        break label61;
      }
      paramView = (ViewGroup)paramView;
      if (!paramView.isTransitionGroup()) {
        break label33;
      }
      paramArrayList.add(paramView);
    }
    for (;;)
    {
      return;
      label33:
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        b(paramArrayList, paramView.getChildAt(i));
        i += 1;
      }
    }
    label61:
    paramArrayList.add(paramView);
  }
  
  private static Rect c(View paramView)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    localRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    return localRect;
  }
}
