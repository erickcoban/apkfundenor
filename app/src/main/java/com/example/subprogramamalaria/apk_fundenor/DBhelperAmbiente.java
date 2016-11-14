package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperAmbiente extends SQLiteOpenHelper {

    // Información de la tabla viviendas
    public static final String TABLE_AMBIENTE = "ambientes";
    public static final String AMBIENTE_ID = "_id";
    public static final String AMBIENTE_NOMBRE = "idVivienda";
    public static final String AMBIENTE_AMBIENTE = "tipoAmbiente";
    public static final String AMBIENTE_DIVISION = "tipoDivision";
    public static final String AMBIENTE_PARED = "paredAmbiente";
    public static final String AMBIENTE_TECHO = "techoAmbiente";
    public static final String AMBIENTE_PISO = "pisoAmbiente";
    public static final String AMBIENTE_MANTTO = "manttoAmbiente";
    public static final String AMBIENTE_LIMPIEZA = "limpiezaAmbiente";
    public static final String AMBIENTE_FECHA = "fechaRegAmbiente";

    // información del a base de datos
    static final String DB_NAME = "DBAMBIENTE";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_AMBIENTE + "("
            + AMBIENTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + AMBIENTE_NOMBRE + " TEXT NOT NULL, "
            + AMBIENTE_AMBIENTE + " TEXT NOT NULL, "
            + AMBIENTE_DIVISION + " TEXT NOT NULL, "
            + AMBIENTE_PARED + " TEXT NOT NULL, "
            + AMBIENTE_TECHO + " TEXT NOT NULL, "
            + AMBIENTE_PISO + " TEXT NOT NULL, "
            + AMBIENTE_MANTTO + " TEXT NOT NULL, "
            + AMBIENTE_LIMPIEZA + " TEXT NOT NULL, "
            + AMBIENTE_FECHA + " TEXT NOT NULL);";

    public DBhelperAmbiente(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AMBIENTE);
        onCreate(db);
    }
}
