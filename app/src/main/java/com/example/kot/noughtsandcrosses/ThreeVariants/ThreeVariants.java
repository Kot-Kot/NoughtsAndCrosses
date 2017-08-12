package com.example.kot.noughtsandcrosses.ThreeVariants;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.kot.noughtsandcrosses.Logic.PCLogic;

/**
 * Created by Kot Kot on 15.06.2017.
 */

public interface ThreeVariants {
    //String LOG_TAG = "MY_LOG";


    String[] getMyPositionsForPlayer1();
    void setMyPositionsForPlayer1(String[] myPositionsForPlayer1);

    String[] getMyPositionsForPlayer2();
    void setMyPositionsForPlayer2(String[] myPositionsForPlayer2);

    int getMyGameStage();
    void setMyGameStage(Integer myGameStage);

    void myPcVsPc(ImageView iv,
                  PCLogic myInterfaceForLogic,
                  Bitmap myBitmapCross, Bitmap myBitmapNought);

    void myPlayerVsPc(ImageView iv,
                      PCLogic myInterfaceForLogic,
                      Bitmap myBitmapCross, Bitmap myBitmapNought,
                      ImageView iv1,
                      ImageView iv2,
                      ImageView iv3,
                      ImageView iv4,
                      ImageView iv5,
                      ImageView iv6,
                      ImageView iv7,
                      ImageView iv8,
                      ImageView iv9);

    void myPlayerVsPlayer(ImageView iv,
                          PCLogic myInterfaceForLogic,
                          Bitmap myBitmapCross, Bitmap myBitmapNought,
                          ImageView iv1,
                          ImageView iv2,
                          ImageView iv3,
                          ImageView iv4,
                          ImageView iv5,
                          ImageView iv6,
                          ImageView iv7,
                          ImageView iv8,
                          ImageView iv9);

    void myHoldScreen(PCLogic myInterfaceForLogic,
                      ImageView iv1,
                      ImageView iv2,
                      ImageView iv3,
                      ImageView iv4,
                      ImageView iv5,
                      ImageView iv6,
                      ImageView iv7,
                      ImageView iv8,
                      ImageView iv9);

    void myClearScreen(PCLogic myInterfaceForLogic,
                       Bitmap myBitmapForClean,
                       ImageView iv1,
                       ImageView iv2,
                       ImageView iv3,
                       ImageView iv4,
                       ImageView iv5,
                       ImageView iv6,
                       ImageView iv7,
                       ImageView iv8,
                       ImageView iv9);
}
