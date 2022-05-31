package net.fred.feedex.parser;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import net.fred.feedex.MainApplication;
import net.fred.feedex.provider.FeedData.EntryColumns;
import net.fred.feedex.provider.FeedData.FeedColumns;
import net.fred.feedex.service.FetcherService;
import net.fred.feedex.utils.Dog;
import net.fred.feedex.utils.HtmlUtils;
import net.fred.feedex.utils.NetworkUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class RssAtomParser
  extends DefaultHandler
{
  private static final String[][] a = { { "MEST", "+0200" }, { "EST", "-0500" }, { "PST", "-0800" }, { "ICT", "+0700" } };
  private String A;
  private Date B;
  private Date C;
  private Date D;
  private Date E;
  private StringBuilder F;
  private StringBuilder G;
  private StringBuilder H;
  private int I = 0;
  private String J;
  private boolean K = false;
  private boolean L = false;
  private boolean M = false;
  private boolean N = false;
  private long O = System.currentTimeMillis();
  private StringBuilder P;
  private StringBuilder Q;
  private StringBuilder R;
  private final DateFormat[] b = { new SimpleDateFormat("d' 'MMM' 'yy' 'HH:mm:ss' 'Z", Locale.US), new SimpleDateFormat("d' 'MMM' 'yy' 'HH:mm:ss' 'z", Locale.US), new SimpleDateFormat("d' 'MMM' 'yy' 'HH:mm:ss", Locale.US) };
  private final DateFormat[] c = { new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ssZ", Locale.US), new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss.SSSz", Locale.US), new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss", Locale.US), new SimpleDateFormat("yyyy-MM-dd", Locale.US) };
  private final Date d;
  private final String e;
  private final Uri f;
  private final String g;
  private final String h;
  private final Date i;
  private final RssAtomParser.FeedFilters j;
  private final ArrayList k = new ArrayList();
  private final ArrayList l = new ArrayList();
  private long m;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private StringBuilder y;
  private StringBuilder z;
  
  public RssAtomParser(Date paramDate, long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.i = new Date(paramLong);
    this.d = paramDate;
    this.m = paramDate.getTime();
    this.e = paramString1;
    this.g = paramString2;
    this.f = FeedData.EntryColumns.a(paramString1);
    this.M = paramBoolean;
    this.j = new RssAtomParser.FeedFilters(this, paramString1);
    this.h = NetworkUtils.a(paramString3);
  }
  
  private Date a(String paramString, boolean paramBoolean)
  {
    DateFormat[] arrayOfDateFormat = this.c;
    int i2 = arrayOfDateFormat.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = arrayOfDateFormat[i1];
      try
      {
        Date localDate = ((DateFormat)localObject).parse(paramString);
        localObject = localDate;
        if (localDate.getTime() > this.O) {
          localObject = new Date(this.O);
        }
        return localObject;
      }
      catch (ParseException localParseException)
      {
        i1 += 1;
      }
    }
    if (paramBoolean) {
      return b(paramString, false);
    }
    return null;
  }
  
  private void a(Attributes paramAttributes, String paramString)
  {
    if ((this.H == null) && (paramString != null))
    {
      this.H = new StringBuilder(paramString);
      this.H.append("[@]");
      paramString = paramAttributes.getValue("", "type");
      if (paramString != null) {
        this.H.append(paramString);
      }
      this.H.append("[@]");
      paramAttributes = paramAttributes.getValue("", "length");
      if (paramAttributes != null) {
        this.H.append(paramAttributes);
      }
    }
  }
  
  private Date b(String paramString, boolean paramBoolean)
  {
    DateFormat[] arrayOfDateFormat = this.b;
    int i2 = arrayOfDateFormat.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = arrayOfDateFormat[i1];
      try
      {
        Date localDate = ((DateFormat)localObject).parse(paramString);
        localObject = localDate;
        if (localDate.getTime() > this.O) {
          localObject = new Date(this.O);
        }
        return localObject;
      }
      catch (ParseException localParseException)
      {
        i1 += 1;
      }
    }
    if (paramBoolean) {
      return a(paramString, false);
    }
    return null;
  }
  
  private static String c(String paramString)
  {
    String str = paramString.replace("&amp;", "&").replaceAll("<(.|\n)*?>", "").replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "\"").replace("&#39;", "'");
    paramString = str;
    if (str.contains("&#")) {
      paramString = Html.fromHtml(str, null, null).toString();
    }
    return paramString;
  }
  
  private String d(String paramString)
  {
    int i1 = paramString.indexOf(", ");
    Object localObject1 = paramString;
    if (i1 != -1) {
      localObject1 = paramString.substring(i1 + 2);
    }
    paramString = ((String)localObject1).replaceAll("([0-9])T([0-9])", "$1 $2").replaceAll("Z$", "").replaceAll("  ", " ").trim();
    localObject1 = a;
    int i2 = localObject1.length;
    i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = localObject1[i1];
      paramString = paramString.replace(localObject2[0], localObject2[1]);
      i1 += 1;
    }
    return paramString;
  }
  
  private void e()
  {
    if (!this.N)
    {
      this.N = true;
      this.K = true;
      endDocument();
      throw new SAXException("Finished");
    }
  }
  
  public String a()
  {
    return this.A;
  }
  
  public Date a(String paramString)
  {
    return a(d(paramString), true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public int b()
  {
    return this.I;
  }
  
  public Date b(String paramString)
  {
    return b(d(paramString), true);
  }
  
  public boolean c()
  {
    return this.K;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.o) {
      this.y.append(paramArrayOfChar, paramInt1, paramInt2);
    }
    do
    {
      return;
      if (this.q)
      {
        this.F.append(paramArrayOfChar, paramInt1, paramInt2);
        return;
      }
      if (this.r)
      {
        this.G.append(paramArrayOfChar, paramInt1, paramInt2);
        return;
      }
      if ((this.p) || (this.s) || (this.t) || (this.u) || (this.v))
      {
        this.z.append(paramArrayOfChar, paramInt1, paramInt2);
        return;
      }
      if (this.w)
      {
        this.P.append(paramArrayOfChar, paramInt1, paramInt2);
        return;
      }
    } while (!this.x);
    this.R.append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public boolean d()
  {
    return this.N;
  }
  
  public void endDocument()
  {
    ContentResolver localContentResolver = MainApplication.a().getContentResolver();
    try
    {
      if (this.k.isEmpty()) {
        break label131;
      }
      localObject1 = localContentResolver.applyBatch("net.fred.feedex.provider.FeedData", this.k);
      if (!this.L) {
        break label79;
      }
      i1 = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        int i1;
        Object localObject2;
        label79:
        label131:
        Dog.a("Error", localException);
        continue;
        i1 += 1;
      }
    }
    if (i1 < localObject1.length)
    {
      localObject2 = (ArrayList)this.l.get(i1);
      if (localObject2 != null) {
        FetcherService.a(localObject1[i1].uri.getLastPathSegment(), (ArrayList)localObject2);
      }
    }
    else
    {
      if (this.M)
      {
        localObject2 = new long[localObject1.length];
        i1 = 0;
        while (i1 < localObject1.length)
        {
          localObject2[i1] = Long.valueOf(localObject1[i1].uri.getLastPathSegment()).longValue();
          i1 += 1;
        }
        FetcherService.a((long[])localObject2);
      }
      localObject1 = new ContentValues();
      if ((this.g == null) && (this.J != null)) {
        ((ContentValues)localObject1).put("name", this.J.trim());
      }
      ((ContentValues)localObject1).putNull("error");
      ((ContentValues)localObject1).put("lastupdate", Long.valueOf(System.currentTimeMillis() - 3000L));
      ((ContentValues)localObject1).put("reallastupdate", Long.valueOf(this.m));
      localContentResolver.update(FeedData.FeedColumns.a(this.e), (ContentValues)localObject1, null, null);
      super.endDocument();
      return;
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if ("title".equals(paramString2)) {
      this.o = false;
    }
    do
    {
      return;
      if ((("description".equals(paramString2)) && (!"media:description".equals(paramString3))) || ("summary".equals(paramString2)) || (("content".equals(paramString2)) && (!"media:content".equals(paramString3))) || ("encoded".equals(paramString2)))
      {
        this.r = false;
        return;
      }
      if (!"link".equals(paramString2)) {
        break;
      }
      this.q = false;
    } while ((this.A != null) || (this.n) || (!"link".equals(paramString3)));
    this.A = this.F.toString();
    return;
    if ("updated".equals(paramString2))
    {
      this.C = a(this.z.toString());
      this.p = false;
      return;
    }
    if ("pubDate".equals(paramString2))
    {
      this.B = b(this.z.toString());
      this.s = false;
      return;
    }
    if ("published".equals(paramString2))
    {
      this.B = b(this.z.toString());
      this.t = false;
      return;
    }
    if ("lastBuildDate".equals(paramString2))
    {
      this.B = b(this.z.toString());
      this.v = false;
      return;
    }
    if ("date".equals(paramString2))
    {
      this.B = a(this.z.toString());
      this.u = false;
      return;
    }
    int i2;
    int i1;
    ContentValues localContentValues;
    String str;
    Object localObject;
    if (("entry".equals(paramString2)) || ("item".equals(paramString2)))
    {
      this.n = false;
      i2 = 0;
      if ((this.C != null) && (this.B != null) && ((this.B.before(this.d)) || (this.B.before(this.i))))
      {
        i2 = 1;
        i1 = i2;
        if (this.C.after(this.B))
        {
          this.B = this.C;
          i1 = i2;
        }
        if ((this.y == null) || ((this.B != null) && ((!this.B.after(this.d)) || (!this.B.after(this.i))))) {
          break label1274;
        }
        localContentValues = new ContentValues();
        if ((this.B != null) && (this.B.getTime() > this.m)) {
          this.m = this.B.getTime();
        }
        str = c(this.y.toString().trim());
        localContentValues.put("title", str);
        paramString1 = null;
        paramString2 = null;
        if (this.G == null) {
          break label1518;
        }
        paramString3 = HtmlUtils.a(this.G.toString(), this.h);
        if (!this.L) {
          break label1152;
        }
        localObject = HtmlUtils.a(paramString3);
        paramString2 = (String)localObject;
        if (!((ArrayList)localObject).isEmpty())
        {
          paramString1 = HtmlUtils.a((ArrayList)localObject);
          paramString2 = (String)localObject;
        }
        label559:
        if (paramString3 != null) {
          localContentValues.put("abstract", paramString3);
        }
      }
    }
    for (;;)
    {
      if (paramString1 != null) {
        localContentValues.put("image_url", paramString1);
      }
      StringBuilder localStringBuilder;
      if (!this.j.a(str, paramString3))
      {
        if (this.Q != null) {
          localContentValues.put("author", this.Q.toString());
        }
        paramString1 = null;
        localStringBuilder = new StringBuilder("link").append("=?");
        localObject = paramString1;
        if (this.H != null)
        {
          localObject = paramString1;
          if (this.H.length() > 0)
          {
            localObject = this.H.toString();
            localContentValues.put("enclosure", (String)localObject);
            localStringBuilder.append(" AND ").append("enclosure").append("=?");
          }
        }
        paramString1 = null;
        paramString3 = paramString1;
        if (this.P != null)
        {
          paramString3 = paramString1;
          if (this.P.length() > 0)
          {
            paramString3 = this.P.toString();
            localContentValues.put("guid", paramString3);
            localStringBuilder.append(" AND ").append("guid").append("=?");
          }
        }
        str = "";
        paramString1 = str;
        if (this.F == null) {
          break label1512;
        }
        paramString1 = str;
        if (this.F.length() <= 0) {
          break label1512;
        }
        str = this.F.toString().trim();
        paramString1 = str;
        if (this.h == null) {
          break label1512;
        }
        paramString1 = str;
        if (str.startsWith("http://")) {
          break label1512;
        }
        paramString1 = str;
        if (str.startsWith("https://")) {
          break label1512;
        }
        paramString1 = new StringBuilder().append(this.h);
        if (!str.startsWith("/")) {
          break label1160;
        }
      }
      label867:
      label906:
      label949:
      label984:
      label1152:
      label1160:
      label1238:
      label1244:
      label1274:
      label1512:
      for (str = str;; str = paramString1)
      {
        if (localObject != null) {
          if (paramString3 != null)
          {
            paramString1 = new String[] { str, localObject, paramString3 };
            localObject = MainApplication.a().getContentResolver();
            if (((str.isEmpty()) && (paramString3 == null)) || (((ContentResolver)localObject).update(this.f, localContentValues, localStringBuilder.toString(), paramString1) == 0)) {
              break label1238;
            }
            i2 = 1;
            if ((i2 == 0) && (i1 == 0))
            {
              if (this.B == null) {
                break label1244;
              }
              localContentValues.put("date", Long.valueOf(this.B.getTime()));
              localContentValues.put("link", str);
              this.l.add(paramString2);
              this.k.add(ContentProviderOperation.newInsert(this.f).withValues(localContentValues).build());
              this.I += 1;
            }
            if ((i2 != 0) && (this.B == null)) {
              e();
            }
          }
        }
        for (;;)
        {
          this.G = null;
          this.y = null;
          this.H = null;
          this.P = null;
          this.Q = null;
          return;
          if ((this.B == null) && (this.C != null))
          {
            this.B = this.C;
            i1 = i2;
            break;
          }
          i1 = i2;
          if (this.B != null) {
            break;
          }
          i1 = i2;
          if (this.C != null) {
            break;
          }
          this.B = this.D;
          this.C = this.E;
          i1 = i2;
          break;
          paramString1 = HtmlUtils.b(paramString3);
          break label559;
          str = "/" + str;
          break label867;
          paramString1 = new String[] { str, localObject };
          break label906;
          if (paramString3 != null)
          {
            paramString1 = new String[2];
            paramString1[0] = str;
            paramString1[1] = paramString3;
            break label906;
          }
          paramString1 = new String[1];
          paramString1[0] = str;
          break label906;
          i2 = 0;
          break label949;
          long l1 = this.O;
          this.O = (l1 - 1L);
          localContentValues.put("date", Long.valueOf(l1));
          break label984;
          e();
        }
        if (("rss".equals(paramString2)) || ("rdf".equals(paramString2)) || ("feed".equals(paramString2)))
        {
          this.K = true;
          return;
        }
        if ("guid".equals(paramString2))
        {
          this.w = false;
          return;
        }
        if ((!"name".equals(paramString2)) && (!"author".equals(paramString2)) && (!"creator".equals(paramString2))) {
          break;
        }
        this.x = false;
        if ((this.R != null) && (this.R.indexOf("@") == -1))
        {
          if (this.Q == null) {
            this.Q = new StringBuilder(this.R);
          }
        }
        else
        {
          this.R = null;
          return;
        }
        int i3 = 0;
        paramString1 = this.Q.toString().split(",");
        int i4 = paramString1.length;
        i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 < i4)
          {
            if (paramString1[i1].equals(this.R.toString())) {
              i2 = 1;
            }
          }
          else
          {
            if (i2 != 0) {
              break;
            }
            this.Q.append(", ");
            this.Q.append(this.R);
            break;
          }
          i1 += 1;
        }
      }
      label1518:
      paramString2 = null;
      paramString1 = null;
      paramString3 = null;
    }
  }
  
  public void error(SAXParseException paramSAXParseException) {}
  
  public void fatalError(SAXParseException paramSAXParseException) {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    int i1 = 0;
    if ("updated".equals(paramString2))
    {
      this.p = true;
      this.z = new StringBuilder();
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (("entry".equals(paramString2)) || ("item".equals(paramString2)))
            {
              this.n = true;
              this.G = null;
              this.F = null;
              this.D = this.B;
              this.E = this.C;
              this.B = null;
              this.C = null;
              if ((this.J == null) && (this.y != null) && (this.y.length() > 0)) {
                this.J = this.y.toString();
              }
              this.y = null;
              return;
            }
            if ("title".equals(paramString2))
            {
              if (this.y == null)
              {
                this.o = true;
                this.y = new StringBuilder();
              }
            }
            else
            {
              if (!"link".equals(paramString2)) {
                break;
              }
              if (!this.x)
              {
                if ("enclosure".equals(paramAttributes.getValue("", "rel")))
                {
                  a(paramAttributes, paramAttributes.getValue("", "href"));
                  return;
                }
                if ((this.F == null) || ("text/html".equals(paramAttributes.getValue("", "type"))))
                {
                  this.F = new StringBuilder();
                  paramString1 = paramAttributes.getValue("", "href");
                  if (!TextUtils.isEmpty(paramString1))
                  {
                    this.F.append(paramString1);
                    this.q = false;
                    i1 = 1;
                  }
                  while (i1 == 0)
                  {
                    this.q = true;
                    return;
                    this.q = true;
                  }
                }
              }
            }
          }
          if ((("description".equals(paramString2)) && (!"media:description".equals(paramString3))) || (("content".equals(paramString2)) && (!"media:content".equals(paramString3))))
          {
            this.r = true;
            this.G = new StringBuilder();
            return;
          }
          if (!"summary".equals(paramString2)) {
            break;
          }
        } while (this.G != null);
        this.r = true;
        this.G = new StringBuilder();
        return;
        if ("pubDate".equals(paramString2))
        {
          this.s = true;
          this.z = new StringBuilder();
          return;
        }
        if ("published".equals(paramString2))
        {
          this.t = true;
          this.z = new StringBuilder();
          return;
        }
        if ("date".equals(paramString2))
        {
          this.u = true;
          this.z = new StringBuilder();
          return;
        }
        if ("lastBuildDate".equals(paramString2))
        {
          this.v = true;
          this.z = new StringBuilder();
          return;
        }
        if ("encoded".equals(paramString2))
        {
          this.r = true;
          this.G = new StringBuilder();
          return;
        }
        if ("enclosure".equals(paramString2))
        {
          a(paramAttributes, paramAttributes.getValue("", "url"));
          return;
        }
        if ("guid".equals(paramString2))
        {
          this.w = true;
          this.P = new StringBuilder();
          return;
        }
      } while ((!"name".equals(paramString2)) && (!"author".equals(paramString2)) && (!"creator".equals(paramString2)));
      this.x = true;
    } while (this.R != null);
    this.R = new StringBuilder();
  }
  
  public void warning(SAXParseException paramSAXParseException) {}
}
