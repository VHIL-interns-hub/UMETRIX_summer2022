package net.fred.feedex.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.Date;
import java.util.List;
import net.fred.feedex.utils.NetworkUtils;

public class FeedDataContentProvider
  extends ContentProvider
{
  public static final UriMatcher a = new UriMatcher(-1);
  private final String[] b = { "MAX(priority)" };
  private DatabaseHelper c;
  
  static
  {
    a.addURI("net.fred.feedex.provider.FeedData", "grouped_feeds", 1);
    a.addURI("net.fred.feedex.provider.FeedData", "groups", 2);
    a.addURI("net.fred.feedex.provider.FeedData", "groups/#", 3);
    a.addURI("net.fred.feedex.provider.FeedData", "groups/#/feeds", 4);
    a.addURI("net.fred.feedex.provider.FeedData", "feeds", 5);
    a.addURI("net.fred.feedex.provider.FeedData", "feeds/#", 6);
    a.addURI("net.fred.feedex.provider.FeedData", "feeds/#/entries", 9);
    a.addURI("net.fred.feedex.provider.FeedData", "feeds/#/entries/#", 10);
    a.addURI("net.fred.feedex.provider.FeedData", "groups/#/entries", 11);
    a.addURI("net.fred.feedex.provider.FeedData", "groups/#/entries/#", 12);
    a.addURI("net.fred.feedex.provider.FeedData", "filters", 7);
    a.addURI("net.fred.feedex.provider.FeedData", "feeds/#/filters", 8);
    a.addURI("net.fred.feedex.provider.FeedData", "entries", 13);
    a.addURI("net.fred.feedex.provider.FeedData", "entries/#", 14);
    a.addURI("net.fred.feedex.provider.FeedData", "unread_entries", 15);
    a.addURI("net.fred.feedex.provider.FeedData", "unread_entries/#", 16);
    a.addURI("net.fred.feedex.provider.FeedData", "favorites", 17);
    a.addURI("net.fred.feedex.provider.FeedData", "favorites/#", 18);
    a.addURI("net.fred.feedex.provider.FeedData", "tasks", 19);
    a.addURI("net.fred.feedex.provider.FeedData", "tasks/#", 20);
    a.addURI("net.fred.feedex.provider.FeedData", "entries/search/*", 21);
    a.addURI("net.fred.feedex.provider.FeedData", "entries/search/*/#", 22);
  }
  
  public FeedDataContentProvider() {}
  
  private static String a(String paramString)
  {
    paramString = Uri.decode(paramString).trim();
    if (!paramString.isEmpty())
    {
      paramString = DatabaseUtils.sqlEscapeString("%" + Uri.decode(paramString) + "%");
      return "title LIKE " + paramString + " OR " + "abstract" + " LIKE " + paramString + " OR " + "mobilized" + " LIKE " + paramString;
    }
    return "1 = 2";
  }
  
  private void a(int paramInt, Uri paramUri)
  {
    ContentResolver localContentResolver = getContext().getContentResolver();
    localContentResolver.notifyChange(paramUri, null);
    if ((paramInt != 7) && (paramInt != 8) && (paramInt != 19) && (paramInt != 20))
    {
      localContentResolver.notifyChange(FeedData.FeedColumns.f, null);
      localContentResolver.notifyChange(FeedData.EntryColumns.d, null);
      localContentResolver.notifyChange(FeedData.EntryColumns.e, null);
      localContentResolver.notifyChange(FeedData.FeedColumns.e, null);
      localContentResolver.notifyChange(FeedData.FeedColumns.g, null);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = null;
    ContentResolver localContentResolver = paramContext.getContentResolver();
    String str = paramString1;
    if (!paramString1.startsWith("http://"))
    {
      str = paramString1;
      if (!paramString1.startsWith("https://")) {
        str = "http://" + paramString1;
      }
    }
    paramString1 = localContentResolver.query(FeedData.FeedColumns.e, null, "url=?", new String[] { str }, null);
    if (paramString1.moveToFirst())
    {
      paramString1.close();
      Toast.makeText(paramContext, 2131165229, 0).show();
      return;
    }
    paramString1.close();
    paramString1 = new ContentValues();
    paramString1.put("url", str);
    paramString1.putNull("error");
    if (paramString2.trim().length() > 0) {
      paramString1.put("name", paramString2);
    }
    paramContext = localObject;
    if (paramBoolean) {
      paramContext = Integer.valueOf(1);
    }
    paramString1.put("retrievefulltext", paramContext);
    localContentResolver.insert(FeedData.FeedColumns.e, paramString1);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = a.match(paramUri);
    StringBuilder localStringBuilder = new StringBuilder();
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    Object localObject1;
    Object localObject2;
    int j;
    switch (i)
    {
    case 5: 
    case 15: 
    case 21: 
    default: 
      throw new IllegalArgumentException("Illegal delete. Match code=" + i + "; uri=" + paramUri);
    case 3: 
      localObject1 = (String)paramUri.getPathSegments().get(1);
      localStringBuilder.append("_id").append('=').append((String)localObject1);
      localObject2 = localSQLiteDatabase.query("feeds", FeedData.FeedColumns.a, "groupid=" + (String)localObject1, null, null, null, null);
      while (((Cursor)localObject2).moveToNext()) {
        delete(FeedData.FeedColumns.a(((Cursor)localObject2).getString(0)), null, null);
      }
      ((Cursor)localObject2).close();
      localObject1 = localSQLiteDatabase.query("feeds", FeedData.FeedColumns.c, "_id=" + (String)localObject1, null, null, null, null);
      if (((Cursor)localObject1).moveToNext())
      {
        j = ((Cursor)localObject1).getInt(0);
        localObject2 = "priority > " + j;
        localSQLiteDatabase.execSQL("UPDATE feeds SET priority = priority-1 WHERE " + "(isgroup=1 OR groupid IS NULL)" + " AND " + (String)localObject2);
      }
      ((Cursor)localObject1).close();
      localObject1 = "feeds";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(" AND ");
        }
        localStringBuilder.append(paramString);
      }
      if ("entries".equals(localObject1)) {
        NetworkUtils.a(paramUri, localStringBuilder.toString(), paramArrayOfString);
      }
      j = localSQLiteDatabase.delete((String)localObject1, localStringBuilder.toString(), paramArrayOfString);
      if (j > 0)
      {
        if ("feeds".equals(localObject1)) {
          this.c.a();
        }
        a(i, paramUri);
      }
      return j;
      localObject1 = (String)paramUri.getPathSegments().get(1);
      new FeedDataContentProvider.1(this, (String)localObject1).start();
      localStringBuilder.append("_id").append('=').append((String)localObject1);
      localObject1 = "_id=" + (String)localObject1;
      localObject2 = localSQLiteDatabase.query("feeds", new String[] { "priority", "groupid" }, (String)localObject1, null, null, null, null);
      Object localObject3;
      if (((Cursor)localObject2).moveToNext())
      {
        j = ((Cursor)localObject2).getInt(0);
        localObject1 = ((Cursor)localObject2).getString(1);
        localObject3 = new StringBuilder().append('(');
        if (localObject1 == null) {
          break label761;
        }
      }
      label761:
      for (localObject1 = "groupid=" + (String)localObject1;; localObject1 = "isgroup=1 OR groupid IS NULL")
      {
        localObject1 = (String)localObject1 + ')';
        localObject3 = "priority > " + j;
        localSQLiteDatabase.execSQL("UPDATE feeds SET priority = priority-1 WHERE " + (String)localObject1 + " AND " + (String)localObject3);
        ((Cursor)localObject2).close();
        localObject1 = "feeds";
        break;
      }
      localStringBuilder.append("groupid").append('=').append((String)paramUri.getPathSegments().get(1));
      localObject1 = "feeds";
      continue;
      localObject1 = "filters";
      continue;
      localStringBuilder.append("feedid").append('=').append((String)paramUri.getPathSegments().get(1));
      localObject1 = "filters";
      continue;
      localObject1 = (String)paramUri.getPathSegments().get(3);
      localStringBuilder.append("_id").append('=').append((String)localObject1);
      new FeedDataContentProvider.2(this, (String)localObject1).start();
      localObject1 = "entries";
      continue;
      localStringBuilder.append("feedid").append('=').append((String)paramUri.getPathSegments().get(1));
      localObject1 = "entries";
      continue;
      localStringBuilder.append("feedid").append(" IN (SELECT ").append("_id").append(" FROM ").append("feeds").append(" WHERE ").append("groupid").append('=').append((String)paramUri.getPathSegments().get(1)).append(')');
      localObject1 = "entries";
      continue;
      localObject1 = "entries";
      new FeedDataContentProvider.3(this).start();
      continue;
      localStringBuilder.append("_id").append('=').append((String)paramUri.getPathSegments().get(1));
      localObject1 = "entries";
      continue;
      localObject1 = "entries";
      localStringBuilder.append("favorite").append("=1");
      continue;
      localObject1 = "tasks";
      continue;
      localStringBuilder.append("_id").append('=').append((String)paramUri.getPathSegments().get(1));
      localObject1 = "tasks";
    }
  }
  
  public String getType(Uri paramUri)
  {
    switch (a.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unknown URI: " + paramUri);
    case 1: 
    case 2: 
    case 4: 
    case 5: 
      return "vnd.android.cursor.dir/vnd.flym.feed";
    case 3: 
    case 6: 
      return "vnd.android.cursor.item/vnd.flym.feed";
    case 7: 
    case 8: 
      return "vnd.android.cursor.dir/vnd.flym.filter";
    case 9: 
    case 11: 
    case 13: 
    case 15: 
    case 17: 
    case 21: 
      return "vnd.android.cursor.dir/vnd.flym.entry";
    case 10: 
    case 12: 
    case 14: 
    case 16: 
    case 18: 
    case 22: 
      return "vnd.android.cursor.item/vnd.flym.entry";
    case 19: 
      return "vnd.android.cursor.dir/vnd.flym.task";
    }
    return "vnd.android.cursor.item/vnd.flym.task";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    int i = a.match(paramUri);
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    Cursor localCursor;
    label176:
    long l;
    switch (i)
    {
    default: 
      throw new IllegalArgumentException("Illegal insert. Match code=" + i + "; uri=" + paramUri);
    case 2: 
    case 5: 
      if (paramContentValues.containsKey("groupid"))
      {
        localCursor = query(FeedData.FeedColumns.b(paramContentValues.getAsString("groupid")), this.b, null, null, null);
        if (!localCursor.moveToFirst()) {
          break label246;
        }
        paramContentValues.put("priority", Integer.valueOf(localCursor.getInt(0) + 1));
        localCursor.close();
        l = localSQLiteDatabase.insert("feeds", null, paramContentValues);
        this.c.a();
      }
      break;
    }
    for (;;)
    {
      paramContentValues = paramUri;
      if (l > -1L)
      {
        a(i, paramUri);
        paramContentValues = ContentUris.withAppendedId(paramUri, l);
      }
      return paramContentValues;
      localCursor = query(FeedData.FeedColumns.g, this.b, null, null, null);
      break;
      label246:
      paramContentValues.put("priority", Integer.valueOf(1));
      break label176;
      l = localSQLiteDatabase.insert("filters", null, paramContentValues);
      continue;
      paramContentValues.put("feedid", (String)paramUri.getPathSegments().get(1));
      l = localSQLiteDatabase.insert("filters", null, paramContentValues);
      continue;
      paramContentValues.put("feedid", (String)paramUri.getPathSegments().get(1));
      paramContentValues.put("fetch_date", Long.valueOf(new Date().getTime()));
      l = localSQLiteDatabase.insert("entries", null, paramContentValues);
      continue;
      l = localSQLiteDatabase.insert("tasks", null, paramContentValues);
    }
  }
  
  public boolean onCreate()
  {
    this.c = new DatabaseHelper(new Handler(), getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (paramUri != null) {}
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    int i = a.match(paramUri);
    if (((i == 5) || (i == 2) || (i == 4)) && (paramString2 == null)) {
      paramString2 = "priority";
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Illegal query. Match code=" + i + "; uri=" + paramUri);
      case 1: 
        localSQLiteQueryBuilder.setTables("feeds LEFT JOIN (SELECT _id AS joined_feed_id, priority AS group_priority FROM feeds) AS f ON (feeds.groupid = f.joined_feed_id)");
        paramString2 = "IFNULL(group_priority, priority), IFNULL(groupid, _id), isgroup DESC, priority";
      }
      for (;;)
      {
        paramArrayOfString1 = localSQLiteQueryBuilder.query(this.c.getReadableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
        return paramArrayOfString1;
        localSQLiteQueryBuilder.setTables("feeds");
        localSQLiteQueryBuilder.appendWhere(new StringBuilder("isgroup").append("=1").append(" OR ").append("groupid").append(" IS NULL"));
        continue;
        localSQLiteQueryBuilder.setTables("feeds");
        localSQLiteQueryBuilder.appendWhere(new StringBuilder("groupid").append('=').append((String)paramUri.getPathSegments().get(1)));
        continue;
        localSQLiteQueryBuilder.setTables("feeds");
        localSQLiteQueryBuilder.appendWhere(new StringBuilder("_id").append('=').append((String)paramUri.getPathSegments().get(1)));
        continue;
        localSQLiteQueryBuilder.setTables("feeds");
        localSQLiteQueryBuilder.appendWhere(new StringBuilder("isgroup").append(" IS NULL"));
        continue;
        localSQLiteQueryBuilder.setTables("filters");
        continue;
        localSQLiteQueryBuilder.setTables("filters");
        localSQLiteQueryBuilder.appendWhere(new StringBuilder("feedid").append('=').append((String)paramUri.getPathSegments().get(1)));
        continue;
        localSQLiteQueryBuilder.setTables("entries JOIN (SELECT _id AS joined_feed_id, name, url, icon, groupid FROM feeds) AS f ON (entries.feedid = f.joined_feed_id)");
        localSQLiteQueryBuilder.appendWhere(new StringBuilder("_id").append('=').append((String)paramUri.getPathSegments().get(3)));
        continue;
        localSQLiteQueryBuilder.setTables("entries JOIN (SELECT _id AS joined_feed_id, name, url, icon, groupid FROM feeds) AS f ON (entries.feedid = f.joined_feed_id)");
        localSQLiteQueryBuilder.appendWhere(new StringBuilder("feedid").append('=').append((String)paramUri.getPathSegments().get(1)));
        continue;
        localSQLiteQueryBuilder.setTables("entries JOIN (SELECT _id AS joined_feed_id, name, url, icon, groupid FROM feeds) AS f ON (entries.feedid = f.joined_feed_id)");
        localSQLiteQueryBuilder.appendWhere(new StringBuilder("groupid").append('=').append((String)paramUri.getPathSegments().get(1)));
        continue;
        localSQLiteQueryBuilder.setTables("entries JOIN (SELECT _id AS joined_feed_id, name, url, icon, groupid FROM feeds) AS f ON (entries.feedid = f.joined_feed_id)");
        continue;
        localSQLiteQueryBuilder.setTables("entries JOIN (SELECT _id AS joined_feed_id, name, url, icon, groupid FROM feeds) AS f ON (entries.feedid = f.joined_feed_id)");
        localSQLiteQueryBuilder.appendWhere("(isread IS NULL OR isread=0)");
        continue;
        localSQLiteQueryBuilder.setTables("entries JOIN (SELECT _id AS joined_feed_id, name, url, icon, groupid FROM feeds) AS f ON (entries.feedid = f.joined_feed_id)");
        localSQLiteQueryBuilder.appendWhere(a((String)paramUri.getPathSegments().get(2)));
        continue;
        localSQLiteQueryBuilder.setTables("entries JOIN (SELECT _id AS joined_feed_id, name, url, icon, groupid FROM feeds) AS f ON (entries.feedid = f.joined_feed_id)");
        localSQLiteQueryBuilder.appendWhere(new StringBuilder("_id").append('=').append((String)paramUri.getPathSegments().get(1)));
        continue;
        localSQLiteQueryBuilder.setTables("entries JOIN (SELECT _id AS joined_feed_id, name, url, icon, groupid FROM feeds) AS f ON (entries.feedid = f.joined_feed_id)");
        localSQLiteQueryBuilder.appendWhere(new StringBuilder("favorite").append("=1"));
        continue;
        localSQLiteQueryBuilder.setTables("tasks");
        continue;
        localSQLiteQueryBuilder.setTables("tasks");
        localSQLiteQueryBuilder.appendWhere(new StringBuilder("_id").append('=').append((String)paramUri.getPathSegments().get(1)));
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if ((paramUri == null) || (paramContentValues == null)) {
      throw new IllegalArgumentException("Illegal update. Uri=" + paramUri + "; values=" + paramContentValues);
    }
    int i = a.match(paramUri);
    StringBuilder localStringBuilder1 = new StringBuilder();
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    Object localObject;
    int j;
    int k;
    String str1;
    switch (i)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("Illegal update. Match code=" + i + "; uri=" + paramUri);
    case 6: 
      long l = Long.parseLong((String)paramUri.getPathSegments().get(1));
      localStringBuilder1.append("_id").append('=').append(l);
      if (paramContentValues.containsKey("priority"))
      {
        localObject = "_id=" + l;
        localObject = localSQLiteDatabase.query("feeds", new String[] { "priority", "groupid" }, (String)localObject, null, null, null, null);
        if (((Cursor)localObject).moveToNext())
        {
          j = ((Cursor)localObject).getInt(0);
          String str2 = ((Cursor)localObject).getString(1);
          k = paramContentValues.getAsInteger("priority").intValue();
          str1 = paramContentValues.getAsString("groupid");
          ((Cursor)localObject).close();
          StringBuilder localStringBuilder2 = new StringBuilder().append('(');
          if (str2 != null)
          {
            localObject = "groupid=" + str2;
            localObject = (String)localObject + ')';
            if (((str2 != null) || (str1 == null)) && ((str2 == null) || (str1 != null)) && ((str2 == null) || (str1 == null) || (str2.equals(str1)))) {
              break label798;
            }
            str2 = "priority>" + j;
            localSQLiteDatabase.execSQL("UPDATE feeds SET priority=" + "priority-1" + " WHERE " + (String)localObject + " AND " + str2);
            str2 = "priority>" + (k - 1);
            localStringBuilder2 = new StringBuilder().append('(');
            if (str1 == null) {
              break label790;
            }
            localObject = "groupid=" + str1;
            label607:
            localObject = (String)localObject + ')';
            localSQLiteDatabase.execSQL("UPDATE feeds SET priority=" + "priority+1" + " WHERE " + (String)localObject + " AND " + str2);
            label673:
            localObject = "feeds";
          }
        }
      }
      break;
    }
    for (;;)
    {
      label677:
      if (!TextUtils.isEmpty(paramString))
      {
        if (localStringBuilder1.length() <= 0) {
          break label1365;
        }
        localStringBuilder1.append(" AND ").append(paramString);
      }
      for (;;)
      {
        j = localSQLiteDatabase.update((String)localObject, paramContentValues, localStringBuilder1.toString(), paramArrayOfString);
        if (("feeds".equals(localObject)) && ((paramContentValues.containsKey("name")) || (paramContentValues.containsKey("url")) || (paramContentValues.containsKey("priority")))) {
          this.c.a();
        }
        if (j > 0) {
          a(i, paramUri);
        }
        return j;
        localObject = "isgroup=1 OR groupid IS NULL";
        break;
        label790:
        localObject = "isgroup=1 OR groupid IS NULL";
        break label607;
        label798:
        if (k > j)
        {
          str1 = "(priority BETWEEN " + (j + 1) + " AND " + k + ')';
          localSQLiteDatabase.execSQL("UPDATE feeds SET priority=" + "priority-1" + " WHERE " + (String)localObject + " AND " + str1);
          break label673;
        }
        if (k >= j) {
          break label673;
        }
        str1 = "(priority BETWEEN " + k + " AND " + (j - 1) + ')';
        localSQLiteDatabase.execSQL("UPDATE feeds SET priority=" + "priority+1" + " WHERE " + (String)localObject + " AND " + str1);
        break label673;
        ((Cursor)localObject).close();
        break label673;
        localObject = "feeds";
        break label677;
        localObject = "filters";
        break label677;
        localStringBuilder1.append("feedid").append('=').append((String)paramUri.getPathSegments().get(1));
        localObject = "filters";
        break label677;
        localStringBuilder1.append("_id").append('=').append((String)paramUri.getPathSegments().get(3));
        localObject = "entries";
        break label677;
        localStringBuilder1.append("feedid").append('=').append((String)paramUri.getPathSegments().get(1));
        localObject = "entries";
        break label677;
        localStringBuilder1.append("feedid").append(" IN (SELECT ").append("_id").append(" FROM ").append("feeds").append(" WHERE ").append("groupid").append('=').append((String)paramUri.getPathSegments().get(1)).append(')');
        localObject = "entries";
        break label677;
        localObject = "entries";
        break label677;
        localObject = "entries";
        localStringBuilder1.append("(isread IS NULL OR isread=0)");
        break label677;
        localStringBuilder1.append(a((String)paramUri.getPathSegments().get(2)));
        localObject = "entries";
        break label677;
        localStringBuilder1.append("_id").append('=').append((String)paramUri.getPathSegments().get(1));
        localObject = "entries";
        break label677;
        localObject = "entries";
        localStringBuilder1.append("favorite").append("=1");
        break label677;
        localObject = "tasks";
        break label677;
        localStringBuilder1.append("_id").append('=').append((String)paramUri.getPathSegments().get(1));
        localObject = "tasks";
        break label677;
        label1365:
        localStringBuilder1.append(paramString);
      }
      localObject = "feeds";
    }
  }
}
