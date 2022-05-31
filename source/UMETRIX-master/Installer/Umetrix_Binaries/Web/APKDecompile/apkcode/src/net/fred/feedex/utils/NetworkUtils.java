package net.fred.feedex.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.Html;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpURLConnection;
import java.net.URL;
import net.fred.feedex.MainApplication;
import net.fred.feedex.provider.FeedData.EntryColumns;

public class NetworkUtils
{
  public static final File a = new File(MainApplication.a().getCacheDir(), "images/");
  public static final String b = a.getAbsolutePath() + '/';
  private static final CookieManager c = new NetworkUtils.1();
  
  public static String a(long paramLong, String paramString)
  {
    File localFile = new File(b(paramLong, paramString));
    if (localFile.exists()) {
      paramString = Uri.fromFile(localFile).toString();
    }
    return paramString;
  }
  
  public static String a(String paramString)
  {
    int i = paramString.indexOf('/', 8);
    String str = paramString;
    if (i > -1) {
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static HttpURLConnection a(URL paramURL)
  {
    paramURL = new OkUrlFactory(new OkHttpClient()).a(paramURL);
    paramURL.setDoInput(true);
    paramURL.setDoOutput(false);
    paramURL.setRequestProperty("User-agent", "Mozilla/5.0 (compatible) AppleWebKit Chrome Safari");
    paramURL.setConnectTimeout(30000);
    paramURL.setReadTimeout(30000);
    paramURL.setUseCaches(false);
    paramURL.setInstanceFollowRedirects(true);
    paramURL.setRequestProperty("accept", "*/*");
    c.getCookieStore().removeAll();
    paramURL.connect();
    return paramURL;
  }
  
  /* Error */
  public static void a(Context paramContext, URL paramURL, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 4
    //   6: iconst_0
    //   7: istore 6
    //   9: iconst_0
    //   10: istore 5
    //   12: aconst_null
    //   13: astore 8
    //   15: new 151	java/net/URL
    //   18: dup
    //   19: new 35	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   26: aload_1
    //   27: invokevirtual 154	java/net/URL:getProtocol	()Ljava/lang/String;
    //   30: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc -100
    //   35: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 159	java/net/URL:getHost	()Ljava/lang/String;
    //   42: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc -95
    //   47: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 162	java/net/URL:<init>	(Ljava/lang/String;)V
    //   56: invokestatic 163	net/fred/feedex/utils/NetworkUtils:a	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   59: astore_1
    //   60: iload 6
    //   62: istore 4
    //   64: aload_1
    //   65: invokevirtual 167	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   68: invokestatic 170	net/fred/feedex/utils/NetworkUtils:a	(Ljava/io/InputStream;)[B
    //   71: astore 8
    //   73: iload 7
    //   75: istore_3
    //   76: aload 8
    //   78: ifnull +125 -> 203
    //   81: iload 7
    //   83: istore_3
    //   84: iload 6
    //   86: istore 4
    //   88: aload 8
    //   90: arraylength
    //   91: ifle +112 -> 203
    //   94: iload 6
    //   96: istore 4
    //   98: aload 8
    //   100: iconst_0
    //   101: aload 8
    //   103: arraylength
    //   104: invokestatic 176	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   107: astore 9
    //   109: iload 7
    //   111: istore_3
    //   112: aload 9
    //   114: ifnull +89 -> 203
    //   117: iload 5
    //   119: istore_3
    //   120: iload 6
    //   122: istore 4
    //   124: aload 9
    //   126: invokevirtual 182	android/graphics/Bitmap:getWidth	()I
    //   129: ifeq +66 -> 195
    //   132: iload 5
    //   134: istore_3
    //   135: iload 6
    //   137: istore 4
    //   139: aload 9
    //   141: invokevirtual 185	android/graphics/Bitmap:getHeight	()I
    //   144: ifeq +51 -> 195
    //   147: iload 6
    //   149: istore 4
    //   151: new 187	android/content/ContentValues
    //   154: dup
    //   155: invokespecial 188	android/content/ContentValues:<init>	()V
    //   158: astore 10
    //   160: iload 6
    //   162: istore 4
    //   164: aload 10
    //   166: ldc -66
    //   168: aload 8
    //   170: invokevirtual 194	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   173: iload 6
    //   175: istore 4
    //   177: aload_0
    //   178: invokevirtual 198	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   181: aload_2
    //   182: invokestatic 203	net/fred/feedex/provider/FeedData$FeedColumns:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   185: aload 10
    //   187: aconst_null
    //   188: aconst_null
    //   189: invokevirtual 209	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   192: pop
    //   193: iconst_1
    //   194: istore_3
    //   195: iload_3
    //   196: istore 4
    //   198: aload 9
    //   200: invokevirtual 212	android/graphics/Bitmap:recycle	()V
    //   203: iload_3
    //   204: istore 5
    //   206: aload_1
    //   207: ifnull +10 -> 217
    //   210: aload_1
    //   211: invokevirtual 215	java/net/HttpURLConnection:disconnect	()V
    //   214: iload_3
    //   215: istore 5
    //   217: iload 5
    //   219: ifne +32 -> 251
    //   222: new 187	android/content/ContentValues
    //   225: dup
    //   226: invokespecial 188	android/content/ContentValues:<init>	()V
    //   229: astore_1
    //   230: aload_1
    //   231: ldc -66
    //   233: invokevirtual 218	android/content/ContentValues:putNull	(Ljava/lang/String;)V
    //   236: aload_0
    //   237: invokevirtual 198	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   240: aload_2
    //   241: invokestatic 203	net/fred/feedex/provider/FeedData$FeedColumns:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   244: aload_1
    //   245: aconst_null
    //   246: aconst_null
    //   247: invokevirtual 209	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   250: pop
    //   251: return
    //   252: astore_1
    //   253: aconst_null
    //   254: astore_1
    //   255: iload 4
    //   257: istore 5
    //   259: aload_1
    //   260: ifnull -43 -> 217
    //   263: aload_1
    //   264: invokevirtual 215	java/net/HttpURLConnection:disconnect	()V
    //   267: iload 4
    //   269: istore 5
    //   271: goto -54 -> 217
    //   274: astore_0
    //   275: aload 8
    //   277: astore_1
    //   278: aload_1
    //   279: ifnull +7 -> 286
    //   282: aload_1
    //   283: invokevirtual 215	java/net/HttpURLConnection:disconnect	()V
    //   286: aload_0
    //   287: athrow
    //   288: astore_0
    //   289: goto -11 -> 278
    //   292: astore 8
    //   294: goto -39 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramContext	Context
    //   0	297	1	paramURL	URL
    //   0	297	2	paramString	String
    //   75	140	3	i	int
    //   4	264	4	j	int
    //   10	260	5	k	int
    //   7	167	6	m	int
    //   1	109	7	n	int
    //   13	263	8	arrayOfByte	byte[]
    //   292	1	8	localThrowable	Throwable
    //   107	92	9	localBitmap	android.graphics.Bitmap
    //   158	28	10	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   15	60	252	java/lang/Throwable
    //   15	60	274	finally
    //   64	73	288	finally
    //   88	94	288	finally
    //   98	109	288	finally
    //   124	132	288	finally
    //   139	147	288	finally
    //   151	160	288	finally
    //   164	173	288	finally
    //   177	193	288	finally
    //   198	203	288	finally
    //   64	73	292	java/lang/Throwable
    //   88	94	292	java/lang/Throwable
    //   98	109	292	java/lang/Throwable
    //   124	132	292	java/lang/Throwable
    //   139	147	292	java/lang/Throwable
    //   151	160	292	java/lang/Throwable
    //   164	173	292	java/lang/Throwable
    //   177	193	292	java/lang/Throwable
    //   198	203	292	java/lang/Throwable
  }
  
  public static void a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    try
    {
      if (a.exists())
      {
        NetworkUtils.PictureFilenameFilter localPictureFilenameFilter = new NetworkUtils.PictureFilenameFilter();
        paramUri = MainApplication.a().getContentResolver().query(paramUri, FeedData.EntryColumns.a, paramString, paramArrayOfString, null);
        while (paramUri.moveToNext())
        {
          localPictureFilenameFilter.a(paramUri.getString(0));
          paramString = a.listFiles(localPictureFilenameFilter);
          if (paramString != null)
          {
            int j = paramString.length;
            int i = 0;
            while (i < j)
            {
              paramString[i].delete();
              i += 1;
            }
          }
        }
        paramUri.close();
      }
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    Object localObject = PrefUtils.a("preload_image_mode", "WIFI_ONLY_PRELOAD");
    if (PrefUtils.a("display_images", true))
    {
      if ("ALWAYS_PRELOAD".equals(localObject)) {
        return true;
      }
      if ("WIFI_ONLY_PRELOAD".equals(localObject))
      {
        localObject = ((ConnectivityManager)MainApplication.a().getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['?'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    paramInputStream.close();
    return arrayOfByte;
  }
  
  public static String b(long paramLong, String paramString)
  {
    return b + paramLong + "__" + StringUtils.a(paramString);
  }
  
  public static HttpURLConnection b(String paramString)
  {
    return a(new URL(paramString));
  }
  
  public static void c(long paramLong, String paramString)
  {
    String str1 = d(paramLong, paramString);
    String str2 = b(paramLong, paramString);
    if ((!new File(str1).exists()) && (!new File(str2).exists()))
    {
      InputStream localInputStream = null;
      FileOutputStream localFileOutputStream = null;
      Object localObject2 = localFileOutputStream;
      Object localObject1 = localInputStream;
      try
      {
        a.mkdir();
        localObject2 = localFileOutputStream;
        localObject1 = localInputStream;
        paramString = b(Html.fromHtml(paramString).toString());
        localObject2 = paramString;
        localObject1 = paramString;
        localFileOutputStream = new FileOutputStream(str1);
        localObject2 = paramString;
        localObject1 = paramString;
        localInputStream = paramString.getInputStream();
        localObject2 = paramString;
        localObject1 = paramString;
        byte[] arrayOfByte = new byte['?'];
        for (;;)
        {
          localObject2 = paramString;
          localObject1 = paramString;
          int i = localInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localObject2 = paramString;
          localObject1 = paramString;
          localFileOutputStream.write(arrayOfByte, 0, i);
        }
        localObject2 = paramString;
      }
      catch (IOException paramString)
      {
        localObject1 = localObject2;
        new File(str1).delete();
        localObject1 = localObject2;
        throw paramString;
      }
      finally
      {
        if (localObject1 != null) {
          ((HttpURLConnection)localObject1).disconnect();
        }
      }
      localObject1 = paramString;
      localFileOutputStream.flush();
      localObject2 = paramString;
      localObject1 = paramString;
      localFileOutputStream.close();
      localObject2 = paramString;
      localObject1 = paramString;
      localInputStream.close();
      localObject2 = paramString;
      localObject1 = paramString;
      new File(str1).renameTo(new File(str2));
      if (paramString != null) {
        paramString.disconnect();
      }
    }
  }
  
  private static String d(long paramLong, String paramString)
  {
    return b + "TEMP__" + paramLong + "__" + StringUtils.a(paramString);
  }
}
