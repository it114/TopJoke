package com.oneapp.app.demo.jinritoutiao.api;

import com.it114.android.oneframework.core.data.Config;
import com.it114.android.oneframework.core.http.HttpRequestHandler;

import com.it114.android.oneframework.core.http.RequestManager;
import com.loopj.android.http.RequestParams;
import com.oneapp.app.demo.jinritoutiao.bean.NewsItem;

import java.util.HashMap;

/**
 * Created by andy on 10/27/2015.
 */
public class JokeApi    {

    private final static int DEFAULT_CACHE_TIME = 60;
    static {
        Config.API_HOST_RELEASE = "http://pengfu.junpinzhi.cn/mobileClientV21.ashx";
        Config.API_HOST_DEBUG = "http://pengfu.junpinzhi.cn/mobileClientV21.ashx";
        Config.debug = true;
        HashMap<String,String> params = new HashMap<>();
        params.put("client","android");
        params.put("version","14");
        RequestManager.initCommonParams(params);
    }

    private static String getUrl(String uri){
        return RequestManager.makeUrl(uri);
    }

    /**
     * GET http://pengfu.junpinzhi.cn/mobileClientV21.ashx?client=android&version=14&key=111&PageIndex=1 HTTP/1.1
     */
    public static void getPicTextJoke(int page,HttpRequestHandler handler){
        RequestParams params = RequestManager.getRequestParams();
        params.put("key","111");
        params.put("PageIndex",page);
        RequestManager.getInstance().getHttpImpl().get(true,DEFAULT_CACHE_TIME,getUrl(""),params,handler);
    }

    /**
     * GET http://pengfu.junpinzhi.cn/mobileClientV21.ashx?client=android&version=14&key=112&PageIndex=1 HTTP/1.1
     */
    public void getTextJoke(int page,HttpRequestHandler handler){
        RequestParams params = RequestManager.getRequestParams();
        params.put("key","112");
        params.put("PageIndex",page);
        RequestManager.getInstance().getHttpImpl().get(true,DEFAULT_CACHE_TIME,getUrl(""),params,handler);
    }

    /**
    GET http://pengfu.junpinzhi.cn/mobileClientV21.ashx?client=android&version=14&key=113&PageIndex=1 HTTP/1.1
     */
    public void getPicJoke(int page,HttpRequestHandler handler){
        RequestParams params = RequestManager.getRequestParams();
        params.put("key","113");
        params.put("PageIndex",page);
        RequestManager.getInstance().getHttpImpl().get(true,DEFAULT_CACHE_TIME,getUrl(""),params,handler);
    }





}
