package com.example.kot.noughtsandcrosses;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Kot Kot on 15.06.2017.
 */

public interface myInterfaceForDiffVariants {
    String LOG_TAG = "MY_LOG";

    void myPcVsPc(ImageView iv,
                  myClassForLogic myObjectForLogic,
                  Bitmap myBitmapCross, Bitmap myBitmapNought);

    void myPlayerVsPc(ImageView iv,
                      myClassForLogic myObjectForLogic,
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
                          myClassForLogic myObjectForLogic,
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
}
