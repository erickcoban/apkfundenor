package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorFamilia {

    private DBhelperFamilia dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorFamilia(Context c) {
        ourcontext = c;
    }

    public SQLControladorFamilia abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperFamilia(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String name, String idV) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperFamilia.FAMILIA_NOMBRE, name);
        cv.put(DBhelperFamilia.FAMILIA_VIVIENDA, idV);
        database.insert(DBhelperFamilia.TABLE_FAMILIA, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperFamilia.FAMILIA_ID,
                DBhelperFamilia.FAMILIA_NOMBRE,
                DBhelperFamilia.FAMILIA_VIVIENDA
        };
        Cursor c = database.query(DBhelperFamilia.TABLE_FAMILIA, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long memberID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperFamilia.FAMILIA_NOMBRE, memberName);
        int i = database.update(DBhelperFamilia.TABLE_FAMILIA, cvActualizar,
                DBhelperFamilia.FAMILIA_ID + " = " + memberID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperFamilia.TABLE_FAMILIA, DBhelperFamilia.FAMILIA_ID + "="
                + memberID, null);
    }
}