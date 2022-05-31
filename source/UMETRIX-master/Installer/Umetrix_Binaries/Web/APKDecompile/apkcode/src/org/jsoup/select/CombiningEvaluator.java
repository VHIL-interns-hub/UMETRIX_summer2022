package org.jsoup.select;

import java.util.ArrayList;
import java.util.Collection;

abstract class CombiningEvaluator
  extends Evaluator
{
  final ArrayList a = new ArrayList();
  int b = 0;
  
  CombiningEvaluator() {}
  
  CombiningEvaluator(Collection paramCollection)
  {
    this();
    this.a.addAll(paramCollection);
    b();
  }
  
  Evaluator a()
  {
    if (this.b > 0) {
      return (Evaluator)this.a.get(this.b - 1);
    }
    return null;
  }
  
  void a(Evaluator paramEvaluator)
  {
    this.a.set(this.b - 1, paramEvaluator);
  }
  
  void b()
  {
    this.b = this.a.size();
  }
}
