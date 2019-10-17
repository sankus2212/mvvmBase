package com.app.mvvmBase.ui.newsFeedFragment;

import androidx.lifecycle.MutableLiveData;

import com.app.mvvmBase.base.BaseViewModel;

public class NewsFeedViewModel extends BaseViewModel<NewsFeedNavigator> {

    public MutableLiveData<String> name = new MutableLiveData<>();

}
