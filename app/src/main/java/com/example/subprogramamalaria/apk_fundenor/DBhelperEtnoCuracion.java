package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperEtnoCuracion extends SQLiteOpenHelper {

    // Información de la tabla Otros Animales
    public static final String TABLE_CURACION = "curacion";
    public static final String CURACION_ID = "_id";
    public static final String CURACION_ETNO = "idEtno";
    public static final String CURACION_ENFECOMUN = "enfermedadComun";
    public static final String CURACION_TIPOMED = "tipoMedicamento";
    public static final String CURACION_TIPOVAC = "tipoVacuna";
    public static final String CURACION_NOVACUNA = "noVacuna";
    public static final String CURACION_QUIENVAC = "quienVacuna";
    public static final String CURACION_ULTIMOMES = "ultimaVacunaMes";
    public static final String CURACION_MUERTE = "mesesMuerte";
    public static final String CURACION_PROMMUERTE = "promedioMuerte";
    public static final String CURACION_FECHA = "fechaReg";

    // información del a base de datos
    static final String DB_NAME = "DBCURACION";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_CURACION + "("
            + CURACION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CURACION_ETNO + " TEXT NOT NULL, "
            + CURACION_ENFECOMUN + " TEXT, "
            + CURACION_TIPOMED + " TEXT, "
            + CURACION_TIPOVAC + " TEXT, "
            + CURACION_NOVACUNA + " TEXT, "
            + CURACION_QUIENVAC + " TEXT, "
            + CURACION_ULTIMOMES + " TEXT, "
            + CURACION_MUERTE + " TEXT, "
            + CURACION_PROMMUERTE + " TEXT, "
            + CURACION_FECHA + " TEXT NOT NULL);";

    public DBhelperEtnoCuracion(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CURACION);
        onCreate(db);
    }
}
