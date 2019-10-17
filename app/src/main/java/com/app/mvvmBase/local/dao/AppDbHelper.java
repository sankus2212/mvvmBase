package com.app.mvvmBase.local.dao;

import com.app.mvvmBase.local.AppDatabase;

import java.util.List;

import io.reactivex.Observable;

public class AppDbHelper implements DBHelper {

    private AppDatabase appDatabase;

    public AppDbHelper(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return Observable.fromCallable(() -> appDatabase.userDao().loadAll());
    }

    @Override
    public Observable<Boolean> insertUser(User user) {
        return Observable.fromCallable(() -> {
            appDatabase.userDao().insert(user);
            return true;
        });
    }
}
