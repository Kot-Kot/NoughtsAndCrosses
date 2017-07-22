package com.example.kot.noughtsandcrosses.Drawing;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;

import com.example.kot.noughtsandcrosses.R;

/**
 * Created by Kot Kot on 12.06.2017.
 */

//отвечает за прорисовку bitmap
public class Skin2ImplDrawing extends Skin1ImplDrawing {


    public Skin2ImplDrawing(Context c) {
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
