package com.oneapp.app.demo.jinritoutiao.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SectionIndexer;
import com.it114.android.oneframework.core.adapter.AdapterHolder;
import com.it114.android.oneframework.core.adapter.CommonAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.oneapp.app.demo.jinritoutiao.R;
import com.oneapp.app.demo.jinritoutiao.bean.NewsItem;
import com.oneapp.app.demo.jinritoutiao.util.DateUtil;
import com.oneapp.app.demo.jinritoutiao.util.RelativeDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by andy on 10/27/2015.
 */
public class NewsAdapter extends CommonAdapter<NewsItem>   implements SectionIndexer {
    /** 弹出的更多选择框  */
    private PopupWindow popupWindow;
    private Activity context;
    private ImageView btn_pop_close;
    private List<Integer> mPositions;
    private List<String> mSections;
    ArrayList<NewsItem> mDatas;
    public NewsAdapter(AbsListView view, Collection<NewsItem> mDatas, Activity context) {
        super(view, mDatas, R.layout.adapter_news_list_item_layout);
        this.context= context;
        this.mDatas = (ArrayList<NewsItem>) mDatas;
        initDateHead();
    }




    private void initDateHead() {
        mSections = new ArrayList<String>();
        mPositions= new ArrayList<Integer>();
        for(int i = 0; i <mDatas.size();i++){
            if(i == 0){
                mSections.add(DateUtil.getSection(String.valueOf(mDatas.get(i).publish_time)));
                mPositions.add(i);
                continue;
            }
            if(i != mDatas.size()){
                if(mDatas.get(i).publish_time==mDatas.get(i - 1).publish_time){
                    mSections.add(DateUtil.getSection(String.valueOf(mDatas.get(i).publish_time)));
                    mPositions.add(i);
                }
            }
        }
    }
    private void initPopWindow() {
        View popView = context.getLayoutInflater().inflate(R.layout.list_item_pop, null);
        popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        //设置popwindow出现和消失动画
        popupWindow.setAnimationStyle(R.style.PopMenuAnimation);
        btn_pop_close = (ImageView) popView.findViewById(R.id.btn_pop_close);
    }

    @Override
    public void convert(int position,AdapterHolder mHolder, NewsItem news, boolean isScrolling) {
        mHolder.setText(R.id.item_title,news.title);
        mHolder.setText(R.id.item_source,news.display_url);
        mHolder.setText(R.id.comment_count,"评论101");
        mHolder.setText(R.id.publish_time, RelativeDateFormat.format(news.publish_time));
        List<String> imgUrlList = news.image_list;

        mHolder.getView(R.id.popicon).setVisibility(View.VISIBLE);
        mHolder.getView(R.id.comment_count).setVisibility(View.VISIBLE);
        mHolder.getView(R.id.right_padding_view).setVisibility(View.VISIBLE);
        if(imgUrlList !=null && imgUrlList.size() !=0){
            if(imgUrlList.size() == 1) {
                mHolder.getView(R.id.item_image_layout).setVisibility(View.GONE);
                //是否是大图
                if(news.getIsLarge()){
//                    mHolder.large_image.setVisibility(View.VISIBLE);
//                    mHolder.right_image.setVisibility(View.GONE);
//                    imageLoader.displayImage(imgUrlList.get(0), mHolder.large_image, options);
//                    mHolder.popicon.setVisibility(View.GONE);
//                    mHolder.comment_count.setVisibility(View.GONE);
//                    mHolder.right_padding_view.setVisibility(View.GONE);
                }else{
                    mHolder.getView(R.id.large_image).setVisibility(View.GONE);
                    mHolder.getView(R.id.right_image).setVisibility(View.VISIBLE);
                    ImageLoader.getInstance().displayImage(imgUrlList.get(0), (ImageView)mHolder.getView(R.id.right_image));
                }
            }else{
                mHolder.getView(R.id.large_image).setVisibility(View.GONE);
                mHolder.getView(R.id.right_image).setVisibility(View.GONE);
                mHolder.getView(R.id.item_image_layout).setVisibility(View.VISIBLE);
                ImageLoader.getInstance().displayImage(imgUrlList.get(0), (ImageView) mHolder.getView(R.id.item_image_0));
                ImageLoader.getInstance().displayImage(imgUrlList.get(1), (ImageView) mHolder.getView(R.id.item_image_1));
                ImageLoader.getInstance().displayImage(imgUrlList.get(2), (ImageView) mHolder.getView(R.id.item_image_2));
            }
        }else{
            mHolder.getView(R.id.right_image).setVisibility(View.GONE);
            mHolder.getView(R.id.item_image_layout).setVisibility(View.GONE);
        }
//        int markResID = getAltMarkResID(news.getMark(),news.getCollectStatus());
//        if(markResID != -1){
//            mHolder.alt_mark.setVisibility(View.VISIBLE);
//            mHolder.alt_mark.setImageResource(markResID);
//        }else{
//            mHolder.alt_mark.setVisibility(View.GONE);
//        }
        //判断该新闻概述是否为空
        if (!TextUtils.isEmpty(news.abstract1)) {
            mHolder.getView(R.id.item_abstract).setVisibility(View.VISIBLE);
            mHolder.setText(R.id.item_abstract,news.abstract1);
        } else {
            mHolder.getView(R.id.item_abstract).setVisibility(View.GONE);
        }
        //判断该新闻是否是特殊标记的，推广等，为空就是新闻
        mHolder.getView(R.id.list_item_local).setVisibility(View.GONE);
//        if(!TextUtils.isEmpty(news.getLocal())){
//            mHolder.list_item_local.setVisibility(View.VISIBLE);
//            mHolder.list_item_local.setText(news.getLocal());
//        }else{
//            mHolder.list_item_local.setVisibility(View.GONE);
//        }
        //判断评论字段是否为空，不为空显示对应布局

        mHolder.getView(R.id.comment_layout).setVisibility(View.GONE);
//        if(!TextUtils.isEmpty(news.getComment())){
//            //news.getLocal() != null &&
//            mHolder.comment_layout.setVisibility(View.VISIBLE);
//            mHolder.comment_content.setText(news.getComment());
//        }else{
//            mHolder.comment_layout.setVisibility(View.GONE);
//        }
        //判断该新闻是否已读
//        if(!news.getReadStatus()){
//            mHolder.item_layout.setSelected(true);
//        }else{
//            mHolder.item_layout.setSelected(false);
//        }
        //设置+按钮点击效果
        mHolder.getView(R.id.popicon).setOnClickListener(new popAction(position));
        //头部的相关东西
        int section = getSectionForPosition(position);
        if (getPositionForSection(section) == position) {
            mHolder.getView(R.id.layout_list_section) .setVisibility(View.VISIBLE);
//			head_title.setText(news.getDate());
            mHolder.setText(R.id.section_text,mSections.get(section));
            mHolder.setText(R.id.section_day, "今天");
        } else {
            mHolder.getView(R.id.layout_list_section) .setVisibility(View.GONE);
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


    /**
     * 显示popWindow
     * */
    public void showPop(View parent, int x, int y,int postion) {
        //设置popwindow显示位置
        popupWindow.showAtLocation(parent, 0, x, y);
        //获取popwindow焦点
        popupWindow.setFocusable(true);
        //设置popwindow如果点击外面区域，便关闭。
        popupWindow.setOutsideTouchable(true);
        popupWindow.update();
        if (popupWindow.isShowing()) {

        }
        btn_pop_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramView) {
                popupWindow.dismiss();
            }
        });
    }

    /**
     * 每个ITEM中more按钮对应的点击动作
     * */
    public class popAction implements View.OnClickListener {
        int position;
        public popAction(int position){
            this.position = position;
        }
        @Override
        public void onClick(View v) {
            int[] arrayOfInt = new int[2];
            //获取点击按钮的坐标
            v.getLocationOnScreen(arrayOfInt);
            int x = arrayOfInt[0];
            int y = arrayOfInt[1];
            showPop(v, x , y, position);
        }
    }
}
