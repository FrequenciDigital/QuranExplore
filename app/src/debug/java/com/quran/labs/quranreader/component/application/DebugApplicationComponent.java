package com.quran.labs.quranreader.component.application;

import com.quran.labs.quranreader.module.application.ApplicationModule;
import com.quran.labs.quranreader.module.application.DatabaseModule;
import com.quran.labs.quranreader.module.application.DebugNetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, DatabaseModule.class, DebugNetworkModule.class } )
interface DebugApplicationComponent extends ApplicationComponent {
}
