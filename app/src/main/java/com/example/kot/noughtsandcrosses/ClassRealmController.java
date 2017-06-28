package com.example.kot.noughtsandcrosses;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Kot Kot on 26.06.2017.
 */

public class ClassRealmController {
    private Realm myRealm;


    void initializeRealm(Context c){
        Realm.init(c);
        RealmConfiguration myRealmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(myRealmConfiguration);
        myRealm = Realm.getInstance(myRealmConfiguration);
    }

    void clearAllUsers() {
        myRealm.executeTransaction(realm ->
                realm.delete(ClassUsersRealm.class));
    }

    void createNewUser(String n, Context c) {
        myRealm.executeTransaction(realm -> {

            ClassUsersRealm myObjForCurrentUser = myRealm.where(ClassUsersRealm.class).equalTo("myName", n).findFirst();
            if (myObjForCurrentUser != null) {
                myObjForCurrentUser.setIsCurrentUser(true);
                myObjForCurrentUser.setIsActive(true);
                realm.copyToRealmOrUpdate(myObjForCurrentUser);

                Toast myToast = (Toast.makeText(c.getApplicationContext(), "Вы вошли как существующий игрок: \"" + myObjForCurrentUser.getMyName() + "\"", Toast.LENGTH_SHORT));
                myToast.show();
            } else {
                ClassUsersRealm myUser = new ClassUsersRealm();
                myUser.setMyName(n);
                myUser.setIsCurrentUser(true);
                myUser.setIsActive(true);

                myUser.setMyPlayerWins(0);
                myUser.setMyPcWins(0);
                myUser.setMyTie(0);
                realm.copyToRealmOrUpdate(myUser);
                Toast myToast = (Toast.makeText(c.getApplicationContext(), "Создан новый игрок: \"" + myUser.getMyName() + "\"", Toast.LENGTH_SHORT));
                myToast.show();
            }

            /*
            ClassUsersRealm myUser = new ClassUsersRealm();
            myUser.setMyName(n);
            myUser.setIsCurrentUser(b);
            myUser.setIsActive(b);

            myUser.setMyPlayerWins(0);
            myUser.setMyPcWins(0);
            myUser.setMyTie(0);
            realm.copyToRealmOrUpdate(myUser);
            */
        });
    }

    void setIsCurrentUserAsFalse(){

        ClassUsersRealm myObjForLastCurrentUser = myRealm.where(ClassUsersRealm.class).equalTo("isCurrentUser", true).findFirst();
        Log.d ("MYL", "myObjForLastCurrentUser = " + myObjForLastCurrentUser);
        if (myObjForLastCurrentUser != null) {
            myRealm.executeTransaction(realm -> {
                //myObjForLastCurrentUser.setMyName(myObjForLastCurrentUser.getMyName());
                myObjForLastCurrentUser.setIsCurrentUser(false);
                myObjForLastCurrentUser.setIsActive(false);
                realm.copyToRealmOrUpdate(myObjForLastCurrentUser);

            });
        }
    }

    Boolean showLastCurrentUser(Context c){

        ClassUsersRealm myObjForLastCurrentUser = myRealm.where(ClassUsersRealm.class).equalTo("isCurrentUser", true).findFirst();
        Log.d ("MYL", "myObjForLastCurrentUser = " + myObjForLastCurrentUser);
        if (myObjForLastCurrentUser == null){
            Toast myToast = (Toast.makeText(c.getApplicationContext(), "База данных пуста! Создайте пользователя или просто закройте диалог.", Toast.LENGTH_LONG));
            myToast.show();

            return false;
        }else {
            myRealm.executeTransaction(realm -> {
                Toast myToast = (Toast.makeText(c.getApplicationContext(), "Вы вошли как: \"" + myObjForLastCurrentUser.getMyName() + "\"", Toast.LENGTH_SHORT));
                myToast.show();
                myObjForLastCurrentUser.setIsActive(true);
            });
        }
        return true;
    }

    void lastCurrentUserIsNotActive() {

        ClassUsersRealm myObjForLastCurrentUser = myRealm.where(ClassUsersRealm.class).equalTo("isCurrentUser", true).findFirst();
        Log.d("MYL", "myObjForLastCurrentUser = " + myObjForLastCurrentUser);
        if (myObjForLastCurrentUser != null) {
            myRealm.executeTransaction(realm -> {
                //myObjForLastCurrentUser.setMyName(myObjForLastCurrentUser.getMyName());
                //myObjForLastCurrentUser.setIsCurrentUser(false);
                myObjForLastCurrentUser.setIsActive(false);
                realm.copyToRealmOrUpdate(myObjForLastCurrentUser);

            });
        }
    }


    void currentUserWin(){

        ClassUsersRealm myObjForLastCurrentUser = myRealm.where(ClassUsersRealm.class).equalTo("isCurrentUser", true).equalTo("isActive", true).findFirst();
        Log.d ("MYL", "myObjForLastCurrentUser = " + myObjForLastCurrentUser);
        if (myObjForLastCurrentUser != null) {
            myRealm.executeTransaction(realm -> {
                Integer i;
                i = myObjForLastCurrentUser.getMyPlayerWins() + 1;
                myObjForLastCurrentUser.setMyPlayerWins(i);

            });
        }
    }

    void currentUserLost(){

        ClassUsersRealm myObjForLastCurrentUser = myRealm.where(ClassUsersRealm.class).equalTo("isCurrentUser", true).equalTo("isActive", true).findFirst();
        Log.d ("MYL", "myObjForLastCurrentUser = " + myObjForLastCurrentUser);
        if (myObjForLastCurrentUser != null) {
            myRealm.executeTransaction(realm -> {
                Integer i;
                i = myObjForLastCurrentUser.getMyPcWins() + 1;
                myObjForLastCurrentUser.setMyPcWins(i);

            });
        }
    }

    void currentUserTie(){

        ClassUsersRealm myObjForLastCurrentUser = myRealm.where(ClassUsersRealm.class).equalTo("isCurrentUser", true).equalTo("isActive", true).findFirst();
        Log.d ("MYL", "myObjForLastCurrentUser = " + myObjForLastCurrentUser);
        if (myObjForLastCurrentUser != null) {
            myRealm.executeTransaction(realm -> {
                Integer i;
                i = myObjForLastCurrentUser.getMyTie() + 1;
                myObjForLastCurrentUser.setMyTie(i);

            });
        }
    }

    String showAllSortedByAlphabet(){
        RealmResults<ClassUsersRealm> results = myRealm.where(ClassUsersRealm.class).findAllSorted("myName");
        StringBuilder myBuilder = new StringBuilder();
        for (ClassUsersRealm singleUser : results){

            String temp = singleUser.getMyName() + ":\n";
            myBuilder.append(temp);
            temp = "Игрок выиграл: " + singleUser.getMyPlayerWins() + "\n";
            myBuilder.append(temp);
            temp = "ПК выиграл: " + singleUser.getMyPcWins() + "\n";
            myBuilder.append(temp);
            temp = "Ничья: " + singleUser.getMyTie() + "\n";
            myBuilder.append(temp);
            temp = "_________________" + "\n\n";
            myBuilder.append(temp);
        }
        String completedString = myBuilder.toString();
        Log.d("MYL", completedString);
        return completedString;
    }

    void setAllToZeros(){
        RealmResults<ClassUsersRealm> results = myRealm.where(ClassUsersRealm.class).findAll();

        myRealm.executeTransaction(realm -> {
            for (ClassUsersRealm singleUser : results){
                singleUser.setMyPlayerWins(0);
                singleUser.setMyPcWins(0);
                singleUser.setMyTie(0);
            }
        });



    }


    RealmResults<ClassUsersRealm> getAll() {

        return myRealm.where(ClassUsersRealm.class).findAll();
    }

    void closeRealm() {
        myRealm.close();
    }



/*
    void refresh() {
        myRealm.refresh();
    }

    void clearAll() {
        myRealm.beginTransaction();
        myRealm.delete(ClassUsersRealm.class);
        myRealm.commitTransaction();
    }



    public ClassUsersRealm getItemByName(String name) {

        return myRealm.where(ClassUsersRealm.class).equalTo("myName", name).findFirst();
    }

    void saveCurrentUser(){

    }

*/

}


