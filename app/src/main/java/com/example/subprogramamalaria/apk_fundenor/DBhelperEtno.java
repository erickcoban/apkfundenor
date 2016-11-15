package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperEtno extends SQLiteOpenHelper {

    // Información de la tabla viviendas
    public static final String TABLE_ETNO = "etnoveterinaria";
    public static final String ETNO_ID = "_id";
    public static final String ETNO_FAMILIA = "idFamilia";
    public static final String ETNO_NOMBRE = "nombre";

    // información del a base de datos
    static final String DB_NAME = "DBETNO";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_ETNO + "("
            + ETNO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ETNO_FAMILIA + " TEXT NOT NULL, "
            + ETNO_NOMBRE + " TEXT NOT NULL);";

    public DBhelperEtno(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETNO);
        onCreate(db);
    }
}
