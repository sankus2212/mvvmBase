package com.app.mvvmBase.ui.newsFeedFragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsFeedModel extends ViewModel {
    public MutableLiveData<String> name = new MutableLiveData<>();

}
