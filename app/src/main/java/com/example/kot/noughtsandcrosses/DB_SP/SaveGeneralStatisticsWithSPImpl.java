package com.example.kot.noughtsandcrosses.DB_SP;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Kot Kot on 24.06.2017.
 */

public class SaveGeneralStatisticsWithSPImpl implements SaveGeneralStatisticsWithSP {

    private Context myContext;
    private Activity myActivity;
    private SharedPreferences mySharedPreferences;


    private Integer winsForCrosses;
    private Integer winsForNoughts;
    private Integer ties;
    private Integer skin;

    @Override
    public Integer getWinsForCrosses() {
        return winsForCrosses;
    }

    @Override
    public Integer getWinsForNoughts() {
        return winsForNoughts;
    }

    @Override
    public Integer getTies() {
        return ties;
    }

    @Override
    public Integer getSkin() {
        return skin;
    }

    public SaveGeneralStatisticsWithSPImpl(Context c, Activity a) {
        myContext = c;
        myActivity = a;

    }


    public void saveWinForCrosses(Activity a) {

        mySharedPreferences = a.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        winsForCrosses = mySharedPreferences.getInt(CROSSES_WIN, 0);
        winsForCrosses++;
        SharedPreferences.Editor myEditor = mySharedPreferences.edit();
        myEditor.putInt(CROSSES_WIN, winsForCrosses);
        myEditor.apply();
        //Toast.makeText(myActivity.getApplicationContext(), "CROSSES_WIN = " + winsForCrosses, Toast.LENGTH_SHORT).show();
    }

    public void saveWinForNoughts(Activity a) {
        mySharedPreferences = a.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        winsForNoughts = mySharedPreferences.getInt(NOUGHTS_WIN, 0);
        winsForNoughts++;
        SharedPreferences.Editor myEditor = mySharedPreferences.edit();
        myEditor.putInt(NOUGHTS_WIN, winsForNoughts);
        myEditor.apply();
        //Toast.makeText(myActivity.getApplicationContext(), "NOUGHTS_WIN = " + winsForNoughts, Toast.LENGTH_SHORT).show();
    }

    public void saveTie(Activity a) {
        mySharedPreferences = a.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        ties = mySharedPreferences.getInt(TIE, 0);
        ties++;
        SharedPreferences.Editor myEditor = mySharedPreferences.edit();
        myEditor.putInt(TIE, ties);
        myEditor.apply();
        //Toast.makeText(myActivity.getApplicationContext(), "TIE = " + ties, Toast.LENGTH_SHORT).show();
    }


    public void loadStat() {
        mySharedPreferences = myContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        winsForCrosses = mySharedPreferences.getInt(CROSSES_WIN, 0);
        winsForNoughts = mySharedPreferences.getInt(NOUGHTS_WIN, 0);
        ties = mySharedPreferences.getInt(TIE, 0);


    }

    public void clearStat(){
        mySharedPreferences = myContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor myEditor = mySharedPreferences.edit();
        myEditor.remove(CROSSES_WIN);
        myEditor.remove(NOUGHTS_WIN);
        myEditor.remove(TIE);
        myEditor.apply();
    }

    @Override
    public void saveSkin(Integer i) {
        mySharedPreferences = myContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        //skin = mySharedPreferences.getInt(SKIN_CODE, 0);
        SharedPreferences.Editor myEditor = mySharedPreferences.edit();
        myEditor.putInt(SKIN_CODE, i);
        myEditor.apply();
    }

    @Override
    public void loadSkin() {
        mySharedPreferences = myContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        skin = mySharedPreferences.getInt(SKIN_CODE, 1);
    }
}
