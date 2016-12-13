package com.test.kexiaoderenren.indexerlistview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.kexiaoderenren.indexerlistview.R;
import com.test.kexiaoderenren.indexerlistview.model.CategoryVo;
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

    /*** 记录当前被选中的位置*/
    private int mPositionSelected;
    private View mSelectedView;

    public IndexerAdapter(List<CategoryVo> lists, Context mContext) {
        this.lists = lists;
        this.mContext = mContext;
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
            mSelectedView = holder.itemView;
            mSelectedView.setSelected(true);
        }
    }

    /**
     * 修改每个Item的点击效果
     * @param view
     * @param position
     */
    public void changeCategoryChoice(View view, int position) {
        mSelectedView.setSelected(false);
        mPositionSelected = position;
        mSelectedView = view;
        mSelectedView.setSelected(true);
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
