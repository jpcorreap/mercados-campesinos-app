package com.equipo4.mercadoapp.model;

import android.content.ContentValues;

import java.io.Serializable;

public class User implements Serializable {
    public static final String TABLE = "userTable", NAME = "nameUser", USERNAME = "username",
            EMAIL = "emailUser", PASSWORD = "passUser", PHONE = "phoneUser";
    private String personName, username, email, password, phone;

    public User(String personName, String username, String email, String password, String phone) {
        this.personName = personName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User(String username, String password, boolean entry) {
        this.username = username;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ContentValues getContentValues(){
        ContentValues values = new ContentValues();
        values.put(NAME, personName);
        values.put(USERNAME, username);
        values.put(EMAIL, email);
        values.put(PASSWORD, password);
        values.put(PHONE, phone);
        return values;
    }
}
