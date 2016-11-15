package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorEtnoHuevos {

    private DBhelperEtnoHuevos dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorEtnoHuevos(Context c) {
        ourcontext = c;
    }

    public SQLControladorEtnoHuevos abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperEtnoHuevos(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String idEtno, String cantidadSemanal, String consumoSemanal, String reproduccion,
                              String venta, String fechaReg) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperEtnoHuevos.HUEVOS_ETNO, idEtno);
        cv.put(DBhelperEtnoHuevos.HUEVOS_CANTIDADSEMANAL, cantidadSemanal);
        cv.put(DBhelperEtnoHuevos.HUEVOS_CONSUMOSEMANAL, consumoSemanal);
        cv.put(DBhelperEtnoHuevos.HUEVOS_REPRODUCCION, reproduccion);
        cv.put(DBhelperEtnoHuevos.HUEVOS_VENTA, venta);
        cv.put(DBhelperEtnoHuevos.HUEVOS_FECHA, fechaReg);
        database.insert(DBhelperEtnoHuevos.TABLE_HUEVOS, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperEtnoHuevos.HUEVOS_ID,
                DBhelperEtnoHuevos.HUEVOS_ETNO,
                DBhelperEtnoHuevos.HUEVOS_CANTIDADSEMANAL,
                DBhelperEtnoHuevos.HUEVOS_CONSUMOSEMANAL,
                DBhelperEtnoHuevos.HUEVOS_REPRODUCCION,
                DBhelperEtnoHuevos.HUEVOS_VENTA,
                DBhelperEtnoHuevos.HUEVOS_FECHA
        };
        Cursor c = database.query(DBhelperEtnoHuevos.TABLE_HUEVOS, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long idEtno, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperEtnoHuevos.HUEVOS_ETNO, memberName);
        int i = database.update(DBhelperEtnoHuevos.TABLE_HUEVOS, cvActualizar,
                DBhelperEtnoHuevos.HUEVOS_ID + " = " + idEtno, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperEtnoHuevos.TABLE_HUEVOS, DBhelperEtnoHuevos.HUEVOS_ID + "="
                + memberID, null);
    }
}