package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperComunidad extends SQLiteOpenHelper {

    // Información de la tabla viviendas
    public static final String TABLE_COMUNIDADES = "comunidades";
    public static final String COMUNIDAD_ID = "_id";
    public static final String COMUNIDAD_NOMBRE = "idVivienda";
    public static final String COMUNIDAD_CATEGORIA = "idLocalidad";
    public static final String COMUNIDAD_MUNICIPIO = "userTecnico";
    public static final String COMUNIDAD_ESTADO = "paredVivienda";

    // información del a base de datos
    static final String DB_NAME = "DBCOMUNIDADES";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_COMUNIDADES + "("
            + COMUNIDAD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COMUNIDAD_NOMBRE + " TEXT NOT NULL, "
            + COMUNIDAD_CATEGORIA + " TEXT NOT NULL, "
            + COMUNIDAD_MUNICIPIO + " TEXT NOT NULL, "
            + COMUNIDAD_ESTADO + " TEXT NOT NULL);";

    public DBhelperComunidad(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMUNIDADES);
        onCreate(db);
    }
}
