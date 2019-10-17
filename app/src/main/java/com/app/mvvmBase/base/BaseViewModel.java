package com.app.mvvmBase.base;

import androidx.lifecycle.ViewModel;

import java.lang.ref.WeakReference;

/**
 * This class is base calls for all viewModels
 * this provides callback between viewModel
 * and activity/frgament
 * @param <N> is a callback interface provides
 *
 */
public class BaseViewModel<N> extends ViewModel {

    private WeakReference<N> navigator;

    public N getNavigator() {
        return navigator.get();
    }

    public void setNavigator(N navigator) {
        this.navigator = new WeakReference<>(navigator);
    }
}
