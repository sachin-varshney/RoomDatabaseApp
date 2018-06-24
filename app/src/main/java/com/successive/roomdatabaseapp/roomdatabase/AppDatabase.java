package com.successive.roomdatabaseapp.roomdatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class }, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static String dbName = "userDb";
    public static AppDatabase appDatabase;
    public abstract UserDao userDao();


    public static AppDatabase getDatabaseInstance(Context context){
        if(appDatabase==null)
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,dbName).allowMainThreadQueries().build();
        return appDatabase;
    }

    public void destroyDatabaseInstance(){
        appDatabase=null;
    }
}
