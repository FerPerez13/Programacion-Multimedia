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
            pincel.setStrokeWidth(50);
            pincel.setStyle(Paint.Style.STROKE);

            /* Circulos concentricos
            for(int i=0;i<1000;i+=33) {
                if (i%2==0) {
                    pincel.setColor(Color.RED);
                    canvas.drawCircle(700, 700, 50 + i, pincel);
                }
            }*/

            pincel.setColor(Color.RED);
            canvas.drawCircle(650, 650, 350, pincel);

            pincel.setStrokeWidth(100);
            pincel.setColor(Color.BLUE);
            canvas.drawPoint(150,150, pincel);

            pincel.setColor(Color.YELLOW);
            canvas.drawPoint(1100,150, pincel);

            pincel.setColor(Color.MAGENTA);
            canvas.drawPoint(150,1100, pincel);

            pincel.setColor(Color.BLACK);
            canvas.drawPoint(1100,1100, pincel);

            pincel.setStrokeWidth(20);
            pincel.setColor(Color.GREEN);
            canvas.drawPoint(650,650,pincel);

            pincel.setColor(Color.DKGRAY);
            canvas.drawOval(1000,2000,100,110,pincel);
            
            pincel.setColor(Color.GRAY);
            canvas.drawArc(300,1600,1100,2000,180,180,false,pincel);

            pincel.setColor(Color.CYAN);
            canvas.drawRect(300,900,900,1500,pincel);



        }
    }


}
