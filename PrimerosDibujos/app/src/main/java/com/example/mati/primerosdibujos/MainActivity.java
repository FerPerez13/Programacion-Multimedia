package com.example.mati.primerosdibujos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View{
        public EjemploView(Context context){
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas){
            Paint pincel = new Paint();
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.STROKE);
            for(int i=0;i<1000;i+=33) {
                if (i%2==0){
                    pincel.setColor(Color.RED);
                    canvas.drawCircle(700, 700, 50+i, pincel);
                }else{
                    pincel.setColor(Color.GREEN);
                    canvas.drawCircle(700, 700, 50+i, pincel);
                }

            }

            pincel.setTextSize(60);
            pincel.setColor(Color.BLUE);
            pincel.setStrokeWidth(5);
            canvas.drawText("Fernando Pérez Andrés",700,2000,pincel);
        }
    }


}
