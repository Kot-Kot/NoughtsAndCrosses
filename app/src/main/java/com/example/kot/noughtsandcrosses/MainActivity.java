package com.example.kot.noughtsandcrosses;

import android.graphics.Bitmap;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioButton.OnCheckedChangeListener {
    static final String LOG_TAG = "MY_LOG";

    Button myClearScreen;

    RadioGroup myRG;

    RadioButton myRB1;
    RadioButton myRB2;
    RadioButton myRB3;

    myClassForLogic myObjectForLogic = new myClassForLogic(this);
    myClassForDiffVariants myObjectForDV = new myClassForDiffVariants(this, this);

    myClassForDrawing myNoughtPicture = new myClassForDrawing();
    myClassForDrawing myCrossPicture = new myClassForDrawing();
    myClassForDrawing myClearPicture = new myClassForDrawing();

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
        setContentView(R.layout.activity_main);

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.colorWhite));

        //myProgressBar = (ProgressBar)findViewById(R.id.progressBar);
        myRG = (RadioGroup) findViewById(R.id.rg);

        myRB1 = (RadioButton) findViewById(R.id.rb1);
        myRB2 = (RadioButton) findViewById(R.id.rb2);
        myRB3 = (RadioButton) findViewById(R.id.rb3);

        myClearScreen = (Button) findViewById(R.id.btnClear);


        myIVTopLeft = (ImageView) findViewById(R.id.ivTopLeft);
        myIVTopCenter = (ImageView)findViewById(R.id.ivTopCenter);
        myIVTopRight = (ImageView)findViewById(R.id.ivTopRight);
        myIVCenterLeft = (ImageView)findViewById(R.id.ivCenterLeft);
        myIVCenter = (ImageView)findViewById(R.id.ivCenter);
        myIVCenterRight = (ImageView)findViewById(R.id.ivCenterRight);
        myIVBottomLeft = (ImageView)findViewById(R.id.ivBottomLeft);
        myIVBottomCenter = (ImageView)findViewById(R.id.ivBottomCenter);
        myIVBottomRight = (ImageView)findViewById(R.id.ivBottomRight);


       // myRB1.setOnCheckedChangeListener(this);
       // myRB2.setOnCheckedChangeListener(this);
       // myRB3.setOnCheckedChangeListener(this);

        myClearScreen.setOnClickListener(v -> {
            //myClearScreen();
            myObjectForDV.myClearScreen(myObjectForLogic, myBitmapForClean,
                    myIVTopLeft,myIVTopCenter,myIVTopRight,
                    myIVCenterLeft,myIVCenter,myIVCenterRight,
                    myIVBottomLeft,myIVBottomCenter,myIVBottomRight);
            if (myRB1.isChecked()){
                //myHoldScreen();


                //while (myGameStage <= 9){
                while (myObjectForDV.myGameStage <= 9){
                    Log.d(LOG_TAG, "myPositionsForPlayer1 = " + Arrays.toString(myObjectForDV.myPositionsForPlayer1));
                    Log.d(LOG_TAG, "myPositionsForPlayer2 = " + Arrays.toString(myObjectForDV.myPositionsForPlayer2));
                    //if (myGameStage%2 == 1){
                    if (myObjectForDV.myGameStage%2 == 1){

                        //ImageView myIV = (ImageView) findViewById(myPCsClickedButton0(myPositionsForPlayer1,myPositionsForPlayer2));
                        //Integer btnId = getResources().getIdentifier("iv"+ myObjectForLogic.myPCsClickedButton(myPositionsForPlayer1,myPositionsForPlayer2),"id",getPackageName());
                        ImageView myIV = (ImageView) findViewById(myObjectForLogic.myPCsClickedButton(myObjectForDV.myPositionsForPlayer1,myObjectForDV.myPositionsForPlayer2));
                        myIV.performClick();
                    }else{

                        //ImageView myIV = (ImageView) findViewById(myPCsClickedButton0(myPositionsForPlayer2,myPositionsForPlayer1));
                        //Integer btnId = getResources().getIdentifier("iv"+ myObjectForLogic.myPCsClickedButton(myPositionsForPlayer2,myPositionsForPlayer1),"id",getPackageName());
                        ImageView myIV = (ImageView) findViewById(myObjectForLogic.myPCsClickedButton(myObjectForDV.myPositionsForPlayer2,myObjectForDV.myPositionsForPlayer1));
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
            myObjectForDV.myClearScreen(myObjectForLogic, myBitmapForClean,
                    myIVTopLeft,myIVTopCenter,myIVTopRight,
                    myIVCenterLeft,myIVCenter,myIVCenterRight,
                    myIVBottomLeft,myIVBottomCenter,myIVBottomRight);
            switch (checkedId){
                case R.id.rb1:

                    //while (myGameStage <= 9){
                    while (myObjectForDV.myGameStage <= 9){

                        Log.d(LOG_TAG, "myPositionsForPlayer1 = " + Arrays.toString(myObjectForDV.myPositionsForPlayer1));
                        Log.d(LOG_TAG, "myPositionsForPlayer2 = " + Arrays.toString(myObjectForDV.myPositionsForPlayer2));

                        //if (myGameStage%2 == 1){
                        if (myObjectForDV.myGameStage%2 == 1){

                            //ImageView myIV = (ImageView) findViewById(myPCsClickedButton0(myPositionsForPlayer1,myPositionsForPlayer2));
                            //Integer btnId = getResources().getIdentifier("iv"+ myObjectForLogic.myPCsClickedButton(myPositionsForPlayer1,myPositionsForPlayer2),"id",getPackageName());
                            ImageView myIV = (ImageView) findViewById(myObjectForLogic.myPCsClickedButton(myObjectForDV.myPositionsForPlayer1,myObjectForDV.myPositionsForPlayer2));
                            myIV.performClick();
                        }else{

                            //ImageView myIV = (ImageView) findViewById(myPCsClickedButton0(myPositionsForPlayer2,myPositionsForPlayer1));
                            //Integer btnId = getResources().getIdentifier("iv"+ myObjectForLogic.myPCsClickedButton(myPositionsForPlayer2,myPositionsForPlayer1),"id",getPackageName());
                            ImageView myIV = (ImageView) findViewById(myObjectForLogic.myPCsClickedButton(myObjectForDV.myPositionsForPlayer2,myObjectForDV.myPositionsForPlayer1));
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



        myBitmapCross = myNoughtPicture.myDrawCross();
        myBitmapNought = myCrossPicture.myDrawNought();
        myBitmapForClean = myClearPicture.myDrawClear();

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
        Log.d(LOG_TAG,"myGameStage = " + myObjectForDV.myGameStage);
        Log.d(LOG_TAG,"IdAsString = " + IdAsString.substring(2));
        //if(myNowClickedButton == ""){
           // myNowClickedButton = IdAsString.substring(2);
       // }
        if(myObjectForLogic.myNowClickedButton == ""){
            myObjectForLogic.myNowClickedButton = IdAsString.substring(2);
        }

        if(myRB3.isChecked() == true){
            Log.d(LOG_TAG, "---myPlayerVsPlayer---");
            //myPlayerVsPlayer(myIV);
            myObjectForDV.myPlayerVsPlayer(myIV,
                    myObjectForLogic, myBitmapCross, myBitmapNought,
                    myIVTopLeft,myIVTopCenter,myIVTopRight,
                    myIVCenterLeft,myIVCenter,myIVCenterRight,
                    myIVBottomLeft,myIVBottomCenter,myIVBottomRight);
            return;
        }

        if(myRB2.isChecked() == true){
            Log.d(LOG_TAG, "---myPlayerVsPc---");
            //myPlayerVsPc(myIV);
            myObjectForDV.myPlayerVsPc(myIV,
                    myObjectForLogic, myBitmapCross, myBitmapNought,
                    myIVTopLeft,myIVTopCenter,myIVTopRight,
                    myIVCenterLeft,myIVCenter,myIVCenterRight,
                    myIVBottomLeft,myIVBottomCenter,myIVBottomRight);
            return;
        }



        if(myRB1.isChecked() == true){
            Log.d(LOG_TAG, "---myPcVsPc---");
            //new Handler(Looper.getMainLooper()).postDelayed(() -> {myPcVsPc(myIV);}, 500);
            //myPcVsPc(myIV);
            myObjectForDV.myPcVsPc(myIV, myObjectForLogic, myBitmapCross, myBitmapNought);
            return;
        }
    }

}
