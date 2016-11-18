package com.splash.banana.estudioscondave;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button boton = (Button)findViewById(R.id.boton);
        final TextView textEdit = (TextView)findViewById(R.id.texto);
        final EditText editText = (EditText)findViewById(R.id.edit);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoRecogido = editText.getText().toString();
                final Texto objetoTexto = new Texto(textoRecogido);
                boton.setBackgroundColor(Color.RED);

                //Creamos el intent (Para poder pasar de pantalla)
                Intent intent = new Intent(MainActivity.this, Pantalla2.class);

                //Para almacenar objetos de la pantalla actual creamos el Bundle
                Bundle bundle = new Bundle();
                bundle.putSerializable("Text", objetoTexto);

                //Insertamos en el intent el bundle
                intent.putExtras(bundle);

                //Lanzamos la nueva pantalla
                startActivity(intent);
            }
        });



    }
}
