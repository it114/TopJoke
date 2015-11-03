package com.oneapp.app.demo.jinritoutiao.ui.fragment.joke;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Bind;
import com.it114.android.oneframework.core.ui.fragment.SupportFragment;

import com.oneapp.app.demo.jinritoutiao.R;
import com.oneapp.app.demo.jinritoutiao.adapter.JokeAdapter;
import com.oneapp.app.demo.jinritoutiao.bean.JokeBean;
import com.oneapp.app.demo.jinritoutiao.view.HeadListView;


import java.util.ArrayList;

/**
 * Created by andy on 10/26/2015.
 */
public class JokeListFragment extends SupportFragment implements JokeListView {

    @Bind(R.id.mListView)HeadListView mListView ;
    @Bind(R.id.item_textview)TextView item_textview ;
    @Bind(R.id.detail_loading)ImageView detail_loading;
    //Toast提示框
    @Bind(R.id.notify_view)RelativeLayout notify_view;
    @Bind(R.id.notify_view_text) TextView notify_view_text;

    JokeAdapter mAdapter;

    private JokeListPresenter presenter;

    private String category = "";
    private int page = 0;
    public JokeListFragment(String category){
        this.category = category;
    }
    
    @Override
    protected void init() {
        Bundle arguments = getArguments();
        String category = arguments.getString("category");
        String text = arguments.getString("text");
        item_textview.setText(text);
        presenter = new JokeListPresenterImpl(this);
        presenter.getJokeList(category, page);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_news_layout;
    }

    @Override
    public void showLoading() {
        detail_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidenLoading() {
        detail_loading.setVisibility(View.GONE);
    }

    @Override
    public void initList(ArrayList<JokeBean.JokeItem> newsList) {
        detail_loading.setVisibility(View.GONE);
        if(mAdapter == null){
            mAdapter = new JokeAdapter(mListView, newsList,getActivity());
        }
        mListView.setAdapter(mAdapter);
        mListView.setOnScrollListener(mAdapter);
        mListView.setPinnedHeaderView(LayoutInflater.from(getActivity()).inflate(R.layout.list_item_section, mListView, false));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Intent intent = new Intent(getActivity(), DetailsActivity.class);
//                if(channel_id == Constants.CHANNEL_CITY){
//                    if(position != 0){
//                        intent.putExtra("news", mAdapter.getItem(position - 1));
//                        startActivity(intent);
//                        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    }
//                }else{
//                    intent.putExtra("news", mAdapter.getItem(position));
//                    startActivity(intent);
//                    activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                }
            }
        });
//        if(channel_id == 1){
//            initNotify();
//        }
    }

    @Override
    public void showNotify(final int count) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                notify_view_text.setText(String.format(getString(R.string.ss_pattern_update), count));
                notify_view.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        notify_view.setVisibility(View.GONE);
                    }
                }, 2000);
            }
        }, 1000);
    }
}
