package com.example.kot.noughtsandcrosses.Dialogs;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.example.kot.noughtsandcrosses.DB_Realm.RealmControllerImpl;

/**
 * Created by Kot Kot on 28.06.2017.
 */

public class DialogStatByUser extends DialogStat {
    public DialogStatByUser(Context c, Activity a) {
        super(c, a);
    }

    public void openStatDialog() {
        RealmControllerImpl myObjForRealmControllerImpl = new RealmControllerImpl();
        myObjForRealmControllerImpl.initializeRealm(super.getMyContext());

        String title = "Статистика (По игрокам)";
        String message = myObjForRealmControllerImpl.showAllSortedByAlphabet();
        String buttonStringPos = "Ок";
        String buttonStringNeg = "Удалить";
        String buttonStringNeut = "Обнулить";

        //AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
        AlertDialog.Builder myDialog = new AlertDialog.Builder(super.getMyActivity());

        myDialog.setMessage(message);
        myDialog.setTitle(title);
        myDialog.setCancelable(false);
        myDialog.setPositiveButton(buttonStringPos, (dialog, which) -> {
            //isQuitDialogOnTop = false;
            //finish();
        });
        myDialog.setNeutralButton(buttonStringNeut, (dialog, which) -> {
            myObjForRealmControllerImpl.setAllToZeros();
            openStatDialog();
        });

        myDialog.setNegativeButton(buttonStringNeg, (dialog, which) -> {
            myObjForRealmControllerImpl.clearAllUsers();
            openStatDialog();
            //isQuitDialogOnTop = false;
            //finish();
        });
        //myBundle.putBoolean(KEY_isQuitDialogOnTop, isQuitDialogOnTop);
        myDialog.show();
    }
}
