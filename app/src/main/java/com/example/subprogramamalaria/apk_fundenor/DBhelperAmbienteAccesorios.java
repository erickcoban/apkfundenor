package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperAmbienteAccesorios extends SQLiteOpenHelper {

    // Información de la tabla viviendas
    public static final String TABLE_ACCESORIOS = "accesorios";
    public static final String ACCESORIO_ID = "_id";
    public static final String ACCESORIO_IDAMBIENTE = "idAmbiente";
    public static final String ACCESORIO_AMBIENTE = "ambiente";
    public static final String ACCESORIO_HABITACION = "accesoHabitacion";
    public static final String ACCESORIO_COCINA = "accesoCocina";
    public static final String ACCESORIO_LETRINA = "accesoLetrina";
    public static final String ACCESORIO_DUCHA = "accesoDucha";
    public static final String ACCESORIO_LAVA = "accesoLavadero";
    public static final String ACCESORIO_FECHA = "fechoAcceso";

    // información del a base de datos
    static final String DB_NAME = "DBACCESORIOS";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_ACCESORIOS + "("
            + ACCESORIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ACCESORIO_IDAMBIENTE + " TEXT NOT NULL, "
            + ACCESORIO_AMBIENTE + " TEXT NOT NULL, "
            + ACCESORIO_HABITACION + " TEXT, "
            + ACCESORIO_COCINA + " TEXT, "
            + ACCESORIO_LETRINA + " TEXT, "
            + ACCESORIO_DUCHA + " TEXT, "
            + ACCESORIO_LAVA + " TEXT, "
            + ACCESORIO_FECHA + " TEXT NOT NULL);";

    public DBhelperAmbienteAccesorios(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCESORIOS);
        onCreate(db);
    }
}
