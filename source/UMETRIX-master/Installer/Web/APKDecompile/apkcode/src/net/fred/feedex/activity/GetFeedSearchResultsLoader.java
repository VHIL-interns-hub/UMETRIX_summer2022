package net.fred.feedex.activity;

import android.content.Context;
import net.fred.feedex.loader.BaseLoader;

class GetFeedSearchResultsLoader
  extends BaseLoader
{
  private final String a;
  
  public GetFeedSearchResultsLoader(Context paramContext, String paramString)
  {
    super(paramContext);
    this.a = paramString;
  }
  
  /* Error */
  public java.util.ArrayList a()
  {
    // Byte code:
    //   0: new 19	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   7: ldc 24
    //   9: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_0
    //   13: getfield 13	net/fred/feedex/activity/GetFeedSearchResultsLoader:a	Ljava/lang/String;
    //   16: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 38	net/fred/feedex/utils/NetworkUtils:b	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   25: astore_3
    //   26: new 40	java/lang/String
    //   29: dup
    //   30: aload_3
    //   31: invokevirtual 46	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   34: invokestatic 49	net/fred/feedex/utils/NetworkUtils:a	(Ljava/io/InputStream;)[B
    //   37: invokespecial 52	java/lang/String:<init>	([B)V
    //   40: astore 5
    //   42: new 54	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 55	java/util/ArrayList:<init>	()V
    //   49: astore 4
    //   51: new 57	org/json/JSONObject
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 60	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   60: ldc 62
    //   62: invokevirtual 66	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   65: ldc 68
    //   67: invokevirtual 72	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   70: astore 5
    //   72: iconst_0
    //   73: istore_1
    //   74: aload 5
    //   76: invokevirtual 78	org/json/JSONArray:length	()I
    //   79: istore_2
    //   80: iload_1
    //   81: iload_2
    //   82: if_icmpge +116 -> 198
    //   85: aload 5
    //   87: iload_1
    //   88: invokevirtual 82	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   91: checkcast 57	org/json/JSONObject
    //   94: astore 6
    //   96: aload 6
    //   98: ldc 84
    //   100: invokevirtual 87	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   103: invokevirtual 90	java/lang/Object:toString	()Ljava/lang/String;
    //   106: astore 7
    //   108: aload 7
    //   110: invokevirtual 94	java/lang/String:isEmpty	()Z
    //   113: ifne +78 -> 191
    //   116: new 96	java/util/HashMap
    //   119: dup
    //   120: invokespecial 97	java/util/HashMap:<init>	()V
    //   123: astore 8
    //   125: aload 8
    //   127: ldc 99
    //   129: aload 6
    //   131: ldc 99
    //   133: invokevirtual 87	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   136: invokevirtual 90	java/lang/Object:toString	()Ljava/lang/String;
    //   139: invokestatic 105	android/text/Html:fromHtml	(Ljava/lang/String;)Landroid/text/Spanned;
    //   142: invokevirtual 90	java/lang/Object:toString	()Ljava/lang/String;
    //   145: invokevirtual 109	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: pop
    //   149: aload 8
    //   151: ldc 84
    //   153: aload 7
    //   155: invokevirtual 109	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: aload 8
    //   161: ldc 111
    //   163: aload 6
    //   165: ldc 111
    //   167: invokevirtual 87	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   170: invokevirtual 90	java/lang/Object:toString	()Ljava/lang/String;
    //   173: invokestatic 105	android/text/Html:fromHtml	(Ljava/lang/String;)Landroid/text/Spanned;
    //   176: invokevirtual 90	java/lang/Object:toString	()Ljava/lang/String;
    //   179: invokevirtual 109	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   182: pop
    //   183: aload 4
    //   185: aload 8
    //   187: invokevirtual 115	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   190: pop
    //   191: iload_1
    //   192: iconst_1
    //   193: iadd
    //   194: istore_1
    //   195: goto -121 -> 74
    //   198: aload_3
    //   199: invokevirtual 118	java/net/HttpURLConnection:disconnect	()V
    //   202: aload 4
    //   204: areturn
    //   205: astore 4
    //   207: aload_3
    //   208: invokevirtual 118	java/net/HttpURLConnection:disconnect	()V
    //   211: aload 4
    //   213: athrow
    //   214: astore_3
    //   215: ldc 120
    //   217: aload_3
    //   218: invokestatic 125	net/fred/feedex/utils/Dog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   221: aconst_null
    //   222: areturn
    //   223: astore 6
    //   225: goto -34 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	GetFeedSearchResultsLoader
    //   73	122	1	i	int
    //   79	4	2	j	int
    //   25	183	3	localHttpURLConnection	java.net.HttpURLConnection
    //   214	4	3	localException1	Exception
    //   49	154	4	localArrayList	java.util.ArrayList
    //   205	7	4	localObject1	Object
    //   40	46	5	localObject2	Object
    //   94	70	6	localJSONObject	org.json.JSONObject
    //   223	1	6	localException2	Exception
    //   106	48	7	str	String
    //   123	63	8	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   26	72	205	finally
    //   74	80	205	finally
    //   85	191	205	finally
    //   0	26	214	java/lang/Exception
    //   198	202	214	java/lang/Exception
    //   207	214	214	java/lang/Exception
    //   85	191	223	java/lang/Exception
  }
}
