package com.example.fer.overwatchstats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

/**
 * Created by fer on 16/01/17.
 */
public class SplashActivity extends Activity {

    // Duración en milisegundos que se mostrará la pantalla de inicio
    private final int DURACION_SPLASH = 4000; // 4 segundos

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final TextView loading = (TextView)findViewById(R.id.loadText);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setText("Cargando usuarios");
            }
        },3*DURACION_SPLASH/4);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setText("Cargando lista de Héroes");
            }
        },DURACION_SPLASH/4);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setText("Preparando fotos de los nuevos");
            }
        },DURACION_SPLASH/2);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                // Cuando pasen los segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}
