package com.example.kot.noughtsandcrosses.Drawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Kot Kot on 12.06.2017.
 */

public interface Drawing {
    Paint getMyPaint();
    Context getMyContext();

    Paint myCreatePaint();

    Bitmap myDrawNought();
    Bitmap myDrawCross();
    Bitmap myDrawClear();




}
