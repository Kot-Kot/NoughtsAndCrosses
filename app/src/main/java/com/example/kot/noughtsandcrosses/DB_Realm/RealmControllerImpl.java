package com.example.kot.noughtsandcrosses.DB_Realm;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.kot.noughtsandcrosses.R;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Kot Kot on 26.06.2017.
 */

public class RealmControllerImpl implements RealmController {
    private Realm myRealm;


    public void initializeRealm(Context c) {
        Realm.init(c);
        RealmConfiguration myRealmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(myRealmConfiguration);
        myRealm = Realm.getInstance(myRealmConfiguration);
    }

    public void clearAllUsers() {
        myRealm.executeTransaction(realm ->
                realm.delete(UsersRealm.class));
    }

    public void createNewUser(String n, Context c) {
        myRealm.executeTransaction(realm -> {

            UsersRealm myObjForCurrentUser = myRealm.where(UsersRealm.class).equalTo("myName", n).findFirst();
            if (myObjForCurrentUser != null) {
                myObjForCurrentUser.setIsCurrentUser(true);
                myObjForCurrentUser.setIsActive(true);
                realm.copyToRealmOrUpdate(myObjForCurrentUser);

                Toast myToast = (Toast.makeText(c.getApplicationContext(),
                        c.getResources().getString(R.string.realm_controller_existing_player) + "\"" + myObjForCurrentUser.getMyName() + "\"", Toast.LENGTH_SHORT));
                myToast.show();
            } else {
                UsersRealm myUser = new UsersRealm();
                myUser.setMyName(n);
                myUser.setIsCurrentUser(true);
                myUser.setIsActive(true);

                myUser.setMyPlayerWins(0);
                myUser.setMyPcWins(0);
                myUser.setMyTie(0);
                realm.copyToRealmOrUpdate(myUser);
                Toast myToast = (Toast.makeText(c.getApplicationContext(),
                        c.getResources().getString(R.string.realm_controller_new_player) + "\"" + myUser.getMyName() + "\"", Toast.LENGTH_SHORT));
                myToast.show();
            }

            /*
            UsersRealm myUser = new UsersRealm();
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

    public void setIsCurrentUserAsFalse() {

        UsersRealm myObjForLastCurrentUser = myRealm.where(UsersRealm.class).equalTo("isCurrentUser", true).findFirst();
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

    public Boolean showLastCurrentUser(Context c) {

        UsersRealm myObjForLastCurrentUser = myRealm.where(UsersRealm.class).equalTo("isCurrentUser", true).findFirst();
        Log.d ("MYL", "myObjForLastCurrentUser = " + myObjForLastCurrentUser);
        if (myObjForLastCurrentUser == null){
            Toast myToast = (Toast.makeText(c.getApplicationContext(), c.getResources().getString(R.string.realm_controller_empty_DB), Toast.LENGTH_LONG));
            myToast.show();

            return false;
        }else {
            myRealm.executeTransaction(realm -> {
                Toast myToast = (Toast.makeText(c.getApplicationContext(),
                        c.getResources().getString(R.string.realm_controller_enterAs) + "\"" + myObjForLastCurrentUser.getMyName() + "\"", Toast.LENGTH_SHORT));
                myToast.show();
                myObjForLastCurrentUser.setIsActive(true);
            });
        }
        return true;
    }

    public void lastCurrentUserIsNotActive() {

        UsersRealm myObjForLastCurrentUser = myRealm.where(UsersRealm.class).equalTo("isCurrentUser", true).findFirst();
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


    public void currentUserWin() {

        UsersRealm myObjForLastCurrentUser = myRealm.where(UsersRealm.class).equalTo("isCurrentUser", true).equalTo("isActive", true).findFirst();
        Log.d ("MYL", "myObjForLastCurrentUser = " + myObjForLastCurrentUser);
        if (myObjForLastCurrentUser != null) {
            myRealm.executeTransaction(realm -> {
                Integer i;
                i = myObjForLastCurrentUser.getMyPlayerWins() + 1;
                myObjForLastCurrentUser.setMyPlayerWins(i);

            });
        }
    }

    public void currentUserLost() {

        UsersRealm myObjForLastCurrentUser = myRealm.where(UsersRealm.class).equalTo("isCurrentUser", true).equalTo("isActive", true).findFirst();
        Log.d ("MYL", "myObjForLastCurrentUser = " + myObjForLastCurrentUser);
        if (myObjForLastCurrentUser != null) {
            myRealm.executeTransaction(realm -> {
                Integer i;
                i = myObjForLastCurrentUser.getMyPcWins() + 1;
                myObjForLastCurrentUser.setMyPcWins(i);

            });
        }
    }

    public void currentUserTie() {

        UsersRealm myObjForLastCurrentUser = myRealm.where(UsersRealm.class).equalTo("isCurrentUser", true).equalTo("isActive", true).findFirst();
        Log.d ("MYL", "myObjForLastCurrentUser = " + myObjForLastCurrentUser);
        if (myObjForLastCurrentUser != null) {
            myRealm.executeTransaction(realm -> {
                Integer i;
                i = myObjForLastCurrentUser.getMyTie() + 1;
                myObjForLastCurrentUser.setMyTie(i);

            });
        }
    }

    public String showAllSortedByAlphabet(Context c) {
        RealmResults<UsersRealm> results = myRealm.where(UsersRealm.class).findAllSorted("myName");
        StringBuilder myBuilder = new StringBuilder();
        for (UsersRealm singleUser : results) {

            String temp = singleUser.getMyName() + ":\n";
            myBuilder.append(temp);
            temp = c.getResources().getString(R.string.realm_controller_player_win)
                    + singleUser.getMyPlayerWins() + "\n";
            myBuilder.append(temp);
            temp = c.getResources().getString(R.string.realm_controller_pc_win)
                    + singleUser.getMyPcWins() + "\n";
            myBuilder.append(temp);
            temp = c.getResources().getString(R.string.realm_controller_tie)
                    + singleUser.getMyTie() + "\n";
            myBuilder.append(temp);
            temp = "_________________" + "\n\n";
            myBuilder.append(temp);
        }
        String completedString = myBuilder.toString();
        Log.d("MYL", completedString);
        return completedString;
    }

    public void setAllToZeros() {
        RealmResults<UsersRealm> results = myRealm.where(UsersRealm.class).findAll();

        myRealm.executeTransaction(realm -> {
            for (UsersRealm singleUser : results) {
                singleUser.setMyPlayerWins(0);
                singleUser.setMyPcWins(0);
                singleUser.setMyTie(0);
            }
        });



    }


    public RealmResults<UsersRealm> getAll() {

        return myRealm.where(UsersRealm.class).findAll();
    }

    public void closeRealm() {
        myRealm.close();
    }



/*
    void refresh() {
        myRealm.refresh();
    }

    void clearAll() {
        myRealm.beginTransaction();
        myRealm.delete(UsersRealm.class);
        myRealm.commitTransaction();
    }



    public UsersRealm getItemByName(String name) {

        return myRealm.where(UsersRealm.class).equalTo("myName", name).findFirst();
    }

    void saveCurrentUser(){

    }

*/

}


