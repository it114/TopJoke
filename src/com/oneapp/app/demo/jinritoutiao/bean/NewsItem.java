package com.oneapp.app.demo.jinritoutiao.bean;

import com.it114.android.oneframework.core.bean.BaseBean;
import java.util.ArrayList;


/**
 * Created by andy on 10/27/2015.
 *
 * {
 "media_name": "深度军事",
 "abstract": "前日有媒体称解放军为什么偏瘦？是应为大块头不适合现代战争，因为其体型太大，从而增加了中弹几率。而且即便格斗，小个子也可以用踢裆战术，打败美军大块头。所以体能和技巧比大块头重要。其实，我们认为，这种说法没有多少道理。解放军新兵体型较弱，是因为人种关系，中国男性18岁时绝大部分都体型",
 "impression_count": 293554,
 "image_list": [
 {
 "url": "http://p2.pstatp.com/list/8860/7548538000"
 },
 {
 "url": "http://p2.pstatp.com/list/8858/8271552928"
 },
 {
 "url": "http://p1.pstatp.com/list/8861/6876053807"
 }
 ],
 "external_visit_count": 321,
 "article_type": 0,
 "more_mode": true,
 "tag": "news_military",
 "is_favorite": 0,
 "has_m3u8_video": 0,
 "keywords": "乌兰巴托,朝鲜,菲律宾,解放军,美军,士兵,莫斯科,轻步兵",
 "has_mp4_video": 0,
 "favorite_count": 101,
 "display_url": "http://toutiao.com/group/6210111381001076994/",
 "article_sub_type": 0,
 "bury_count": 3,
 "title": "媒体称解放军小个子格斗靠踢裆能轻易打败美军大块头：靠谱吗？",
 "has_video": false,
 "share_url": "http://toutiao.com/a6210111381001076994/?iid=7218179523&app=news_article",
 "id": 6210111381001077000,
 "source": "深度军事",
 "comment_count": 56,
 "article_url": "http://toutiao.com/preview_article/?pgc_id=6210118776933433858",
 "create_time": 1445905824,
 "recommend": 0,
 "tips": 0,
 "aggr_type": 1,
 "item_source_url": "/item/6210118776933433858/",
 "media_url": "http://toutiao.com/m4082896223/",
 "display_time": 1445905952,
 "publish_time": 1445905952,
 "go_detail_count": 24816,
 "group_flags": 2,
 "middle_mode": false,
 "display_title": " ",
 "item_seo_url": "/i6210118776933433858/",
 "tag_id": 6210111381001077000,
 "source_url": "/group/6210111381001076994/",
 "large_mode": false,
 "item_id": 6210118776933434000,
 "datetime": "2015-10-27 18:16",
 "is_digg": 0,
 "seo_url": "/i6210118776933433858/",
 "repin_count": 101,
 "url": "http://toutiao.com/preview_article/?pgc_id=6210118776933433858",
 "level": 0,
 "digg_count": 18,
 "behot_time": 1445941000,
 "hot": 0,
 "preload_web": 2,
 "comments_count": 56,
 "has_image": true,
 "is_bury": 0,
 "group_id": 6210111381001077000,
 "middle_image": {
 "url": "http://p2.pstatp.com/list/8860/7548538000",
 "width": 550,
 "url_list": [
 {
 "url": "http://p2.pstatp.com/list/8860/7548538000"
 },
 {
 "url": "http://p4.pstatp.com/list/8860/7548538000"
 },
 {
 "url": "http://p4.pstatp.com/list/8860/7548538000"
 }
 ],
 "uri": "list/8860/7548538000",
 "height": 388
 }
 }


 */
public class NewsItem extends BaseBean {
    private final static String TOUTIAO_HOST = "http://toutiao.com/";
    public String media_name;
    public String tag;
    public String abstract1;
    public String display_url;
    public String keywords;
    public int  is_favorite;
    public int  article_type;
    public int  external_visit_count;
    public int  favorite_count;
    public int  article_sub_type;
    public ArrayList<String> image_list;
    public String title;
    public String share_url;
    public String article_url;
    public String source_url;
    public String datetime;
    public int item_id;
    public long publish_time;

    public String getNewsUrl(){
        return TOUTIAO_HOST+source_url;
    }

    public boolean getIsLarge() {
        return false;
    }

    public NewsList newsList;

}
