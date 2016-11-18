package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorAmbientemMobiliario {

    private DBhelperAmbienteMobiliario dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorAmbientemMobiliario(Context c) {
        ourcontext = c;
    }

    public SQLControladorAmbientemMobiliario abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperAmbienteMobiliario(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String idAmbiente, String ambiente, String tipoRopero, String noRopero, String tieneCamas, String noCamas,
                              String tipoCamas, String tienePlatera, String noPlatera, String tieneMesa, String noMesa, String tieneSilla,
                              String noSilla, String tieneEstufa, String tipoEstufa, String ubicaTrebe, String fechaRegMob) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_IDAMBIENTE, idAmbiente);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_AMBIENTE, ambiente);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_TIENEROPERO, tipoRopero);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_NOROPERO, noRopero);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_TIENECAMAS, tieneCamas);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_NOCAMAS, noCamas);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_TIPOCAMAS, tipoCamas);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_TIENEPLATERA, tienePlatera);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_NOPLATERA, noPlatera);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_TIENEMESA, tieneMesa);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_NOMESA, noMesa);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_TIENESILLA, tieneSilla);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_NOSILLA, noSilla);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_TIENEESTUFA, tieneEstufa);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_TIPOESTUFA, tipoEstufa);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_UBICATREBE, ubicaTrebe);
        cv.put(DBhelperAmbienteMobiliario.MOBILIARIO_FECHA, fechaRegMob);
        database.insert(DBhelperAmbienteMobiliario.TABLE_MOBILIARIO, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperAmbienteMobiliario.MOBILIARIO_ID,
                DBhelperAmbienteMobiliario.MOBILIARIO_IDAMBIENTE,
                DBhelperAmbienteMobiliario.MOBILIARIO_AMBIENTE,
                DBhelperAmbienteMobiliario.MOBILIARIO_TIENEROPERO,
                DBhelperAmbienteMobiliario.MOBILIARIO_NOROPERO,
                DBhelperAmbienteMobiliario.MOBILIARIO_TIENECAMAS,
                DBhelperAmbienteMobiliario.MOBILIARIO_NOCAMAS,
                DBhelperAmbienteMobiliario.MOBILIARIO_TIPOCAMAS,
                DBhelperAmbienteMobiliario.MOBILIARIO_TIENEPLATERA,
                DBhelperAmbienteMobiliario.MOBILIARIO_NOPLATERA,
                DBhelperAmbienteMobiliario.MOBILIARIO_TIENEMESA,
                DBhelperAmbienteMobiliario.MOBILIARIO_NOMESA,
                DBhelperAmbienteMobiliario.MOBILIARIO_TIENESILLA,
                DBhelperAmbienteMobiliario.MOBILIARIO_NOSILLA,
                DBhelperAmbienteMobiliario.MOBILIARIO_TIENEESTUFA,
                DBhelperAmbienteMobiliario.MOBILIARIO_TIPOESTUFA,
                DBhelperAmbienteMobiliario.MOBILIARIO_UBICATREBE,
                DBhelperAmbienteMobiliario.MOBILIARIO_FECHA

        };
        Cursor c = database.query(DBhelperAmbienteMobiliario.TABLE_MOBILIARIO, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long viviendaID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperAmbienteMobiliario.MOBILIARIO_AMBIENTE, memberName);
        int i = database.update(DBhelperAmbienteMobiliario.TABLE_MOBILIARIO, cvActualizar,
                DBhelperAmbienteMobiliario.MOBILIARIO_ID + " = " + viviendaID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperAmbienteMobiliario.TABLE_MOBILIARIO, DBhelperAmbienteMobiliario.MOBILIARIO_ID + "="
                + memberID, null);
    }
}