package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;

class AccessibilityManagerCompatKitKat
{
  AccessibilityManagerCompatKitKat() {}
  
  public static boolean addTouchExplorationStateChangeListener(AccessibilityManager paramAccessibilityManager, Object paramObject)
  {
    return paramAccessibilityManager.addTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)paramObject);
  }
  
  public static Object newTouchExplorationStateChangeListener(TouchExplorationStateChangeListenerBridge paramTouchExplorationStateChangeListenerBridge)
  {
    new AccessibilityManager.TouchExplorationStateChangeListener()
    {
      public void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
      {
        this.val$bridge.onTouchExplorationStateChanged(paramAnonymousBoolean);
      }
    };
  }
  
  public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager paramAccessibilityManager, Object paramObject)
  {
    return paramAccessibilityManager.removeTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)paramObject);
  }
  
  static abstract interface TouchExplorationStateChangeListenerBridge
  {
    public abstract void onTouchExplorationStateChanged(boolean paramBoolean);
  }
  
  public static class TouchExplorationStateChangeListenerWrapper
    implements AccessibilityManager.TouchExplorationStateChangeListener
  {
    final Object mListener;
    final AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerBridge mListenerBridge;
    
    public TouchExplorationStateChangeListenerWrapper(Object paramObject, AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerBridge paramTouchExplorationStateChangeListenerBridge)
    {
      this.mListener = paramObject;
      this.mListenerBridge = paramTouchExplorationStateChangeListenerBridge;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (TouchExplorationStateChangeListenerWrapper)paramObject;
        if (this.mListener != null) {
          break;
        }
      } while (paramObject.mListener == null);
      return false;
      return this.mListener.equals(paramObject.mListener);
    }
    
    public int hashCode()
    {
      if (this.mListener == null) {
        return 0;
      }
      return this.mListener.hashCode();
    }
    
    public void onTouchExplorationStateChanged(boolean paramBoolean)
    {
      this.mListenerBridge.onTouchExplorationStateChanged(paramBoolean);
    }
  }
}
