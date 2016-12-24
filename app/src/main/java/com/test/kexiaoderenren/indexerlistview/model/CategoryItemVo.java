package com.test.kexiaoderenren.indexerlistview.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kexiaoderenren on 2016/12/13.
 */
public class CategoryItemVo implements Serializable{

    /**
     * 图片广告位展位
     */
    public static final int VIEW_TYPE_IMAGE_ADS = 0;

    /**
     * 图文魂牌展位
     */
    public static final int VIEW_TYPE_IMAGE_AND_TXT = 1;

    /**
     * 文字展位
     */
    public static final int VIEW_TYPE_TXT = 2;

    /**
     * 布局类型
     */
    public int viewType;

    /**
     * 商品展示
     */
    public List<String> lists;

}
