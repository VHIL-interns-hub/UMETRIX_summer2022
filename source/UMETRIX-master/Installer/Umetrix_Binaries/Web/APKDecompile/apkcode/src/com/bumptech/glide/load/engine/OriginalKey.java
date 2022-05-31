package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

class OriginalKey
  implements Key
{
  private final String a;
  private final Key b;
  
  public OriginalKey(String paramString, Key paramKey)
  {
    this.a = paramString;
    this.b = paramKey;
  }
  
  public void a(MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(this.a.getBytes("UTF-8"));
    this.b.a(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (OriginalKey)paramObject;
      if (!this.a.equals(paramObject.a)) {
        return false;
      }
    } while (this.b.equals(paramObject.b));
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() * 31 + this.b.hashCode();
  }
}
