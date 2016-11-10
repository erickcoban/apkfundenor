package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperParticipante extends SQLiteOpenHelper {

    // Información de la tabla
    public static final String TABLE_PARTICIPANTE = "participantes";
    public static final String PARTICIPANTE_ID = "_id";
    public static final String PARTICIPANTE_NOMBRE1 = "nombre1";
    public static final String PARTICIPANTE_NOMBRE2 = "nombre2";
    public static final String PARTICIPANTE_NOMBRE3 = "nombre3";
    public static final String PARTICIPANTE_APELLIDO1 = "apellido1";
    public static final String PARTICIPANTE_APELLIDO2 = "apellido2";
    public static final String PARTICIPANTE_APELLIDOC = "apellidoC";
    public static final String PARTICIPANTE_GENERO = "genero";
    public static final String PARTICIPANTE_FECHANAC = "fechaNac";
    public static final String PARTICIPANTE_CUI = "cui";
    public static final String PARTICIPANTE_GRADOACA = "gradoAcademico";
    public static final String PARTICIPANTE_ESTADOCIV = "estadoCivil";
    public static final String PARTICIPANTE_CARGOCOM = "cargoComunitarios";
    public static final String PARTICIPANTE_IDIOMA = "idioma";
    public static final String PARTICIPANTE_OFICIO = "oficio";
    public static final String PARTICIPANTE_RELIGION = "religion";
    public static final String PARTICIPANTE_GRUPO = "grupo";
    public static final String PARTICIPANTE_TENECIAT = "tenenciaTerreno";
    public static final String PARTICIPANTE_CERTEZA = "certezaJuridica";
    public static final String PARTICIPANTE_MEDIDAT = "medidaTerrero";
    public static final String PARTICIPANTE_INGRESOE = "ingresoEconomico";
    public static final String PARTICIPANTE_FECHAREG = "fechaRegistro";

    // información del a base de datos
    static final String DB_NAME = "DBPARTICIPANTE";
    static final int DB_VERSION = 1;

    // Información de la base de datos
    private static final String CREATE_TABLE = "create table "
            + TABLE_PARTICIPANTE + "("
            + PARTICIPANTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PARTICIPANTE_NOMBRE1 + " TEXT NOT NULL, "
            + PARTICIPANTE_NOMBRE2 + " TEXT, "
            + PARTICIPANTE_NOMBRE3 + " TEXT, "
            + PARTICIPANTE_APELLIDO1 + " TEXT NOT NULL, "
            + PARTICIPANTE_APELLIDO2 + " TEXT, "
            + PARTICIPANTE_APELLIDOC + " TEXT, "
            + PARTICIPANTE_GENERO + " TEXT NOT NULL, "
            + PARTICIPANTE_FECHANAC + " TEXT NOT NULL, "
            + PARTICIPANTE_CUI + " TEXT NOT NULL, "
            + PARTICIPANTE_GRADOACA + " TEXT NOT NULL, "
            + PARTICIPANTE_ESTADOCIV + " TEXT NOT NULL, "
            + PARTICIPANTE_CARGOCOM + " TEXT NOT NULL, "
            + PARTICIPANTE_IDIOMA + " TEXT NOT NULL, "
            + PARTICIPANTE_OFICIO + " TEXT NOT NULL, "
            + PARTICIPANTE_RELIGION + " TEXT NOT NULL, "
            + PARTICIPANTE_GRUPO + " TEXT NOT NULL, "
            + PARTICIPANTE_TENECIAT + " TEXT NOT NULL, "
            + PARTICIPANTE_CERTEZA + " TEXT NOT NULL, "
            + PARTICIPANTE_MEDIDAT + " TEXT NOT NULL, "
            + PARTICIPANTE_INGRESOE + " TEXT NOT NULL, "
            + PARTICIPANTE_FECHAREG + " TEXT NOT NULL);";

    public DBhelperParticipante(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARTICIPANTE);
        onCreate(db);
    }
}
