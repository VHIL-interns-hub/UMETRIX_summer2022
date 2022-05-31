package org.jsoup.select;

import org.jsoup.nodes.Node;

public class NodeTraversor
{
  private NodeVisitor a;
  
  public NodeTraversor(NodeVisitor paramNodeVisitor)
  {
    this.a = paramNodeVisitor;
  }
  
  public void a(Node paramNode)
  {
    int i = 0;
    Node localNode1 = paramNode;
    for (;;)
    {
      int j;
      Node localNode2;
      if (localNode1 != null)
      {
        this.a.a(localNode1, i);
        j = i;
        localNode2 = localNode1;
        if (localNode1.B() > 0)
        {
          localNode1 = localNode1.b(0);
          i += 1;
          continue;
        }
        while ((localNode2.H() == null) && (j > 0))
        {
          this.a.b(localNode2, j);
          localNode2 = localNode2.C();
          j -= 1;
        }
        this.a.b(localNode2, j);
        if (localNode2 != paramNode) {}
      }
      else
      {
        return;
      }
      localNode1 = localNode2.H();
      i = j;
    }
  }
}
