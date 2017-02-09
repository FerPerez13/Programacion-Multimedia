package com.example.fer.overwatchstats;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private static String usuarios[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Abrimos la base de datos en modo escritura
        PartidasSQLiteHelper partidas = new PartidasSQLiteHelper(this, "OverStats",null,1);
        //Referencia de la base de datos para modificarla
        final SQLiteDatabase db = partidas.getWritableDatabase();

        //Esto es para introducir un usuario nuevo

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


        final Button loginBtn = (Button)findViewById(R.id.logButton);
        final Button signinBtn = (Button)findViewById(R.id.signButton);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Login");
                //Arrancar la pantala de Acceso
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Signin");
                //Arrancar la pantalla de Registro
                mostrarSignIn(db);
            }
        });
    }

    //Menú para el Acerca de
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.acerca:
                mostrarAcerca();
                break;
        }
        return true;
    }

    public void mostrarAcerca(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acerca de")
                .setMessage("Aplicación creada por Fernando Pérez Andrés")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        builder.create().show();
    }

    //Dialog Crear Usuario
    public void mostrarSignIn(final SQLiteDatabase db){
        //Falta utilizar un fragment
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final EditText nomUsuario = new EditText(this);
        builder.setTitle("Crear usuario")
                .setView(nomUsuario)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Sentencia SQL para crear nueva tabla

                        //TODO: Revisar este comprobador, ya que solo si salimos de la aplicación y volvemos a entrar aparecen los datos nuevos.(Por lo que nos permite crear usuarios nuevos iguales)
                        boolean correcto=true;
                        String nom = nomUsuario.getText().toString();
                        for(int j=0; j<usuarios.length;j++){
                            if(nom.compareToIgnoreCase(usuarios[j])==0 && nom.compareToIgnoreCase("")==0) {
                                correcto = false;
                            }
                        }

                        if(correcto) {
                            db.execSQL("INSERT INTO usuarios (user) VALUES (\"" + nom + "\");"); //Sentencia para crear nuevo usuario
                            Toast toast1 =
                                    Toast.makeText(getApplicationContext(),
                                            "El usuario "+ nomUsuario.getText().toString() +" creado correctamente.", Toast.LENGTH_SHORT);
                            toast1.show();

                        }else{
                            Toast toast2 =
                                    Toast.makeText(getApplicationContext(),
                                            "ERROR: El usuario "+ nomUsuario.getText().toString() +" no ha posido ser creado o ya existe.", Toast.LENGTH_SHORT);
                            toast2.show();
                        }

                        dialogInterface.dismiss();
                    }
                });

        builder.create().show();
    }

}
