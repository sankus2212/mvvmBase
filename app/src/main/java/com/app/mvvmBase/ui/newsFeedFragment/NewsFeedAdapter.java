package com.app.mvvmBase.ui.newsFeedFragment;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.app.mvvmBase.BR;
import com.app.mvvmBase.R;
import com.app.mvvmBase.base.BaseRecyclerAdapter;
import com.app.mvvmBase.databinding.ItemRecyclerBinding;


import java.util.List;

public class NewsFeedAdapter extends BaseRecyclerAdapter<ItemRecyclerBinding,NewsFeedModel> {

    private RecyclerViewClickListener listener;
    private List<NewsFeedModel> list;
    private ItemRecyclerBinding dataBinding;
    private Context context;

    public NewsFeedAdapter(RecyclerViewClickListener listener, List<NewsFeedModel> list,
                           Context context) {
        this.listener = listener;
        this.list = list;
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_recycler;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerAdapter.BaseViewHolder holder, int position) {
        holder.bind(list.get(position));
        dataBinding = (ItemRecyclerBinding) holder.getViewDataBinding();
        dataBinding.tvName.setOnClickListener(v-> Toast.makeText(context, "Working : "+(position+1), Toast.LENGTH_SHORT).show());
        listener.onItemClick(dataBinding.tvName,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
