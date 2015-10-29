package com.oneapp.app.demo.jinritoutiao.ui.activity.main;

import com.oneapp.app.demo.jinritoutiao.bean.ChannelItem;

import java.util.ArrayList;

/**
 * Created by andy on 10/27/2015.
 */
public interface MainView {

    public void initTopChannelBar(ArrayList<ChannelItem> channelItems);

    public void initFragment(ArrayList<ChannelItem> channelItems);

}
