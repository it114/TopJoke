// Generated code from Butter Knife. Do not modify!
package com.oneapp.app.demo.jinritoutiao.ui.fragment.news;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NewsFragment$$ViewBinder<T extends com.oneapp.app.demo.jinritoutiao.ui.fragment.news.NewsFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034161, "field 'mListView'");
    target.mListView = finder.castView(view, 2131034161, "field 'mListView'");
    view = finder.findRequiredView(source, 2131034159, "field 'item_textview'");
    target.item_textview = finder.castView(view, 2131034159, "field 'item_textview'");
    view = finder.findRequiredView(source, 2131034160, "field 'detail_loading'");
    target.detail_loading = finder.castView(view, 2131034160, "field 'detail_loading'");
    view = finder.findRequiredView(source, 2131034162, "field 'notify_view'");
    target.notify_view = finder.castView(view, 2131034162, "field 'notify_view'");
    view = finder.findRequiredView(source, 2131034163, "field 'notify_view_text'");
    target.notify_view_text = finder.castView(view, 2131034163, "field 'notify_view_text'");
  }

  @Override public void unbind(T target) {
    target.mListView = null;
    target.item_textview = null;
    target.detail_loading = null;
    target.notify_view = null;
    target.notify_view_text = null;
  }
}
