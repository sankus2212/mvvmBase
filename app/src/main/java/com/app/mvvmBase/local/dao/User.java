package com.app.mvvmBase.local.dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by amitshekhar on 07/07/17.
 */
@Entity(tableName = "users")
public class User {

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @ColumnInfo(name = "created_at")
    public String createdAt;

    @PrimaryKey
    public Long id;

    public String name;

    @ColumnInfo(name = "updated_at")
    public String updatedAt;
}