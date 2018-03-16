package com.quran.labs.quranreader.ui.helpers;

import android.content.Context;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.quran.labs.quranreader.common.Response;
import com.quran.labs.quranreader.di.ActivityScope;
import com.quran.labs.quranreader.util.QuranScreenInfo;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;

@ActivityScope
public class QuranPageWorker {
  private static final String TAG = "QuranPageWorker";

  private final Context appContext;
  private final OkHttpClient okHttpClient;
  private final String imageWidth;

  @Inject
  QuranPageWorker(Context context, OkHttpClient okHttpClient, String imageWidth) {
    this.appContext = context;
    this.okHttpClient = okHttpClient;
    this.imageWidth = imageWidth;
  }

  private Response downloadImage(int pageNumber) {
    Response response = null;
    OutOfMemoryError oom = null;

    try {
      response = QuranDisplayHelper.getQuranPage(okHttpClient, appContext, imageWidth, pageNumber);
    } catch (OutOfMemoryError me){
      Crashlytics.log(Log.WARN, TAG,
          "out of memory exception loading page " + pageNumber + ", " + imageWidth);
      oom = me;
    }

    if (response == null ||
        (response.getBitmap() == null &&
            response.getErrorCode() != Response.ERROR_SD_CARD_NOT_FOUND)){
      if (QuranScreenInfo.getInstance().isTablet(appContext)){
        Crashlytics.log(Log.WARN, TAG, "tablet got bitmap null, trying alternate width...");
        String param = QuranScreenInfo.getInstance().getWidthParam();
        if (param.equals(imageWidth)){
          param = QuranScreenInfo.getInstance().getTabletWidthParam();
        }
        response = QuranDisplayHelper.getQuranPage(okHttpClient, appContext, param, pageNumber);
        if (response.getBitmap() == null){
          Crashlytics.log(Log.WARN, TAG,
              "bitmap still null, giving up... [" + response.getErrorCode() + "]");
        }
      }
      Crashlytics.log(Log.WARN, TAG, "got response back as null... [" +
          (response == null ? "" : response.getErrorCode()));
    }

    if ((response == null || response.getBitmap() == null) && oom != null) {
      throw oom;
    }

    response.setPageData(pageNumber);
    return response;
  }

  public Observable<Response> loadPages(Integer... pages) {
    return Observable.fromArray(pages)
        .flatMap(page -> Observable.fromCallable(() -> downloadImage(page)))
        .subscribeOn(Schedulers.io());
  }
}
