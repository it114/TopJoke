package com.oneapp.app.demo.jinritoutiao.ui.activity.main;

import android.content.Context;
import com.oneapp.app.demo.jinritoutiao.R;
import com.oneapp.app.demo.jinritoutiao.bean.ChannelItem;

import java.nio.channels.Channel;
import java.util.ArrayList;

/**
 * Created by andy on 10/27/2015.
 */
public class MainPresenterImpl extends MainPresenter {

    private ArrayList<ChannelItem> userChannelList = null;
    private MainView mainView;
    private Context context;
    public MainPresenterImpl(MainView mainView,Context context){
        this.mainView = mainView;
        this.context = context;
    }

    @Override
    public void initChannelAndFragment() {
        super.initChannelAndFragment();
        if(userChannelList == null || userChannelList.size() == 0) {
            userChannelList = new ArrayList<ChannelItem>();
            String customChannel[] = context.getResources().getStringArray(R.array.user_channel_data);
            for (int i = 0; i < customChannel.length; i++) {
                String item = customChannel[i];
                String item_arr[] = item.split("=");
                ChannelItem channelItem = new ChannelItem(i, item_arr[0], i, i, item_arr[1]);
                userChannelList.add(channelItem);
            }
        }
        mainView.initFragment(this.userChannelList);
        mainView.initTopChannelBar(this.userChannelList);
    }

}
