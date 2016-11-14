package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorDiversificacion {

    private DBhelperHuertos dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorDiversificacion(Context c) {
        ourcontext = c;
    }

    public SQLControladorDiversificacion abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperHuertos(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String nombre, String consume, String vende, String cantidad, String idHuerto,
                              String fechaReg) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperHuertosDiversificacion.DIVERSIFICACION_NOMBRE, nombre);
        cv.put(DBhelperHuertosDiversificacion.DIVERSIFICACION_CONSUME, consume);
        cv.put(DBhelperHuertosDiversificacion.DIVERSIFICACION_VENDE, vende);
        cv.put(DBhelperHuertosDiversificacion.DIVERSIFICACION_CANTIDAD, cantidad);
        cv.put(DBhelperHuertosDiversificacion.DIVERSIFICACION_IDHUERTO, idHuerto);
        cv.put(DBhelperHuertosDiversificacion.DIVERSIFICACION_FECHAREG, fechaReg);
        database.insert(DBhelperSubparticipante.TABLE_SUBPARTICIPANTE, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperHuertosDiversificacion.DIVERSIFICACION_ID,
                DBhelperHuertosDiversificacion.DIVERSIFICACION_NOMBRE,
                DBhelperHuertosDiversificacion.DIVERSIFICACION_CONSUME,
                DBhelperHuertosDiversificacion.DIVERSIFICACION_VENDE,
                DBhelperHuertosDiversificacion.DIVERSIFICACION_CANTIDAD,
                DBhelperHuertosDiversificacion.DIVERSIFICACION_IDHUERTO,
                DBhelperHuertosDiversificacion.DIVERSIFICACION_FECHAREG
        };
        Cursor c = database.query(DBhelperHuertos.TABLE_HUERTOS, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long memberID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperHuertosDiversificacion.DIVERSIFICACION_NOMBRE, memberName);
        int i = database.update(DBhelperHuertosDiversificacion.TABLE_DIVERSIFICACION, cvActualizar,
                DBhelperHuertosDiversificacion.DIVERSIFICACION_ID + " = " + memberID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperHuertosDiversificacion.TABLE_DIVERSIFICACION, DBhelperHuertosDiversificacion.DIVERSIFICACION_ID + "="
                + memberID, null);
    }
}