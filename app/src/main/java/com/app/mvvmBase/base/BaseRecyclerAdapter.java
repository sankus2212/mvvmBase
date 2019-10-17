package com.app.mvvmBase.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @param <T> databinding object of the item layout
 * @param <V> is the single instance of the dataset object
 *
 */
public abstract class BaseRecyclerAdapter<T extends ViewDataBinding,V extends Object>
        extends RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder> {

    private T mViewDataBinding;

    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * @return Binding Variable
     */
    public abstract int getBindingVariable();

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         mViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),getLayoutId(),parent,false);
        return new BaseViewHolder(mViewDataBinding);
    }

    /**
     * Base ViewHolder Class for all Adapters
     */
    public class BaseViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding mViewDataBinding;
        public BaseViewHolder(@NonNull ViewDataBinding mViewDataBinding) {
            super(mViewDataBinding.getRoot());
            this.mViewDataBinding = mViewDataBinding;
        }

        /**
         * method binds the holder view to data object
         * @param mObject this is the single instance
         *               of the data set
         */
        public void bind(Object mObject){
            mViewDataBinding.setVariable(getBindingVariable(),mObject);
            mViewDataBinding.executePendingBindings();
        }

        /**
         * this methood returns the viewBinding object
         * to access the UI elements
         */
        public ViewDataBinding getViewDataBinding() {
            return mViewDataBinding;
        }


    }
}
