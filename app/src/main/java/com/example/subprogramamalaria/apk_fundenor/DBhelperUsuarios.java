package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperUsuarios extends SQLiteOpenHelper {

    // Información de la tabla viviendas
    public static final String TABLE_USUARIO = "usuarios";
    public static final String USUARIO_ID = "user";
    public static final String USUARIO_NOMBRE = "password";

    // información del a base de datos
    static final String DB_NAME = "DBUSUARIOS";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_USUARIO + "("
            + USUARIO_ID + " TEXT NOT NULL, "
            + USUARIO_NOMBRE + " TEXT NOT NULL); ";

    public DBhelperUsuarios(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIO);
        onCreate(db);
    }
}
