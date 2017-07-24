package com.example.kot.noughtsandcrosses.DB_SP;

import android.app.Activity;

/**
 * Created by Kot Kot on 24.06.2017.
 */

public interface SaveGeneralStatisticsWithSP {
    String FILE_NAME = "my_stat";

    String CROSSES_WIN = "crosses_win";
    String NOUGHTS_WIN = "noughts_win";
    String TIE = "tie";
    String SKIN_CODE = "skin";

    Integer getWinsForCrosses();
    Integer getWinsForNoughts();
    Integer getTies();
    Integer getSkin();

    void saveWinForCrosses(Activity a);

    void saveWinForNoughts(Activity a);

    void saveTie(Activity a);

    void saveSkin(Integer i);
    void loadSkin();

    void loadStat();

    void clearStat();
}
