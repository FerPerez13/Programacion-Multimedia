package com.example.fer.overwatchstats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MostrarDatos extends AppCompatActivity {

    public Personaje[] per = new Personaje[]{
            new Personaje("Genji", R.drawable.genji),
            new Personaje("McCree", R.drawable.mccree),
            new Personaje("Pharah", R.drawable.phara),
            new Personaje("Reaper", R.drawable.reaper),
            new Personaje("Soldado: 76", R.drawable.soldado),
            new Personaje("Sombra", R.drawable.sombra),
            new Personaje("Tracer", R.drawable.tracer),
            new Personaje("Bastion", R.drawable.bastion),
            new Personaje("Hanzo", R.drawable.hanzo),
            new Personaje("Junkrat", R.drawable.junkrat),
            new Personaje("Mei", R.drawable.mei),
            new Personaje("Torbjörn", R.drawable.torbjorn),
            new Personaje("Widowmaker", R.drawable.widowmaker),
            new Personaje("D.Va", R.drawable.dva),
            new Personaje("Reinhardt", R.drawable.reihart),
            new Personaje("Roadhog", R.drawable.roadhogh),
            new Personaje("Winston", R.drawable.winston),
            new Personaje("Zarya", R.drawable.zayra),
            new Personaje("Ana", R.drawable.ana),
            new Personaje("Lúcio", R.drawable.lucio),
            new Personaje("Mercy", R.drawable.mercy),
            new Personaje("Symetra", R.drawable.symetra),
            new Personaje("Zenyatta", R.drawable.zenyatta),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        final ImageView imageView = (ImageView)findViewById(R.id.imgPersonaje);

        Bundle bundle = getIntent().getExtras();
        int seleccion = (int)bundle.getInt("int");

        imageView.setImageResource(per[seleccion].getImagen());
    }
}
