package com.bumptech.glide.module;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;

public abstract interface GlideModule
{
  public abstract void a(Context paramContext, Glide paramGlide);
  
  public abstract void a(Context paramContext, GlideBuilder paramGlideBuilder);
}
