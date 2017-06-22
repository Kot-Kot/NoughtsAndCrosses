package com.example.kot.noughtsandcrosses;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Kot Kot on 14.06.2017.
 */
//отвечает за разные варианты игры (PC vs PC, PC vs Player, Player vs Player)
public class ClassForDiffVariants implements InterfaceForDiffVariants {

    private Context myContext;
    private Activity myActivity;
    //final String LOG_TAG = "MY_LOG";
    private String[] myPositionsForPlayer1 = {"","","","",""};
    private String[] myPositionsForPlayer2 = {"","","","",""};

    //String myNowClickedButton = "";

    Integer myGameStage = 1;

    public String[] getMyPositionsForPlayer1() {
        return myPositionsForPlayer1;
    }

    public void setMyPositionsForPlayer1(String[] myPositionsForPlayer1) {
        this.myPositionsForPlayer1 = myPositionsForPlayer1;
    }

    public String[] getMyPositionsForPlayer2() {
        return myPositionsForPlayer2;
    }

    public void setMyPositionsForPlayer2(String[] myPositionsForPlayer2) {
        this.myPositionsForPlayer2 = myPositionsForPlayer2;
    }

    public Integer getMyGameStage() {
        return myGameStage;
    }

    public void setMyGameStage(Integer myGameStage) {
        this.myGameStage = myGameStage;
    }

    ClassForDiffVariants(Context c, Activity a) {
        //super(c);
        myContext = c;
        myActivity = a;
    }


    public void myPcVsPc(ImageView iv,
                         InterfaceForLogic myInterfaceForLogic,
                  Bitmap myBitmapCross, Bitmap myBitmapNought){
        // final ImageView fiv = iv;
        //final Bitmap fbc = myBitmapCross;
        // final Bitmap fbn = myBitmapNought;


        if (myGameStage%2 == 1) {

            //new Thread(myThread).start();
            //myPositionsForPlayer1[(myGameStage/2 + myGameStage%2)-1] = myNowClickedButton;
            //myNowClickedButton = "";
            myPositionsForPlayer1[(myGameStage/2 + myGameStage%2)-1] = myInterfaceForLogic.getMyNowClickedButton();
            myInterfaceForLogic.setMyNowClickedButton("");
            Log.d(LOG_TAG,"----Cross---- ");
            //myDelay(fiv,fbc);
            //new Thread(myThread).start();
            iv.setImageBitmap(myBitmapCross);
            //iv.setImageBitmap(myObjForCrossPicture.myDrawCross());

            iv.setClickable(false);
            myGameStage++;

            //if(isSomebodyWin(myPositionsForPlayer1)==true){
            if(myInterfaceForLogic.isSomebodyWin(myPositionsForPlayer1)){
                Log.d(LOG_TAG, "Выиграли крестики");
                Toast myToast = (Toast.makeText(myContext.getApplicationContext(), "Выиграли крестики", Toast.LENGTH_SHORT));
                myToast.show();
                //myHoldScreen();
            }else if(myGameStage == 10) {
                Log.d(LOG_TAG, "Ничья");
                Toast myToast = (Toast.makeText(myContext.getApplicationContext(), "Ничья", Toast.LENGTH_SHORT));
                myToast.show();
                // myHoldScreen();
            }


        }else{

            // new Thread(myThread).start();
            //myPositionsForPlayer2[(myGameStage/2 + myGameStage%2)-1] = myNowClickedButton;
            //myNowClickedButton = "";
            myPositionsForPlayer2[(myGameStage/2 + myGameStage%2)-1] = myInterfaceForLogic.getMyNowClickedButton();
            myInterfaceForLogic.setMyNowClickedButton("");
            Log.d(LOG_TAG,"----Naught---- ");
            //myDelay(fiv,fbn);
            iv.setImageBitmap(myBitmapNought);
            //iv.setImageBitmap(myObjForNoughtPicture.myDrawNought());
            iv.setClickable(false);
            myGameStage++;

            //if(isSomebodyWin(myPositionsForPlayer2)==true){
            if(myInterfaceForLogic.isSomebodyWin(myPositionsForPlayer2)){
                Log.d(LOG_TAG, "Выиграли нолики");
                Toast myToast = (Toast.makeText(myContext.getApplicationContext(), "Выиграли нолики", Toast.LENGTH_SHORT));
                myToast.show();
                //myHoldScreen();
            }

        }

        Log.d(LOG_TAG, "myGameStage++ myPcVsPc = " + myGameStage);
    }

   //----------------------------------------------------------------------

    public void myPlayerVsPc(ImageView iv,
                             InterfaceForLogic myInterfaceForLogic,
                             Bitmap myBitmapCross, Bitmap myBitmapNought,
                      ImageView iv1,
                      ImageView iv2,
                      ImageView iv3,
                      ImageView iv4,
                      ImageView iv5,
                      ImageView iv6,
                      ImageView iv7,
                      ImageView iv8,
                      ImageView iv9){
        if (myGameStage%2 == 1) {
            //myPositionsForPlayer1[(myGameStage/2 + myGameStage%2)-1] = myNowClickedButton;
            //myNowClickedButton = "";
            myPositionsForPlayer1[(myGameStage/2 + myGameStage%2)-1] = myInterfaceForLogic.getMyNowClickedButton();
            myInterfaceForLogic.setMyNowClickedButton("");
            Log.d(LOG_TAG,"----Cross---- ");
            iv.setImageBitmap(myBitmapCross);
            //iv.setImageBitmap(myObjForCrossPicture.myDrawCross());

            iv.setClickable(false);
            myGameStage++;

            //if(isSomebodyWin(myPositionsForPlayer1)==true){
            if(myInterfaceForLogic.isSomebodyWin(myPositionsForPlayer1)){
                Toast myToast = (Toast.makeText(myContext.getApplicationContext(), "Выиграл игрок", Toast.LENGTH_SHORT));
                myToast.show();
                myHoldScreen(myInterfaceForLogic, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9);
            }else if(myGameStage == 10){
                Toast myToast = (Toast.makeText(myContext.getApplicationContext(), "Ничья", Toast.LENGTH_SHORT));
                myToast.show();
                myHoldScreen(myInterfaceForLogic, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9);
            }else if (myGameStage < 9){
                //TextView myTV = (TextView) findViewById(myPCsClickedButton0(myPositionsForPlayer2,myPositionsForPlayer1));
                // myTV.performClick();
                //ImageView myIV = (ImageView) findViewById(myPCsClickedButton0(myPositionsForPlayer2,myPositionsForPlayer1));
                //Integer btnId = myContext.getResources().getIdentifier("iv"+myObjForLogic.myPCsClickedButton(myPositionsForPlayer2,myPositionsForPlayer1),"id",myContext.getPackageName());
                //ImageView myIV = (ImageView) findViewById(btnId);
                ImageView myIV = (ImageView) myActivity.findViewById(myInterfaceForLogic.myPCsClickedButton(myPositionsForPlayer2,myPositionsForPlayer1));
                myIV.performClick();
            }


        }else{


            //myPositionsForPlayer2[(myGameStage/2 + myGameStage%2)-1] = myNowClickedButton;
            //myNowClickedButton = "";
            myPositionsForPlayer2[(myGameStage/2 + myGameStage%2)-1] = myInterfaceForLogic.getMyNowClickedButton();
            myInterfaceForLogic.setMyNowClickedButton("");
            Log.d(LOG_TAG,"----Naught---- ");
            iv.setImageBitmap(myBitmapNought);
            //iv.setImageBitmap(myObjForNoughtPicture.myDrawNought());
            iv.setClickable(false);
            myGameStage++;

            //if(isSomebodyWin(myPositionsForPlayer2)==true) {
            if(myInterfaceForLogic.isSomebodyWin(myPositionsForPlayer2)) {
                Toast myToast = (Toast.makeText(myContext.getApplicationContext(), "Выиграл ПК", Toast.LENGTH_SHORT));
                myToast.show();
                myHoldScreen(myInterfaceForLogic, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9);

            }
        }
    }

    //------------------------------------------------------------


    public void myPlayerVsPlayer(ImageView iv,
                                 InterfaceForLogic myInterfaceForLogic,
                          Bitmap myBitmapCross, Bitmap myBitmapNought,
                          ImageView iv1,
                          ImageView iv2,
                          ImageView iv3,
                          ImageView iv4,
                          ImageView iv5,
                          ImageView iv6,
                          ImageView iv7,
                          ImageView iv8,
                          ImageView iv9){
        if (myGameStage%2 == 1) {
            //myPositionsForPlayer1[(myGameStage/2 + myGameStage%2)-1] = myNowClickedButton;
            //myNowClickedButton = "";
            myPositionsForPlayer1[(myGameStage/2 + myGameStage%2)-1] = myInterfaceForLogic.getMyNowClickedButton();
            myInterfaceForLogic.setMyNowClickedButton("");
            Log.d(LOG_TAG,"----Cross---- ");
            iv.setImageBitmap(myBitmapCross);
            //iv.setImageBitmap(myObjForCrossPicture.myDrawCross());
            iv.setClickable(false);
            myGameStage++;

            //if(isSomebodyWin(myPositionsForPlayer1)==true){
            if(myInterfaceForLogic.isSomebodyWin(myPositionsForPlayer1)){
                Toast myToast = (Toast.makeText(myContext.getApplicationContext(), "Выиграли крестики", Toast.LENGTH_SHORT));
                myToast.show();
                myHoldScreen(myInterfaceForLogic, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9);
            }else if(myGameStage == 10) {
                Toast myToast = (Toast.makeText(myContext.getApplicationContext(), "Ничья", Toast.LENGTH_SHORT));
                myToast.show();
                myHoldScreen(myInterfaceForLogic, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9);
            }


        }else{
            //myPositionsForPlayer2[(myGameStage/2 + myGameStage%2)-1] = myNowClickedButton;
            //myNowClickedButton = "";
            myPositionsForPlayer2[(myGameStage/2 + myGameStage%2)-1] = myInterfaceForLogic.getMyNowClickedButton();
            myInterfaceForLogic.setMyNowClickedButton("");
            Log.d(LOG_TAG,"----Naught---- ");
            iv.setImageBitmap(myBitmapNought);
            //iv.setImageBitmap(myObjForNoughtPicture.myDrawNought());

            iv.setClickable(false);
            myGameStage++;

            //if(isSomebodyWin(myPositionsForPlayer2)==true){
            if(myInterfaceForLogic.isSomebodyWin(myPositionsForPlayer2)){
                Toast myToast = (Toast.makeText(myContext.getApplicationContext(), "Выиграли нолики", Toast.LENGTH_SHORT));
                myToast.show();
                myHoldScreen(myInterfaceForLogic, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9);
            }
        }
    }



    public void myHoldScreen(InterfaceForLogic myInterfaceForLogic,
                      ImageView iv1,
                      ImageView iv2,
                      ImageView iv3,
                      ImageView iv4,
                      ImageView iv5,
                      ImageView iv6,
                      ImageView iv7,
                      ImageView iv8,
                      ImageView iv9){
        //myNowClickedButton = "";
        myInterfaceForLogic.setMyNowClickedButton("");
        myGameStage = 1;
        for (int i = 0; i <myPositionsForPlayer1.length; i++){
            myPositionsForPlayer1[i] = "";
            myPositionsForPlayer2[i] = "";
        }


        iv1.setClickable(false);
        iv2.setClickable(false);
        iv3.setClickable(false);
        iv4.setClickable(false);
        iv5.setClickable(false);
        iv6.setClickable(false);
        iv7.setClickable(false);
        iv8.setClickable(false);
        iv9.setClickable(false);
    }


    public void myClearScreen(InterfaceForLogic myInterfaceForLogic,
                       Bitmap myBitmapForClean,
                       ImageView iv1,
                       ImageView iv2,
                       ImageView iv3,
                       ImageView iv4,
                       ImageView iv5,
                       ImageView iv6,
                       ImageView iv7,
                       ImageView iv8,
                       ImageView iv9){

        //myNowClickedButton = "";
        myInterfaceForLogic.setMyNowClickedButton("");
        //myGameStage = 1;
        myGameStage = 1;
        for (int i = 0; i <myPositionsForPlayer1.length; i++){
            myPositionsForPlayer1[i] = "";
            myPositionsForPlayer2[i] = "";
        }

        iv1.setImageBitmap(myBitmapForClean);
        iv1.setClickable(true);

        iv2.setImageBitmap(myBitmapForClean);
        iv2.setClickable(true);

        iv3.setImageBitmap(myBitmapForClean);
        iv3.setClickable(true);

        iv4.setImageBitmap(myBitmapForClean);
        iv4.setClickable(true);

        iv5.setImageBitmap(myBitmapForClean);
        iv5.setClickable(true);

        iv6.setImageBitmap(myBitmapForClean);
        iv6.setClickable(true);

        iv7.setImageBitmap(myBitmapForClean);
        iv7.setClickable(true);

        iv8.setImageBitmap(myBitmapForClean);
        iv8.setClickable(true);

        iv9.setImageBitmap(myBitmapForClean);
        iv9.setClickable(true);

    }


}
