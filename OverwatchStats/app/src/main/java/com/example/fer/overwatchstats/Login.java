package com.example.fer.overwatchstats;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    public static String usuarios[];
    private static int selection;

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
                selection=i;
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
                if (usuarios!=null)
                    startActivity(intent);
            }
        });

    }

    //Menú para Eliminar Usuario
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        //Abrimos la base de datos en modo escritura
        PartidasSQLiteHelper partidas = new PartidasSQLiteHelper(this, "OverStats",null,1);
        //Referencia de la base de datos para modificarla
        final SQLiteDatabase db = partidas.getWritableDatabase();
        switch (menuItem.getItemId()){
            case R.id.eliminar:
                mostrarEliminarUsuario(db,usuarios[selection]);
                break;
        }
        return true;
    }

    public void mostrarEliminarUsuario(final SQLiteDatabase db, final String nom){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Eliminar")
                .setMessage("¿Seguro que quiere eliminar el usuario seleccionado?")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.execSQL("DELETE FROM usuarios WHERE user=\"" + nom + "\";"); //Sentencia para crear nuevo usuario
                        //TODO: Falta refrescar la base de datos en directo
                        dialogInterface.dismiss();
                    }
                });
        builder.create().show();
    }

    public static Context getMyContext(){
        return myContext;
    }
}
