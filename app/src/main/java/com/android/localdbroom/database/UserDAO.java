package com.android.localdbroom.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert //this mean now to be functionality of add value to DB
    public long addUser(User user); //this method back number ID from DB

    @Update //making update any row in DB table
    public void updateUser(User user); //this method not back nothing.

    @Delete // delete any user from DB
    public void deleteUser(User user);

    @Query("select * from users") //Question fro DB, using MySQL queries
    public List<User> getAllUser();

    @Query("select * from users where id = :idUser") //method, using find user by his id
    public User findUserByID(long idUser);
}
