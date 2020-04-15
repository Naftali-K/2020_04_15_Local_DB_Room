package com.android.localdbroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.localdbroom.database.User;
import com.android.localdbroom.database.UsersAppDatabase;

public class AddUser extends AppCompatActivity {

    EditText input_name, input_family, input_phone, input_mail;
    User user;
    UsersAppDatabase usersAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), "Test", Toast.LENGTH_SHORT).show();

                input_name = findViewById(R.id.input_name);
                            String name = input_name.getText().toString();
                input_family = findViewById(R.id.input_family);
                            String family = input_family.getText().toString();
                input_phone = findViewById(R.id.input_phone);
                            String phone = input_phone.getText().toString();
                input_mail = findViewById(R.id.input_mail);
                            String mail = input_mail.getText().toString();

                //Toast.makeText(getBaseContext(), "User name: " + name, Toast.LENGTH_LONG).show();

                user = new User(0, name, family, phone, mail);

                usersAppDatabase = Room.databaseBuilder(getApplicationContext(), UsersAppDatabase.class, "PeopleDB").
                        allowMainThreadQueries().build();

                long indexAddUser = usersAppDatabase.getUserDAO().addUser(user);

                if(indexAddUser != 0){
                    Toast.makeText(getBaseContext(), "Add new user", Toast.LENGTH_SHORT).show();
                }


                //return to MainActivity with result
                Intent intent = new Intent();
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
