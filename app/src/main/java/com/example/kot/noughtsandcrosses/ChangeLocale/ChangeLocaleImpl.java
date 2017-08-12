package com.example.kot.noughtsandcrosses.ChangeLocale;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.kot.noughtsandcrosses.FragmentButtonClear;
import com.example.kot.noughtsandcrosses.R;

import java.util.Locale;


/**
 * Created by Kot Kot on 24.07.2017.
 */

public class ChangeLocaleImpl implements ChangeLocale {
    private String currentLanguage;

    public String getCurrentLanguage() {
        return currentLanguage;
    }

    public void setCurrentLanguage(String cl) {
        currentLanguage = cl;
    }


    public void updateLocale(Context c) {

        Locale myLocale = new Locale(currentLanguage);
        Locale.setDefault(myLocale);
        Configuration myConfiguration = new Configuration();
        myConfiguration.locale = myLocale;
        c.getResources().updateConfiguration(myConfiguration, null);

        // выводим английский текст на русской локали устройства
        //a.setTitle(R.string.app_name);
    }


    //@NonNull
    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    //public static String getStringByLocale(Activity context, int id, String locale) {
    //Configuration configuration = new Configuration(context.getResources().getConfiguration());
    //configuration.setLocale(new Locale(locale));
    //return context.createConfigurationContext(configuration).getResources().getString(id);
    //}


}
