package net.fred.feedex.service;

import android.app.IntentService;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import net.fred.feedex.Constants;
import net.fred.feedex.MainApplication;
import net.fred.feedex.activity.HomeActivity;
import net.fred.feedex.provider.FeedData.EntryColumns;
import net.fred.feedex.provider.FeedData.FeedColumns;
import net.fred.feedex.provider.FeedData.TaskColumns;
import net.fred.feedex.utils.NetworkUtils;
import net.fred.feedex.utils.PrefUtils;

public class FetcherService
  extends IntentService
{
  private static final Pattern a = Pattern.compile("[.]*<link[^>]* ((rel=alternate|rel=\"alternate\")[^>]* href=\"[^\"]*\"|href=\"[^\"]*\"[^>]* (rel=alternate|rel=\"alternate\"))[^>]*>", 2);
  private final Handler b;
  
  public FetcherService()
  {
    super(FetcherService.class.getSimpleName());
    HttpURLConnection.setFollowRedirects(true);
    this.b = new Handler();
  }
  
  /* Error */
  private int a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 56	net/fred/feedex/service/FetcherService:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 20
    //   6: aload 20
    //   8: aload_1
    //   9: invokestatic 61	net/fred/feedex/provider/FeedData$FeedColumns:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 67	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 18
    //   21: aload 18
    //   23: invokeinterface 73 1 0
    //   28: ifeq +2571 -> 2599
    //   31: aload 18
    //   33: ldc 75
    //   35: invokeinterface 79 2 0
    //   40: istore 4
    //   42: aload 18
    //   44: ldc 81
    //   46: invokeinterface 79 2 0
    //   51: istore 9
    //   53: aload 18
    //   55: ldc 83
    //   57: invokeinterface 79 2 0
    //   62: istore 6
    //   64: aload 18
    //   66: ldc 85
    //   68: invokeinterface 79 2 0
    //   73: istore 10
    //   75: aload 18
    //   77: ldc 87
    //   79: invokeinterface 79 2 0
    //   84: istore 7
    //   86: aload 18
    //   88: ldc 89
    //   90: invokeinterface 79 2 0
    //   95: istore 5
    //   97: aload 18
    //   99: ldc 91
    //   101: invokeinterface 79 2 0
    //   106: istore 8
    //   108: aload 18
    //   110: iload 9
    //   112: invokeinterface 95 2 0
    //   117: astore 19
    //   119: aconst_null
    //   120: astore 12
    //   122: aload 18
    //   124: iload 4
    //   126: invokeinterface 95 2 0
    //   131: astore 21
    //   133: aload 21
    //   135: invokestatic 100	net/fred/feedex/utils/NetworkUtils:b	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 103	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   143: astore 12
    //   145: aload 18
    //   147: iload 10
    //   149: invokeinterface 107 2 0
    //   154: istore 4
    //   156: new 109	java/util/Date
    //   159: dup
    //   160: aload 18
    //   162: iload 7
    //   164: invokeinterface 113 2 0
    //   169: invokespecial 116	java/util/Date:<init>	(J)V
    //   172: astore 13
    //   174: aload 18
    //   176: iload 6
    //   178: invokeinterface 95 2 0
    //   183: astore 14
    //   185: aload 18
    //   187: iload 8
    //   189: invokeinterface 107 2 0
    //   194: iconst_1
    //   195: if_icmpne +597 -> 792
    //   198: iconst_1
    //   199: istore 11
    //   201: new 118	net/fred/feedex/parser/RssAtomParser
    //   204: dup
    //   205: aload 13
    //   207: lload_2
    //   208: aload 19
    //   210: aload 14
    //   212: aload 21
    //   214: iload 11
    //   216: invokespecial 121	net/fred/feedex/parser/RssAtomParser:<init>	(Ljava/util/Date;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   219: astore 15
    //   221: aload 15
    //   223: astore 14
    //   225: aload_1
    //   226: astore 13
    //   228: aload 15
    //   230: invokestatic 123	net/fred/feedex/utils/NetworkUtils:a	()Z
    //   233: invokevirtual 125	net/fred/feedex/parser/RssAtomParser:a	(Z)V
    //   236: iload 4
    //   238: ifne +2351 -> 2589
    //   241: aload 12
    //   243: ifnull +2339 -> 2582
    //   246: aload 15
    //   248: astore 14
    //   250: aload_1
    //   251: astore 13
    //   253: aload 12
    //   255: ldc 127
    //   257: invokevirtual 133	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   260: ifeq +2322 -> 2582
    //   263: aload 15
    //   265: astore 14
    //   267: aload_1
    //   268: astore 13
    //   270: new 135	java/io/BufferedReader
    //   273: dup
    //   274: new 137	java/io/InputStreamReader
    //   277: dup
    //   278: aload_1
    //   279: invokevirtual 141	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   282: invokespecial 144	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   285: invokespecial 147	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   288: astore 16
    //   290: iconst_m1
    //   291: istore 4
    //   293: aload 15
    //   295: astore 14
    //   297: aload_1
    //   298: astore 13
    //   300: aload 16
    //   302: invokevirtual 150	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   305: astore 17
    //   307: aload 17
    //   309: ifnull +2267 -> 2576
    //   312: aload 15
    //   314: astore 14
    //   316: aload_1
    //   317: astore 13
    //   319: aload 17
    //   321: ldc -104
    //   323: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   326: istore 11
    //   328: iload 11
    //   330: ifeq +468 -> 798
    //   333: aload_1
    //   334: astore 14
    //   336: iload 4
    //   338: iconst_m1
    //   339: if_icmpne +2224 -> 2563
    //   342: aload 14
    //   344: astore 12
    //   346: aload 14
    //   348: astore 13
    //   350: aload 14
    //   352: astore_1
    //   353: aload 15
    //   355: astore 17
    //   357: aload 14
    //   359: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   362: aload 14
    //   364: astore 12
    //   366: aload 14
    //   368: astore 13
    //   370: aload 14
    //   372: astore_1
    //   373: aload 15
    //   375: astore 17
    //   377: aload 21
    //   379: invokestatic 100	net/fred/feedex/utils/NetworkUtils:b	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   382: astore 14
    //   384: aload 14
    //   386: astore 12
    //   388: aload 14
    //   390: astore 13
    //   392: aload 14
    //   394: astore_1
    //   395: aload 15
    //   397: astore 17
    //   399: aload 14
    //   401: invokevirtual 103	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   404: astore 16
    //   406: aload 14
    //   408: astore_1
    //   409: aload 16
    //   411: ifnull +822 -> 1233
    //   414: aload 16
    //   416: ldc -95
    //   418: invokevirtual 164	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   421: istore 4
    //   423: iload 4
    //   425: iconst_m1
    //   426: if_icmple +801 -> 1227
    //   429: aload 16
    //   431: bipush 59
    //   433: iload 4
    //   435: invokevirtual 167	java/lang/String:indexOf	(II)I
    //   438: istore 6
    //   440: iload 6
    //   442: iconst_m1
    //   443: if_icmple +761 -> 1204
    //   446: aload 16
    //   448: iload 4
    //   450: bipush 8
    //   452: iadd
    //   453: iload 6
    //   455: invokevirtual 171	java/lang/String:substring	(II)Ljava/lang/String;
    //   458: astore 12
    //   460: aload 12
    //   462: invokestatic 177	android/util/Xml:findEncodingByName	(Ljava/lang/String;)Landroid/util/Xml$Encoding;
    //   465: pop
    //   466: iconst_1
    //   467: istore 4
    //   469: aload_1
    //   470: astore 14
    //   472: aload 14
    //   474: astore 12
    //   476: aload 14
    //   478: astore 13
    //   480: aload 14
    //   482: astore_1
    //   483: aload 15
    //   485: astore 17
    //   487: new 179	android/content/ContentValues
    //   490: dup
    //   491: invokespecial 180	android/content/ContentValues:<init>	()V
    //   494: astore 21
    //   496: aload 14
    //   498: astore 12
    //   500: aload 14
    //   502: astore 13
    //   504: aload 14
    //   506: astore_1
    //   507: aload 15
    //   509: astore 17
    //   511: aload 21
    //   513: ldc 85
    //   515: iload 4
    //   517: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   520: invokevirtual 190	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   523: aload 14
    //   525: astore 12
    //   527: aload 14
    //   529: astore 13
    //   531: aload 14
    //   533: astore_1
    //   534: aload 15
    //   536: astore 17
    //   538: aload 20
    //   540: aload 19
    //   542: invokestatic 61	net/fred/feedex/provider/FeedData$FeedColumns:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   545: aload 21
    //   547: aconst_null
    //   548: aconst_null
    //   549: invokevirtual 194	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   552: pop
    //   553: goto +2052 -> 2605
    //   556: aload 16
    //   558: ifnull +854 -> 1412
    //   561: aload 14
    //   563: astore 12
    //   565: aload 14
    //   567: astore 13
    //   569: aload 14
    //   571: astore_1
    //   572: aload 15
    //   574: astore 17
    //   576: aload 16
    //   578: ldc -95
    //   580: invokevirtual 164	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   583: istore 4
    //   585: aload 14
    //   587: astore 12
    //   589: aload 14
    //   591: astore 13
    //   593: aload 14
    //   595: astore_1
    //   596: aload 15
    //   598: astore 17
    //   600: aload 16
    //   602: bipush 59
    //   604: iload 4
    //   606: invokevirtual 167	java/lang/String:indexOf	(II)I
    //   609: istore 6
    //   611: aload 14
    //   613: astore 12
    //   615: aload 14
    //   617: astore 13
    //   619: aload 14
    //   621: astore_1
    //   622: aload 15
    //   624: astore 17
    //   626: aload 14
    //   628: invokevirtual 141	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   631: astore 21
    //   633: iload 6
    //   635: iconst_m1
    //   636: if_icmple +746 -> 1382
    //   639: aload 14
    //   641: astore 12
    //   643: aload 14
    //   645: astore 13
    //   647: aload 14
    //   649: astore_1
    //   650: aload 15
    //   652: astore 17
    //   654: aload 16
    //   656: iload 4
    //   658: bipush 8
    //   660: iadd
    //   661: iload 6
    //   663: invokevirtual 171	java/lang/String:substring	(II)Ljava/lang/String;
    //   666: astore 16
    //   668: aload 14
    //   670: astore 12
    //   672: aload 14
    //   674: astore 13
    //   676: aload 14
    //   678: astore_1
    //   679: aload 15
    //   681: astore 17
    //   683: aload 21
    //   685: aload 16
    //   687: invokestatic 177	android/util/Xml:findEncodingByName	(Ljava/lang/String;)Landroid/util/Xml$Encoding;
    //   690: aload 15
    //   692: invokestatic 198	android/util/Xml:parse	(Ljava/io/InputStream;Landroid/util/Xml$Encoding;Lorg/xml/sax/ContentHandler;)V
    //   695: aload 14
    //   697: astore 12
    //   699: aload 14
    //   701: astore 13
    //   703: aload 14
    //   705: astore_1
    //   706: aload 15
    //   708: astore 17
    //   710: aload 14
    //   712: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   715: aload 15
    //   717: ifnull +39 -> 756
    //   720: aload 18
    //   722: iload 5
    //   724: invokeinterface 202 2 0
    //   729: ifnonnull +27 -> 756
    //   732: aload 15
    //   734: invokevirtual 204	net/fred/feedex/parser/RssAtomParser:a	()Ljava/lang/String;
    //   737: astore_1
    //   738: aload_1
    //   739: ifnull +1634 -> 2373
    //   742: aload_0
    //   743: new 206	java/net/URL
    //   746: dup
    //   747: aload_1
    //   748: invokespecial 207	java/net/URL:<init>	(Ljava/lang/String;)V
    //   751: aload 19
    //   753: invokestatic 210	net/fred/feedex/utils/NetworkUtils:a	(Landroid/content/Context;Ljava/net/URL;Ljava/lang/String;)V
    //   756: aload 15
    //   758: astore 13
    //   760: aload 14
    //   762: ifnull +12 -> 774
    //   765: aload 14
    //   767: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   770: aload 15
    //   772: astore 13
    //   774: aload 18
    //   776: invokeinterface 213 1 0
    //   781: aload 13
    //   783: ifnull +1681 -> 2464
    //   786: aload 13
    //   788: invokevirtual 216	net/fred/feedex/parser/RssAtomParser:b	()I
    //   791: ireturn
    //   792: iconst_0
    //   793: istore 11
    //   795: goto -594 -> 201
    //   798: aload 15
    //   800: astore 14
    //   802: aload_1
    //   803: astore 13
    //   805: getstatic 20	net/fred/feedex/service/FetcherService:a	Ljava/util/regex/Pattern;
    //   808: aload 17
    //   810: invokevirtual 220	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   813: astore 17
    //   815: aload 15
    //   817: astore 14
    //   819: aload_1
    //   820: astore 13
    //   822: aload 17
    //   824: invokevirtual 225	java/util/regex/Matcher:find	()Z
    //   827: ifeq -534 -> 293
    //   830: aload 15
    //   832: astore 14
    //   834: aload_1
    //   835: astore 13
    //   837: aload 17
    //   839: invokevirtual 228	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   842: astore 17
    //   844: aload 15
    //   846: astore 14
    //   848: aload_1
    //   849: astore 13
    //   851: aload 17
    //   853: ldc -26
    //   855: invokevirtual 164	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   858: istore 4
    //   860: iload 4
    //   862: iconst_m1
    //   863: if_icmple +1710 -> 2573
    //   866: aload 15
    //   868: astore 14
    //   870: aload_1
    //   871: astore 13
    //   873: aload 17
    //   875: iload 4
    //   877: bipush 6
    //   879: iadd
    //   880: aload 17
    //   882: bipush 34
    //   884: iload 4
    //   886: bipush 10
    //   888: iadd
    //   889: invokevirtual 167	java/lang/String:indexOf	(II)I
    //   892: invokevirtual 171	java/lang/String:substring	(II)Ljava/lang/String;
    //   895: ldc -24
    //   897: ldc -22
    //   899: invokevirtual 238	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   902: astore 16
    //   904: aload 15
    //   906: astore 14
    //   908: aload_1
    //   909: astore 13
    //   911: new 179	android/content/ContentValues
    //   914: dup
    //   915: invokespecial 180	android/content/ContentValues:<init>	()V
    //   918: astore 17
    //   920: aload 15
    //   922: astore 14
    //   924: aload_1
    //   925: astore 13
    //   927: aload 16
    //   929: ldc -16
    //   931: invokevirtual 133	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   934: ifeq +190 -> 1124
    //   937: aload 15
    //   939: astore 14
    //   941: aload_1
    //   942: astore 13
    //   944: aload 21
    //   946: bipush 47
    //   948: bipush 8
    //   950: invokevirtual 167	java/lang/String:indexOf	(II)I
    //   953: istore 6
    //   955: iload 6
    //   957: iconst_m1
    //   958: if_icmple +134 -> 1092
    //   961: aload 15
    //   963: astore 14
    //   965: aload_1
    //   966: astore 13
    //   968: new 242	java/lang/StringBuilder
    //   971: dup
    //   972: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   975: aload 21
    //   977: iconst_0
    //   978: iload 6
    //   980: invokevirtual 171	java/lang/String:substring	(II)Ljava/lang/String;
    //   983: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload 16
    //   988: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   994: astore 12
    //   996: aload 15
    //   998: astore 14
    //   1000: aload_1
    //   1001: astore 13
    //   1003: aload 17
    //   1005: ldc 75
    //   1007: aload 12
    //   1009: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1012: aload 15
    //   1014: astore 14
    //   1016: aload_1
    //   1017: astore 13
    //   1019: aload 20
    //   1021: aload 19
    //   1023: invokestatic 61	net/fred/feedex/provider/FeedData$FeedColumns:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   1026: aload 17
    //   1028: aconst_null
    //   1029: aconst_null
    //   1030: invokevirtual 194	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1033: pop
    //   1034: aload 15
    //   1036: astore 14
    //   1038: aload_1
    //   1039: astore 13
    //   1041: aload_1
    //   1042: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   1045: aload 15
    //   1047: astore 14
    //   1049: aload_1
    //   1050: astore 13
    //   1052: aload 12
    //   1054: invokestatic 100	net/fred/feedex/utils/NetworkUtils:b	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   1057: astore 12
    //   1059: aload 12
    //   1061: astore 14
    //   1063: aload 14
    //   1065: astore 12
    //   1067: aload 14
    //   1069: astore 13
    //   1071: aload 14
    //   1073: astore_1
    //   1074: aload 15
    //   1076: astore 17
    //   1078: aload 14
    //   1080: invokevirtual 103	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1083: astore 16
    //   1085: aload 16
    //   1087: astore 12
    //   1089: goto -753 -> 336
    //   1092: aload 15
    //   1094: astore 14
    //   1096: aload_1
    //   1097: astore 13
    //   1099: new 242	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1106: aload 21
    //   1108: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: aload 16
    //   1113: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: astore 12
    //   1121: goto -125 -> 996
    //   1124: aload 16
    //   1126: astore 12
    //   1128: aload 15
    //   1130: astore 14
    //   1132: aload_1
    //   1133: astore 13
    //   1135: aload 16
    //   1137: ldc -1
    //   1139: invokevirtual 133	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1142: ifne -146 -> 996
    //   1145: aload 16
    //   1147: astore 12
    //   1149: aload 15
    //   1151: astore 14
    //   1153: aload_1
    //   1154: astore 13
    //   1156: aload 16
    //   1158: ldc_w 257
    //   1161: invokevirtual 133	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1164: ifne -168 -> 996
    //   1167: aload 15
    //   1169: astore 14
    //   1171: aload_1
    //   1172: astore 13
    //   1174: new 242	java/lang/StringBuilder
    //   1177: dup
    //   1178: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1181: aload 21
    //   1183: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: bipush 47
    //   1188: invokevirtual 260	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1191: aload 16
    //   1193: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1199: astore 12
    //   1201: goto -205 -> 996
    //   1204: aload 16
    //   1206: iload 4
    //   1208: bipush 8
    //   1210: iadd
    //   1211: invokevirtual 262	java/lang/String:substring	(I)Ljava/lang/String;
    //   1214: astore 12
    //   1216: goto -756 -> 460
    //   1219: astore 12
    //   1221: iconst_2
    //   1222: istore 4
    //   1224: goto -755 -> 469
    //   1227: iconst_2
    //   1228: istore 4
    //   1230: goto -761 -> 469
    //   1233: new 135	java/io/BufferedReader
    //   1236: dup
    //   1237: new 137	java/io/InputStreamReader
    //   1240: dup
    //   1241: aload_1
    //   1242: invokevirtual 141	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1245: invokespecial 144	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1248: invokespecial 147	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1251: astore 12
    //   1253: bipush 20
    //   1255: newarray char
    //   1257: astore 13
    //   1259: new 129	java/lang/String
    //   1262: dup
    //   1263: aload 13
    //   1265: iconst_0
    //   1266: aload 12
    //   1268: aload 13
    //   1270: invokevirtual 266	java/io/BufferedReader:read	([C)I
    //   1273: invokespecial 269	java/lang/String:<init>	([CII)V
    //   1276: astore 21
    //   1278: aload_1
    //   1279: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   1282: aload_1
    //   1283: invokevirtual 273	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   1286: invokestatic 276	net/fred/feedex/utils/NetworkUtils:a	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   1289: astore 14
    //   1291: aload 14
    //   1293: astore 12
    //   1295: aload 14
    //   1297: astore 13
    //   1299: aload 14
    //   1301: astore_1
    //   1302: aload 15
    //   1304: astore 17
    //   1306: aload 21
    //   1308: ldc_w 278
    //   1311: invokevirtual 164	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1314: istore 4
    //   1316: iload 4
    //   1318: iconst_m1
    //   1319: if_icmple +57 -> 1376
    //   1322: aload 14
    //   1324: astore 12
    //   1326: aload 14
    //   1328: astore 13
    //   1330: aload 14
    //   1332: astore_1
    //   1333: aload 15
    //   1335: astore 17
    //   1337: aload 21
    //   1339: iload 4
    //   1341: bipush 10
    //   1343: iadd
    //   1344: aload 21
    //   1346: bipush 34
    //   1348: iload 4
    //   1350: bipush 11
    //   1352: iadd
    //   1353: invokevirtual 167	java/lang/String:indexOf	(II)I
    //   1356: invokevirtual 171	java/lang/String:substring	(II)Ljava/lang/String;
    //   1359: invokestatic 177	android/util/Xml:findEncodingByName	(Ljava/lang/String;)Landroid/util/Xml$Encoding;
    //   1362: pop
    //   1363: iconst_1
    //   1364: istore 4
    //   1366: goto -894 -> 472
    //   1369: astore_1
    //   1370: iconst_2
    //   1371: istore 4
    //   1373: goto -901 -> 472
    //   1376: iconst_1
    //   1377: istore 4
    //   1379: goto -907 -> 472
    //   1382: aload 14
    //   1384: astore 12
    //   1386: aload 14
    //   1388: astore 13
    //   1390: aload 14
    //   1392: astore_1
    //   1393: aload 15
    //   1395: astore 17
    //   1397: aload 16
    //   1399: iload 4
    //   1401: bipush 8
    //   1403: iadd
    //   1404: invokevirtual 262	java/lang/String:substring	(I)Ljava/lang/String;
    //   1407: astore 16
    //   1409: goto -741 -> 668
    //   1412: aload 14
    //   1414: astore 12
    //   1416: aload 14
    //   1418: astore 13
    //   1420: aload 14
    //   1422: astore_1
    //   1423: aload 15
    //   1425: astore 17
    //   1427: new 137	java/io/InputStreamReader
    //   1430: dup
    //   1431: aload 14
    //   1433: invokevirtual 141	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1436: invokespecial 144	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1439: aload 15
    //   1441: invokestatic 281	android/util/Xml:parse	(Ljava/io/Reader;Lorg/xml/sax/ContentHandler;)V
    //   1444: goto -749 -> 695
    //   1447: astore_1
    //   1448: aload 15
    //   1450: ifnull +33 -> 1483
    //   1453: aload 12
    //   1455: astore_1
    //   1456: aload 15
    //   1458: astore 17
    //   1460: aload 15
    //   1462: invokevirtual 284	net/fred/feedex/parser/RssAtomParser:c	()Z
    //   1465: ifne +96 -> 1561
    //   1468: aload 12
    //   1470: astore_1
    //   1471: aload 15
    //   1473: astore 17
    //   1475: aload 15
    //   1477: invokevirtual 287	net/fred/feedex/parser/RssAtomParser:d	()Z
    //   1480: ifne +81 -> 1561
    //   1483: aload 12
    //   1485: astore_1
    //   1486: aload 15
    //   1488: astore 17
    //   1490: new 179	android/content/ContentValues
    //   1493: dup
    //   1494: invokespecial 180	android/content/ContentValues:<init>	()V
    //   1497: astore 13
    //   1499: aload 12
    //   1501: astore_1
    //   1502: aload 15
    //   1504: astore 17
    //   1506: aload 13
    //   1508: ldc 85
    //   1510: iconst_0
    //   1511: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1514: invokevirtual 190	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1517: aload 12
    //   1519: astore_1
    //   1520: aload 15
    //   1522: astore 17
    //   1524: aload 13
    //   1526: ldc_w 289
    //   1529: aload_0
    //   1530: ldc_w 290
    //   1533: invokevirtual 291	net/fred/feedex/service/FetcherService:getString	(I)Ljava/lang/String;
    //   1536: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1539: aload 12
    //   1541: astore_1
    //   1542: aload 15
    //   1544: astore 17
    //   1546: aload 20
    //   1548: aload 19
    //   1550: invokestatic 61	net/fred/feedex/provider/FeedData$FeedColumns:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   1553: aload 13
    //   1555: aconst_null
    //   1556: aconst_null
    //   1557: invokevirtual 194	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1560: pop
    //   1561: aload 15
    //   1563: ifnull +39 -> 1602
    //   1566: aload 18
    //   1568: iload 5
    //   1570: invokeinterface 202 2 0
    //   1575: ifnonnull +27 -> 1602
    //   1578: aload 15
    //   1580: invokevirtual 204	net/fred/feedex/parser/RssAtomParser:a	()Ljava/lang/String;
    //   1583: astore_1
    //   1584: aload_1
    //   1585: ifnull +806 -> 2391
    //   1588: aload_0
    //   1589: new 206	java/net/URL
    //   1592: dup
    //   1593: aload_1
    //   1594: invokespecial 207	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1597: aload 19
    //   1599: invokestatic 210	net/fred/feedex/utils/NetworkUtils:a	(Landroid/content/Context;Ljava/net/URL;Ljava/lang/String;)V
    //   1602: aload 15
    //   1604: astore 13
    //   1606: aload 12
    //   1608: ifnull -834 -> 774
    //   1611: aload 12
    //   1613: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   1616: aload 15
    //   1618: astore 13
    //   1620: goto -846 -> 774
    //   1623: aload 14
    //   1625: astore 12
    //   1627: aload 14
    //   1629: astore 13
    //   1631: aload 14
    //   1633: astore_1
    //   1634: aload 15
    //   1636: astore 17
    //   1638: new 293	java/io/ByteArrayOutputStream
    //   1641: dup
    //   1642: invokespecial 294	java/io/ByteArrayOutputStream:<init>	()V
    //   1645: astore 21
    //   1647: aload 14
    //   1649: astore 12
    //   1651: aload 14
    //   1653: astore 13
    //   1655: aload 14
    //   1657: astore_1
    //   1658: aload 15
    //   1660: astore 17
    //   1662: aload 14
    //   1664: invokevirtual 141	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1667: astore 22
    //   1669: aload 14
    //   1671: astore 12
    //   1673: aload 14
    //   1675: astore 13
    //   1677: aload 14
    //   1679: astore_1
    //   1680: aload 15
    //   1682: astore 17
    //   1684: sipush 4096
    //   1687: newarray byte
    //   1689: astore 23
    //   1691: aload 14
    //   1693: astore 12
    //   1695: aload 14
    //   1697: astore 13
    //   1699: aload 14
    //   1701: astore_1
    //   1702: aload 15
    //   1704: astore 17
    //   1706: aload 22
    //   1708: aload 23
    //   1710: invokevirtual 299	java/io/InputStream:read	([B)I
    //   1713: istore 4
    //   1715: iload 4
    //   1717: ifle +236 -> 1953
    //   1720: aload 14
    //   1722: astore 12
    //   1724: aload 14
    //   1726: astore 13
    //   1728: aload 14
    //   1730: astore_1
    //   1731: aload 15
    //   1733: astore 17
    //   1735: aload 21
    //   1737: aload 23
    //   1739: iconst_0
    //   1740: iload 4
    //   1742: invokevirtual 303	java/io/ByteArrayOutputStream:write	([BII)V
    //   1745: goto -54 -> 1691
    //   1748: astore 12
    //   1750: aload 13
    //   1752: astore_1
    //   1753: aload 15
    //   1755: ifnull +33 -> 1788
    //   1758: aload 15
    //   1760: astore 14
    //   1762: aload_1
    //   1763: astore 13
    //   1765: aload 15
    //   1767: invokevirtual 284	net/fred/feedex/parser/RssAtomParser:c	()Z
    //   1770: ifne +120 -> 1890
    //   1773: aload 15
    //   1775: astore 14
    //   1777: aload_1
    //   1778: astore 13
    //   1780: aload 15
    //   1782: invokevirtual 287	net/fred/feedex/parser/RssAtomParser:d	()Z
    //   1785: ifne +105 -> 1890
    //   1788: aload 15
    //   1790: astore 14
    //   1792: aload_1
    //   1793: astore 13
    //   1795: new 179	android/content/ContentValues
    //   1798: dup
    //   1799: invokespecial 180	android/content/ContentValues:<init>	()V
    //   1802: astore 16
    //   1804: aload 15
    //   1806: astore 14
    //   1808: aload_1
    //   1809: astore 13
    //   1811: aload 16
    //   1813: ldc 85
    //   1815: iconst_0
    //   1816: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1819: invokevirtual 190	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1822: aload 15
    //   1824: astore 14
    //   1826: aload_1
    //   1827: astore 13
    //   1829: aload 12
    //   1831: invokevirtual 306	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1834: ifnull +575 -> 2409
    //   1837: aload 15
    //   1839: astore 14
    //   1841: aload_1
    //   1842: astore 13
    //   1844: aload 12
    //   1846: invokevirtual 306	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1849: astore 12
    //   1851: aload 15
    //   1853: astore 14
    //   1855: aload_1
    //   1856: astore 13
    //   1858: aload 16
    //   1860: ldc_w 289
    //   1863: aload 12
    //   1865: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1868: aload 15
    //   1870: astore 14
    //   1872: aload_1
    //   1873: astore 13
    //   1875: aload 20
    //   1877: aload 19
    //   1879: invokestatic 61	net/fred/feedex/provider/FeedData$FeedColumns:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   1882: aload 16
    //   1884: aconst_null
    //   1885: aconst_null
    //   1886: invokevirtual 194	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1889: pop
    //   1890: aload 15
    //   1892: ifnull +42 -> 1934
    //   1895: aload 18
    //   1897: iload 5
    //   1899: invokeinterface 202 2 0
    //   1904: ifnonnull +30 -> 1934
    //   1907: aload 15
    //   1909: invokevirtual 204	net/fred/feedex/parser/RssAtomParser:a	()Ljava/lang/String;
    //   1912: astore 12
    //   1914: aload 12
    //   1916: ifnull +512 -> 2428
    //   1919: aload_0
    //   1920: new 206	java/net/URL
    //   1923: dup
    //   1924: aload 12
    //   1926: invokespecial 207	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1929: aload 19
    //   1931: invokestatic 210	net/fred/feedex/utils/NetworkUtils:a	(Landroid/content/Context;Ljava/net/URL;Ljava/lang/String;)V
    //   1934: aload 15
    //   1936: astore 13
    //   1938: aload_1
    //   1939: ifnull -1165 -> 774
    //   1942: aload_1
    //   1943: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   1946: aload 15
    //   1948: astore 13
    //   1950: goto -1176 -> 774
    //   1953: aload 14
    //   1955: astore 12
    //   1957: aload 14
    //   1959: astore 13
    //   1961: aload 14
    //   1963: astore_1
    //   1964: aload 15
    //   1966: astore 17
    //   1968: aload 21
    //   1970: invokevirtual 307	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   1973: astore 22
    //   1975: aload 22
    //   1977: ifnull +159 -> 2136
    //   1980: aload 14
    //   1982: astore 12
    //   1984: aload 14
    //   1986: astore 13
    //   1988: aload 14
    //   1990: astore_1
    //   1991: aload 15
    //   1993: astore 17
    //   1995: aload 22
    //   1997: ldc_w 278
    //   2000: invokevirtual 164	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2003: istore 4
    //   2005: iload 4
    //   2007: iconst_m1
    //   2008: if_icmple +134 -> 2142
    //   2011: aload 14
    //   2013: astore 12
    //   2015: aload 14
    //   2017: astore 13
    //   2019: aload 14
    //   2021: astore_1
    //   2022: aload 15
    //   2024: astore 17
    //   2026: new 309	java/io/StringReader
    //   2029: dup
    //   2030: new 129	java/lang/String
    //   2033: dup
    //   2034: aload 21
    //   2036: invokevirtual 313	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   2039: aload 22
    //   2041: iload 4
    //   2043: bipush 10
    //   2045: iadd
    //   2046: aload 22
    //   2048: bipush 34
    //   2050: iload 4
    //   2052: bipush 11
    //   2054: iadd
    //   2055: invokevirtual 167	java/lang/String:indexOf	(II)I
    //   2058: invokevirtual 171	java/lang/String:substring	(II)Ljava/lang/String;
    //   2061: invokespecial 316	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2064: invokespecial 317	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   2067: aload 15
    //   2069: invokestatic 281	android/util/Xml:parse	(Ljava/io/Reader;Lorg/xml/sax/ContentHandler;)V
    //   2072: goto -1377 -> 695
    //   2075: astore 12
    //   2077: aload 17
    //   2079: astore 15
    //   2081: aload 15
    //   2083: ifnull +42 -> 2125
    //   2086: aload 18
    //   2088: iload 5
    //   2090: invokeinterface 202 2 0
    //   2095: ifnonnull +30 -> 2125
    //   2098: aload 15
    //   2100: invokevirtual 204	net/fred/feedex/parser/RssAtomParser:a	()Ljava/lang/String;
    //   2103: astore 13
    //   2105: aload 13
    //   2107: ifnull +339 -> 2446
    //   2110: aload_0
    //   2111: new 206	java/net/URL
    //   2114: dup
    //   2115: aload 13
    //   2117: invokespecial 207	java/net/URL:<init>	(Ljava/lang/String;)V
    //   2120: aload 19
    //   2122: invokestatic 210	net/fred/feedex/utils/NetworkUtils:a	(Landroid/content/Context;Ljava/net/URL;Ljava/lang/String;)V
    //   2125: aload_1
    //   2126: ifnull +7 -> 2133
    //   2129: aload_1
    //   2130: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   2133: aload 12
    //   2135: athrow
    //   2136: iconst_m1
    //   2137: istore 4
    //   2139: goto -134 -> 2005
    //   2142: aload 16
    //   2144: ifnull -1449 -> 695
    //   2147: aload 14
    //   2149: astore 12
    //   2151: aload 14
    //   2153: astore 13
    //   2155: aload 14
    //   2157: astore_1
    //   2158: aload 15
    //   2160: astore 17
    //   2162: aload 16
    //   2164: ldc -95
    //   2166: invokevirtual 164	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2169: istore 4
    //   2171: iload 4
    //   2173: iconst_m1
    //   2174: if_icmple +157 -> 2331
    //   2177: aload 14
    //   2179: astore 12
    //   2181: aload 14
    //   2183: astore 13
    //   2185: aload 14
    //   2187: astore_1
    //   2188: aload 15
    //   2190: astore 17
    //   2192: aload 16
    //   2194: bipush 59
    //   2196: iload 4
    //   2198: invokevirtual 167	java/lang/String:indexOf	(II)I
    //   2201: istore 6
    //   2203: aload 14
    //   2205: astore 12
    //   2207: aload 14
    //   2209: astore 13
    //   2211: aload 14
    //   2213: astore_1
    //   2214: aload 15
    //   2216: astore 17
    //   2218: aload 21
    //   2220: invokevirtual 313	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   2223: astore 21
    //   2225: iload 6
    //   2227: iconst_m1
    //   2228: if_icmple +73 -> 2301
    //   2231: aload 14
    //   2233: astore 12
    //   2235: aload 14
    //   2237: astore 13
    //   2239: aload 14
    //   2241: astore_1
    //   2242: aload 15
    //   2244: astore 17
    //   2246: aload 16
    //   2248: iload 4
    //   2250: bipush 8
    //   2252: iadd
    //   2253: iload 6
    //   2255: invokevirtual 171	java/lang/String:substring	(II)Ljava/lang/String;
    //   2258: astore 16
    //   2260: aload 14
    //   2262: astore 12
    //   2264: aload 14
    //   2266: astore 13
    //   2268: aload 14
    //   2270: astore_1
    //   2271: aload 15
    //   2273: astore 17
    //   2275: new 309	java/io/StringReader
    //   2278: dup
    //   2279: new 129	java/lang/String
    //   2282: dup
    //   2283: aload 21
    //   2285: aload 16
    //   2287: invokespecial 316	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2290: invokespecial 317	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   2293: aload 15
    //   2295: invokestatic 281	android/util/Xml:parse	(Ljava/io/Reader;Lorg/xml/sax/ContentHandler;)V
    //   2298: goto -1603 -> 695
    //   2301: aload 14
    //   2303: astore 12
    //   2305: aload 14
    //   2307: astore 13
    //   2309: aload 14
    //   2311: astore_1
    //   2312: aload 15
    //   2314: astore 17
    //   2316: aload 16
    //   2318: iload 4
    //   2320: bipush 8
    //   2322: iadd
    //   2323: invokevirtual 262	java/lang/String:substring	(I)Ljava/lang/String;
    //   2326: astore 16
    //   2328: goto -68 -> 2260
    //   2331: aload 14
    //   2333: astore 12
    //   2335: aload 14
    //   2337: astore 13
    //   2339: aload 14
    //   2341: astore_1
    //   2342: aload 15
    //   2344: astore 17
    //   2346: new 309	java/io/StringReader
    //   2349: dup
    //   2350: new 129	java/lang/String
    //   2353: dup
    //   2354: aload 21
    //   2356: invokevirtual 313	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   2359: invokespecial 320	java/lang/String:<init>	([B)V
    //   2362: invokespecial 317	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   2365: aload 15
    //   2367: invokestatic 281	android/util/Xml:parse	(Ljava/io/Reader;Lorg/xml/sax/ContentHandler;)V
    //   2370: goto -1675 -> 695
    //   2373: aload_0
    //   2374: aload 14
    //   2376: invokevirtual 273	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   2379: aload 19
    //   2381: invokestatic 210	net/fred/feedex/utils/NetworkUtils:a	(Landroid/content/Context;Ljava/net/URL;Ljava/lang/String;)V
    //   2384: goto -1628 -> 756
    //   2387: astore_1
    //   2388: goto -1632 -> 756
    //   2391: aload_0
    //   2392: aload 12
    //   2394: invokevirtual 273	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   2397: aload 19
    //   2399: invokestatic 210	net/fred/feedex/utils/NetworkUtils:a	(Landroid/content/Context;Ljava/net/URL;Ljava/lang/String;)V
    //   2402: goto -800 -> 1602
    //   2405: astore_1
    //   2406: goto -804 -> 1602
    //   2409: aload 15
    //   2411: astore 14
    //   2413: aload_1
    //   2414: astore 13
    //   2416: aload_0
    //   2417: ldc_w 321
    //   2420: invokevirtual 291	net/fred/feedex/service/FetcherService:getString	(I)Ljava/lang/String;
    //   2423: astore 12
    //   2425: goto -574 -> 1851
    //   2428: aload_0
    //   2429: aload_1
    //   2430: invokevirtual 273	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   2433: aload 19
    //   2435: invokestatic 210	net/fred/feedex/utils/NetworkUtils:a	(Landroid/content/Context;Ljava/net/URL;Ljava/lang/String;)V
    //   2438: goto -504 -> 1934
    //   2441: astore 12
    //   2443: goto -509 -> 1934
    //   2446: aload_0
    //   2447: aload_1
    //   2448: invokevirtual 273	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   2451: aload 19
    //   2453: invokestatic 210	net/fred/feedex/utils/NetworkUtils:a	(Landroid/content/Context;Ljava/net/URL;Ljava/lang/String;)V
    //   2456: goto -331 -> 2125
    //   2459: astore 13
    //   2461: goto -336 -> 2125
    //   2464: iconst_0
    //   2465: ireturn
    //   2466: astore 12
    //   2468: aconst_null
    //   2469: astore_1
    //   2470: aconst_null
    //   2471: astore 15
    //   2473: goto -392 -> 2081
    //   2476: astore 12
    //   2478: aconst_null
    //   2479: astore 15
    //   2481: goto -400 -> 2081
    //   2484: astore 12
    //   2486: aload 14
    //   2488: astore 15
    //   2490: aload 13
    //   2492: astore_1
    //   2493: goto -412 -> 2081
    //   2496: astore 12
    //   2498: goto -417 -> 2081
    //   2501: astore 12
    //   2503: aconst_null
    //   2504: astore_1
    //   2505: aconst_null
    //   2506: astore 15
    //   2508: goto -755 -> 1753
    //   2511: astore 12
    //   2513: aconst_null
    //   2514: astore 15
    //   2516: goto -763 -> 1753
    //   2519: astore 12
    //   2521: goto -768 -> 1753
    //   2524: astore 12
    //   2526: goto -773 -> 1753
    //   2529: astore_1
    //   2530: aconst_null
    //   2531: astore 15
    //   2533: goto -1085 -> 1448
    //   2536: astore 12
    //   2538: aconst_null
    //   2539: astore 15
    //   2541: aload_1
    //   2542: astore 12
    //   2544: goto -1096 -> 1448
    //   2547: astore 12
    //   2549: aload_1
    //   2550: astore 12
    //   2552: goto -1104 -> 1448
    //   2555: astore 12
    //   2557: aload_1
    //   2558: astore 12
    //   2560: goto -1112 -> 1448
    //   2563: aload 14
    //   2565: astore_1
    //   2566: aload 12
    //   2568: astore 16
    //   2570: goto -2161 -> 409
    //   2573: goto -2280 -> 293
    //   2576: aload_1
    //   2577: astore 14
    //   2579: goto -2243 -> 336
    //   2582: aload 12
    //   2584: astore 16
    //   2586: goto -2177 -> 409
    //   2589: aload_1
    //   2590: astore 14
    //   2592: aload 12
    //   2594: astore 16
    //   2596: goto +9 -> 2605
    //   2599: aconst_null
    //   2600: astore 13
    //   2602: goto -1828 -> 774
    //   2605: iload 4
    //   2607: tableswitch	default:+17->2624, 2:+-984->1623
    //   2624: goto -2068 -> 556
    //   2627: astore_1
    //   2628: goto -1933 -> 695
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2631	0	this	FetcherService
    //   0	2631	1	paramString	String
    //   0	2631	2	paramLong	long
    //   40	2566	4	i	int
    //   95	1994	5	j	int
    //   62	2192	6	k	int
    //   84	79	7	m	int
    //   106	82	8	n	int
    //   51	60	9	i1	int
    //   73	75	10	i2	int
    //   199	595	11	bool	boolean
    //   120	1095	12	localObject1	Object
    //   1219	1	12	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   1251	472	12	localObject2	Object
    //   1748	97	12	localThrowable1	Throwable
    //   1849	165	12	localObject3	Object
    //   2075	59	12	localObject4	Object
    //   2149	275	12	localObject5	Object
    //   2441	1	12	localThrowable2	Throwable
    //   2466	1	12	localObject6	Object
    //   2476	1	12	localObject7	Object
    //   2484	1	12	localObject8	Object
    //   2496	1	12	localObject9	Object
    //   2501	1	12	localThrowable3	Throwable
    //   2511	1	12	localThrowable4	Throwable
    //   2519	1	12	localThrowable5	Throwable
    //   2524	1	12	localThrowable6	Throwable
    //   2536	1	12	localFileNotFoundException1	java.io.FileNotFoundException
    //   2542	1	12	str1	String
    //   2547	1	12	localFileNotFoundException2	java.io.FileNotFoundException
    //   2550	1	12	str2	String
    //   2555	1	12	localFileNotFoundException3	java.io.FileNotFoundException
    //   2558	35	12	str3	String
    //   172	2243	13	localObject10	Object
    //   2459	32	13	localThrowable7	Throwable
    //   2600	1	13	localObject11	Object
    //   183	2408	14	localObject12	Object
    //   219	2321	15	localObject13	Object
    //   288	2307	16	localObject14	Object
    //   305	2040	17	localObject15	Object
    //   19	2068	18	localCursor	Cursor
    //   117	2335	19	str4	String
    //   4	1872	20	localContentResolver	ContentResolver
    //   131	2224	21	localObject16	Object
    //   1667	380	22	localObject17	Object
    //   1689	49	23	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   446	460	1219	java/io/UnsupportedEncodingException
    //   460	466	1219	java/io/UnsupportedEncodingException
    //   1204	1216	1219	java/io/UnsupportedEncodingException
    //   1337	1363	1369	java/io/UnsupportedEncodingException
    //   357	362	1447	java/io/FileNotFoundException
    //   377	384	1447	java/io/FileNotFoundException
    //   399	406	1447	java/io/FileNotFoundException
    //   487	496	1447	java/io/FileNotFoundException
    //   511	523	1447	java/io/FileNotFoundException
    //   538	553	1447	java/io/FileNotFoundException
    //   576	585	1447	java/io/FileNotFoundException
    //   600	611	1447	java/io/FileNotFoundException
    //   626	633	1447	java/io/FileNotFoundException
    //   654	668	1447	java/io/FileNotFoundException
    //   683	695	1447	java/io/FileNotFoundException
    //   710	715	1447	java/io/FileNotFoundException
    //   1078	1085	1447	java/io/FileNotFoundException
    //   1306	1316	1447	java/io/FileNotFoundException
    //   1337	1363	1447	java/io/FileNotFoundException
    //   1397	1409	1447	java/io/FileNotFoundException
    //   1427	1444	1447	java/io/FileNotFoundException
    //   1638	1647	1447	java/io/FileNotFoundException
    //   1662	1669	1447	java/io/FileNotFoundException
    //   1684	1691	1447	java/io/FileNotFoundException
    //   1706	1715	1447	java/io/FileNotFoundException
    //   1735	1745	1447	java/io/FileNotFoundException
    //   1968	1975	1447	java/io/FileNotFoundException
    //   1995	2005	1447	java/io/FileNotFoundException
    //   2026	2072	1447	java/io/FileNotFoundException
    //   2162	2171	1447	java/io/FileNotFoundException
    //   2192	2203	1447	java/io/FileNotFoundException
    //   2218	2225	1447	java/io/FileNotFoundException
    //   2246	2260	1447	java/io/FileNotFoundException
    //   2275	2298	1447	java/io/FileNotFoundException
    //   2316	2328	1447	java/io/FileNotFoundException
    //   2346	2370	1447	java/io/FileNotFoundException
    //   357	362	1748	java/lang/Throwable
    //   377	384	1748	java/lang/Throwable
    //   399	406	1748	java/lang/Throwable
    //   487	496	1748	java/lang/Throwable
    //   511	523	1748	java/lang/Throwable
    //   538	553	1748	java/lang/Throwable
    //   576	585	1748	java/lang/Throwable
    //   600	611	1748	java/lang/Throwable
    //   626	633	1748	java/lang/Throwable
    //   654	668	1748	java/lang/Throwable
    //   683	695	1748	java/lang/Throwable
    //   710	715	1748	java/lang/Throwable
    //   1078	1085	1748	java/lang/Throwable
    //   1306	1316	1748	java/lang/Throwable
    //   1337	1363	1748	java/lang/Throwable
    //   1397	1409	1748	java/lang/Throwable
    //   1427	1444	1748	java/lang/Throwable
    //   1638	1647	1748	java/lang/Throwable
    //   1662	1669	1748	java/lang/Throwable
    //   1684	1691	1748	java/lang/Throwable
    //   1706	1715	1748	java/lang/Throwable
    //   1735	1745	1748	java/lang/Throwable
    //   1968	1975	1748	java/lang/Throwable
    //   1995	2005	1748	java/lang/Throwable
    //   2026	2072	1748	java/lang/Throwable
    //   2162	2171	1748	java/lang/Throwable
    //   2192	2203	1748	java/lang/Throwable
    //   2218	2225	1748	java/lang/Throwable
    //   2246	2260	1748	java/lang/Throwable
    //   2275	2298	1748	java/lang/Throwable
    //   2316	2328	1748	java/lang/Throwable
    //   2346	2370	1748	java/lang/Throwable
    //   357	362	2075	finally
    //   377	384	2075	finally
    //   399	406	2075	finally
    //   487	496	2075	finally
    //   511	523	2075	finally
    //   538	553	2075	finally
    //   576	585	2075	finally
    //   600	611	2075	finally
    //   626	633	2075	finally
    //   654	668	2075	finally
    //   683	695	2075	finally
    //   710	715	2075	finally
    //   1078	1085	2075	finally
    //   1306	1316	2075	finally
    //   1337	1363	2075	finally
    //   1397	1409	2075	finally
    //   1427	1444	2075	finally
    //   1460	1468	2075	finally
    //   1475	1483	2075	finally
    //   1490	1499	2075	finally
    //   1506	1517	2075	finally
    //   1524	1539	2075	finally
    //   1546	1561	2075	finally
    //   1638	1647	2075	finally
    //   1662	1669	2075	finally
    //   1684	1691	2075	finally
    //   1706	1715	2075	finally
    //   1735	1745	2075	finally
    //   1968	1975	2075	finally
    //   1995	2005	2075	finally
    //   2026	2072	2075	finally
    //   2162	2171	2075	finally
    //   2192	2203	2075	finally
    //   2218	2225	2075	finally
    //   2246	2260	2075	finally
    //   2275	2298	2075	finally
    //   2316	2328	2075	finally
    //   2346	2370	2075	finally
    //   720	738	2387	java/lang/Throwable
    //   742	756	2387	java/lang/Throwable
    //   2373	2384	2387	java/lang/Throwable
    //   1566	1584	2405	java/lang/Throwable
    //   1588	1602	2405	java/lang/Throwable
    //   2391	2402	2405	java/lang/Throwable
    //   1895	1914	2441	java/lang/Throwable
    //   1919	1934	2441	java/lang/Throwable
    //   2428	2438	2441	java/lang/Throwable
    //   2086	2105	2459	java/lang/Throwable
    //   2110	2125	2459	java/lang/Throwable
    //   2446	2456	2459	java/lang/Throwable
    //   122	139	2466	finally
    //   139	198	2476	finally
    //   201	221	2476	finally
    //   228	236	2484	finally
    //   253	263	2484	finally
    //   270	290	2484	finally
    //   300	307	2484	finally
    //   319	328	2484	finally
    //   805	815	2484	finally
    //   822	830	2484	finally
    //   837	844	2484	finally
    //   851	860	2484	finally
    //   873	904	2484	finally
    //   911	920	2484	finally
    //   927	937	2484	finally
    //   944	955	2484	finally
    //   968	996	2484	finally
    //   1003	1012	2484	finally
    //   1019	1034	2484	finally
    //   1041	1045	2484	finally
    //   1052	1059	2484	finally
    //   1099	1121	2484	finally
    //   1135	1145	2484	finally
    //   1156	1167	2484	finally
    //   1174	1201	2484	finally
    //   1765	1773	2484	finally
    //   1780	1788	2484	finally
    //   1795	1804	2484	finally
    //   1811	1822	2484	finally
    //   1829	1837	2484	finally
    //   1844	1851	2484	finally
    //   1858	1868	2484	finally
    //   1875	1890	2484	finally
    //   2416	2425	2484	finally
    //   414	423	2496	finally
    //   429	440	2496	finally
    //   446	460	2496	finally
    //   460	466	2496	finally
    //   1204	1216	2496	finally
    //   1233	1291	2496	finally
    //   122	139	2501	java/lang/Throwable
    //   139	198	2511	java/lang/Throwable
    //   201	221	2511	java/lang/Throwable
    //   228	236	2519	java/lang/Throwable
    //   253	263	2519	java/lang/Throwable
    //   270	290	2519	java/lang/Throwable
    //   300	307	2519	java/lang/Throwable
    //   319	328	2519	java/lang/Throwable
    //   805	815	2519	java/lang/Throwable
    //   822	830	2519	java/lang/Throwable
    //   837	844	2519	java/lang/Throwable
    //   851	860	2519	java/lang/Throwable
    //   873	904	2519	java/lang/Throwable
    //   911	920	2519	java/lang/Throwable
    //   927	937	2519	java/lang/Throwable
    //   944	955	2519	java/lang/Throwable
    //   968	996	2519	java/lang/Throwable
    //   1003	1012	2519	java/lang/Throwable
    //   1019	1034	2519	java/lang/Throwable
    //   1041	1045	2519	java/lang/Throwable
    //   1052	1059	2519	java/lang/Throwable
    //   1099	1121	2519	java/lang/Throwable
    //   1135	1145	2519	java/lang/Throwable
    //   1156	1167	2519	java/lang/Throwable
    //   1174	1201	2519	java/lang/Throwable
    //   414	423	2524	java/lang/Throwable
    //   429	440	2524	java/lang/Throwable
    //   446	460	2524	java/lang/Throwable
    //   460	466	2524	java/lang/Throwable
    //   1204	1216	2524	java/lang/Throwable
    //   1233	1291	2524	java/lang/Throwable
    //   122	139	2529	java/io/FileNotFoundException
    //   139	198	2536	java/io/FileNotFoundException
    //   201	221	2536	java/io/FileNotFoundException
    //   228	236	2547	java/io/FileNotFoundException
    //   253	263	2547	java/io/FileNotFoundException
    //   270	290	2547	java/io/FileNotFoundException
    //   300	307	2547	java/io/FileNotFoundException
    //   319	328	2547	java/io/FileNotFoundException
    //   805	815	2547	java/io/FileNotFoundException
    //   822	830	2547	java/io/FileNotFoundException
    //   837	844	2547	java/io/FileNotFoundException
    //   851	860	2547	java/io/FileNotFoundException
    //   873	904	2547	java/io/FileNotFoundException
    //   911	920	2547	java/io/FileNotFoundException
    //   927	937	2547	java/io/FileNotFoundException
    //   944	955	2547	java/io/FileNotFoundException
    //   968	996	2547	java/io/FileNotFoundException
    //   1003	1012	2547	java/io/FileNotFoundException
    //   1019	1034	2547	java/io/FileNotFoundException
    //   1041	1045	2547	java/io/FileNotFoundException
    //   1052	1059	2547	java/io/FileNotFoundException
    //   1099	1121	2547	java/io/FileNotFoundException
    //   1135	1145	2547	java/io/FileNotFoundException
    //   1156	1167	2547	java/io/FileNotFoundException
    //   1174	1201	2547	java/io/FileNotFoundException
    //   414	423	2555	java/io/FileNotFoundException
    //   429	440	2555	java/io/FileNotFoundException
    //   446	460	2555	java/io/FileNotFoundException
    //   460	466	2555	java/io/FileNotFoundException
    //   1204	1216	2555	java/io/FileNotFoundException
    //   1233	1291	2555	java/io/FileNotFoundException
    //   2218	2225	2627	java/lang/Exception
    //   2246	2260	2627	java/lang/Exception
    //   2275	2298	2627	java/lang/Exception
    //   2316	2328	2627	java/lang/Exception
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 56	net/fred/feedex/service/FetcherService:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 14
    //   6: aload 14
    //   8: getstatic 329	net/fred/feedex/provider/FeedData$TaskColumns:c	Landroid/net/Uri;
    //   11: iconst_3
    //   12: anewarray 129	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: ldc 81
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: ldc_w 331
    //   25: aastore
    //   26: dup
    //   27: iconst_2
    //   28: ldc_w 333
    //   31: aastore
    //   32: ldc_w 335
    //   35: aconst_null
    //   36: aconst_null
    //   37: invokevirtual 67	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore 15
    //   42: new 337	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 338	java/util/ArrayList:<init>	()V
    //   49: astore 16
    //   51: aload 15
    //   53: invokeinterface 341 1 0
    //   58: ifeq +670 -> 728
    //   61: aload 15
    //   63: iconst_0
    //   64: invokeinterface 113 2 0
    //   69: lstore 6
    //   71: aload 15
    //   73: iconst_1
    //   74: invokeinterface 113 2 0
    //   79: lstore 8
    //   81: aload 15
    //   83: iconst_2
    //   84: invokeinterface 345 2 0
    //   89: ifne +708 -> 797
    //   92: aload 15
    //   94: iconst_2
    //   95: invokeinterface 107 2 0
    //   100: istore_3
    //   101: iconst_0
    //   102: istore 4
    //   104: iconst_0
    //   105: istore_2
    //   106: lload 8
    //   108: invokestatic 350	net/fred/feedex/provider/FeedData$EntryColumns:c	(J)Landroid/net/Uri;
    //   111: astore 18
    //   113: aload 14
    //   115: aload 18
    //   117: aconst_null
    //   118: aconst_null
    //   119: aconst_null
    //   120: aconst_null
    //   121: invokevirtual 67	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   124: astore 17
    //   126: aload 17
    //   128: invokeinterface 73 1 0
    //   133: ifeq +659 -> 792
    //   136: aload 17
    //   138: aload 17
    //   140: ldc_w 352
    //   143: invokeinterface 79 2 0
    //   148: invokeinterface 345 2 0
    //   153: ifeq +505 -> 658
    //   156: aload 17
    //   158: ldc_w 354
    //   161: invokeinterface 79 2 0
    //   166: istore_1
    //   167: aload 17
    //   169: ldc_w 356
    //   172: invokeinterface 79 2 0
    //   177: istore 5
    //   179: aconst_null
    //   180: astore 11
    //   182: aload 11
    //   184: astore 10
    //   186: aload 17
    //   188: iload_1
    //   189: invokeinterface 95 2 0
    //   194: astore 19
    //   196: aconst_null
    //   197: astore 13
    //   199: aload 11
    //   201: astore 10
    //   203: aload 17
    //   205: iload 5
    //   207: invokeinterface 95 2 0
    //   212: astore 20
    //   214: aload 13
    //   216: astore 12
    //   218: aload 11
    //   220: astore 10
    //   222: aload 20
    //   224: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   227: ifne +50 -> 277
    //   230: aload 11
    //   232: astore 10
    //   234: aload 20
    //   236: invokestatic 367	android/text/Html:fromHtml	(Ljava/lang/String;)Landroid/text/Spanned;
    //   239: invokevirtual 370	java/lang/Object:toString	()Ljava/lang/String;
    //   242: astore 20
    //   244: aload 13
    //   246: astore 12
    //   248: aload 11
    //   250: astore 10
    //   252: aload 20
    //   254: invokevirtual 373	java/lang/String:length	()I
    //   257: bipush 60
    //   259: if_icmple +18 -> 277
    //   262: aload 11
    //   264: astore 10
    //   266: aload 20
    //   268: bipush 20
    //   270: bipush 40
    //   272: invokevirtual 171	java/lang/String:substring	(II)Ljava/lang/String;
    //   275: astore 12
    //   277: aload 11
    //   279: astore 10
    //   281: aload 19
    //   283: invokestatic 100	net/fred/feedex/utils/NetworkUtils:b	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   286: astore 11
    //   288: aload 11
    //   290: astore 10
    //   292: iload 4
    //   294: istore_1
    //   295: aload 11
    //   297: invokevirtual 141	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   300: aload 12
    //   302: invokestatic 378	net/fred/feedex/utils/ArticleTextExtractor:a	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    //   305: astore 12
    //   307: aload 12
    //   309: ifnull +225 -> 534
    //   312: aload 11
    //   314: astore 10
    //   316: iload 4
    //   318: istore_1
    //   319: aload 12
    //   321: aload 19
    //   323: invokestatic 381	net/fred/feedex/utils/NetworkUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   326: invokestatic 386	net/fred/feedex/utils/HtmlUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   329: astore 13
    //   331: aload 11
    //   333: astore 10
    //   335: iload 4
    //   337: istore_1
    //   338: new 179	android/content/ContentValues
    //   341: dup
    //   342: invokespecial 180	android/content/ContentValues:<init>	()V
    //   345: astore 19
    //   347: aload 11
    //   349: astore 10
    //   351: iload 4
    //   353: istore_1
    //   354: aload 19
    //   356: ldc_w 352
    //   359: aload 13
    //   361: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload 11
    //   366: astore 10
    //   368: iload 4
    //   370: istore_1
    //   371: invokestatic 123	net/fred/feedex/utils/NetworkUtils:a	()Z
    //   374: ifeq +412 -> 786
    //   377: aload 11
    //   379: astore 10
    //   381: iload 4
    //   383: istore_1
    //   384: aload 13
    //   386: invokestatic 389	net/fred/feedex/utils/HtmlUtils:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   389: astore 12
    //   391: aload 12
    //   393: ifnull +193 -> 586
    //   396: aload 11
    //   398: astore 10
    //   400: iload 4
    //   402: istore_1
    //   403: aload 12
    //   405: invokestatic 392	net/fred/feedex/utils/HtmlUtils:a	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   408: astore 13
    //   410: aload 13
    //   412: ifnull +20 -> 432
    //   415: aload 11
    //   417: astore 10
    //   419: iload 4
    //   421: istore_1
    //   422: aload 19
    //   424: ldc_w 394
    //   427: aload 13
    //   429: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: aload 11
    //   434: astore 10
    //   436: iload 4
    //   438: istore_1
    //   439: aload 16
    //   441: aload 18
    //   443: invokestatic 400	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   446: aload 19
    //   448: invokevirtual 406	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   451: invokevirtual 410	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   454: invokevirtual 414	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   457: pop
    //   458: iconst_1
    //   459: istore 5
    //   461: iconst_1
    //   462: istore 4
    //   464: aload 11
    //   466: astore 10
    //   468: iload 5
    //   470: istore_1
    //   471: aload 16
    //   473: lload 6
    //   475: invokestatic 416	net/fred/feedex/provider/FeedData$TaskColumns:a	(J)Landroid/net/Uri;
    //   478: invokestatic 419	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   481: invokevirtual 410	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   484: invokevirtual 414	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   487: pop
    //   488: iload 4
    //   490: istore_2
    //   491: aload 12
    //   493: ifnull +41 -> 534
    //   496: iload 4
    //   498: istore_2
    //   499: aload 11
    //   501: astore 10
    //   503: iload 5
    //   505: istore_1
    //   506: aload 12
    //   508: invokevirtual 421	java/util/ArrayList:isEmpty	()Z
    //   511: ifne +23 -> 534
    //   514: aload 11
    //   516: astore 10
    //   518: iload 5
    //   520: istore_1
    //   521: lload 8
    //   523: invokestatic 424	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   526: aload 12
    //   528: invokestatic 427	net/fred/feedex/service/FetcherService:a	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   531: iload 4
    //   533: istore_2
    //   534: iload_2
    //   535: istore_1
    //   536: aload 11
    //   538: ifnull +10 -> 548
    //   541: aload 11
    //   543: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   546: iload_2
    //   547: istore_1
    //   548: aload 17
    //   550: invokeinterface 213 1 0
    //   555: iload_1
    //   556: ifne -505 -> 51
    //   559: iload_3
    //   560: iconst_1
    //   561: iadd
    //   562: iconst_3
    //   563: if_icmple +117 -> 680
    //   566: aload 16
    //   568: lload 6
    //   570: invokestatic 416	net/fred/feedex/provider/FeedData$TaskColumns:a	(J)Landroid/net/Uri;
    //   573: invokestatic 419	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   576: invokevirtual 410	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   579: invokevirtual 414	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   582: pop
    //   583: goto -532 -> 51
    //   586: aload 11
    //   588: astore 10
    //   590: iload 4
    //   592: istore_1
    //   593: aload 13
    //   595: invokestatic 429	net/fred/feedex/utils/HtmlUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   598: astore 13
    //   600: goto -190 -> 410
    //   603: astore 11
    //   605: aconst_null
    //   606: astore 10
    //   608: iconst_0
    //   609: istore_2
    //   610: ldc_w 431
    //   613: aload 11
    //   615: invokestatic 436	net/fred/feedex/utils/Dog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   618: iload_2
    //   619: istore_1
    //   620: aload 10
    //   622: ifnull -74 -> 548
    //   625: aload 10
    //   627: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   630: iload_2
    //   631: istore_1
    //   632: goto -84 -> 548
    //   635: astore 12
    //   637: aload 10
    //   639: astore 11
    //   641: aload 12
    //   643: astore 10
    //   645: aload 11
    //   647: ifnull +8 -> 655
    //   650: aload 11
    //   652: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   655: aload 10
    //   657: athrow
    //   658: iconst_1
    //   659: istore_1
    //   660: aload 16
    //   662: lload 6
    //   664: invokestatic 416	net/fred/feedex/provider/FeedData$TaskColumns:a	(J)Landroid/net/Uri;
    //   667: invokestatic 419	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   670: invokevirtual 410	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   673: invokevirtual 414	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   676: pop
    //   677: goto -129 -> 548
    //   680: new 179	android/content/ContentValues
    //   683: dup
    //   684: invokespecial 180	android/content/ContentValues:<init>	()V
    //   687: astore 10
    //   689: aload 10
    //   691: ldc_w 333
    //   694: iload_3
    //   695: iconst_1
    //   696: iadd
    //   697: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   700: invokevirtual 190	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   703: aload 16
    //   705: lload 6
    //   707: invokestatic 416	net/fred/feedex/provider/FeedData$TaskColumns:a	(J)Landroid/net/Uri;
    //   710: invokestatic 400	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   713: aload 10
    //   715: invokevirtual 406	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   718: invokevirtual 410	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   721: invokevirtual 414	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   724: pop
    //   725: goto -674 -> 51
    //   728: aload 15
    //   730: invokeinterface 213 1 0
    //   735: aload 16
    //   737: invokevirtual 421	java/util/ArrayList:isEmpty	()Z
    //   740: ifne +14 -> 754
    //   743: aload 14
    //   745: ldc_w 438
    //   748: aload 16
    //   750: invokevirtual 442	android/content/ContentResolver:applyBatch	(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
    //   753: pop
    //   754: return
    //   755: astore 10
    //   757: return
    //   758: astore 12
    //   760: aload 10
    //   762: astore 11
    //   764: aload 12
    //   766: astore 10
    //   768: goto -123 -> 645
    //   771: astore 12
    //   773: aload 11
    //   775: astore 10
    //   777: aload 12
    //   779: astore 11
    //   781: iload_1
    //   782: istore_2
    //   783: goto -173 -> 610
    //   786: aconst_null
    //   787: astore 12
    //   789: goto -398 -> 391
    //   792: iconst_0
    //   793: istore_1
    //   794: goto -246 -> 548
    //   797: iconst_0
    //   798: istore_3
    //   799: goto -698 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	802	0	this	FetcherService
    //   166	628	1	i	int
    //   105	678	2	j	int
    //   100	699	3	k	int
    //   102	489	4	m	int
    //   177	342	5	n	int
    //   69	637	6	l1	long
    //   79	443	8	l2	long
    //   184	530	10	localObject1	Object
    //   755	6	10	localThrowable1	Throwable
    //   766	10	10	localObject2	Object
    //   180	407	11	localHttpURLConnection	HttpURLConnection
    //   603	11	11	localThrowable2	Throwable
    //   639	141	11	localObject3	Object
    //   216	311	12	localObject4	Object
    //   635	7	12	localObject5	Object
    //   758	7	12	localObject6	Object
    //   771	7	12	localThrowable3	Throwable
    //   787	1	12	localObject7	Object
    //   197	402	13	str1	String
    //   4	740	14	localContentResolver	ContentResolver
    //   40	689	15	localCursor1	Cursor
    //   49	700	16	localArrayList	ArrayList
    //   124	425	17	localCursor2	Cursor
    //   111	331	18	localUri	Uri
    //   194	253	19	localObject8	Object
    //   212	55	20	str2	String
    // Exception table:
    //   from	to	target	type
    //   186	196	603	java/lang/Throwable
    //   203	214	603	java/lang/Throwable
    //   222	230	603	java/lang/Throwable
    //   234	244	603	java/lang/Throwable
    //   252	262	603	java/lang/Throwable
    //   266	277	603	java/lang/Throwable
    //   281	288	603	java/lang/Throwable
    //   186	196	635	finally
    //   203	214	635	finally
    //   222	230	635	finally
    //   234	244	635	finally
    //   252	262	635	finally
    //   266	277	635	finally
    //   281	288	635	finally
    //   295	307	635	finally
    //   319	331	635	finally
    //   338	347	635	finally
    //   354	364	635	finally
    //   371	377	635	finally
    //   384	391	635	finally
    //   403	410	635	finally
    //   422	432	635	finally
    //   439	458	635	finally
    //   471	488	635	finally
    //   506	514	635	finally
    //   521	531	635	finally
    //   593	600	635	finally
    //   743	754	755	java/lang/Throwable
    //   610	618	758	finally
    //   295	307	771	java/lang/Throwable
    //   319	331	771	java/lang/Throwable
    //   338	347	771	java/lang/Throwable
    //   354	364	771	java/lang/Throwable
    //   371	377	771	java/lang/Throwable
    //   384	391	771	java/lang/Throwable
    //   403	410	771	java/lang/Throwable
    //   422	432	771	java/lang/Throwable
    //   439	458	771	java/lang/Throwable
    //   471	488	771	java/lang/Throwable
    //   506	514	771	java/lang/Throwable
    //   521	531	771	java/lang/Throwable
    //   593	600	771	java/lang/Throwable
  }
  
  public static void a(String paramString, ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      ContentValues[] arrayOfContentValues = new ContentValues[paramArrayList.size()];
      int i = 0;
      while (i < paramArrayList.size())
      {
        arrayOfContentValues[i] = new ContentValues();
        arrayOfContentValues[i].put("entryid", paramString);
        arrayOfContentValues[i].put("imgurl_to_dl", (String)paramArrayList.get(i));
        i += 1;
      }
      MainApplication.a().getContentResolver().bulkInsert(FeedData.TaskColumns.c, arrayOfContentValues);
    }
  }
  
  public static void a(long[] paramArrayOfLong)
  {
    ContentValues[] arrayOfContentValues = new ContentValues[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfContentValues[i] = new ContentValues();
      arrayOfContentValues[i].put("entryid", Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    MainApplication.a().getContentResolver().bulkInsert(FeedData.TaskColumns.c, arrayOfContentValues);
  }
  
  public static boolean a(long paramLong)
  {
    Cursor localCursor = MainApplication.a().getContentResolver().query(FeedData.TaskColumns.c, FeedData.TaskColumns.a, "entryid=" + paramLong + " AND " + "imgurl_to_dl" + " IS NULL", null, null);
    if (localCursor.getCount() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localCursor.close();
      return bool;
    }
  }
  
  private void b()
  {
    ContentResolver localContentResolver = MainApplication.a().getContentResolver();
    Cursor localCursor = localContentResolver.query(FeedData.TaskColumns.c, new String[] { "_id", "entryid", "imgurl_to_dl", "number_attempt" }, "imgurl_to_dl IS NOT NULL", null, null);
    ArrayList localArrayList = new ArrayList();
    long l1;
    long l2;
    String str;
    if (localCursor.moveToNext())
    {
      l1 = localCursor.getLong(0);
      l2 = localCursor.getLong(1);
      str = localCursor.getString(2);
      if (localCursor.isNull(3)) {
        break label249;
      }
    }
    label249:
    for (int i = localCursor.getInt(3);; i = 0)
    {
      try
      {
        NetworkUtils.c(l2, str);
        localArrayList.add(ContentProviderOperation.newDelete(FeedData.TaskColumns.a(l1)).build());
      }
      catch (Exception localException)
      {
        if (i + 1 > 3)
        {
          localArrayList.add(ContentProviderOperation.newDelete(FeedData.TaskColumns.a(l1)).build());
          break;
        }
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("number_attempt", Integer.valueOf(i + 1));
        localArrayList.add(ContentProviderOperation.newUpdate(FeedData.TaskColumns.a(l1)).withValues(localContentValues).build());
      }
      break;
      localCursor.close();
      if (!localArrayList.isEmpty()) {}
      try
      {
        localContentResolver.applyBatch("net.fred.feedex.provider.FeedData", localArrayList);
        return;
      }
      catch (Throwable localThrowable)
      {
        return;
      }
    }
  }
  
  private void b(long paramLong)
  {
    if (paramLong > 0L)
    {
      String str = "date<" + paramLong + " AND " + "(favorite IS NULL OR favorite=0)";
      MainApplication.a().getContentResolver().delete(FeedData.EntryColumns.c, str, null);
    }
  }
  
  private int c(long paramLong)
  {
    Cursor localCursor = getContentResolver().query(FeedData.FeedColumns.e, FeedData.FeedColumns.a, null, null, null);
    int k = localCursor.getCount();
    ExecutorService localExecutorService = Executors.newFixedThreadPool(3, new FetcherService.2(this));
    ExecutorCompletionService localExecutorCompletionService = new ExecutorCompletionService(localExecutorService);
    while (localCursor.moveToNext()) {
      localExecutorCompletionService.submit(new FetcherService.3(this, localCursor.getString(0), paramLong));
    }
    localCursor.close();
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j >= k) {
        break label148;
      }
      try
      {
        int m = ((Integer)localExecutorCompletionService.take().get()).intValue();
        i = m + i;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      j += 1;
    }
    label148:
    localExecutorService.shutdownNow();
    return i;
  }
  
  public void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    boolean bool;
    Object localObject;
    int i;
    for (;;)
    {
      return;
      bool = paramIntent.getBooleanExtra("from_auto_refresh", false);
      localObject = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject == null) || (((NetworkInfo)localObject).getState() != NetworkInfo.State.CONNECTED))
      {
        if (("net.fred.feedex.REFRESH".equals(paramIntent.getAction())) && (!bool)) {
          this.b.post(new FetcherService.1(this));
        }
      }
      else
      {
        if ((bool) && (PrefUtils.a("refreshwifionly.enabled", false)) && (((NetworkInfo)localObject).getType() != 1)) {}
        for (i = 1; i == 0; i = 0)
        {
          if (!"net.fred.feedex.MOBILIZE_FEEDS".equals(paramIntent.getAction())) {
            break label135;
          }
          a();
          b();
          return;
        }
      }
    }
    label135:
    if ("net.fred.feedex.DOWNLOAD_IMAGES".equals(paramIntent.getAction()))
    {
      b();
      return;
    }
    PrefUtils.b("IS_REFRESHING", true);
    if (bool) {
      PrefUtils.b("lastscheduledrefresh", SystemClock.elapsedRealtime());
    }
    long l = Long.parseLong(PrefUtils.a("keeptime", "4")) * 86400000L;
    if (l > 0L)
    {
      l = System.currentTimeMillis() - l;
      b(l);
      paramIntent = paramIntent.getStringExtra("feedid");
      if (paramIntent != null) {
        break label530;
      }
      i = c(l);
      label231:
      if (i > 0)
      {
        if (!PrefUtils.a("notifications.enabled", true)) {
          break label541;
        }
        paramIntent = getContentResolver().query(FeedData.EntryColumns.c, new String[] { "COUNT(*)" }, "(isread IS NULL OR isread=0)", null, null);
        paramIntent.moveToFirst();
        i = paramIntent.getInt(0);
        paramIntent.close();
        if (i > 0)
        {
          paramIntent = getResources().getQuantityString(2131296256, i, new Object[] { Integer.valueOf(i) });
          localObject = PendingIntent.getActivity(this, 0, new Intent(this, HomeActivity.class), 134217728);
          paramIntent = new Notification.Builder(MainApplication.a()).setContentIntent((PendingIntent)localObject).setSmallIcon(2130837598).setLargeIcon(BitmapFactory.decodeResource(getResources(), 2130903040)).setTicker(paramIntent).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle(getString(2131165243)).setContentText(paramIntent).setLights(-1, 0, 0);
          if (PrefUtils.a("notifications.vibrate", false)) {
            paramIntent.setVibrate(new long[] { 0L, 1000L });
          }
          localObject = PrefUtils.a("notifications.ringtone", null);
          if ((localObject != null) && (((String)localObject).length() > 0)) {
            paramIntent.setSound(Uri.parse((String)localObject));
          }
          if (PrefUtils.a("notifications.light", false)) {
            paramIntent.setLights(-1, 300, 1000);
          }
          if (Constants.a != null) {
            Constants.a.notify(0, paramIntent.getNotification());
          }
        }
      }
    }
    for (;;)
    {
      a();
      b();
      PrefUtils.b("IS_REFRESHING", false);
      return;
      l = 0L;
      break;
      label530:
      i = a(paramIntent, l);
      break label231;
      label541:
      if (Constants.a != null) {
        Constants.a.cancel(0);
      }
    }
  }
}
