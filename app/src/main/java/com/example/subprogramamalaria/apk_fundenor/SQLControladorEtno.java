package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorEtno {

    private DBhelperEtno dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorEtno(Context c) {
        ourcontext = c;
    }

    public SQLControladorEtno abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperEtno(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String idFam, String nombre) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperEtno.ETNO_FAMILIA, idFam);
        cv.put(DBhelperEtno.ETNO_NOMBRE, nombre);
        database.insert(DBhelperEtno.TABLE_ETNO, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperEtno.ETNO_ID,
                DBhelperEtno.ETNO_FAMILIA,
                DBhelperEtno.ETNO_NOMBRE
        };
        Cursor c = database.query(DBhelperEtno.TABLE_ETNO, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long idEtno, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperEtno.ETNO_NOMBRE, memberName);
        int i = database.update(DBhelperEtno.TABLE_ETNO, cvActualizar,
                DBhelperEtno.ETNO_ID + " = " + idEtno, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperEtno.TABLE_ETNO, DBhelperEtno.ETNO_ID + "="
                + memberID, null);
    }
}