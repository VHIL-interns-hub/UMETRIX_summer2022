package com.bumptech.glide.request;

import com.bumptech.glide.request.target.Target;

public abstract interface RequestListener
{
  public abstract boolean a(Exception paramException, Object paramObject, Target paramTarget, boolean paramBoolean);
  
  public abstract boolean a(Object paramObject1, Object paramObject2, Target paramTarget, boolean paramBoolean1, boolean paramBoolean2);
}
