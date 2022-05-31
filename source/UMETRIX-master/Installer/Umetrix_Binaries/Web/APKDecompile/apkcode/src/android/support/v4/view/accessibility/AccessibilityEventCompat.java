package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class AccessibilityEventCompat
{
  private static final AccessibilityEventCompat.AccessibilityEventVersionImpl a = new AccessibilityEventCompat.AccessibilityEventStubImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new AccessibilityEventCompat.AccessibilityEventKitKatImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new AccessibilityEventCompat.AccessibilityEventIcsImpl();
      return;
    }
  }
  
  public static AccessibilityRecordCompat a(AccessibilityEvent paramAccessibilityEvent)
  {
    return new AccessibilityRecordCompat(paramAccessibilityEvent);
  }
}
