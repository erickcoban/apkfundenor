package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControlador {

    private DBhelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControlador(Context c) {
        ourcontext = c;
    }

    public SQLControlador abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String numVivienda, String idLocalidad, String user, String paredVivienda, String techoVivienda,
                              String tieneDivision, String tipoAgua, String tipoAlmacen, String otroAlmancen, String tipoPurificacion,
                              String estadoAsig, String fecha ) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.VIVIENDA_NOMBRE, numVivienda);
        cv.put(DBhelper.VIVIENDA_LOCALIDAD, idLocalidad);
        cv.put(DBhelper.VIVIENDA_USER, user);
        cv.put(DBhelper.VIVIENDA_PARED, paredVivienda);
        cv.put(DBhelper.VIVIENDA_TECHO, techoVivienda);
        cv.put(DBhelper.VIVIENDA_DIVISION, tieneDivision);
        cv.put(DBhelper.VIVIENDA_TIPOAGUA, tipoAgua);
        cv.put(DBhelper.VIVIENDA_TIPOALMACENAGUA, tipoAlmacen);
        cv.put(DBhelper.VIVIENDA_OTROALMACEN, otroAlmancen);
        cv.put(DBhelper.VIVIENDA_PURIFICACION, tipoPurificacion);
        cv.put(DBhelper.VIVIENDA_ESTADO, estadoAsig);
        cv.put(DBhelper.VIVIENDA_FECHA, fecha);
        database.insert(DBhelper.TABLE_VIVIENDA, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelper.VIVIENDA_ID,
                DBhelper.VIVIENDA_NOMBRE,
                DBhelper.VIVIENDA_LOCALIDAD,
                DBhelper.VIVIENDA_USER,
                DBhelper.VIVIENDA_PARED,
                DBhelper.VIVIENDA_TECHO,
                DBhelper.VIVIENDA_DIVISION,
                DBhelper.VIVIENDA_TIPOAGUA,
                DBhelper.VIVIENDA_TIPOALMACENAGUA,
                DBhelper.VIVIENDA_OTROALMACEN,
                DBhelper.VIVIENDA_PURIFICACION,
                DBhelper.VIVIENDA_ESTADO,
                DBhelper.VIVIENDA_FECHA
        };
        Cursor c = database.query(DBhelper.TABLE_VIVIENDA, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long viviendaID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelper.VIVIENDA_NOMBRE, memberName);
        int i = database.update(DBhelper.TABLE_VIVIENDA, cvActualizar,
                DBhelper.VIVIENDA_ID + " = " + viviendaID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelper.TABLE_VIVIENDA, DBhelper.VIVIENDA_ID + "="
                + memberID, null);
    }
}