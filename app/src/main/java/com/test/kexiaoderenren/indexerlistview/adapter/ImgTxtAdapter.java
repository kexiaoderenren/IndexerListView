package com.test.kexiaoderenren.indexerlistview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.kexiaoderenren.indexerlistview.R;
import com.test.kexiaoderenren.indexerlistview.utils.Constants;
import com.test.kexiaoderenren.indexerlistview.utils.ImageLoaderUtils;

import java.util.List;

/**
 * Created by kexiaoderenren on 2016/12/23.
 */
public class ImgTxtAdapter extends RecyclerView.Adapter<ImgTxtAdapter.ImgTxtHolder> {

    private Context mContext;
    private List<String> lists;

    public ImgTxtAdapter(Context mContext, List<String> lists) {
        this.mContext = mContext;
        this.lists = lists;
    }

    @Override
    public ImgTxtHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImgTxtHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_item_imgs_txt, parent, false));
    }

    @Override
    public void onBindViewHolder(ImgTxtHolder holder, int position) {
        ImageLoaderUtils.loadImg(mContext, Constants.TEST_URL2, holder.imgGoods);
    }

    @Override
    public int getItemCount() {
        return (lists == null) ? 0 : lists.size() ;
    }

    public class ImgTxtHolder extends RecyclerView.ViewHolder{

        ImageView imgGoods;
        TextView tvGoods;

        public ImgTxtHolder(View itemView) {
            super(itemView);
            imgGoods = (ImageView) itemView.findViewById(R.id.img_goods);
            tvGoods = (TextView) itemView.findViewById(R.id.tv_goods);

        }
    }
}
