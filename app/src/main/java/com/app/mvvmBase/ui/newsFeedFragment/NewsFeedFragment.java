package com.app.mvvmBase.ui.newsFeedFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.app.mvvmBase.R;
import com.app.mvvmBase.base.BaseFragment;

import com.app.mvvmBase.databinding.NewsFeedFragmentBinding;
import com.app.mvvmBase.local.AppDatabase;
import com.app.mvvmBase.local.dao.AppDbHelper;
import com.app.mvvmBase.local.dao.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class    NewsFeedFragment extends BaseFragment<NewsFeedFragmentBinding, NewsFeedViewModel>
        implements NewsFeedNavigator,RecyclerViewClickListener {
    private CompositeDisposable compositeDisposable;
    private static final String TAG = "NewsFeedFragment";
    private AppDbHelper appDbHelper;
    private NewsFeedViewModel mViewModel;
    private PictureViewModel pictureViewModel;
    private Context context;
    private NewsFeedFragmentBinding binding;
    List<NewsFeedModel> list = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.news_feed_fragment;
    }

    @Override
    public int getBindingVariable() {
        return com.app.mvvmBase.BR.viewModel;
    }

    @Override
    public NewsFeedViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this).get(NewsFeedViewModel.class);

        return mViewModel;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel.setNavigator(this);
        binding = getViewDataBinding();
        binding.btnTest.setOnClickListener(v->{
            pictureViewModel = new PictureViewModel();
            pictureViewModel.imageUrl.setValue("http://homepages.cae.wisc.edu/~ece533/images/frymire.png");
            binding.setPictureViewModel(pictureViewModel);
        });

        compositeDisposable = new CompositeDisposable();

        appDbHelper =new AppDbHelper(AppDatabase.getDatabase(context));



    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0f);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public Context getAcitivityContext() {
        return context;

    }


    @Override
    public NewsFeedFragmentBinding getBinding() {
        return binding;
    }

    @Override
    public void onItemClick(View v, int position) {

    }

    //iserting data to user database
    private void insertUserIntoDatabase(){
        compositeDisposable.add(appDbHelper.getAllUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<User>>() {

                    @Override
                    public void onNext(List<User> users) {
                        List<User> list = users;
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    //fetching users from database
    private void getUsersFromDatabase(){
        compositeDisposable.add(appDbHelper.getAllUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<User>>() {

                    @Override
                    public void onNext(List<User> users) {
                        List<User> list = users;
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
