package com.example.fer.overwatchstats;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fer on 25/01/17.
 */

public class PersonajesSQLiteHelper extends SQLiteOpenHelper {

    //Cadena paracrear la SQL que nos permita crear la tabla Personajes
    String userSQL = "CREATE TABLE Usuarios (user TEXT)";

    public PersonajesSQLiteHelper(Context context, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(context, nombre, almacen, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd){
        bd.execSQL(userSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva){
        bd.execSQL("DROP TABLE ID EXISTS Usuarios");
    }

}
