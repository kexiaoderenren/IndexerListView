package com.test.kexiaoderenren.indexerlistview.model;

import java.io.Serializable;

/**
 * Created by kexiaoderenren on 2016/12/13.
 */
public class CategoryItemVo implements Serializable{


    /**
     * id : 370
     * cat_name : 酒杯
     * cat_img : http://image13.wine9.com/activity/2015/07/app/5/5-1.jpg
     * img : http://image13.wine9.com/activity/2015/08/app1/5/5-1.jpg
     */

    private String id;
    private String cat_name;
    private String cat_img;
    private String img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_img() {
        return cat_img;
    }

    public void setCat_img(String cat_img) {
        this.cat_img = cat_img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "CategoryItemVo{" +
                "id='" + id + '\'' +
                ", cat_name='" + cat_name + '\'' +
                ", cat_img='" + cat_img + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
