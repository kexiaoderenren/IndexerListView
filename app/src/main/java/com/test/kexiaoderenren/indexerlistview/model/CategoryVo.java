package com.test.kexiaoderenren.indexerlistview.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kexiaoderenren on 2016/12/13.
 */
public class CategoryVo implements Serializable {


    /**
     * cat_id : 0
     * cat_name : 一键选酒
     * cat_type : tag
     * cat_list : [{"id":47,"cat_name":"新人推荐","cat_img":"","img":"http://image13.wine9.com/activity/2016/01/fl/1-0000.jpg"},{"id":74,"cat_name":"送礼精选","cat_img":"","img":"http://image13.wine9.com/activity/2015/08/app1/1/1-1.jpg"},{"id":66,"cat_name":"品牌专区","cat_img":"","img":"http://image13.wine9.com/activity/2015/08/app1/1/1-10.jpg"},{"id":113,"cat_name":"中级酒庄","cat_img":"","img":"http://image13.wine9.com/activity/2016/01/fl/1-00000.jpg"},{"id":71,"cat_name":"名庄专区","cat_img":"","img":"http://image13.wine9.com/activity/2015/08/app1/1/1-9.jpg"},{"id":20,"cat_name":"女士专区","cat_img":"","img":"http://image13.wine9.com/activity/2015/08/app1/1/1-6.jpg"},{"id":34,"cat_name":"整箱聚会","cat_img":"","img":"http://image13.wine9.com/activity/2015/08/app1/1/1-4.jpg"},{"id":39,"cat_name":"婚庆用酒","cat_img":"","img":"http://image13.wine9.com/activity/2015/08/app1/1/1-3.jpg"}]
     * prom_list : []
     */

    private String cat_id;
    private String cat_name;
    private String cat_type;
    private List<CategoryItemVo> cat_list;
    private List<?> prom_list;

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_type() {
        return cat_type;
    }

    public void setCat_type(String cat_type) {
        this.cat_type = cat_type;
    }

    public List<CategoryItemVo> getCat_list() {
        return cat_list;
    }

    public void setCat_list(List<CategoryItemVo> cat_list) {
        this.cat_list = cat_list;
    }

    public List<?> getProm_list() {
        return prom_list;
    }

    public void setProm_list(List<?> prom_list) {
        this.prom_list = prom_list;
    }

    @Override
    public String toString() {
        return "CategoryVo{" +
                "cat_id='" + cat_id + '\'' +
                ", cat_name='" + cat_name + '\'' +
                ", cat_type='" + cat_type + '\'' +
                ", cat_list=" + cat_list +
                ", prom_list=" + prom_list +
                '}';
    }
}
