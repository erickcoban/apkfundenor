package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorSubparticipante {

    private DBhelperSubparticipante dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorSubparticipante(Context c) {
        ourcontext = c;
    }

    public SQLControladorSubparticipante abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperSubparticipante(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String name) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperSubparticipante.MIEMBRO_NOMBRE, name);
        database.insert(DBhelperSubparticipante.TABLE_MEMBER, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperSubparticipante.MIEMBRO_ID,
                DBhelperSubparticipante.MIEMBRO_NOMBRE
        };
        Cursor c = database.query(DBhelperSubparticipante.TABLE_MEMBER, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long memberID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperSubparticipante.MIEMBRO_NOMBRE, memberName);
        int i = database.update(DBhelperSubparticipante.TABLE_MEMBER, cvActualizar,
                DBhelperSubparticipante.MIEMBRO_ID + " = " + memberID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperSubparticipante.TABLE_MEMBER, DBhelperSubparticipante.MIEMBRO_ID + "="
                + memberID, null);
    }
}