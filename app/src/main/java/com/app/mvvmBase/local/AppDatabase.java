package com.app.mvvmBase.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.app.mvvmBase.local.dao.User;
import com.app.mvvmBase.local.dao.UserDao;



@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "AppDatabase";
    private static AppDatabase instace;

    /**
     * this method returns/create the instance of the room database
     * @param context
     * @return instace of the room database
     */
    public static AppDatabase getDatabase(Context context) {
        if (null == instace)
            instace = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        return instace;
    }

    public abstract UserDao userDao();


}
