package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperEtnoOtrosAnimales extends SQLiteOpenHelper {

    // Información de la tabla Otros Animales
    public static final String TABLE_ANIMALES = "OtroAnimales";
    public static final String ANIMALES_ID = "_id";
    public static final String ANIMALES_ETNO = "idEtno";
    public static final String ANIMALES_NOMBRE = "nombre";
    public static final String ANIMALES_NOVACAS = "noVacas";
    public static final String ANIMALES_NOCERDOS = "noCerdos";
    public static final String ANIMALES_NOCABRAS = "noCabras";
    public static final String ANIMALES_NOCONEJOS = "noConejos";
    public static final String ANIMALES_NOPALOMAS = "noPalomas";
    public static final String ANIMALES_HABITAT = "habitat";
    public static final String ANIMALES_FECHA = "fechaReg";

    // información del a base de datos
    static final String DB_NAME = "DBOANIMALES";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_ANIMALES + "("
            + ANIMALES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ANIMALES_ETNO + " TEXT NOT NULL, "
            + ANIMALES_NOMBRE + " TEXT NOT NULL, "
            + ANIMALES_NOVACAS + " TEXT, "
            + ANIMALES_NOCERDOS + " TEXT, "
            + ANIMALES_NOCABRAS + " TEXT, "
            + ANIMALES_NOCONEJOS + " TEXT, "
            + ANIMALES_NOPALOMAS + " TEXT, "
            + ANIMALES_HABITAT + " TEXT, "
            + ANIMALES_FECHA + " TEXT NOT NULL);";

    public DBhelperEtnoOtrosAnimales(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANIMALES);
        onCreate(db);
    }
}
