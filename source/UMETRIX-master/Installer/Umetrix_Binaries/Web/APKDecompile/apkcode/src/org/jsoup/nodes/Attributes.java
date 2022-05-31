package org.jsoup.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.jsoup.helper.Validate;

public class Attributes
  implements Cloneable, Iterable
{
  private LinkedHashMap a = null;
  
  public Attributes() {}
  
  public int a()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public String a(String paramString)
  {
    Validate.a(paramString);
    if (this.a == null) {
      return "";
    }
    paramString = (Attribute)this.a.get(paramString.toLowerCase());
    if (paramString != null) {
      return paramString.b();
    }
    return "";
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(new Attribute(paramString1, paramString2));
  }
  
  void a(StringBuilder paramStringBuilder, Document.OutputSettings paramOutputSettings)
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Attribute localAttribute = (Attribute)((Map.Entry)localIterator.next()).getValue();
        paramStringBuilder.append(" ");
        localAttribute.a(paramStringBuilder, paramOutputSettings);
      }
    }
  }
  
  public void a(Attribute paramAttribute)
  {
    Validate.a(paramAttribute);
    if (this.a == null) {
      this.a = new LinkedHashMap(2);
    }
    this.a.put(paramAttribute.a(), paramAttribute);
  }
  
  public void a(Attributes paramAttributes)
  {
    if (paramAttributes.a() == 0) {
      return;
    }
    if (this.a == null) {
      this.a = new LinkedHashMap(paramAttributes.a());
    }
    this.a.putAll(paramAttributes.a);
  }
  
  public List b()
  {
    if (this.a == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(this.a.size());
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public boolean b(String paramString)
  {
    return (this.a != null) && (this.a.containsKey(paramString.toLowerCase()));
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, new Document("").e());
    return localStringBuilder.toString();
  }
  
  /* Error */
  public Attributes d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	org/jsoup/nodes/Attributes:a	Ljava/util/LinkedHashMap;
    //   4: ifnonnull +13 -> 17
    //   7: new 2	org/jsoup/nodes/Attributes
    //   10: dup
    //   11: invokespecial 152	org/jsoup/nodes/Attributes:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: invokespecial 154	java/lang/Object:clone	()Ljava/lang/Object;
    //   21: checkcast 2	org/jsoup/nodes/Attributes
    //   24: astore_2
    //   25: aload_2
    //   26: new 20	java/util/LinkedHashMap
    //   29: dup
    //   30: aload_0
    //   31: getfield 16	org/jsoup/nodes/Attributes:a	Ljava/util/LinkedHashMap;
    //   34: invokevirtual 23	java/util/LinkedHashMap:size	()I
    //   37: invokespecial 94	java/util/LinkedHashMap:<init>	(I)V
    //   40: putfield 16	org/jsoup/nodes/Attributes:a	Ljava/util/LinkedHashMap;
    //   43: aload_0
    //   44: invokevirtual 155	org/jsoup/nodes/Attributes:iterator	()Ljava/util/Iterator;
    //   47: astore_3
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: invokeinterface 69 1 0
    //   56: ifeq -41 -> 15
    //   59: aload_3
    //   60: invokeinterface 73 1 0
    //   65: checkcast 43	org/jsoup/nodes/Attribute
    //   68: astore_1
    //   69: aload_2
    //   70: getfield 16	org/jsoup/nodes/Attributes:a	Ljava/util/LinkedHashMap;
    //   73: aload_1
    //   74: invokevirtual 96	org/jsoup/nodes/Attribute:a	()Ljava/lang/String;
    //   77: aload_1
    //   78: invokevirtual 158	org/jsoup/nodes/Attribute:e	()Lorg/jsoup/nodes/Attribute;
    //   81: invokevirtual 100	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   84: pop
    //   85: goto -37 -> 48
    //   88: astore_1
    //   89: new 160	java/lang/RuntimeException
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 163	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	Attributes
    //   14	64	1	localObject	Object
    //   88	6	1	localCloneNotSupportedException	CloneNotSupportedException
    //   24	46	2	localAttributes	Attributes
    //   47	13	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   17	25	88	java/lang/CloneNotSupportedException
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Attributes)) {
        return false;
      }
      paramObject = (Attributes)paramObject;
      if (this.a == null) {
        break;
      }
    } while (this.a.equals(paramObject.a));
    while (paramObject.a != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    if (this.a != null) {
      return this.a.hashCode();
    }
    return 0;
  }
  
  public Iterator iterator()
  {
    return b().iterator();
  }
  
  public String toString()
  {
    return c();
  }
}
