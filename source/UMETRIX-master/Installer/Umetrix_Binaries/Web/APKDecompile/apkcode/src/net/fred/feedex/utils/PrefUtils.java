package net.fred.feedex.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;
import net.fred.feedex.MainApplication;

public class PrefUtils
{
  public static int a(String paramString, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(MainApplication.a()).getInt(paramString, paramInt);
  }
  
  public static long a(String paramString, long paramLong)
  {
    return PreferenceManager.getDefaultSharedPreferences(MainApplication.a()).getLong(paramString, paramLong);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(MainApplication.a()).getString(paramString1, paramString2);
  }
  
  public static void a(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      PreferenceManager.getDefaultSharedPreferences(MainApplication.a()).registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
      return;
    }
    catch (Exception paramOnSharedPreferenceChangeListener) {}
  }
  
  public static void a(String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(MainApplication.a()).edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return PreferenceManager.getDefaultSharedPreferences(MainApplication.a()).getBoolean(paramString, paramBoolean);
  }
  
  public static void b(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      PreferenceManager.getDefaultSharedPreferences(MainApplication.a()).unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
      return;
    }
    catch (Exception paramOnSharedPreferenceChangeListener) {}
  }
  
  public static void b(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(MainApplication.a()).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.apply();
  }
  
  public static void b(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(MainApplication.a()).edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.apply();
  }
  
  public static void b(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(MainApplication.a()).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.apply();
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(MainApplication.a()).edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.apply();
  }
}
