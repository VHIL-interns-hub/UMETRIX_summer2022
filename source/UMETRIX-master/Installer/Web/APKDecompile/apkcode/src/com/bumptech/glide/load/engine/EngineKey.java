package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

class EngineKey
  implements Key
{
  private final String a;
  private final int b;
  private final int c;
  private final ResourceDecoder d;
  private final ResourceDecoder e;
  private final Transformation f;
  private final ResourceEncoder g;
  private final ResourceTranscoder h;
  private final Encoder i;
  private final Key j;
  private String k;
  private int l;
  private Key m;
  
  public EngineKey(String paramString, Key paramKey, int paramInt1, int paramInt2, ResourceDecoder paramResourceDecoder1, ResourceDecoder paramResourceDecoder2, Transformation paramTransformation, ResourceEncoder paramResourceEncoder, ResourceTranscoder paramResourceTranscoder, Encoder paramEncoder)
  {
    this.a = paramString;
    this.j = paramKey;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramResourceDecoder1;
    this.e = paramResourceDecoder2;
    this.f = paramTransformation;
    this.g = paramResourceEncoder;
    this.h = paramResourceTranscoder;
    this.i = paramEncoder;
  }
  
  public Key a()
  {
    if (this.m == null) {
      this.m = new OriginalKey(this.a, this.j);
    }
    return this.m;
  }
  
  public void a(MessageDigest paramMessageDigest)
  {
    Object localObject = ByteBuffer.allocate(8).putInt(this.b).putInt(this.c).array();
    this.j.a(paramMessageDigest);
    paramMessageDigest.update(this.a.getBytes("UTF-8"));
    paramMessageDigest.update((byte[])localObject);
    if (this.d != null)
    {
      localObject = this.d.a();
      paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
      if (this.e == null) {
        break label193;
      }
      localObject = this.e.a();
      label95:
      paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
      if (this.f == null) {
        break label199;
      }
      localObject = this.f.a();
      label122:
      paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
      if (this.g == null) {
        break label205;
      }
      localObject = this.g.a();
      label149:
      paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
      if (this.i == null) {
        break label211;
      }
    }
    label193:
    label199:
    label205:
    label211:
    for (localObject = this.i.a();; localObject = "")
    {
      paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
      return;
      localObject = "";
      break;
      localObject = "";
      break label95;
      localObject = "";
      break label122;
      localObject = "";
      break label149;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    int n;
    label119:
    label128:
    label182:
    label191:
    label245:
    label254:
    label308:
    label317:
    label371:
    label380:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return bool1;
                                    bool1 = bool2;
                                  } while (paramObject == null);
                                  bool1 = bool2;
                                } while (getClass() != paramObject.getClass());
                                paramObject = (EngineKey)paramObject;
                                bool1 = bool2;
                              } while (!this.a.equals(paramObject.a));
                              bool1 = bool2;
                            } while (!this.j.equals(paramObject.j));
                            bool1 = bool2;
                          } while (this.c != paramObject.c);
                          bool1 = bool2;
                        } while (this.b != paramObject.b);
                        if (this.f != null) {
                          break;
                        }
                        n = 1;
                        if (paramObject.f != null) {
                          break label495;
                        }
                        i1 = 1;
                        bool1 = bool2;
                      } while ((n ^ i1) != 0);
                      if (this.f == null) {
                        break;
                      }
                      bool1 = bool2;
                    } while (!this.f.a().equals(paramObject.f.a()));
                    if (this.e != null) {
                      break label500;
                    }
                    n = 1;
                    if (paramObject.e != null) {
                      break label505;
                    }
                    i1 = 1;
                    bool1 = bool2;
                  } while ((n ^ i1) != 0);
                  if (this.e == null) {
                    break;
                  }
                  bool1 = bool2;
                } while (!this.e.a().equals(paramObject.e.a()));
                if (this.d != null) {
                  break label510;
                }
                n = 1;
                if (paramObject.d != null) {
                  break label515;
                }
                i1 = 1;
                bool1 = bool2;
              } while ((n ^ i1) != 0);
              if (this.d == null) {
                break;
              }
              bool1 = bool2;
            } while (!this.d.a().equals(paramObject.d.a()));
            if (this.g != null) {
              break label520;
            }
            n = 1;
            if (paramObject.g != null) {
              break label525;
            }
            i1 = 1;
            bool1 = bool2;
          } while ((n ^ i1) != 0);
          if (this.g == null) {
            break;
          }
          bool1 = bool2;
        } while (!this.g.a().equals(paramObject.g.a()));
        if (this.h != null) {
          break label530;
        }
        n = 1;
        if (paramObject.h != null) {
          break label535;
        }
        i1 = 1;
        bool1 = bool2;
      } while ((n ^ i1) != 0);
      if (this.h == null) {
        break;
      }
      bool1 = bool2;
    } while (!this.h.a().equals(paramObject.h.a()));
    if (this.i == null)
    {
      n = 1;
      label434:
      if (paramObject.i != null) {
        break label545;
      }
    }
    label495:
    label500:
    label505:
    label510:
    label515:
    label520:
    label525:
    label530:
    label535:
    label545:
    for (int i1 = 1;; i1 = 0)
    {
      bool1 = bool2;
      if ((n ^ i1) != 0) {
        break;
      }
      if (this.i != null)
      {
        bool1 = bool2;
        if (!this.i.a().equals(paramObject.i.a())) {
          break;
        }
      }
      return true;
      n = 0;
      break label119;
      i1 = 0;
      break label128;
      n = 0;
      break label182;
      i1 = 0;
      break label191;
      n = 0;
      break label245;
      i1 = 0;
      break label254;
      n = 0;
      break label308;
      i1 = 0;
      break label317;
      n = 0;
      break label371;
      i1 = 0;
      break label380;
      n = 0;
      break label434;
    }
  }
  
  public int hashCode()
  {
    int i1 = 0;
    int i2;
    if (this.l == 0)
    {
      this.l = this.a.hashCode();
      this.l = (this.l * 31 + this.j.hashCode());
      this.l = (this.l * 31 + this.b);
      this.l = (this.l * 31 + this.c);
      i2 = this.l;
      if (this.d == null) {
        break label290;
      }
      n = this.d.a().hashCode();
      this.l = (n + i2 * 31);
      i2 = this.l;
      if (this.e == null) {
        break label295;
      }
      n = this.e.a().hashCode();
      label133:
      this.l = (n + i2 * 31);
      i2 = this.l;
      if (this.f == null) {
        break label300;
      }
      n = this.f.a().hashCode();
      label168:
      this.l = (n + i2 * 31);
      i2 = this.l;
      if (this.g == null) {
        break label305;
      }
      n = this.g.a().hashCode();
      label203:
      this.l = (n + i2 * 31);
      i2 = this.l;
      if (this.h == null) {
        break label310;
      }
    }
    label290:
    label295:
    label300:
    label305:
    label310:
    for (int n = this.h.a().hashCode();; n = 0)
    {
      this.l = (n + i2 * 31);
      i2 = this.l;
      n = i1;
      if (this.i != null) {
        n = this.i.a().hashCode();
      }
      this.l = (i2 * 31 + n);
      return this.l;
      n = 0;
      break;
      n = 0;
      break label133;
      n = 0;
      break label168;
      n = 0;
      break label203;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    if (this.k == null)
    {
      localStringBuilder = new StringBuilder().append("EngineKey{").append(this.a).append('+').append(this.j).append("+[").append(this.b).append('x').append(this.c).append("]+").append('\'');
      if (this.d == null) {
        break label307;
      }
      str = this.d.a();
      localStringBuilder = localStringBuilder.append(str).append('\'').append('+').append('\'');
      if (this.e == null) {
        break label313;
      }
      str = this.e.a();
      label128:
      localStringBuilder = localStringBuilder.append(str).append('\'').append('+').append('\'');
      if (this.f == null) {
        break label319;
      }
      str = this.f.a();
      label166:
      localStringBuilder = localStringBuilder.append(str).append('\'').append('+').append('\'');
      if (this.g == null) {
        break label325;
      }
      str = this.g.a();
      label204:
      localStringBuilder = localStringBuilder.append(str).append('\'').append('+').append('\'');
      if (this.h == null) {
        break label331;
      }
      str = this.h.a();
      label242:
      localStringBuilder = localStringBuilder.append(str).append('\'').append('+').append('\'');
      if (this.i == null) {
        break label337;
      }
    }
    label307:
    label313:
    label319:
    label325:
    label331:
    label337:
    for (String str = this.i.a();; str = "")
    {
      this.k = (str + '\'' + '}');
      return this.k;
      str = "";
      break;
      str = "";
      break label128;
      str = "";
      break label166;
      str = "";
      break label204;
      str = "";
      break label242;
    }
  }
}
