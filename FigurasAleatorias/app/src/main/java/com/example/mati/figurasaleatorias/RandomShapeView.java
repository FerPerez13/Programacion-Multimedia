package com.example.mati.figurasaleatorias;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import javax.xml.validation.ValidatorHandler;

/**
 * Created by mati on 9/11/16.
 */
public class RandomShapeView extends View {
    private Integer[] backgrounds = {Color.CYAN, Color.GRAY, Color.LTGRAY, Color.MAGENTA, Color.YELLOW, Color.WHITE};
    private Paint[] paints = {makePaint(Color.BLACK), makePaint(Color.BLUE), makePaint(Color.GREEN), makePaint(Color.RED)};
    private Bitmap[] pics = {makeBitmap(R.drawable.img1), makeBitmap(R.drawable.img2), makeBitmap(R.drawable.img3), makeBitmap(R.drawable.img4), makeBitmap(R.drawable.img5)};
    private String mensaje = "Braum";

    public RandomShapeView(Context context) {
        super(context);
    }
    public RandomShapeView(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(RandomUtils.randomElement(backgrounds));

        int viewWidth = getWidth();
        int viewHeight = getHeight();
        int avgShapeWidth = viewWidth/5;

        for (int i=0; i<20; i++) {
            drawRandomCircle(canvas, viewWidth, viewHeight, avgShapeWidth);
            drawRandomRect(canvas, viewWidth, viewHeight, avgShapeWidth);
            drawRandomBitmap(canvas, viewWidth, viewHeight);
            drawRandomText(canvas, viewWidth, viewHeight, avgShapeWidth);
        }
    }

    private Paint makePaint(int color){
        Paint p = new Paint();
        p.setColor(color);
        return p;
    }

    private Bitmap makeBitmap(int bitmapId){
        return BitmapFactory.decodeResource(getResources(), bitmapId);
    }

    private void drawRandomCircle(Canvas canvas, int viewWidth, int viewHeight, int avgShapeWidth){
        float x = RandomUtils.randomFloat(viewWidth);
        float y = RandomUtils.randomFloat(viewHeight);
        float rad = RandomUtils.randomFloat(avgShapeWidth/2);
        Paint circleColor = RandomUtils.randomElement(paints);
        canvas.drawCircle(x,y,rad,circleColor);
    }

    private void drawRandomRect(Canvas canvas, int viewWidth, int viewHeight, int avgShapeWidth){
        float left = RandomUtils.randomFloat(viewWidth);
        float top = RandomUtils.randomFloat(viewHeight);
        float width = RandomUtils.randomFloat(avgShapeWidth);
        float right = left + width;
        float bottom = top+width;
        Paint color = RandomUtils.randomElement(paints);
        canvas.drawRect(left,top,right,bottom,color);
    }

    private void drawRandomBitmap (Canvas canvas, int viewWidth, int viewHeight){
        float left = RandomUtils.randomFloat(viewWidth);
        float top = RandomUtils.randomFloat(viewHeight);
        Bitmap pic = RandomUtils.randomElement(pics);
        canvas.drawBitmap(pic,left,top,null);
    }

    private void drawRandomText(Canvas canvas, int viewWidth, int viewHeight, int abgShapeWidth){
        float x = RandomUtils.randomFloat(viewWidth);
        float y = RandomUtils.randomFloat(viewHeight);
        float textSize = RandomUtils.randomFloat(abgShapeWidth);
        Paint textPaint = RandomUtils.randomElement(paints);
        canvas.drawText(mensaje, x,y,textPaint);
    }

}
