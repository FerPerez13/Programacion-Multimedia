package com.example.fer.overwatchstats;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.fer.overwatchstats.PartidasSQLiteHelper;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    private static Context myContext;

    Spinner spinner;
    static String usuarios[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Abrimos la base de datos en modo escritura
        PartidasSQLiteHelper partidas = new PartidasSQLiteHelper(this, "OverStats",null,1);
        //Referencia de la base de datos para modificarla
        final SQLiteDatabase db = partidas.getWritableDatabase();

        final Button button = (Button)findViewById(R.id.validar);

        //Rellenamos la lista para el Spinner
        usuarios=new String[0];
        String[] dataFields = new String[] {"user"};
        Cursor cursor = db.query("usuarios", dataFields, null, null, null, null, null);
        String fetchUsers[];
        fetchUsers=new String[cursor.getCount()];
        int i=0;
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(0);
                fetchUsers[i]= name;
                i++;

            } while (cursor.moveToNext());
        }
        usuarios=fetchUsers;
        cursor.close();
        //Fin relleno de lista

        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, usuarios);
        spinner.setAdapter(adapter);

        final Bundle miBundle = new Bundle();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("Usuario: "+usuarios[i]);
                miBundle.putString("Texto1", usuarios[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Pasar con un Bundle el nombre del usuario que está accediendo a su cuenta

                Intent intent = new Intent(Login.this, PersonajeActivity.class);
                intent.putExtras(miBundle);

                startActivity(intent);
            }
        });

    }

    public static Context getMyContext(){
        return myContext;
    }
}
