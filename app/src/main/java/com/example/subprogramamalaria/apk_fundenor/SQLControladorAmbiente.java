package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorAmbiente {

    private DBhelperAmbiente dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorAmbiente(Context c) {
        ourcontext = c;
    }

    public SQLControladorAmbiente abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperAmbiente(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String numVivienda, String tipoAmb, String tipoDiv, String paredAmb, String techoAmb,
                              String pisoAmb, String manttoAmb, String limpiezaAmb, String fechaRegAmb) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperAmbiente.AMBIENTE_NOMBRE, numVivienda);
        cv.put(DBhelperAmbiente.AMBIENTE_AMBIENTE, tipoAmb);
        cv.put(DBhelperAmbiente.AMBIENTE_DIVISION, tipoDiv);
        cv.put(DBhelperAmbiente.AMBIENTE_PARED, paredAmb);
        cv.put(DBhelperAmbiente.AMBIENTE_TECHO, techoAmb);
        cv.put(DBhelperAmbiente.AMBIENTE_PISO, pisoAmb);
        cv.put(DBhelperAmbiente.AMBIENTE_MANTTO, manttoAmb);
        cv.put(DBhelperAmbiente.AMBIENTE_LIMPIEZA, limpiezaAmb);
        cv.put(DBhelperAmbiente.AMBIENTE_FECHA, fechaRegAmb);
        database.insert(DBhelperAmbiente.TABLE_AMBIENTE, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperAmbiente.AMBIENTE_ID,
                DBhelperAmbiente.AMBIENTE_NOMBRE,
                DBhelperAmbiente.AMBIENTE_AMBIENTE,
                DBhelperAmbiente.AMBIENTE_DIVISION,
                DBhelperAmbiente.AMBIENTE_PARED,
                DBhelperAmbiente.AMBIENTE_TECHO,
                DBhelperAmbiente.AMBIENTE_PISO,
                DBhelperAmbiente.AMBIENTE_MANTTO,
                DBhelperAmbiente.AMBIENTE_LIMPIEZA,
                DBhelperAmbiente.AMBIENTE_FECHA
        };
        Cursor c = database.query(DBhelperAmbiente.TABLE_AMBIENTE, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long viviendaID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperAmbiente.AMBIENTE_NOMBRE, memberName);
        int i = database.update(DBhelperAmbiente.TABLE_AMBIENTE, cvActualizar,
                DBhelperAmbiente.AMBIENTE_ID + " = " + viviendaID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperAmbiente.TABLE_AMBIENTE, DBhelperAmbiente.AMBIENTE_ID + "="
                + memberID, null);
    }
}