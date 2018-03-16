package com.quran.labs.quranreader.component.application;

import com.quran.labs.quranreader.QuranImportActivity;
import com.quran.labs.quranreader.component.activity.PagerActivityComponent;
import com.quran.labs.quranreader.data.QuranDataProvider;
import com.quran.labs.quranreader.module.application.ApplicationModule;
import com.quran.labs.quranreader.module.application.DatabaseModule;
import com.quran.labs.quranreader.module.application.NetworkModule;
import com.quran.labs.quranreader.service.QuranDownloadService;
import com.quran.labs.quranreader.ui.QuranActivity;
import com.quran.labs.quranreader.ui.TranslationManagerActivity;
import com.quran.labs.quranreader.ui.fragment.AddTagDialog;
import com.quran.labs.quranreader.ui.fragment.BookmarksFragment;
import com.quran.labs.quranreader.ui.fragment.QuranAdvancedSettingsFragment;
import com.quran.labs.quranreader.ui.fragment.QuranSettingsFragment;
import com.quran.labs.quranreader.ui.fragment.TagBookmarkDialog;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, DatabaseModule.class, NetworkModule.class } )
public interface ApplicationComponent {
  // subcomponents
  PagerActivityComponent.Builder pagerActivityComponentBuilder();

  // content provider
  void inject(QuranDataProvider quranDataProvider);

  // services
  void inject(QuranDownloadService quranDownloadService);

  // activities
  void inject(QuranActivity quranActivity);
  void inject(QuranImportActivity quranImportActivity);

  // fragments
  void inject(BookmarksFragment bookmarksFragment);
  void inject(QuranSettingsFragment fragment);
  void inject(TranslationManagerActivity translationManagerActivity);
  void inject(QuranAdvancedSettingsFragment quranAdvancedSettingsFragment);

  // dialogs
  void inject(TagBookmarkDialog tagBookmarkDialog);
  void inject(AddTagDialog addTagDialog);
}
