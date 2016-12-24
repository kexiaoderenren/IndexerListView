package com.test.kexiaoderenren.indexerlistview.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by kexiaoderenren on 2016/12/23.
 */
public class ImageLoaderUtils {

    public static void loadImg(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(imageView);
    }

    public static void loadDrawableImg(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .centerCrop()
                .into(imageView);
    }
}
