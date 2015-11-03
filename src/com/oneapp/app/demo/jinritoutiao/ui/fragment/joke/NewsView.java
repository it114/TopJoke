package com.oneapp.app.demo.jinritoutiao.ui.fragment.joke;

import com.oneapp.app.demo.jinritoutiao.bean.NewsItem;

import java.util.ArrayList;

/**
 * Created by andy on 10/27/2015.
 */
public interface NewsView  {

    public void showLoading();

    public void hidenLoading();

    public void initList(ArrayList<NewsItem> newsList);

    public void showNotify(int count);

}
