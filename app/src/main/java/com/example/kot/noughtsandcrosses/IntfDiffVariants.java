package com.example.kot.noughtsandcrosses;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Kot Kot on 15.06.2017.
 */

public interface IntfDiffVariants {
    String LOG_TAG = "MY_LOG";


    String[] getMyPositionsForPlayer1();
    void setMyPositionsForPlayer1(String[] myPositionsForPlayer1);

    String[] getMyPositionsForPlayer2();
    void setMyPositionsForPlayer2(String[] myPositionsForPlayer2);

    Integer getMyGameStage() ;
    void setMyGameStage(Integer myGameStage);

    void myPcVsPc(ImageView iv,
                  IntfLogic myInterfaceForLogic,
                  Bitmap myBitmapCross, Bitmap myBitmapNought);

    void myPlayerVsPc(ImageView iv,
                      IntfLogic myInterfaceForLogic,
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
                          IntfLogic myInterfaceForLogic,
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

    void myHoldScreen(IntfLogic myInterfaceForLogic,
                      ImageView iv1,
                      ImageView iv2,
                      ImageView iv3,
                      ImageView iv4,
                      ImageView iv5,
                      ImageView iv6,
                      ImageView iv7,
                      ImageView iv8,
                      ImageView iv9);

    void myClearScreen(IntfLogic myInterfaceForLogic,
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
