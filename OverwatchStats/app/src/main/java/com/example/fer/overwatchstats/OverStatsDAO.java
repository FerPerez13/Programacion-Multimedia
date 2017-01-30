package com.example.fer.overwatchstats;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class OverStatsDAO {
    static SQLiteOpenHelper sqliteOpenHelper=new SQLiteOpenHelper(Login.getMyContext(), "OverStats", null, 1) {
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {}
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}
    };
    static SQLiteDatabase sqLiteDatabase = sqliteOpenHelper.getReadableDatabase();

    public static void initiateDB(){
        try {
            //TODO GET RID OF  THE NEXT SENTENCE FOR THE FINAL PROJECT
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS products");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS history");
            String sqlUsers = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NULL, surname TEXT NULL, " +
                    "telephone TEXT NULL, address TEXT NULL, username TEXT NOT NULL, password TEXT NOT NULL, UNIQUE (username))";

            String sqlProducts="CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, " +
                    "description TEXT NULL, price double NOT NULL)";
            String[] tables=new String[]{sqlUsers, sqlProducts};
            for(String sql:tables){
                sqLiteDatabase.execSQL(sql);
            }

        }catch (Exception e){

        }

    }


}