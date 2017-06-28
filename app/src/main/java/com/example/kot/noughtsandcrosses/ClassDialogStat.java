package com.example.kot.noughtsandcrosses;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Kot Kot on 28.06.2017.
 */

public class ClassDialogStat extends AppCompatActivity {
    private Context myContext;
    private Activity myActivity;

    public Context getMyContext(){
        return myContext;
    }

    public Activity getMyActivity(){
        return myActivity;
    }

    ClassDialogStat(Context c, Activity a){
        myContext = c;
        myActivity = a;
    }


    void openStatDialog() {
        ClassImplSaveStatistics myObjForSaveStatistics = new ClassImplSaveStatistics(myContext, myActivity);
        myObjForSaveStatistics.loadStat();

        String title = "Статистика (Общая)";
        String message = "Крестики выиграли: "+ myObjForSaveStatistics.getWinsForCrosses()
                +"\nНолики выиграли: " + myObjForSaveStatistics.getWinsForNoughts()
                + "\nНичья: " + myObjForSaveStatistics.getTies();
        String buttonStringPos = "Ок";
        String buttonStringNeg = "Обнулить";

        //AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
        AlertDialog.Builder myDialog = new AlertDialog.Builder(myActivity);

        myDialog.setMessage(message);
        myDialog.setTitle(title);
        myDialog.setCancelable(false);
        myDialog.setPositiveButton(buttonStringPos, (dialog, which) -> {
            //isQuitDialogOnTop = false;
            //finish();
        });
        myDialog.setNegativeButton(buttonStringNeg, (dialog, which) -> {
            myObjForSaveStatistics.clearStat();
            openStatDialog();
            //isQuitDialogOnTop = false;
            //finish();
        });
        //myBundle.putBoolean(KEY_isQuitDialogOnTop, isQuitDialogOnTop);
        myDialog.show();
    }

}
