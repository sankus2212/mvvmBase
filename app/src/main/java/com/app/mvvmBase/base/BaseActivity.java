package com.app.mvvmBase.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Base Activity for easy implementation of
 * Data binding and MVVM
 * @param <T> Databinding object of the activity
 * @param <V> ViewModel object #must extend the BaseView Model
 */

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    private T mViewDataBinding;
    private V mViewModel;


    /**
     * Override to set Layout Resourse id
     * @return layout Id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

        public abstract int getBindingVariable();
    /**
     * Override to set view model
     * @return view model instance
     */
    public abstract V getViewModel();

    /**
     * Override to set DataBindind
     * @return DataBinding instance
     */
    public T getViewDataBinding(){
        return mViewDataBinding;
    }

    /**
     * override for initial setting
     */
    public abstract void setUpView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDatabinding();
        setUpView();
    }


    /**
     * method to perform the data binding
     * and set the view model variable
     */
    private void performDatabinding(){
        mViewDataBinding = DataBindingUtil.setContentView(this,getLayoutId());
        this.mViewModel = mViewModel==null?getViewModel():mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(),mViewModel);
        mViewDataBinding.setLifecycleOwner(this);
        mViewDataBinding.executePendingBindings();
    }
}
