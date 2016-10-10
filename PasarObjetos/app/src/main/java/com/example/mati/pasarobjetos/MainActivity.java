package com.example.mati.pasarobjetos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editNombre = (EditText)findViewById(R.id.nombre);
        final EditText editApellido = (EditText)findViewById(R.id.apellidos);
        final EditText editEdad = (EditText)findViewById(R.id.edad);
        final ImageView editImg = (ImageView)findViewById(R.id.imagen);
        final Button boton = (Button)findViewById(R.id.boton);
        final TextView validar = (TextView)findViewById(R.id.validado);

        final Persona persona = new Persona();

        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String nom = editNombre.getText().toString();
                String ap = editApellido.getText().toString();
                int edad = Integer.parseInt(editEdad.getText().toString());

                Persona persona = new Persona(nom,ap,edad,R.drawable.braum);

                String info = persona.toString();

                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();

                miBundle.putSerializable("Texto1", persona); //Esto es para pasar el Objeto entero
                miIntent.putExtras(miBundle);
                startActivity(miIntent);

                showToast(info);
            }
        });
    }

    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
