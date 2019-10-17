package com.app.mvvmBase.ui.walkThrough;

import androidx.lifecycle.ViewModelProviders;

import com.app.mvvmBase.BR;
import com.app.mvvmBase.R;
import com.app.mvvmBase.base.BaseFragment;
import com.app.mvvmBase.databinding.WalkThroughFragmentBinding;


public class WalkThroughFragment extends BaseFragment<WalkThroughFragmentBinding,WalkThroughViewModel> {


    @Override
    public int getLayoutId() {
        return R.layout.walk_through_fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public WalkThroughViewModel getViewModel() {
        return ViewModelProviders.of(this).get(WalkThroughViewModel.class);
    }



}
