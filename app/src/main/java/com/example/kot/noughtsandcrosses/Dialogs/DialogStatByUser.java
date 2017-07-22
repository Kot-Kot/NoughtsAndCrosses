package com.example.kot.noughtsandcrosses.Dialogs;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.example.kot.noughtsandcrosses.DB_Realm.RealmController;
import com.example.kot.noughtsandcrosses.Dialogs.DialogStat;

/**
 * Created by Kot Kot on 28.06.2017.
 */

public class DialogStatByUser extends DialogStat {
    public DialogStatByUser(Context c, Activity a) {
        super(c, a);
    }

    public void openStatDialog() {
        RealmController myObjForRealmController = new RealmController();
        myObjForRealmController.initializeRealm(super.getMyContext());

        String title = "Статистика (По игрокам)";
        String message = myObjForRealmController.showAllSortedByAlphabet();
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
            myObjForRealmController.setAllToZeros();
            openStatDialog();
        });

        myDialog.setNegativeButton(buttonStringNeg, (dialog, which) -> {
            myObjForRealmController.clearAllUsers();
            openStatDialog();
            //isQuitDialogOnTop = false;
            //finish();
        });
        //myBundle.putBoolean(KEY_isQuitDialogOnTop, isQuitDialogOnTop);
        myDialog.show();
    }
}
