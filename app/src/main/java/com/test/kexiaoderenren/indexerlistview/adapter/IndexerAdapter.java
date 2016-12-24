package com.test.kexiaoderenren.indexerlistview.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.test.kexiaoderenren.indexerlistview.R;
import com.test.kexiaoderenren.indexerlistview.model.CategoryVo;
import com.test.kexiaoderenren.indexerlistview.utils.ImageLoaderUtils;
import com.test.kexiaoderenren.indexerlistview.widget.IRecyclerItemClickListener;

import java.util.List;

/**
 * 索引列表适配器
 * Created by kexiaoderenren on 2016/12/13.
 */
public class IndexerAdapter extends RecyclerView.Adapter<IndexerAdapter.IndexerHolder> {

    private List<CategoryVo> lists;
    private Context mContext;
    private IRecyclerItemClickListener itemClickListener;
    private Drawable drawableLeft;

    /*** 记录当前被选中的位置*/
    private int mPositionSelected;
    private TextView mSelectedView;

    public IndexerAdapter(List<CategoryVo> lists, Context mContext) {
        this.lists = lists;
        this.mContext = mContext;
        drawableLeft = ContextCompat.getDrawable(this.mContext,R.mipmap.icon_vertical_red);
        drawableLeft.setBounds(0, 0, drawableLeft.getMinimumWidth(), drawableLeft.getMinimumHeight());
    }

    @Override
    public IndexerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IndexerHolder(LayoutInflater.from(mContext).inflate(R.layout.view_textview, parent, false));
    }

    @Override
    public void onBindViewHolder(IndexerHolder holder, int position) {
        if ((lists.get(position) != null) && (lists.get(position).getCat_name() != null)) {
            holder.textView.setText(lists.get(position).getCat_name());
        } else {
            holder.textView.setText("");
        }
        if (mSelectedView == null && position==0){  //默认选中第一个
            mPositionSelected = 0;
            mSelectedView = (TextView) holder.itemView;
            mSelectedView.setSelected(true);
            mSelectedView.setCompoundDrawables(drawableLeft, null, null, null);
        }
    }

    /**
     * 修改每个Item的点击效果
     * @param view
     * @param position
     */
    public void changeCategoryChoice(View view, int position) {
        mSelectedView.setSelected(false);
        mSelectedView.setCompoundDrawables(null, null, null, null);

        mPositionSelected = position;
        mSelectedView = (TextView) view;
        mSelectedView.setSelected(true);
        mSelectedView.setCompoundDrawables(drawableLeft, null, null, null);

    }

    @Override
    public int getItemCount() {
        return (lists == null) ? 0 : lists.size();
    }

    /**
     * 设置recyclerView item 点击事件
     * @param itemClickListener
     */
    public void setItemClickListener(IRecyclerItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public class IndexerHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public IndexerHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.tv_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClickListener(getAdapterPosition(), v);
                    }
                }
            });
        }
    }
}
