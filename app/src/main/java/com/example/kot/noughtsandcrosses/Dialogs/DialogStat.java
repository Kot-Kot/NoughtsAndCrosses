package com.example.kot.noughtsandcrosses.Dialogs;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.kot.noughtsandcrosses.DB_SP.SaveGeneralStatisticsWithSPImpl;

/**
 * Created by Kot Kot on 28.06.2017.
 */

public class DialogStat extends AppCompatActivity {
    private Context myContext;
    private Activity myActivity;

    public Context getMyContext(){
        return myContext;
    }

    public Activity getMyActivity(){
        return myActivity;
    }

    public DialogStat(Context c, Activity a) {
        myContext = c;
        myActivity = a;
    }


    public void openStatDialog() {
        SaveGeneralStatisticsWithSPImpl myObjForSaveStatistics = new SaveGeneralStatisticsWithSPImpl(myContext, myActivity);
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
