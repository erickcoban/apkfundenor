package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorUsuarios {

    private DBhelperAmbiente dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorUsuarios(Context c) {
        ourcontext = c;
    }

    public SQLControladorUsuarios abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperAmbiente(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String user, String pass) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperUsuarios.USUARIO_ID, user);
        cv.put(DBhelperUsuarios.USUARIO_NOMBRE, pass);
        database.insert(DBhelperUsuarios.TABLE_USUARIO, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperUsuarios.USUARIO_ID,
                DBhelperUsuarios.USUARIO_NOMBRE
        };
        Cursor c = database.query(DBhelperUsuarios.TABLE_USUARIO, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long viviendaID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperUsuarios.USUARIO_NOMBRE, memberName);
        int i = database.update(DBhelperUsuarios.TABLE_USUARIO, cvActualizar,
                DBhelperUsuarios.USUARIO_ID + " = " + viviendaID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperUsuarios.TABLE_USUARIO, DBhelperUsuarios.USUARIO_ID + "="
                + memberID, null);
    }
}