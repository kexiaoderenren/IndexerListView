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
public class TxtAdapter extends RecyclerView.Adapter<TxtAdapter.TxtHolder> {

    private Context mContext;
    private List<String> lists;

    public TxtAdapter(Context mContext, List<String> lists) {
        this.mContext = mContext;
        this.lists = lists;
    }

    @Override
    public TxtHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TxtHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_item_txt, parent, false));
    }

    @Override
    public void onBindViewHolder(TxtHolder holder, int position) {
        holder.tvTxt.setText(lists.get(position));
    }

    @Override
    public int getItemCount() {
        return (lists == null) ? 0 : lists.size() ;
    }

    public class TxtHolder extends RecyclerView.ViewHolder{

        TextView tvTxt;

        public TxtHolder(View itemView) {
            super(itemView);
            tvTxt = (TextView) itemView.findViewById(R.id.tv_txt);
        }
    }
}

