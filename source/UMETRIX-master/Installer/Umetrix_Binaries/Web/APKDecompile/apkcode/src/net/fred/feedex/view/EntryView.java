package net.fred.feedex.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Date;
import net.fred.feedex.utils.HtmlUtils;
import net.fred.feedex.utils.PrefUtils;

public class EntryView
  extends WebView
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g;
  private static final String h;
  private final EntryView.JavaScriptObject i = new EntryView.JavaScriptObject(this, null);
  private EntryView.EntryViewManager j;
  
  static
  {
    if (PrefUtils.a("lighttheme", false))
    {
      str = "#f6f6f6";
      a = str;
      if (!PrefUtils.a("lighttheme", false)) {
        break label315;
      }
      str = "#e6e6e6";
      label28:
      b = str;
      if (!PrefUtils.a("lighttheme", false)) {
        break label321;
      }
      str = "#a6a6a6";
      label44:
      c = str;
      if (!PrefUtils.a("lighttheme", false)) {
        break label327;
      }
      str = "#000000";
      label60:
      d = str;
      if (!PrefUtils.a("lighttheme", false)) {
        break label333;
      }
      str = "#52A7DF";
      label76:
      e = str;
      if (!PrefUtils.a("lighttheme", false)) {
        break label339;
      }
      str = "#666666";
      label92:
      f = str;
      if (!PrefUtils.a("lighttheme", false)) {
        break label345;
      }
    }
    label315:
    label321:
    label327:
    label333:
    label339:
    label345:
    for (String str = "solid #ddd";; str = "solid #303030")
    {
      g = str;
      h = "<head><style type='text/css'> body {max-width: 100%; margin: 0.3cm; font-family: sans-serif-light; color: " + d + "; background-color:" + a + "; line-height: 150%} " + "* {max-width: 100%; word-break: break-word}" + "h1, h2 {font-weight: normal; line-height: 130%} " + "h1 {font-size: 170%; margin-bottom: 0.1em} " + "h2 {font-size: 140%} " + "a {color: #0099CC}" + "h1 a {color: inherit; text-decoration: none}" + "img {height: auto} " + "pre {white-space: pre-wrap;} " + "blockquote {border-left: thick solid " + c + "; background-color:" + b + "; margin: 0.5em 0 0.5em 0em; padding: 0.5em} " + "p {margin: 0.8em 0 0.8em 0} " + "p.subtitle {color: " + f + "; border-top:1px " + g + "; border-bottom:1px " + g + "; padding-top:2px; padding-bottom:2px; font-weight:800 } " + "ul, ol {margin: 0 0 0.8em 0.6em; padding: 0 0 0 1em} " + "ul li, ol li {margin: 0 0 0.8em 0; padding: 0} " + "div.button-section {padding: 0.4cm 0; margin: 0; text-align: center} " + ".button-section p {margin: 0.1cm 0 0.2cm 0}" + ".button-section p.marginfix {margin: 0.5cm 0 0.5cm 0}" + ".button-section input, .button-section a {font-family: sans-serif-light; font-size: 100%; color: #FFFFFF; background-color: " + e + "; text-decoration: none; border: none; border-radius:0.2cm; padding: 0.3cm} " + "</style><meta name='viewport' content='width=device-width'/></head>";
      return;
      str = "#181b1f";
      break;
      str = "#383b3f";
      break label28;
      str = "#686b6f";
      break label44;
      str = "#C0C0C0";
      break label60;
      str = "#1A5A81";
      break label76;
      str = "#8c8c8c";
      break label92;
    }
  }
  
  public EntryView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(h).append("<body>");
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    localStringBuilder.append("<h1><a href='").append(str).append("'>").append(paramString1).append("</a></h1>").append("<p class='subtitle'>");
    paramString2 = new Date(paramLong);
    paramString1 = getContext();
    paramString2 = new StringBuilder(android.text.format.DateFormat.getLongDateFormat(paramString1).format(paramString2)).append(' ').append(android.text.format.DateFormat.getTimeFormat(paramString1).format(paramString2));
    if ((paramString5 != null) && (!paramString5.isEmpty())) {
      paramString2.append(" &mdash; ").append(paramString5);
    }
    localStringBuilder.append(paramString2).append("</p>").append(paramString3).append("<div class='button-section'>").append("<p><input type='button' value='");
    if (!paramBoolean) {
      localStringBuilder.append(paramString1.getString(2131165244)).append("' onclick='").append("injectedJSObject.onClickFullText();");
    }
    for (;;)
    {
      localStringBuilder.append("'/></p>");
      if ((paramString4 != null) && (paramString4.length() > 6) && (!paramString4.contains("[@]image/"))) {
        localStringBuilder.append("<p><input type='button' value='").append(paramString1.getString(2131165287)).append("' onclick='").append("injectedJSObject.onClickEnclosure();").append("'/></p>");
      }
      if (str.length() > 0) {
        localStringBuilder.append("<p class='marginfix'><a href='").append(str).append("'>").append(paramString1.getString(2131165288)).append("</a></p>");
      }
      localStringBuilder.append("</div>").append("</body>");
      return localStringBuilder.toString();
      localStringBuilder.append(paramString1.getString(2131165281)).append("' onclick='").append("injectedJSObject.onClickOriginalText();");
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
  private void a()
  {
    setHorizontalScrollBarEnabled(false);
    getSettings().setUseWideViewPort(false);
    setBackgroundColor(Color.parseColor(a));
    int k = Integer.parseInt(PrefUtils.a("fontsize", "0"));
    if (k != 0) {
      getSettings().setTextZoom(k * 20 + 100);
    }
    getSettings().setJavaScriptEnabled(true);
    addJavascriptInterface(this.i, this.i.toString());
    setWebChromeClient(new EntryView.1(this));
    setWebViewClient(new EntryView.2(this));
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, boolean paramBoolean)
  {
    if (PrefUtils.a("display_images", true))
    {
      String str = HtmlUtils.a(paramString3, paramLong1);
      paramString3 = str;
      if (getSettings().getBlockNetworkImage())
      {
        loadData("", "text/html", "UTF-8");
        getSettings().setBlockNetworkImage(false);
        paramString3 = str;
      }
    }
    for (;;)
    {
      loadDataWithBaseURL("", a(paramString1, paramString2, paramString3, paramString4, paramString5, paramLong2, paramBoolean), "text/html", "UTF-8", null);
      return;
      paramString3 = paramString3.replaceAll("(?i)<[/]?[ ]?img(.|\n)*?>", "");
      getSettings().setBlockNetworkImage(true);
    }
  }
  
  public void setListener(EntryView.EntryViewManager paramEntryViewManager)
  {
    this.j = paramEntryViewManager;
  }
}
