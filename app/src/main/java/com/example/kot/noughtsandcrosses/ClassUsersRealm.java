package com.example.kot.noughtsandcrosses;


import io.realm.RealmObject;

import io.realm.annotations.PrimaryKey;


/**
 * Created by Kot Kot on 26.06.2017.
 */

public class ClassUsersRealm extends RealmObject {

    //private Context myContext;
    //@Index


    @PrimaryKey
    private String myName;
    private Boolean isCurrentUser;

    private Integer myPcWins;
    private Integer myPlayerWins;
    private Integer myTie;




    public String getMyName() {
        return myName;
    }

    public void setMyName(String n) {
        myName = n;
    }

    public Boolean getIsCurrentUser(){
        return isCurrentUser;
    }

    public void setIsCurrentUser (Boolean b){
        isCurrentUser = b;
    }

    public Integer getMyPcWins() {
        return myPcWins;
    }

    public void setMyPcWins(Integer i) {
        myPcWins = i;
    }

    public Integer getMyPlayerWins() {
        return myPlayerWins;
    }

    public void setMyPlayerWins(Integer i) {
        myPlayerWins = i;
    }

    public Integer getMyTie() {
        return myTie;
    }

    public void setMyTie(Integer i) {
        myTie = i;
    }


    //ClassUsersRealm(Context c){
        //myContext = c;
    //}







}
