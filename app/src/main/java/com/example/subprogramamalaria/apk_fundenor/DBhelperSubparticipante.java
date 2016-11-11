package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperSubparticipante extends SQLiteOpenHelper {

    // Información de la tabla
    public static final String TABLE_SUBPARTICIPANTE = "subparticipantes";
    public static final String SUBPARTICIPANTE_ID = "_id";
    public static final String SUBPARTICIPANTE_IDPART = "idParticipante";
    public static final String SUBPARTICIPANTE_NOMBRE1 = "nombre1";
    public static final String SUBPARTICIPANTE_NOMBRE2 = "nombre2";
    public static final String SUBPARTICIPANTE_NOMBRE3 = "nombre3";
    public static final String SUBPARTICIPANTE_APELLIDO1 = "apellido1";
    public static final String SUBPARTICIPANTE_APELLIDO2 = "apellido2";
    public static final String SUBPARTICIPANTE_APELLIDOC = "apellidoC";
    public static final String SUBPARTICIPANTE_GENERO = "genero";
    public static final String SUBPARTICIPANTE_CONSANGUINIDAD = "idConsanguinidad";
    public static final String SUBPARTICIPANTE_FECHANAC = "fechaNac";
    public static final String SUBPARTICIPANTE_TALLA = "talla";
    public static final String SUBPARTICIPANTE_PESO = "peso";
    public static final String SUBPARTICIPANTE_DESNUTICION = "desnutricion";
    public static final String SUBPARTICIPANTE_CUI = "cui";
    public static final String SUBPARTICIPANTE_GRADOACA = "gradoAcademico";
    public static final String SUBPARTICIPANTE_ESTADOCIV = "estadoCivil";
    public static final String SUBPARTICIPANTE_TELEFONO = "telefono";
    public static final String SUBPARTICIPANTE_CARGOCOM = "cargoComunitarios";
    public static final String SUBPARTICIPANTE_IDIOMA = "idioma";
    public static final String SUBPARTICIPANTE_OFICIO = "oficio";
    public static final String SUBPARTICIPANTE_RELIGION = "religion";
    public static final String SUBPARTICIPANTE_GRUPO = "grupo";
    public static final String SUBPARTICIPANTE_INGRESOE = "ingresoEconomico";
    public static final String SUBPARTICIPANTE_FECHAREG = "fechaRegistro";

    // información del a base de datos
    static final String DB_NAME = "DBSUBPARTICIPANTE";
    static final int DB_VERSION = 1;

    // Información de la base de datos
    private static final String CREATE_TABLE = "create table "
            + TABLE_SUBPARTICIPANTE + "("
            + SUBPARTICIPANTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + SUBPARTICIPANTE_IDPART + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_NOMBRE1 + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_NOMBRE2 + " TEXT, "
            + SUBPARTICIPANTE_NOMBRE3 + " TEXT, "
            + SUBPARTICIPANTE_APELLIDO1 + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_APELLIDO2 + " TEXT, "
            + SUBPARTICIPANTE_APELLIDOC + " TEXT, "
            + SUBPARTICIPANTE_GENERO + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_CONSANGUINIDAD + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_FECHANAC + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_TALLA + " TEXT, "
            + SUBPARTICIPANTE_PESO + " TEXT, "
            + SUBPARTICIPANTE_DESNUTICION + " TEXT, "
            + SUBPARTICIPANTE_CUI + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_GRADOACA + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_ESTADOCIV + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_TELEFONO + " TEXT, "
            + SUBPARTICIPANTE_CARGOCOM + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_IDIOMA + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_OFICIO + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_RELIGION + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_GRUPO + " TEXT NOT NULL, "
            + SUBPARTICIPANTE_INGRESOE + " TEXT, "
            + SUBPARTICIPANTE_FECHAREG + " TEXT NOT NULL);";

    public DBhelperSubparticipante(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBPARTICIPANTE);
        onCreate(db);
    }
}
