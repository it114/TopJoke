package com.oneapp.app.demo.jinritoutiao.ui.fragment.news;

import com.it114.android.oneframework.core.http.HttpRequestHandler;
import com.oneapp.app.demo.jinritoutiao.api.JokeApi;
import com.oneapp.app.demo.jinritoutiao.bean.NewsItem;

/**
 * Created by andy on 10/27/2015.
 */
public class NewsPresenterImpl extends NewsPresenter {

    private NewsView newsView;
    public NewsPresenterImpl(NewsView newsView){
        this.newsView = newsView;
    }

    @Override
    public void initNewsList(String category,int offset) {
        newsView.showLoading();
        JokeApi.getNewsList(category, offset, new HttpRequestHandler<NewsItem>() {
            @Override
            public void onSuccess(NewsItem data) {
                super.onSuccess(data);
                newsView.initList(data.newsList.data);
            }

            @Override
            public void onFailure(int statusCode, String error) {
                super.onFailure(statusCode, error);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                newsView.hidenLoading();
            }
        });
    }
}
