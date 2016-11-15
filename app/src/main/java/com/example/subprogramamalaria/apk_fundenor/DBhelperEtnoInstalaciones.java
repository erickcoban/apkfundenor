package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperEtnoInstalaciones extends SQLiteOpenHelper {

    // Información de la tabla viviendas
    public static final String TABLE_INSTALACION = "instalaciones";
    public static final String INSTALACION_ID = "_id";
    public static final String INSTALACION_ETNO = "idEtno";
    public static final String INSTALACION_GALLINERO = "gallinero";
    public static final String INSTALACION_MEDIDAG = "medidaGallinero";
    public static final String INSTALACION_CORRAL = "corral";
    public static final String INSTALACION_MEDIDAC = "medidaCorral";
    public static final String INSTALACION_COMEDERO = "comedero";
    public static final String INSTALACION_BEBEDERO = "bebedero";
    public static final String INSTALACION_NIDALES = "nidales";
    public static final String INSTALACION_MODULOPE = "moduloPecuario";
    public static final String INSTALACION_MODULOLI = "moduloLimpio";
    public static final String INSTALACION_FECHA = "fechaRegInstalacion";

    // información del a base de datos
    static final String DB_NAME = "DBINSTALACION";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_INSTALACION + "("
            + INSTALACION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + INSTALACION_ETNO + " TEXT NOT NULL, "
            + INSTALACION_GALLINERO + " TEXT NOT NULL, "
            + INSTALACION_MEDIDAG + " TEXT, "
            + INSTALACION_CORRAL + " TEXT NOT NULL, "
            + INSTALACION_MEDIDAC + " TEXT, "
            + INSTALACION_COMEDERO + " TEXT NOT NULL, "
            + INSTALACION_BEBEDERO + " TEXT NOT NULL, "
            + INSTALACION_NIDALES + " TEXT NOT NULL, "
            + INSTALACION_MODULOPE + " TEXT NOT NULL, "
            + INSTALACION_MODULOLI + " TEXT NOT NULL, "
            + INSTALACION_FECHA + " TEXT NOT NULL);";

    public DBhelperEtnoInstalaciones(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INSTALACION);
        onCreate(db);
    }
}
