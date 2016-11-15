package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperEtnoHuevos extends SQLiteOpenHelper {

    // Información de la tabla viviendas
    public static final String TABLE_HUEVOS = "huevos";
    public static final String HUEVOS_ID = "_id";
    public static final String HUEVOS_ETNO = "idEtno";
    public static final String HUEVOS_CANTIDADSEMANAL = "cantidadSemanal";
    public static final String HUEVOS_CONSUMOSEMANAL = "consumoSemanal";
    public static final String HUEVOS_REPRODUCCION = "reproduccion";
    public static final String HUEVOS_VENTA = "venta";
    public static final String HUEVOS_FECHA = "fechaRegHuevos";

    // información del a base de datos
    static final String DB_NAME = "DBHUEVOS";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_HUEVOS + "("
            + HUEVOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + HUEVOS_ETNO + " TEXT NOT NULL, "
            + HUEVOS_CANTIDADSEMANAL + " TEXT NOT NULL, "
            + HUEVOS_CONSUMOSEMANAL + " TEXT NOT NULL, "
            + HUEVOS_REPRODUCCION + " TEXT NOT NULL, "
            + HUEVOS_VENTA + " TEXT NOT NULL, "
            + HUEVOS_FECHA + " TEXT NOT NULL);";

    public DBhelperEtnoHuevos(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HUEVOS);
        onCreate(db);
    }
}
