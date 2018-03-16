package com.quran.labs.quranreader.presenter;

public interface Presenter<T> {
  void bind(T what);
  void unbind(T what);
}
