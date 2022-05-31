package org.jsoup.select;

import org.jsoup.nodes.Element;

public class Collector
{
  public static Elements a(Evaluator paramEvaluator, Element paramElement)
  {
    Elements localElements = new Elements();
    new NodeTraversor(new Collector.Accumulator(paramElement, localElements, paramEvaluator)).a(paramElement);
    return localElements;
  }
}
