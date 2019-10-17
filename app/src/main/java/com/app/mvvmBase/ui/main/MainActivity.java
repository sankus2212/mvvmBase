package com.app.mvvmBase.ui.main;

import android.view.View;

import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.app.mvvmBase.R;
import com.app.mvvmBase.base.BaseActivity;

import com.app.mvvmBase.BR;
import com.app.mvvmBase.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>
implements MainNavigator{

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public MainViewModel getViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public void setUpView() {
        Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.newsFeedFragment);
    }

    @Override
    public void openCamera(View view) {
        //todo write code to open camera
    }
}
