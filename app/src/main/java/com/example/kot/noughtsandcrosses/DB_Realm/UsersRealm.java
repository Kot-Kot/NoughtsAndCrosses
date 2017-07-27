package com.example.kot.noughtsandcrosses.DB_Realm;


import io.realm.RealmObject;

import io.realm.annotations.PrimaryKey;


/**
 * Created by Kot Kot on 26.06.2017.
 */

public class UsersRealm extends RealmObject {

    //private Context myContext;
    //@Index


    @PrimaryKey
    private String myName;
    private boolean isCurrentUser;
    private boolean isActive;

    private int myPcWins;
    private int myPlayerWins;
    private int myTie;




    public String getMyName() {
        return myName;
    }

    public void setMyName(String n) {
        myName = n;
    }

    public boolean getIsCurrentUser() {
        return isCurrentUser;
    }

    public void setIsCurrentUser (Boolean b){
        isCurrentUser = b;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean b) {
        isActive = b;
    }

    public int getMyPcWins() {
        return myPcWins;
    }

    public void setMyPcWins(Integer i) {
        myPcWins = i;
    }

    public int getMyPlayerWins() {
        return myPlayerWins;
    }

    public void setMyPlayerWins(Integer i) {
        myPlayerWins = i;
    }

    public int getMyTie() {
        return myTie;
    }

    public void setMyTie(Integer i) {
        myTie = i;
    }


    //UsersRealm(Context c){
        //myContext = c;
    //}







}
