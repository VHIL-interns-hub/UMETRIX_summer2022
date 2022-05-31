package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;

abstract interface EngineJobListener
{
  public abstract void a(Key paramKey, EngineResource paramEngineResource);
  
  public abstract void a(EngineJob paramEngineJob, Key paramKey);
}
