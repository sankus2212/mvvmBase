package com.app.mvvmBase.ui.newsFeedFragment;

import android.content.Context;

import com.app.mvvmBase.databinding.NewsFeedFragmentBinding;


public interface NewsFeedNavigator {
        Context getAcitivityContext();
        NewsFeedFragmentBinding getBinding();
}
