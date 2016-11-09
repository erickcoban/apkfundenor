package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperFamilia extends SQLiteOpenHelper {

    // Información de la tabla
    public static final String TABLE_FAMILIA = "familia";
    public static final String FAMILIA_ID = "_id";
    public static final String FAMILIA_NOMBRE = "nombre";
    public static final String FAMILIA_VIVIENDA = "vivienda";

    // información del a base de datos
    static final String DB_NAME = "DBFAMILIA";
    static final int DB_VERSION = 1;

    // Información de la base de datos
    private static final String CREATE_TABLE = "create table "
            + TABLE_FAMILIA + "("
            + FAMILIA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + FAMILIA_NOMBRE + " TEXT NOT NULL, "
            + FAMILIA_VIVIENDA + " TEXT NOT NULL);";

    public DBhelperFamilia(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAMILIA);
        onCreate(db);
    }
}
