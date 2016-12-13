package com.test.kexiaoderenren.indexerlistview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.kexiaoderenren.indexerlistview.R;
import com.test.kexiaoderenren.indexerlistview.model.CategoryItemVo;

import java.util.List;

/**
 * 右侧recyclerview列表适配器
 * Created by kexiaoderenren on 2016/12/13.
 */
public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CategoryItemVo> lists;
    private Context mContext;

    public CategoryAdapter(List<CategoryItemVo> lists, Context mContext) {
        this.lists = lists;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IndexerHolder(LayoutInflater.from(mContext).inflate(R.layout.view_textview, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((IndexerHolder)holder).textView.setText(lists.get(position).getCat_name());
    }

    @Override
    public int getItemCount() {
        return (lists == null) ? 0 : lists.size();
    }

    public class IndexerHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public IndexerHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_text);

        }
    }
}
