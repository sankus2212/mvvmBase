package com.app.mvvmBase.ui.walkThrough;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;

import com.app.mvvmBase.R;
import com.app.mvvmBase.base.BaseViewModel;

public class WalkThroughViewModel extends BaseViewModel {

    public MutableLiveData<String> name = new MutableLiveData<>();

    public void openNewsFeedViewFragment(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("name", name.getValue());
        Navigation.findNavController(view).navigate(R.id.newsFeedFragment, bundle);
    }

}
