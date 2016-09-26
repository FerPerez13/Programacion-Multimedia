package com.example.mati.proyectobotones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Boton4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton4);
    }
    public void onClickBack (View v){
        Intent miIntent = new Intent(Boton4.this, MainActivity.class);
        startActivity(miIntent);
    }
}
