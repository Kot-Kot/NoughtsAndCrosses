package com.example.kot.noughtsandcrosses;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
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

    InterfaceForLogic myObjForLogic = new ClassForLogic(this);
    InterfaceForDiffVariants myObjForDV = new ClassForDiffVariants(this, this);

    InterfaceForDrawing myObjForNoughtPicture = new ClassForDrawing();
    InterfaceForDrawing myObjForCrossPicture = new ClassForDrawing();
    InterfaceForDrawing myObjForClearPicture = new ClassForDrawing();

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

                        //ImageView myIV = (ImageView) findViewById(myPCsClickedButton0(myPositionsForPlayer1,myPositionsForPlayer2));
                        //Integer btnId = getResources().getIdentifier("iv"+ myObjForLogic.myPCsClickedButton(myPositionsForPlayer1,myPositionsForPlayer2),"id",getPackageName());
                        ImageView myIV = (ImageView) findViewById(myObjForLogic.myPCsClickedButton(myObjForDV.getMyPositionsForPlayer1(), myObjForDV.getMyPositionsForPlayer2()));
                        myIV.performClick();
                    }else{

                        //ImageView myIV = (ImageView) findViewById(myPCsClickedButton0(myPositionsForPlayer2,myPositionsForPlayer1));
                        //Integer btnId = getResources().getIdentifier("iv"+ myObjForLogic.myPCsClickedButton(myPositionsForPlayer2,myPositionsForPlayer1),"id",getPackageName());
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

                    //while (myGameStage <= 9){
                    while (myObjForDV.getMyGameStage() <= 9){

                        Log.d(LOG_TAG, "myPositionsForPlayer1 = " + Arrays.toString(myObjForDV.getMyPositionsForPlayer1()));
                        Log.d(LOG_TAG, "myPositionsForPlayer2 = " + Arrays.toString(myObjForDV.getMyPositionsForPlayer2()));

                        //if (myGameStage%2 == 1){
                        if (myObjForDV.getMyGameStage()%2 == 1){

                            //ImageView myIV = (ImageView) findViewById(myPCsClickedButton0(myPositionsForPlayer1,myPositionsForPlayer2));
                            //Integer btnId = getResources().getIdentifier("iv"+ myObjForLogic.myPCsClickedButton(myPositionsForPlayer1,myPositionsForPlayer2),"id",getPackageName());
                            ImageView myIV = (ImageView) findViewById(myObjForLogic.myPCsClickedButton(myObjForDV.getMyPositionsForPlayer1(), myObjForDV.getMyPositionsForPlayer2()));
                            myIV.performClick();
                        }else{

                            //ImageView myIV = (ImageView) findViewById(myPCsClickedButton0(myPositionsForPlayer2,myPositionsForPlayer1));
                            //Integer btnId = getResources().getIdentifier("iv"+ myObjForLogic.myPCsClickedButton(myPositionsForPlayer2,myPositionsForPlayer1),"id",getPackageName());
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
