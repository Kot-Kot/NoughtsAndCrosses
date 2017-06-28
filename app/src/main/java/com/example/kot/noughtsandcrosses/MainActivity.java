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

import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, RadioButton.OnCheckedChangeListener {
    static final String LOG_TAG = "MY_LOG";


    ClassModeFragment myModeFragment;
    ClassFieldsFragment myFieldsFragment;
    ClassButtonFragment myButtonFragment;


    Button myClearScreen;

    RadioGroup myRG;

    RadioButton myRB1;
    RadioButton myRB2;
    RadioButton myRB3;


    IntfSaveStatistics myObjForSaveStatistics = new ClassImplSaveStatistics(this, this);

    IntfLogic myObjForLogic = new ClassImplLogic(this);
    IntfDiffVariants myObjForDV = new ClassImplDiffVariants(this, this);

    IntfDrawing myObjForNoughtPicture;
    IntfDrawing myObjForCrossPicture;
    IntfDrawing myObjForClearPicture;

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

        myObjForSaveStatistics.loadSkin();
        switch (myObjForSaveStatistics.getSkin()){
            case 1:
                myObjForNoughtPicture = new ClassSkin1ImplDrawing(this);
                myObjForCrossPicture = new ClassSkin1ImplDrawing(this);
                myObjForClearPicture = new ClassSkin1ImplDrawing(this);
                MainActivity.this.setTheme(R.style.AppTheme1);
                break;
            case 2:
                myObjForNoughtPicture = new ClassSkin2ImplDrawing(this);
                myObjForCrossPicture = new ClassSkin2ImplDrawing(this);
                myObjForClearPicture = new ClassSkin2ImplDrawing(this);
                MainActivity.this.setTheme(R.style.AppTheme2);
                break;
            case 3:
                myObjForNoughtPicture = new ClassSkin3ImplDrawing(this);
                myObjForCrossPicture = new ClassSkin3ImplDrawing(this);
                myObjForClearPicture = new ClassSkin3ImplDrawing(this);
                MainActivity.this.setTheme(R.style.AppTheme3);
                break;
            default:
                myBitmapCross = myObjForNoughtPicture.myDrawCross();
                myBitmapNought = myObjForCrossPicture.myDrawNought();
                myBitmapForClean = myObjForClearPicture.myDrawClear();
                break;



        }

        setContentView(R.layout.activity_main);
        //ClassRealmController RC = new ClassRealmController();
        //RC.initializeRealm(this);
        //RC.clearAllUsers();
        //Log.d ("MYL", "RC.getAll() =" + RC.getAll());
        //Log.d ("MYL", "RC.getAll() =" + RC.getAll());
        //Log.d ("MYL", "RC.getItem(\"вася\") =" + RC.getItemByName("вася"));

        ClassCustomDialog myObjForCustomDialog = new ClassCustomDialog(this, this);

        myObjForCustomDialog.createCustomDialog();








        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.colorWhite));

        //myModeFragment = getFragmentManager().findFragmentById(R.id.mode_fragment);
        myModeFragment = (ClassModeFragment) getSupportFragmentManager().findFragmentById(R.id.mode_fragment);
        myFieldsFragment = (ClassFieldsFragment) getSupportFragmentManager().findFragmentById(R.id.fields_fragment);
        myButtonFragment = (ClassButtonFragment) getSupportFragmentManager().findFragmentById(R.id.button_fragment);



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

            myObjForDV.myClearScreen(myObjForLogic, myBitmapForClean,
                    myIVTopLeft,myIVTopCenter,myIVTopRight,
                    myIVCenterLeft,myIVCenter,myIVCenterRight,
                    myIVBottomLeft,myIVBottomCenter,myIVBottomRight);
            if (myRB1.isChecked()){
                //myHoldScreen();


                //while (myGameStage <= 9){
                while (myObjForDV.getMyGameStage() <= 9){
                    Log.d(LOG_TAG, "myPositionsForPlayer1 = " + Arrays.toString(myObjForDV.getMyPositionsForPlayer1()));
                    Log.d(LOG_TAG, "myPositionsForPlayer2 = " + Arrays.toString(myObjForDV.getMyPositionsForPlayer2()));
                    //if (myGameStage%2 == 1){
                    if (myObjForDV.getMyGameStage()%2 == 1){
                        ImageView myIV = (ImageView) findViewById(myObjForLogic.myPCsClickedButton(myObjForDV.getMyPositionsForPlayer1(), myObjForDV.getMyPositionsForPlayer2()));
                        myIV.performClick();
                    }else{
                        ImageView myIV = (ImageView) findViewById(myObjForLogic.myPCsClickedButton(myObjForDV.getMyPositionsForPlayer2(), myObjForDV.getMyPositionsForPlayer1()));
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
            myObjForDV.myClearScreen(myObjForLogic, myBitmapForClean,
                    myIVTopLeft,myIVTopCenter,myIVTopRight,
                    myIVCenterLeft,myIVCenter,myIVCenterRight,
                    myIVBottomLeft,myIVBottomCenter,myIVBottomRight);
            switch (checkedId){
                case R.id.rb1:


                    while (myObjForDV.getMyGameStage() <= 9){

                        Log.d(LOG_TAG, "myPositionsForPlayer1 = " + Arrays.toString(myObjForDV.getMyPositionsForPlayer1()));
                        Log.d(LOG_TAG, "myPositionsForPlayer2 = " + Arrays.toString(myObjForDV.getMyPositionsForPlayer2()));


                        if (myObjForDV.getMyGameStage()%2 == 1){

                            ImageView myIV = (ImageView) findViewById(myObjForLogic.myPCsClickedButton(myObjForDV.getMyPositionsForPlayer1(), myObjForDV.getMyPositionsForPlayer2()));
                            myIV.performClick();
                        }else{

                            ImageView myIV = (ImageView) findViewById(myObjForLogic.myPCsClickedButton(myObjForDV.getMyPositionsForPlayer2(), myObjForDV.getMyPositionsForPlayer1()));
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


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        myObjForSaveStatistics.loadSkin();
        switch (myObjForSaveStatistics.getSkin()){
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

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu, menu);
         return super.onCreateOptionsMenu(menu);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_reload:
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                return true;
            case R.id.menu_stat:
                ClassDialogStat myObjForDialogStat = new ClassDialogStat(this, this);
                myObjForDialogStat.openStatDialog();

                //openStatDialog();
                return true;
            case R.id.menu_stat_by_users:
                ClassDialogStatByUser myObjForDialogStatByUser = new ClassDialogStatByUser(this, this);
                myObjForDialogStatByUser.openStatDialog();

                //openStatDialog();
                return true;
            case R.id.menu_skin1:
                item.setChecked(!item.isChecked());
                //item.setEnabled(!item.isEnabled());
                myObjForSaveStatistics.saveSkin(1);
                Toast.makeText(this, "Перезагрузите приложение!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_skin2:
                item.setChecked(!item.isChecked());
                //item.setEnabled(!item.isEnabled());
                myObjForSaveStatistics.saveSkin(2);
                Toast.makeText(this, "Перезагрузите приложение!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_skin3:
                item.setChecked(!item.isChecked());
                //item.setEnabled(!item.isEnabled());
                myObjForSaveStatistics.saveSkin(3);
                Toast.makeText(this, "Перезагрузите приложение!", Toast.LENGTH_SHORT).show();
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
        Log.d(LOG_TAG,"---                       ---");
        //Log.d(LOG_TAG,"myGameStage = " + myGameStage);
        Log.d(LOG_TAG,"myGameStage = " + myObjForDV.getMyGameStage());
        Log.d(LOG_TAG,"IdAsString = " + IdAsString.substring(2));
        //if(myNowClickedButton == ""){
           // myNowClickedButton = IdAsString.substring(2);
       // }
        if(myObjForLogic.getMyNowClickedButton().equals("")){
            myObjForLogic.setMyNowClickedButton(IdAsString.substring(2));

        }

        if(myRB3.isChecked()){
            Log.d(LOG_TAG, "---myPlayerVsPlayer---");
            //myPlayerVsPlayer(myIV)

            myObjForDV.myPlayerVsPlayer(myIV,
                    myObjForLogic, myBitmapCross, myBitmapNought,
                    myIVTopLeft,myIVTopCenter,myIVTopRight,
                    myIVCenterLeft,myIVCenter,myIVCenterRight,
                    myIVBottomLeft,myIVBottomCenter,myIVBottomRight);
            return;
        }

        if(myRB2.isChecked()){
            Log.d(LOG_TAG, "---myPlayerVsPc---");
            //myPlayerVsPc(myIV);
            myObjForDV.myPlayerVsPc(myIV,
                    myObjForLogic, myBitmapCross, myBitmapNought,
                    myIVTopLeft,myIVTopCenter,myIVTopRight,
                    myIVCenterLeft,myIVCenter,myIVCenterRight,
                    myIVBottomLeft,myIVBottomCenter,myIVBottomRight);
            return;
        }



        if(myRB1.isChecked()){
            Log.d(LOG_TAG, "---myPcVsPc---");
            //new Handler(Looper.getMainLooper()).postDelayed(() -> {myPcVsPc(myIV);}, 500);
            //myPcVsPc(myIV);
            myObjForDV.myPcVsPc(myIV, myObjForLogic, myBitmapCross, myBitmapNought);
            return;
        }
    }

}
