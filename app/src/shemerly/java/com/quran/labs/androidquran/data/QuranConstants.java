package com.quran.labs.quranreader.data;

import com.quran.labs.quranreader.util.QuranScreenInfo;
import com.quran.labs.quranreader.util.ShemerlyPageProvider;

import android.support.annotation.NonNull;
import android.view.Display;

public class QuranConstants {
  public static final int NUMBER_OF_PAGES = 521;

  public static QuranScreenInfo.PageProvider getPageProvider(@NonNull Display display) {
    return new ShemerlyPageProvider();
  }
}
