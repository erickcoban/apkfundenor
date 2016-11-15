package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorComunidad {

    private DBhelperComunidad dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorComunidad(Context c) {
        ourcontext = c;
    }

    public SQLControladorComunidad abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperComunidad(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String nombre, String categoria, String municipio, String estado) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperComunidad.COMUNIDAD_NOMBRE, nombre);
        cv.put(DBhelperComunidad.COMUNIDAD_CATEGORIA, categoria);
        cv.put(DBhelperComunidad.COMUNIDAD_MUNICIPIO, municipio);
        cv.put(DBhelperComunidad.COMUNIDAD_ESTADO, estado);
        database.insert(DBhelperComunidad.TABLE_COMUNIDADES, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperComunidad.COMUNIDAD_ID,
                DBhelperComunidad.COMUNIDAD_NOMBRE,
                DBhelperComunidad.COMUNIDAD_CATEGORIA,
                DBhelperComunidad.COMUNIDAD_MUNICIPIO,
                DBhelperComunidad.COMUNIDAD_ESTADO
        };
        Cursor c = database.query(DBhelperComunidad.TABLE_COMUNIDADES, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long viviendaID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperComunidad.COMUNIDAD_NOMBRE, memberName);
        int i = database.update(DBhelperComunidad.TABLE_COMUNIDADES, cvActualizar,
                DBhelperComunidad.COMUNIDAD_ID + " = " + viviendaID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperComunidad.TABLE_COMUNIDADES, DBhelperComunidad.COMUNIDAD_ID + "="
                + memberID, null);
    }
}