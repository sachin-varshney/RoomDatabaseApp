package com.successive.roomdatabaseapp.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from User")
    List<User> getUserList();

    @Query("select * from User where id = :id")
    User getUserById(@NonNull int id);

    @Query("select count(*) from USER")
    int getCount();

    @Insert
    void addUser(User... users);

    @Delete
    void deleteUser(User user);

}
