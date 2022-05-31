package android.support.v4.util;

public class LongSparseArray
  implements Cloneable
{
  private static final Object a = new Object();
  private boolean b = false;
  private long[] c;
  private Object[] d;
  private int e;
  
  public LongSparseArray()
  {
    this(10);
  }
  
  public LongSparseArray(int paramInt)
  {
    if (paramInt == 0) {
      this.c = ContainerHelpers.b;
    }
    for (this.d = ContainerHelpers.c;; this.d = new Object[paramInt])
    {
      this.e = 0;
      return;
      paramInt = ContainerHelpers.b(paramInt);
      this.c = new long[paramInt];
    }
  }
  
  private void c()
  {
    int m = this.e;
    long[] arrayOfLong = this.c;
    Object[] arrayOfObject = this.d;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != a)
      {
        if (i != j)
        {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.b = false;
    this.e = j;
  }
  
  public long a(int paramInt)
  {
    if (this.b) {
      c();
    }
    return this.c[paramInt];
  }
  
  public LongSparseArray a()
  {
    try
    {
      LongSparseArray localLongSparseArray = (LongSparseArray)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        localLongSparseArray.c = ((long[])this.c.clone());
        localLongSparseArray.d = ((Object[])this.d.clone());
        return localLongSparseArray;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public Object a(long paramLong)
  {
    return a(paramLong, null);
  }
  
  public Object a(long paramLong, Object paramObject)
  {
    int i = ContainerHelpers.a(this.c, this.e, paramLong);
    if ((i < 0) || (this.d[i] == a)) {
      return paramObject;
    }
    return this.d[i];
  }
  
  public int b()
  {
    if (this.b) {
      c();
    }
    return this.e;
  }
  
  public Object b(int paramInt)
  {
    if (this.b) {
      c();
    }
    return this.d[paramInt];
  }
  
  public void b(long paramLong)
  {
    int i = ContainerHelpers.a(this.c, this.e, paramLong);
    if ((i >= 0) && (this.d[i] != a))
    {
      this.d[i] = a;
      this.b = true;
    }
  }
  
  public void b(long paramLong, Object paramObject)
  {
    int i = ContainerHelpers.a(this.c, this.e, paramLong);
    if (i >= 0)
    {
      this.d[i] = paramObject;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.e) && (this.d[j] == a))
    {
      this.c[j] = paramLong;
      this.d[j] = paramObject;
      return;
    }
    i = j;
    if (this.b)
    {
      i = j;
      if (this.e >= this.c.length)
      {
        c();
        i = ContainerHelpers.a(this.c, this.e, paramLong) ^ 0xFFFFFFFF;
      }
    }
    if (this.e >= this.c.length)
    {
      j = ContainerHelpers.b(this.e + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.c, 0, arrayOfLong, 0, this.c.length);
      System.arraycopy(this.d, 0, arrayOfObject, 0, this.d.length);
      this.c = arrayOfLong;
      this.d = arrayOfObject;
    }
    if (this.e - i != 0)
    {
      System.arraycopy(this.c, i, this.c, i + 1, this.e - i);
      System.arraycopy(this.d, i, this.d, i + 1, this.e - i);
    }
    this.c[i] = paramLong;
    this.d[i] = paramObject;
    this.e += 1;
  }
  
  public String toString()
  {
    if (b() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.e * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.e)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(a(i));
      localStringBuilder.append('=');
      Object localObject = b(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
