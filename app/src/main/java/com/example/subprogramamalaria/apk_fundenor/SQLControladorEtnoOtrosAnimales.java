package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorEtnoOtrosAnimales {

    private DBhelperEtnoOtrosAnimales dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorEtnoOtrosAnimales(Context c) {
        ourcontext = c;
    }

    public SQLControladorEtnoOtrosAnimales abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperEtnoOtrosAnimales(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String idEtno, String nombre, String noVacas, String noCerdos,
                              String noCabras, String noConejos, String noPalomas,String habitat,
                              String fechaReg) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperEtnoOtrosAnimales.ANIMALES_ETNO, idEtno);
        cv.put(DBhelperEtnoOtrosAnimales.ANIMALES_NOMBRE, nombre);
        cv.put(DBhelperEtnoOtrosAnimales.ANIMALES_NOVACAS, noVacas);
        cv.put(DBhelperEtnoOtrosAnimales.ANIMALES_NOCERDOS, noCerdos);
        cv.put(DBhelperEtnoOtrosAnimales.ANIMALES_NOCABRAS, noCabras);
        cv.put(DBhelperEtnoOtrosAnimales.ANIMALES_NOCONEJOS, noConejos);
        cv.put(DBhelperEtnoOtrosAnimales.ANIMALES_NOPALOMAS, noPalomas);
        cv.put(DBhelperEtnoOtrosAnimales.ANIMALES_HABITAT, habitat);
        cv.put(DBhelperEtnoOtrosAnimales.ANIMALES_FECHA, fechaReg);
        database.insert(DBhelperEtnoOtrosAnimales.TABLE_ANIMALES, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperEtnoOtrosAnimales.ANIMALES_ID,
                DBhelperEtnoOtrosAnimales.ANIMALES_ETNO,
                DBhelperEtnoOtrosAnimales.ANIMALES_NOMBRE,
                DBhelperEtnoOtrosAnimales.ANIMALES_NOVACAS,
                DBhelperEtnoOtrosAnimales.ANIMALES_NOCERDOS,
                DBhelperEtnoOtrosAnimales.ANIMALES_NOCABRAS,
                DBhelperEtnoOtrosAnimales.ANIMALES_NOCONEJOS,
                DBhelperEtnoOtrosAnimales.ANIMALES_NOPALOMAS,
                DBhelperEtnoOtrosAnimales.ANIMALES_HABITAT,
                DBhelperEtnoOtrosAnimales.ANIMALES_FECHA
        };
        Cursor c = database.query(DBhelperEtnoOtrosAnimales.TABLE_ANIMALES, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long idEtno, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperEtnoOtrosAnimales.ANIMALES_NOMBRE, memberName);
        int i = database.update(DBhelperEtnoOtrosAnimales.TABLE_ANIMALES, cvActualizar,
                DBhelperEtnoOtrosAnimales.ANIMALES_ID + " = " + idEtno, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperEtnoOtrosAnimales.TABLE_ANIMALES, DBhelperEtnoOtrosAnimales.ANIMALES_ID + "="
                + memberID, null);
    }
}