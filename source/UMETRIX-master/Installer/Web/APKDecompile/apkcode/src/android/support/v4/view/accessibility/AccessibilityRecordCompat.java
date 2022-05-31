package android.support.v4.view.accessibility;

import android.os.Build.VERSION;

public class AccessibilityRecordCompat
{
  private static final AccessibilityRecordCompat.AccessibilityRecordImpl a = new AccessibilityRecordCompat.AccessibilityRecordStubImpl();
  private final Object b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new AccessibilityRecordCompat.AccessibilityRecordJellyBeanImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      a = new AccessibilityRecordCompat.AccessibilityRecordIcsMr1Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new AccessibilityRecordCompat.AccessibilityRecordIcsImpl();
      return;
    }
  }
  
  public AccessibilityRecordCompat(Object paramObject)
  {
    this.b = paramObject;
  }
  
  public void a(int paramInt)
  {
    a.b(this.b, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    a.a(this.b, paramBoolean);
  }
  
  public void b(int paramInt)
  {
    a.a(this.b, paramInt);
  }
  
  public void c(int paramInt)
  {
    a.e(this.b, paramInt);
  }
  
  public void d(int paramInt)
  {
    a.c(this.b, paramInt);
  }
  
  public void e(int paramInt)
  {
    a.d(this.b, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (AccessibilityRecordCompat)paramObject;
        if (this.b != null) {
          break;
        }
      } while (paramObject.b == null);
      return false;
    } while (this.b.equals(paramObject.b));
    return false;
  }
  
  public void f(int paramInt)
  {
    a.f(this.b, paramInt);
  }
  
  public void g(int paramInt)
  {
    a.g(this.b, paramInt);
  }
  
  public int hashCode()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.hashCode();
  }
}
