package com.oneapp.app.demo.jinritoutiao.bean;

import java.util.ArrayList;

/**
 * Created by andy on 10/29/2015.
 *
 * body": {
 "rcount": 788,
 "pagecount": 40,
 "pagesize": 20,
 "pageindex": 1,
 "items": [
 {
 "hid": 1385122,
 "htitle": "看背影就知道是萌妹子",
 "rcount": 12,
 "dcount": 35,
 "ptime": "2015/10/29 8:00:32",
 "pusername": "我是专门来逗你们笑的",
 "ispic": 1,
 "intor": "",
 "image": [
 {
 "purl": "http://img5.pengfu.cn/middle/241/895241.jpg",
 "ptitle": ""
 }
 ]
 },
 */
public class JokeBean extends BaseJoke {
  public   MixedJokeBody body;
  public class MixedJokeBody {
    public int rcount;
    public int pagecount;
    public int pagesize;
    public int pageindex;
    public ArrayList<JokeItem> items;
  }


    public class JokeItem {
        public  int hid;
        public String  htitle;
        public String rcount;
        public String dcount;
        public String ptime;
        public String pusername;
        public String ispic;
        public String intor;
        public ArrayList<JokeImage> image;

        /**
         {
         "purl": "http://img5.pengfu.cn/middle/241/895241.jpg",
         "ptitle": ""
         }
         */
        public  class JokeImage {
            public String purl;
            public String ptitle;
        }
    }




}
