package com.oneapp.app.demo.jinritoutiao.bean;

import com.it114.android.oneframework.core.bean.BaseBean;


/**
 * Created by andy on 10/26/2015.
 */
public class ChannelItem  extends BaseBean {

    /**
     *
     */
    private static final long serialVersionUID = -6465237897027410019L;
    /**
     * 栏目对应ID
     *  */
    public Integer id;
    /**
     * 栏目对应NAME
     *  */
    public String name;
    /**
     * 栏目在整体中的排序顺序  rank
     *  */
    public Integer orderId;
    /**
     * 栏目是否选中
     *  */
    public Integer selected;
    public String category;//栏目类别

    public ChannelItem() {
    }

    public ChannelItem(int id, String name, int orderId,int selected,String category) {
        this.id = Integer.valueOf(id);
        this.name = name;
        this.orderId = Integer.valueOf(orderId);
        this.selected = Integer.valueOf(selected);
        this.category = category;
    }


    public String toString() {
        return "ChannelItem [id=" + this.id + ", name=" + this.name
                + ", selected=" + this.selected + ",this.category="+this.category+"]";
    }
}
