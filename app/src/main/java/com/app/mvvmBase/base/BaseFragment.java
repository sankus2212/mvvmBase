package com.app.mvvmBase.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;



/**
 * Base Fragment for easy implementation of
 * Data binding and MVVM
 * @param <T> Databinding object of the fragment
 * @param <V> ViewModel object #must extend the BaseView Model
 */
public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {

    private T mViewDataBinding;
    private V mViewModel;


    /**
     * Override to set Layout Resourse id
     *
     * @return layout Id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    public abstract int getBindingVariable();

    /**
     * Override to set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

    /**
     * Override to set DataBindind
     *
     * @return DataBinding instance
     */
    public T getViewDataBinding() {
        return mViewDataBinding;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        performBinding();
        return mViewDataBinding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * method to perform the data binding
     * and set the view model variable
     */
    private void performBinding() {
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.setLifecycleOwner(this);
        mViewDataBinding.executePendingBindings();
    }
}
