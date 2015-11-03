package com.oneapp.app.demo.jinritoutiao.ui.fragment.joke;



import com.oneapp.app.demo.jinritoutiao.bean.JokeBean;

import java.util.ArrayList;

/**
 * Created by andy on 10/27/2015.
 */
public interface JokeListView {

    public void showLoading();

    public void hidenLoading();

    public void initList(ArrayList<JokeBean.JokeItem> jokeList);

    public void showNotify(int count);

}
