package net.fred.feedex;

import android.app.NotificationManager;
import android.content.Context;
import android.database.MatrixCursor;

public final class Constants
{
  public static final NotificationManager a = (NotificationManager)MainApplication.a().getSystemService("notification");
  public static final MatrixCursor b = new MatrixCursor(new String[] { "_id" });
}
