package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

public final class EmptySignature
  implements Key
{
  private static final EmptySignature a = new EmptySignature();
  
  private EmptySignature() {}
  
  public static EmptySignature a()
  {
    return a;
  }
  
  public void a(MessageDigest paramMessageDigest) {}
}
