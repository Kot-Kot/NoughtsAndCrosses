package com.example.kot.noughtsandcrosses.ChangeLocale;

import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;

/**
 * Created by Kot Kot on 25.07.2017.
 */

public interface ChangeLocale {


    String getCurrentLanguage();


    void setCurrentLanguage(String cl);


    void updateLocale(Context c);

}
