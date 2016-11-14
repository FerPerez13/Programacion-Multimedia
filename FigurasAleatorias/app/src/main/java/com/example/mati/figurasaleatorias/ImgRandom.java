package com.example.mati.figurasaleatorias;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class ImgRandom extends Activity {
    private RandomShapeView areaDrawing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_random);
        areaDrawing = (RandomShapeView)findViewById(R.id.randoms);
    }

    public void reDraw(View clickedButton){
        areaDrawing.invalidate();
    }


}
