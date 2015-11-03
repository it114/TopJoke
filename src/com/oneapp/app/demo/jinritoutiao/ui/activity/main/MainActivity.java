package com.oneapp.app.demo.jinritoutiao.ui.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.Bind;
import butterknife.OnClick;
import com.it114.android.oneframework.core.ui.activity.BaseFragmentActivity;
import com.it114.android.oneframework.core.util.UiUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.oneapp.app.demo.jinritoutiao.R;
import com.oneapp.app.demo.jinritoutiao.adapter.NewsFragmentPagerAdapter;
import com.oneapp.app.demo.jinritoutiao.bean.ChannelItem;
import com.oneapp.app.demo.jinritoutiao.ui.activity.ChannelActivity;
import com.oneapp.app.demo.jinritoutiao.ui.fragment.joke.NewsFragment;
import com.oneapp.app.demo.jinritoutiao.view.ColumnHorizontalScrollView;
import com.oneapp.app.demo.jinritoutiao.view.DrawerView;

import java.util.ArrayList;

/**
 * Created by andy on 10/26/2015.
 */
public class MainActivity extends BaseFragmentActivity  implements MainView{

    /** 自定义HorizontalScrollView */
    @Bind(R.id.mColumnHorizontalScrollView) ColumnHorizontalScrollView mColumnHorizontalScrollView;
    @Bind(R.id.mRadioGroup_content)  LinearLayout mRadioGroup_content;//显示顶部滚动内容的容器
    @Bind(R.id.ll_more_columns)  LinearLayout ll_more_columns;//添加更多频道
    @Bind(R.id.rl_column)  RelativeLayout rl_column;//顶部可滚动容器
    @Bind(R.id.mViewPager)  ViewPager mViewPager;
    @Bind(R.id.button_more_columns)  ImageView button_more_columns;//添加频道按钮
    /** head 头部 的中间的loading*/
    @Bind(R.id.top_progress) ProgressBar top_progress;
    /** head 头部 中间的刷新按钮*/
    @Bind(R.id.top_refresh) ImageView top_refresh;
    SlidingMenu side_drawer;
    /** 头部频道可滑动的左阴影部分*/
    @Bind(R.id.shade_left)  ImageView shade_left;
    /** 头部频道可滑动的右阴影部分 */
    @Bind(R.id.shade_right)  ImageView shade_right;
    /** 用户选择的新闻分类列表*/
    //private ArrayList<ChannelItem> userChannelList=new ArrayList<ChannelItem>();
    /** 当前选中的栏目*/
    private int columnSelectIndex = 0;
    /** 屏幕宽度 */
    private int mScreenWidth = 0;
    /** Item宽度 */
    private int mItemWidth = 0;
    private ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    /** 请求CODE */
    public final static int CHANNELREQUEST = 1;
    /** 调整返回的RESULTCODE */
    public final static int CHANNELRESULT = 10;
    private long mExitTime;

    @Override
    protected void init(Bundle savedInstanceState) {
        mScreenWidth = UiUtil.getWindowsWidth(this);
        mItemWidth = mScreenWidth / 7;// 一个Item宽度为屏幕的1/7
        initSlidingMenu();

        MainPresenter mainPresenter = new MainPresenterImpl(this,this);
        mainPresenter.initChannelAndFragment();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_layout;
    }

    @OnClick(R.id.button_more_columns)
    public  void choinceMoreChannel(){
        Intent intent_channel = new  Intent(getApplicationContext(), ChannelActivity.class);
        startActivityForResult(intent_channel, CHANNELREQUEST);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @OnClick(R.id.top_more)
    public void showRightOrLeftPanel(){
        if(side_drawer.isSecondaryMenuShowing()){
            side_drawer.showContent();
        }else{
            side_drawer.showSecondaryMenu();
        }
    }

    @OnClick({R.id.top_head})
    public void onUserHeadClick(){
        if(side_drawer.isMenuShowing()){
            side_drawer.showContent();
        }else{
            side_drawer.showMenu();
        }
    }

    protected void initSlidingMenu() {
        side_drawer = new DrawerView(this).initSlidingMenu();
    }

    /**
     *  ViewPager切换监听方法
     * */
    public ViewPager.OnPageChangeListener pageListener= new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int position) {
            // TODO Auto-generated method stub
            mViewPager.setCurrentItem(position);
            selectTab(position);
        }
    };

    /**
     *  选择的Column里面的Tab
     * */
    private void selectTab(int tab_postion) {
        columnSelectIndex = tab_postion;
        for (int i = 0; i < mRadioGroup_content.getChildCount(); i++) {
            View checkView = mRadioGroup_content.getChildAt(tab_postion);
            int k = checkView.getMeasuredWidth();
            int l = checkView.getLeft();
            int i2 = l + k / 2 - mScreenWidth / 2;
            // rg_nav_content.getParent()).smoothScrollTo(i2, 0);
            mColumnHorizontalScrollView.smoothScrollTo(i2, 0);
            // mColumnHorizontalScrollView.smoothScrollTo((position - 2) *
            // mItemWidth , 0);
        }
        //判断是否选中
        for (int j = 0; j <  mRadioGroup_content.getChildCount(); j++) {
            View checkView = mRadioGroup_content.getChildAt(j);
            boolean ischeck;
            if (j == tab_postion) {
                ischeck = true;
            } else {
                ischeck = false;
            }
            checkView.setSelected(ischeck);
        }
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(side_drawer.isMenuShowing() ||side_drawer.isSecondaryMenuShowing()){
                side_drawer.showContent();
            }else {
                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                    Toast.makeText(this, "在按一次退出",
                            Toast.LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();
                } else {
                    finish();
                }
            }
            return true;
        }
        //拦截MENU按钮点击事件，让他无任何操作
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void initTopChannelBar(final ArrayList<ChannelItem> channelItems) {
        mRadioGroup_content.removeAllViews();
        int count =  channelItems.size();
        mColumnHorizontalScrollView.setParam(this, mScreenWidth, mRadioGroup_content, shade_left, shade_right, ll_more_columns, rl_column);
        for(int i = 0; i< count; i++){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mItemWidth , ViewGroup.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 5;
            params.rightMargin = 5;
//			TextView localTextView = (TextView) mInflater.inflate(R.layout.column_radio_item, null);
            TextView columnTextView = new TextView(this);
            columnTextView.setTextAppearance(this, R.style.top_category_scroll_view_item_text);
//			localTextView.setBackground(getResources().getDrawable(R.drawable.top_category_scroll_text_view_bg));
            columnTextView.setBackgroundResource(R.drawable.radio_button_bg);
            columnTextView.setGravity(Gravity.CENTER);
            columnTextView.setPadding(5, 5, 5, 5);
            columnTextView.setId(i);
            columnTextView.setText(channelItems.get(i).name);
            columnTextView.setTextColor(getResources().getColorStateList(R.color.top_category_scroll_text_color_day));
            if(columnSelectIndex == i){
                columnTextView.setSelected(true);
            }
            columnTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i = 0;i < mRadioGroup_content.getChildCount();i++){
                        View localView = mRadioGroup_content.getChildAt(i);
                        if (localView != v)
                            localView.setSelected(false);
                        else{
                            localView.setSelected(true);
                            mViewPager.setCurrentItem(i);
                        }
                    }
                    Toast.makeText(getApplicationContext(), channelItems.get(v.getId()).category, Toast.LENGTH_SHORT).show();
                }
            });
            mRadioGroup_content.addView(columnTextView, i ,params);
        }
    }

    @Override
    public void initFragment(ArrayList<ChannelItem> channelItems) {
        fragments.clear();//清空
        int count =  channelItems.size();
        for(int i = 0; i< count;i++) {
            Bundle data = new Bundle();
            data.putString("text", channelItems.get(i).name);
            data.putInt("id", channelItems.get(i).id);
            data.putString("category", channelItems.get(i).category);
            NewsFragment newfragment = new NewsFragment();
            newfragment.setArguments(data);
            fragments.add(newfragment);
        }
        NewsFragmentPagerAdapter mAdapetr = new NewsFragmentPagerAdapter(getSupportFragmentManager(), fragments);
//		mViewPager.setOffscreenPageLimit(0);
        mViewPager.setAdapter(mAdapetr);
        mViewPager.setOnPageChangeListener(pageListener);
    }
}
