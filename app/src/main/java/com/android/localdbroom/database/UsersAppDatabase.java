package com.android.localdbroom.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1) //here we in "entities" write which BD Table will using in this DB
public abstract class UsersAppDatabase extends RoomDatabase {

    public abstract UserDAO getUserDAO(); //connection to DAO of user
}
