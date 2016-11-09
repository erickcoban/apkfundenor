package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    // Información de la tabla viviendas
    public static final String TABLE_VIVIENDA = "viviendas";
    public static final String VIVIENDA_ID = "_id";
    public static final String VIVIENDA_NOMBRE = "idVivienda";
    public static final String VIVIENDA_LOCALIDAD = "idLocalidad";
    public static final String VIVIENDA_USER = "userTecnico";
    public static final String VIVIENDA_PARED = "paredVivienda";
    public static final String VIVIENDA_TECHO = "techoVivienda";
    public static final String VIVIENDA_DIVISION = "tieneDivision";
    public static final String VIVIENDA_TIPOAGUA = "tipoAgua";
    public static final String VIVIENDA_TIPOALMACENAGUA = "almacenAgua";
    public static final String VIVIENDA_OTROALMACEN = "otroAlmancen";
    public static final String VIVIENDA_PURIFICACION = "tipoPurificacion";
    public static final String VIVIENDA_ESTADO = "estadoAsignacion";
    public static final String VIVIENDA_FECHA = "fecha";

    // información del a base de datos
    static final String DB_NAME = "DBFUNSYS";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_VIVIENDA + "("
            + VIVIENDA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + VIVIENDA_NOMBRE + " TEXT NOT NULL, "
            + VIVIENDA_LOCALIDAD + " TEXT NOT NULL, "
            + VIVIENDA_USER + " TEXT NOT NULL, "
            + VIVIENDA_PARED + " TEXT NOT NULL, "
            + VIVIENDA_TECHO + " TEXT NOT NULL, "
            + VIVIENDA_DIVISION + " TEXT NOT NULL, "
            + VIVIENDA_TIPOAGUA + " TEXT NOT NULL, "
            + VIVIENDA_TIPOALMACENAGUA + " TEXT NOT NULL, "
            + VIVIENDA_OTROALMACEN + " TEXT, "
            + VIVIENDA_PURIFICACION + " TEXT NOT NULL, "
            + VIVIENDA_ESTADO + " TEXT NOT NULL, "
            + VIVIENDA_FECHA + " TEXT NOT NULL);";

    public DBhelper(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VIVIENDA);
        onCreate(db);
    }
}
