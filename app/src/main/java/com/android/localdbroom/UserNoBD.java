package com.android.localdbroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


public class UserNoBD {

    private long id;
    private String uName;
    private String uFamily;
    private String numPhone;
    private String mail; //here, i decided not change name column, to will stay "mail"

    public UserNoBD() {
    }

    public UserNoBD(long id, String uName, String uFamily, String numPhone, String mail) {
        this.id = id;
        this.uName = uName;
        this.uFamily = uFamily;
        this.numPhone = numPhone;
        this.mail = mail;
    }

    public UserNoBD(String uName, String uFamily, String numPhone, String mail) {
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

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuFamily() {
        return uFamily;
    }

    public void setuFamily(String uFamily) {
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
