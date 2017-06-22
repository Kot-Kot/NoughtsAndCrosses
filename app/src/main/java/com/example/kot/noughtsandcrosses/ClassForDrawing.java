package com.example.kot.noughtsandcrosses;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Kot Kot on 12.06.2017.
 */

//отвечает за прорисовку bitmap
public class ClassForDrawing implements InterfaceForDrawing {

    Bitmap myBitmap = Bitmap.createBitmap(50,50, Bitmap.Config.ARGB_8888);
    Canvas myCanvas = new Canvas(myBitmap);
    Paint myPaint = new Paint(Paint.ANTI_ALIAS_FLAG);



    @Override
    public Paint myCreatePaint() {

        myPaint.setColor(Color.BLUE);
        myPaint.setStrokeWidth(3);
        myPaint.setStyle(Paint.Style.STROKE);

        return myPaint;
    }

    @Override
    public Bitmap myDrawNought() {

        myCanvas.drawCircle(myCanvas.getWidth()/2,myCanvas.getWidth()/2,myCanvas.getWidth()/2 - 7, myCreatePaint());
        return myBitmap;


    }

    @Override
    public Bitmap myDrawCross() {


        myCanvas.drawLine(7,7,myCanvas.getWidth()-7,myCanvas.getHeight()-7,myCreatePaint());
        myCanvas.drawLine(myCanvas.getWidth()-7,7,7,myCanvas.getHeight()-7,myCreatePaint());
        return myBitmap;

    }

    @Override
    public Bitmap myDrawClear() {
        myCanvas.drawColor(Color.WHITE);
        return myBitmap;

    }


}
