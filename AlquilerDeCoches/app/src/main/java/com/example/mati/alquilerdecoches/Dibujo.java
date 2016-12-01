package com.example.mati.alquilerdecoches;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.view.View;

public class Dibujo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView((this)));
    }

    public class EjemploView extends View{
        public EjemploView(Context context){
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas){
            Paint pincel = new Paint();
            pincel.setStrokeWidth(20);
            pincel.setStyle(Paint.Style.STROKE);
            pincel.setColor(Color.BLACK);

            canvas.drawCircle(500,500,100,pincel);
            canvas.drawCircle(1000,500,100,pincel);

            pincel.setColor(Color.BLUE);
            canvas.drawRect(300,300,1200,500,pincel);
            pincel.setColor(Color.RED);
            canvas.drawRect(500,100,1000,300,pincel);
        }
    }
}
