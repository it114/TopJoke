package com.oneapp.app.demo.jinritoutiao.adapter;

import android.app.Activity;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SectionIndexer;
import com.it114.android.oneframework.core.adapter.AdapterHolder;
import com.it114.android.oneframework.core.adapter.CommonAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.oneapp.app.demo.jinritoutiao.bean.JokeBean;

import com.oneapp.app.demo.jinritoutiao.R;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by andy on 11/3/2015.
 */
public class JokeAdapter extends CommonAdapter<JokeBean.JokeItem> implements SectionIndexer {
    /** 弹出的更多选择框  */
    private PopupWindow popupWindow;
    private Activity context;
    private ImageView btn_pop_close;
    private List<Integer> mPositions;
    private List<String> mSections;
    ArrayList<JokeBean.JokeItem> mDatas;
    public JokeAdapter(AbsListView view, Collection<JokeBean.JokeItem> mDatas, Activity context) {
        super(view, mDatas, R.layout.joke_list_item_1);
        this.context= context;
        this.mDatas = (ArrayList<JokeBean.JokeItem>) mDatas;
        initDateHead();
    }

    private void initDateHead() {
        mSections = new ArrayList<String>();
        mPositions= new ArrayList<Integer>();
        for(int i = 0; i <mDatas.size();i++){
            if(i == 0){
                mSections.add(mDatas.get(i).ptime);
                mPositions.add(i);
                continue;
            }
            if(i != mDatas.size()){
                if(mDatas.get(i).ptime.equals(mDatas.get(i-1).ptime)) {
                    mSections.add(mDatas.get(i).ptime);
                    mPositions.add(i);
                }
            }
        }
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        if (sectionIndex < 0 || sectionIndex >= mPositions.size()) {
            return -1;
        }
        return mPositions.get(sectionIndex);
    }

    @Override
    public int getSectionForPosition(int position) {
        if (position < 0 || position >= getCount()) {
            return -1;
        }
        int index = Arrays.binarySearch(mPositions.toArray(), position);
        return index >= 0 ? index : -index - 2;
    }

    @Override
    public void convert(int position, AdapterHolder helper, JokeBean.JokeItem item, boolean isScrolling) {
        helper.setText(R.id.latest_list_title,item.htitle);
        helper.setText(R.id.latest_list_time,item.ptime);
        helper.setText(R.id.latest_list_intro,item.intor);

        ImageView img1 = helper.getView(R.id.latest_list_imagec1);
        ImageView img2 = helper.getView(R.id.latest_list_image2);
        ImageView img3 = helper.getView(R.id.latest_list_image3);
        ImageView img4 = helper.getView(R.id.latest_list_image4);

        if(item.image !=null && item.image.size() !=0 ) {
            if(item.image.size() >= 1){
                ImageLoader.getInstance().displayImage(item.image.get(0).purl,img1);
            }

            if(item.image.size() >= 2){
                ImageLoader.getInstance().displayImage(item.image.get(1).purl,img2);
            }

            if(item.image.size() >= 3){
                ImageLoader.getInstance().displayImage(item.image.get(2).purl,img3);
            }

            if(item.image.size() >= 4){
                ImageLoader.getInstance().displayImage(item.image.get(3).purl,img4);
            }
        }
    }
}