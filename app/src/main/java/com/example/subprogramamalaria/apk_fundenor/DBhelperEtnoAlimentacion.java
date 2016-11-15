package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperEtnoAlimentacion extends SQLiteOpenHelper {

    // Información de la tabla viviendas
    public static final String TABLE_ALIMENTACION = "alimentacion";
    public static final String ALIMENTACION_ID = "_id";
    public static final String ALIMENTACION_ETNO = "idEtno";
    public static final String ALIMENTACION_CONCENTRADO = "concentradp";
    public static final String ALIMENTACION_TIPOCONCENTRADO = "tipoConcentrado";
    public static final String ALIMENTACION_OTRO = "otroAlimento";
    public static final String ALIMENTACION_FECHA = "fechaRegInstalacion";

    // información del a base de datos
    static final String DB_NAME = "DBINSTALACION";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_ALIMENTACION + "("
            + ALIMENTACION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ALIMENTACION_ETNO + " TEXT NOT NULL, "
            + ALIMENTACION_CONCENTRADO + " TEXT NOT NULL, "
            + ALIMENTACION_TIPOCONCENTRADO + " TEXT, "
            + ALIMENTACION_OTRO + " TEXT NOT NULL, "
            + ALIMENTACION_FECHA + " TEXT NOT NULL);";

    public DBhelperEtnoAlimentacion(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALIMENTACION);
        onCreate(db);
    }
}
