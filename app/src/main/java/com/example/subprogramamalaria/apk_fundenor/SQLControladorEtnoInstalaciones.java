package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorEtnoInstalaciones {

    private DBhelperEtnoInstalaciones dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorEtnoInstalaciones(Context c) {
        ourcontext = c;
    }

    public SQLControladorEtnoInstalaciones abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperEtnoInstalaciones(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String idEtno, String gallinero, String medidaGallinero, String corral, String medidaCorral, String comedero,
                              String bebedero, String nidales, String moduloPecuario, String moduloLimpio, String fechaReg) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperEtnoInstalaciones.INSTALACION_ETNO, idEtno);
        cv.put(DBhelperEtnoInstalaciones.INSTALACION_GALLINERO, gallinero);
        cv.put(DBhelperEtnoInstalaciones.INSTALACION_MEDIDAG, medidaGallinero);
        cv.put(DBhelperEtnoInstalaciones.INSTALACION_CORRAL, corral);
        cv.put(DBhelperEtnoInstalaciones.INSTALACION_MEDIDAC, medidaCorral);
        cv.put(DBhelperEtnoInstalaciones.INSTALACION_COMEDERO, comedero);
        cv.put(DBhelperEtnoInstalaciones.INSTALACION_BEBEDERO, bebedero);
        cv.put(DBhelperEtnoInstalaciones.INSTALACION_NIDALES, nidales);
        cv.put(DBhelperEtnoInstalaciones.INSTALACION_MODULOPE, moduloPecuario);
        cv.put(DBhelperEtnoInstalaciones.INSTALACION_MODULOLI, moduloLimpio);
        cv.put(DBhelperEtnoInstalaciones.INSTALACION_FECHA, fechaReg);
        database.insert(DBhelperEtnoInstalaciones.TABLE_INSTALACION, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperEtnoInstalaciones.INSTALACION_ID,
                DBhelperEtnoInstalaciones.INSTALACION_ETNO,
                DBhelperEtnoInstalaciones.INSTALACION_GALLINERO,
                DBhelperEtnoInstalaciones.INSTALACION_MEDIDAG,
                DBhelperEtnoInstalaciones.INSTALACION_CORRAL,
                DBhelperEtnoInstalaciones.INSTALACION_MEDIDAC,
                DBhelperEtnoInstalaciones.INSTALACION_COMEDERO,
                DBhelperEtnoInstalaciones.INSTALACION_BEBEDERO,
                DBhelperEtnoInstalaciones.INSTALACION_NIDALES,
                DBhelperEtnoInstalaciones.INSTALACION_MODULOPE,
                DBhelperEtnoInstalaciones.INSTALACION_MODULOLI,
                DBhelperEtnoInstalaciones.INSTALACION_FECHA
        };
        Cursor c = database.query(DBhelperEtnoInstalaciones.TABLE_INSTALACION, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long idEtno, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperEtnoInstalaciones.INSTALACION_ETNO, memberName);
        int i = database.update(DBhelperEtnoInstalaciones.TABLE_INSTALACION, cvActualizar,
                DBhelperEtnoInstalaciones.INSTALACION_ID + " = " + idEtno, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperEtnoInstalaciones.TABLE_INSTALACION, DBhelperEtnoInstalaciones.INSTALACION_ID + "="
                + memberID, null);
    }
}