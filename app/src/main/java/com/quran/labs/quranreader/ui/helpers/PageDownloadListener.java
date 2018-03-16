package com.quran.labs.quranreader.ui.helpers;

import android.graphics.drawable.BitmapDrawable;

import com.quran.labs.quranreader.common.Response;

public interface PageDownloadListener {
  void onLoadImageResponse(BitmapDrawable drawable, Response response);
}
