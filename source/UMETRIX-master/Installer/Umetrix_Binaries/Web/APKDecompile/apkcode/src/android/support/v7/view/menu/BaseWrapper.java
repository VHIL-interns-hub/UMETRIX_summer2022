package android.support.v7.view.menu;

class BaseWrapper
{
  final Object b;
  
  BaseWrapper(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("Wrapped Object can not be null.");
    }
    this.b = paramObject;
  }
}
