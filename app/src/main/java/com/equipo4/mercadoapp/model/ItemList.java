package com.equipo4.mercadoapp.model;

import java.io.Serializable;

//*create el 02/08/2021 para probes
public class ItemList implements Serializable {
    private int imgMarket;
    private String counter;
    private String coment;
    private String place;
    private String direction;
    private String email;
    private String telephone;

    public int getImgMarket() {
        return imgMarket;
    }

    public void setImgMarket(int imgMarket) {
        this.imgMarket = imgMarket;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public ItemList(int imgMarket, String counter, String coment, String place, String direction, String email, String telephone) {
        this.imgMarket = imgMarket;
        this.counter = counter;
        this.coment = coment;
        this.place = place;
        this.direction = direction;
        this.email = email;
        this.telephone = telephone;


    }
}
