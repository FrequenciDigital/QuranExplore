package com.quran.labs.quranreader.component.activity;

import com.quran.labs.quranreader.component.fragment.QuranPageComponent;
import com.quran.labs.quranreader.di.ActivityScope;
import com.quran.labs.quranreader.module.activity.PagerActivityModule;
import com.quran.labs.quranreader.ui.PagerActivity;
import com.quran.labs.quranreader.ui.fragment.AyahTranslationFragment;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = PagerActivityModule.class)
public interface PagerActivityComponent {
  // subcomponents
  QuranPageComponent.Builder quranPageComponentBuilder();

  void inject(PagerActivity pagerActivity);
  void inject(AyahTranslationFragment ayahTranslationFragment);

  @Subcomponent.Builder interface Builder {
    Builder withPagerActivityModule(PagerActivityModule pagerModule);
    PagerActivityComponent build();
  }
}
