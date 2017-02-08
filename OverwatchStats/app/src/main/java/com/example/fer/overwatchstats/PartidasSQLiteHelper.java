package com.example.fer.overwatchstats;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fer on 1/02/17.
 */

public class PartidasSQLiteHelper extends SQLiteOpenHelper{

    //Sentencia SQL que nos permite crear la tabla Usuarios
    String userSQL = "CREATE TABLE IF NOT EXISTS usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, user TEXT);";
    //Sentecia SQL que nos permite crear la tabla Partidas
    String matchSQL = "CREATE TABLE IF NOT EXISTS match (id INTEGER PRIMARY KEY AUTOINCREMENT, id_user INTEGER, id_heroe INTEGER, wins INTEGER, " +
            "draw INTEGER, lose INTEGER, damage_received INTEGER, damage_done INTEGER)" +
            ";";

    public PartidasSQLiteHelper(Context context, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super (context, nombre, almacen, version);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(userSQL);
        db.execSQL(matchSQL);
    }

    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva){
        db.execSQL("DROP TABLE IF EXISTS usuarios;");
        db.execSQL("DROP TABLE IF EXISTS match;");

        db.execSQL(userSQL);
        db.execSQL(matchSQL);
    }

    public void creaBD(SQLiteDatabase db){
        db.execSQL(userSQL);
        db.execSQL(matchSQL);
    }




}
