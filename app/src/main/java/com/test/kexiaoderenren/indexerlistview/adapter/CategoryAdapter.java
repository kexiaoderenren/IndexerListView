



package com.test.kexiaoderenren.indexerlistview.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.kexiaoderenren.indexerlistview.R;
import com.test.kexiaoderenren.indexerlistview.model.CategoryItemVo;
import com.test.kexiaoderenren.indexerlistview.utils.Constants;
import com.test.kexiaoderenren.indexerlistview.utils.ImageLoaderUtils;
import com.test.kexiaoderenren.indexerlistview.utils.TypeUtils;
import com.test.kexiaoderenren.indexerlistview.widget.IRecyclerItemClickListener;

import java.util.List;

/**
 * 右侧recyclerview列表适配器
 * Created by kexiaoderenren on 2016/12/13.
 */
public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CategoryItemVo> lists;
    private Context mContext;
    private IRecyclerItemClickListener itemClickListener;
    private LayoutInflater inflater;

    public CategoryAdapter(List<CategoryItemVo> lists, Context mContext) {
        this.lists = lists;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case CategoryItemVo.VIEW_TYPE_IMAGE_ADS:
                holder = new ImgHolder(inflater.inflate(R.layout.adapter_item_img, parent, false));
                break;
            case CategoryItemVo.VIEW_TYPE_IMAGE_AND_TXT:
                holder = new CategoryItemHolder(inflater.inflate(R.layout.adapter_item_catorydetail, parent, false));
                break;
            case CategoryItemVo.VIEW_TYPE_TXT:
                holder = new CategoryItemHolder(inflater.inflate(R.layout.adapter_item_catorydetail, parent, false));
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (lists.get(position).viewType) {
            case CategoryItemVo.VIEW_TYPE_IMAGE_ADS:
                ImageLoaderUtils.loadImg(mContext, Constants.TEST_URL, ((ImgHolder)holder).imgAds);

                break;
            case CategoryItemVo.VIEW_TYPE_IMAGE_AND_TXT:
                CategoryItemHolder imgTxtHolder = (CategoryItemHolder) holder;

                ViewGroup.LayoutParams layoutParams = imgTxtHolder.itemView.getLayoutParams();
                int totalNum = lists.get(position).lists.size();
                int rowsNum = (totalNum % 3 == 0) ? totalNum/3 : totalNum/3 +1;
                //分类高度+分类边距+ 下边距 + item行数 * 行高 = 48+114*行数
                layoutParams.height = rowsNum * TypeUtils.dip2px(mContext, 114) + TypeUtils.dip2px(mContext, 48);  //每行100dp,加上分类、边距48
                imgTxtHolder.itemView.setLayoutParams(layoutParams);
                imgTxtHolder.recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
                imgTxtHolder.recyclerView.setAdapter(new ImgTxtAdapter(mContext, lists.get(position).lists));

                break;
            case CategoryItemVo.VIEW_TYPE_TXT:
                CategoryItemHolder txtHolder = (CategoryItemHolder) holder;

                ViewGroup.LayoutParams txtParams = txtHolder.itemView.getLayoutParams();
                int totalNum2 = lists.get(position).lists.size();
                int rowsNum2 = (totalNum2 % 3 == 0) ? totalNum2/3 : totalNum2/3 +1;
                //分类高度+分类边距+ 下边距 + item行数 * 行高 = 48+30*行数
                txtParams.height = rowsNum2 * TypeUtils.dip2px(mContext, 30) + TypeUtils.dip2px(mContext, 48);
                txtHolder.itemView.setLayoutParams(txtParams);
                txtHolder.recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
                txtHolder.recyclerView.setAdapter(new TxtAdapter(mContext, lists.get(position).lists));
                break;
        }
    }

    public void setItemClickListener(IRecyclerItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return lists.get(position).viewType;
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ImgHolder extends RecyclerView.ViewHolder {

        ImageView imgAds;

        public ImgHolder(View itemView) {
            super(itemView);
            imgAds = (ImageView) itemView.findViewById(R.id.img_ads);
            imgAds.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) { itemClickListener.onItemClickListener(getAdapterPosition(), v); }
                }
            });
        }
    }

    public class CategoryItemHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView textView;

        public CategoryItemHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerview);
            textView = (TextView) itemView.findViewById(R.id.tv_category_name);
        }
    }
}
