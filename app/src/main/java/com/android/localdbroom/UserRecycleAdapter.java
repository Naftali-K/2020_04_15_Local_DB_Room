package com.android.localdbroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.localdbroom.database.User;
import com.android.localdbroom.database.UsersAppDatabase;

import java.util.ArrayList;

public class UserRecycleAdapter extends  RecyclerView.Adapter<UserRowHolder> {

    ArrayList<User> users = new ArrayList();
    UsersAppDatabase usersAppDatabase;

    public UserRecycleAdapter() {
    }

    public UserRecycleAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new UserRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserRowHolder holder, final int position) {
        holder.userName.setText(users.get(position).getUName());
        holder.userFamily.setText(users.get(position).getUFamily());
        holder.userNumPhone.setText(users.get(position).getNumPhone());
        holder.userMail.setText(users.get(position).getMail());

        //catching push to button remove
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.usersAppDatabase.getUserDAO().deleteUser(users.get(position)); //removing user from DB
                MainActivity.updateRecycleView(); //making update of RecycleView
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    //update RecycleView
    public void updateRecycleList(ArrayList<User> users){
        this.users = users; //changing list of users, and after making update
        notifyDataSetChanged();
    }
}

class UserRowHolder extends RecyclerView.ViewHolder{

    TextView userName, userFamily, userNumPhone, userMail;
    Button btnRemove;

    public UserRowHolder(@NonNull View itemView) {
        super(itemView);

        userName = itemView.findViewById(R.id.user_name);
        userFamily = itemView.findViewById(R.id.user_family);
        userNumPhone = itemView.findViewById(R.id.user_num_phone);
        userMail = itemView.findViewById(R.id.user_mail);
        btnRemove = itemView.findViewById(R.id.btn_remove);
    }
}