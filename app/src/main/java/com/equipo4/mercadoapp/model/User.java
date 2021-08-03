package com.equipo4.mercadoapp.model;

import java.io.Serializable;

public class User implements Serializable {
    public static final String TABLE = "userTable", NAME = "nameUser", USERNAME = "username",
            EMAIL = "emailUser", PASSWORD = "passUser", PHONE = "phoneUser";
    private String personName, username, mail, password;
    private int phone;

    public User(String personName, String username, String mail, String password, int phone) {
        this.personName = personName;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
    }

    public User(String username, String password, boolean entry) {
        this.username = username;
        this.password = password;
    }

    public User(String mail, String password) {
        this.mail = mail;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
