package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.tls.RealTrustRootIndex;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;

public class Platform
{
  private static final Platform a = ;
  
  public Platform() {}
  
  public static Platform a()
  {
    return a;
  }
  
  static Object a(Object paramObject, Class paramClass, String paramString)
  {
    Class localClass = paramObject.getClass();
    while (localClass != Object.class) {
      try
      {
        Object localObject = localClass.getDeclaredField(paramString);
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(paramObject);
        if ((localObject == null) || (!paramClass.isInstance(localObject))) {
          break label110;
        }
        localObject = paramClass.cast(localObject);
        return localObject;
      }
      catch (IllegalAccessException paramObject)
      {
        throw new AssertionError();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    if (!paramString.equals("delegate"))
    {
      paramObject = a(paramObject, Object.class, "delegate");
      if (paramObject != null) {
        return a(paramObject, paramClass, paramString);
      }
    }
    return null;
    label110:
    return null;
  }
  
  static byte[] a(List paramList)
  {
    Buffer localBuffer = new Buffer();
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol == Protocol.a) {}
      for (;;)
      {
        i += 1;
        break;
        localBuffer.b(localProtocol.toString().length());
        localBuffer.a(localProtocol.toString());
      }
    }
    return localBuffer.s();
  }
  
  /* Error */
  private static Platform c()
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 111	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore 4
    //   7: new 113	com/squareup/okhttp/internal/OptionalMethod
    //   10: dup
    //   11: aconst_null
    //   12: ldc 115
    //   14: iconst_1
    //   15: anewarray 29	java/lang/Class
    //   18: dup
    //   19: iconst_0
    //   20: getstatic 121	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   23: aastore
    //   24: invokespecial 124	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   27: astore 6
    //   29: new 113	com/squareup/okhttp/internal/OptionalMethod
    //   32: dup
    //   33: aconst_null
    //   34: ldc 126
    //   36: iconst_1
    //   37: anewarray 29	java/lang/Class
    //   40: dup
    //   41: iconst_0
    //   42: ldc 60
    //   44: aastore
    //   45: invokespecial 124	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   48: astore 7
    //   50: ldc -128
    //   52: invokestatic 111	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   55: astore_0
    //   56: aload_0
    //   57: ldc -126
    //   59: iconst_1
    //   60: anewarray 29	java/lang/Class
    //   63: dup
    //   64: iconst_0
    //   65: ldc -124
    //   67: aastore
    //   68: invokevirtual 136	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   71: astore_2
    //   72: aload_0
    //   73: ldc -118
    //   75: iconst_1
    //   76: anewarray 29	java/lang/Class
    //   79: dup
    //   80: iconst_0
    //   81: ldc -124
    //   83: aastore
    //   84: invokevirtual 136	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   87: astore_0
    //   88: ldc -116
    //   90: invokestatic 111	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   93: pop
    //   94: new 113	com/squareup/okhttp/internal/OptionalMethod
    //   97: dup
    //   98: ldc -114
    //   100: ldc -112
    //   102: iconst_0
    //   103: anewarray 29	java/lang/Class
    //   106: invokespecial 124	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   109: astore_1
    //   110: new 113	com/squareup/okhttp/internal/OptionalMethod
    //   113: dup
    //   114: aconst_null
    //   115: ldc -110
    //   117: iconst_1
    //   118: anewarray 29	java/lang/Class
    //   121: dup
    //   122: iconst_0
    //   123: ldc -114
    //   125: aastore
    //   126: invokespecial 124	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   129: astore_3
    //   130: new 148	com/squareup/okhttp/internal/Platform$Android
    //   133: dup
    //   134: aload 4
    //   136: aload 6
    //   138: aload 7
    //   140: aload_2
    //   141: aload_0
    //   142: aload_1
    //   143: aload_3
    //   144: invokespecial 151	com/squareup/okhttp/internal/Platform$Android:<init>	(Ljava/lang/Class;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;)V
    //   147: areturn
    //   148: astore_0
    //   149: ldc -103
    //   151: invokestatic 111	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   154: astore 4
    //   156: goto -149 -> 7
    //   159: astore_1
    //   160: aconst_null
    //   161: astore_1
    //   162: aconst_null
    //   163: astore_3
    //   164: goto -34 -> 130
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_0
    //   170: aconst_null
    //   171: astore_1
    //   172: aconst_null
    //   173: astore_3
    //   174: aload_0
    //   175: astore_2
    //   176: aload_3
    //   177: astore_0
    //   178: aconst_null
    //   179: astore 5
    //   181: aload_0
    //   182: astore_3
    //   183: aload_1
    //   184: astore_0
    //   185: aload_3
    //   186: astore_1
    //   187: aload 5
    //   189: astore_3
    //   190: goto -60 -> 130
    //   193: astore_0
    //   194: ldc -101
    //   196: invokestatic 111	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   199: astore_0
    //   200: ldc -99
    //   202: invokestatic 111	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   205: astore_1
    //   206: new 159	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   213: ldc -99
    //   215: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc -90
    //   220: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 111	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   229: astore_2
    //   230: new 159	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   237: ldc -99
    //   239: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc -87
    //   244: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 111	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   253: astore_3
    //   254: new 159	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   261: ldc -99
    //   263: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc -85
    //   268: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 111	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   277: astore 4
    //   279: new 173	com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform
    //   282: dup
    //   283: aload_0
    //   284: aload_1
    //   285: ldc -81
    //   287: iconst_2
    //   288: anewarray 29	java/lang/Class
    //   291: dup
    //   292: iconst_0
    //   293: ldc -79
    //   295: aastore
    //   296: dup
    //   297: iconst_1
    //   298: aload_2
    //   299: aastore
    //   300: invokevirtual 136	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   303: aload_1
    //   304: ldc -78
    //   306: iconst_1
    //   307: anewarray 29	java/lang/Class
    //   310: dup
    //   311: iconst_0
    //   312: ldc -79
    //   314: aastore
    //   315: invokevirtual 136	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   318: aload_1
    //   319: ldc -76
    //   321: iconst_1
    //   322: anewarray 29	java/lang/Class
    //   325: dup
    //   326: iconst_0
    //   327: ldc -79
    //   329: aastore
    //   330: invokevirtual 136	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   333: aload_3
    //   334: aload 4
    //   336: invokespecial 183	com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform:<init>	(Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   339: astore_1
    //   340: aload_1
    //   341: areturn
    //   342: astore_1
    //   343: new 185	com/squareup/okhttp/internal/Platform$JdkPlatform
    //   346: dup
    //   347: aload_0
    //   348: invokespecial 188	com/squareup/okhttp/internal/Platform$JdkPlatform:<init>	(Ljava/lang/Class;)V
    //   351: astore_0
    //   352: aload_0
    //   353: areturn
    //   354: astore_0
    //   355: new 2	com/squareup/okhttp/internal/Platform
    //   358: dup
    //   359: invokespecial 189	com/squareup/okhttp/internal/Platform:<init>	()V
    //   362: areturn
    //   363: astore_1
    //   364: goto -21 -> 343
    //   367: astore_0
    //   368: aconst_null
    //   369: astore_0
    //   370: aconst_null
    //   371: astore_1
    //   372: aconst_null
    //   373: astore_2
    //   374: goto -196 -> 178
    //   377: astore_0
    //   378: aconst_null
    //   379: astore_0
    //   380: aconst_null
    //   381: astore_1
    //   382: goto -204 -> 178
    //   385: astore_1
    //   386: aconst_null
    //   387: astore_3
    //   388: aload_0
    //   389: astore_1
    //   390: aload_3
    //   391: astore_0
    //   392: goto -214 -> 178
    //   395: astore_3
    //   396: aload_0
    //   397: astore_3
    //   398: aload_1
    //   399: astore_0
    //   400: aload_3
    //   401: astore_1
    //   402: goto -224 -> 178
    //   405: astore_0
    //   406: aload_2
    //   407: astore_0
    //   408: goto -238 -> 170
    //   411: astore_3
    //   412: goto -250 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   55	87	0	localObject1	Object
    //   148	1	0	localClassNotFoundException1	ClassNotFoundException
    //   167	1	0	localClassNotFoundException2	ClassNotFoundException
    //   169	16	0	localObject2	Object
    //   193	1	0	localClassNotFoundException3	ClassNotFoundException
    //   199	154	0	localObject3	Object
    //   354	1	0	localClassNotFoundException4	ClassNotFoundException
    //   367	1	0	localNoSuchMethodException1	NoSuchMethodException
    //   369	1	0	localObject4	Object
    //   377	1	0	localNoSuchMethodException2	NoSuchMethodException
    //   379	21	0	localObject5	Object
    //   405	1	0	localClassNotFoundException5	ClassNotFoundException
    //   407	1	0	localObject6	Object
    //   109	34	1	localOptionalMethod1	OptionalMethod
    //   159	1	1	localClassNotFoundException6	ClassNotFoundException
    //   161	180	1	localObject7	Object
    //   342	1	1	localClassNotFoundException7	ClassNotFoundException
    //   363	1	1	localNoSuchMethodException3	NoSuchMethodException
    //   371	11	1	localObject8	Object
    //   385	1	1	localNoSuchMethodException4	NoSuchMethodException
    //   389	13	1	localObject9	Object
    //   71	336	2	localObject10	Object
    //   129	262	3	localObject11	Object
    //   395	1	3	localNoSuchMethodException5	NoSuchMethodException
    //   397	4	3	localObject12	Object
    //   411	1	3	localClassNotFoundException8	ClassNotFoundException
    //   5	330	4	localClass	Class
    //   179	9	5	localObject13	Object
    //   27	110	6	localOptionalMethod2	OptionalMethod
    //   48	91	7	localOptionalMethod3	OptionalMethod
    // Exception table:
    //   from	to	target	type
    //   0	7	148	java/lang/ClassNotFoundException
    //   88	110	159	java/lang/ClassNotFoundException
    //   50	72	167	java/lang/ClassNotFoundException
    //   7	50	193	java/lang/ClassNotFoundException
    //   130	148	193	java/lang/ClassNotFoundException
    //   149	156	193	java/lang/ClassNotFoundException
    //   200	340	342	java/lang/ClassNotFoundException
    //   194	200	354	java/lang/ClassNotFoundException
    //   343	352	354	java/lang/ClassNotFoundException
    //   200	340	363	java/lang/NoSuchMethodException
    //   50	72	367	java/lang/NoSuchMethodException
    //   72	88	377	java/lang/NoSuchMethodException
    //   88	110	385	java/lang/NoSuchMethodException
    //   110	130	395	java/lang/NoSuchMethodException
    //   72	88	405	java/lang/ClassNotFoundException
    //   110	130	411	java/lang/ClassNotFoundException
  }
  
  public TrustRootIndex a(X509TrustManager paramX509TrustManager)
  {
    return new RealTrustRootIndex(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public X509TrustManager a(SSLSocketFactory paramSSLSocketFactory)
  {
    return null;
  }
  
  public void a(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public void a(SSLSocket paramSSLSocket) {}
  
  public void a(SSLSocket paramSSLSocket, String paramString, List paramList) {}
  
  public String b()
  {
    return "OkHttp";
  }
  
  public String b(SSLSocket paramSSLSocket)
  {
    return null;
  }
}
