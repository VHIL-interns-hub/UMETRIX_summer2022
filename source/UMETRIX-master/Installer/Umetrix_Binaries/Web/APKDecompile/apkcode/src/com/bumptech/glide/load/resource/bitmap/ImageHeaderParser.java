package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;

public class ImageHeaderParser
{
  private static final byte[] a;
  private static final int[] b = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
  private final ImageHeaderParser.StreamReader c;
  
  static
  {
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = "Exif\000\000".getBytes("UTF-8");
      localObject = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    a = (byte[])localObject;
  }
  
  public ImageHeaderParser(InputStream paramInputStream)
  {
    this.c = new ImageHeaderParser.StreamReader(paramInputStream);
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + 2 + paramInt2 * 12;
  }
  
  private static int a(ImageHeaderParser.RandomAccessReader paramRandomAccessReader)
  {
    int i = "Exif\000\000".length();
    int j = paramRandomAccessReader.b(i);
    ByteOrder localByteOrder;
    label48:
    int n;
    int m;
    if (j == 19789)
    {
      localByteOrder = ByteOrder.BIG_ENDIAN;
      paramRandomAccessReader.a(localByteOrder);
      j = i + paramRandomAccessReader.a(i + 4);
      int k = paramRandomAccessReader.b(j);
      i = 0;
      if (i >= k) {
        break label486;
      }
      n = a(j, i);
      m = paramRandomAccessReader.b(n);
      if (m == 274) {
        break label140;
      }
    }
    for (;;)
    {
      i += 1;
      break label48;
      if (j == 18761)
      {
        localByteOrder = ByteOrder.LITTLE_ENDIAN;
        break;
      }
      if (Log.isLoggable("ImageHeaderParser", 3)) {
        Log.d("ImageHeaderParser", "Unknown endianness = " + j);
      }
      localByteOrder = ByteOrder.BIG_ENDIAN;
      break;
      label140:
      int i1 = paramRandomAccessReader.b(n + 2);
      if ((i1 < 1) || (i1 > 12))
      {
        if (Log.isLoggable("ImageHeaderParser", 3)) {
          Log.d("ImageHeaderParser", "Got invalid format code=" + i1);
        }
      }
      else
      {
        int i2 = paramRandomAccessReader.a(n + 4);
        if (i2 < 0)
        {
          if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Negative tiff component count");
          }
        }
        else
        {
          if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Got tagIndex=" + i + " tagType=" + m + " formatCode=" + i1 + " componentCount=" + i2);
          }
          i2 += b[i1];
          if (i2 > 4)
          {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
              Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + i1);
            }
          }
          else
          {
            n += 8;
            if ((n < 0) || (n > paramRandomAccessReader.a()))
            {
              if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + n + " tagType=" + m);
              }
            }
            else
            {
              if ((i2 >= 0) && (n + i2 <= paramRandomAccessReader.a())) {
                break label479;
              }
              if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + m);
              }
            }
          }
        }
      }
    }
    label479:
    return paramRandomAccessReader.b(n);
    label486:
    return -1;
  }
  
  private static boolean a(int paramInt)
  {
    return ((paramInt & 0xFFD8) == 65496) || (paramInt == 19789) || (paramInt == 18761);
  }
  
  private byte[] d()
  {
    int i = this.c.b();
    if (i != 255) {
      if (Log.isLoggable("ImageHeaderParser", 3)) {
        Log.d("ImageHeaderParser", "Unknown segmentId=" + i);
      }
    }
    int j;
    label183:
    byte[] arrayOfByte;
    int k;
    do
    {
      long l;
      do
      {
        do
        {
          do
          {
            return null;
            i = this.c.b();
          } while (i == 218);
          if (i != 217) {
            break;
          }
        } while (!Log.isLoggable("ImageHeaderParser", 3));
        Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
        return null;
        j = this.c.a() - 2;
        if (i == 225) {
          break label183;
        }
        l = this.c.a(j);
        if (l == j) {
          break;
        }
      } while (!Log.isLoggable("ImageHeaderParser", 3));
      Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + i + ", wanted to skip: " + j + ", but actually skipped: " + l);
      return null;
      arrayOfByte = new byte[j];
      k = this.c.a(arrayOfByte);
      if (k == j) {
        break label257;
      }
    } while (!Log.isLoggable("ImageHeaderParser", 3));
    Log.d("ImageHeaderParser", "Unable to read segment data, type: " + i + ", length: " + j + ", actually read: " + k);
    return null;
    label257:
    return arrayOfByte;
  }
  
  public boolean a()
  {
    return b().hasAlpha();
  }
  
  public ImageHeaderParser.ImageType b()
  {
    int i = this.c.a();
    if (i == 65496) {
      return ImageHeaderParser.ImageType.JPEG;
    }
    i = i << 16 & 0xFFFF0000 | this.c.a() & 0xFFFF;
    if (i == -1991225785)
    {
      this.c.a(21L);
      if (this.c.c() >= 3) {
        return ImageHeaderParser.ImageType.PNG_A;
      }
      return ImageHeaderParser.ImageType.PNG;
    }
    if (i >> 8 == 4671814) {
      return ImageHeaderParser.ImageType.GIF;
    }
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
  
  public int c()
  {
    int k = 0;
    if (!a(this.c.a())) {
      return -1;
    }
    byte[] arrayOfByte = d();
    int i;
    int j;
    if ((arrayOfByte != null) && (arrayOfByte.length > a.length))
    {
      i = 1;
      if (i == 0) {
        break label99;
      }
      j = 0;
      label46:
      if (j >= a.length) {
        break label99;
      }
      if (arrayOfByte[j] == a[j]) {
        break label90;
      }
      i = k;
    }
    label90:
    label99:
    for (;;)
    {
      if (i != 0)
      {
        return a(new ImageHeaderParser.RandomAccessReader(arrayOfByte));
        i = 0;
        break;
        j += 1;
        break label46;
      }
      return -1;
    }
  }
}
