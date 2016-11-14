package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperHuertos extends SQLiteOpenHelper {

    // Información de la tabla
    public static final String TABLE_HUERTOS = "huertos";
    public static final String HUERTO_ID = "_id";
    public static final String HUERTO_IDFAM = "idfam";
    public static final String HUERTO_NOMBRE = "nombre";
    public static final String HUERTO_FECHA = "fechaImplementacion";
    public static final String HUERTO_BUENAP = "buenaPractica";
    public static final String HUERTO_INGRESOS = "ingresoSemanal";
    public static final String HUERTO_MANTTOT = "manttoTierra";
    public static final String HUERTO_PRODUCCIONORG = "produccionOrganica";
    public static final String HUERTO_PRACTICAAGUA = "practicaSinAgua";
    public static final String HUERTO_FECHAHUERTO = "fechaHuerto";

    // información del a base de datos
    static final String DB_NAME = "DBHUERTOS";
    static final int DB_VERSION = 1;

    // Información de la base de datos
    private static final String CREATE_TABLE = "create table "
            + TABLE_HUERTOS + "("
            + HUERTO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + HUERTO_IDFAM + " TEXT NOT NULL, "
            + HUERTO_NOMBRE + " TEXT NOT NULL, "
            + HUERTO_FECHA + " TEXT NOT NULL, "
            + HUERTO_BUENAP + " TEXT, "
            + HUERTO_INGRESOS + " TEXT, "
            + HUERTO_MANTTOT + " TEXT NOT NULL, "
            + HUERTO_PRODUCCIONORG + " TEXT, "
            + HUERTO_PRACTICAAGUA + " TEXT, "
            + HUERTO_FECHAHUERTO + " TEXT NOT NULL);";

    public DBhelperHuertos(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HUERTOS);
        onCreate(db);
    }
}
