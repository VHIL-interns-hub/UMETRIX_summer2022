package org.jsoup.select;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.TokenQueue;

class QueryParser
{
  private static final String[] a = { ",", ">", "+", "~", " " };
  private static final String[] b = { "=", "!=", "^=", "$=", "*=", "~=" };
  private static final Pattern f = Pattern.compile("((\\+|-)?(\\d+)?)n(\\s*(\\+|-)?\\s*\\d+)?", 2);
  private static final Pattern g = Pattern.compile("(\\+|-)?(\\d+)");
  private TokenQueue c;
  private String d;
  private List e = new ArrayList();
  
  private QueryParser(String paramString)
  {
    this.d = paramString;
    this.c = new TokenQueue(paramString);
  }
  
  public static Evaluator a(String paramString)
  {
    return new QueryParser(paramString).a();
  }
  
  private void a(char paramChar)
  {
    this.c.e();
    Evaluator localEvaluator = a(b());
    Object localObject1;
    Object localObject3;
    int i;
    Object localObject2;
    if (this.e.size() == 1)
    {
      localObject1 = (Evaluator)this.e.get(0);
      if ((!(localObject1 instanceof CombiningEvaluator.Or)) || (paramChar == ',')) {
        break label366;
      }
      localObject3 = ((CombiningEvaluator.Or)localObject1).a();
      i = 1;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      this.e.clear();
      if (paramChar == '>')
      {
        localObject1 = new CombiningEvaluator.And(new Evaluator[] { localEvaluator, new StructuralEvaluator.ImmediateParent((Evaluator)localObject1) });
        label117:
        if (i == 0) {
          break label360;
        }
        ((CombiningEvaluator.Or)localObject2).a((Evaluator)localObject1);
      }
      for (;;)
      {
        this.e.add(localObject2);
        return;
        localObject1 = new CombiningEvaluator.And(this.e);
        i = 0;
        localObject2 = localObject1;
        break;
        if (paramChar == ' ')
        {
          localObject1 = new CombiningEvaluator.And(new Evaluator[] { localEvaluator, new StructuralEvaluator.Parent((Evaluator)localObject1) });
          break label117;
        }
        if (paramChar == '+')
        {
          localObject1 = new CombiningEvaluator.And(new Evaluator[] { localEvaluator, new StructuralEvaluator.ImmediatePreviousSibling((Evaluator)localObject1) });
          break label117;
        }
        if (paramChar == '~')
        {
          localObject1 = new CombiningEvaluator.And(new Evaluator[] { localEvaluator, new StructuralEvaluator.PreviousSibling((Evaluator)localObject1) });
          break label117;
        }
        if (paramChar == ',')
        {
          if ((localObject1 instanceof CombiningEvaluator.Or))
          {
            localObject1 = (CombiningEvaluator.Or)localObject1;
            ((CombiningEvaluator.Or)localObject1).b(localEvaluator);
          }
          for (;;)
          {
            break;
            localObject3 = new CombiningEvaluator.Or();
            ((CombiningEvaluator.Or)localObject3).b((Evaluator)localObject1);
            ((CombiningEvaluator.Or)localObject3).b(localEvaluator);
            localObject1 = localObject3;
          }
        }
        throw new Selector.SelectorParseException("Unknown combinator: " + paramChar, new Object[0]);
        label360:
        localObject2 = localObject1;
      }
      label366:
      i = 0;
      localObject2 = localObject1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    TokenQueue localTokenQueue = this.c;
    if (paramBoolean) {}
    for (String str = ":containsOwn";; str = ":contains")
    {
      localTokenQueue.c(str);
      str = TokenQueue.f(this.c.a('(', ')'));
      Validate.a(str, ":contains(text) query must not be empty");
      if (!paramBoolean) {
        break;
      }
      this.e.add(new Evaluator.ContainsOwnText(str));
      return;
    }
    this.e.add(new Evaluator.ContainsText(str));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    int j = 0;
    String str = this.c.e(")").trim().toLowerCase();
    Matcher localMatcher1 = f.matcher(str);
    Matcher localMatcher2 = g.matcher(str);
    int i;
    if ("odd".equals(str))
    {
      j = 1;
      i = 2;
    }
    while (paramBoolean2) {
      if (paramBoolean1)
      {
        this.e.add(new Evaluator.IsNthLastOfType(i, j));
        return;
        if ("even".equals(str))
        {
          i = 2;
        }
        else if (localMatcher1.matches())
        {
          if (localMatcher1.group(3) != null) {
            k = Integer.parseInt(localMatcher1.group(1).replaceFirst("^\\+", ""));
          }
          i = k;
          if (localMatcher1.group(4) != null)
          {
            j = Integer.parseInt(localMatcher1.group(4).replaceFirst("^\\+", ""));
            i = k;
          }
        }
        else if (localMatcher2.matches())
        {
          j = Integer.parseInt(localMatcher2.group().replaceFirst("^\\+", ""));
          i = 0;
        }
        else
        {
          throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", new Object[] { str });
        }
      }
      else
      {
        this.e.add(new Evaluator.IsNthOfType(i, j));
        return;
      }
    }
    if (paramBoolean1)
    {
      this.e.add(new Evaluator.IsNthLastChild(i, j));
      return;
    }
    this.e.add(new Evaluator.IsNthChild(i, j));
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      if (!this.c.a())
      {
        if (this.c.a("("))
        {
          localStringBuilder.append("(").append(this.c.a('(', ')')).append(")");
          continue;
        }
        if (this.c.a("["))
        {
          localStringBuilder.append("[").append(this.c.a('[', ']')).append("]");
          continue;
        }
        if (!this.c.a(a)) {}
      }
      else
      {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(this.c.d());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    TokenQueue localTokenQueue = this.c;
    if (paramBoolean) {}
    for (String str = ":matchesOwn";; str = ":matches")
    {
      localTokenQueue.c(str);
      str = this.c.a('(', ')');
      Validate.a(str, ":matches(regex) query must not be empty");
      if (!paramBoolean) {
        break;
      }
      this.e.add(new Evaluator.MatchesOwn(Pattern.compile(str)));
      return;
    }
    this.e.add(new Evaluator.Matches(Pattern.compile(str)));
  }
  
  private void c()
  {
    if (this.c.b("#"))
    {
      d();
      return;
    }
    if (this.c.b("."))
    {
      e();
      return;
    }
    if (this.c.c())
    {
      f();
      return;
    }
    if (this.c.a("["))
    {
      g();
      return;
    }
    if (this.c.b("*"))
    {
      h();
      return;
    }
    if (this.c.b(":lt("))
    {
      i();
      return;
    }
    if (this.c.b(":gt("))
    {
      j();
      return;
    }
    if (this.c.b(":eq("))
    {
      k();
      return;
    }
    if (this.c.a(":has("))
    {
      m();
      return;
    }
    if (this.c.a(":contains("))
    {
      a(false);
      return;
    }
    if (this.c.a(":containsOwn("))
    {
      a(true);
      return;
    }
    if (this.c.a(":matches("))
    {
      b(false);
      return;
    }
    if (this.c.a(":matchesOwn("))
    {
      b(true);
      return;
    }
    if (this.c.a(":not("))
    {
      n();
      return;
    }
    if (this.c.b(":nth-child("))
    {
      a(false, false);
      return;
    }
    if (this.c.b(":nth-last-child("))
    {
      a(true, false);
      return;
    }
    if (this.c.b(":nth-of-type("))
    {
      a(false, true);
      return;
    }
    if (this.c.b(":nth-last-of-type("))
    {
      a(true, true);
      return;
    }
    if (this.c.b(":first-child"))
    {
      this.e.add(new Evaluator.IsFirstChild());
      return;
    }
    if (this.c.b(":last-child"))
    {
      this.e.add(new Evaluator.IsLastChild());
      return;
    }
    if (this.c.b(":first-of-type"))
    {
      this.e.add(new Evaluator.IsFirstOfType());
      return;
    }
    if (this.c.b(":last-of-type"))
    {
      this.e.add(new Evaluator.IsLastOfType());
      return;
    }
    if (this.c.b(":only-child"))
    {
      this.e.add(new Evaluator.IsOnlyChild());
      return;
    }
    if (this.c.b(":only-of-type"))
    {
      this.e.add(new Evaluator.IsOnlyOfType());
      return;
    }
    if (this.c.b(":empty"))
    {
      this.e.add(new Evaluator.IsEmpty());
      return;
    }
    if (this.c.b(":root"))
    {
      this.e.add(new Evaluator.IsRoot());
      return;
    }
    throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", new Object[] { this.d, this.c.h() });
  }
  
  private void d()
  {
    String str = this.c.g();
    Validate.a(str);
    this.e.add(new Evaluator.Id(str));
  }
  
  private void e()
  {
    String str = this.c.g();
    Validate.a(str);
    this.e.add(new Evaluator.Class(str.trim().toLowerCase()));
  }
  
  private void f()
  {
    String str2 = this.c.f();
    Validate.a(str2);
    String str1 = str2;
    if (str2.contains("|")) {
      str1 = str2.replace("|", ":");
    }
    this.e.add(new Evaluator.Tag(str1.trim().toLowerCase()));
  }
  
  private void g()
  {
    TokenQueue localTokenQueue = new TokenQueue(this.c.a('[', ']'));
    String str = localTokenQueue.b(b);
    Validate.a(str);
    localTokenQueue.e();
    if (localTokenQueue.a())
    {
      if (str.startsWith("^"))
      {
        this.e.add(new Evaluator.AttributeStarting(str.substring(1)));
        return;
      }
      this.e.add(new Evaluator.Attribute(str));
      return;
    }
    if (localTokenQueue.b("="))
    {
      this.e.add(new Evaluator.AttributeWithValue(str, localTokenQueue.h()));
      return;
    }
    if (localTokenQueue.b("!="))
    {
      this.e.add(new Evaluator.AttributeWithValueNot(str, localTokenQueue.h()));
      return;
    }
    if (localTokenQueue.b("^="))
    {
      this.e.add(new Evaluator.AttributeWithValueStarting(str, localTokenQueue.h()));
      return;
    }
    if (localTokenQueue.b("$="))
    {
      this.e.add(new Evaluator.AttributeWithValueEnding(str, localTokenQueue.h()));
      return;
    }
    if (localTokenQueue.b("*="))
    {
      this.e.add(new Evaluator.AttributeWithValueContaining(str, localTokenQueue.h()));
      return;
    }
    if (localTokenQueue.b("~="))
    {
      this.e.add(new Evaluator.AttributeWithValueMatching(str, Pattern.compile(localTokenQueue.h())));
      return;
    }
    throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", new Object[] { this.d, localTokenQueue.h() });
  }
  
  private void h()
  {
    this.e.add(new Evaluator.AllElements());
  }
  
  private void i()
  {
    this.e.add(new Evaluator.IndexLessThan(l()));
  }
  
  private void j()
  {
    this.e.add(new Evaluator.IndexGreaterThan(l()));
  }
  
  private void k()
  {
    this.e.add(new Evaluator.IndexEquals(l()));
  }
  
  private int l()
  {
    String str = this.c.e(")").trim();
    Validate.a(StringUtil.b(str), "Index must be numeric");
    return Integer.parseInt(str);
  }
  
  private void m()
  {
    this.c.c(":has");
    String str = this.c.a('(', ')');
    Validate.a(str, ":has(el) subselect must not be empty");
    this.e.add(new StructuralEvaluator.Has(a(str)));
  }
  
  private void n()
  {
    this.c.c(":not");
    String str = this.c.a('(', ')');
    Validate.a(str, ":not(selector) subselect must not be empty");
    this.e.add(new StructuralEvaluator.Not(a(str)));
  }
  
  Evaluator a()
  {
    this.c.e();
    if (this.c.a(a))
    {
      this.e.add(new StructuralEvaluator.Root());
      a(this.c.d());
    }
    while (!this.c.a())
    {
      boolean bool = this.c.e();
      if (this.c.a(a))
      {
        a(this.c.d());
        continue;
        c();
      }
      else if (bool)
      {
        a(' ');
      }
      else
      {
        c();
      }
    }
    if (this.e.size() == 1) {
      return (Evaluator)this.e.get(0);
    }
    return new CombiningEvaluator.And(this.e);
  }
}
