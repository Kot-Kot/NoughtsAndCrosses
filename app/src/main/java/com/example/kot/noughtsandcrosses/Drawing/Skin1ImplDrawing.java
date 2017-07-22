package com.example.kot.noughtsandcrosses.Drawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;

import com.example.kot.noughtsandcrosses.Drawing.Drawing;
import com.example.kot.noughtsandcrosses.R;

/**
 * Created by Kot Kot on 12.06.2017.
 */

//отвечает за прорисовку bitmap
public class Skin1ImplDrawing implements Drawing {

    private Bitmap myBitmap = Bitmap.createBitmap(50,50, Bitmap.Config.ARGB_8888);
    private Canvas myCanvas = new Canvas(myBitmap);
    private Paint myPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


    private Context myContext;

    @Override
    public Paint getMyPaint() {
        return myPaint;
    }

    @Override
    public Context getMyContext() {
        return myContext;
    }

    public Skin1ImplDrawing(Context c) {
        myContext = c;
    }



    @Override
    public Paint myCreatePaint() {

        myPaint.setColor(ContextCompat.getColor(myContext, R.color.colorSkin1));
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
