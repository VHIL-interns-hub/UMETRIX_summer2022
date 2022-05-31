package org.jsoup.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public abstract class Node
  implements Cloneable
{
  private static final List f = ;
  Node a;
  List b;
  Attributes c;
  String d;
  int e;
  
  protected Node()
  {
    this.b = f;
    this.c = null;
  }
  
  protected Node(String paramString)
  {
    this(paramString, new Attributes());
  }
  
  protected Node(String paramString, Attributes paramAttributes)
  {
    Validate.a(paramString);
    Validate.a(paramAttributes);
    this.b = f;
    this.d = paramString.trim();
    this.c = paramAttributes;
  }
  
  private void a(int paramInt)
  {
    while (paramInt < this.b.size())
    {
      ((Node)this.b.get(paramInt)).c(paramInt);
      paramInt += 1;
    }
  }
  
  public List A()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public final int B()
  {
    return this.b.size();
  }
  
  public final Node C()
  {
    return this.a;
  }
  
  public Document D()
  {
    if ((this instanceof Document)) {
      return (Document)this;
    }
    if (this.a == null) {
      return null;
    }
    return this.a.D();
  }
  
  public void E()
  {
    Validate.a(this.a);
    this.a.f(this);
  }
  
  protected void F()
  {
    if (this.b == f) {
      this.b = new ArrayList(4);
    }
  }
  
  public List G()
  {
    if (this.a == null) {
      return Collections.emptyList();
    }
    Object localObject = this.a.b;
    ArrayList localArrayList = new ArrayList(((List)localObject).size() - 1);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Node localNode = (Node)((Iterator)localObject).next();
      if (localNode != this) {
        localArrayList.add(localNode);
      }
    }
    return localArrayList;
  }
  
  public Node H()
  {
    if (this.a == null) {}
    List localList;
    int i;
    do
    {
      return null;
      localList = this.a.b;
      i = this.e + 1;
    } while (localList.size() <= i);
    return (Node)localList.get(i);
  }
  
  public int I()
  {
    return this.e;
  }
  
  Document.OutputSettings J()
  {
    if (D() != null) {
      return D().e();
    }
    return new Document("").e();
  }
  
  public abstract String a();
  
  public Node a(NodeVisitor paramNodeVisitor)
  {
    Validate.a(paramNodeVisitor);
    new NodeTraversor(paramNodeVisitor).a(this);
    return this;
  }
  
  protected void a(int paramInt, Node... paramVarArgs)
  {
    Validate.a(paramVarArgs);
    int i = paramVarArgs.length - 1;
    while (i >= 0)
    {
      Node localNode = paramVarArgs[i];
      g(localNode);
      F();
      this.b.add(paramInt, localNode);
      i -= 1;
    }
    a(paramInt);
  }
  
  protected void a(StringBuilder paramStringBuilder)
  {
    new NodeTraversor(new Node.OuterHtmlVisitor(paramStringBuilder, J())).a(this);
  }
  
  abstract void a(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings);
  
  public Node b(int paramInt)
  {
    return (Node)this.b.get(paramInt);
  }
  
  public Node b(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
    return this;
  }
  
  abstract void b(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings);
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    a(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  protected void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  protected void c(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    paramStringBuilder.append("\n").append(StringUtil.a(paramOutputSettings.f() * paramInt));
  }
  
  public Node d(Node paramNode)
  {
    Validate.a(paramNode);
    Validate.a(this.a);
    this.a.a(this.e, new Node[] { paramNode });
    return this;
  }
  
  protected void e(Node paramNode)
  {
    if (this.a != null) {
      this.a.f(this);
    }
    this.a = paramNode;
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
      paramObject = (Node)paramObject;
      if (this.b != null)
      {
        if (this.b.equals(paramObject.b)) {}
      }
      else {
        while (paramObject.b != null) {
          return false;
        }
      }
      if (this.c == null) {
        break;
      }
    } while (this.c.equals(paramObject.c));
    while (paramObject.c != null) {
      return false;
    }
    return true;
  }
  
  public String f(String paramString)
  {
    Validate.a(paramString);
    if (this.c.b(paramString)) {
      return this.c.a(paramString);
    }
    if (paramString.toLowerCase().startsWith("abs:")) {
      return i(paramString.substring("abs:".length()));
    }
    return "";
  }
  
  protected void f(Node paramNode)
  {
    if (paramNode.a == this) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.a(bool);
      int i = paramNode.e;
      this.b.remove(i);
      a(i);
      paramNode.a = null;
      return;
    }
  }
  
  protected void g(Node paramNode)
  {
    if (paramNode.a != null) {
      paramNode.a.f(paramNode);
    }
    paramNode.e(this);
  }
  
  public boolean g(String paramString)
  {
    Validate.a(paramString);
    if (paramString.startsWith("abs:"))
    {
      String str = paramString.substring("abs:".length());
      if ((this.c.b(str)) && (!i(str).equals(""))) {
        return true;
      }
    }
    return this.c.b(paramString);
  }
  
  public Node h()
  {
    Node localNode1 = h(null);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localNode1);
    while (!localLinkedList.isEmpty())
    {
      Node localNode2 = (Node)localLinkedList.remove();
      int i = 0;
      while (i < localNode2.b.size())
      {
        Node localNode3 = ((Node)localNode2.b.get(i)).h(localNode2);
        localNode2.b.set(i, localNode3);
        localLinkedList.add(localNode3);
        i += 1;
      }
    }
    return localNode1;
  }
  
  protected Node h(Node paramNode)
  {
    Node localNode1;
    for (;;)
    {
      try
      {
        localNode1 = (Node)super.clone();
        localNode1.a = paramNode;
        if (paramNode == null)
        {
          i = 0;
          localNode1.e = i;
          if (this.c == null) {
            break label135;
          }
          paramNode = this.c.d();
          localNode1.c = paramNode;
          localNode1.d = this.d;
          localNode1.b = new ArrayList(this.b.size());
          paramNode = this.b.iterator();
          if (!paramNode.hasNext()) {
            break;
          }
          Node localNode2 = (Node)paramNode.next();
          localNode1.b.add(localNode2);
          continue;
        }
        int i = this.e;
      }
      catch (CloneNotSupportedException paramNode)
      {
        throw new RuntimeException(paramNode);
      }
      continue;
      label135:
      paramNode = null;
    }
    return localNode1;
  }
  
  public void h(String paramString)
  {
    Validate.a(paramString);
    a(new Node.1(this, paramString));
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.b != null) {}
    for (int i = this.b.hashCode();; i = 0)
    {
      if (this.c != null) {
        j = this.c.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public String i(String paramString)
  {
    Validate.a(paramString);
    if (!g(paramString)) {
      return "";
    }
    return StringUtil.a(this.d, f(paramString));
  }
  
  public String toString()
  {
    return c();
  }
  
  public Node x()
  {
    return this.a;
  }
  
  public Attributes y()
  {
    return this.c;
  }
  
  public String z()
  {
    return this.d;
  }
}
