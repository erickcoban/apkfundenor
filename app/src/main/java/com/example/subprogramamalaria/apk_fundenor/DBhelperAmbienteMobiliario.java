package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperAmbienteMobiliario extends SQLiteOpenHelper {

    // Información de la tabla viviendas
    public static final String TABLE_MOBILIARIO = "mobiliario";
    public static final String MOBILIARIO_ID = "_id";
    public static final String MOBILIARIO_IDAMBIENTE = "idAmbiente";
    public static final String MOBILIARIO_AMBIENTE = "ambiente";
    public static final String MOBILIARIO_TIENEROPERO = "tieneRopero";
    public static final String MOBILIARIO_NOROPERO = "noRopero";
    public static final String MOBILIARIO_TIENECAMAS = "tieneCamas";
    public static final String MOBILIARIO_NOCAMAS = "noCamas";
    public static final String MOBILIARIO_TIPOCAMAS = "tipoCamas";
    public static final String MOBILIARIO_TIENEPLATERA = "tienePlatera";
    public static final String MOBILIARIO_NOPLATERA = "NoPlatera";
    public static final String MOBILIARIO_TIENEMESA = "tieneMesa";
    public static final String MOBILIARIO_NOMESA = "noMesa";
    public static final String MOBILIARIO_TIENESILLA = "tieneSilla";
    public static final String MOBILIARIO_NOSILLA = "noSilla";
    public static final String MOBILIARIO_TIENEESTUFA = "tieneEstufa";
    public static final String MOBILIARIO_TIPOESTUFA = "tipoEstufa";
    public static final String MOBILIARIO_UBICATREBE = "ubicaTrebe";
    public static final String MOBILIARIO_FECHA = "fechoAcceso";

    // información del a base de datos
    static final String DB_NAME = "DBMOBILIARIO";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_MOBILIARIO + "("
            + MOBILIARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MOBILIARIO_IDAMBIENTE + " TEXT NOT NULL, "
            + MOBILIARIO_AMBIENTE + " TEXT NOT NULL, "
            + MOBILIARIO_TIENEROPERO + " TEXT, "
            + MOBILIARIO_NOROPERO + " TEXT, "
            + MOBILIARIO_TIENECAMAS + " TEXT, "
            + MOBILIARIO_NOCAMAS + " TEXT, "
            + MOBILIARIO_TIPOCAMAS + " TEXT, "
            + MOBILIARIO_TIENEPLATERA + " TEXT, "
            + MOBILIARIO_NOPLATERA + " TEXT, "
            + MOBILIARIO_TIENEMESA + " TEXT, "
            + MOBILIARIO_NOMESA + " TEXT, "
            + MOBILIARIO_TIENESILLA + " TEXT, "
            + MOBILIARIO_NOSILLA + " TEXT, "
            + MOBILIARIO_TIENEESTUFA + " TEXT, "
            + MOBILIARIO_TIPOESTUFA + " TEXT, "
            + MOBILIARIO_UBICATREBE + " TEXT, "
            + MOBILIARIO_FECHA + " TEXT NOT NULL);";

    public DBhelperAmbienteMobiliario(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOBILIARIO);
        onCreate(db);
    }
}
