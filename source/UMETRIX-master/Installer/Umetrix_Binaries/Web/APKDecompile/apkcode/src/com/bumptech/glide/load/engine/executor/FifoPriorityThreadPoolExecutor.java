package com.bumptech.glide.load.engine.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FifoPriorityThreadPoolExecutor
  extends ThreadPoolExecutor
{
  private final AtomicInteger a = new AtomicInteger();
  private final FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy b;
  
  public FifoPriorityThreadPoolExecutor(int paramInt)
  {
    this(paramInt, FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.b);
  }
  
  public FifoPriorityThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, ThreadFactory paramThreadFactory, FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy paramUncaughtThrowableStrategy)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, new PriorityBlockingQueue(), paramThreadFactory);
    this.b = paramUncaughtThrowableStrategy;
  }
  
  public FifoPriorityThreadPoolExecutor(int paramInt, FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy paramUncaughtThrowableStrategy)
  {
    this(paramInt, paramInt, 0L, TimeUnit.MILLISECONDS, new FifoPriorityThreadPoolExecutor.DefaultThreadFactory(), paramUncaughtThrowableStrategy);
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    if ((paramThrowable == null) && ((paramRunnable instanceof Future)))
    {
      paramRunnable = (Future)paramRunnable;
      if ((!paramRunnable.isDone()) || (paramRunnable.isCancelled())) {}
    }
    try
    {
      paramRunnable.get();
      return;
    }
    catch (InterruptedException paramRunnable)
    {
      this.b.a(paramRunnable);
      return;
    }
    catch (ExecutionException paramRunnable)
    {
      this.b.a(paramRunnable);
    }
  }
  
  protected RunnableFuture newTaskFor(Runnable paramRunnable, Object paramObject)
  {
    return new FifoPriorityThreadPoolExecutor.LoadTask(paramRunnable, paramObject, this.a.getAndIncrement());
  }
}
