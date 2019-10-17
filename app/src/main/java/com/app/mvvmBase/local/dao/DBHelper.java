package com.app.mvvmBase.local.dao;



import java.util.List;

import io.reactivex.Observable;

public interface DBHelper {

    Observable<List<User>> getAllUsers();
    Observable<Boolean> insertUser(final User user);
}
