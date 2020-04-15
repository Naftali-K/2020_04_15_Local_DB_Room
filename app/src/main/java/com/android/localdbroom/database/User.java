package com.android.localdbroom.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "users") //This mean, is to be table of DB. Also i change name of table to "users"
public class User {

    @PrimaryKey(autoGenerate = true) //this making "id", primary key, is mean in the table can't be few time same id.
    //Also decided, id will change by him self. Default - false
    private long id;

    @ColumnInfo(name = "user_name") //this making change name column of table Db, to be not default, it's to be "user_name"
    private String uName;

    @ColumnInfo(name = "user_family") //same like before. not must be. can not change, so to be column calling like name variable
    private String uFamily;

    @ColumnInfo(name = "phone")
    private String numPhone;
    private String mail; //here, i decided not change name column, to will stay "mail"

    @Ignore // if user will using this constructor, so he will ignore
    public User() {
    }

    public User(long id, String uName, String uFamily, String numPhone, String mail) {
        this.id = id;
        this.uName = uName;
        this.uFamily = uFamily;
        this.numPhone = numPhone;
        this.mail = mail;
    }

    @Ignore
    public User(String uName, String uFamily, String numPhone, String mail) {
        this.uName = uName;
        this.uFamily = uFamily;
        this.numPhone = numPhone;
        this.mail = mail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUFamily() {
        return uFamily;
    }

    public void setUFamily(String uFamily) {
        this.uFamily = uFamily;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
