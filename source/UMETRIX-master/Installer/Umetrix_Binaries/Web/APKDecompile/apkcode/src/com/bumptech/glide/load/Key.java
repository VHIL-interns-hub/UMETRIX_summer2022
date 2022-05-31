package com.bumptech.glide.load;

import java.security.MessageDigest;

public abstract interface Key
{
  public abstract void a(MessageDigest paramMessageDigest);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
}
