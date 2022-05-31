package net.fred.feedex.provider;

import android.content.ContentValues;

public class FeedData
{
  public static ContentValues a()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    return localContentValues;
  }
  
  public static ContentValues b()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.putNull("isread");
    return localContentValues;
  }
}
