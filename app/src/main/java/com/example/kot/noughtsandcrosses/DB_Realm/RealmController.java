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

public interface RealmController {


    void initializeRealm(Context c);

    void clearAllUsers();

    void createNewUser(String n, Context c);

    void setIsCurrentUserAsFalse();

    boolean showLastCurrentUser(Context c);

    void lastCurrentUserIsNotActive();

    void currentUserWin();

    void currentUserLost();

    void currentUserTie();

    String showAllSortedByAlphabet(Context c);

    void setAllToZeros();

    RealmResults<UsersRealm> getAll();

    void closeRealm();


}
