package com.quran.labs.quranreader;

import com.quran.labs.quranreader.component.application.ApplicationComponent;
import com.quran.labs.quranreader.component.application.DaggerDebugApplicationComponent;
import com.quran.labs.quranreader.module.application.ApplicationModule;

public class DebugApplication extends QuranApplication {

  @Override
  public void onCreate() {
    super.onCreate();


  }

  @Override
  protected ApplicationComponent initializeInjector() {
    return DaggerDebugApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }
}
