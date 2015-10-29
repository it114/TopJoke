package com.oneapp.app.demo.jinritoutiao.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by andy on 10/27/2015.
 */
public class DateUtil {

    /*
 * 将时间戳转为字符串 ，格式：yyyy.MM.dd  星期几
 */
    public static String getSection(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd  EEEE");
//		对于创建SimpleDateFormat传入的参数：EEEE代表星期，如“星期四”；MMMM代表中文月份，如“十一月”；MM代表月份，如“11”；
//		yyyy代表年份，如“2010”；dd代表天，如“25”
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

}
