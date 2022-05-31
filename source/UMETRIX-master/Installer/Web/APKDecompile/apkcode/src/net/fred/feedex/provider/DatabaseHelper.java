package net.fred.feedex.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.os.Handler;
import java.io.File;
import net.fred.feedex.parser.OPML;

class DatabaseHelper
  extends SQLiteOpenHelper
{
  private final Handler a;
  
  public DatabaseHelper(Handler paramHandler, Context paramContext)
  {
    super(paramContext, "FeedEx.db", null, 8);
    this.a = paramHandler;
  }
  
  private String a(String paramString, String[][] paramArrayOfString)
  {
    if ((paramString == null) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      throw new IllegalArgumentException("Invalid parameters for creating table " + paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (");
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(paramArrayOfString[i][0]).append(' ').append(paramArrayOfString[i][1]);
      i += 1;
    }
    return ");";
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      paramSQLiteDatabase.execSQL(paramString);
      return;
    }
    catch (Exception paramSQLiteDatabase) {}
  }
  
  private void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  public void a()
  {
    try
    {
      OPML.b(OPML.a);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(a("feeds", FeedData.FeedColumns.d));
    paramSQLiteDatabase.execSQL(a("filters", FeedData.FilterColumns.a));
    paramSQLiteDatabase.execSQL(a("entries", FeedData.EntryColumns.b));
    paramSQLiteDatabase.execSQL(a("tasks", FeedData.TaskColumns.b));
    if (new File(OPML.a).exists()) {
      this.a.post(new DatabaseHelper.1(this));
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 2) {
      a(paramSQLiteDatabase, "ALTER TABLE feeds ADD reallastupdate DATETIME");
    }
    if (paramInt1 < 3) {
      a(paramSQLiteDatabase, "ALTER TABLE feeds ADD retrievefulltext INTEGER(1)");
    }
    if (paramInt1 < 4) {
      a(paramSQLiteDatabase, a("tasks", FeedData.TaskColumns.b));
    }
    try
    {
      a(new File(Environment.getExternalStorageDirectory() + "/FeedEx/"));
      if (paramInt1 < 5) {
        a(paramSQLiteDatabase, "ALTER TABLE tasks ADD UNIQUE(entryid, imgurl_to_dl) ON CONFLICT IGNORE");
      }
      if (paramInt1 < 6) {
        a(paramSQLiteDatabase, "ALTER TABLE filters ADD isacceptrule INTEGER(1)");
      }
      if (paramInt1 < 7) {
        a(paramSQLiteDatabase, "ALTER TABLE entries ADD fetch_date DATETIME");
      }
      if (paramInt1 < 8) {
        a(paramSQLiteDatabase, "ALTER TABLE entries ADD image_url TEXT");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}
