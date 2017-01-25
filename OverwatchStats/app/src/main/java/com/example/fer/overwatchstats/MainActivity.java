package com.example.fer.overwatchstats;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.MenuItemHoverListener;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Abrimos la base de datos en modo escritura
    private PersonajesSQLiteHelper personajesSQLiteHelper = new PersonajesSQLiteHelper(this, "BDPersonajes", null, 1);
    //Referencia de la base de datos para modificarla
    private SQLiteDatabase bd = personajesSQLiteHelper.getWritableDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button loginBtn = (Button)findViewById(R.id.logButton);
        final Button signinBtn = (Button)findViewById(R.id.signButton);

        if (bd!=null){
            //Metemos el usuario admin de ejemplo
            String user = "admin";
            bd.execSQL("INSERT INTO Usuarios (user) VALUES ("+user+")");
        }

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
                mostrarSignIn();
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
    public void mostrarSignIn(){
        //Falta utilizar un fragment
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final EditText nomUsuario = new EditText(this);
        builder.setTitle("Crear usuario")
                .setView(nomUsuario)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Mensaje de que se ha creado correctamente el usuario
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Usuario "+ nomUsuario.getText().toString() +" creado correctamente", Toast.LENGTH_SHORT);

                        toast1.show();

                        //Sentencia SQL para crear nueva tabla
                        bd.execSQL("INSERT INTO Usuarios (user) VALUES ("+nomUsuario+")");

                        dialogInterface.dismiss();
                    }
                });

        builder.create().show();
    }

}
