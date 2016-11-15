package com.example.subprogramamalaria.apk_fundenor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperEtnoProduccion extends SQLiteOpenHelper {

    // Información de la tabla viviendas
    public static final String TABLE_PRODUCCION = "producciones";
    public static final String PRODUCCION_ID = "_id";
    public static final String PRODUCCION_IDETNO = "idEnto";
    public static final String PRODUCCION_PRODUCCION = "produccion";
    public static final String PRODUCCION_CANTGALLINA = "cantGallina";
    public static final String PRODUCCION_PRODGALLINA = "prodGallina";
    public static final String PRODUCCION_VENDEGALLINA = "vendeGallina";
    public static final String PRODUCCION_CONSUGALLINA = "consuGallina";
    public static final String PRODUCCION_CANTGALLOS = "cantGallos";
    public static final String PRODUCCION_PRODGALLOS = "prodGallos";
    public static final String PRODUCCION_VENDEGALLOS = "vendeGallos";
    public static final String PRODUCCION_CONSUGALLOS = "consuGallos";
    public static final String PRODUCCION_CANTPOLLITOS = "cantPollitos";
    public static final String PRODUCCION_PRODPOLLITOS = "prodPollitos";
    public static final String PRODUCCION_VENDEPOLLITOS = "vendePollitos";
    public static final String PRODUCCION_CONSUPOLLITOS = "consuPollitos";
    public static final String PRODUCCION_CANTPATOS = "cantPatos";
    public static final String PRODUCCION_PRODPATOS = "prodPatos";
    public static final String PRODUCCION_VENDEPATOS = "vendePatos";
    public static final String PRODUCCION_CONSUPATOS = "consuPatos";
    public static final String PRODUCCION_CANTPATAS = "cantPatas";
    public static final String PRODUCCION_PRODPATAS = "prodPatas";
    public static final String PRODUCCION_VENDEPATAS = "vendePatas";
    public static final String PRODUCCION_CONSUPATAS = "consuPatas";
    public static final String PRODUCCION_CANTCHUNTAS = "cantChuntas";
    public static final String PRODUCCION_PRODCHUNTAS = "prodChuntas";
    public static final String PRODUCCION_VENDECHUNTAS = "vendeChuntas";
    public static final String PRODUCCION_CONSUCHUNTAS = "consuChuntas";
    public static final String PRODUCCION_CANTCHUNTOS = "cantChuntos";
    public static final String PRODUCCION_PRODCHUNTOS = "prodChuntos";
    public static final String PRODUCCION_VENDECHUNTOS = "vendeChuntos";
    public static final String PRODUCCION_CONSUCHUNTOS = "consuChuntos";
    public static final String PRODUCCION_CANTCHUNTIOS = "cantChuntios";
    public static final String PRODUCCION_PRODCHUNTIOS = "prodChuntios";
    public static final String PRODUCCION_VENDECHUNTIOS = "vendeChuntios";
    public static final String PRODUCCION_CONSUCHUNTIOS = "consuChuntios";
    public static final String PRODUCCION_AVEENCERRADA = "aveEncerrada";
    public static final String PRODUCCION_FECHAREG = "fechaRegProd";

    // información del a base de datos
    static final String DB_NAME = "DBPRODUCCION";
    static final int DB_VERSION = 1;

    // Creación de la Tabla
    private static final String CREATE_TABLE = "create table "
            + TABLE_PRODUCCION + "("
            + PRODUCCION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PRODUCCION_IDETNO + " TEXT NOT NULL, "
            + PRODUCCION_PRODUCCION + " TEXT NOT NULL, "
            + PRODUCCION_CANTGALLINA + " TEXT, "
            + PRODUCCION_PRODGALLINA + " TEXT, "
            + PRODUCCION_VENDEGALLINA + " TEXT, "
            + PRODUCCION_CONSUGALLINA + " TEXT, "
            + PRODUCCION_CANTGALLOS + " TEXT, "
            + PRODUCCION_PRODGALLOS + " TEXT, "
            + PRODUCCION_VENDEGALLOS + " TEXT, "
            + PRODUCCION_CONSUGALLOS + " TEXT, "
            + PRODUCCION_CANTPOLLITOS + " TEXT, "
            + PRODUCCION_PRODPOLLITOS + " TEXT, "
            + PRODUCCION_VENDEPOLLITOS + " TEXT, "
            + PRODUCCION_CONSUPOLLITOS + " TEXT, "
            + PRODUCCION_CANTPATOS + " TEXT, "
            + PRODUCCION_PRODPATOS + " TEXT, "
            + PRODUCCION_VENDEPATOS + " TEXT, "
            + PRODUCCION_CONSUPATOS + " TEXT, "
            + PRODUCCION_CANTPATAS + " TEXT, "
            + PRODUCCION_PRODPATAS + " TEXT, "
            + PRODUCCION_VENDEPATAS + " TEXT, "
            + PRODUCCION_CONSUPATAS + " TEXT, "
            + PRODUCCION_CANTCHUNTAS + " TEXT, "
            + PRODUCCION_PRODCHUNTAS + " TEXT, "
            + PRODUCCION_VENDECHUNTAS + " TEXT, "
            + PRODUCCION_CONSUCHUNTAS + " TEXT, "
            + PRODUCCION_CANTCHUNTOS + " TEXT, "
            + PRODUCCION_PRODCHUNTOS + " TEXT, "
            + PRODUCCION_VENDECHUNTOS + " TEXT, "
            + PRODUCCION_CONSUCHUNTOS + " TEXT, "
            + PRODUCCION_CANTCHUNTIOS + " TEXT, "
            + PRODUCCION_PRODCHUNTIOS + " TEXT, "
            + PRODUCCION_VENDECHUNTIOS + " TEXT, "
            + PRODUCCION_CONSUCHUNTIOS + " TEXT, "
            + PRODUCCION_AVEENCERRADA + " TEXT, "
            + PRODUCCION_FECHAREG + " TEXT NOT NULL); ";

    public DBhelperEtnoProduccion(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCCION);
        onCreate(db);
    }
}
