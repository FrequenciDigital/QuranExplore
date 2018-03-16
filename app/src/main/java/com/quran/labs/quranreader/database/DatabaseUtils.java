package com.quran.labs.quranreader.database;

import android.database.Cursor;

public class DatabaseUtils {

  public static void closeCursor(Cursor cursor) {
    if (cursor != null) {
      try {
        cursor.close();
      } catch (Exception e) {
        // no op
      }
    }
  }
}
