package com.example.kot.noughtsandcrosses.DB_Realm;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Kot Kot on 24.07.2017.
 */

public interface RealmConroller {


    public void initializeRealm(Context c);

    public void clearAllUsers();

    public void createNewUser(String n, Context c);

    public void setIsCurrentUserAsFalse();

    public Boolean showLastCurrentUser(Context c);

    public void lastCurrentUserIsNotActive();

    public void currentUserWin();

    public void currentUserLost();

    public void currentUserTie();

    public String showAllSortedByAlphabet(Context c);

    public void setAllToZeros();

    public RealmResults<UsersRealm> getAll();

    public void closeRealm();


}
