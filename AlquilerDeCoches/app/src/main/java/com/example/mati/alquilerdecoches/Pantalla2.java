package com.example.mati.alquilerdecoches;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final ImageView img2 = (ImageView)findViewById(R.id.img2);
        final TextView modelo2 = (TextView)findViewById(R.id.modelo2);
        final TextView precio2 = (TextView)findViewById(R.id.precio2);
        final TextView extras2 = (TextView)findViewById(R.id.extras2);
        final TextView tiempo2 = (TextView)findViewById(R.id.tiempo2);
        final TextView seguro2 = (TextView)findViewById(R.id.seguro2);
        final TextView coste2 = (TextView)findViewById(R.id.coste2);
        final CheckBox checkBox = (CheckBox)findViewById(R.id.HoraPedido);
        final DigitalClock reloj = (DigitalClock)findViewById(R.id.horaRosa);

        Bundle bundle = getIntent().getExtras();
        Seleccion seleccion = (Seleccion)bundle.getSerializable("Sel");

        img2.setImageResource(seleccion.getCoche().getImg());
        modelo2.setText(seleccion.getCoche().getModelo());
        precio2.setText(seleccion.getCoche().getPrecio()+"€");

        int extras = seleccion.getExtras();
        extras2.setText(""+extras+"€");

        tiempo2.setText(seleccion.getTiempo());

        int seg = seleccion.getSeguro();

        String seguro  = "Sin Seguro";
        if(seg==1)
            seguro = "Con Seguro";

        seguro2.setText(seguro);

        coste2.setText(""+seleccion.getPrecio());

        modelo2.setText("prueba");

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                reloj.setVisibility(View.VISIBLE);
            }
        });
    }
}
