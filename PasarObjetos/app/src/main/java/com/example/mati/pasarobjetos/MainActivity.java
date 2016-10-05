package com.example.mati.pasarobjetos;

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

        final EditText editNombre = (EditText)findViewById(R.id.nombre);
        final EditText editApellido = (EditText)findViewById(R.id.apellidos);
        final EditText editEdad = (EditText)findViewById(R.id.edad);
        final Button boton = (Button)findViewById(R.id.boton);
        final TextView validar = (TextView)findViewById(R.id.validado);

        final Persona persona = new Persona();

        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String nom = editNombre.getText().toString();
                String ap = editApellido.getText().toString();
                int edad = Integer.parseInt(editEdad.getText().toString());

                final Persona persona = new Persona(nom,ap,edad);

                String info = persona.toString();

                validar.setText(info);
            }
        });




    }
}
