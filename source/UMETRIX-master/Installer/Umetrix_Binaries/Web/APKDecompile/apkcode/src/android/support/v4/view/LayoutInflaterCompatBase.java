package android.support.v4.view;

import android.view.LayoutInflater;

class LayoutInflaterCompatBase
{
  static LayoutInflaterFactory a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.getFactory();
    if ((paramLayoutInflater instanceof LayoutInflaterCompatBase.FactoryWrapper)) {
      return ((LayoutInflaterCompatBase.FactoryWrapper)paramLayoutInflater).a;
    }
    return null;
  }
  
  static void a(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory)
  {
    if (paramLayoutInflaterFactory != null) {}
    for (paramLayoutInflaterFactory = new LayoutInflaterCompatBase.FactoryWrapper(paramLayoutInflaterFactory);; paramLayoutInflaterFactory = null)
    {
      paramLayoutInflater.setFactory(paramLayoutInflaterFactory);
      return;
    }
  }
}
