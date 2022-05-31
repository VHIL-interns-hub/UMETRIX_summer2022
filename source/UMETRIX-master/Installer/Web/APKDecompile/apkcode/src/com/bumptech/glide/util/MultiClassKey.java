package com.bumptech.glide.util;

public class MultiClassKey
{
  private Class a;
  private Class b;
  
  public MultiClassKey() {}
  
  public MultiClassKey(Class paramClass1, Class paramClass2)
  {
    a(paramClass1, paramClass2);
  }
  
  public void a(Class paramClass1, Class paramClass2)
  {
    this.a = paramClass1;
    this.b = paramClass2;
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
      paramObject = (MultiClassKey)paramObject;
      if (!this.a.equals(paramObject.a)) {
        return false;
      }
    } while (this.b.equals(paramObject.b));
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
  }
}
