// Generated code from Butter Knife. Do not modify!
package com.oneapp.app.demo.jinritoutiao.ui.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.oneapp.app.demo.jinritoutiao.ui.activity.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034124, "field 'mColumnHorizontalScrollView'");
    target.mColumnHorizontalScrollView = finder.castView(view, 2131034124, "field 'mColumnHorizontalScrollView'");
    view = finder.findRequiredView(source, 2131034125, "field 'mRadioGroup_content'");
    target.mRadioGroup_content = finder.castView(view, 2131034125, "field 'mRadioGroup_content'");
    view = finder.findRequiredView(source, 2131034128, "field 'll_more_columns'");
    target.ll_more_columns = finder.castView(view, 2131034128, "field 'll_more_columns'");
    view = finder.findRequiredView(source, 2131034123, "field 'rl_column'");
    target.rl_column = finder.castView(view, 2131034123, "field 'rl_column'");
    view = finder.findRequiredView(source, 2131034131, "field 'mViewPager'");
    target.mViewPager = finder.castView(view, 2131034131, "field 'mViewPager'");
    view = finder.findRequiredView(source, 2131034129, "field 'button_more_columns' and method 'choinceMoreChannel'");
    target.button_more_columns = finder.castView(view, 2131034129, "field 'button_more_columns'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.choinceMoreChannel();
        }
      });
    view = finder.findRequiredView(source, 2131034175, "field 'top_progress'");
    target.top_progress = finder.castView(view, 2131034175, "field 'top_progress'");
    view = finder.findRequiredView(source, 2131034174, "field 'top_refresh'");
    target.top_refresh = finder.castView(view, 2131034174, "field 'top_refresh'");
    view = finder.findRequiredView(source, 2131034126, "field 'shade_left'");
    target.shade_left = finder.castView(view, 2131034126, "field 'shade_left'");
    view = finder.findRequiredView(source, 2131034127, "field 'shade_right'");
    target.shade_right = finder.castView(view, 2131034127, "field 'shade_right'");
    view = finder.findRequiredView(source, 2131034168, "method 'showRightOrLeftPanel'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.showRightOrLeftPanel();
        }
      });
    view = finder.findRequiredView(source, 2131034166, "method 'onUserHeadClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onUserHeadClick();
        }
      });
  }

  @Override public void unbind(T target) {
    target.mColumnHorizontalScrollView = null;
    target.mRadioGroup_content = null;
    target.ll_more_columns = null;
    target.rl_column = null;
    target.mViewPager = null;
    target.button_more_columns = null;
    target.top_progress = null;
    target.top_refresh = null;
    target.shade_left = null;
    target.shade_right = null;
  }
}
