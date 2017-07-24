package com.example.kot.noughtsandcrosses.Dialogs;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.kot.noughtsandcrosses.DB_SP.SaveGeneralStatisticsWithSPImpl;
import com.example.kot.noughtsandcrosses.R;

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

        String title = myContext.getResources().getString(R.string.dialog_stat_title);
        String message = myContext.getResources().getString(R.string.dialog_stat_crosses_win) + myObjForSaveStatistics.getWinsForCrosses()
                + "\n" + myContext.getResources().getString(R.string.dialog_stat_noughts_win) + myObjForSaveStatistics.getWinsForNoughts()
                + "\n" + myContext.getResources().getString(R.string.dialog_stat_tie) + myObjForSaveStatistics.getTies();
        String buttonStringPos = myContext.getResources().getString(R.string.dialog_stat_pb_name);
        String buttonStringNeg = myContext.getResources().getString(R.string.dialog_stat_negb_name);

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
