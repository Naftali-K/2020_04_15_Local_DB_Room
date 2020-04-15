package com.android.localdbroom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.localdbroom.database.User;
import com.android.localdbroom.database.UsersAppDatabase;

import java.util.ArrayList;

/*
1) Connecting dependencies of DB Room
2) Making @Entity class/object. @Entity explain how will looks table of DB
3) Making @Dao interface/abstract file, where written of functionality for use DB, like: Add new row, update row and etc.
4) Connection and using DB

    *DB - DataBase
 */

public class MainActivity extends AppCompatActivity {

    static UserRecycleAdapter adapter;
    static UsersAppDatabase usersAppDatabase;
    static ArrayList<User> users = new ArrayList();
    final int REQUEST_NUMBER = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add connection to DB
        usersAppDatabase = Room.databaseBuilder(getApplicationContext(), UsersAppDatabase.class, "PeopleDB").
                allowMainThreadQueries().build();
        /*
        Row before, is connection DB to the code. Parameters:
        1) Mean from where take the DB
        2) Which class is DataBase builder "UsersAppDatabase"
        3) Name of DB.
         */


        users.addAll(usersAppDatabase.getUserDAO().getAllUser());
        /*
        Using DB Query for get all users
        1) using connection of Room
        2) using method have in class DB (UsersAppDatabase)
        3) using method in DAO class.
         */

        //RecycleView connection
        RecyclerView recyclerView = findViewById(R.id.rv_container);
        adapter = new UserRecycleAdapter(users);
        recyclerView.setAdapter(adapter);


        //Button add new user
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddUser.class);
                startActivityForResult(intent, REQUEST_NUMBER);
            }
        });


        //Button make Refresh of RecycleView
        findViewById(R.id.btn_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Refresh RecycleView", Toast.LENGTH_LONG).show();
                updateRecycleView();
            }
        });
    }



    //get page beck with result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if result OK, to make update RecycleView
        if(requestCode == REQUEST_NUMBER && resultCode == RESULT_OK){
            Toast.makeText(getBaseContext(), "Update RecycleView", Toast.LENGTH_LONG).show();
            updateRecycleView();
        }else{
            Toast.makeText(getBaseContext(), "Had any error, Try again!", Toast.LENGTH_LONG).show();
        }
    }


    //static function for update RecycleView
    public static void updateRecycleView(){
        users = new ArrayList();
        users.addAll(usersAppDatabase.getUserDAO().getAllUser());
        adapter.updateRecycleList(users);
    }
}
