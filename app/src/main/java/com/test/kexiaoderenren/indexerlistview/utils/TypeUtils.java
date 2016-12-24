package com.test.kexiaoderenren.indexerlistview.utils;

import android.content.Context;

/**
 * Created by kexiaoderenren on 2016/12/23.
 */
public class TypeUtils {


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
