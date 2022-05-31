package net.fred.feedex.activity;

import android.app.AlertDialog.Builder;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;
import net.fred.feedex.Constants;
import net.fred.feedex.adapter.FiltersCursorAdapter;
import net.fred.feedex.provider.FeedData.FilterColumns;
import net.fred.feedex.provider.FeedDataContentProvider;
import net.fred.feedex.utils.UiUtils;

public class EditFeedActivity
  extends BaseActivity
  implements LoaderManager.LoaderCallbacks
{
  private static final String[] m = { "name", "url", "retrievefulltext" };
  private final ActionMode.Callback n = new EditFeedActivity.1(this);
  private TabHost o;
  private EditText p;
  private EditText q;
  private CheckBox r;
  private ListView s;
  private FiltersCursorAdapter t;
  
  public EditFeedActivity() {}
  
  public void a(Loader paramLoader, Cursor paramCursor)
  {
    this.t.swapCursor(paramCursor);
  }
  
  public void onClickCancel(View paramView)
  {
    finish();
  }
  
  public void onClickOk(View paramView)
  {
    paramView = this.p.getText().toString().trim();
    String str = this.q.getText().toString().trim();
    if (str.isEmpty()) {
      Toast.makeText(this, 2131165225, 0).show();
    }
    if ((!str.contains(".")) || (!str.contains("/")) || (str.contains(" ")))
    {
      ProgressDialog localProgressDialog = new ProgressDialog(this);
      localProgressDialog.setMessage(getString(2131165256));
      localProgressDialog.setCancelable(true);
      localProgressDialog.setIndeterminate(true);
      localProgressDialog.show();
      getLoaderManager().restartLoader(1, null, new EditFeedActivity.6(this, str, localProgressDialog, paramView));
      return;
    }
    FeedDataContentProvider.a(this, str, paramView, this.r.isChecked());
    setResult(-1);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    UiUtils.a(this);
    super.onCreate(paramBundle);
    setContentView(2130968605);
    a((Toolbar)findViewById(2131689558));
    g().a(true);
    setResult(0);
    Object localObject = getIntent();
    this.o = ((TabHost)findViewById(2131689567));
    this.p = ((EditText)findViewById(2131689572));
    this.q = ((EditText)findViewById(2131689570));
    this.r = ((CheckBox)findViewById(2131689573));
    this.s = ((ListView)findViewById(16908298));
    View localView1 = findViewById(16908307);
    View localView2 = findViewById(2131689557);
    this.o.setup();
    this.o.addTab(this.o.newTabSpec("feedTab").setIndicator(getString(2131165324)).setContent(2131689568));
    this.o.addTab(this.o.newTabSpec("filtersTab").setIndicator(getString(2131165325)).setContent(2131689574));
    this.o.setOnTabChangedListener(new EditFeedActivity.2(this));
    if (paramBundle != null) {
      this.o.setCurrentTab(paramBundle.getInt("STATE_CURRENT_TAB"));
    }
    if ((((Intent)localObject).getAction().equals("android.intent.action.INSERT")) || (((Intent)localObject).getAction().equals("android.intent.action.SEND")))
    {
      setTitle(2131165273);
      localView1.setVisibility(8);
      if (((Intent)localObject).hasExtra("android.intent.extra.TEXT")) {
        this.q.setText(((Intent)localObject).getStringExtra("android.intent.extra.TEXT"));
      }
    }
    do
    {
      do
      {
        return;
        if (((Intent)localObject).getAction().equals("android.intent.action.VIEW"))
        {
          setTitle(2131165273);
          localView1.setVisibility(8);
          this.q.setText(((Intent)localObject).getDataString());
          return;
        }
      } while (!((Intent)localObject).getAction().equals("android.intent.action.EDIT"));
      setTitle(2131165221);
      localView2.setVisibility(8);
      this.t = new FiltersCursorAdapter(this, Constants.b);
      this.s.setAdapter(this.t);
      this.s.setOnItemLongClickListener(new EditFeedActivity.3(this));
      getLoaderManager().initLoader(0, null, this);
    } while (paramBundle != null);
    paramBundle = getContentResolver().query(((Intent)localObject).getData(), m, null, null, null);
    if (paramBundle.moveToNext())
    {
      this.p.setText(paramBundle.getString(0));
      this.q.setText(paramBundle.getString(1));
      localObject = this.r;
      if (paramBundle.getInt(2) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((CheckBox)localObject).setChecked(bool);
        paramBundle.close();
        return;
      }
    }
    paramBundle.close();
    Toast.makeText(this, 2131165223, 0).show();
    finish();
  }
  
  public Loader onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = new CursorLoader(this, FeedData.FilterColumns.a(getIntent().getData().getLastPathSegment()), null, null, null, "isacceptrule DESC");
    paramBundle.setUpdateThrottle(200L);
    return paramBundle;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755009, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  /* Error */
  protected void onDestroy()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: invokevirtual 200	net/fred/feedex/activity/EditFeedActivity:getIntent	()Landroid/content/Intent;
    //   8: invokevirtual 265	android/content/Intent:getAction	()Ljava/lang/String;
    //   11: ldc_w 302
    //   14: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +107 -> 124
    //   20: aload_0
    //   21: getfield 90	net/fred/feedex/activity/EditFeedActivity:q	Landroid/widget/EditText;
    //   24: invokevirtual 79	android/widget/EditText:getText	()Landroid/text/Editable;
    //   27: invokevirtual 85	java/lang/Object:toString	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_0
    //   32: invokevirtual 329	net/fred/feedex/activity/EditFeedActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   35: astore 5
    //   37: aload_0
    //   38: invokevirtual 329	net/fred/feedex/activity/EditFeedActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   41: getstatic 404	net/fred/feedex/provider/FeedData$FeedColumns:e	Landroid/net/Uri;
    //   44: getstatic 406	net/fred/feedex/provider/FeedData$FeedColumns:a	[Ljava/lang/String;
    //   47: ldc_w 408
    //   50: iconst_1
    //   51: anewarray 25	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: aload_2
    //   57: aastore
    //   58: aconst_null
    //   59: invokevirtual 339	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore 4
    //   64: aload 4
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +61 -> 129
    //   71: aload_1
    //   72: invokeinterface 411 1 0
    //   77: ifeq +52 -> 129
    //   80: aload_0
    //   81: invokevirtual 200	net/fred/feedex/activity/EditFeedActivity:getIntent	()Landroid/content/Intent;
    //   84: invokevirtual 333	android/content/Intent:getData	()Landroid/net/Uri;
    //   87: invokevirtual 364	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   90: aload_1
    //   91: iconst_0
    //   92: invokeinterface 345 2 0
    //   97: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifne +29 -> 129
    //   103: aload_0
    //   104: ldc_w 412
    //   107: iconst_1
    //   108: invokestatic 101	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   111: invokevirtual 104	android/widget/Toast:show	()V
    //   114: aload_1
    //   115: ifnull +9 -> 124
    //   118: aload_1
    //   119: invokeinterface 354 1 0
    //   124: aload_0
    //   125: invokespecial 414	net/fred/feedex/activity/BaseActivity:onDestroy	()V
    //   128: return
    //   129: new 416	android/content/ContentValues
    //   132: dup
    //   133: invokespecial 417	android/content/ContentValues:<init>	()V
    //   136: astore 4
    //   138: aload_2
    //   139: ldc_w 419
    //   142: invokevirtual 422	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   145: ifne +178 -> 323
    //   148: aload_2
    //   149: ldc_w 424
    //   152: invokevirtual 422	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   155: ifne +168 -> 323
    //   158: new 426	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 419
    //   168: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_2
    //   172: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 432	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: astore_2
    //   179: aload 4
    //   181: ldc 29
    //   183: aload_2
    //   184: invokevirtual 436	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_0
    //   188: getfield 73	net/fred/feedex/activity/EditFeedActivity:p	Landroid/widget/EditText;
    //   191: invokevirtual 79	android/widget/EditText:getText	()Landroid/text/Editable;
    //   194: invokevirtual 85	java/lang/Object:toString	()Ljava/lang/String;
    //   197: astore_2
    //   198: aload_2
    //   199: invokevirtual 88	java/lang/String:trim	()Ljava/lang/String;
    //   202: invokevirtual 440	java/lang/String:length	()I
    //   205: ifle +90 -> 295
    //   208: aload 4
    //   210: ldc 27
    //   212: aload_2
    //   213: invokevirtual 436	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_3
    //   217: astore_2
    //   218: aload_0
    //   219: getfield 58	net/fred/feedex/activity/EditFeedActivity:r	Landroid/widget/CheckBox;
    //   222: invokevirtual 156	android/widget/CheckBox:isChecked	()Z
    //   225: ifeq +8 -> 233
    //   228: iconst_1
    //   229: invokestatic 446	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: astore_2
    //   233: aload 4
    //   235: ldc 31
    //   237: aload_2
    //   238: invokevirtual 449	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   241: aload 4
    //   243: ldc_w 451
    //   246: iconst_0
    //   247: invokestatic 446	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   250: invokevirtual 449	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   253: aload 4
    //   255: ldc_w 453
    //   258: invokevirtual 457	android/content/ContentValues:putNull	(Ljava/lang/String;)V
    //   261: aload 5
    //   263: aload_0
    //   264: invokevirtual 200	net/fred/feedex/activity/EditFeedActivity:getIntent	()Landroid/content/Intent;
    //   267: invokevirtual 333	android/content/Intent:getData	()Landroid/net/Uri;
    //   270: aload 4
    //   272: aconst_null
    //   273: aconst_null
    //   274: invokevirtual 461	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   277: pop
    //   278: goto -164 -> 114
    //   281: astore_2
    //   282: aload_1
    //   283: ifnull -159 -> 124
    //   286: aload_1
    //   287: invokeinterface 354 1 0
    //   292: goto -168 -> 124
    //   295: aconst_null
    //   296: astore_2
    //   297: goto -89 -> 208
    //   300: astore_2
    //   301: aload_1
    //   302: ifnull +9 -> 311
    //   305: aload_1
    //   306: invokeinterface 354 1 0
    //   311: aload_2
    //   312: athrow
    //   313: astore_2
    //   314: goto -13 -> 301
    //   317: astore_1
    //   318: aconst_null
    //   319: astore_1
    //   320: goto -38 -> 282
    //   323: goto -144 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	EditFeedActivity
    //   1	305	1	localObject1	Object
    //   317	1	1	localException1	Exception
    //   319	1	1	localObject2	Object
    //   30	208	2	localObject3	Object
    //   281	1	2	localException2	Exception
    //   296	1	2	localObject4	Object
    //   300	12	2	localObject5	Object
    //   313	1	2	localObject6	Object
    //   3	214	3	localObject7	Object
    //   62	209	4	localObject8	Object
    //   35	227	5	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   71	114	281	java/lang/Exception
    //   129	179	281	java/lang/Exception
    //   179	208	281	java/lang/Exception
    //   208	216	281	java/lang/Exception
    //   218	233	281	java/lang/Exception
    //   233	278	281	java/lang/Exception
    //   37	64	300	finally
    //   71	114	313	finally
    //   129	179	313	finally
    //   179	208	313	finally
    //   208	216	313	finally
    //   218	233	313	finally
    //   233	278	313	finally
    //   37	64	317	java/lang/Exception
  }
  
  public void onLoaderReset(Loader paramLoader)
  {
    this.t.swapCursor(Constants.b);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332: 
      finish();
      return true;
    }
    paramMenuItem = getLayoutInflater().inflate(2130968609, null);
    new AlertDialog.Builder(this).setTitle(2131165237).setView(paramMenuItem).setPositiveButton(17039370, new EditFeedActivity.5(this, paramMenuItem)).setNegativeButton(17039360, new EditFeedActivity.4(this)).show();
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.o.getCurrentTab() == 0) {
      paramMenu.findItem(2131689623).setVisible(false);
    }
    for (;;)
    {
      return super.onPrepareOptionsMenu(paramMenu);
      paramMenu.findItem(2131689623).setVisible(true);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("STATE_CURRENT_TAB", this.o.getCurrentTab());
    super.onSaveInstanceState(paramBundle);
  }
}
