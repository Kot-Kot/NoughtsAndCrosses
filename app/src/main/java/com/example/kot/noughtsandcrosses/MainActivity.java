package com.example.kot.noughtsandcrosses;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Message;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioButton.OnCheckedChangeListener {
    static final String LOG_TAG = "MY_LOG";
    static final String Cross = "X";
    static final String Naught = "O";
    static final String FirstPos = "Center";
    static final String[] SecondPos = {"TopLeft","TopRight","BottomLeft","BottomRight"};
    static final String[] ThirdPos = {"TopCenter","CenterLeft","CenterRight","BottomCenter"};

    final int STATUS_START = 0;
    final int STATUS_END = 1;



    ImageView myIV;
    Button myClearScreen;

    RadioGroup myRG;

    RadioButton myRB1;
    RadioButton myRB2;
    RadioButton myRB3;

    Bitmap myBitmapCross;
    Bitmap myBitmapNought;
    Canvas myCanvasCross;
    Canvas myCanvasNought;
    Bitmap myBitmapForClean;
    Canvas myCanvasForClean;

    ImageView myIVTopLeft;
    ImageView myIVTopCenter;
    ImageView myIVTopRight;
    ImageView myIVCenterLeft;
    ImageView myIVCenter;
    ImageView myIVCenterRight;
    ImageView myIVBottomLeft;
    ImageView myIVBottomCenter;
    ImageView myIVBottomRight;

    Handler myHandler = new Handler();
    ProgressBar myProgressBar;
    int myProgress = 0;




    String[] myPositions = {"TopLeft","TopCenter","TopRight",
            "CenterLeft","Center","CenterRight",
            "BottomLeft","BottomCenter","BottomRight"};


    String[][] myWinningCombinations = {{"TopLeft","TopCenter","TopRight"},
            {"CenterLeft","Center","CenterRight"},
            {"BottomLeft","BottomCenter","BottomRight"},

            {"TopLeft","CenterLeft","BottomLeft"},
            {"TopCenter","Center","BottomCenter"},
            {"TopRight","CenterRight","BottomRight"},

            {"TopLeft","Center","BottomRight"},
            {"TopRight","Center","BottomLeft"}};

    String[] myOccupiedPositions = new String[9];
    //String[] myPositionsForPlayer1 = new String[5];
    String[] myPositionsForPlayer1 = {"","","","",""};
    String[] myPositionsForPlayer2 = {"","","","",""};

    String myNowClickedButton = "";

    Integer myGameStage = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myProgressBar = (ProgressBar)findViewById(R.id.progressBar);

        //myIV = (ImageView)findViewById(R.id.iv);
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

        myIVTopLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //myTVTopLeft.setText("performClick");
            }
        });

       // myRB1.setOnCheckedChangeListener(this);
       // myRB2.setOnCheckedChangeListener(this);
       // myRB3.setOnCheckedChangeListener(this);

        myClearScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClearScreen();
                if (myRB1.isChecked()){
                    //myHoldScreen();


                    while (myGameStage <= 9){
                        Log.d(LOG_TAG, "myPositionsForPlayer1 = " + Arrays.toString(myPositionsForPlayer1));
                        Log.d(LOG_TAG, "myPositionsForPlayer2 = " + Arrays.toString(myPositionsForPlayer2));
                        if (myGameStage%2 == 1){
                            ImageView myIV = (ImageView) findViewById(myClickedButton(myPositionsForPlayer1,myPositionsForPlayer2));
                            myIV.performClick();
                        }else{
                            ImageView myIV = (ImageView) findViewById(myClickedButton(myPositionsForPlayer2,myPositionsForPlayer1));
                            myIV.performClick();
                        }
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





        myRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                myClearScreen();
                switch (checkedId){
                    case R.id.rb1:

                        while (myGameStage <= 9){

                            Log.d(LOG_TAG, "myPositionsForPlayer1 = " + Arrays.toString(myPositionsForPlayer1));
                            Log.d(LOG_TAG, "myPositionsForPlayer2 = " + Arrays.toString(myPositionsForPlayer2));

                            if (myGameStage%2 == 1){

                                ImageView myIV = (ImageView) findViewById(myClickedButton(myPositionsForPlayer1,myPositionsForPlayer2));
                                myIV.performClick();
                            }else{

                                ImageView myIV = (ImageView) findViewById(myClickedButton(myPositionsForPlayer2,myPositionsForPlayer1));
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
            }
        });

        myBitmapCross = Bitmap.createBitmap(50,50, Bitmap.Config.ARGB_8888);
        myBitmapNought = Bitmap.createBitmap(50,50, Bitmap.Config.ARGB_8888);
        myBitmapForClean = Bitmap.createBitmap(50,50, Bitmap.Config.ARGB_8888);

        myCanvasCross = new Canvas(myBitmapCross);
        myCanvasNought = new Canvas(myBitmapNought);
        myCanvasForClean = new Canvas(myBitmapForClean);

        Paint myPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        myPaint.setColor(Color.BLUE);
        myPaint.setStrokeWidth(3);
        myPaint.setStyle(Paint.Style.STROKE);


        myCanvasNought.drawCircle(myCanvasNought.getWidth()/2,myCanvasNought.getWidth()/2,myCanvasNought.getWidth()/2 - 7,myPaint);

        // ivTopLeft.setImageBitmap(myBitmap);


        myCanvasCross.drawLine(7,7,myCanvasCross.getWidth()-7,myCanvasCross.getHeight()-7,myPaint);
        myCanvasCross.drawLine(myCanvasCross.getWidth()-7,7,7,myCanvasCross.getHeight()-7,myPaint);

        myCanvasForClean.drawColor(Color.WHITE);

        // ivTopCenter.setImageBitmap(myBitmap1);
        // ivTopRight.setImageBitmap(myBitmap1);
    }


/*
    class DrawView extends View{

        public DrawView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.GREEN);
        }
    }
*/
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
        Log.d(LOG_TAG,"myGameStage = " + myGameStage);
        Log.d(LOG_TAG,"IdAsString = " + IdAsString.substring(2));
        if(myNowClickedButton == ""){
            myNowClickedButton = IdAsString.substring(2);
        }

        if(myRB3.isChecked() == true){
            Log.d(LOG_TAG, "---myPlayerVsPlayer---");
            myPlayerVsPlayer(myIV);
            return;
        }

        if(myRB2.isChecked() == true){
            Log.d(LOG_TAG, "---myPlayerVsPc---");
            myPlayerVsPc(myIV);
            return;
        }



        if(myRB1.isChecked() == true){
            Log.d(LOG_TAG, "---myPcVsPc---");
            myPcVsPc(myIV);
            return;
        }




        //switch (v.getId()){
           // case R.id.tvTopLeft:
              //  myTVTopLeft.setText("performClick");
               // break;

        //}

    }

    String myLastRun(String[] rivalPositions){
        int number;
        String neededPos = "";

        for (int i=0; i < myWinningCombinations.length; i++){

            number = 0;
            int[] pos = {0,0,0};
            for(int j = 0; j < 3; j++){
                for (int k = 0; k < 5; k++){
                    if(myWinningCombinations[i][j].equalsIgnoreCase(rivalPositions[k])){
                        //Log.d(LOG_TAG, "myWinningCombinations[i][j] =" + myWinningCombinations[i][j]);
                        //Log.d(LOG_TAG, "rivalPositions[k] =" + rivalPositions[k]);
                        //Log.d(LOG_TAG, "---                   ---");
                        number++;
                        pos[j] = 1;
                        if (number == 2){
                            Log.d(LOG_TAG, "i = " + i);
                            Log.d(LOG_TAG, "pos[] = " + Arrays.toString(pos));
                            for(int p = 0; p < pos.length; p++){
                                if (pos[p]==0){
                                    neededPos = myWinningCombinations[i][p];
                                    //break;
                                    return neededPos;
                                }

                            }

                        }
                    }
                }

            }


        }
        return neededPos;
    }

    Integer myClickedButton(String[] strPos, String[] strPosRival){
        Integer btnId = 0;
        String tempStr = FirstPos;

        int number;

        for (int i=0; i < myWinningCombinations.length; i++){

            number = 0;
            int[] pos = {0,0,0};
            for(int j = 0; j < 3; j++){
                for (int k = 0; k < 5; k++){
                    if(myWinningCombinations[i][j].equalsIgnoreCase(strPos[k])){
                        //Log.d(LOG_TAG, "myWinningCombinations[i][j] =" + myWinningCombinations[i][j]);
                        //Log.d(LOG_TAG, "rivalPositions[k] =" + rivalPositions[k]);
                        //Log.d(LOG_TAG, "---                   ---");
                        number++;
                        pos[j] = 1;
                        if (number == 2){
                            //Log.d(LOG_TAG, "i = " + i);
                            //Log.d(LOG_TAG, "pos[] = " + Arrays.toString(pos));
                            for(int p = 0; p < pos.length; p++){
                                if (pos[p]==0 & isPosInArray(myWinningCombinations[i][p],strPosRival) == false){
                                    tempStr = myWinningCombinations[i][p];
                                    myNowClickedButton = tempStr;
                                    btnId = getResources().getIdentifier("iv"+tempStr,"id",getPackageName());
                                    // Log.d(LOG_TAG, "btnId = " + btnId);
                                    return  btnId;
                                    //break;

                                }

                            }

                        }
                    }
                }

            }


        }


        for (int i=0; i < myWinningCombinations.length; i++){

            number = 0;
            int[] pos = {0,0,0};
            for(int j = 0; j < 3; j++){
                for (int k = 0; k < 5; k++){
                    if(myWinningCombinations[i][j].equalsIgnoreCase(strPosRival[k])){
                        //Log.d(LOG_TAG, "myWinningCombinations[i][j] =" + myWinningCombinations[i][j]);
                        //Log.d(LOG_TAG, "rivalPositions[k] =" + rivalPositions[k]);
                        //Log.d(LOG_TAG, "---                   ---");
                        number++;
                        pos[j] = 1;
                        if (number == 2){
                            //Log.d(LOG_TAG, "i = " + i);
                            //Log.d(LOG_TAG, "pos[] = " + Arrays.toString(pos));
                            for(int p = 0; p < pos.length; p++){
                                if (pos[p]==0 & isPosInArray(myWinningCombinations[i][p],strPos) == false){
                                    tempStr = myWinningCombinations[i][p];
                                    myNowClickedButton = tempStr;
                                    btnId = getResources().getIdentifier("iv"+tempStr,"id",getPackageName());
                                    // Log.d(LOG_TAG, "btnId = " + btnId);
                                    return  btnId;
                                    //break;

                                }

                            }

                        }
                    }
                }

            }


        }






        for (int i = 0; i < strPos.length; i++){
            if (tempStr.equalsIgnoreCase(strPos[i]) || tempStr.equalsIgnoreCase(strPosRival[i])){
                //Log.d(LOG_TAG, "tempStr.equalsIgnoreCase(strPos[i]) || tempStr.equalsIgnoreCase(strPosRival[i]) , i = " +i);
                break;
            }else if(i==4){
                myNowClickedButton = tempStr;
                btnId = getResources().getIdentifier("iv"+tempStr,"id",getPackageName());
               // Log.d(LOG_TAG, "btnId = " + btnId);
                return  btnId;
            }
        }

        String[] tempSecondPos = new String[SecondPos.length];
        for (int k = 0; k < SecondPos.length; k++){
            for (int i = 0; i < strPos.length; i++){
                if (SecondPos[k].equalsIgnoreCase(strPos[i]) || SecondPos[k].equalsIgnoreCase(strPosRival[i])){
                    break;
                }else if (i==4){
                    tempSecondPos[k] = SecondPos[k];
                }
            }
        }
        Log.d(LOG_TAG, " tempSecondPos[] = " + Arrays.toString(tempSecondPos));
        for (String s : tempSecondPos){
            if(s != null){
                Log.d(LOG_TAG, " tempSecondPos[] = " + Arrays.toString(tempSecondPos));
                do{
                    tempStr = tempSecondPos[(int)(Math.random()*tempSecondPos.length)];
                }while (tempStr == null);
                myNowClickedButton = tempStr;
                btnId = getResources().getIdentifier("iv"+tempStr,"id",getPackageName());
                return btnId;
            }

        }

        String[] tempThirdPos = new String[ThirdPos.length];
        for (int k = 0; k < ThirdPos.length; k++){
            for (int i = 0; i < strPos.length; i++){
                if (ThirdPos[k].equalsIgnoreCase(strPos[i]) || ThirdPos[k].equalsIgnoreCase(strPosRival[i])){
                    break;
                }else if (i==4){
                    tempThirdPos[k] = ThirdPos[k];
                }
            }
        }
        Log.d(LOG_TAG, " tempThirdPos[] = " + Arrays.toString(tempThirdPos));
        for (String s : tempThirdPos){
            if(s != null){
                Log.d(LOG_TAG, " tempThirdPos[] = " + Arrays.toString(tempThirdPos));
                do{
                    tempStr = tempThirdPos[(int)(Math.random()*tempThirdPos.length)];
                }while (tempStr == null);
                myNowClickedButton = tempStr;
                btnId = getResources().getIdentifier("iv"+tempStr,"id",getPackageName());
                return btnId;
            }

        }


/*
        for (int j = 0; j < strPos.length; j++){
            for (int k = 0; k < SecondPos.length; k++){


            }
            do{
                tempStr = SecondPos[(int)(Math.random()*SecondPos.length)];
            }while (tempStr.equalsIgnoreCase(strPos[j]) || tempStr.equalsIgnoreCase(strPosRival[j]));
        }

*/
        myNowClickedButton = tempStr;
        Log.d(LOG_TAG, " btnId = " + btnId);
        return btnId;


    }

    Boolean isPosInArray(String pos, String[] posArray){
        for (int i=0; i<posArray.length;i++){
            if (posArray[i].equalsIgnoreCase(pos)){
                return true;
            }
        }
        return false;
    }


    void myHoldScreen(){

        myNowClickedButton = "";
        myGameStage = 1;
        for (int i = 0; i <myPositionsForPlayer1.length; i++){
            myPositionsForPlayer1[i] = "";
            myPositionsForPlayer2[i] = "";
        }


        myIVTopLeft.setClickable(false);

        myIVTopCenter.setClickable(false);

        myIVTopRight.setClickable(false);

        myIVCenterLeft.setClickable(false);

        myIVCenter.setClickable(false);

        myIVCenterRight.setClickable(false);

        myIVBottomLeft.setClickable(false);

        myIVBottomCenter.setClickable(false);

        myIVBottomRight.setClickable(false);

    }


    void myClearScreen(){

        myNowClickedButton = "";
        myGameStage = 1;
        for (int i = 0; i <myPositionsForPlayer1.length; i++){
            myPositionsForPlayer1[i] = "";
            myPositionsForPlayer2[i] = "";
        }






        myIVTopLeft.setImageBitmap(myBitmapForClean);
        myIVTopLeft.setClickable(true);

        myIVTopCenter.setImageBitmap(myBitmapForClean);
        myIVTopCenter.setClickable(true);

        myIVTopRight.setImageBitmap(myBitmapForClean);
        myIVTopRight.setClickable(true);

        myIVCenterLeft.setImageBitmap(myBitmapForClean);
        myIVCenterLeft.setClickable(true);

        myIVCenter.setImageBitmap(myBitmapForClean);
        myIVCenter.setClickable(true);

        myIVCenterRight.setImageBitmap(myBitmapForClean);
        myIVCenterRight.setClickable(true);

        myIVBottomLeft.setImageBitmap(myBitmapForClean);
        myIVBottomLeft.setClickable(true);

        myIVBottomCenter.setImageBitmap(myBitmapForClean);
        myIVBottomCenter.setClickable(true);

        myIVBottomRight.setImageBitmap(myBitmapForClean);
        myIVBottomRight.setClickable(true);

    }

    void myPlayerVsPlayer(ImageView iv){
        if (myGameStage%2 == 1) {
            myPositionsForPlayer1[(myGameStage/2 + myGameStage%2)-1] = myNowClickedButton;
            myNowClickedButton = "";
            Log.d(LOG_TAG,"----Cross---- ");
            iv.setImageBitmap(myBitmapCross);
            iv.setClickable(false);
            myGameStage++;

            if(isSomebodyWin(myPositionsForPlayer1)==true){
                Toast myToast = (Toast.makeText(this, "Выиграли крестики", Toast.LENGTH_SHORT));
                myToast.show();
                myHoldScreen();
            }else if(myGameStage == 10) {
                Toast myToast = (Toast.makeText(this, "Ничья", Toast.LENGTH_SHORT));
                myToast.show();
                myHoldScreen();
            }


        }else{
            myPositionsForPlayer2[(myGameStage/2 + myGameStage%2)-1] = myNowClickedButton;
            myNowClickedButton = "";
            Log.d(LOG_TAG,"----Naught---- ");
            iv.setImageBitmap(myBitmapNought);
            iv.setClickable(false);
            myGameStage++;

            if(isSomebodyWin(myPositionsForPlayer2)==true){
                Toast myToast = (Toast.makeText(this, "Выиграли нолики", Toast.LENGTH_SHORT));
                myToast.show();
                myHoldScreen();
            }
        }
    }



    void myPlayerVsPc(ImageView iv){
        if (myGameStage%2 == 1) {
            myPositionsForPlayer1[(myGameStage/2 + myGameStage%2)-1] = myNowClickedButton;
            myNowClickedButton = "";
            Log.d(LOG_TAG,"----Cross---- ");
            iv.setImageBitmap(myBitmapCross);
            iv.setClickable(false);
            myGameStage++;

            if(isSomebodyWin(myPositionsForPlayer1)==true){
                Toast myToast = (Toast.makeText(this, "Выиграл игрок", Toast.LENGTH_SHORT));
                myToast.show();
                myHoldScreen();
            }else if(myGameStage == 10){
                Toast myToast = (Toast.makeText(this, "Ничья", Toast.LENGTH_SHORT));
                myToast.show();
                myHoldScreen();
            }else if (myGameStage < 9){
                //TextView myTV = (TextView) findViewById(myClickedButton(myPositionsForPlayer2,myPositionsForPlayer1));
               // myTV.performClick();
                ImageView myIV = (ImageView) findViewById(myClickedButton(myPositionsForPlayer2,myPositionsForPlayer1));
                myIV.performClick();
            }


        }else{


            myPositionsForPlayer2[(myGameStage/2 + myGameStage%2)-1] = myNowClickedButton;
            myNowClickedButton = "";
            Log.d(LOG_TAG,"----Naught---- ");
            iv.setImageBitmap(myBitmapNought);
            iv.setClickable(false);
            myGameStage++;

            if(isSomebodyWin(myPositionsForPlayer2)==true) {
                Toast myToast = (Toast.makeText(this, "Выиграл ПК", Toast.LENGTH_SHORT));
                myToast.show();
                myHoldScreen();
                myHoldScreen();
            }
        }
    }

    void myPcVsPc(ImageView iv){
       // final ImageView fiv = iv;
        //final Bitmap fbc = myBitmapCross;
       // final Bitmap fbn = myBitmapNought;


        if (myGameStage%2 == 1) {

            //new Thread(myThread).start();
            myPositionsForPlayer1[(myGameStage/2 + myGameStage%2)-1] = myNowClickedButton;
            myNowClickedButton = "";
            Log.d(LOG_TAG,"----Cross---- ");
            //myDelay(fiv,fbc);
            //new Thread(myThread).start();
            iv.setImageBitmap(myBitmapCross);
            iv.setClickable(false);
            myGameStage++;

            if(isSomebodyWin(myPositionsForPlayer1)==true){
                Log.d(LOG_TAG, "Выиграли крестики");
                Toast myToast = (Toast.makeText(this, "Выиграли крестики", Toast.LENGTH_SHORT));
                myToast.show();
                //myHoldScreen();
            }else if(myGameStage == 10) {
                Log.d(LOG_TAG, "Ничья");
                Toast myToast = (Toast.makeText(this, "Ничья", Toast.LENGTH_SHORT));
                myToast.show();
               // myHoldScreen();
            }


        }else{

            // new Thread(myThread).start();
            myPositionsForPlayer2[(myGameStage/2 + myGameStage%2)-1] = myNowClickedButton;
            myNowClickedButton = "";
            Log.d(LOG_TAG,"----Naught---- ");
            //myDelay(fiv,fbn);
            iv.setImageBitmap(myBitmapNought);
            iv.setClickable(false);
            myGameStage++;

            if(isSomebodyWin(myPositionsForPlayer2)==true){
                Log.d(LOG_TAG, "Выиграли нолики");
                Toast myToast = (Toast.makeText(this, "Выиграли нолики", Toast.LENGTH_SHORT));
                myToast.show();
                //myHoldScreen();
            }

        }

        Log.d(LOG_TAG, "myGameStage++ myPcVsPc = " + myGameStage);
    }



    Boolean isSomebodyWin(String[] strPos) {

        //Integer btnId = 0;
        //String tempStr = FirstPos;

        int number;

        for (int i=0; i < myWinningCombinations.length; i++){

            number = 0;
            int[] pos = {0,0,0};
            for(int j = 0; j < 3; j++){
                for (int k = 0; k < 5; k++){
                    if(myWinningCombinations[i][j].equalsIgnoreCase(strPos[k])){
                        //Log.d(LOG_TAG, "myWinningCombinations[i][j] =" + myWinningCombinations[i][j]);
                        //Log.d(LOG_TAG, "rivalPositions[k] =" + rivalPositions[k]);
                        //Log.d(LOG_TAG, "---                   ---");
                        number++;
                        //pos[j] = 1;
                        if (number == 3){
                           return true;
                        }
                    }
                }

            }


        }


        return false;
    }


}
