package com.example.mati.alquilerdecoches;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        //final ImageView img2 = (ImageView)findViewById(R.id.img2);
        final TextView modelo2 = (TextView)findViewById(R.id.modelo2);
        final TextView precio2 = (TextView)findViewById(R.id.precio2);
        final TextView extras2 = (TextView)findViewById(R.id.extras2);
        final TextView tiempo2 = (TextView)findViewById(R.id.tiempo2);
        final TextView seguro2 = (TextView)findViewById(R.id.seguro2);
        final TextView coste2 = (TextView)findViewById(R.id.coste2);

        Bundle bundle = getIntent().getExtras();
        Seleccion seleccion = (Seleccion)bundle.getSerializable("seleccion");

        //img2.setImageResource(seleccion.getCoche().getImg());
        modelo2.setText(seleccion.getCoche().getModelo());
        precio2.setText(seleccion.getCoche().getPrecio()+"€");

        int c = 0;
        if(seleccion.isAireAcondicionado())
            c++;
        if(seleccion.isGps())
            c++;
        if (seleccion.isRadioDVD())
            c++;

        int extras=50*c;

        extras2.setText(extras);

        tiempo2.setText(seleccion.getTiempo());

        String seguro = "Sin Seguro";
        if(seleccion.isSeguro()){
            seguro = "Con Seguro";
        }
        seguro2.setText(seguro);

        coste2.setText(seleccion.getPrecio());
    }
}
