package com.amulyakhare.textdrawable.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ColorGenerator
{
  public static ColorGenerator a = a(Arrays.asList(new Integer[] { Integer.valueOf(-957596), Integer.valueOf(-686759), Integer.valueOf(-416706), Integer.valueOf(-1784274), Integer.valueOf(-9977996), Integer.valueOf(-10902850), Integer.valueOf(-14642227), Integer.valueOf(-5414233), Integer.valueOf(-8366207) }));
  public static ColorGenerator b = a(Arrays.asList(new Integer[] { Integer.valueOf(-1739917), Integer.valueOf(-1023342), Integer.valueOf(-4560696), Integer.valueOf(-6982195), Integer.valueOf(-8812853), Integer.valueOf(-10177034), Integer.valueOf(-11549705), Integer.valueOf(-11677471), Integer.valueOf(-11684180), Integer.valueOf(-8271996), Integer.valueOf(-5319295), Integer.valueOf(35429), Integer.valueOf(-2825897), Integer.valueOf(54607), Integer.valueOf(46925), Integer.valueOf(-6190977), Integer.valueOf(-7297874) }));
  private final List c;
  private final Random d;
  
  private ColorGenerator(List paramList)
  {
    this.c = paramList;
    this.d = new Random(System.currentTimeMillis());
  }
  
  public static ColorGenerator a(List paramList)
  {
    return new ColorGenerator(paramList);
  }
  
  public int a(Object paramObject)
  {
    return ((Integer)this.c.get(Math.abs(paramObject.hashCode()) % this.c.size())).intValue();
  }
}
