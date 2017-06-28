package com.example.kot.noughtsandcrosses;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by Kot Kot on 28.06.2017.
 */

public class ClassDialogStatByUser extends ClassDialogStat {
    ClassDialogStatByUser(Context c, Activity a) {
        super(c, a);
    }

    void openStatDialog() {
        ClassRealmController myObjForRealmController = new ClassRealmController();
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
