package com.quran.labs.quranreader.presenter.bookmark;

import com.quran.labs.quranreader.dao.Tag;
import com.quran.labs.quranreader.model.bookmark.BookmarkModel;
import com.quran.labs.quranreader.presenter.Presenter;
import com.quran.labs.quranreader.ui.fragment.AddTagDialog;

import javax.inject.Inject;

public class AddTagDialogPresenter implements Presenter<AddTagDialog> {
  private BookmarkModel mBookmarkModel;

  @Inject
  AddTagDialogPresenter(BookmarkModel bookmarkModel) {
    mBookmarkModel = bookmarkModel;
  }

  public void addTag(String tagName) {
    mBookmarkModel.addTagObservable(tagName)
        .subscribe();
  }

  public void updateTag(Tag tag) {
    mBookmarkModel.updateTag(tag)
        .subscribe();
  }

  @Override
  public void bind(AddTagDialog dialog) {
  }

  @Override
  public void unbind(AddTagDialog dialog) {
  }
}
