package com.quran.labs.quranreader.module.activity;

import com.quran.labs.quranreader.di.ActivityScope;
import com.quran.labs.quranreader.ui.PagerActivity;
import com.quran.labs.quranreader.ui.helpers.AyahSelectedListener;
import com.quran.labs.quranreader.util.QuranScreenInfo;
import com.quran.labs.quranreader.util.QuranUtils;

import dagger.Module;
import dagger.Provides;

@Module
public class PagerActivityModule {
  private final PagerActivity pagerActivity;

  public PagerActivityModule(PagerActivity pagerActivity) {
    this.pagerActivity = pagerActivity;
  }

  @Provides
  AyahSelectedListener provideAyahSelectedListener() {
    return this.pagerActivity;
  }

  @Provides
  @ActivityScope
  String provideImageWidth(QuranScreenInfo screenInfo) {
    return QuranUtils.isDualPages(pagerActivity, screenInfo) ?
        screenInfo.getTabletWidthParam() : screenInfo.getWidthParam();
  }
}
