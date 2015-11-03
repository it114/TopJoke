package com.oneapp.app.demo.jinritoutiao.ui.fragment.joke;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.it114.android.oneframework.core.http.HttpRequestHandler;
import com.oneapp.app.demo.jinritoutiao.api.JokeApi;
import com.oneapp.app.demo.jinritoutiao.bean.JokeBean;

/**
 * Created by andy on 10/27/2015.
 */
public class JokeListPresenterImpl extends JokeListPresenter {

    private JokeListView newsView;
    protected int currentPage;
    protected int maxPage;

    public JokeListPresenterImpl(JokeListView newsView){
        this.newsView = newsView;
    }

    @Override
    public void getJokeList(String category,int page) {
        newsView.showLoading();
        this.currentPage = page;
        JokeApi.getTextJoke(page, new HttpRequestHandler() {
            @Override
            public void onSuccess(Object data) {
                super.onSuccess(data);
                String str = (String) data;
                if (!TextUtils.isEmpty(str)) {
                    Gson gson = new Gson();
                    JokeBean joke = gson.fromJson(str, JokeBean.class);
                    newsView.initList(joke.body.items);
                }
            }

            @Override
            public void onFailure(int statusCode, String error) {
                super.onFailure(statusCode, error);
            }

            @Override
            public void onFinish() {
                super.onFinish();
            }
        });
    }




}
