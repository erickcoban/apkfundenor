package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperHuertosDiversificacion extends SQLiteOpenHelper {

    // Información de la tabla
    public static final String TABLE_DIVERSIFICACION = "diversificacion";
    public static final String DIVERSIFICACION_ID = "_id";
    public static final String DIVERSIFICACION_NOMBRE = "nombre";
    public static final String DIVERSIFICACION_CONSUME = "consume";
    public static final String DIVERSIFICACION_VENDE = "vende";
    public static final String DIVERSIFICACION_CANTIDAD = "cantidad";
    public static final String DIVERSIFICACION_IDHUERTO = "idHuerto";
    public static final String DIVERSIFICACION_FECHAREG = "fechaReg";

    // información del a base de datos
    static final String DB_NAME = "DBSUBPARTICIPANTE";
    static final int DB_VERSION = 1;

    // Información de la base de datos
    private static final String CREATE_TABLE = "create table "
            + TABLE_DIVERSIFICACION + "("
            + DIVERSIFICACION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DIVERSIFICACION_NOMBRE + " TEXT NOT NULL, "
            + DIVERSIFICACION_CONSUME + " TEXT NOT NULL, "
            + DIVERSIFICACION_VENDE + " TEXT NOT NULL, "
            + DIVERSIFICACION_CANTIDAD + " TEXT, "
            + DIVERSIFICACION_IDHUERTO + " TEXT, "
            + DIVERSIFICACION_FECHAREG + " TEXT NOT NULL);";

    public DBhelperHuertosDiversificacion(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DIVERSIFICACION);
        onCreate(db);
    }
}
