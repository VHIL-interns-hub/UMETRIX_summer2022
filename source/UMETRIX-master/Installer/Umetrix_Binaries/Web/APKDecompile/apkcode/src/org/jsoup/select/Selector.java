package org.jsoup.select;

import java.util.Iterator;
import java.util.LinkedHashSet;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;

public class Selector
{
  private final Evaluator a;
  private final Element b;
  
  private Selector(String paramString, Element paramElement)
  {
    Validate.a(paramString);
    paramString = paramString.trim();
    Validate.a(paramString);
    Validate.a(paramElement);
    this.a = QueryParser.a(paramString);
    this.b = paramElement;
  }
  
  private Selector(Evaluator paramEvaluator, Element paramElement)
  {
    Validate.a(paramEvaluator);
    Validate.a(paramElement);
    this.a = paramEvaluator;
    this.b = paramElement;
  }
  
  private Elements a()
  {
    return Collector.a(this.a, this.b);
  }
  
  public static Elements a(String paramString, Iterable paramIterable)
  {
    Validate.a(paramString);
    Validate.a(paramIterable);
    paramString = QueryParser.a(paramString);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localLinkedHashSet.addAll(a(paramString, (Element)paramIterable.next()));
    }
    return new Elements(localLinkedHashSet);
  }
  
  public static Elements a(String paramString, Element paramElement)
  {
    return new Selector(paramString, paramElement).a();
  }
  
  public static Elements a(Evaluator paramEvaluator, Element paramElement)
  {
    return new Selector(paramEvaluator, paramElement).a();
  }
}
