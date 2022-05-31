package com.bumptech.glide.load.model;

import android.content.Context;

public abstract interface ModelLoaderFactory
{
  public abstract ModelLoader a(Context paramContext, GenericLoaderFactory paramGenericLoaderFactory);
  
  public abstract void a();
}
