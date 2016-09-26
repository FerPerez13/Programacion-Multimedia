package com.example.mati.proyectobotones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button boton1 = (Button) findViewById(R.id.boton1);
        final Button boton2 = (Button) findViewById(R.id.boton2);
        final Button boton3 = (Button) findViewById(R.id.boton3);
        final Button boton4 = (Button) findViewById(R.id.boton4);

        boton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent = new Intent(MainActivity.this, Boton1.class);
                Bundle miBundle = new Bundle();
                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent,0);
            }
        });

        // boton2 Esta debajo con un método separado declarado en el XML (onClickBoton2)
        // boton3 Esta debajo con un método separado declarado en el XML (onClickBoton3)

        boton4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent = new Intent(MainActivity.this, Boton4.class);
                Bundle miBundle = new Bundle();
                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent,0);
            }
        });
    }

    public void onClickBoton2(View v){
        Intent miIntent = new Intent(MainActivity.this, Boton2.class);
        startActivity(miIntent);
    }

    public void onClickBoton3 (View v){
        Intent miIntent = new Intent(MainActivity.this, Boton3.class);
        startActivity(miIntent);
    }


}
