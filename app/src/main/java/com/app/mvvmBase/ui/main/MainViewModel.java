package com.app.mvvmBase.ui.main;


import android.view.View;
import android.widget.Toast;

import com.app.mvvmBase.base.BaseViewModel;

public class MainViewModel extends BaseViewModel {

    public void openCamera(View view) {
        Toast.makeText(view.getContext(), "Working", Toast.LENGTH_SHORT).show();
    }

}
