package com.example.kot.noughtsandcrosses;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.kot.noughtsandcrosses.ChangeLocale.ChangeLocaleImpl;
import com.example.kot.noughtsandcrosses.Constants.Constants;
import com.example.kot.noughtsandcrosses.DB_SP.SaveGeneralStatisticsWithSPImpl;
import com.example.kot.noughtsandcrosses.DB_SP.SaveGeneralStatisticsWithSP;
import com.example.kot.noughtsandcrosses.Dialogs.DialogInitial;
import com.example.kot.noughtsandcrosses.Dialogs.DialogStatGeneral;
import com.example.kot.noughtsandcrosses.Dialogs.DialogStatByUser;
import com.example.kot.noughtsandcrosses.Drawing.Drawing;
import com.example.kot.noughtsandcrosses.Drawing.Skin1Impl;
import com.example.kot.noughtsandcrosses.Drawing.Skin2Impl;
import com.example.kot.noughtsandcrosses.Drawing.Skin3Impl;
import com.example.kot.noughtsandcrosses.Logic.PCLogic;
import com.example.kot.noughtsandcrosses.Logic.PCLogicImpl;
import com.example.kot.noughtsandcrosses.ThreeVariants.ThreeVariants;
import com.example.kot.noughtsandcrosses.ThreeVariants.ThreeVariantsImpl;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, RadioButton.OnCheckedChangeListener {
    //public static final String LOG_TAG = "MY_LOG";

    //RealmControllerImpl myObjForRealmController = new RealmControllerImpl();


    FragmentChooseMode myModeFragment;
    FragmentPlayingFields myFieldsFragment;
    FragmentButtonClear myButtonFragment;


    Button myClearScreen;

    RadioGroup myRG;

    RadioButton myRB1;
    RadioButton myRB2;
    RadioButton myRB3;


    SaveGeneralStatisticsWithSP myObjForSaveGeneralStatistics = new SaveGeneralStatisticsWithSPImpl(this, this);

    PCLogic myObjForLogic = new PCLogicImpl(this);
    ThreeVariants myObjForThreeVariants = new ThreeVariantsImpl(this, this);

    Drawing myObjForNoughtPicture;
    Drawing myObjForCrossPicture;
    Drawing myObjForClearPicture;

    ChangeLocaleImpl myObjForChangeLocale = new ChangeLocaleImpl();

    Bitmap myBitmapCross;
    Bitmap myBitmapNought;
    Bitmap myBitmapForClean;

    ImageView myIVTopLeft;
    ImageView myIVTopCenter;
    ImageView myIVTopRight;
    ImageView myIVCenterLeft;
    ImageView myIVCenter;
    ImageView myIVCenterRight;
    ImageView myIVBottomLeft;
    ImageView myIVBottomCenter;
    ImageView myIVBottomRight;

    //Handler myHandler = new Handler();
    //ProgressBar myProgressBar;
    //int myProgress = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myObjForSaveGeneralStatistics.loadLanguage();
        myObjForChangeLocale.setCurrentLanguage(myObjForSaveGeneralStatistics.getLanguage());
        myObjForChangeLocale.updateLocale(this);
        setTitle(R.string.app_name);

        myObjForSaveGeneralStatistics.loadSkin();
        switch (myObjForSaveGeneralStatistics.getSkin()) {
            case 1:
                myObjForNoughtPicture = new Skin1Impl(this);
                myObjForCrossPicture = new Skin1Impl(this);
                myObjForClearPicture = new Skin1Impl(this);
                MainActivity.this.setTheme(R.style.AppTheme1);
                break;
            case 2:
                myObjForNoughtPicture = new Skin2Impl(this);
                myObjForCrossPicture = new Skin2Impl(this);
                myObjForClearPicture = new Skin2Impl(this);
                MainActivity.this.setTheme(R.style.AppTheme2);
                break;
            case 3:
                myObjForNoughtPicture = new Skin3Impl(this);
                myObjForCrossPicture = new Skin3Impl(this);
                myObjForClearPicture = new Skin3Impl(this);
                MainActivity.this.setTheme(R.style.AppTheme3);
                break;
            default:
                myBitmapCross = myObjForNoughtPicture.myDrawCross();
                myBitmapNought = myObjForCrossPicture.myDrawNought();
                myBitmapForClean = myObjForClearPicture.myDrawClear();
                break;



        }

        setContentView(R.layout.activity_main);
        //RealmControllerImpl RC = new RealmControllerImpl();
        //RC.initializeRealm(this);
        //RC.clearAllUsers();
        //Log.d ("MYL", "RC.getAll() =" + RC.getAll());
        //Log.d ("MYL", "RC.getAll() =" + RC.getAll());
        //Log.d ("MYL", "RC.getItem(\"вася\") =" + RC.getItemByName("вася"));

        DialogInitial myObjForCustomDialog = new DialogInitial(this, this);

        myObjForCustomDialog.createCustomDialog();








        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.colorWhite));

        //myModeFragment = getFragmentManager().findFragmentById(R.id.mode_fragment);
        myModeFragment = (FragmentChooseMode) getSupportFragmentManager().findFragmentById(R.id.mode_fragment);
        myFieldsFragment = (FragmentPlayingFields) getSupportFragmentManager().findFragmentById(R.id.fields_fragment);
        myButtonFragment = (FragmentButtonClear) getSupportFragmentManager().findFragmentById(R.id.button_fragment);



        //myProgressBar = (ProgressBar)findViewById(R.id.progressBar);

        myRG = (RadioGroup) myModeFragment.getView().findViewById(R.id.rg);

        myRB1 = (RadioButton) myModeFragment.getView().findViewById(R.id.rb1);
        myRB2 = (RadioButton) myModeFragment.getView().findViewById(R.id.rb2);
        myRB3 = (RadioButton) myModeFragment.getView().findViewById(R.id.rb3);

        myClearScreen = (Button) myButtonFragment.getView().findViewById(R.id.btnClear);


        myIVTopLeft = (ImageView) myFieldsFragment.getView().findViewById(R.id.ivTopLeft);
        myIVTopCenter = (ImageView) myFieldsFragment.getView().findViewById(R.id.ivTopCenter);
        myIVTopRight = (ImageView) myFieldsFragment.getView().findViewById(R.id.ivTopRight);
        myIVCenterLeft = (ImageView) myFieldsFragment.getView().findViewById(R.id.ivCenterLeft);
        myIVCenter = (ImageView) myFieldsFragment.getView().findViewById(R.id.ivCenter);
        myIVCenterRight = (ImageView) myFieldsFragment.getView().findViewById(R.id.ivCenterRight);
        myIVBottomLeft = (ImageView) myFieldsFragment.getView().findViewById(R.id.ivBottomLeft);
        myIVBottomCenter = (ImageView) myFieldsFragment.getView().findViewById(R.id.ivBottomCenter);
        myIVBottomRight = (ImageView) myFieldsFragment.getView().findViewById(R.id.ivBottomRight);


        myRB1.setOnCheckedChangeListener(this);
        myRB2.setOnCheckedChangeListener(this);
        myRB3.setOnCheckedChangeListener(this);


        myClearScreen.setOnClickListener(v -> {
            //myClearScreen();

            myObjForThreeVariants.myClearScreen(myObjForLogic, myBitmapForClean,
                    myIVTopLeft,myIVTopCenter,myIVTopRight,
                    myIVCenterLeft,myIVCenter,myIVCenterRight,
                    myIVBottomLeft,myIVBottomCenter,myIVBottomRight);
            if (myRB1.isChecked()){
                //myHoldScreen();


                //while (myGameStage <= 9){
                while (myObjForThreeVariants.getMyGameStage() <= 9) {
                    Log.d(Constants.LOG_TAG, "myPositionsForPlayer1 = " + Arrays.toString(myObjForThreeVariants.getMyPositionsForPlayer1()));
                    Log.d(Constants.LOG_TAG, "myPositionsForPlayer2 = " + Arrays.toString(myObjForThreeVariants.getMyPositionsForPlayer2()));
                    //if (myGameStage%2 == 1){
                    if (myObjForThreeVariants.getMyGameStage() % 2 == 1) {
                        ImageView myIV = (ImageView) findViewById(myObjForLogic.myPCsClickedButton(myObjForThreeVariants.getMyPositionsForPlayer1(), myObjForThreeVariants.getMyPositionsForPlayer2()));

                        myIV.performClick();
                    }else{
                        ImageView myIV = (ImageView) findViewById(myObjForLogic.myPCsClickedButton(myObjForThreeVariants.getMyPositionsForPlayer2(), myObjForThreeVariants.getMyPositionsForPlayer1()));

                        myIV.performClick();
                    }
                }
            }
        });



        myIVTopLeft.setOnClickListener(this);
        myIVTopCenter.setOnClickListener(this);
        myIVTopRight.setOnClickListener(this);
        myIVCenterLeft.setOnClickListener(this);
        myIVCenter.setOnClickListener(this);
        myIVCenterRight.setOnClickListener(this);
        myIVBottomLeft.setOnClickListener(this);
        myIVBottomCenter.setOnClickListener(this);
        myIVBottomRight.setOnClickListener(this);





        myRG.setOnCheckedChangeListener((group, checkedId) -> {
            //myClearScreen();
            myObjForThreeVariants.myClearScreen(myObjForLogic, myBitmapForClean,
                    myIVTopLeft,myIVTopCenter,myIVTopRight,
                    myIVCenterLeft,myIVCenter,myIVCenterRight,
                    myIVBottomLeft,myIVBottomCenter,myIVBottomRight);
            switch (checkedId){
                case R.id.rb1:


                    while (myObjForThreeVariants.getMyGameStage() <= 9) {

                        Log.d(Constants.LOG_TAG, "myPositionsForPlayer1 = " + Arrays.toString(myObjForThreeVariants.getMyPositionsForPlayer1()));
                        Log.d(Constants.LOG_TAG, "myPositionsForPlayer2 = " + Arrays.toString(myObjForThreeVariants.getMyPositionsForPlayer2()));


                        if (myObjForThreeVariants.getMyGameStage() % 2 == 1) {

                            ImageView myIV = (ImageView) findViewById(myObjForLogic.myPCsClickedButton(myObjForThreeVariants.getMyPositionsForPlayer1(), myObjForThreeVariants.getMyPositionsForPlayer2()));

                            myIV.performClick();

                        }else{

                            ImageView myIV = (ImageView) findViewById(myObjForLogic.myPCsClickedButton(myObjForThreeVariants.getMyPositionsForPlayer2(), myObjForThreeVariants.getMyPositionsForPlayer1()));

                            myIV.performClick();

                        }
                    }
                    break;
                case R.id.rb2:
                    break;
                case R.id.rb3:
                    break;
                default:
                    break;

            }
        });



        myBitmapCross = myObjForNoughtPicture.myDrawCross();
        myBitmapNought = myObjForCrossPicture.myDrawNought();
        myBitmapForClean = myObjForClearPicture.myDrawClear();

    }

    //@Override
    //protected void onDestroy() {
    //super.onDestroy();

    //myObjForRealmController.initializeRealm(this);
    //myObjForRealmController.closeRealm();
    //}

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        myObjForSaveGeneralStatistics.loadSkin();
        switch (myObjForSaveGeneralStatistics.getSkin()) {
            case 1:
                menu.findItem(R.id.menu_skin1).setChecked(true);
                //menu.getItem(R.id.menu_skin1).setChecked(true);
                break;
            case 2:
                menu.findItem(R.id.menu_skin2).setChecked(true);
                //menu.getItem(R.id.menu_skin2).setChecked(true);
                break;
            case 3:
                menu.findItem(R.id.menu_skin3).setChecked(true);
                //menu.getItem(R.id.menu_skin3).setChecked(true);
                break;
        }

        myObjForSaveGeneralStatistics.loadLanguage();
        myObjForChangeLocale.setCurrentLanguage(myObjForSaveGeneralStatistics.getLanguage());
        myObjForChangeLocale.updateLocale(this);

        switch (myObjForChangeLocale.getCurrentLanguage()) {
            case "ru":
                menu.findItem(R.id.menu_lang_ru).setChecked(true);
                break;
            case "en":
                menu.findItem(R.id.menu_lang_eng).setChecked(true);
                break;
        }

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu, menu);
         return super.onCreateOptionsMenu(menu);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String msgReload = this.getResources().getString(R.string.menu_toast_msg_reload);

        switch (item.getItemId()){
            case R.id.menu_reload:
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                return true;
            case R.id.menu_stat:
                DialogStatGeneral myObjForDialogStat = new DialogStatGeneral(this, this);
                myObjForDialogStat.openStatDialog();

                //openStatDialog();
                return true;
            case R.id.menu_stat_by_users:
                DialogStatByUser myObjForDialogStatByUser = new DialogStatByUser(this, this);
                myObjForDialogStatByUser.openStatDialog();

                //openStatDialog();
                return true;
            case R.id.menu_skin1:
                item.setChecked(!item.isChecked());
                //item.setEnabled(!item.isEnabled());
                myObjForSaveGeneralStatistics.saveSkin(1);
                Toast.makeText(this, msgReload, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_skin2:
                item.setChecked(!item.isChecked());
                //item.setEnabled(!item.isEnabled());
                myObjForSaveGeneralStatistics.saveSkin(2);
                Toast.makeText(this, msgReload, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_skin3:
                item.setChecked(!item.isChecked());
                //item.setEnabled(!item.isEnabled());
                myObjForSaveGeneralStatistics.saveSkin(3);
                Toast.makeText(this, msgReload, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_lang_ru:
                item.setChecked(!item.isChecked());
                //item.setEnabled(!item.isEnabled());

                myObjForSaveGeneralStatistics.saveLanguage("ru");
                myObjForChangeLocale.setCurrentLanguage("ru");
                myObjForChangeLocale.updateLocale(this);
                Toast.makeText(this, msgReload, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_lang_eng:
                item.setChecked(!item.isChecked());
                //item.setEnabled(!item.isEnabled());
                myObjForSaveGeneralStatistics.saveLanguage("en");
                myObjForChangeLocale.setCurrentLanguage("en");
                myObjForChangeLocale.updateLocale(this);
                Toast.makeText(this, msgReload, Toast.LENGTH_SHORT).show();
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }

    }



    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }




    @Override
    public void onClick(View v) {
        //TextView mytv = (TextView)findViewById(v.getId());
        ImageView myIV = (ImageView) findViewById(v.getId());


        //String IdAsString = v.getResources().getResourceName(v.getId());
        String IdAsString = v.getResources().getResourceEntryName(v.getId());
        Log.d(Constants.LOG_TAG, "---                       ---");
        //Log.d(Constants.LOG_TAG,"myGameStage = " + myGameStage);
        Log.d(Constants.LOG_TAG, "myGameStage = " + myObjForThreeVariants.getMyGameStage());
        Log.d(Constants.LOG_TAG, "IdAsString = " + IdAsString.substring(2));
        //if(myNowClickedButton == ""){
           // myNowClickedButton = IdAsString.substring(2);
       // }
        if(myObjForLogic.getMyNowClickedButton().equals("")){
            myObjForLogic.setMyNowClickedButton(IdAsString.substring(2));

        }

        if(myRB3.isChecked()){
            Log.d(Constants.LOG_TAG, "---myPlayerVsPlayer---");
            //myPlayerVsPlayer(myIV)

            myObjForThreeVariants.myPlayerVsPlayer(myIV,
                    myObjForLogic, myBitmapCross, myBitmapNought,
                    myIVTopLeft,myIVTopCenter,myIVTopRight,
                    myIVCenterLeft,myIVCenter,myIVCenterRight,
                    myIVBottomLeft,myIVBottomCenter,myIVBottomRight);
            return;
        }

        if(myRB2.isChecked()){
            Log.d(Constants.LOG_TAG, "---myPlayerVsPc---");
            //myPlayerVsPc(myIV);
            myObjForThreeVariants.myPlayerVsPc(myIV,
                    myObjForLogic, myBitmapCross, myBitmapNought,
                    myIVTopLeft,myIVTopCenter,myIVTopRight,
                    myIVCenterLeft,myIVCenter,myIVCenterRight,
                    myIVBottomLeft,myIVBottomCenter,myIVBottomRight);
            return;
        }



        if(myRB1.isChecked()){
            Log.d(Constants.LOG_TAG, "---myPcVsPc---");
            //new Handler(Looper.getMainLooper()).postDelayed(() -> {myPcVsPc(myIV);}, 500);
            //myPcVsPc(myIV);
            myObjForThreeVariants.myPcVsPc(myIV, myObjForLogic, myBitmapCross, myBitmapNought);
            return;
        }
    }

}
