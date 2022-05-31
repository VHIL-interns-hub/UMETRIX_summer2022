package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

public class AccessibilityNodeProviderCompat
{
  private static final AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl a = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl();
  private final Object b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl();
      return;
    }
  }
  
  public AccessibilityNodeProviderCompat()
  {
    this.b = a.a(this);
  }
  
  public AccessibilityNodeProviderCompat(Object paramObject)
  {
    this.b = paramObject;
  }
  
  public AccessibilityNodeInfoCompat a(int paramInt)
  {
    return null;
  }
  
  public Object a()
  {
    return this.b;
  }
  
  public List a(String paramString, int paramInt)
  {
    return null;
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  public AccessibilityNodeInfoCompat b(int paramInt)
  {
    return null;
  }
}
