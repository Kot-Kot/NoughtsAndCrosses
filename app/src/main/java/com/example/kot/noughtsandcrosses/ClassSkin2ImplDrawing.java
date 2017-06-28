package com.example.kot.noughtsandcrosses;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;

/**
 * Created by Kot Kot on 12.06.2017.
 */

//отвечает за прорисовку bitmap
public class ClassSkin2ImplDrawing extends ClassSkin1ImplDrawing {


    ClassSkin2ImplDrawing(Context c) {
        super(c);
    }

    @Override
    public Paint myCreatePaint() {
        Paint myPaint = getMyPaint();
        myPaint.setColor(ContextCompat.getColor(getMyContext(), R.color.colorSkin2));
        myPaint.setStrokeWidth(3);
        myPaint.setStyle(Paint.Style.STROKE);

        return myPaint;
    }




}
