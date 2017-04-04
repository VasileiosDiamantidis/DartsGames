package com.example.vdiamant.dartsgames.model;

import java.io.Serializable;

/**
 * Created by vdiamant on 26/3/2017.
 */

public class Player implements Serializable {
    private String name;
    private int points;


    public  Player(){}

    public Player(String n,int p){
        this.name=n;
        this.points=p;
    }

    public Player(String n){
        this.name=n;
        this.points=0;
    }


    public String getName(){
        return this.name;
    }

    public void setName(String n){
        this.name=n;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int p){
        this.points=p;
    }

    public void addPoints(int p){
        this.points+=p;
    }
}
