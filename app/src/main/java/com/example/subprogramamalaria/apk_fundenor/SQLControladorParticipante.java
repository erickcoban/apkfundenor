package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorParticipante {

    private DBhelperParticipante dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorParticipante(Context c) {
        ourcontext = c;
    }

    public SQLControladorParticipante abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperParticipante(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String name) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperParticipante.MIEMBRO_NOMBRE, name);
        database.insert(DBhelperParticipante.TABLE_MEMBER, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperParticipante.MIEMBRO_ID,
                DBhelperParticipante.MIEMBRO_NOMBRE
        };
        Cursor c = database.query(DBhelperParticipante.TABLE_MEMBER, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long memberID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperParticipante.MIEMBRO_NOMBRE, memberName);
        int i = database.update(DBhelperParticipante.TABLE_MEMBER, cvActualizar,
                DBhelperParticipante.MIEMBRO_ID + " = " + memberID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperParticipante.TABLE_MEMBER, DBhelperParticipante.MIEMBRO_ID + "="
                + memberID, null);
    }
}