package com.example.mati.shapedrawable2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mati on 7/11/16.
 */
public class VistaDibujo extends View {
    private ShapeDrawable miDrawable;
    public VistaDibujo (Context context){
        super(context);
    }
    public  VistaDibujo(Context c, AttributeSet attributeSet){
        super(c, attributeSet);
    }

    protected void onDraw(Canvas canvas){
        int x=10, y=10;
        int ancho=300, alto=50;
        miDrawable = new ShapeDrawable(new OvalShape());
        miDrawable.getPaint().setColor(0xFF0000FF);
        miDrawable.setBounds(x,y,x+ancho,y+alto);
        miDrawable.draw(canvas);
    }
}
